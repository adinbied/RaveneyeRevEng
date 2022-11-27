package dji.common.error;

import dji.logic.album.model.DJIAlbumPullErrorType;
import dji.midware.data.config.P3.Ccode;

public class DJIError
{
  public static final DJIError BATTERY_GET_SMART_BATTERY_INFO_FAILED = new DJIError("Get smart battery info failed");
  public static final DJIError BATTERY_PAIR_FAILED;
  public static final DJIError CANNOT_PAUSE_STABILIZATION = new DJIError("Can't pause stabilization.");
  public static final DJIError COMMAND_NOT_SUPPORTED_BY_FIRMWARE;
  public static final DJIError COMMON_DISCONNECTED;
  public static final DJIError COMMON_EXECUTION_FAILED = new DJIError("The execution could not be executed.");
  public static final DJIError COMMON_PARAM_ILLEGAL;
  public static final DJIError COMMON_PARAM_INVALID;
  public static final DJIError COMMON_SYSTEM_BUSY = new DJIError("The system is too busy to execute the action");
  public static final DJIError COMMON_TIMEOUT;
  public static final DJIError COMMON_UNDEFINED;
  public static final DJIError COMMON_UNKNOWN;
  public static final DJIError COMMON_UNSUPPORTED;
  public static final DJIError DATABASE_IS_NOT_READY;
  public static final DJIError FIRMWARE_CRC_WRONG;
  public static final DJIError FIRMWARE_LENGTH_WRONG;
  public static final DJIError FIRMWARE_MATCH_WRONG;
  public static final DJIError FIRMWARE_NON_SEQUENCE;
  public static final DJIError FLASH_CLEAR_WRONG;
  public static final DJIError FLASH_FLUSHING;
  public static final DJIError FLASH_WRITE_WRONG;
  public static final DJIError IMAGE_TRANSMITTER_INVALID_PARAMETER;
  public static final DJIError MEDIA_INVALID_REQUEST_TYPE;
  public static final DJIError MEDIA_NO_SUCH_FILE;
  public static final DJIError MEDIA_REQUEST_CLIENT_ABORT;
  public static final DJIError MEDIA_REQUEST_DISCONNECT;
  public static final DJIError MEDIA_REQUEST_SERVER_ABORT;
  public static final DJIError NETWORK_ERROR = new DJIError("Network error");
  public static final DJIError NOT_LOGIN;
  public static final DJIError NO_LICENSE;
  public static final DJIError NO_UNLOCK_AREA_IN_WHITE_LIST;
  public static final DJIError SERIAL_NUMBER_ERROR;
  public static final DJIError TOKEN_ERROR;
  public static final DJIError UNABLE_TO_GET_FIRMWARE_VERSION;
  public static final DJIError UNABLE_TO_GET_FLAGS;
  public static final DJIError UNABLE_TO_GET_FLAG_BUT_RETRY;
  public static final DJIError UPDATE_WRONG;
  private String description;
  
  static
  {
    DATABASE_IS_NOT_READY = new DJIError("Database is not ready");
    SERIAL_NUMBER_ERROR = new DJIError("Serial number error");
    TOKEN_ERROR = new DJIError("Token error.");
    NO_LICENSE = new DJIError("No license");
    NO_UNLOCK_AREA_IN_WHITE_LIST = new DJIError("No unlock area in the white list.");
    NOT_LOGIN = new DJIError("User does not login.");
    COMMON_UNKNOWN = new DJIError("Server error, please contact <dev@dji.com> for help.");
    COMMON_UNDEFINED = new DJIError("Undefined Error");
    COMMON_TIMEOUT = new DJIError("Execution of this process has timed out");
    COMMON_PARAM_ILLEGAL = new DJIError("Param Illegal");
    COMMON_PARAM_INVALID = new DJIError("Param Invalid");
    COMMON_UNSUPPORTED = new DJIError("Not supported");
    COMMON_DISCONNECTED = new DJIError("Disconnected");
    FIRMWARE_NON_SEQUENCE = new DJIError("Firmware pattern number not continuous");
    FIRMWARE_LENGTH_WRONG = new DJIError("Firmware length invalid");
    FIRMWARE_CRC_WRONG = new DJIError("Firmware crc value invalid");
    FLASH_CLEAR_WRONG = new DJIError("Flash clear error ");
    FLASH_WRITE_WRONG = new DJIError("Flash write error ");
    UPDATE_WRONG = new DJIError("Update error");
    FIRMWARE_MATCH_WRONG = new DJIError("Firmware match error ");
    FLASH_FLUSHING = new DJIError("Firmware flushing");
    MEDIA_INVALID_REQUEST_TYPE = new DJIError("Media download result: media downloading request type is invalid");
    MEDIA_NO_SUCH_FILE = new DJIError("Media download result: no such file");
    MEDIA_REQUEST_CLIENT_ABORT = new DJIError("Media download result: the client aborts the downloading");
    MEDIA_REQUEST_SERVER_ABORT = new DJIError("Media download result: the server aborts the downloading");
    MEDIA_REQUEST_DISCONNECT = new DJIError("Media download result: the downloading link disconnects");
    IMAGE_TRANSMITTER_INVALID_PARAMETER = new DJIError("The input parameter is out of bound or invalid.");
    COMMAND_NOT_SUPPORTED_BY_FIRMWARE = new DJIError("The command is not supported by the current firmware version.");
    UNABLE_TO_GET_FIRMWARE_VERSION = new DJIError("Unable to get the firmware version. Note: The sdk will fetch the firmware version from the server so, please ensure you have Internet connectivity before you invoke getVersion().");
    UNABLE_TO_GET_FLAGS = new DJIError("Unable to get the analytics flags from server. Please ensure you have Internet connectivity before you invoke this method.");
    UNABLE_TO_GET_FLAG_BUT_RETRY = new DJIError("Unable to get the analytics flags from server, but retrying.  Please ensure you have Internet connectivity before invoking this method");
    BATTERY_PAIR_FAILED = new DJIError("Unable to pair the batteries");
  }
  
  protected DJIError(String paramString)
  {
    this.description = paramString;
  }
  
  public static DJIError getDJIError(DJIAlbumPullErrorType paramDJIAlbumPullErrorType)
  {
    switch (1.$SwitchMap$dji$logic$album$model$DJIAlbumPullErrorType[paramDJIAlbumPullErrorType.ordinal()])
    {
    default: 
      return COMMON_UNKNOWN;
    case 8: 
      return COMMON_UNKNOWN;
    case 7: 
      return MEDIA_REQUEST_DISCONNECT;
    case 6: 
      return MEDIA_REQUEST_SERVER_ABORT;
    case 5: 
      return MEDIA_REQUEST_CLIENT_ABORT;
    case 4: 
      return COMMON_TIMEOUT;
    case 3: 
      return COMMON_UNKNOWN;
    case 2: 
      return MEDIA_NO_SUCH_FILE;
    }
    return MEDIA_INVALID_REQUEST_TYPE;
  }
  
  public static DJIError getDJIError(Ccode paramCcode)
  {
    switch (1.$SwitchMap$dji$midware$data$config$P3$Ccode[paramCcode.ordinal()])
    {
    default: 
      return COMMON_UNKNOWN;
    case 10: 
      return COMMON_UNDEFINED;
    case 9: 
      return COMMON_UNKNOWN;
    case 8: 
      return COMMON_UNSUPPORTED;
    case 7: 
      return COMMON_PARAM_ILLEGAL;
    case 6: 
      return COMMON_UNKNOWN;
    case 5: 
      return COMMON_TIMEOUT;
    case 4: 
      return COMMON_UNSUPPORTED;
    case 3: 
      return COMMON_UNKNOWN;
    case 2: 
      return COMMON_UNKNOWN;
    }
    return COMMON_TIMEOUT;
  }
  
  public String getDescription()
  {
    return this.description;
  }
  
  public void setDescription(String paramString)
  {
    this.description = paramString;
  }
  
  public String toString()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\error\DJIError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */