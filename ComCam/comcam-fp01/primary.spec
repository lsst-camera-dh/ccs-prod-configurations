# Specification file for primary header. Taken from LCA 10140 v1
#

# Define here the groups with respective comments.
# Keyword assigned to a group will appear under the group.
# The groups will follow this order
BLANK Basic        
BLANK Basic ---- Date, night and basic image information ----        
BLANK TelInfo
BLANK TelInfo ---- Telescope info, location, observer ----
BLANK Pointing
BLANK Pointing ---- Pointing info, etc. ----
BLANK TanProj
BLANK TanProj ---- TAN Projection ----
BLANK ImgId
BLANK ImgId ---- Image-identifying used to build OBS-ID ----
BLANK AddInfo
BLANK AddInfo ---- Additional Keys Information from Camera ----
BLANK ImgSeq
BLANK ImgSeq ---- Image sequence numbers ----
BLANK TsInfo
BLANK TsInfo ---- Test Stand information ----
BLANK CommCamInfo
BLANK CommCamInfo ---- Information from Camera (Common block) ---- 
BLANK CamInfo
BLANK CamInfo ---- Information from Camera ----
BLANK FilterGratInfo
BLANK FilterGratInfo ---- Filter/grating information ----
BLANK ExpInfo
BLANK ExpInfo ---- Exposure-related information ----
BLANK WeathInfo
BLANK WeathInfo ---- Weather information ----
BLANK HeadInfo
BLANK HeadInfo ---- Header information ----
BLANK Checksum
BLANK Checksum ---- Checksums ----
BLANK HierInfo
BLANK HierInfo ---- Hierarch information for CSC Simulatiom Mode ----
BLANK Stutter
BLANK Stutter ---- Stuttered Image Support ----

ORIGIN      String  ${Origin}                   Which site acquired the data
Basic:DATE        Date    ${FileCreationTime}         Creation Date and Time of File
Basic:MJD         MJD     ${FileCreationTime}         Modified Julian Date that the file was written
Basic:IMGTYPE     String  ${ImageType|UNKNOWN}        BIAS, DARK, FE55, FLAT, FLAT_<lam>, SPOT, PPUMP


CamInfo:RUNNUM      String  ${RunNumber}                The Run Number
CamInfo:CONTROLL    String  ${Instrument}               Duplicates INSTRUME
CamInfo:CCD_MANU!   String  ${CCDManufacturer}          CCD Manufacturer
CamInfo:CCD_TYPE!   String  ${CCDModel}                 CCD Model Number

ImgId:TESTTYPE    String  ${TestType}                 BIAS, DARK, FE55, FLAT, LAMBDA, PERSISTENCE, SPOT, SFLAT_<lam>, TRAP

DETSIZE     String  ${DETSIZE}
CamInfo:TEMP_SET    Float   ${TemperatureSetPoint}      Temperature set point (deg C)
ExpInfo:EXPTIME     Float   ${ExposureTime}             Exposure Time in Seconds
HeadInfo:FILENAME    String  ${OriginalFileName}         Original name of the file
BINX        Integer 1                           [pixels] binning along X axis 
BINY        Integer 1                           [pixels] binning along Y axis 
CCDGAIN     Float   1.0                         Rough guess at overall system gain (e-/DNB)
CCDNOISE    Float   10.0                        Rough guess at system noise (e- rms)
