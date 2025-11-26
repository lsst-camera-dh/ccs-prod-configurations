import org.lsst.ccs.description.groovy.CCSBuilder
import org.lsst.ccs.bootstrap.BootstrapResourceUtils
import org.lsst.ccs.subsystem.common.ConfiguredAverageChannel;
import org.lsst.ccs.subsystem.refrig.ThermalMain
import org.lsst.ccs.subsystem.refrig.TrimHeaterControl
import org.lsst.ccs.subsystem.refrig.PcpPlutoDevice
import org.lsst.ccs.subsystem.refrig.HeaterPsDevice
import org.lsst.ccs.subsystem.refrig.SimCompPlutoDevice
import org.lsst.ccs.subsystem.refrig.SimHeaterPsDevice
import org.lsst.ccs.subsystem.refrig.constants.TrimHeaters
import org.lsst.ccs.subsystem.common.alertaction.RefrigActionClient
import org.lsst.ccs.subsystem.common.devices.dataforth.Maq20Device
import org.lsst.ccs.monitor.Channel

runMode = BootstrapResourceUtils.getBootstrapSystemProperties().getProperty("org.lsst.ccs.run.mode", "normal")
if (runMode.equals("simulation")) {
    plutoDevice = SimCompPlutoDevice
    heaterPsDevice = SimHeaterPsDevice
}
else {
    plutoDevice = PcpPlutoDevice
    heaterPsDevice = HeaterPsDevice
}

CCSBuilder builder = ["thermal"]

builder.main (ThermalMain,
              coldTempChans: ["Cold_Temp/CLP-RTD-00", "Cold_Temp/CLP-RTD-50",
                              "Cold_Temp/CLP-RTD-02", "Cold_Temp/CLP-RTD-03",
                              "Cold_Temp/CLP-RTD-52", "Cold_Temp/CLP-RTD-53",
                              "Cold_Temp/CLP-RTD-05", "Cold_Temp/CLP-RTD-55"],
              cryoTempChans: ["Cryo_Temp/CYP-RTD-02", "Cryo_Temp/CYP-RTD-03", "Cryo_Temp/CYP-RTD-04",
                              "Cryo_Temp/CYP-RTD-12", "Cryo_Temp/CYP-RTD-13", "Cryo_Temp/CYP-RTD-14",
                              "Cryo_Temp/CYP-RTD-21", "Cryo_Temp/CYP-RTD-22", "Cryo_Temp/CYP-RTD-24",
                              "Cryo_Temp/CYP-RTD-25", "Cryo_Temp/CYP-RTD-30", "Cryo_Temp/CYP-RTD-31",
                              "Cryo_Temp/CYP-RTD-33", "Cryo_Temp/CYP-RTD-34", "Cryo_Temp/CYP-RTD-41",
                              "Cryo_Temp/CYP-RTD-42", "Cryo_Temp/CYP-RTD-43", "Cryo_Temp/CYP-RTD-51",
                              "Cryo_Temp/CYP-RTD-52", "Cryo_Temp/CYP-RTD-53"]) {

    ActionClient (RefrigActionClient)

    ColdTempCtrlMYE (TrimHeaterControl, powerDevc: "TrimPower", powerChan: TrimHeaters.TRIM_HEATER_COLD_MYE,
                     tempChans: ["Cold_Temp/CLP-RTD-00", "Cold_Temp/CLP-RTD-50"])

    ColdTempCtrlC (TrimHeaterControl, powerDevc: "TrimPower", powerChan: TrimHeaters.TRIM_HEATER_COLD_C,
                   tempChans: ["Cold_Temp/CLP-RTD-02", "Cold_Temp/CLP-RTD-03",
                               "Cold_Temp/CLP-RTD-52", "Cold_Temp/CLP-RTD-53"])

    ColdTempCtrlPYE (TrimHeaterControl, powerDevc: "TrimPower", powerChan: TrimHeaters.TRIM_HEATER_COLD_PYE,
                     tempChans: ["Cold_Temp/CLP-RTD-05", "Cold_Temp/CLP-RTD-55"])

    CryoTempCtrl (TrimHeaterControl, powerDevc: "TrimPower", powerChan: TrimHeaters.TRIM_HEATER_CRYO,
                  tempChans: ["Cryo_Temp/CYP-RTD-12", "Cryo_Temp/CYP-RTD-13", "Cryo_Temp/CYP-RTD-14",
                              "Cryo_Temp/CYP-RTD-31", "Cryo_Temp/CYP-RTD-42", "Cryo_Temp/CYP-RTD-43"])

    Rtds       (Maq20Device, modules: ["RTD", "RTD", "RTD", "RTD", "RTD", "RTD"])

    ProtRtds   (plutoDevice)

    TrimPower  (heaterPsDevice, softMaxCurrent: 1.95)

    "Cold_Temp/AvgColdTemp" (ConfiguredAverageChannel, 
                             description: "Average Cold Plate RTD Temperature",
                             units: "\u00b0C", format: ".1f")

    "Cold_Temp/CLP-RTD-00" (Channel, description: "Cold Plate RTD 00", units: "\u00b0C", format: ".1f",
                            devcName: "Rtds", hwChan: 0, type: "3", subtype: "R200")

    "Cold_Temp/CLP-RTD-02" (Channel, description: "Cold Plate RTD 02", units: "\u00b0C", format: ".1f",
                            devcName: "Rtds", hwChan: 1, type: "3", subtype: "R200")

    "Cold_Temp/CLP-RTD-03" (Channel, description: "Cold Plate RTD 03", units: "\u00b0C", format: ".1f",
                            devcName: "ProtRtds", hwChan: 0, type: "ADDREG:12", scale: 0.013125, offset: -215.5)

    "Cold_Temp/CLP-RTD-05" (Channel, description: "Cold Plate RTD 05", units: "\u00b0C", format: ".1f",
                            devcName: "ProtRtds", hwChan: 0, type: "ADDREG:13", scale: 0.013125, offset: -215.5)

    "Cold_Temp/CLP-RTD-50" (Channel, description: "Cold Plate RTD 50", units: "\u00b0C", format: ".1f",
                            devcName: "ProtRtds", hwChan: 0, type: "ADDREG:11", scale: 0.013125, offset: -215.5)

    "Cold_Temp/CLP-RTD-52" (Channel, description: "Cold Plate RTD 52", units: "\u00b0C", format: ".1f",
                            devcName: "Rtds", hwChan: 0, type: "0", subtype: "R200")

    "Cold_Temp/CLP-RTD-53" (Channel, description: "Cold Plate RTD 53", units: "\u00b0C", format: ".1f",
                            devcName: "Rtds", hwChan: 1, type: "0", subtype: "R200")

    "Cold_Temp/CLP-RTD-55" (Channel, description: "Cold Plate RTD 55", units: "\u00b0C", format: ".1f",
                            devcName: "ProtRtds", hwChan: 0, type: "ADDREG:10", scale: 0.013125, offset: -215.5)

    "Cryo_Temp/AvgCryoTemp" (ConfiguredAverageChannel, 
                             description: "Average Cryo Plate RTD Temperature",
                             units: "\u00b0C", format: ".1f", checkHi: "alarm")

    "Cryo_Temp/CYP-RTD-02" (Channel, description: "Cryo Plate RTD 02", units: "\u00b0C", format: ".1f",
                            devcName: "Rtds", hwChan: 2, type: "4", subtype: "R200")

    "Cryo_Temp/CYP-RTD-03" (Channel, description: "Cryo Plate RTD 03", units: "\u00b0C", format: ".1f",
                            devcName: "Rtds", hwChan: 0, type: "4", subtype: "R200")

    "Cryo_Temp/CYP-RTD-04" (Channel, description: "Cryo Plate RTD 04", units: "\u00b0C", format: ".1f",
                            devcName: "Rtds", hwChan: 4, type: "3", subtype: "R200")

    "Cryo_Temp/CYP-RTD-12" (Channel, description: "Cryo Plate RTD 12", units: "\u00b0C", format: ".1f",
                            devcName: "ProtRtds", hwChan: 0, type: "ADDREG:23", scale: 0.013125, offset: -215.5)

    "Cryo_Temp/CYP-RTD-13" (Channel, description: "Cryo Plate RTD 13", units: "\u00b0C", format: ".1f",
                            devcName: "Rtds", hwChan: 5, type: "3", subtype: "R200")

    "Cryo_Temp/CYP-RTD-14" (Channel, description: "Cryo Plate RTD 14", units: "\u00b0C", format: ".1f",
                            devcName: "ProtRtds", hwChan: 0, type: "ADDREG:22", scale: 0.013125, offset: -215.5)

    "Cryo_Temp/CYP-RTD-21" (Channel, description: "Cryo Plate RTD 21", units: "\u00b0C", format: ".1f",
                            devcName: "Rtds", hwChan: 3, type: "4", subtype: "R200")

    "Cryo_Temp/CYP-RTD-22" (Channel, description: "Cryo Plate RTD 22", units: "\u00b0C", format: ".1f",
                            devcName: "Rtds", hwChan: 1, type: "4", subtype: "R200")

    "Cryo_Temp/CYP-RTD-24" (Channel, description: "Cryo Plate RTD 24", units: "\u00b0C", format: ".1f",
                            devcName: "Rtds", hwChan: 3, type: "3", subtype: "R200")

    "Cryo_Temp/CYP-RTD-25" (Channel, description: "Cryo Plate RTD 25", units: "\u00b0C", format: ".1f",
                            devcName: "Rtds", hwChan: 2, type: "3", subtype: "R200")

    "Cryo_Temp/CYP-RTD-30" (Channel, description: "Cryo Plate RTD 30", units: "\u00b0C", format: ".1f",
                            devcName: "Rtds", hwChan: 3, type: "1", subtype: "R200")

    "Cryo_Temp/CYP-RTD-31" (Channel, description: "Cryo Plate RTD 31", units: "\u00b0C", format: ".1f",
                            devcName: "ProtRtds", hwChan: 0, type: "ADDREG:21", scale: 0.013125, offset: -215.5)

    "Cryo_Temp/CYP-RTD-33" (Channel, description: "Cryo Plate RTD 33", units: "\u00b0C", format: ".1f",
                            devcName: "Rtds", hwChan: 3, type: "0", subtype: "R200")

    "Cryo_Temp/CYP-RTD-34" (Channel, description: "Cryo Plate RTD 34", units: "\u00b0C", format: ".1f",
                            devcName: "Rtds", hwChan: 2, type: "0", subtype: "R200")

    "Cryo_Temp/CYP-RTD-41" (Channel, description: "Cryo Plate RTD 41", units: "\u00b0C", format: ".1f",
                            devcName: "Rtds", hwChan: 1, type: "1", subtype: "R200")

    "Cryo_Temp/CYP-RTD-42" (Channel, description: "Cryo Plate RTD 42", units: "\u00b0C", format: ".1f",
                            devcName: "Rtds", hwChan: 5, type: "0", subtype: "R200")

    "Cryo_Temp/CYP-RTD-43" (Channel, description: "Cryo Plate RTD 43", units: "\u00b0C", format: ".1f",
                            devcName: "ProtRtds", hwChan: 0, type: "ADDREG:20", scale: 0.013125, offset: -215.5)

    "Cryo_Temp/CYP-RTD-51" (Channel, description: "Cryo Plate RTD 51", units: "\u00b0C", format: ".1f",
                            devcName: "Rtds", hwChan: 2, type: "1", subtype: "R200")

    "Cryo_Temp/CYP-RTD-52" (Channel, description: "Cryo Plate RTD 52", units: "\u00b0C", format: ".1f",
                            devcName: "Rtds", hwChan: 0, type: "1", subtype: "R200")

    "Cryo_Temp/CYP-RTD-53" (Channel, description: "Cryo Plate RTD 53", units: "\u00b0C", format: ".1f",
                            devcName: "Rtds", hwChan: 4, type: "0", subtype: "R200")

    "Grid_Temp/GRD-RTD-01" (Channel, description: "Grid RTD 01", units: "\u00b0C", format: ".1f",
                            devcName: "Rtds", hwChan: 4, type: "1", subtype: "R200")

    "Grid_Temp/GRD-RTD-02" (Channel, description: "Grid RTD 02", units: "\u00b0C", format: ".1f",
                            devcName: "Rtds", hwChan: 5, type: "1", subtype: "R200")

    "Grid_Temp/GRD-RTD-03" (Channel, description: "Grid RTD 03", units: "\u00b0C", format: ".1f",
                            devcName: "Rtds", hwChan: 4, type: "4", subtype: "R200")

    "Grid_Temp/GRD-RTD-04" (Channel, description: "Grid RTD 04", units: "\u00b0C", format: ".1f",
                            devcName: "Rtds", hwChan: 5, type: "4", subtype: "R200")

    "Grid_Temp/GFX-RTD-01" (Channel, description: "Grid Flexure RTD 01", units: "\u00b0C", format: ".1f",
                            devcName: "Rtds", hwChan: 0, type: "2", subtype: "R200")

    "Grid_Temp/GFX-RTD-02" (Channel, description: "Grid Flexure RTD 02", units: "\u00b0C", format: ".1f",
                            devcName: "Rtds", hwChan: 1, type: "2", subtype: "R200")

    "Grid_Temp/GFX-RTD-03" (Channel, description: "Grid Flexure RTD 03", units: "\u00b0C", format: ".1f",
                            devcName: "Rtds", hwChan: 0, type: "5", subtype: "R200")

    "Grid_Temp/GFX-RTD-04" (Channel, description: "Grid Flexure RTD 04", units: "\u00b0C", format: ".1f",
                            devcName: "Rtds", hwChan: 1, type: "5", subtype: "R200")

    "Grid_Temp/CFX-RTD-01" (Channel, description: "Cryo Flexure RTD 01", units: "\u00b0C", format: ".1f",
                            devcName: "Rtds", hwChan: 2, type: "2", subtype: "R200")

    "Grid_Temp/CFX-RTD-02" (Channel, description: "Cryo Flexure RTD 02", units: "\u00b0C", format: ".1f",
                            devcName: "Rtds", hwChan: 3, type: "2", subtype: "R200")

    "Grid_Temp/CFX-RTD-03" (Channel, description: "Cryo Flexure RTD 03", units: "\u00b0C", format: ".1f",
                            devcName: "Rtds", hwChan: 2, type: "5", subtype: "R200")

    "Grid_Temp/CFX-RTD-04" (Channel, description: "Cryo Flexure RTD 04", units: "\u00b0C", format: ".1f",
                            devcName: "Rtds", hwChan: 3, type: "5", subtype: "R200")

    "Trim_Htrs/ColdHtr0_V" (Channel, description: "Cold Heater 0 Voltage", units: "Volts", format: ".1f",
                            devcName: "TrimPower", hwChan: 6, type: "VOLTAGE")

    "Trim_Htrs/ColdHtr0_I" (Channel, description: "Cold Heater 0 Current", units: "Amps", format: ".1f",
                            devcName: "TrimPower", hwChan: 6, type: "CURRENT")

    "Trim_Htrs/ColdHtr0_P" (Channel, description: "Cold Heater 0 Power", units: "Watts", format: ".1f",
                            devcName: "TrimPower", hwChan: 6, type: "POWER")

    "Trim_Htrs/ColdHtr1_V" (Channel, description: "Cold Heater 1 Voltage", units: "Volts", format: ".1f",
                            devcName: "TrimPower", hwChan: 7, type: "VOLTAGE")

    "Trim_Htrs/ColdHtr1_I" (Channel, description: "Cold Heater 1 Current", units: "Amps", format: ".1f",
                            devcName: "TrimPower", hwChan: 7, type: "CURRENT")

    "Trim_Htrs/ColdHtr1_P" (Channel, description: "Cold Heater 1 Power", units: "Watts", format: ".1f",
                            devcName: "TrimPower", hwChan: 7, type: "POWER")

    "Trim_Htrs/ColdHtr2_V" (Channel, description: "Cold Heater 2 Voltage", units: "Volts", format: ".1f",
                            devcName: "TrimPower", hwChan: 8, type: "VOLTAGE")

    "Trim_Htrs/ColdHtr2_I" (Channel, description: "Cold Heater 2 Current", units: "Amps", format: ".1f",
                            devcName: "TrimPower", hwChan: 8, type: "CURRENT")

    "Trim_Htrs/ColdHtr2_P" (Channel, description: "Cold Heater 2 Power", units: "Watts", format: ".1f",
                            devcName: "TrimPower", hwChan: 8, type: "POWER")

    "Trim_Htrs/ColdHtr3_V" (Channel, description: "Cold Heater 3 Voltage", units: "Volts", format: ".1f",
                            devcName: "TrimPower", hwChan: 9, type: "VOLTAGE")

    "Trim_Htrs/ColdHtr3_I" (Channel, description: "Cold Heater 3 Current", units: "Amps", format: ".1f",
                            devcName: "TrimPower", hwChan: 9, type: "CURRENT")

    "Trim_Htrs/ColdHtr3_P" (Channel, description: "Cold Heater 3 Power", units: "Watts", format: ".1f",
                            devcName: "TrimPower", hwChan: 9, type: "POWER")

    "Trim_Htrs/ColdHtr4_V" (Channel, description: "Cold Heater 4 Voltage", units: "Volts", format: ".1f",
                            devcName: "TrimPower", hwChan: 10, type: "VOLTAGE")

    "Trim_Htrs/ColdHtr4_I" (Channel, description: "Cold Heater 4 Current", units: "Amps", format: ".1f",
                            devcName: "TrimPower", hwChan: 10, type: "CURRENT")

    "Trim_Htrs/ColdHtr4_P" (Channel, description: "Cold Heater 4 Power", units: "Watts", format: ".1f",
                            devcName: "TrimPower", hwChan: 10, type: "POWER")

    "Trim_Htrs/ColdHtr5_V" (Channel, description: "Cold Heater 5 Voltage", units: "Volts", format: ".1f",
                            devcName: "TrimPower", hwChan: 11, type: "VOLTAGE")

    "Trim_Htrs/ColdHtr5_I" (Channel, description: "Cold Heater 5 Current", units: "Amps", format: ".1f",
                            devcName: "TrimPower", hwChan: 11, type: "CURRENT")

    "Trim_Htrs/ColdHtr5_P" (Channel, description: "Cold Heater 5 Power", units: "Watts", format: ".1f",
                            devcName: "TrimPower", hwChan: 11, type: "POWER")

    "Trim_Htrs/ColdTotal_P" (Channel, description: "Cold Total Power", units: "Watts", format: ".1f",
                             devcName: "TrimPower", hwChan: TrimHeaters.TRIM_HEATER_COLD, type: "TOTALPOWER")

    "Trim_Htrs/CryoHtr0_V" (Channel, description: "Cryo Heater 0 Voltage", units: "Volts", format: ".1f",
                            devcName: "TrimPower", hwChan: 0, type: "VOLTAGE")

    "Trim_Htrs/CryoHtr0_I" (Channel, description: "Cryo Heater 0 Current", units: "Amps", format: ".1f",
                            devcName: "TrimPower", hwChan: 0, type: "CURRENT")

    "Trim_Htrs/CryoHtr0_P" (Channel, description: "Cryo Heater 0 Power", units: "Watts", format: ".1f",
                            devcName: "TrimPower", hwChan: 0, type: "POWER")

    "Trim_Htrs/CryoHtr1_V" (Channel, description: "Cryo Heater 1 Voltage", units: "Volts", format: ".1f",
                            devcName: "TrimPower", hwChan: 1, type: "VOLTAGE")

    "Trim_Htrs/CryoHtr1_I" (Channel, description: "Cryo Heater 1 Current", units: "Amps", format: ".1f",
                            devcName: "TrimPower", hwChan: 1, type: "CURRENT")

    "Trim_Htrs/CryoHtr1_P" (Channel, description: "Cryo Heater 1 Power", units: "Watts", format: ".1f",
                            devcName: "TrimPower", hwChan: 1, type: "POWER")

    "Trim_Htrs/CryoHtr2_V" (Channel, description: "Cryo Heater 2 Voltage", units: "Volts", format: ".1f",
                            devcName: "TrimPower", hwChan: 2, type: "VOLTAGE")

    "Trim_Htrs/CryoHtr2_I" (Channel, description: "Cryo Heater 2 Current", units: "Amps", format: ".1f",
                            devcName: "TrimPower", hwChan: 2, type: "CURRENT")

    "Trim_Htrs/CryoHtr2_P" (Channel, description: "Cryo Heater 2 Power", units: "Watts", format: ".1f",
                            devcName: "TrimPower", hwChan: 2, type: "POWER")

    "Trim_Htrs/CryoHtr3_V" (Channel, description: "Cryo Heater 3 Voltage", units: "Volts", format: ".1f",
                            devcName: "TrimPower", hwChan: 3, type: "VOLTAGE")

    "Trim_Htrs/CryoHtr3_I" (Channel, description: "Cryo Heater 3 Current", units: "Amps", format: ".1f",
                            devcName: "TrimPower", hwChan: 3, type: "CURRENT")

    "Trim_Htrs/CryoHtr3_P" (Channel, description: "Cryo Heater 3 Power", units: "Watts", format: ".1f",
                            devcName: "TrimPower", hwChan: 3, type: "POWER")

    "Trim_Htrs/CryoHtr4_V" (Channel, description: "Cryo Heater 4 Voltage", units: "Volts", format: ".1f",
                            devcName: "TrimPower", hwChan: 4, type: "VOLTAGE")

    "Trim_Htrs/CryoHtr4_I" (Channel, description: "Cryo Heater 4 Current", units: "Amps", format: ".1f",
                            devcName: "TrimPower", hwChan: 4, type: "CURRENT")

    "Trim_Htrs/CryoHtr4_P" (Channel, description: "Cryo Heater 4 Power", units: "Watts", format: ".1f",
                            devcName: "TrimPower", hwChan: 4, type: "POWER")

    "Trim_Htrs/CryoHtr5_V" (Channel, description: "Cryo Heater 5 Voltage", units: "Volts", format: ".1f",
                            devcName: "TrimPower", hwChan: 5, type: "VOLTAGE")

    "Trim_Htrs/CryoHtr5_I" (Channel, description: "Cryo Heater 5 Current", units: "Amps", format: ".1f",
                            devcName: "TrimPower", hwChan: 5, type: "CURRENT")

    "Trim_Htrs/CryoHtr5_P" (Channel, description: "Cryo Heater 5 Power", units: "Watts", format: ".1f",
                            devcName: "TrimPower", hwChan: 5, type: "POWER")

    "Trim_Htrs/CryoTotal_P" (Channel, description: "Cryo Total Power", units: "Watts", format: ".1f",
                             devcName: "TrimPower", hwChan: TrimHeaters.TRIM_HEATER_CRYO, type: "TOTALPOWER", checkLo: "alarm", hysteresis: 0.008)

    "Trim_Htrs/HtrBulk_V" (Channel, description: "Heater Bulk PS Voltage", units: "Volts", format: ".1f",
                           devcName: "TrimPower", hwChan: 0, type: "MAINVOLTS")

    "Trim_Htrs/HtrBulk_I" (Channel, description: "Heater Bulk PS Current", units: "Amps", format: ".1f",
                           devcName: "TrimPower", hwChan: 0, type: "MAINCURR")

    "Trim_Htrs/HtrBulk_P" (Channel, description: "Heater Bulk PS Power", units: "Watts", format: ".1f",
                           devcName: "TrimPower", hwChan: 0, type: "MAINPOWER")

    "Trim_Htrs/HtrBulkTmp" (Channel, description: "Heater Bulk PS Temperature", units: "\u00b0C", format: ".1f",
                             devcName: "TrimPower", hwChan: 0, type: "MAINTEMP")

    "Trim_Htrs/HtrPsTmp" (Channel, description: "Heater PS Temperature", units: "\u00b0C", format: ".1f",
                           devcName: "TrimPower", hwChan: 0, type: "TEMP")
}
