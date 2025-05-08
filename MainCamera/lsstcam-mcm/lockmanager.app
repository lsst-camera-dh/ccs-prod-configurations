org.lsst.ccs.application.mainClass=org.lsst.ccs.startup.SubsystemBoot
org.lsst.ccs.application.description=Run the Lock Manager 
org.lsst.ccs.application.args=--description LockManager --initialConfiguration General:defaultInitial|<instrument>-<site>
org.lsst.ccs.lockservice=remote
org.lsst.ccs.lockservice.enforceLevel=STRICT
org.lsst.ccs.subsystem.lockmanager.level=FINE