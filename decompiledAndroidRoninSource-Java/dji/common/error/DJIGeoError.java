package dji.common.error;

import dji.midware.data.config.P3.Ccode;

public class DJIGeoError
  extends DJIError
{
  public static final DJIGeoError ACCOUNT_NOT_LOG_IN_OR_NOT_AUTHORIZED;
  public static final DJIGeoError COULD_NOT_CONNECT_TO_INTERNET_FOR_PULLING_DATA = new DJIGeoError("Could not connect to the Internet while SDK try to pull the latest cached data from server.");
  public static final DJIGeoError COULD_NOT_ENABLE_OR_DISABLE_GEO_SYSTEM_WHILE_AIRCRAFT_IS_IN_THE_SKY = new DJIGeoError("Could not enable or disable the GEO system while the aircraft is flying.");
  public static final DJIGeoError COULD_NOT_FIND_UNLOCKED_RECORD_IN_THE_SERVER = new DJIGeoError("Could not find unlocked record in the server.");
  public static final DJIGeoError FLIGHT_CONTROLLER_SERIAL_NUMBER_IS_NOT_READY;
  public static final DJIGeoError INVALID_SIMULATED_LOCATION = new DJIGeoError("INVALID simulation location.");
  public static final DJIGeoError NOT_LOGGED_IN;
  public static final DJIGeoError NO_DATA_IN_DATABASE = new DJIGeoError("No data in database");
  
  static
  {
    NOT_LOGGED_IN = new DJIGeoError("No logged in account.");
    ACCOUNT_NOT_LOG_IN_OR_NOT_AUTHORIZED = new DJIGeoError("No logged in account or account did not get authorization.");
    FLIGHT_CONTROLLER_SERIAL_NUMBER_IS_NOT_READY = new DJIGeoError("The flight controller SN is not ready, could not start to execute next step, please try again later.");
  }
  
  private DJIGeoError(String paramString)
  {
    super(paramString);
  }
  
  public static DJIError getDJIError(Ccode paramCcode)
  {
    if (COMMON_UNKNOWN != DJIError.getDJIError(paramCcode)) {
      return DJIError.getDJIError(paramCcode);
    }
    if (1.$SwitchMap$dji$midware$data$config$P3$Ccode[paramCcode.ordinal()] != 1) {
      return COMMON_UNKNOWN;
    }
    return COMMON_TIMEOUT;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\error\DJIGeoError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */