package com.huawei.appmarket.component.buoycircle.impl.delegete;

import android.app.Activity;
import android.content.Intent;
import android.view.KeyEvent;
import java.lang.ref.WeakReference;

public class BuoyUpdateDelegate
  implements IBridgeActivityDelegate
{
  public static final String EXTRA_RESULT = "intent.extra.RESULT";
  private static final int REQUEST_CODE_UPDSTE_APP_MARKET = 1000;
  public static final String SDK_VERSION_CODE = "sdkVersionCode";
  private static final int SUCCESS = 0;
  private WeakReference<Activity> mThisWeakRef;
  
  private Activity getActivity()
  {
    return null;
  }
  
  /* Error */
  private void openBigBuoy(Activity arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public int getRequestCode()
  {
    return 0;
  }
  
  /* Error */
  public void onBridgeActivityCreate(Activity arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void onBridgeActivityDestroy()
  {
    this.mThisWeakRef = null;
  }
  
  public boolean onBridgeActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    return false;
  }
  
  public void onBridgeConfigurationChanged() {}
  
  public void onKeyUp(int paramInt, KeyEvent paramKeyEvent) {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\appmarket\component\buoycircle\impl\delegete\BuoyUpdateDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */