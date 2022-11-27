package dji.pilot.usercenter.sign;

import android.app.Dialog;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.dji.ronin.publics.util.Util;
import dji.pilot.usercenter.NewLibraryDialog;
import dji.pilot.usercenter.NewLibraryDialog.OnPositiveListener;
import dji.publics.DJIUI.DJIEditText;

public class DJIAccountSignInFragment
  extends Fragment
  implements DJIAccountSignContract.AccountSignInView, View.OnClickListener
{
  private static final String LOG_TAG = "DJIAccountSignFragment";
  private static final int MAX_ERROR_PASSWORD_COUNT_WITHOUT_VARIFICATION = 3;
  public static final int RESULT_FIRST_USER = 1;
  private static final ISignState STATE_SIGN_IN = new ISignState()
  {
    public void back(DJIAccountSignInFragment paramAnonymousDJIAccountSignInFragment)
    {
      paramAnonymousDJIAccountSignInFragment.cancelActivity();
    }
    
    public void onEdtChanged(Editable paramAnonymousEditable, DJIAccountSignInFragment paramAnonymousDJIAccountSignInFragment)
    {
      if ((!Util.isEmpty(paramAnonymousDJIAccountSignInFragment.mEdtEmail.getText().toString())) && (!Util.isEmpty(paramAnonymousDJIAccountSignInFragment.mEdtPassword.getText().toString())))
      {
        paramAnonymousDJIAccountSignInFragment.mBtnLogin.setEnabled(true);
        return;
      }
      paramAnonymousDJIAccountSignInFragment.mBtnLogin.setEnabled(false);
    }
    
    /* Error */
    public void onOkBtnClick(DJIAccountSignInFragment arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public String toString()
    {
      return "now state: STATE_SIGN_IN";
    }
  };
  private Button mBtnLogin;
  private Button mBtnSignup;
  private FragmentChangeContract.GotoSignUp mController;
  private Dialog mDialogWait;
  private DJIEditText mEdtEmail;
  private DJIEditText mEdtPassword;
  private TextWatcher mEdtTextWatcher = new TextWatcher()
  {
    /* Error */
    public void afterTextChanged(Editable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    
    public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
  };
  private DJIEditText mEdtVerification;
  private NewLibraryDialog mErrorDialog;
  private boolean mFromNFZ = false;
  private int mGotoType = 1003;
  private ImageView mHintDeleteEmal;
  private ImageView mHintShowPassword;
  private boolean mIsLoginType = true;
  private ImageView mIvBack;
  private ImageView mIvVerification;
  private DJIAccountSignContract.AccountSignInPresenter mPresenter;
  private String mPrivacyUrl = "https://content.djiservice.org/agreement/dji-ronin-pp-en-1.0.html";
  private int mPswErrorTimes = 0;
  private boolean mSignInUseVerification = false;
  private ISignState mState = STATE_SIGN_IN;
  private TextView mTvTermsTips;
  private String mUseTermsUrl = "https://content.djiservice.org/agreement/dji-ronin-terms-of-use-en-1.0.html";
  
  /* Error */
  private void cancelActivity()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private boolean checkPwd(String paramString)
  {
    return false;
  }
  
  /* Error */
  private void forgot()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  private void getIntentData()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private String getStringById(int paramInt)
  {
    return null;
  }
  
  private void goBack()
  {
    this.mState.back(this);
  }
  
  /* Error */
  private void goInputPsw()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void goSignUp()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private void networkOperationDoing()
  {
    Dialog localDialog = this.mDialogWait;
    if (localDialog != null) {
      localDialog.show();
    }
  }
  
  /* Error */
  private void networkOperationDone()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static DJIAccountSignInFragment newInstance()
  {
    return new DJIAccountSignInFragment();
  }
  
  private void onBtnOkLick()
  {
    this.mState.onOkBtnClick(this);
  }
  
  /* Error */
  private void showEmailErrorDialog()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void showPswErrorDialog()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void showVerifyErrorDialog()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void backPress()
  {
    goBack();
  }
  
  /* Error */
  public void changeToSignInWithVerification()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void gotoOther()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    getIntentData();
  }
  
  /* Error */
  public void onAttach(android.app.Activity arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void onAttach(Context paramContext)
  {
    super.onAttach(paramContext);
    onAttachToContext(paramContext);
  }
  
  protected void onAttachToContext(Context paramContext)
  {
    this.mController = ((FragmentChangeContract.GotoSignUp)getActivity());
  }
  
  /* Error */
  public void onClick(View arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return null;
  }
  
  /* Error */
  public void onViewStateRestored(Bundle arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void refreshVerificationImage(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void setPresenter(Object paramObject)
  {
    this.mPresenter = ((DJIAccountSignContract.AccountSignInPresenter)paramObject);
  }
  
  /* Error */
  public void showEmailValid(boolean arg1, String arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void showSignInResult(boolean arg1, String arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void showSignInResultDialog(boolean arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  private static abstract interface ISignState
  {
    public abstract void back(DJIAccountSignInFragment paramDJIAccountSignInFragment);
    
    public abstract void onEdtChanged(Editable paramEditable, DJIAccountSignInFragment paramDJIAccountSignInFragment);
    
    public abstract void onOkBtnClick(DJIAccountSignInFragment paramDJIAccountSignInFragment);
  }
  
  public static enum V2LoginState
  {
    static
    {
      V2LoginState localV2LoginState = new V2LoginState("FAIL", 1);
      FAIL = localV2LoginState;
      $VALUES = new V2LoginState[] { SUCCEED, localV2LoginState };
    }
    
    private V2LoginState() {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\pilo\\usercenter\sign\DJIAccountSignInFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */