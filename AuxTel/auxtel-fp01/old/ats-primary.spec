# Specification file for primary header. 
# AuxTel specific quantities
#
TelInfo:INSTRUME    String  LATISS                      Instrument
TelInfo:TELESCOP    String  "LSST AuxTelescope"         Telescope
TelInfo:FACILITY    String  "Vera C. Rubin Observatory" Facility name
#
CCDTEMP     Float   ${focal-plane/${RAFT}/${REB}/SW/Temp} CCD temperature
CamInfo:TEMP_SET    Float   ${ats/TempCCDSetPoint}      CCD Temperature set point (deg C)

