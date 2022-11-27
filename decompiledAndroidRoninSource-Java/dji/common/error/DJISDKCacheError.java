package dji.common.error;

public class DJISDKCacheError
  extends DJIError
{
  public static final DJISDKCacheError DISCONNECTED;
  public static final DJISDKCacheError INVALID_KEY_FORMAT;
  public static final DJISDKCacheError INVALID_KEY_FOR_COMPONENT;
  public static final DJISDKCacheError INVALID_VALUE = new DJISDKCacheError("Received invalid value");
  public static final DJISDKCacheError KEY_UNSUPPORTED = new DJISDKCacheError("The feature is unsupported.");
  public static final DJISDKCacheError NO_ACTION_FOR_KEY;
  public static final DJISDKCacheError NO_GET_FOR_KEY;
  public static final DJISDKCacheError NO_SET_FOR_KEY;
  public static final DJISDKCacheError NO_STORAGE_ACCESS;
  public static final DJISDKCacheError SETTER_VALUE_TYPE_MISMATCH;
  public static final DJISDKCacheError UNKNOWN_ACCESS_TYPE;
  
  static
  {
    INVALID_KEY_FORMAT = new DJISDKCacheError("The key does not match theformat: component/index/key with index being a number or *.");
    SETTER_VALUE_TYPE_MISMATCH = new DJISDKCacheError("The value type is not correct.");
    INVALID_KEY_FOR_COMPONENT = new DJISDKCacheError("Not Support");
    NO_GET_FOR_KEY = new DJISDKCacheError("The feature is not gettable.");
    NO_SET_FOR_KEY = new DJISDKCacheError("The feature is not settable.");
    UNKNOWN_ACCESS_TYPE = new DJISDKCacheError("The access type requested for thekey unknown. This is an implementation error in the cache as only valid types should be exposedto the public interfaces.");
    DISCONNECTED = new DJISDKCacheError("The abstraction is no longer connected to real hardware.");
    NO_STORAGE_ACCESS = new DJISDKCacheError("Can not access to component storage.");
    NO_ACTION_FOR_KEY = new DJISDKCacheError("The feature is not actionable.");
  }
  
  private DJISDKCacheError(String paramString)
  {
    super(paramString);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\error\DJISDKCacheError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */