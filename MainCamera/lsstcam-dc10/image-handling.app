org.lsst.ccs.application.mainClass=org.lsst.ccs.startup.SubsystemBoot
org.lsst.ccs.application.args=--alias image-handling-<host> --description ImageHandling  --initialConfiguration "\
    build:<host>,\
    General:lsstcam|lsstcam-<site>,\
    Guider:<instrument>-guiding,\
    Commands:common|<instrument>|<instrument>-<site>,\
    DAQ:common|<instrument>|<site>|<host>,\
    FitsHandling:common|<site>" 
org.lsst.ccs.application.description=Run the Image Handling Subsystem (<host>)
system.property.org.lsst.ccs.resource.path=ccs://lsst-camera-dev.slac.stanford.edu/RestFileServer/misc/spec-files-combined[spec]|../etc/|~/ccs/etc/|/etc/ccs/

