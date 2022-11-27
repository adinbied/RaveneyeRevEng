package dji.pilot.usercenter;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnShowListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.TextView;

public class NewLibraryDialog
  extends Dialog
  implements View.OnClickListener, DialogInterface.OnShowListener
{
  private View mButtonDivider;
  private TextView mCancel;
  private String mCancelString = null;
  private TextView mConfirm;
  private String mConfirmString = null;
  private TextView mContent;
  private String mContentString = null;
  private boolean mIsDividerVisble = true;
  private OnNegativeListener mNegativeListener;
  private OnPositiveListener mPositiveListener;
  private TextView mTitle;
  private String mTitleString = null;
  
  public NewLibraryDialog(Context paramContext)
  {
    super(paramContext, 2131820750);
    paramContext = getWindow();
    paramContext.getAttributes().dimAmount = 0.5F;
    paramContext.setGravity(17);
    paramContext.setFlags(-1, 2);
    setCancelable(false);
  }
  
  /* Error */
  public void onClick(View arg1)
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
  public void onShow(android.content.DialogInterface arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public NewLibraryDialog setButtonDivider(boolean paramBoolean)
  {
    return null;
  }
  
  public NewLibraryDialog setCancel(String paramString, OnNegativeListener paramOnNegativeListener)
  {
    this.mCancelString = paramString;
    this.mNegativeListener = paramOnNegativeListener;
    paramOnNegativeListener = this.mCancel;
    if (paramOnNegativeListener != null) {
      paramOnNegativeListener.setText(paramString);
    }
    return this;
  }
  
  public NewLibraryDialog setConfirm(String paramString, OnPositiveListener paramOnPositiveListener)
  {
    this.mConfirmString = paramString;
    this.mPositiveListener = paramOnPositiveListener;
    paramOnPositiveListener = this.mConfirm;
    if (paramOnPositiveListener != null) {
      paramOnPositiveListener.setText(paramString);
    }
    return this;
  }
  
  public NewLibraryDialog setContent(String paramString)
  {
    return null;
  }
  
  public NewLibraryDialog setTitle(String paramString)
  {
    return null;
  }
  
  public static abstract interface OnNegativeListener
  {
    public abstract void onClick();
  }
  
  public static abstract interface OnPositiveListener
  {
    public abstract void onClick();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\pilo\\usercenter\NewLibraryDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */