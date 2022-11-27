package dji.pilot.privacy;

import android.content.Context;
import dji.midware.util.ContextUtil;

public class PrivacyConfigManager
  implements IPrivacyConfiguration
{
  private static final String KEY_PRIVACY_CONFIG_VERSION = "key_privacy_config_version";
  private static final int PRIVACY_CONFIG_VERSION = 2;
  private Context mContext = ContextUtil.getContext().getApplicationContext();
  private boolean mNeedCheckPrivacy;
  
  private PrivacyConfigManager()
  {
    initPrivacyCheckState();
  }
  
  public static PrivacyConfigManager getInstance()
  {
    return LazyHolder.INSTANCE;
  }
  
  /* Error */
  private void initPrivacyCheckState()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void finishCheckPrivacyProcess()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean getPrivacyDataState(IPrivacyConfiguration.PrivacyType paramPrivacyType)
  {
    return true;
  }
  
  public boolean isNeedCheckPrivacy()
  {
    return this.mNeedCheckPrivacy;
  }
  
  public void setPrivacyDataState(IPrivacyConfiguration.PrivacyType paramPrivacyType, boolean paramBoolean) {}
  
  public void showPrivacyConfigDialog(Context paramContext, IPrivacyConfiguration.PrivacyType paramPrivacyType, String paramString, boolean paramBoolean, IPrivacyConfiguration.AuthorizeDialogClickListener paramAuthorizeDialogClickListener) {}
  
  private static final class LazyHolder
  {
    private static final PrivacyConfigManager INSTANCE = new PrivacyConfigManager(null);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\pilot\privacy\PrivacyConfigManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */