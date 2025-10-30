import org.lsst.ccs.description.groovy.CCSBuilder;
import org.lsst.ccs.monitor.Alarm;
import org.lsst.ccs.monitor.Channel;
import org.lsst.ccs.subsystem.bonnshutter.BonnShutterSubsystem;
import org.lsst.ccs.subsystem.bonnshutter.alerts.BonnShutterAlerts;

CCSBuilder builder = ["bonn-shutter"]
Class deviceClass = Class.forName("org.lsst.ccs.subsystem.bonnshutter.BonnDevice")

builder.bonn(BonnShutterSubsystem) {

    AlarmVoltage(Alarm, alertToBeRaised: BonnShutterAlerts.VOLTAGE.newAlert())
    
    Device(deviceClass) {

        Bonn_V5  (Channel, description:"BonnShutter 5-volt reading",
                  devcName:"BonnDevice", type:"Bonn_V5", units:"volts",
                  format:"%.3f", checkLo:"alarm", checkHi:"alarm",
                  alarmHi:"AlarmVoltage", alarmLo:"AlarmVoltage")

        Bonn_V36 (Channel, description:"BonnShutter 5-volt reading",
                  devcName:"BonnDevice", type:"Bonn_V36", units:"volts",
                  format:"%.2f", checkLo:"alarm", checkHi:"alarm",
                  alarmHi:"AlarmVoltage", alarmLo:"AlarmVoltage")
    }

}
