package dji.common.error;

import dji.midware.data.config.P3.Ccode;

public class DJICameraError
  extends DJIError
{
  public static final DJICameraError CANNOT_SET_PARAMETERS_IN_THIS_STATE;
  public static final DJICameraError CHECK_PERMISSION_LEVEL1_IS_INVALID;
  public static final DJICameraError COULD_NOT_DELETE_ALL_FILES;
  public static final DJICameraError EXEC_TIMEOUT;
  public static final DJICameraError GET_REMOTE_MEDIA_FAILED;
  public static final DJICameraError GET_THUMBNAIL_FAILED;
  public static final DJICameraError INVALID_PARAMETERS;
  public static final DJICameraError MEDIA_INVALID_REQUEST_TYPE;
  public static final DJICameraError MEDIA_NO_SUBMEDIA_FILES;
  public static final DJICameraError MEDIA_REQUEST_CLIENT_ABORT;
  public static final DJICameraError MEDIA_REQUEST_DISCONNECT;
  public static final DJICameraError MEDIA_REQUEST_SERVER_ABORT;
  public static final DJICameraError NOT_CONNECTED;
  public static final DJICameraError NO_SUCH_MEDIA_FILE;
  public static final DJICameraError PARAMETERS_GET_FAILED;
  public static final DJICameraError PARAMETERS_NOT_AVAILABLE = new DJICameraError("Camera received invalid parameters");
  public static final DJICameraError PARAMETERS_SET_FAILED;
  public static final DJICameraError SD_CARD_ERROR;
  public static final DJICameraError SD_CARD_FULL;
  public static final DJICameraError SD_CARD_NOT_INSERTED;
  public static final DJICameraError SENSOR_ERROR;
  public static final DJICameraError SYSTEM_ERROR;
  public static final DJICameraError UNKNOWN_ERROR = new DJICameraError("Server error, please contact <dev@dji.com> for help.");
  public static final DJICameraError UNSUPPORTED_CMD_STATE;
  
  static
  {
    CHECK_PERMISSION_LEVEL1_IS_INVALID = new DJICameraError("Level 1 API permission is invalid");
    MEDIA_INVALID_REQUEST_TYPE = new DJICameraError("Media download result: media downloading request type is invalid");
    NO_SUCH_MEDIA_FILE = new DJICameraError("Media download result: no such file");
    MEDIA_NO_SUBMEDIA_FILES = new DJICameraError("Sub media fetching result: No sub media files");
    MEDIA_REQUEST_CLIENT_ABORT = new DJICameraError("Media download result: the client aborted the download");
    MEDIA_REQUEST_SERVER_ABORT = new DJICameraError("Media download result: the server aborted the download");
    MEDIA_REQUEST_DISCONNECT = new DJICameraError("Media download result: the download link disconnected");
    COULD_NOT_DELETE_ALL_FILES = new DJICameraError("Could not delete all files");
    CANNOT_SET_PARAMETERS_IN_THIS_STATE = new DJICameraError("Cannot set the parameters in this state");
    GET_REMOTE_MEDIA_FAILED = new DJICameraError("Get remote media failed");
    GET_THUMBNAIL_FAILED = new DJICameraError("Failed to get the thumbnail");
    NOT_CONNECTED = new DJICameraError("Connection is not ok");
    EXEC_TIMEOUT = new DJICameraError("Camera's execution of this action has timed out");
    INVALID_PARAMETERS = new DJICameraError("Camera received invalid parameters");
    UNSUPPORTED_CMD_STATE = new DJICameraError("Camera is busy or the command is not supported in the Camera's current state");
    PARAMETERS_SET_FAILED = new DJICameraError("Camera failed to set the parameters it received");
    PARAMETERS_GET_FAILED = new DJICameraError("Camera param get failed");
    SD_CARD_NOT_INSERTED = new DJICameraError("Camera has no SD Card");
    SD_CARD_FULL = new DJICameraError("The Camera's SD Card is full");
    SD_CARD_ERROR = new DJICameraError("Error accessing the SD Card");
    SENSOR_ERROR = new DJICameraError("Camera sensor error");
    SYSTEM_ERROR = new DJICameraError("Camera system error ");
  }
  
  private DJICameraError(String paramString)
  {
    super(paramString);
  }
  
  public static DJIError getDJIError(Ccode paramCcode)
  {
    if (COMMON_UNKNOWN != DJIError.getDJIError(paramCcode)) {
      return DJIError.getDJIError(paramCcode);
    }
    switch (1.$SwitchMap$dji$midware$data$config$P3$Ccode[paramCcode.ordinal()])
    {
    default: 
      return UNKNOWN_ERROR;
    case 9: 
      return UNSUPPORTED_CMD_STATE;
    case 8: 
      return INVALID_PARAMETERS;
    case 7: 
      return PARAMETERS_NOT_AVAILABLE;
    case 6: 
      return UNKNOWN_ERROR;
    case 5: 
      return SD_CARD_ERROR;
    case 4: 
      return SD_CARD_FULL;
    case 3: 
      return SD_CARD_ERROR;
    case 2: 
      return PARAMETERS_GET_FAILED;
    }
    return PARAMETERS_SET_FAILED;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\error\DJICameraError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */