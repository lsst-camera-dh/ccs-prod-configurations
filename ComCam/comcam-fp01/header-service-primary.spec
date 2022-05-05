OBS-LONG  String _NULL_ [deg] Observatory east longitude
OBS-LAT   String _NULL_ [deg] Observatory latitude
OBS-ELEV  String _NULL_ [m] Observatory elevation
OBSGEO-X  String _NULL_ [m] X-axis Geocentric coordinate
OBSGEO-Y  String _NULL_ [m] Y-axis Geocentric coordinate
OBSGEO-Z  String _NULL_ [m] Z-axis Geocentric coordinate
RA        String _NULL_ RA commanded from pointing component
DEC       String _NULL_ DEC commanded from pointing component
RASTART   String _NULL_ RA of telescope from AZSTART and ELSTART
DECSTART  String _NULL_ DEC of telescope from AZSTART and ELSTART
RAEND     String _NULL_ RA of telescope from AZEND and ELEND
DECEND    String _NULL_ DEC of telescope from AZEND and ELEND
ROTPA     String _NULL_ Rotation angle relative to the sky (deg)
ROTCOORD  String _NULL_ Telescope Rotation Coordinates
HASTART   String _NULL_ [HH:MM:SS] Telescope hour angle at start
ELSTART   String _NULL_ [deg] Telescope zenith distance at start
AZSTART   String _NULL_ [deg] Telescope azimuth angle at start
AMSTART   String _NULL_ Airmass at start
HAEND     String _NULL_ [HH:MM:SS] Telescope hour angle at end
ELEND     String _NULL_ [deg] Telescope zenith distance at end
AZEND     String _NULL_ [deg] Telescope azimuth angle at end
AMEND     String _NULL_ Airmass at end
TRACKSYS  String _NULL_ Tracking system RADEC, AZEL, PLANET, EPHEM
RADESYS   String _NULL_ Equatorial coordinate system FK5 or ICRS
FOCUSZ    String _NULL_ Focus Z position
OBJECT    String _NULL_ Name of the observed object
#
GROUPID   String _NULL_  
BUNIT     String _NULL_ Brightness units for pixel array
#
# Items which should be coming from CCS but do not seem to be
#
TIMESYS   String TAI    The time scale used
CURINDEX  String _NULL_ Index number for exposure within the sequence
MAXINDEX  String _NULL_ Number of requested images in sequence
PROGRAM   String _NULL_ Name of the program
REASON    String _NULL_ Reason for observation
FILTBAND  String _NULL_ Name of the filter band
FILTER    String _NULL_ Name of the physical filter
FILTPOS   String _NULL_ Filter measured position of slide
FILTSLOT  String _NULL_ Filter home slot
#FILENAME  String _NULL_ Filename when written
SHUTTIME  String _NULL_ Shutter exposure time
#DATE-BEG  String _NULL_ Time at the start of integration
#DATE-END  String _NULL_ end date of the observation
#MJD-BEG   String _NULL_ Modified Julian Date derived from DATE-BEG
#MJD-END   String _NULL_ Modified Julian Date derived from DATE-END
# Temporary workaround
# DARKTIME  String _NULL_ Dark time

