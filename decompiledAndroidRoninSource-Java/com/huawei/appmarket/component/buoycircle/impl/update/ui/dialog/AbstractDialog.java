package com.huawei.appmarket.component.buoycircle.impl.update.ui.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources;
import com.huawei.appmarket.component.buoycircle.impl.update.ui.delegate.AbsUpdateDelegate;

public abstract class AbstractDialog
{
  private static final String TAG = "AbstractDialog";
  private AlertDialog mDialog;
  private AbsUpdateDelegate mUpdateWizard;
  
  private static int getThemeEmui(Context paramContext)
  {
    if (paramContext == null) {
      return 0;
    }
    return paramContext.getResources().getIdentifier("androidhwext:style/Theme.Emui", null, null);
  }
  
  public void cancel()
  {
    AlertDialog localAlertDialog = this.mDialog;
    if (localAlertDialog != null) {
      localAlertDialog.cancel();
    }
  }
  
  public void dismiss()
  {
    AlertDialog localAlertDialog = this.mDialog;
    if (localAlertDialog != null) {
      localAlertDialog.dismiss();
    }
  }
  
  protected void fireCancel()
  {
    AbsUpdateDelegate localAbsUpdateDelegate = this.mUpdateWizard;
    if (localAbsUpdateDelegate != null) {
      localAbsUpdateDelegate.onCancel(this);
    }
  }
  
  protected void fireDoWork()
  {
    AbsUpdateDelegate localAbsUpdateDelegate = this.mUpdateWizard;
    if (localAbsUpdateDelegate != null) {
      localAbsUpdateDelegate.onDoWork(this);
    }
  }
  
  protected Activity getActivity()
  {
    return null;
  }
  
  protected int getDialogThemeId()
  {
    return 0;
  }
  
  protected abstract AlertDialog onCreateDialog();
  
  /* Error */
  public void show(AbsUpdateDelegate arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\appmarket\component\buoycircle\imp\\updat\\ui\dialog\AbstractDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */