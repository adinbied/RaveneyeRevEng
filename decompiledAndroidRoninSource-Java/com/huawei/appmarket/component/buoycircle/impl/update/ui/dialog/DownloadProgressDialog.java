package com.huawei.appmarket.component.buoycircle.impl.update.ui.dialog;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import android.widget.ProgressBar;
import android.widget.TextView;

public class DownloadProgressDialog
  extends AbstractDialog
{
  private static final String TAG = "DownloadProgressDialog";
  private DialogInterface.OnKeyListener keylistener = new CustomOnKeyListener(null);
  private int mProgress = 0;
  private ProgressBar mProgressBar;
  private TextView mProgressInfo;
  
  public void intProgress(int paramInt)
  {
    this.mProgress = paramInt;
  }
  
  public AlertDialog onCreateDialog()
  {
    return null;
  }
  
  /* Error */
  public void setDownloading(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  private static class CustomOnKeyListener
    implements DialogInterface.OnKeyListener
  {
    public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
    {
      return (paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\appmarket\component\buoycircle\imp\\updat\\ui\dialog\DownloadProgressDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */