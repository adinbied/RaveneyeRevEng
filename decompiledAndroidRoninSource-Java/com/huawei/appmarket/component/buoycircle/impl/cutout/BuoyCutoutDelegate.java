package com.huawei.appmarket.component.buoycircle.impl.cutout;

import android.app.Activity;
import android.content.Intent;
import android.view.KeyEvent;
import com.huawei.appmarket.component.buoycircle.impl.delegete.IBridgeActivityDelegate;
import java.lang.ref.WeakReference;

public class BuoyCutoutDelegate
  implements IBridgeActivityDelegate
{
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
  
  public void onBridgeActivityDestroy() {}
  
  public boolean onBridgeActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    paramIntent = getActivity();
    if (paramIntent == null) {
      return true;
    }
    paramIntent.finish();
    return true;
  }
  
  public void onBridgeConfigurationChanged() {}
  
  public void onKeyUp(int paramInt, KeyEvent paramKeyEvent) {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\appmarket\component\buoycircle\impl\cutout\BuoyCutoutDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */