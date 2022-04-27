# Specification file for primary header. Taken from LCA 10140 v1
#
ORIGIN      String  ${Origin}                   Which site acquired the data
DATE        Date    ${FileCreationTime}         Creation Date and Time of File
MJD         MJD     ${FileCreationTime}         Modified Julian Date that the file was written
RUNNUM      String  ${RunNumber}                The Run Number
CONTROLL    String  ${Instrument}               Duplicates INSTRUME
CCD_MANU!   String  ${CCDManufacturer}          CCD Manufacturer
CCD_TYPE!   String  ${CCDModel}                 CCD Model Number
TESTTYPE    String  ${TestType}                 BIAS, DARK, FE55, FLAT, LAMBDA, PERSISTENCE, SPOT, SFLAT_<lam>, TRAP
IMGTYPE     String  ${ImageType|UNKNOWN}        BIAS, DARK, FE55, FLAT, FLAT_<lam>, SPOT, PPUMP
DETSIZE     String  ${DETSIZE}
TEMP_SET    Float   ${TemperatureSetPoint}      Temperature set point (deg C)
EXPTIME     Float   ${ExposureTime}             Exposure Time in Seconds
FILENAME    String  ${OriginalFileName}         Original name of the file
BINX        Integer 1                           [pixels] binning along X axis 
BINY        Integer 1                           [pixels] binning along Y axis 
CCDGAIN     Float   1.0                         Rough guess at overall system gain (e-/DNB)
CCDNOISE    Float   10.0                        Rough guess at system noise (e- rms)
