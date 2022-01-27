org.lsst.ccs.application.mainClass=org.lsst.ccs.startup.SubsystemBoot
org.lsst.ccs.application.args=--description FocalPlane --initialConfiguration "\
   DAQ:common|<instrument>|<instrument>-<site>|<instrument>-<site>-emu,\
   Devices:<instrument>,\
   General:common|<instrument>|<instrument>-<site>,\
   HardwareId:<instrument>,\
   Instrument:<instrument>|<instrument>-<site>,\
   Limits:<instrument>(7),\
   RaftsLimits:<instrument>,\
   RaftTempControl:<instrument>,\
   RaftTempControlStatus:<instrument>,\
   Rafts:<instrument>|<instrument>-emu,\
   RaftsPower:<instrument>,\
   Sequencer:common|v25,\
   build:<instrument>,\
   Visualization:<site>,\
   timers:<instrument>" --alias comcam-fp
org.lsst.ccs.application.description=Run the FocalPlane Subsystem for ComCam
org.lsst.ccs.ld.library.path=Daq4
# Can we get rid of this?
org.lsst.ccs.raft.partition=emu
org.lsst.ccs.subsystem.agent.property.group=comcam
system.pre-execute=daqv4-setup
org.lsst.ccs.config.remote=true
