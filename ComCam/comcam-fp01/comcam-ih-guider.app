org.lsst.ccs.application.mainClass=org.lsst.ccs.startup.SubsystemBoot
org.lsst.ccs.application.args=--description ImageHandling --alias comcam-ih --initialConfiguration "\
   General:<instrument>|<instrument>-<site>|<instrument>-<site>-guiding,\
   Guider:<instrument>-guiding,\
   DAQ:common|<instrument>|<instrument>-<site>|<instrument>-<site>-guiding,\
   build:common|<instrument>|<instrument>-<site>,\
   Commands:common|<instrument>|<instrument>-<site>,\
   FitsHandling:common|<instrument>|<instrument>-<site>"
org.lsst.ccs.application.description=Run the Image Handling Subsystem (for ComCam)
org.lsst.ccs.subsystem.agent.property.group=comcam
system.property.org.lsst.ccs.daq.ims.SourceTimeout=60000000
system.option.-add-opens\=java.base/java.util\=ALL-UNNAMED
system.property.org.lsst.ccs.resource.path=ccs://lsst-camera-dev.slac.stanford.edu/RestFileServer/misc/spec-files-combined[spec]|../etc/|~/ccs/etc/|/etc/ccs/
