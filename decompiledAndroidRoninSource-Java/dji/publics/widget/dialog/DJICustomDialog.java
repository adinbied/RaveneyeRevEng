package dji.publics.widget.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import dji.publics.DJIUI.DJILinearLayout;
import dji.publics.DJIUI.DJIRelativeLayout;
import dji.publics.DJIUI.DJITextView;
import dji.publics.widget.DJIScrollTextView;
import dji.publics.widget.DJIThumbSeekBar;

public class DJICustomDialog
  extends DJIDialog
{
  private CheckBox mCheckBoxView;
  private DJIScrollTextView mHelpTextView;
  private OnSeekDoneListener mListener;
  private ProgressBar mProgressBar;
  private DJILinearLayout mProgressRoundLy;
  private DJITextView mProgressRoundTv;
  private DJIThumbSeekBar mSeekBar;
  private DJIRelativeLayout mSeekBarLy;
  private DJITextView mSeekBarTextView;
  
  public DJICustomDialog(Context paramContext)
  {
    super(paramContext);
    initCustomView();
  }
  
  public DJICustomDialog(Context paramContext, DJIDialogType paramDJIDialogType, DJIDialog.DJIDialogTheme paramDJIDialogTheme)
  {
    super(paramContext, paramDJIDialogType, paramDJIDialogTheme);
    initCustomView();
  }
  
  /* Error */
  private void adjustCheckBoxDrawable()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void handleSbStopTrack()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void hideCustomDivider()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void initCustomView()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void dismiss()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void hideCheckText()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void hideHelpText()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void hideProgressText()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void hideSeekBar()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean isChecked()
  {
    return this.mCheckBoxView.isChecked();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  /* Error */
  public void setCheckText(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setCheckText(CharSequence arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setHelpText(CharSequence arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setHelpTextWithUnderLine(boolean arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setOnHelpTextClickListener(DialogInterface.OnClickListener arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setOnSeekDoneListener(OnSeekDoneListener arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setProgressText(CharSequence arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setSeekBarText(CharSequence arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static abstract interface OnSeekDoneListener
  {
    public abstract void onSeekBarChecked(DialogInterface paramDialogInterface, boolean paramBoolean);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\publics\widget\dialog\DJICustomDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */