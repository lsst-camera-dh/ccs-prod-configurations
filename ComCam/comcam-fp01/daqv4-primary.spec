# Specification file for primary header, DAQv4 specific items
#
# Temporary fix for LSSTCCSRAFTS-488
Basic:DATE-OBS!    Date    ${startIntegrationTime}     Date of the image trigger (readout)
Basic:MJD-OBS!     MJD     ${startIntegrationTime}     Modified Julian Date of image trigger
Basic:DATE-TRG!    Date    ${DAQTriggerTime}           Date of the image trigger (readout), UTC for now
Basic:MJD-TRG!     MJD     ${DAQTriggerTime}           Modified Julian Date of image trigger
#
CommCamInfo:IMAGETAG!    String  ${Tag}                      DAQ Image id (Hex)
CamInfo:CCDSLOT!     String  ${CCDSlot}                  The CCD Slot
CamInfo:RAFTBAY!     String  ${RaftBay}                  The RAFT Bay
CamInfo:FIRMWARE!    String  ${Firmware}                 DAQ firmware version (Hex)
CamInfo:PLATFORM!    String  ${Platform}                 DAQ platform version
CamInfo:CONTNUM!     String  ${CCDControllerSerial|_NULL_} REB serial # (Hex)
CamInfo:DAQVERS!     String  ${DAQVersion}               DAQ version
CamInfo:DAQPART!     String  ${DAQPartition}             DAQ partition
CamInfo:DAQFOLD!     String  ${DAQFolder}                DAQ folder the image was initially created in
CommCamInfo:OBSANNOT!    String  ${DAQAnnotation}            DAQ image annotation
# Elements from the image name, see also TSEIA-79
Basic:OBSID!       String  ${ImageName}                The image name or obs-id
ImgId:CAMCODE!     String  ${ImageSource}              The "code" for AuxTel | ComCam | Main Camera
ImgId:CONTRLLR!    String  ${ImageController}          The controller (e.g. O for OCS, C for CCS)
ImgId:DAYOBS!      String  ${ImageDate}                The observation day as defined in the image name 
ImgId:SEQNUM!      Integer ${ImageNumber}              The sequence number from the image name
