system.property.org.lsst.ccs.resource.path=ccs://lsst-camera-dev.slac.stanford.edu/RestFileServer/misc/sequencer-files[seq]|../etc/|~/ccs/etc/|/etc/ccs/
org.lsst.ccs.application.mainClass=org.lsst.ccs.startup.SubsystemBoot
org.lsst.ccs.application.args=--description FocalPlane --alias focal-plane --initialConfiguration "\
   DAQ:common|<instrument>|<instrument>-<site>|<instrument>-guiding,\
   Devices:<instrument>,\
   General:common|<instrument>|<instrument>-<site>,\
   Guider:<instrument>-guiding,\
   HardwareId:<instrument>,\
   Instrument:<instrument>|<instrument>-<site>,\
   Limits:<instrument>,\
   RaftsLimits:<instrument>-dp80,\
   RaftTempControl:<instrument>|<instrument>-101e,\
   RaftTempControlStatus:<instrument>|<instrument>-on,\
   Rafts:<instrument>-dp80|<instrument>-rc2,\
   RaftsPower:<instrument>,\
   Sequencer:common|3s-v2,\
   build:<instrument>,\
   Visualization:<instrument>-<site>,\
   timers:<instrument>" 
org.lsst.ccs.application.description=Run the FocalPlane Subsystem
org.lsst.ccs.ld.library.path=Daq4
org.lsst.ccs.raft.partition=bts
org.lsst.ccs.dbUrl=jdbc:mysql://lsst-ir2db01.slac.stanford.edu:3306/ir2dbprod?user=ccs&password=ccs23&autoReconnect=true
org.lsst.ccs.transport=jgroups:udp_ccs:org.lsst.ccs.messaging.util.MultiQueueDispatcher
org.lsst.ccs.monitoring.no.reliability=true
# Extra logging for idle_clear 
# org.lsst.ccs.subsystem.focalplane.IdleClear.level=FINE
# org.lsst.ccs.subsystem.focalplane.Sequencers.level=FINE
