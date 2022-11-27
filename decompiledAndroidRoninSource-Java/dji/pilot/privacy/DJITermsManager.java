package dji.pilot.privacy;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.reflect.TypeToken;
import java.util.List;

public class DJITermsManager
{
  private static final String TERMS_SETTING_NEED_UPLOAD = "need_upload";
  private static final String TERMS_SETTING_PREFERENCES = "terms_setting_preferences";
  private static final String TERMS_SETTING_SHOW_AGREED = "show_agreed";
  private static final String TERMS_SETTING_TERMS_DATE = "terms_date";
  private static final String TERMS_SETTING_TERMS_VER = "terms_ver";
  private static final String TERMS_SETTING_USERS_AGREED = "users_agreed";
  private static DJITermsManager mInstance;
  private Context mContext = null;
  private SharedPreferences mPreferences;
  
  private DJITermsManager(Context paramContext)
  {
    this.mContext = paramContext;
    this.mPreferences = paramContext.getSharedPreferences("terms_setting_preferences", 4);
  }
  
  public static DJITermsManager createInstance(Context paramContext)
  {
    if (mInstance == null) {
      mInstance = new DJITermsManager(paramContext);
    }
    return mInstance;
  }
  
  public static DJITermsManager getInstance()
  {
    return mInstance;
  }
  
  /* Error */
  public void addTermsRecord(String arg1, String arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void addUserAgreed(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void clearTermsAgreed()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean isUaserAgreedEmpty()
  {
    return false;
  }
  
  public boolean isUserAgreed(String paramString)
  {
    return false;
  }
  
  /* Error */
  public void setNeedUpload()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean shouldShowTerms()
  {
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\pilot\privacy\DJITermsManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */