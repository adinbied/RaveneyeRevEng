package com.huawei.appmarket.component.buoycircle.impl.delegete;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.view.KeyEvent;
import java.lang.ref.WeakReference;

public class BuoyHideDelegate
  implements IBridgeActivityDelegate
{
  public static final String APP_INFO_KEY = "appInfo";
  private AlertDialog dialog = null;
  private WeakReference<Activity> mThisWeakRef;
  
  private Activity getActivity()
  {
    return null;
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
    paramIntent = getActivity();
    if (paramIntent == null) {
      return true;
    }
    paramIntent.finish();
    return true;
  }
  
  /* Error */
  public void onBridgeConfigurationChanged()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void onKeyUp(int paramInt, KeyEvent paramKeyEvent) {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\appmarket\component\buoycircle\impl\delegete\BuoyHideDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */