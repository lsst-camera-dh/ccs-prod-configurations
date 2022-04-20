org.lsst.ccs.application.mainClass=org.lsst.ccs.startup.SubsystemBoot
org.lsst.ccs.application.args=--description MCM  --alias ats-mcm --initialConfiguration "\
   General:common|<instrument>|<instrument>-<site>"
org.lsst.ccs.application.description=Start the MCM subsystem for auxtel
org.lsst.ccs.logging.StackTraceFormats.depth=-1
org.lsst.ccs.mcm.camera: AuxTel
system.property.org.lsst.ccs.config.remote=true

