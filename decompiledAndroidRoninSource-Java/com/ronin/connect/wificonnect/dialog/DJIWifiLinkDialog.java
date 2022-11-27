package com.ronin.connect.wificonnect.dialog;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.ronin.connect.R.string;
import dji.publics.widget.dialog.DJIDialog;
import dji.publics.widget.dialog.DJIDialog.DJIDialogTheme;
import dji.publics.widget.dialog.DJIDialogType;

public class DJIWifiLinkDialog
  extends DJIDialog
{
  public static final int MAX_WIFI_PASSWORD_LENGTH = 8;
  private static final String TAG = "DJIWifiLinkDialog";
  private boolean isPwdInvisible = true;
  private String mCapabilities;
  private EditText mEtPassword;
  private ImageView mIvInvisiblePwd;
  private String mSSID;
  private TextView mWarningText;
  
  public DJIWifiLinkDialog(Context paramContext)
  {
    super(paramContext);
    initEditView();
  }
  
  public DJIWifiLinkDialog(Context paramContext, DJIDialogType paramDJIDialogType, DJIDialog.DJIDialogTheme paramDJIDialogTheme)
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
  private void initListener()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void setLeftBtn()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void setPwdView()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void setPwdView(android.view.View arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void dismiss()
  {
    super.dismiss();
  }
  
  public String getInputPwd()
  {
    return null;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setCanceledOnTouchOutside(false);
    setPwdView();
  }
  
  public void setInputText(String paramString)
  {
    EditText localEditText = this.mEtPassword;
    if (localEditText != null) {
      localEditText.setText(paramString);
    }
  }
  
  public void setRightBtn(DialogInterface.OnClickListener paramOnClickListener)
  {
    setRightBtn(R.string.common_confirm, paramOnClickListener);
  }
  
  public void setWifiInfo(String paramString1, String paramString2)
  {
    this.mSSID = paramString1;
    this.mCapabilities = paramString2;
  }
  
  /* Error */
  public void warnInvalidInput()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\ronin\connect\wificonnect\dialog\DJIWifiLinkDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */