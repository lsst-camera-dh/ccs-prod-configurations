org.lsst.ccs.application.mainClass=org.lsst.ccs.startup.SubsystemBoot
org.lsst.ccs.application.args=--alias image-handling-<host> --description ImageHandling  --initialConfiguration "\
    build:<host>,\
    General:defaultInitial,\
    Guider:noGuiding,\
    Commands:common|<instrument>,\
    DAQ:common|<instrument>|<site>|<host>,\
    FitsHandling:common|<site>" 
org.lsst.ccs.application.description=Run the Image Handling Subsystem (<host>)

