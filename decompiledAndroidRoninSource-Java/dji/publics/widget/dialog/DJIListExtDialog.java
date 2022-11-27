package dji.publics.widget.dialog;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import dji.publics.widget.DJIScrollTextView;

public class DJIListExtDialog
  extends DJIListDialog
{
  private CheckBox mCheckBoxView;
  private DJIScrollTextView mHelpTextView;
  
  public DJIListExtDialog(Context paramContext)
  {
    super(paramContext);
    initExtView();
  }
  
  public DJIListExtDialog(Context paramContext, DJIDialogType paramDJIDialogType, DJIDialog.DJIDialogTheme paramDJIDialogTheme)
  {
    super(paramContext, paramDJIDialogType, paramDJIDialogTheme);
    initExtView();
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
  private void initExtView()
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
  
  public boolean isChecked()
  {
    return this.mCheckBoxView.isChecked();
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
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\publics\widget\dialog\DJIListExtDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */