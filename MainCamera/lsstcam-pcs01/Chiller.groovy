import org.lsst.ccs.description.groovy.CCSBuilder
import org.lsst.ccs.bootstrap.BootstrapResourceUtils
import org.lsst.ccs.subsystem.common.HeatTransferChannel
import org.lsst.ccs.subsystem.common.devices.dataforth.Maq20DiscControl;
import org.lsst.ccs.subsystem.common.devices.dataforth.Maq20PulseControl
import org.lsst.ccs.subsystem.refrig.ChillerAlertListener
import org.lsst.ccs.subsystem.refrig.ChillerBlockingListener
import org.lsst.ccs.subsystem.refrig.ChillerMaq20Device
import org.lsst.ccs.subsystem.refrig.ChillerPlutoDevice
import org.lsst.ccs.subsystem.refrig.SimChillerPlutoDevice
import org.lsst.ccs.subsystem.refrig.ChillerSubsystem
import org.lsst.ccs.subsystem.refrig.CompMaq20PWMControl
import org.lsst.ccs.subsystem.refrig.FanControl
import org.lsst.ccs.subsystem.refrig.InTESTChillerDevice
import org.lsst.ccs.subsystem.refrig.constants.ChillerAlerts
import org.lsst.ccs.monitor.Alarm
import org.lsst.ccs.monitor.CalcChannel
import org.lsst.ccs.monitor.Channel

Properties props = BootstrapResourceUtils.getBootstrapSystemProperties()
runMode = props.getProperty("org.lsst.ccs.run.mode", "normal")
plutoDevice = runMode.equals("simulation") ? SimChillerPlutoDevice : ChillerPlutoDevice
// Note that simulation is not implemented for InTESTChillerDevice.

pOffset150 = -37.5        // Pressure convesions
pScale150 = 9375.0
pOffset300 = -75.0
pScale300 = 18750.0
pOffset500 = -125.0
pScale500 = 31250.0
fOffset26 = -6.50         // Flow (gpm) conversions
fScale26 = 1625.0
fOffset10 = -2.5
fScale10 = 625.0

CCSBuilder builder = ["chiller"]

