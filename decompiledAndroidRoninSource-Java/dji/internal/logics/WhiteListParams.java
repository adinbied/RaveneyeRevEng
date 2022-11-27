package dji.internal.logics;

public class WhiteListParams
{
  private static boolean IS_RUNNING_IN_TEST_ENVIRONMENT = false;
  private static final String LICENSE_SERVER_URL = "https://flysafe-api.dji.com/api/v3/geofence_unlock/whitelist_license";
  private static final String TEST_LICENSE_SERVER_URL = "https://flysafe.aasky.net/api/v3/geofence_unlock/whitelist_license";
  
  public static String getUrl()
  {
    if (IS_RUNNING_IN_TEST_ENVIRONMENT) {
      return "https://flysafe.aasky.net/api/v3/geofence_unlock/whitelist_license";
    }
    return "https://flysafe-api.dji.com/api/v3/geofence_unlock/whitelist_license";
  }
  
  public static void setTestingEnvironmentEnabled(boolean paramBoolean)
  {
    IS_RUNNING_IN_TEST_ENVIRONMENT = paramBoolean;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\internal\logics\WhiteListParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */