package com.google.android.gms.common.api.internal;

import android.app.Activity;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class zaa
  extends ActivityLifecycleObserver
{
  private final WeakReference<zaa> zacl;
  
  public zaa(Activity paramActivity)
  {
    this(zaa.zab(paramActivity));
  }
  
  private zaa(zaa paramzaa)
  {
    this.zacl = new WeakReference(paramzaa);
  }
  
  public final ActivityLifecycleObserver onStopCallOnce(Runnable paramRunnable)
  {
    zaa localzaa = (zaa)this.zacl.get();
    if (localzaa != null)
    {
      zaa.zaa(localzaa, paramRunnable);
      return this;
    }
    throw new IllegalStateException("The target activity has already been GC'd");
  }
  
  static class zaa
    extends LifecycleCallback
  {
    private List<Runnable> zacm = new ArrayList();
    
    private zaa(LifecycleFragment paramLifecycleFragment)
    {
      super();
      this.mLifecycleFragment.addCallback("LifecycleObserverOnStop", this);
    }
    
    private static zaa zaa(Activity paramActivity)
    {
      try
      {
        LifecycleFragment localLifecycleFragment = getFragment(paramActivity);
        zaa localzaa2 = (zaa)localLifecycleFragment.getCallbackOrNull("LifecycleObserverOnStop", zaa.class);
        zaa localzaa1 = localzaa2;
        if (localzaa2 == null) {
          localzaa1 = new zaa(localLifecycleFragment);
        }
        return localzaa1;
      }
      finally {}
    }
    
    private final void zaa(Runnable paramRunnable)
    {
      try
      {
        this.zacm.add(paramRunnable);
        return;
      }
      finally
      {
        paramRunnable = finally;
        throw paramRunnable;
      }
    }
    
    public void onStop()
    {
      try
      {
        Object localObject1 = this.zacm;
        this.zacm = new ArrayList();
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext()) {
          ((Runnable)((Iterator)localObject1).next()).run();
        }
        return;
      }
      finally {}
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\api\internal\zaa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */