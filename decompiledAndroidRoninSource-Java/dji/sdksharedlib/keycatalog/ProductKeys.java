package dji.sdksharedlib.keycatalog;

import dji.common.product.Model;
import dji.sdksharedlib.keycatalog.extension.Key;

public class ProductKeys
  extends DJISDKCacheKeys
{
  public static final String COMPONENT_KEY = "Product";
  @Key(accessType=4, type=String.class)
  public static final String FIRMWARE_PACKAGE_VERSION = "FirmwarePackageVersion";
  @Key(accessType=4, type=Boolean.class)
  public static final String HAS_CAMERA_BEEN_ACTIVATED = "HasCameraBeenActivated";
  @Key(accessType=4, type=Boolean.class)
  public static final String HAS_FLIGHT_CONTROLLER_BEEN_ACTIVATED = "HasFlightControllerBeenActivated";
  @Key(accessType=4, type=Boolean.class)
  public static final String HAS_MONITOR = "HasMonitor";
  @Key(accessType=4, type=Boolean.class)
  public static final String HAS_OFDM_MODULE_BEEN_ACTIVATED = "HasOFDMModuleBeenActivated";
  @Key(accessType=4, type=Boolean.class)
  public static final String HAS_REMOTE_CONTROLLER = "HasRemoteController";
  @Key(accessType=4, type=Boolean.class)
  public static final String IS_HANDLED = "IsHandleDevice";
  @Key(accessType=4, type=Boolean.class)
  public static final String IS_HANDLE_DEVICE_MONITOR = "IsHandleDeviceWithMonitor";
  @Key(accessType=4, type=Boolean.class)
  public static final String IS_MONITOR = "IsMonitor";
  @Key(accessType=4, type=Boolean.class)
  public static final String IS_OSMO = "IsOSMO";
  @Key(accessType=4, type=Boolean.class)
  public static final String IS_RONIN = "IsRonin";
  @Key(accessType=4, type=Model.class)
  public static final String MODEL_NAME = "ModelName";
  
  public ProductKeys(String paramString)
  {
    super(paramString);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\keycatalog\ProductKeys.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */