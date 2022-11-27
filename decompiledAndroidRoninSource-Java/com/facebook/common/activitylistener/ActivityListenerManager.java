package com.facebook.common.activitylistener;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import com.facebook.common.internal.Preconditions;
import java.lang.ref.WeakReference;
import javax.annotation.Nullable;

public class ActivityListenerManager
{
  @Nullable
  public static ListenableActivity getListenableActivity(Context paramContext)
  {
    Context localContext = paramContext;
    if (!(paramContext instanceof ListenableActivity))
    {
      localContext = paramContext;
      if ((paramContext instanceof ContextWrapper)) {
        localContext = ((ContextWrapper)paramContext).getBaseContext();
      }
    }
    if ((localContext instanceof ListenableActivity)) {
      return (ListenableActivity)localContext;
    }
    return null;
  }
  
  public static void register(ActivityListener paramActivityListener, Context paramContext)
  {
    paramContext = getListenableActivity(paramContext);
    if (paramContext != null) {
      paramContext.addActivityListener(new Listener(paramActivityListener));
    }
  }
  
  private static class Listener
    extends BaseActivityListener
  {
    private final WeakReference<ActivityListener> mActivityListenerRef;
    
    public Listener(ActivityListener paramActivityListener)
    {
      this.mActivityListenerRef = new WeakReference(paramActivityListener);
    }
    
    @Nullable
    private ActivityListener getListenerOrCleanUp(Activity paramActivity)
    {
      ActivityListener localActivityListener = (ActivityListener)this.mActivityListenerRef.get();
      if (localActivityListener == null)
      {
        Preconditions.checkArgument(paramActivity instanceof ListenableActivity);
        ((ListenableActivity)paramActivity).removeActivityListener(this);
      }
      return localActivityListener;
    }
    
    public void onActivityCreate(Activity paramActivity)
    {
      ActivityListener localActivityListener = getListenerOrCleanUp(paramActivity);
      if (localActivityListener != null) {
        localActivityListener.onActivityCreate(paramActivity);
      }
    }
    
    public void onDestroy(Activity paramActivity)
    {
      ActivityListener localActivityListener = getListenerOrCleanUp(paramActivity);
      if (localActivityListener != null) {
        localActivityListener.onDestroy(paramActivity);
      }
    }
    
    public void onPause(Activity paramActivity)
    {
      ActivityListener localActivityListener = getListenerOrCleanUp(paramActivity);
      if (localActivityListener != null) {
        localActivityListener.onPause(paramActivity);
      }
    }
    
    public void onResume(Activity paramActivity)
    {
      ActivityListener localActivityListener = getListenerOrCleanUp(paramActivity);
      if (localActivityListener != null) {
        localActivityListener.onResume(paramActivity);
      }
    }
    
    public void onStart(Activity paramActivity)
    {
      ActivityListener localActivityListener = getListenerOrCleanUp(paramActivity);
      if (localActivityListener != null) {
        localActivityListener.onStart(paramActivity);
      }
    }
    
    public void onStop(Activity paramActivity)
    {
      ActivityListener localActivityListener = getListenerOrCleanUp(paramActivity);
      if (localActivityListener != null) {
        localActivityListener.onStop(paramActivity);
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\common\activitylistener\ActivityListenerManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */