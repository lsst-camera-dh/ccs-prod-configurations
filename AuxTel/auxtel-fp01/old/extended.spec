# Specification file for extended header. Taken from LCA 13501 from June 8th 2016
#
INHERIT     Boolean true                Extension inherits values from primary header
#
NAXIS       Integer ${NAXIS}            number of axis
NAXIS1      Integer ${NAXIS1}           size of the n'th axis
NAXIS2      Integer ${NAXIS2}           size of the n'th axis
CHANNEL     Integer ${CHANNEL}
EXTNAME     String  ${EXTNAME}
CCDSUM      String  ${CCDSUM}
AVERAGE     Float   ${AVERAGE}
AVGBIAS     Float   ${AVGBIAS}
AVWOBIAS    Float   ${AVWOBIAS}
STDVBIAS    Float   ${STDVBIAS}
STDEV       Float   ${STDEV}
# Mosaic coodinate keywords
DATASEC     String  ${DATASEC}
DETSEC      String  ${DETSEC}
DETSIZE     String  ${DETSIZE}
DTV1        Integer ${DTV1}           detector transformation vector
DTV2        Integer ${DTV2}           detector transformation vector
DTM1_1      Float   ${DTM1_1}         detector transformation matrix
DTM2_2      Float   ${DTM2_2}         detector transformation matrix
DTM1_2      Float   ${DTM1_2}         detector transformation matrix
DTM2_1      Float   ${DTM2_1}         detector transformation matrix
# WCS keywords
WCSNAMEA    String  "AMPLIFIER"       Name of coordinate system
CTYPE1A     String  "Seg_X"           In the camera coordinate system
CTYPE2A     String  "Seg_Y"           In the camera coordinate system
PC1_1A      Float   ${PC1_1A}
PC1_2A      Float   ${PC1_2A}
PC2_1A      Float   ${PC2_1A}
PC2_2A      Float   ${PC2_2A}
CDELT1A     Float   ${CDELT1A}
CDELT2A     Float   ${CDELT2A}
CRPIX1A     Float   ${CRPIX1A}
CRPIX2A     Float   ${CRPIX2A}
CRVAL1A     Float   ${CRVAL1A}
CRVAL2A     Float   ${CRVAL2A}
WCSNAMEC    String  "CCD"             Name of coordinate system
CTYPE1C     String  "CCD_X"           In the camera coordinate system
CTYPE2C     String  "CCD_Y"           In the camera coordinate system
PC1_1C      Float   ${PC1_1C}
PC1_2C      Float   ${PC1_2C}
PC2_1C      Float   ${PC2_1C}
PC2_2C      Float   ${PC2_2C}
CDELT1C     Float   ${CDELT1C}
CDELT2C     Float   ${CDELT2C}
CRPIX1C     Float   ${CRPIX1C}
CRPIX2C     Float   ${CRPIX2C}
CRVAL1C     Float   ${CRVAL1C}
CRVAL2C     Float   ${CRVAL2C}
WCSNAMER    String  "RAFT"            Name of coordinate system
CTYPE1R     String  "RAFT_X"          In the camera coordinate system
CTYPE2R     String  "RAFT_Y"          In the camera coordinate system
PC1_1R      Float   ${PC1_1R}
PC1_2R      Float   ${PC1_2R}
PC2_1R      Float   ${PC2_1R}
PC2_2R      Float   ${PC2_2R}  
CDELT1R     Float   ${CDELT1R}
CDELT2R     Float   ${CDELT2R}
CRPIX1R     Float   ${CRPIX1R}
CRPIX2R     Float   ${CRPIX2R}
CRVAL1R     Float   ${CRVAL1R}
CRVAL2R     Float   ${CRVAL2R}
WCSNAMEF    String  "FOCAL_PLANE"     Name of coordinate system
CTYPE1F     String  "FP_X"            In the camera coordinate system
CTYPE2F     String  "FP_Y"            In the camera coordinate system
PC1_1F      Float   ${PC1_1F}
PC1_2F      Float   ${PC1_2F}
PC2_1F      Float   ${PC2_1F}
PC2_2F      Float   ${PC2_2F}  
CDELT1F     Float   ${CDELT1F}
CDELT2F     Float   ${CDELT2F}
CRPIX1F     Float   ${CRPIX1F}
CRPIX2F     Float   ${CRPIX2F}
CRVAL1F     Float   ${CRVAL1F}
CRVAL2F     Float   ${CRVAL2F}
WCSNAMEE    String  "FP_SERPAR"       Name of coordinate system
CTYPE1E     String  "FP_S"            In the camera coordinate system
CTYPE2E     String  "FP_P"            In the camera coordinate system
PC1_1E      Float   ${PC1_1E}
PC1_2E      Float   ${PC1_2E}
PC2_1E      Float   ${PC2_1E}
PC2_2E      Float   ${PC2_2E}  
CDELT1E     Float   ${CDELT1E}
CDELT2E     Float   ${CDELT2E}
CRPIX1E     Float   ${CRPIX1E}
CRPIX2E     Float   ${CRPIX2E}
CRVAL1E     Float   ${CRVAL1E}
CRVAL2E     Float   ${CRVAL2E}
WCSNAMEB    String  "CCD_SERPAR"      Name of coordinate system
CTYPE1B     String  "CCD_S"           In the serial-parallel coordinate system
CTYPE2B     String  "CCD_P"           In the serial-parallel coordinate system
PC1_1B      Float   ${PC1_1B}
PC1_2B      Float   ${PC1_2B}
PC2_1B      Float   ${PC2_1B}
PC2_2B      Float   ${PC2_2B}  
CDELT1B     Float   ${CDELT1B}
CDELT2B     Float   ${CDELT2B}
CRPIX1B     Float   ${CRPIX1B}
CRPIX2B     Float   ${CRPIX2B}
CRVAL1B     Float   ${CRVAL1B}
CRVAL2B     Float   ${CRVAL2B}
WCSNAMEQ    String  "RAFT_SERPAR"     Name of coordinate system
CTYPE1Q     String  "RAFT_S"          In the serial-parallel coordinate system
CTYPE2Q     String  "RAFT_P"          In the serial-parallel coordinate system
PC1_1Q      Float   ${PC1_1Q}
PC1_2Q      Float   ${PC1_2Q}
PC2_1Q      Float   ${PC2_1Q}
PC2_2Q      Float   ${PC2_2Q}  
CDELT1Q     Float   ${CDELT1Q}
CDELT2Q     Float   ${CDELT2Q}
CRPIX1Q     Float   ${CRPIX1Q}
CRPIX2Q     Float   ${CRPIX2Q}
CRVAL1Q     Float   ${CRVAL1Q}
CRVAL2Q     Float   ${CRVAL2Q}
