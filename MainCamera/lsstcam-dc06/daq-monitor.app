org.lsst.ccs.application.mainClass=org.lsst.ccs.startup.SubsystemBoot
org.lsst.ccs.application.description=Run the Daq-monitoring subsystem
org.lsst.ccs.application.args=--description DaqMonitor --initialConfiguration "Store:common|<instrument>|<instrument>-<site>" --alias daq-monitor
system.pre-execute=daqv5-setup
