org.lsst.ccs.application.mainClass=org.lsst.ccs.startup.SubsystemBoot
org.lsst.ccs.application.args=--description ImageHandling --alias comcam-ih --initialConfiguration "\
   General:<instrument>,\
   DAQ:common|<instrument>|<instrument>-<site>|<instrument>-<site>-emu,\
   build:common|<instrument>|<instrument>-<site>,\
   FitsHandling:common|<instrument>|<instrument>-<site>"
org.lsst.ccs.application.description=Run the Image Handling Subsystem (for ComCam)
system.pre-execute=daqv4-setup
org.lsst.ccs.subsystem.agent.property.group=comcam
system.property.org.lsst.ccs.daq.ims.SourceTimeout=60000000
org.lsst.ccs.config.remote=true
