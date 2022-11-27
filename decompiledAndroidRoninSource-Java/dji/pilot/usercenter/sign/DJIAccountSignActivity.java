package dji.pilot.usercenter.sign;

import android.app.Activity;

public class DJIAccountSignActivity
  extends Activity
  implements FragmentChangeContract.GotoSignIn, FragmentChangeContract.GotoSignUp
{
  public static final int EXPLORE_LIKE_LOGIN_REQUEST_CODE = 3;
  private static final int INTERVAL_BACK = 2000;
  public static final String KEY_FROM_NFZ = "key_from_nfz";
  public static final String KEY_GOTO = "key_goto";
  public static final String KEY_GOTO_CLASS = "key_goto_class";
  public static final String KEY_TYPE = "key_type";
  public static final int REQUEST_CODE_INVALIDATE_TOKEN = 1007;
  public static final String TAG = "DJIAccountSignActivity";
  public static final int TYPE_GOTO_FLYRECORD = 1006;
  public static final int TYPE_GOTO_INTENT_CLASS = 1010;
  public static final int TYPE_GOTO_MINE_SETTING = 1008;
  public static final int TYPE_GOTO_NOWHERE = 1003;
  public static final int TYPE_GOTO_SET_RESULT = 1009;
  public static final int TYPE_GOTO_STORE = 1002;
  public static final int TYPE_GOTO_UPLOAD = 1005;
  public static final int TYPE_GOTO_VIDEOEDITOR = 1001;
  public static final int TYPE_GOTO_WEBVIEW = 1004;
  public static final int UPLOAD_LOGIN_REQUEST_CODE = 2;
  private CurPage mCurPage;
  private long mLastBackPress = 0L;
  private DJIAccountSignInFragment mSignInFragment;
  private DJIAccountSignContract.AccountSignInPresenter mSignInPresenter;
  private DJIAccountSignUpFragment mSignUpFragment;
  private DJIAccountSignContract.AccountSignUpPresenter mSignUpPresenter;
  
  private void initPresenter()
  {
    gotoSignIn();
  }
  
  public boolean exitApp()
  {
    return false;
  }
  
  /* Error */
  public void gotoSignIn()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void gotoSignUp()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onBackPressed()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void onCreate(android.os.Bundle arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void onDestroy()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void onPause()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void onResume()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected void onStart()
  {
    super.onStart();
  }
  
  /* Error */
  protected void onStop()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private static enum CurPage
  {
    static
    {
      CurPage localCurPage = new CurPage("SIGN_IN", 1);
      SIGN_IN = localCurPage;
      $VALUES = new CurPage[] { SIGN_UP, localCurPage };
    }
    
    private CurPage() {}
  }
  
  public static enum SignUpType
  {
    static
    {
      SignUpType localSignUpType = new SignUpType("EMAIL", 1);
      EMAIL = localSignUpType;
      $VALUES = new SignUpType[] { PHONE, localSignUpType };
    }
    
    private SignUpType() {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\pilo\\usercenter\sign\DJIAccountSignActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */