# Specification file for primary header. 
# ComCam specific quantities
#
TelInfo:INSTRUME    String  ComCam                      Instrument
TsInfo:TSTAND       String  EOCCv2_SUM                  Test Stand
TelInfo:TELESCOP    String  "Simonyi Survey Telescope"  Telescope
# Now provided by focal-plane
ImgSeq:CURINDEX  Integer ${MaxIndex} Index number for exposure within the sequence
ImgSeq:MAXINDEX  Integer ${CurIndex} Number of requested images in sequence
Basic:GROUPID   String ${GroupId}
AddInfo:PROGRAM   String ${Program|_NULL_} Name of the program
AddInfo:REASON    String ${Reason|_NULL_} Reason for observation
