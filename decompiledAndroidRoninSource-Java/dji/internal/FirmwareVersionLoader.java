package dji.internal;

import dji.sdksharedlib.keycatalog.DJISDKCacheKey;
import dji.sdksharedlib.listener.DJIParamAccessListener;
import dji.sdksharedlib.store.DJISDKCacheParamValue;

public class FirmwareVersionLoader
{
  private static final String DEFAULT = "N/A";
  private static final boolean FIRMWARE_VERSION_DEBUGGABLE = false;
  private static final String SEPARATOR = ".";
  private static FirmwareVersionLoader instance;
  private String batteryFirmwareVersion = "";
  private String cameraFirmwareVersion = "";
  private String flightControllerFirmwareVersion = "";
  private String flightControllerSerialNumber = "";
  private String gimbalFirmwareVersion = "";
  private String remoteControllerFirmwareVersion = "";
  
  private FirmwareVersionLoader()
  {
    startListenToFirmwareVersion();
    startListenToSerialNumber();
  }
  
  private void Log(String paramString) {}
  
  private String extractFirmwareVerionFromData(DJISDKCacheParamValue paramDJISDKCacheParamValue)
  {
    return null;
  }
  
  public static FirmwareVersionLoader getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new FirmwareVersionLoader();
      }
      FirmwareVersionLoader localFirmwareVersionLoader = instance;
      return localFirmwareVersionLoader;
    }
    finally {}
  }
  
  public String getBatteryFirmwareVersion()
  {
    return this.batteryFirmwareVersion;
  }
  
  public String getCameraFirmwareVersion()
  {
    return this.cameraFirmwareVersion;
  }
  
  public String getFlightControllerFirmwareVersion()
  {
    return this.flightControllerFirmwareVersion;
  }
  
  public String getFlightControllerSerialNumber()
  {
    return this.flightControllerSerialNumber;
  }
  
  public String getGimbalFirmwareVersion()
  {
    return this.gimbalFirmwareVersion;
  }
  
  public String getRemoteControllerFirmwareVersion()
  {
    return this.remoteControllerFirmwareVersion;
  }
  
  /* Error */
  public void startListenToFirmwareVersion()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void startListenToSerialNumber()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\internal\FirmwareVersionLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */