package com.huawei.hms.support.api.game.c;

import android.app.Activity;
import android.content.Intent;
import android.view.KeyEvent;
import java.lang.ref.WeakReference;

public class a
  implements com.huawei.hms.activity.a
{
  private WeakReference<Activity> a;
  
  private Activity a()
  {
    return null;
  }
  
  /* Error */
  public void onBridgeActivityCreate(Activity arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public void onBridgeActivityDestroy()
  {
    this.a = null;
  }
  
  public boolean onBridgeActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    return false;
  }
  
  public void onBridgeConfigurationChanged() {}
  
  public void onKeyUp(int paramInt, KeyEvent paramKeyEvent) {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\game\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */