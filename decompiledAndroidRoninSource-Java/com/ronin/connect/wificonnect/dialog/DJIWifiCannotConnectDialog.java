package com.ronin.connect.wificonnect.dialog;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import dji.publics.widget.dialog.DJIDialog;
import dji.publics.widget.dialog.DJIDialog.DJIDialogTheme;
import dji.publics.widget.dialog.DJIDialogType;

public class DJIWifiCannotConnectDialog
  extends DJIDialog
{
  private TextView mTvWifiConnectTip;
  private TextView mTvWifiName;
  private TextView mTvWifiPwd;
  
  public DJIWifiCannotConnectDialog(Context paramContext)
  {
    super(paramContext);
    initEditView();
  }
  
  public DJIWifiCannotConnectDialog(Context paramContext, DJIDialogType paramDJIDialogType, DJIDialog.DJIDialogTheme paramDJIDialogTheme)
  {
    super(paramContext, paramDJIDialogType, paramDJIDialogTheme);
    initEditView();
  }
  
  public DJIWifiCannotConnectDialog(Context paramContext, DJIDialogType paramDJIDialogType, DJIDialog.DJIDialogTheme paramDJIDialogTheme, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    super(paramContext, paramDJIDialogType, paramDJIDialogTheme);
    initEditView();
    setTitle(paramString1);
    setContent(paramString2);
    setWifiInfo(paramString3, paramString4);
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
  private void setWifiView(android.view.View arg1)
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
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setCanceledOnTouchOutside(false);
  }
  
  /* Error */
  public void setTvWifiConnectTip(boolean arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setWifiInfo(String arg1, String arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\ronin\connect\wificonnect\dialog\DJIWifiCannotConnectDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */