package dji.common.error;

public class DJISDKError
  extends DJIError
{
  public static final DJISDKError APPLICATION_NOT_ACTIVATED;
  public static final DJISDKError APP_KEY_INVALID_PLATFORM;
  public static final DJISDKError APP_KEY_LEVEL_NOT_PERMITTED;
  public static final DJISDKError APP_KEY_NOT_EXIST;
  public static final DJISDKError APP_KEY_PROHIBITED;
  public static final DJISDKError BUNDLE_NOT_MATCH;
  public static final DJISDKError COMMAND_EXECUTION_FAILED;
  public static final DJISDKError CONNECTION_TO_SDK_FAILED;
  public static final DJISDKError COULD_NOT_CONNECT_TO_INTERNET;
  public static final DJISDKError DEVICE_NOT_FOUND = new DJISDKError("Device is not connected or does not exist.");
  public static final DJISDKError DEVICE_NOT_MATCH;
  public static final DJISDKError EMPTY_APP_KEY;
  public static final DJISDKError FEATURE_NOT_SUPPORTED = new DJISDKError("This feature is not supported in the SDK");
  public static final DJISDKError HTTP_TIMEOUT;
  public static final DJISDKError INVALID_APP_KEY;
  public static final DJISDKError INVALID_METADATA;
  public static final DJISDKError INVALID_PARAMETERS;
  public static final DJISDKError MAX_ACTIVATION_COUNT_REACHED;
  public static final DJISDKError NOT_DEFINED;
  public static final DJISDKError PARAMETER_GET_FAILED;
  public static final DJISDKError PARAMETER_SET_FAILED;
  public static final DJISDKError REGISTRATION_AESENCRYPT_ERROR;
  public static final DJISDKError REGISTRATION_AESENCRYPT_FAILED;
  public static final DJISDKError REGISTRATION_INVALID_UUID;
  public static final DJISDKError REGISTRATION_SUCCESS;
  public static final DJISDKError SEND_DATA_FAILED;
  public static final DJISDKError SERVER_DATA_ABNORMAL;
  public static final DJISDKError SERVER_PARSE_FAILURE;
  public static final DJISDKError SERVER_WRITE_FAILURE;
  public static final DJISDKError SYSTEM_BUSY;
  public static final DJISDKError UNKNOWN;
  
  static
  {
    APPLICATION_NOT_ACTIVATED = new DJISDKError("Application is not registered");
    SYSTEM_BUSY = new DJISDKError("System is busy, please retry later");
    INVALID_PARAMETERS = new DJISDKError("The parameters are invalid. Please review and submit the request");
    PARAMETER_GET_FAILED = new DJISDKError("Getting parameters operation failed");
    PARAMETER_SET_FAILED = new DJISDKError("Setting parameters operation failed");
    COMMAND_EXECUTION_FAILED = new DJISDKError("There was an error executing the command");
    SEND_DATA_FAILED = new DJISDKError("There was an error sending the data");
    CONNECTION_TO_SDK_FAILED = new DJISDKError("There was an error connecting to the SDK");
    NOT_DEFINED = new DJISDKError("Not defined error.");
    REGISTRATION_SUCCESS = new DJISDKError("API Key successfully registered");
    COULD_NOT_CONNECT_TO_INTERNET = new DJISDKError("For first time registration, app should be connected to Internet.");
    INVALID_APP_KEY = new DJISDKError("The app key submitted is invalid. Please check the app key you provided.");
    HTTP_TIMEOUT = new DJISDKError("The server may be busy or is not reachable.");
    DEVICE_NOT_MATCH = new DJISDKError("Attempt to copy metadata from another registered device is not permitted.");
    BUNDLE_NOT_MATCH = new DJISDKError("The bundle identifier of your app should be identical to the one you registered on the website.");
    APP_KEY_PROHIBITED = new DJISDKError("The app key is prohibited, please contact <dev@dji.com> for help.");
    MAX_ACTIVATION_COUNT_REACHED = new DJISDKError("The app key reached maximum number of activations, please contact <dev@dji.com> for help.");
    APP_KEY_INVALID_PLATFORM = new DJISDKError("The app key is not valid for this platform.");
    APP_KEY_NOT_EXIST = new DJISDKError("The app key does not exist. Please check the app key you provided.");
    APP_KEY_LEVEL_NOT_PERMITTED = new DJISDKError("The app key does not have the required permission.");
    SERVER_PARSE_FAILURE = new DJISDKError("Server error, please contact <dev@dji.com> for help.");
    SERVER_WRITE_FAILURE = new DJISDKError("Server error, please contact <dev@dji.com> for help.");
    SERVER_DATA_ABNORMAL = new DJISDKError("Server error, please contact <dev@dji.com> for help.");
    INVALID_METADATA = new DJISDKError("The metadata received from server is invalid, please reconnect to the server and try.");
    EMPTY_APP_KEY = new DJISDKError("The app key was not provided.");
    REGISTRATION_AESENCRYPT_FAILED = new DJISDKError("Server error, please contact <dev@dji.com> for help");
    REGISTRATION_AESENCRYPT_ERROR = new DJISDKError("Server error, please contact <dev@dji.com> for help.");
    REGISTRATION_INVALID_UUID = new DJISDKError("Server error, please contact <dev@dji.com> for help.");
    UNKNOWN = new DJISDKError("Unknown error occurred during registration");
  }
  
  private DJISDKError(String paramString)
  {
    super(paramString);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\error\DJISDKError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */