# Specification file for primary header. 
# AuxTel specific quantities
#
INSTRUME    String  LATISS                      Instrument
TELESCOP    String  "LSST AuxTelescope"         Telescope
FACILITY    String  "Vera C. Rubin Observatory" Facility name
#
CCDTEMP     Float   ${focal-plane/${RAFT}/${REB}/SW/Temp} CCD temperature
TEMP_SET    Float   ${ats/TempCCDSetPoint}      CCD Temperature set point (deg C)

