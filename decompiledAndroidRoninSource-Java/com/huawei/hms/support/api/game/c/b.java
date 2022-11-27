package com.huawei.hms.support.api.game.c;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import com.huawei.hms.activity.a;
import java.lang.ref.WeakReference;

public class b
  implements a
{
  private WeakReference<Activity> a;
  private String b = null;
  private int c = 0;
  private String d = null;
  
  private Activity a()
  {
    return null;
  }
  
  /* Error */
  private void a(Activity arg1, int arg2, Intent arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  private void a(Activity arg1, Intent arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  private boolean a(Context paramContext, String paramString, int paramInt)
  {
    return false;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\game\c\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */