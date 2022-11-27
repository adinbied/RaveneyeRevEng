package com.huawei.appmarket.component.buoycircle.impl.update.ui.delegate;

import android.content.Intent;

public class HiAppUpdateDelegate
  extends AbsUpdateDelegate
{
  private static final String TAG = "HiAppUpdateDelegate";
  
  private boolean gotoHiappForUpdate()
  {
    return false;
  }
  
  public int getRequestCode()
  {
    return 2005;
  }
  
  /* Error */
  public void onBridgeActivityCreate(android.app.Activity arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void onBridgeActivityDestroy()
  {
    super.onBridgeActivityDestroy();
  }
  
  public boolean onBridgeActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    return false;
  }
  
  public void onBridgeConfigurationChanged()
  {
    super.onBridgeConfigurationChanged();
  }
  
  /* Error */
  public void onCancel(com.huawei.appmarket.component.buoycircle.impl.update.ui.dialog.AbstractDialog arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onDoWork(com.huawei.appmarket.component.buoycircle.impl.update.ui.dialog.AbstractDialog arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onKeyUp(int arg1, android.view.KeyEvent arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
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
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\appmarket\component\buoycircle\imp\\updat\\ui\delegate\HiAppUpdateDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */