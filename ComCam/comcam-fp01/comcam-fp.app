org.lsst.ccs.application.mainClass=org.lsst.ccs.startup.SubsystemBoot
org.lsst.ccs.application.args=--description FocalPlaneSubsystem --initialConfiguration --alias comcam-fp
org.lsst.ccs.application.description=Run the FocalPlane Subsystem for ComCam
org.lsst.ccs.ld.library.path=Daq4
org.lsst.ccs.raft.partition=comcam
org.lsst.ccs.subsystem.agent.property.group=comcam
system.pre-execute=daqv4-setup

