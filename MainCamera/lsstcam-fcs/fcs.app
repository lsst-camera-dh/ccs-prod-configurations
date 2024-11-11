org.lsst.ccs.application.mainClass=org.lsst.ccs.startup.SubsystemBoot
org.lsst.ccs.application.description=Run FCS Subsystem with real hardware
org.lsst.ccs.application.args=--description Fcs --alias <app> --initialConfiguration "timers:base|<acInstance>|<caInstance>|<loInstance>,canbus:carousel|loader,controller:autochanger|<acInstance>|carousel|<caInstance>|loader|<loInstance>,serialNB:<acInstance>|<caInstance>|<loInstance>,filter:carousel,nodeID:autochanger|carousel|loader,sensor:autochanger|<acInstance>|carousel|<caInstance>|loader|<loInstance>,readRate:autochanger|carousel|loader,carousel:carousel|<caInstance>,autochanger:autochanger|<acInstance>,loader:loader|<loInstance>"

org.lsst.ccs.run.mode=hardware
org.lsst.ccs.subsystem.agent.property.runMode=hardware

org.lsst.ccs.fcs.hcu.ip=quadbox

# Hardware components of Filter Exchanger : 2 instances of autochanger and of loader.
# these 2 lines below have to be changed depending on which instance of hardware 
# for autochanger and for loader is to be run.
org.lsst.ccs.fcs.instance.autochanger=AC1
org.lsst.ccs.fcs.instance.loader=LO1
org.lsst.ccs.fcs.instance.carousel=FINAL

org.lsst.ccs.subsystem.agent.property.acInstance=autochanger1
org.lsst.ccs.subsystem.agent.property.caInstance=carousel-f
org.lsst.ccs.subsystem.agent.property.loInstance=loader1

# for GUI
org.lsst.ccs.subsystem.agent.property.agentCategory=FILTER_CHANGER

# no remote persistence
org.lsst.ccs.persist.remote=false

