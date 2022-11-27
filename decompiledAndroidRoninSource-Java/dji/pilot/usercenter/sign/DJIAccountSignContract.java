package dji.pilot.usercenter.sign;

import dji.pilot.usercenter.BasePresenter;
import dji.pilot.usercenter.BaseView;

public abstract interface DJIAccountSignContract
{
  public static abstract interface AccountSignInPresenter
    extends BasePresenter
  {
    public abstract void refreshVerificationCode();
    
    public abstract void signIn(String paramString1, String paramString2);
    
    public abstract void signIn(String paramString1, String paramString2, String paramString3);
    
    public abstract void stop();
  }
  
  public static abstract interface AccountSignInView
    extends BaseView
  {
    public abstract void backPress();
    
    public abstract void changeToSignInWithVerification();
    
    public abstract void refreshVerificationImage(String paramString);
    
    public abstract void showEmailValid(boolean paramBoolean, String paramString);
    
    public abstract void showSignInResult(boolean paramBoolean, String paramString);
    
    public abstract void showSignInResultDialog(boolean paramBoolean, int paramInt);
  }
  
  public static abstract interface AccountSignUpPresenter
    extends BasePresenter
  {
    public abstract void inputMail(String paramString1, String paramString2);
    
    public abstract void inputPsw(String paramString, boolean paramBoolean);
    
    public abstract void refreshVerificationCode();
    
    public abstract void stop();
  }
  
  public static abstract interface AccountSignUpView
    extends BaseView
  {
    public abstract void changeToSignUpEmailWithVerification();
    
    public abstract void refreshVerificationImage(String paramString);
    
    public abstract void showEmailValid(boolean paramBoolean, String paramString);
    
    public abstract void showSignInResult(boolean paramBoolean, int paramInt, String paramString);
    
    public abstract void showSignUpResult(boolean paramBoolean, int paramInt, String paramString);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\pilo\\usercenter\sign\DJIAccountSignContract.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */