package dji.pilot.usercenter;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.dji.basic.countrycode.contorller.CountryCodeGetter;
import com.dji.basic.countrycode.contorller.CountryCodeGetter.CountryCodeGetterCallBack;
import com.dji.basic.download.DJIFileDownloadManager.OnDownLoadListener;
import dji.midware.data.config.P3.ProductType;
import dji.midware.data.manager.P3.DJIProductManager;
import dji.midware.data.manager.P3.ServiceManager;
import dji.pilot.usercenter.mode.AccountCenterBaseResponse;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;

public class DJIMemberManager
  implements IMemberProtocol
{
  private static final boolean DEBUG = false;
  private static final String KEY_AUTH_COOKIE_KEY = "key_auth_cookie_key";
  private static final String KEY_AUTH_COOKIE_NAME = "key_auth_cookie_name";
  private static final String KEY_AVATAR = "user_avatar.png";
  private static final String KEY_EMAIL = "key_account_email";
  private static final String KEY_ID = "key_account_id";
  private static final String KEY_IS_REGISTER_BY_PHONE = "key_account_is_register_phone";
  private static final String KEY_IS_TOKEN_VALID = "key_account_is_token_valid";
  private static final String KEY_NICKNAME = "key_account_nickname";
  private static final String KEY_PHONE = "key_account_phone";
  private static final String KEY_PHONE_AREA = "key_account_phone_area";
  private static final String KEY_TOKEN = "key_account_token";
  private static final String KEY_UID = "key_account_uid";
  private static final String KEY_VIP_LEVEL = "key_vip_level";
  private static final String KEY_WORD = "key_account_word";
  private static final String TAG = DJIMemberManager.class.getSimpleName();
  public static final int TOKEN_STATE_INVALID = 2;
  public static final int TOKEN_STATE_LOGIN = 1;
  public static final int TOKEN_STATE_NOT_LOGIN = 0;
  private Context mAppCxt = null;
  private volatile boolean mAvatarDownloaded = false;
  private DJIFileDownloadManager.OnDownLoadListener mDownLoadListener = null;
  private final ArrayList<IProtocol.OnDataResultListener> mExtraResultListeners = new ArrayList(4);
  private final MemberHandler mHandler = new MemberHandler(this);
  private final IProtocol.OnDataResultListener mHttpListener = new IProtocol.OnDataResultListener()
  {
    /* Error */
    public void onFail(int arg1, int arg2, int arg3, Object arg4)
    {
      // Byte code:
      //   0: return
      //   1: astore 4
      //   3: goto -3 -> 0
    }
    
    public void onStart(int paramAnonymousInt1, boolean paramAnonymousBoolean, int paramAnonymousInt2, Object paramAnonymousObject) {}
    
    public void onSuccess(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, Object paramAnonymousObject1, Object paramAnonymousObject2)
    {
      if (paramAnonymousInt1 != 196640) {
        DJIMemberManager.this.mHandler.obtainMessage(65536, paramAnonymousInt1, 0, paramAnonymousObject1).sendToTarget();
      }
    }
    
    public void onUpate(int paramAnonymousInt1, long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt2, Object paramAnonymousObject) {}
  };
  private volatile boolean mInit = false;
  private final MemberInfo mMemberInfo = new MemberInfo();
  private final MemberInfo mMemberInfoCache = new MemberInfo();
  private OnTokenInvalidListener mOnTokenInvalidListener = null;
  private volatile boolean mProfileGetted = false;
  private final MemberInfo mProfileInfo = new MemberInfo();
  private Map<String, String> mTmpProfileMap = null;
  private int mTokenState = 0;
  private boolean mbLogined = false;
  
  private boolean canDo()
  {
    return this.mInit;
  }
  
  public static boolean checkNetAvaiable(Context paramContext)
  {
    paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramContext != null)
    {
      bool1 = bool2;
      if (paramContext.isAvailable()) {
        if (DJIProductManager.getInstance().getType().isFromWifi())
        {
          bool1 = bool2;
          if (ServiceManager.getInstance().isConnected()) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  /* Error */
  private void clearMemberInfo()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void copyMemberInfo(MemberResponse arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void copyMemberInfoFromMap(Map<String, String> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static DJIMemberManager getInstance()
  {
    return SingletonHolder.mInstance;
  }
  
  private IProtocol.OnDataResultListener getOnDataResultListener()
  {
    return null;
  }
  
  /* Error */
  private void handleResultFail(int arg1, int arg2, Object arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void handleResultSuccess(int arg1, int arg2, Object arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  private boolean isEmpty(String paramString)
  {
    return (paramString == null) || (paramString.trim().length() == 0);
  }
  
  private static void log(String paramString, Object... paramVarArgs) {}
  
  /* Error */
  private void onCheckCountryFinish(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void saveMemberInfo()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void accountCenterLoginByEmail(String paramString1, String paramString2)
  {
    accountCenterLoginByEmailWithCaptcha(paramString1, paramString2, null, null);
  }
  
  /* Error */
  public void accountCenterLoginByEmailWithCaptcha(String arg1, String arg2, String arg3, String arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void accountCenterLoginByPhone(String arg1, String arg2, String arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void accountCenterLoginByPhoneWithCaptcha(String arg1, String arg2, String arg3, String arg4, String arg5)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Deprecated
  public void checkEmailvalid(String arg1, String arg2, String arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void checkTokenIvalidate(Context arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void finalizeMM()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void forgetpassword(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public String getAccount()
  {
    return null;
  }
  
  public String getAvatarFilePath()
  {
    return null;
  }
  
  public String getEmail()
  {
    return this.mMemberInfo.mUsedEmail;
  }
  
  public MemberInfo getMemberInfo()
  {
    return null;
  }
  
  public String getPhone()
  {
    return this.mMemberInfo.mPhoneNumber;
  }
  
  public String getPhoneArea()
  {
    return this.mMemberInfo.mPhoneArea;
  }
  
  public MemberInfo getProfileInfo()
  {
    return this.mProfileInfo;
  }
  
  public String getToken()
  {
    return this.mMemberInfo.mToken;
  }
  
  public int getTokenState()
  {
    return this.mTokenState;
  }
  
  public String getUID()
  {
    return this.mMemberInfo.mUid;
  }
  
  public String getUserId()
  {
    return this.mMemberInfo.mId;
  }
  
  @Deprecated
  public String getUserInputEmail()
  {
    return this.mMemberInfo.mEmail;
  }
  
  public String getUserName()
  {
    return null;
  }
  
  /* Error */
  public void handleTokenInvalid(boolean arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void initAccount(boolean arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void initializeMM(Context arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public boolean isLogined()
  {
    return this.mbLogined;
  }
  
  public boolean isPhoneRegistered()
  {
    return this.mMemberInfo.mIsPhoneRegister;
  }
  
  public boolean isProfileGetted()
  {
    return this.mProfileGetted;
  }
  
  /* Error */
  public void logoutByNoWeb()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void logoutByWeb(IProtocol.OnDataResultListener arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onLogOut(Context arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void registerByEmail(String arg1, String arg2, String arg3, String arg4, String arg5, boolean arg6)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void registerByEmail(String arg1, String arg2, boolean arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void registerByPhone(String arg1, String arg2, String arg3, String arg4, String arg5)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean registerResultListener(IProtocol.OnDataResultListener paramOnDataResultListener)
  {
    return false;
  }
  
  public void registerTokenListener(OnTokenInvalidListener paramOnTokenInvalidListener)
  {
    this.mOnTokenInvalidListener = paramOnTokenInvalidListener;
  }
  
  public void syncProfileInfo()
  {
    this.mProfileInfo.copyOf(this.mMemberInfo);
  }
  
  public boolean unregisterResultListener(IProtocol.OnDataResultListener paramOnDataResultListener)
  {
    return false;
  }
  
  public void unregisterTokenListener()
  {
    this.mOnTokenInvalidListener = null;
  }
  
  private static final class MemberHandler
    extends Handler
  {
    private final WeakReference<DJIMemberManager> mOutCls;
    
    public MemberHandler(DJIMemberManager paramDJIMemberManager)
    {
      super();
      this.mOutCls = new WeakReference(paramDJIMemberManager);
    }
    
    /* Error */
    public void handleMessage(Message arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  public static abstract interface OnTokenInvalidListener
  {
    public abstract void onTokenInvalid(String paramString, Object paramObject);
  }
  
  private static final class SingletonHolder
  {
    private static final DJIMemberManager mInstance = new DJIMemberManager(null);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\pilo\\usercenter\DJIMemberManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */