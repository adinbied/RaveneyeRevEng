package dji.midware.natives;

import dji.log.RoninLog;

public class SDKRelativeJNI
{
  static
  {
    try
    {
      System.loadLibrary("SDKRelativeJNI");
      RoninLog.d("SDKRelativeJNI", "load lib suc", new Object[0]);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      localUnsatisfiedLinkError.printStackTrace();
      RoninLog.d("SDKRelativeJNI", "Couldn't load lib", new Object[0]);
    }
  }
  
  public static native String native_get1860DbDownloadedFileName();
  
  public static native String native_get1860DbDownloadedFileNameForTesting();
  
  public static native String native_get1860PolygonDbDecryptedFileName();
  
  public static native String native_getBatteryBanSnListUrl();
  
  public static native String native_getBatteryValidatingSPKey();
  
  public static native String native_getDbEncryptionAc();
  
  public static native String native_getEncryptedLocalDbFileName();
  
  public static native String native_getGeo1860DbAESKeys();
  
  public static native String native_getGeo1860DbSDKSignatureKeys();
  
  public static native String native_getGeoAESKeys();
  
  public static native String native_getGeoAirmapApiKey();
  
  public static native String native_getGeoAirmapDataUrl();
  
  public static native String native_getGeoAirmapFileName();
  
  public static native String native_getGeoAirmapUuid();
  
  public static native String native_getGeoAndroidKey();
  
  public static native String native_getGeoDjiFileName();
  
  public static native String native_getGeoDjiFileUuid();
  
  public static native String native_getGeoFlyForbidUrl();
  
  public static native String native_getGeoMobileUnlockAreasUrl();
  
  public static native String native_getGeoNoFlyZonesUrl();
  
  public static native String native_getGeoSignatureKey();
  
  public static native String native_getLicenseUnlockList();
  
  public static native String native_getRemoteServerDevUrl();
  
  public static native String native_getRemoteServerDevUserName();
  
  public static native String native_getRemoteServerProdUrl();
  
  public static native String native_getRemoteServerProdUserName();
  
  public static native String native_getRemoteServerStageUrl();
  
  public static native String native_getRemoteServerStageUserName();
  
  public static native String native_getRequestKey();
  
  public static native String native_getSDKConfigFileName();
  
  public static native String native_getServerUrl();
  
  public static native String native_getStatTestUrl();
  
  public static native String native_getSync1860DbFromServerApi();
  
  public static native String native_getSync1860DbFromTestingServerApi();
  
  public static native String native_getSyncFileFromServerApi();
  
  public static native String native_getUnlimitListUrl();
  
  public static native String native_getUpgradeUrls0();
  
  public static native String native_getUpgradeUrls1();
  
  public static native String native_getUpgradeUrls2();
  
  public static native String native_getUrlForBr();
  
  public static native String native_getUrlForBrTest();
  
  public static native String native_getUrlForDate();
  
  public static native String native_getUsbAccessoryAttachedString();
  
  public static native boolean native_isRunningIVT(String paramString);
  
  public static native boolean native_isSDKActivated();
  
  public static native int native_startRegistration(String paramString1, String paramString2, String paramString3);
  
  public static native int native_startRegistrationWithoutInternet(String paramString1, String paramString2);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\natives\SDKRelativeJNI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */