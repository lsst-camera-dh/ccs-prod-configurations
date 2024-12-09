org.lsst.ccs.application.mainClass=org.lsst.ccs.startup.SubsystemBoot
org.lsst.ccs.application.args=--alias ats-ih --description ImageHandling --initialConfiguration "\
   General:<instrument>|<instrument>-<site>,\
   DAQ:common|<instrument>|<instrument>-<site>,\
   Guider:noGuiding,\
   build:common|<instrument>|<instrument>-<site>,\
   Commands:common|<instrument>|<instrument>-<site>,\
   FitsHandling:common|<instrument>|<instrument>-<site>"
org.lsst.ccs.application.description=Run the Image Handling Subsystem (for ats)
org.lsst.ccs.subsystem.agent.property.group=auxtel
system.property.org.lsst.ccs.daq.ims.SourceTimeout=60000000
system.property.org.lsst.ccs.config.remote=true
system.option.-add-opens\=java.base/java.util\=ALL-UNNAMED

