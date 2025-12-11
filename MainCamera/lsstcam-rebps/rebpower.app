org.lsst.ccs.application.description=Control the REB power supplies
org.lsst.ccs.application.mainClass=org.lsst.ccs.startup.SubsystemBoot
org.lsst.ccs.application.args=--description RebPowerSupply \
          --alias rebpower \
          --initialConfiguration "build:<alias>,\
                                  Limits:<alias>|generated-camera-normal-state,\
                                  Power:<alias>,\
                                  HVRegulation:<alias>(19),\
                                  General:<alias>,\
                                  timers:<alias>(14),\
                                  Devices:<alias>"

#To use a REB power supply with prototype firmware
#org.lsst.ccs.ps.version=proto

#To use the Lambda CPFE1000 as the main power supply
org.lsst.ccs.main.ps.type=cpfe

