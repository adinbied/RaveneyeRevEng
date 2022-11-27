package dji.publics.widget.dialog;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.widget.ProgressBar;
import dji.publics.DJIUI.DJILinearLayout;
import dji.publics.DJIUI.DJITextView;
import java.lang.ref.WeakReference;

public class DJIProgressDialog
  extends DJIDialog
{
  private boolean mHasStarted;
  private int mIncrementBy;
  private int mIncrementSecondaryBy;
  private boolean mIndeterminate;
  private Drawable mIndeterminateDrawable;
  private int mMax;
  private ProgressBar mProgress;
  private DJILinearLayout mProgressBottomLy;
  private Drawable mProgressDrawable;
  private String mProgressNumberFormat;
  private DJITextView mProgressPercent;
  private DJITextView mProgressTextLeft;
  private DJITextView mProgressTextRight;
  private int mProgressVal;
  private int mSecondaryProgressVal;
  private ViewUpdateHandler mViewUpdateHandler;
  
  public DJIProgressDialog(Context paramContext)
  {
    super(paramContext);
    initDivider();
    initView();
  }
  
  public DJIProgressDialog(Context paramContext, DJIDialogType paramDJIDialogType, DJIDialog.DJIDialogTheme paramDJIDialogTheme)
  {
    super(paramContext, paramDJIDialogType, paramDJIDialogTheme);
    initDivider();
    initView();
  }
  
  /* Error */
  private void initDivider()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private void initFormats()
  {
    this.mProgressNumberFormat = "%1d/%2d";
  }
  
  /* Error */
  private void initView()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void onProgressChanged()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void updateProgressView()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public int getMax()
  {
    return 0;
  }
  
  public int getProgress()
  {
    return 0;
  }
  
  public int getSecondaryProgress()
  {
    return 0;
  }
  
  /* Error */
  public void incrementProgressBy(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void incrementSecondaryProgressBy(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  public boolean isIndeterminate()
  {
    return false;
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
  public void onDetachedFromWindow()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void onStart()
  {
    super.onStart();
    this.mHasStarted = true;
  }
  
  protected void onStop()
  {
    super.onStop();
    this.mHasStarted = false;
  }
  
  public void setDefaultFormat()
  {
    initFormats();
  }
  
  /* Error */
  public void setIndeterminate(boolean arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setIndeterminateDrawable(Drawable arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setMax(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setProgress(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setProgressDrawable(Drawable arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setProgressLeftText(CharSequence arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setProgressNormal()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void setProgressNumberFormat(String paramString)
  {
    this.mProgressNumberFormat = paramString;
    onProgressChanged();
  }
  
  /* Error */
  public void setProgressPercent(CharSequence arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setProgressRed()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setProgressRightText(CharSequence arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setSecondaryProgress(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  private static class ViewUpdateHandler
    extends Handler
  {
    private WeakReference<DJIProgressDialog> mViewReference;
    
    ViewUpdateHandler(DJIProgressDialog paramDJIProgressDialog)
    {
      this.mViewReference = new WeakReference(paramDJIProgressDialog);
    }
    
    public void handleMessage(Message paramMessage)
    {
      ((DJIProgressDialog)this.mViewReference.get()).updateProgressView();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\publics\widget\dialog\DJIProgressDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */