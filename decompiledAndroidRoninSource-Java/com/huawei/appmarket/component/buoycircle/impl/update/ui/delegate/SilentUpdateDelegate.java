package com.huawei.appmarket.component.buoycircle.impl.update.ui.delegate;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.os.Handler;
import android.view.KeyEvent;

public class SilentUpdateDelegate
  extends AbsUpdateDelegate
{
  private static final int DOWNLOAD_OVER_TIME = 20000;
  private static final int INSTALL_OVER_TIME = 60000;
  private static final String PACKAGE_DATA_SCHEME = "package";
  private static final String TAG = "SilentUpdateDelegate";
  private BroadcastReceiver HiAppReciever;
  private Handler handler = new Handler();
  private int mCurProgress = 0;
  private Handler silentInstallHandler = new Handler()
  {
    /* Error */
    public void handleMessage(android.os.Message arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  };
  private BroadcastReceiver systemAppAddedReceiver;
  
  /* Error */
  private void handleDownloadStatus(android.os.Bundle arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void handlerDownloadProgress(android.os.Bundle arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void handlerInstallStatus(android.os.Bundle arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void refreshOverTime(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void registReceiver()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private boolean silentInstall(Activity paramActivity)
  {
    return false;
  }
  
  /* Error */
  private void silentInstallFail(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void unRegistReceiver()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public int getRequestCode()
  {
    return 2000;
  }
  
  /* Error */
  public void onBridgeActivityCreate(Activity arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onBridgeActivityDestroy()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean onBridgeActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    return false;
  }
  
  public void onBridgeConfigurationChanged()
  {
    super.onBridgeConfigurationChanged();
  }
  
  public void onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  /* Error */
  void showDialog(Class<? extends com.huawei.appmarket.component.buoycircle.impl.update.ui.dialog.AbstractDialog> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  void userCancelUpdate()
  {
    finishBridgeActivity(13, this.updateType);
  }
  
  private class HandlerRunnable
    implements Runnable
  {
    private HandlerRunnable() {}
    
    public void run()
    {
      SilentUpdateDelegate.this.silentInstallFail(14);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\appmarket\component\buoycircle\imp\\updat\\ui\delegate\SilentUpdateDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */