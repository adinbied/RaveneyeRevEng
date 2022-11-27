package dji.midware.encryption.util;

import org.json.JSONArray;

public class FeatureFlagEngine
{
  private static final String AIRCRAFT_SN = "aicraft_sn";
  private static final String APP_KEY = "app_key";
  private static final String FEATURES = "features";
  private static final String LICENSED_TO = "licensed_to";
  private static final String PHONE = "phone";
  private static final String SILENT_MODE = "silent_mode";
  private static final String TAG = FeatureFlagEngine.class.getSimpleName();
  private String connectedAircraftSerial;
  private String connectedAppKey;
  private String loadedLicenseContent;
  
  public static FeatureFlagEngine getInstance()
  {
    return LazyHolder.INSTANCE;
  }
  
  private JSONArray getLicensedAircraftSerialNumber()
  {
    return null;
  }
  
  private String getLicensedAppKey()
  {
    return null;
  }
  
  public boolean doesLicenseHaveAircraftSerial()
  {
    return false;
  }
  
  public boolean doesLicenseHaveAppKey()
  {
    return false;
  }
  
  public String getLicenseOwner()
  {
    return null;
  }
  
  public String getPhoneNum()
  {
    return null;
  }
  
  public boolean isLicenseLoaded()
  {
    return false;
  }
  
  public boolean isLicenseValid()
  {
    return false;
  }
  
  public boolean isSilentModeRequired()
  {
    return false;
  }
  
  /* Error */
  public void loadRawLicenseFileContent(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void setConnectedAircraftSerial(String paramString)
  {
    this.connectedAircraftSerial = paramString;
  }
  
  public void setConnectedAppKey(String paramString)
  {
    this.connectedAppKey = paramString;
  }
  
  private static class LazyHolder
  {
    private static final FeatureFlagEngine INSTANCE = new FeatureFlagEngine(null);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\encryptio\\util\FeatureFlagEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */