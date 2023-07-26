org.lsst.ccs.application.mainClass=org.lsst.ccs.startup.SubsystemBoot
org.lsst.ccs.application.args=--description ImageHandling --alias comcam-ih --initialConfiguration "\
   General:<instrument>|<instrument>-<site>,\
   Guider:noGuiding,\
   DAQ:common|<instrument>|<instrument>-<site>,\
   build:common|<instrument>|<instrument>-<site>,\
   Commands:common|<instrument>|<instrument>-<site>,\
   FitsHandling:common|<instrument>|<instrument>-<site>"
org.lsst.ccs.application.description=Run the Image Handling Subsystem (for ComCam)
org.lsst.ccs.subsystem.agent.property.group=comcam
system.property.org.lsst.ccs.daq.ims.SourceTimeout=60000000
system.option.-add-opens\=java.base/java.util\=ALL-UNNAMED
