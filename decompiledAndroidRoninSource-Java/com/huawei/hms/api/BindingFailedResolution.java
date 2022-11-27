package com.huawei.hms.api;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.view.KeyEvent;
import com.huawei.hms.b.f;
import com.huawei.hms.c.h;
import com.huawei.hms.c.j;

public class BindingFailedResolution
  implements ServiceConnection, com.huawei.hms.activity.a
{
  private Activity a;
  private boolean b = true;
  private a c;
  private Handler d = null;
  
  /* Error */
  private void a()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void a(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void a(Activity arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  private void a(boolean arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  private boolean b()
  {
    return false;
  }
  
  /* Error */
  private void c()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void d()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void e()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected Activity getActivity()
  {
    return this.a;
  }
  
  public int getRequestCode()
  {
    return 2003;
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
    if (paramInt1 != getRequestCode()) {
      return false;
    }
    a();
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
  
  public void onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    com.huawei.hms.support.log.a.b("BindingFailedResolution", "On key up when resolve conn error");
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    d();
    a(true);
    paramComponentName = getActivity();
    if (paramComponentName == null) {
      return;
    }
    j.a(paramComponentName, this);
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName) {}
  
  /* Error */
  protected void onStartResult(boolean arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  private static class a
    extends f
  {
    protected String a(Context paramContext)
    {
      return null;
    }
    
    protected String b(Context paramContext)
    {
      return h.d("hms_confirm");
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\api\BindingFailedResolution.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */