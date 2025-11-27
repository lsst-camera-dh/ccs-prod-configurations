import org.lsst.ccs.description.groovy.CCSBuilder
import org.lsst.ccs.bootstrap.BootstrapResourceUtils
import org.lsst.ccs.subsystem.refrig.RefrigMain
import org.lsst.ccs.subsystem.refrig.CryoCompressor
import org.lsst.ccs.subsystem.refrig.CryoCompLimits
import org.lsst.ccs.subsystem.refrig.RefrigActionManager
import org.lsst.ccs.subsystem.refrig.FanControl
import org.lsst.ccs.subsystem.refrig.CompMaq20Device
import org.lsst.ccs.subsystem.refrig.CompMaq20PWMControl
import org.lsst.ccs.subsystem.refrig.CompMaq20DiscControl
import org.lsst.ccs.subsystem.refrig.CompPlutoDevice
import org.lsst.ccs.subsystem.refrig.SimCompPlutoDevice
import org.lsst.ccs.subsystem.refrig.SimCompPlutoPersist
import org.lsst.ccs.subsystem.common.devices.dataforth.Maq20PulseControl
import org.lsst.ccs.monitor.Channel

runMode = BootstrapResourceUtils.getBootstrapSystemProperties().getProperty("org.lsst.ccs.run.mode", "normal")
simulation = runMode.equals("simulation")
compPlutoDevice = simulation ? SimCompPlutoDevice : CompPlutoDevice

cryoPresent = buildProperties().getProperty("org.lsst.ccs.cryo.present", "1,2,3,4,5,6")
cryoSet = new HashSet()
if (!cryoPresent.isEmpty()) {
    for (j in cryoPresent.split(",")) {
        cryoSet.add(Integer.decode(j.trim()) - 1)
    }
}
cryoOrder = buildProperties().getProperty("org.lsst.ccs.cryo.order", "1,2,3,4,5,6").split(",")
cryoCircs = new int[cryoOrder.length]
for (j = 0; j < cryoCircs.length; j++) {
    cryoCircs[j] = Integer.decode(cryoOrder[j].trim()) - 1
}
cryoNames = ["Cryo1", "Cryo2", "Cryo3", "Cryo4", "Cryo5", "Cryo6"]

CCSBuilder builder = ["refrig"]

builder.main (RefrigMain) {

    CryoCompLimits (CryoCompLimits)

    ActionManager (RefrigActionManager)

    if (simulation) {
        SimPlcPersist (SimCompPlutoPersist)
    }

    for (j in cryoSet) {

        comp = cryoNames[cryoCircs[j]]
        "$comp" (CryoCompressor, discTempChan: "DischrgTmp_P", discPressChan: "DischrgPrs", suctTempChan: "SuctionTmp_P",
                 suctPressChan: "SuctionPrs", cmprPowerChan: "CompPower", phaseSepTempChan: "PhaseSepTmp",
                 oilLevelChan: "OilLevel") {

            if (j % 3 == 0) {
                ctrl2 = cryoSet.contains(j + 1) ? "${cryoNames[cryoCircs[j + 1]]}/Maq20/FanControl" : null
                ctrl3 = cryoSet.contains(j + 2) ? "${cryoNames[cryoCircs[j + 2]]}/Maq20/FanControl" : null
                FanCtrl (FanControl, fanCntrl: ["$comp/Maq20/FanControl", ctrl2, ctrl3],
                         ambientTemp: "$comp/AmbientTmp", cabinetTemp: "$comp/CabinetTmp")
            }

            Plc (compPlutoDevice)

            Maq20 (CompMaq20Device, modules: ["TTC", "TTC", "DIOL:pwm:pulse", "DIOL"]) {

                FanControl (CompMaq20PWMControl, modIndex: 2, funcIndex: 0, frequency: 200.0)

                PulseControl (Maq20PulseControl, modIndex: 2, funcIndex: 1, pulsesPerRevn: 6)

                LineControl0 (CompMaq20DiscControl, modIndex: 2, index: 0)

                LineControl1 (CompMaq20DiscControl, modIndex: 3, index: 1)

            }

            plc = "$comp/Plc"
            maq20 = "$comp/Maq20"

            DischrgTmp_P (Channel, description: "Discharge Temperature (PLC)", units: "\u00b0C", format: ".1f",
                          devcName: plc, hwChan: 1, type: "ADDREG:0", scale: 0.01)

            DischrgTmp_M (Channel, description: "Discharge Temperature (MAQ20)", units: "\u00b0C", format: ".1f",
                          devcName: maq20, hwChan: 3, type: "0", subtype: "T220")

            DischrgPrs   (Channel, description: "Discharge Pressure", units: "psia", format: ".1f",
                          devcName: plc, hwChan: 1, type: "ADDREG:3", scale: 0.1)

            SuctionTmp_P (Channel, description: "Suction Temperature (PLC)", units: "\u00b0C", format: ".1f",
                          devcName: plc, hwChan: 1, type: "ADDREG:1", scale: 0.01)

            SuctionTmp_M (Channel, description: "Suction Temperature (MAQ20)", units: "\u00b0C", format: ".1f",
                          devcName: maq20, hwChan: 2, type: "0", subtype: "T220")

            SuctionPrs   (Channel, description: "Suction Pressure", units: "psia", format: ".1f",
                          devcName: plc, hwChan: 1, type: "ADDREG:4", scale: 0.1)

            OilLevel     (Channel, description: "Oil Level", units: "mm", format: ".1f", hysteresis: 0.02,
                          devcName: plc, hwChan: 1, type: "ADDREG:2", scale: 0.01818, offset: -36.36)

            CompVoltage  (Channel, description: "Compressor Voltage", units: "Volts", format: ".1f",
                          devcName: plc, hwChan: 1, type: "ADDREG:6", scale: 0.1)

            CompCurrent  (Channel, description: "Compressor Current", units: "Amps", format: ".1f",
                          devcName: plc, hwChan: 1, type: "ADDREG:5", scale: 0.01)

            CompPower    (Channel, description: "Compressor Power", units: "VA", format: ".1f",
                          devcName: plc, hwChan: 0, type: "ADDINT:9", scale: 0.001)

            WaterInTmp   (Channel, description: "Water Inlet Temperature", units: "\u00b0C", format: ".1f",
                          devcName: maq20, hwChan: 0, type: "0", subtype: "T220", checkHi:"alarm")

            WaterOutTmp  (Channel, description: "Water Outlet Temperature", units: "\u00b0C", format: ".1f",
                          devcName: maq20, hwChan: 4, type: "0", subtype: "T220", checkHi:"alarm")

            AfterCoolTmp (Channel, description: "After Cooler Temperature", units: "\u00b0C", format: ".1f",
                          devcName: maq20, hwChan: 1, type: "0", subtype: "T220")

            PhaseSepTmp  (Channel, description: "Phase Separator Temperature", units: "\u00b0C", format: ".1f",
                          devcName: maq20, hwChan: 5, type: "0", subtype: "T220")

            OilSepTmp    (Channel, description: "Oil Separator Temperature", units: "\u00b0C", format: ".1f",
                          devcName: maq20, hwChan: 6, type: "0", subtype: "T220")

            SurgeTankTmp (Channel, description: "Surge Tank Temperature", units: "\u00b0C", format: ".1f",
                          devcName: maq20, hwChan: 7, type: "0", subtype: "T220")

            if (j % 3 == 0) {
                CabinetTmp (Channel, description: "Cabinet Temperature", units: "\u00b0C", format: ".1f",
                            devcName: maq20, hwChan: 1, type: "1", subtype: "T220")

                AmbientTmp (Channel, description: "Ambient Temperature", units: "\u00b0C", format: ".1f",
                            devcName: maq20, hwChan: 0, type: "1", subtype: "T220")
            }

            FanSpeed     (Channel, description: "Fan Speed", units: "rpm", format: ".0f",
                          devcName: maq20, hwChan: CompMaq20Device.CHAN_PULSE_RPM, type: "2", subtype: "1")

        }

    }

}
