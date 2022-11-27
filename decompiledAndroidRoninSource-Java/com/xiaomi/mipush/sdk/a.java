package com.xiaomi.mipush.sdk;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;
import java.util.HashSet;
import java.util.Set;

public class a
  implements Application.ActivityLifecycleCallbacks
{
  private Set<String> a = new HashSet();
  
  private static void a(Application paramApplication)
  {
    paramApplication.registerActivityLifecycleCallbacks(new a());
  }
  
  public static void a(Context paramContext)
  {
    a((Application)paramContext.getApplicationContext());
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity) {}
  
  public void onActivityPaused(Activity paramActivity) {}
  
  /* Error */
  public void onActivityResumed(Activity arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity) {}
  
  public void onActivityStopped(Activity paramActivity) {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\mipush\sdk\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */