TelInfo:OBS-LONG  String _NULL_ [deg] Observatory east longitude
TelInfo:OBS-LAT   String _NULL_ [deg] Observatory latitude
TelInfo:OBS-ELEV  String _NULL_ [m] Observatory elevation
TelInfo:OBSGEO-X  String _NULL_ [m] X-axis Geocentric coordinate
TelInfo:OBSGEO-Y  String _NULL_ [m] Y-axis Geocentric coordinate
TelInfo:OBSGEO-Z  String _NULL_ [m] Z-axis Geocentric coordinate
Pointing:RA        String _NULL_ RA commanded from pointing component
Pointing:DEC       String _NULL_ DEC commanded from pointing component
Pointing:RASTART   String _NULL_ RA of telescope from AZSTART and ELSTART
Pointing:DECSTART  String _NULL_ DEC of telescope from AZSTART and ELSTART
Pointing:RAEND     String _NULL_ RA of telescope from AZEND and ELEND
Pointing:DECEND    String _NULL_ DEC of telescope from AZEND and ELEND
Pointing:ROTPA     String _NULL_ Rotation angle relative to the sky (deg)
Pointing:ROTCOORD  String _NULL_ Telescope Rotation Coordinates
Pointing:HASTART   String _NULL_ [HH:MM:SS] Telescope hour angle at start
Pointing:ELSTART   String _NULL_ [deg] Telescope zenith distance at start
Pointing:AZSTART   String _NULL_ [deg] Telescope azimuth angle at start
Pointing:AMSTART   String _NULL_ Airmass at start
Pointing:AHAEND     String _NULL_ [HH:MM:SS] Telescope hour angle at end
Pointing:AELEND     String _NULL_ [deg] Telescope zenith distance at end
Pointing:AAZEND     String _NULL_ [deg] Telescope azimuth angle at end
Pointing:AAMEND     String _NULL_ Airmass at end
Pointing:TRACKSYS  String _NULL_ Tracking system RADEC, AZEL, PLANET, EPHEM
Pointing:RADESYS   String _NULL_ Equatorial coordinate system FK5 or ICRS
Pointing:FOCUSZ    String _NULL_ Focus Z position
Pointing:OBJECT    String _NULL_ Name of the observed object
Pointing:INSTPORT  String _NULL_ The instrument port where LATISS is installed
Pointing:ATM3PORT  String _NULL_ The port the M3 is directing light into
Pointing:DOMEAZ    String _NULL_ [deg] Dome Azimuth Position
Pointing:SHUTLOWR  String _NULL_ Dome Dropout Door Opening Percentage
Pointing:SHUTUPPR  String _NULL_ Dome Main Door Opening Percentage
Pointing:VIGNETTE  String _NULL_ Is the telescope vignetted?
#
HierInfo:HIERARCH.SIMULATE.ATMCS            String _NULL_ ATMCS Simulation Mode (False=0)
HierInfo:HIERARCH.SIMULATE.ATHEXAPOD        String _NULL_ ATHexapod Simulation Mode (False=0)
HierInfo:HIERARCH.SIMULATE.ATPNEUMATICS     String _NULL_ ATPneumatics Simulation Mode (False=0)
HierInfo:HIERARCH.SIMULATE.ATDOME           String _NULL_ ATDome Simulation Mode (False=0)
HierInfo:HIERARCH.SIMULATE.ATSPECTROGRAPH   String _NULL_ ATSpectrograph Simulation Mode (False=0)
#
Basic:GROUPID   String _NULL_  
Basic:BUNIT     String _NULL_ Brightness units for pixel array

TanProj:WCSAXES   String _NULL_ WCS Dimensionality
TanProj:CTYPE1    String _NULL_ Coordinate type
TanProj:CTYPE2    String _NULL_ Coordinate type
TanProj:CUNIT1    String _NULL_ 
TanProj:CUNIT2    String _NULL_ 
TanProj:CRVAL1    String _NULL_ [deg] WCS Reference Coordinate (RA)
TanProj:CRVAL2    String _NULL_ [deg] WCS Reference Coordinate (DEC)
TanProj:CRPIX1    String _NULL_ Reference pixel axis 1
TanProj:CRPIX2    String _NULL_ Reference pixel axis 2
TanProj:CD1_1     String _NULL_ DL/DX World coordinate transformation matrix
TanProj:CD1_2     String _NULL_ DL/DY World coordinate transformation matrix
TanProj:CD2_1     String _NULL_ DM/DX World coordinate transformation matrix
TanProj:CD2_2     String _NULL_ DM/DY World coordinate transformation matrix
TanProj:EQUINOX   String _NULL_ Equinox of coordinates
FilterGratInfo:GRATING   String _NULL_ Name of physical grating
FilterGratInfo:GRATBAND  String _NULL_ Descriptive name
FilterGratInfo:GRATSLOT  String _NULL_ Grating's slot (1-indexed)
WeathInfo:AIRTEMP   String _NULL_ Position of slide
WeathInfo:PRESSURE  String _NULL_ [Pascals] Atmospheric Pressure
WeathInfo:HUMIDITY  String _NULL_ Percentage of Relative Humidity
WeathInfo:WINDSPD   String _NULL_ [m/s] Wind Speed
WeathInfo:WINDDIR   String _NULL_ [deg] Wind Direction
WeathInfo:SEEING    String _NULL_ [arcsec] Seeing from FWHM DIMM measurement
FilterGratInfo:LINSPOS   String _NULL_ Position of slide
#
# Items which should be coming from CCS but do not seem to be
#
Basic:TIMESYS   String TAI    The time scale used
ImgSeq:CURINDEX  String _NULL_ Index number for exposure within the sequence
ImgSeq:MAXINDEX  String _NULL_ Number of requested images in sequence

AddInfo:PROGRAM   String _NULL_ Name of the program
AddInfo:REASON    String _NULL_ Reason for observation
FilterGratInfo:FILTBAND  String _NULL_ Name of the filter band
FilterGratInfo:FILTER    String _NULL_ Name of the physical filter
FILTPOS   String _NULL_ Filter measured position of slide
FilterGratInfo:FILTSLOT  String _NULL_ Filter home slot
#HeadInfo:FILENAME  String _NULL_ Filename when written
ExpInfo:SHUTTIME  String _NULL_ Shutter exposure time
#Basic:DATE-BEG  String _NULL_ Time at the start of integration
#Basic:DATE-END  String _NULL_ end date of the observation
#Basic:MJD-BEG   String _NULL_ Modified Julian Date derived from DATE-BEG
#Basic:MJD-END   String _NULL_ Modified Julian Date derived from DATE-END
# Temporary workaround
# ExpInfo:DARKTIME  String _NULL_ Dark time

