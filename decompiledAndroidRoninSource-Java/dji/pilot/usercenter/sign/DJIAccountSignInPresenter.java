package dji.pilot.usercenter.sign;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import dji.pilot.usercenter.DJIMemberManager;
import dji.pilot.usercenter.IProtocol.OnDataResultListener;

public class DJIAccountSignInPresenter
  implements DJIAccountSignContract.AccountSignInPresenter
{
  private static final String LOG_TAG = "DJIAccountSignPresenter";
  private DJIAccountSignContract.AccountSignInView mAccountSignInView;
  private Context mContext;
  private IProtocol.OnDataResultListener mDataResultListener = new IProtocol.OnDataResultListener()
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
      if ((paramAnonymousInt1 != 196656) && (paramAnonymousInt1 != 196704))
      {
        if (paramAnonymousInt1 != 262224) {
          return;
        }
        DJIAccountSignInPresenter.this.mUiHandler.post(new Runnable()
        {
          /* Error */
          public void run()
          {
            // Byte code:
            //   0: return
            //   1: astore_1
            //   2: goto -2 -> 0
          }
        });
        return;
      }
      DJIAccountSignInPresenter.this.mUiHandler.post(new Runnable()
      {
        /* Error */
        public void run()
        {
          // Byte code:
          //   0: return
          //   1: astore_1
          //   2: goto -2 -> 0
        }
      });
    }
    
    public void onUpate(int paramAnonymousInt1, long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt2, Object paramAnonymousObject) {}
  };
  private DJIMemberManager mMemberManager;
  private Handler mUiHandler;
  private String mVerificationKey;
  
  public DJIAccountSignInPresenter(DJIAccountSignContract.AccountSignInView paramAccountSignInView, Context paramContext)
  {
    this.mContext = paramContext;
    this.mAccountSignInView = paramAccountSignInView;
    paramAccountSignInView.setPresenter(this);
    this.mUiHandler = new Handler(Looper.getMainLooper());
    this.mMemberManager = DJIMemberManager.getInstance();
  }
  
  private String generateKey()
  {
    return null;
  }
  
  /* Error */
  void log(String arg1, Object... arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void refreshVerificationCode()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void signIn(String paramString1, String paramString2)
  {
    this.mMemberManager.accountCenterLoginByEmail(paramString1, paramString2);
  }
  
  public void signIn(String paramString1, String paramString2, String paramString3)
  {
    this.mMemberManager.accountCenterLoginByEmailWithCaptcha(paramString1, paramString2, paramString3, this.mVerificationKey);
  }
  
  public void start(int paramInt)
  {
    this.mMemberManager.registerResultListener(this.mDataResultListener);
  }
  
  public void stop()
  {
    this.mMemberManager.unregisterResultListener(this.mDataResultListener);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\pilo\\usercenter\sign\DJIAccountSignInPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */