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
Pointing:HAEND     String _NULL_ [HH:MM:SS] Telescope hour angle at end
Pointing:ELEND     String _NULL_ [deg] Telescope zenith distance at end
Pointing:AZEND     String _NULL_ [deg] Telescope azimuth angle at end
Pointing:AMEND     String _NULL_ Airmass at end
Pointing:TRACKSYS  String _NULL_ Tracking system RADEC, AZEL, PLANET, EPHEM
Pointing:RADESYS   String _NULL_ Equatorial coordinate system FK5 or ICRS
Pointing:FOCUSZ    String _NULL_ Focus Z position
Pointing:OBJECT    String _NULL_ Name of the observed object
Pointing:VIGNETTE  String _NULL_ Is the telescope vignetted?
Pointing:VIGN_MIN  String _NULL_ Minimum vignetting?
#
#GROUPID   String _NULL_  
Basic:BUNIT     String _NULL_ Brightness units for pixel array
#
WeathInfo:AIRTEMP   String _NULL_ Position of slide
WeathInfo:PRESSURE  String _NULL_ [Pascals] Atmospheric Pressure
WeathInfo:HUMIDITY  String _NULL_ Percentage of Relative Humidity
WeathInfo:WINDSPD   String _NULL_ [m/s] Wind Speed
WeathInfo:WINDDIR   String _NULL_ [deg] Wind Direction
WeathInfo:SEEING    String _NULL_ [arcsec] Seeing from FWHM DIMM measurement
#
# Items which should be coming from CCS but do not seem to be
#
Basic:TIMESYS   String TAI    The time scale used
#CURINDEX  String _NULL_ Index number for exposure within the sequence
#MAXINDEX  String _NULL_ Number of requested images in sequence
#AddInfo:PROGRAM   String _NULL_ Name of the program
#AddInfo:REASON    String _NULL_ Reason for observation
FilterGratInfo:FILTBAND  String _NULL_ Name of the filter band
FilterGratInfo:FILTER    String _NULL_ Name of the physical filter
FilterGratInfo:FILTPOS   String _NULL_ Filter measured position of slide
FilterGratInfo:FILTSLOT  String _NULL_ Filter home slot
#FILENAME  String _NULL_ Filename when written
ExpInfo:SHUTTIME  String _NULL_ Shutter exposure time
#DATE-BEG  String _NULL_ Time at the start of integration
#DATE-END  String _NULL_ end date of the observation
#MJD-BEG   String _NULL_ Modified Julian Date derived from DATE-BEG
#MJD-END   String _NULL_ Modified Julian Date derived from DATE-END