builder.main (ChillerSubsystem) {

    AlarmDUT (Alarm, alert:ChillerAlerts.DUT_INVALID.newAlert())

    chillerAlertListener (ChillerAlertListener)
    chillerBlockingListener (ChillerBlockingListener)

    Pluto (plutoDevice)

    Chiller(InTESTChillerDevice) {

        FluidTemperature (Channel, description:"temperature of chiller output",
                          devcName:"Chiller", checkLo:"none", checkHi:"none",
                          type:"Temp", subtype:"TEMPERATURE", units:"\u00b0C",
                          format:"%.2f")

        ImportedColdTemp (Channel, description:"coldplate temp from listener",
                          devcName:"Chiller", checkLo:"none", checkHi:"none",
                          type:"ColdPlate", subtype:"Average", units:"\u00b0C",
                          format:"%.2f")

        TempDUTInput     (Channel, description:"last DUT input temperature",
                          devcName:"Chiller", checkLo:"none", checkHi:"alarm",
                          type:"Temp", subtype:"T_PROBE2", units:"\u00b0C",
                          format:"%.2f", alarmHi:"AlarmDUT")

        TempCondenser    (Channel, description:"temperature condenser outlet",
                          devcName:"Chiller", checkLo:"none", checkHi:"none",
                          type:"Temp", subtype:"T_CONDENSER", units:"\u00b0C",
                          format:"%.2f")

        TempTXVBulb      (Channel, description:"temperature chiller TXV bulb",
                          devcName:"Chiller", checkLo:"none", checkHi:"none",
                          type:"Temp", subtype:"T_TXV_BULB", units:"\u00b0C",
                          format:"%.2f")

        TempStage2Evap   (Channel, description:"temperature chiller Stage2Evap",
                          devcName:"Chiller", checkLo:"none", checkHi:"none",
                          type:"Temp", subtype:"T_STAGE2EVAP", units:"\u00b0C",
                          format:"%.2f")

        TempSetPoint     (Channel, description:"temperature setpoint",
                          devcName:"Chiller", checkLo:"none", checkHi:"none",
                          type:"Temp", subtype:"SET_POINT", units:"\u00b0C",
                          format:"%.2f")

        TempDynamicSetPt (Channel, description:"dynamic temperature setpoint",
                          devcName:"Chiller", checkLo:"none", checkHi:"none",
                          type:"Temp", subtype:"DYNAMIC_SET", units:"\u00b0C",
                          format:"%.2f")

        CascadeSetPoint  (Channel, description:"cascade setpoint used in DUT",
                          devcName:"Chiller", checkLo:"none", checkHi:"none",
                          type:"Temp", subtype:"CASCADE_SETPT", units:"\u00b0C",
                          format:"%.2f")

        HeatPercentage   (Channel, description:"heating as percentage of max",
                          devcName:"Chiller", checkLo:"none", checkHi:"none",
                          type:"HC", subtype:"Heat", units:"%",
                          format:"%.1f")

        CoolPercentage   (Channel, description:"cooling as percentage of max",
                          devcName:"Chiller", checkLo:"none", checkHi:"none",
                          type:"HC", subtype:"Cool", units:"%",
                          format:"%.1f")

        FlowRate         (Channel, description:"chiller flow rate",
                          devcName:"Chiller", checkLo:"none", checkHi:"none",
                          type:"Flow", subtype:"FLOW_RATE", 
                          units:"gallon/min", format:"%.2f")

        FlowSetPoint     (Channel, description:"chiller flow setpoint",
                         devcName:"Chiller", checkLo:"none", checkHi:"none",
                          type:"Flow", subtype:"FLOW_SETPT",
                          units:"gallon/min", format:"%.1f")

        PressureIn       (Channel, description:"chiller input pressure",
                          devcName:"Chiller", checkLo:"none", checkHi:"none",
                          type:"Pres", subtype:"PRESSURE_IN", units:"psig",
                          format:"%.1f")
 
        PressureOut      (Channel, description:"chiller output pressure",
                          devcName:"Chiller", checkLo:"none", checkHi:"none",
                          type:"Pres", subtype:"PRESSURE_OUT", units:"psig",
                          format:"%.1f")
 
        PressureTank     (Channel, description:"chiller tank pressure",
                          devcName:"Chiller", checkLo:"none", checkHi:"none",
                          type:"Pres", subtype:"PRESSURE_TANK", units:"psig",
                          format:"%.1f")
 
        TankSetPoint     (Channel, description:"tank pressure setpoint",
                          devcName:"Chiller", checkLo:"none", checkHi:"none",
                          type:"Pres", subtype:"TANK_P_SET", units:"psig",
                          format:"%.0f")

        TankLevel        (Channel, description:"tank fluid level in percent",
                          devcName:"Chiller", checkLo:"none", checkHi:"none",
                          type:"Fill", subtype:"TANK_PERCENT", units:"%",
                          format:"%.0f")

        ControllerLife   (Channel, description:"chiller controller hours",
                          devcName:"Chiller", checkLo:"none", checkHi:"none",
                          type:"Life", subtype:"CONTROL", units:"h",
                          format:"%.0f")

        CompressorLife   (Channel, description:"chiller compressorOne hours",
                          devcName:"Chiller", checkLo:"none", checkHi:"none",
                          type:"Life", subtype:"COMPRESS", units:"h",
                          format:"%.0f")

        ChillerPumpLife  (Channel, description:"chiller pump hours",
                          devcName:"Chiller", checkLo:"none", checkHi:"none",
                          type:"Life", subtype:"PUMP", units:"h",
                          format:"%.0f")

        ChillerValveAct  (Channel, description:"current valve activations",
                          devcName:"Chiller", checkLo:"none", checkHi:"none",
                          type:"Life", subtype:"CURR_VALVE", units:"unitless",
                          format:"%.0f")

        ChillerStatus    (Channel, description:"Chiller status register",
                          devcName:"Chiller", checkLo:"none", checkHi:"none",
                          type:"Register", subtype:"Status", units:"unitless", 
                          format:"%.0a", doNotTrend:true)

        ColdInletTemp  (Channel, description: "Temperature at coldplate inlet",
                        devcName:"Chiller", checkLo:"none", checkHi:"none",
                        type:"ColdPlate", subtype:"Inlet", units:"\u00b0C",
                        format:"%.2f", doNotPublish:true)

        ColdOutletTemp (Channel, description: "Temperature at coldplate outlet",
                        devcName:"Chiller", checkLo:"none", checkHi:"none",
                        type:"ColdPlate", subtype:"Outlet", units:"\u00b0C",
                        format:"%.2f", doNotPublish:true)

    }

    FanCtrl (FanControl, fanCntrl: ["Maq20/ChillerFans"],
             ambientTemp: "Maq20/AmbientTemp", cabinetTemp: "Maq20/CabinetTemp")

    // Maq20 module order: DIN-11, DIN-12, DIN-13, DIN-10, DIN-15, DIN-16.
    // see schematic LCA-19782-A
    Maq20 (ChillerMaq20Device, modules: ["TTC", "TTC", "TTC", "IS", "DIOL:pulse:pwm", 
                                         "DIOL:pulse:pulse"]) {

        ChillerFans    (CompMaq20PWMControl, modIndex: 4, funcIndex: 1, 
                        frequency: 200.0)

        ChillerPulse   (Maq20PulseControl, modIndex: 4, funcIndex: 0)

        ChillerPulseF1 (Maq20PulseControl, modIndex: 5, funcIndex: 0,
                        pulsesPerRevn: 6)

        ChillerPulseF2 (Maq20PulseControl, modIndex: 5, funcIndex: 1,
                        pulsesPerRevn: 6)

        ChillerLights (Maq20DiscControl, modIndex: 4)

        Stg1Discharge  (Channel, description: "TC5: Stage1 Discharge Temp", 
                        devcName: "Maq20", units: "\u00b0C", format: ".1f",
                        subtype: "T220", type: "0", hwChan: 4,
                        checkLo:"none", checkHi:"none")
        
        Stg1CondensOut (Channel, description: "TC6: Stage1 Condenser out", 
                        devcName: "Maq20", units: "\u00b0C", format: ".1f",
                        subtype: "T220", type: "0", hwChan: 5,
                        checkLo:"none", checkHi:"none")
        
        Stg1TXVBulb    (Channel, description: "TC7: Stage1 TXV Thermal Bulb", 
                        devcName: "Maq20", units: "\u00b0C", format: ".1f",
                        subtype: "T220", type: "0", hwChan: 6,
                        checkLo:"none", checkHi:"alarm")
        
        Stg1Return     (Channel, description: "TC8: Stage1 Return", 
                        devcName: "Maq20", units: "\u00b0C", format: ".1f",
                        subtype: "T220", type: "0", hwChan: 7,
                        checkLo:"none", checkHi:"none")
        
        Stg2Discharge  (Channel, description: "TC9: Stage2 Discharge Temp", 
                        devcName: "Maq20", units: "\u00b0C", format: ".1f",
                        subtype: "T220", type: "1", hwChan: 0,
                        checkLo:"none", checkHi:"none")
        
        Stg2DeSuHtrOut (Channel, description: "TC10: Stage2 DeSuperHeater out", 
                        devcName: "Maq20", units: "\u00b0C", format: ".1f",
                        subtype: "T220", type: "1", hwChan: 1,
                        checkLo:"none", checkHi:"none")
        
        Stg2EvapIn     (Channel, description: "TC11: Stage2 Evaporator in", 
                        devcName: "Maq20", units: "\u00b0C", format: ".1f",
                        subtype: "T220", type: "1", hwChan: 2,
                        checkLo:"none", checkHi:"none")
        
        Stg2EvapOut    (Channel, description: "TC12: Stage2 Evaporator out", 
                        devcName: "Maq20", units: "\u00b0C", format: ".1f",
                        subtype: "T220", type: "1", hwChan: 3,
                        checkLo:"none", checkHi:"none")
        
        Stg2Return     (Channel, description: "TC13: Stage2 Return", 
                        devcName: "Maq20", units: "\u00b0C", format: ".1f",
                        subtype: "T220", type: "1", hwChan: 4,
                        checkLo:"none", checkHi:"none")

        Stg2DischargeP (Channel, description: "Stage 2 Dicharge Pressure", 
                        devcName: "Maq20", units: "psia", format: ".2f",
                        subtype: "MA4_20", type: "3", hwChan: 0,
                        offset: pOffset500, scale: pScale500,
                        checkLo:"none", checkHi:"none")
        
        CoolantPumpOut (Channel, description: "TC14: Pumped Coolant Pump out", 
                        devcName: "Maq20", units: "\u00b0C", format: ".1f",
                        subtype: "T220", type: "1", hwChan: 5,
                        checkLo:"none", checkHi:"none")
        
        CoolantHXOut   (Channel, description: "TC15: Pumped Coolant HX out", 
                        devcName: "Maq20", units: "\u00b0C", format: ".1f",
                        subtype: "T220", type: "1", hwChan: 6,
                        checkLo:"none", checkHi:"none")
        
        CoolantReturn  (Channel, description: "TC16: Pumped Coolant Return", 
                        devcName: "Maq20", units: "\u00b0C", format: ".1f",
                        subtype: "T220", type: "1", hwChan: 7,
                        checkLo:"none", checkHi:"none")
        
        CoolantSupply  (Channel, description: "TC17: Pumped Coolant Supply", 
                        devcName: "Maq20", units: "\u00b0C", format: ".1f",
                        subtype: "T220", type: "2", hwChan: 0,
                        checkLo:"none", checkHi:"none")
        
        CoolantPumpIn  (Channel, description: "TC18: Pumped Coolant into Pump", 
                        devcName: "Maq20", units: "\u00b0C", format: ".1f",
                        subtype: "T220", type: "2", hwChan: 1,
                        checkLo:"none", checkHi:"none")
        
        CoolantHeatXfer(HeatTransferChannel, units: "Watt", format: ".0f",
                        description: "Total heat transfer rate to coolant",
                        scale: 1000.0, checkLo:"none", checkHi:"none")

        ColdPlHeatXfer (HeatTransferChannel, units: "Watt", format: ".0f",
                        description: "Heat transfer rate from coldplate",
                        scale: 1000.0, checkLo:"none", checkHi:"none")

        GlycSupplyP    (Channel, description: "Glycol Supply Pressure", 
                        devcName: "Maq20", units: "psig", format: ".2f",
                        subtype: "MA4_20", type: "3", hwChan: 3,
                        offset: pOffset300, scale: pScale300,
                        checkLo:"none", checkHi:"none")
        
        GlycChillerIn  (Channel, description: "TC1: Glycol into Chiller", 
                        devcName: "Maq20", units: "\u00b0C", format: ".1f",
                        subtype: "T220", type: "0", hwChan: 0,
                        checkLo:"flag", checkHi:"alarm")
        
        GlycCondensOut (Channel, description: "TC2: Glycol out of Condenser", 
                        devcName: "Maq20", units: "\u00b0C", format: ".1f",
                        subtype: "T220", type: "0", hwChan: 1,
                        checkLo:"none", checkHi:"none")
        
        GlycDeSuHtrOut (Channel,description:"TC3: Glycol out of DeSuperHeater", 
                        devcName: "Maq20", units: "\u00b0C", format: ".1f",
                        subtype: "T220", type: "0", hwChan: 2,
                        checkLo:"none", checkHi:"none")
        
        GlycChillerOut (Channel, description: "TC4: Glycol out of Chiller", 
                        devcName: "Maq20", units: "\u00b0C", format: ".1f",
                        subtype: "T220", type: "0", hwChan: 3,
                        checkLo:"flag", checkHi:"alarm")
        
        GlycFanIn      (Channel, description: "TC20: Glycol into Fan", 
                        devcName: "Maq20", units: "\u00b0C", format: ".1f",
                        subtype: "T220", type: "2", hwChan: 3,
                        checkLo:"none", checkHi:"none")
        
        GlycFanOut     (Channel, description: "TC21: Glycol out of Fan", 
                        devcName: "Maq20", units: "\u00b0C", format: ".1f",
                        subtype: "T220", type: "2", hwChan: 4,
                        checkLo:"none", checkHi:"none")

        GlycFanMinusAmb(CalcChannel, description: "GlycFanIn - AmbientTemp",
	                units: "\u00b0C", type: CalcChannel.Operation.DIFF,
			channelPaths: ["Maq20/GlycFanIn", "Maq20/AmbientTemp"],
                        format: ".1f", checkLo:"none", checkHi:"alarm")

        GlycInputFlow  (Channel, description: "Glycol flow rate into Chiller",
                        devcName: "Maq20", units: "gallon/min", format: ".2f",
                        subtype: "MA4_20", type: "3", hwChan: 4,
                        offset: fOffset26, scale: fScale26,
                        checkLo:"alarm", checkHi:"none")

        GlycHeatXfer   (HeatTransferChannel, units: "Watt", format: ".0f",
                        description: "Heat transfer rate to cooling glycol",
                        scale: 1000.0, checkLo:"none", checkHi:"none")

        GlycDeSuHtrFlow(Channel, description: "Glycol flow at Stg 2 DeSuperHtr",
                        devcName: "Maq20", units: "gallon/min", format: ".2f",
                        subtype: "MA4_20", type: "3", hwChan: 5,
                        offset: fOffset10, scale: fScale10,
                        checkLo:"flag", checkHi:"none")

        AmbientTemp    (Channel, description: "TC19: Ambient", 
                        devcName: "Maq20", units: "\u00b0C", format: ".1f",
                        subtype: "T220", type: "2", hwChan: 2,
                        checkLo:"none", checkHi:"none")

        CabinetTemp    (Channel, description: "TC22: Cabinet ambient", 
                        devcName: "Maq20", units: "\u00b0C", format: ".1f",
                        subtype: "T220", type: "2", hwChan: 5,
                        checkLo:"none", checkHi:"none")
        
        PBurstSupply   (Channel, description: "Burst disc pressure supply line",
                        devcName: "Maq20", units: "psig", format: ".2f",
                        subtype: "MA4_20", type: "3", hwChan: 1,
                        offset: pOffset150, scale: pScale150,
                        checkLo:"none", checkHi:"flag")

        PBurstReturn   (Channel, description: "Burst disc pressure return line",
                        devcName: "Maq20", units: "psig", format: ".2f",
                        subtype: "MA4_20", type: "3", hwChan: 2,
                        offset: pOffset150, scale: pScale150,
                        checkLo:"none", checkHi:"flag")

        Fan1Speed      (Channel, description: "Fan 1 speed", units: "rpm",
                        devcName: "Maq20", format: ".0f", type: "5", 
                        hwChan: ChillerMaq20Device.CHAN_PULSE_RPM, subtype: "0",
                        checkLo:"none", checkHi:"none")

        Fan2Speed      (Channel, description: "Fan 2 speed", units: "rpm",
                        devcName: "Maq20", format: ".0f", type: "5", 
                        hwChan: ChillerMaq20Device.CHAN_PULSE_RPM, subtype: "1",
                        checkLo:"none", checkHi:"none")

    }        

}
