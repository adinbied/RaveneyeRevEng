package dji.publics.widget.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import dji.publics.DJIUI.DJIEditText;

public class DJIEditDialog
  extends DJIDialog
{
  private DJIEditText mEditView;
  
  public DJIEditDialog(Context paramContext)
  {
    super(paramContext);
    initEditView();
  }
  
  public DJIEditDialog(Context paramContext, DJIDialogType paramDJIDialogType, DJIDialog.DJIDialogTheme paramDJIDialogTheme)
  {
    super(paramContext, paramDJIDialogType, paramDJIDialogTheme);
    initEditView();
  }
  
  /* Error */
  private void initEditView()
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
  
  public String getEditText()
  {
    return null;
  }
  
  public void setEditHint(CharSequence paramCharSequence)
  {
    this.mEditView.setHint(paramCharSequence);
  }
  
  public void setEditText(String paramString)
  {
    this.mEditView.setText(paramString);
  }
  
  /* Error */
  public void setEditTextColor(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setEditTextMaxInput(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setLeftBtnOfEdit(String arg1, OnEditClickListener arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setRightBtnOfEdit(String arg1, OnEditClickListener arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static abstract interface OnEditClickListener
  {
    public abstract void onClick(DialogInterface paramDialogInterface, int paramInt, String paramString);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\publics\widget\dialog\DJIEditDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */