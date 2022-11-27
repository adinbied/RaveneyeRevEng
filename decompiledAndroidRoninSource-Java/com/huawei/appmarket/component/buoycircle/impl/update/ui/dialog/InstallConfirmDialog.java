package com.huawei.appmarket.component.buoycircle.impl.update.ui.dialog;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.huawei.appmarket.component.buoycircle.impl.utils.ResourceLoaderUtil;

public class InstallConfirmDialog
  extends AbstractDialog
{
  private String appName = ResourceLoaderUtil.getString("c_buoycircle_appmarket_name");
  
  public void intAppName(String paramString)
  {
    this.appName = paramString;
  }
  
  protected AlertDialog onCreateDialog()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\appmarket\component\buoycircle\imp\\updat\\ui\dialog\InstallConfirmDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */