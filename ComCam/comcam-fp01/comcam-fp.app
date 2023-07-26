org.lsst.ccs.application.mainClass=org.lsst.ccs.startup.SubsystemBoot
org.lsst.ccs.application.args=--description FocalPlane --initialConfiguration "\
   DAQ:common|<instrument>|<instrument>-<site>,\
   Devices:<instrument>,\
   General:common|<instrument>|<instrument>-<site>,\
   Guider:no-guiding,\
   HardwareId:<instrument>,\
   Instrument:<instrument>|<instrument>-<site>,\
   Limits:<instrument>|<instrument>-<site>,\
   RaftsLimits:<instrument>,\
   RaftTempControl:<instrument>,\
   RaftTempControlStatus:<instrument>,\
   Rafts:<instrument>|<instrument>-v26|<instrument>-<site>,\
   RaftsPower:<instrument>,\
   Sequencer:common|v26,\
   build:<instrument>,\
   Visualization:<site>,\
   timers:<instrument>" --alias comcam-fp
org.lsst.ccs.application.description=Run the FocalPlane Subsystem for ComCam
org.lsst.ccs.ld.library.path=Daq4
# Can we get rid of this?
org.lsst.ccs.raft.partition=comcam
org.lsst.ccs.subsystem.agent.property.group=comcam
