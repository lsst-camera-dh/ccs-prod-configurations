org.lsst.ccs.application.args=--alias ats-fp --description FocalPlane --initialConfiguration "\
   DAQ:common|<instrument>|<instrument>-<site>|<instrument>-<site>-emu,\
   Devices:<instrument>,\
   General:common|<instrument>|<instrument>-<site>,HardwareId:<instrument>,\
   Guider:no-guiding,\
   Instrument:<instrument>|<instrument>-<site>,\
   Limits:<instrument>|<instrument>-<site>|<instrument>-emu,\
   RaftsLimits:<instrument>,\
   RaftTempControl:<instrument>,\
   RaftTempControlStatus:<instrument>,\
   Rafts:<instrument>|<instrument>-<site>|<instrument>-emu,\
   RaftsPower:<instrument>,\
   Sequencer:common|v26noRG|disableIdleFlush,\
   build:<instrument>,\
   Visualization:<site>,\
   timers:<instrument>
# This needs to be a system property to keep the DAQ driver happy.
# Probably this should become the default, since it is the only option supported.
org.lsst.ccs.ld.library.path=Daq4
org.lsst.ccs.subsystem.agent.property.group=auxtel
org.lsst.ccs.raft.partition=emu
org.lsst.ccs.application.mainClass=org.lsst.ccs.startup.SubsystemBoot
org.lsst.ccs.application.description=Run the FocalPlane Subsystem
system.property.org.lsst.ccs.config.remote=true
