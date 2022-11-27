package com.huawei.android.hms.agent.common;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

public final class ActivityMgr
  implements Application.ActivityLifecycleCallbacks
{
  public static final ActivityMgr INST = new ActivityMgr();
  private static final Object LOCK_LASTACTIVITIES = new Object();
  private Application application;
  private List<Activity> curActivities = new ArrayList();
  private List<IActivityDestroyedCallback> destroyedCallbacks = new ArrayList();
  private List<IActivityPauseCallback> pauseCallbacks = new ArrayList();
  private List<IActivityResumeCallback> resumeCallbacks = new ArrayList();
  
  /* Error */
  private void clearCurActivities()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  private Activity getLastActivityInner()
  {
    return null;
  }
  
  /* Error */
  private void removeActivity(Activity arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  private void setCurActivity(Activity arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void clearActivitPauseCallbacks()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void clearActivitResumeCallbacks()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public Activity getLastActivity()
  {
    return getLastActivityInner();
  }
  
  /* Error */
  public void init(Application arg1, Activity arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onActivityCreated(Activity arg1, Bundle arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onActivityDestroyed(Activity arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onActivityPaused(Activity arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onActivityResumed(Activity arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  /* Error */
  public void onActivityStarted(Activity arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onActivityStopped(Activity arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void registerActivitDestroyedEvent(IActivityDestroyedCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void registerActivitPauseEvent(IActivityPauseCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void registerActivitResumeEvent(IActivityResumeCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void release()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void unRegisterActivitDestroyedEvent(IActivityDestroyedCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void unRegisterActivitPauseEvent(IActivityPauseCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void unRegisterActivitResumeEvent(IActivityResumeCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\android\hms\agent\common\ActivityMgr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */