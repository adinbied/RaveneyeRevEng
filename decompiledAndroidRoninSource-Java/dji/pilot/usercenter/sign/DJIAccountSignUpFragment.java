package dji.pilot.usercenter.sign;

import android.app.Dialog;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class DJIAccountSignUpFragment
  extends Fragment
  implements View.OnClickListener, DJIAccountSignContract.AccountSignUpView
{
  private static final int LENGTH_VERIFICATION = 4;
  private Button mBtnSignIn;
  private Button mBtnSignUp;
  private FragmentChangeContract.GotoSignIn mController;
  private Dialog mDialogWait;
  private EditText mEdtConfirmPsw;
  private EditText mEdtEmail;
  private EditText mEdtPsw;
  private TextWatcher mEdtTextWatcher = new TextWatcher()
  {
    /* Error */
    public void afterTextChanged(android.text.Editable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    
    public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
  };
  private EditText mEdtVerification;
  private TextWatcher mEmailTextWatcher = new TextWatcher()
  {
    /* Error */
    public void afterTextChanged(android.text.Editable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    
    public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
  };
  private ImageView mHintDeleteEmail;
  private ImageView mHintShowConfirmPassword;
  private ImageView mHintShowPassword;
  private DJIAccountSignUpPresenter mPresenter;
  private String mPrivacyUrl = "https://content.djiservice.org/agreement/dji-ronin-pp-en-1.0.html";
  private TextView mTvTermsTips;
  private String mUseTermsUrl = "https://content.djiservice.org/agreement/dji-ronin-terms-of-use-en-1.0.html";
  private ImageView mVerification;
  
  private boolean checkPasssword()
  {
    return false;
  }
  
  private void gotoSignIn()
  {
    FragmentChangeContract.GotoSignIn localGotoSignIn = this.mController;
    if (localGotoSignIn != null) {
      localGotoSignIn.gotoSignIn();
    }
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
  
  public static DJIAccountSignUpFragment newInstance()
  {
    return new DJIAccountSignUpFragment();
  }
  
  /* Error */
  private void signUp()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void changeToSignUpEmailWithVerification() {}
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    paramBundle = this.mPresenter;
    if (paramBundle != null) {
      paramBundle.refreshVerificationCode();
    }
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
    this.mController = ((FragmentChangeContract.GotoSignIn)getActivity());
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
  public void refreshVerificationImage(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void setPresenter(Object paramObject)
  {
    this.mPresenter = ((DJIAccountSignUpPresenter)paramObject);
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
  public void showSignInResult(boolean arg1, int arg2, String arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void showSignUpResult(boolean arg1, int arg2, String arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\pilo\\usercenter\sign\DJIAccountSignUpFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */