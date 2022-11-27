package com.huawei.appmarket.component.buoycircle.impl.update.ui.dialog;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.huawei.appmarket.component.buoycircle.impl.utils.ResourceLoaderUtil;

public final class ConfirmUpdateDialog
{
  private static abstract class AbstractUpdateConfirm
    extends AbstractDialog
  {
    protected abstract int getMessageResId();
    
    protected abstract int getNegativeButtonResId();
    
    protected abstract int getPositiveButtonResId();
    
    public AlertDialog onCreateDialog()
    {
      return null;
    }
  }
  
  public static class RetryConfirm
    extends ConfirmUpdateDialog.AbstractUpdateConfirm
  {
    public RetryConfirm()
    {
      super();
    }
    
    protected int getMessageResId()
    {
      return ResourceLoaderUtil.getStringId("c_buoycircle_download_retry");
    }
    
    protected int getNegativeButtonResId()
    {
      return ResourceLoaderUtil.getStringId("c_buoycircle_cancel");
    }
    
    protected int getPositiveButtonResId()
    {
      return ResourceLoaderUtil.getStringId("c_buoycircle_retry");
    }
  }
  
  public static class StopConfirm
    extends ConfirmUpdateDialog.AbstractUpdateConfirm
  {
    public StopConfirm()
    {
      super();
    }
    
    protected int getMessageResId()
    {
      return ResourceLoaderUtil.getStringId("c_buoycircle_abort_message");
    }
    
    protected int getNegativeButtonResId()
    {
      return ResourceLoaderUtil.getStringId("c_buoycircle_no");
    }
    
    protected int getPositiveButtonResId()
    {
      return ResourceLoaderUtil.getStringId("c_buoycircle_abort");
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\appmarket\component\buoycircle\imp\\updat\\ui\dialog\ConfirmUpdateDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */