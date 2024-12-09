# Specification file for primary header. Taken from LCA 10140 v1.
# Modified for use with focal-plane
#
HeadInfo:HEADVER     Integer 2                           Version number of header
INSTRUME    String  lsstCam                     Instrument
TELESCOP    String  LSST                        Telescope
# Header requested by Merlin, TimJ
TsInfo:TSTAND      String  _NULL_                      Camera test stand BOT or CCOB
SEQFILE!    String  ${focal-plane/${RAFT}/${REB}/sequencerFile}  Sequencer file name
SEQNAME!    String  ${focal-plane/${RAFT}/${REB}/sequencerFile}  Sequencer file name
SEQCKSUM!   String  ${focal-plane/${RAFT}/${REB}/sequencerChecksum} Checksum of Sequencer
LSST_NUM!   String  ${focal-plane/${RAFT}/${REB}/${CCD}/name} LSST Assigned CCD Number
CCD_SERN!   String  ${focal-plane/${RAFT}/${REB}/${CCD}/manSerNum}    Manufacturers’ CCD Serial Number
REBNAME!    String  ${focal-plane/${RAFT}/${REB}_hardware/name} LSST Assigned Name REB name
RAFTNAME!   String  ${focal-plane/${RAFT}/name}    LSST Assigned Raft name
ExpInfo:DARKTIME!   Float   ${darkTime}                 Dark Time in Seconds (see TSEIA-91)
ImgId:EMUIMAGE    String  ${emulatedImage}            Image bring emulated (from 2-day store)
#
Basic:DATE-BEG    Date    ${startIntegrationTime} Time at the start of integration
Basic:MJD-BEG     MJD     ${startIntegrationTime} Modified Julian Date derived from DATE-BEG
Basic:DATE-END    Date    ${endIntegrationTime}   End date of the observation
Basic:MJD-END     MJD     ${endIntegrationTime}   Date derived from DATE-END
#
TSEQNUM     Integer ${TestSeqNum}                Sequence number within current test
#
# CCS versions
FPVERS      String  ${focal-plane/ccsVersions/agent/version}  The focal-plane version number
IHVERS      String  ${${AGENT_NAME}/ccsVersions/agent/version} The image-handling version number
#
# Stutter keywords (CAP-895)
HIERARCH.STUTTER.ROWS      Integer ${StutterRows|_NULL_}     The number of row shifts per stutter
HIERARCH.STUTTER.DELAY     Float ${StutterDelay|_NULL_}      [s] The delay between stutters
HIERARCH.STUTTER.NSHIFTS   Integer ${StutterNShifts|_NULL_}  The number of stutters

