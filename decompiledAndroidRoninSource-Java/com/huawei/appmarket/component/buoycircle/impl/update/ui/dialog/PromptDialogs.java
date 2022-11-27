package com.huawei.appmarket.component.buoycircle.impl.update.ui.dialog;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.huawei.appmarket.component.buoycircle.impl.utils.ResourceLoaderUtil;

public final class PromptDialogs
{
  private static abstract class AbstractFailurePrompt
    extends AbstractDialog
  {
    protected abstract int getMessageResId();
    
    protected int getPositiveButtonResId()
    {
      return ResourceLoaderUtil.getStringId("c_buoycircle_confirm");
    }
    
    public AlertDialog onCreateDialog()
    {
      return null;
    }
  }
  
  public static class CheckFailurePrompt
    extends PromptDialogs.AbstractFailurePrompt
  {
    public CheckFailurePrompt()
    {
      super();
    }
    
    protected int getMessageResId()
    {
      return ResourceLoaderUtil.getStringId("c_buoycircle_check_failure");
    }
  }
  
  public static class DownloadFailurePrompt
    extends PromptDialogs.AbstractFailurePrompt
  {
    public DownloadFailurePrompt()
    {
      super();
    }
    
    protected int getMessageResId()
    {
      return ResourceLoaderUtil.getStringId("c_buoycircle_download_failure");
    }
  }
  
  public static class DownloadNoSpacePrompt
    extends PromptDialogs.AbstractFailurePrompt
  {
    public DownloadNoSpacePrompt()
    {
      super();
    }
    
    protected int getMessageResId()
    {
      return ResourceLoaderUtil.getStringId("c_buoycircle_download_no_space");
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\appmarket\component\buoycircle\imp\\updat\\ui\dialog\PromptDialogs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */