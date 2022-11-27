package dji.internal.version;

import android.content.BroadcastReceiver;
import dji.midware.natives.SDKRelativeJNI;
import dji.thirdparty.afinal.FinalHttp;
import dji.thirdparty.afinal.http.AjaxCallBack;

public class DJIRemoteVersionInfo
  extends BroadcastReceiver
{
  private static boolean DEBUG = false;
  private static final String TAG = "DJIRemoteVersionInfo";
  private static final String keyForBrList = "br_list";
  private static final String keyForDate = "data";
  private static final String keyForList = "list";
  public static final String[] upgradeUrl;
  private static final String urlForBr;
  private static final String urlForBrTest;
  public static final String urlForDate = ;
  private FinalHttp finalHttp;
  private boolean isDownloadRemote = false;
  private String tmpDateStr;
  private String tmpUpgradeConfig;
  private String tmpUpgradeConfigBr;
  private DJIModelUpgradePackList upgradeConfigBrModel = null;
  private String upgradeConfigBrUrl;
  private DJIModelUpgradePackList upgradeConfigReleaseModel = null;
  private String upgradeConfigUrl;
  
  static
  {
    upgradeUrl = new String[] { SDKRelativeJNI.native_getUpgradeUrls0(), SDKRelativeJNI.native_getUpgradeUrls1(), SDKRelativeJNI.native_getUpgradeUrls2() };
    urlForBr = SDKRelativeJNI.native_getUrlForBr();
    urlForBrTest = SDKRelativeJNI.native_getUrlForBrTest();
  }
  
  /* Error */
  private void getDateFile()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static DJIRemoteVersionInfo getInstance()
  {
    return SingletonHolder.instance;
  }
  
  private DJIModelUpgradeDate getLocalDate()
  {
    return null;
  }
  
  private DJIModelUpgradePackList getLocalUpgradeConfig()
  {
    return null;
  }
  
  private DJIModelUpgradePackList getLocalUpgradeConfigBr()
  {
    return null;
  }
  
  private String getLocalValue(String paramString)
  {
    return null;
  }
  
  /* Error */
  private void log(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void setLocalValue(String arg1, String arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  protected void getUpgradeBrConfigFile()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public DJIModelUpgradePackList getUpgradeConfigBrModel()
  {
    return this.upgradeConfigBrModel;
  }
  
  /* Error */
  protected void getUpgradeConfigFile()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public DJIModelUpgradePackList getUpgradeConfigReleaseModel()
  {
    return this.upgradeConfigReleaseModel;
  }
  
  /* Error */
  public void init(android.content.Context arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onReceive(android.content.Context arg1, android.content.Intent arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void uninit(android.content.Context arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  private static final class SingletonHolder
  {
    private static final DJIRemoteVersionInfo instance = new DJIRemoteVersionInfo(null);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\internal\version\DJIRemoteVersionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */