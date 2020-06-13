# Specification file for primary header. Taken from LCA 10140 v1.
# Modified for use with focal-plane
#
HEADVER     Integer 2                           Version number of header
INSTRUME    String  lsstCam                     Instrument
TELESCOP    String  LSST                        Telescope
# Header requested by Merlin, TimJ
TSTAND      String  BOT                         Camera test stand BOT or CCOB
SEQFILE     String  ${focal-plane/${RAFT}/${REB}/sequencerFile}  Sequencer file name
SEQCKSUM    String  ${focal-plane/${RAFT}/${REB}/sequencerChecksum} Checksum of Sequencer
LSST_NUM    String  ${focal-plane/${RAFT}/${REB}/${CCD}/name} LSST Assigned CCD Number
REBNAME     String  ${focal-plane/${RAFT}/${REB}/name} LSST Assigned Name REB name
RAFTNAME    String  ${focal-plane/${RAFT}/name}    LSST Assigned Raft name
DARKTIME    Float   ${DarkTime}                 Dark Time in Seconds (see TSEIA-91)
# Elements from the image name, see also TSEIA-79
OBSID       String  ${ImageName}                The image name or obs-id
TELCODE     String  ${ImageSource}              The "code" for MainCamera
CONTRLLR    String  ${ImageController}          The controller (e.g. O for OCS, C for CCS)
DAYOBS      String  ${ImageDate}                The observation day as defined in the image name 
SEQNUM      Integer ${ImageNumber}              The sequence number from the image name
#
CCDTEMP     Float   ${focal-plane/${RAFT}/${REB}/${CCD_TRENDING}/Temp} Measured temperature (deg C)
TSEQNUM     Integer ${TestSeqNum}                Sequence number within current test
