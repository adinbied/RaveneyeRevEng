package dji.publics.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import com.dji.frame.util.V_AppUtils;

public class DJINewBaseDialog
  extends Dialog
{
  protected static final float DEFAULT_DIM_AMOUNT = 0.4F;
  public int height;
  private boolean isHideSystemBar = false;
  protected Context mContext = null;
  protected DJIDialogType mDialogType = DJIDialogType.SMALL;
  private float mDimAmout = 0.0F;
  public Handler mPostHandler = new Handler(Looper.getMainLooper());
  protected DJIDialog.DJIDialogTheme mTheme = DJIDialog.DJIDialogTheme.BLACK;
  private boolean mTypeToast = false;
  public int width;
  
  public DJINewBaseDialog(Context paramContext)
  {
    this(paramContext, R.style.LogDialog);
  }
  
  public DJINewBaseDialog(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    this.mContext = paramContext;
  }
  
  public DJINewBaseDialog(Context paramContext, int paramInt, boolean paramBoolean)
  {
    super(paramContext, paramInt);
    this.mContext = paramContext;
    this.isHideSystemBar = paramBoolean;
  }
  
  public DJINewBaseDialog(Context paramContext, DJIDialogType paramDJIDialogType, DJIDialog.DJIDialogTheme paramDJIDialogTheme)
  {
    super(paramContext, i);
    this.mContext = paramContext;
    this.mDialogType = paramDJIDialogType;
    this.mTheme = paramDJIDialogTheme;
  }
  
  public DJINewBaseDialog(Context paramContext, boolean paramBoolean)
  {
    this(paramContext, R.style.LogDialog);
    this.isHideSystemBar = paramBoolean;
  }
  
  private int adjustDialogWidth(int paramInt)
  {
    return 0;
  }
  
  /* Error */
  public void adjustAttrs(int arg1, int arg2, int arg3, int arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore 5
    //   3: goto -3 -> 0
  }
  
  /* Error */
  protected void adjustAttrsDefault()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  protected int getScreenWidth()
  {
    return 0;
  }
  
  protected boolean handleTouchOutside()
  {
    return false;
  }
  
  protected boolean isOutOfBounds(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  /* Error */
  public void onAttachedToWindow()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    adjustAttrsDefault();
  }
  
  /* Error */
  public void onDetachedFromWindow()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @org.greenrobot.eventbus.Subscribe(threadMode=org.greenrobot.eventbus.ThreadMode.MAIN)
  public void onEvent3MainThread(com.dji.frame.util.V_AppUtils.DJI_SYS_UI_EVENT arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void onStart()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if ((isShowing()) && (this.isHideSystemBar)) {
      V_AppUtils.enter(getWindow());
    }
  }
  
  /* Error */
  public void setBeModalDlg()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setBehindDim(float arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  public void setContentView(int paramInt)
  {
    super.setContentView(paramInt);
    if (this.isHideSystemBar) {
      V_AppUtils.enter(getWindow());
    }
  }
  
  /* Error */
  public void setHideSystemBar(boolean arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setNoModalDlg()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void setWindowTypeToast(boolean paramBoolean)
  {
    this.mTypeToast = paramBoolean;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\publics\widget\dialog\DJINewBaseDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */