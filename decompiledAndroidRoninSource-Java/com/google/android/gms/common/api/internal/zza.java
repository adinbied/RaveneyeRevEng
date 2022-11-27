package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import androidx.collection.ArrayMap;
import com.google.android.gms.internal.common.zze;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;

public final class zza
  extends Fragment
  implements LifecycleFragment
{
  private static WeakHashMap<Activity, WeakReference<zza>> zzbe = new WeakHashMap();
  private Map<String, LifecycleCallback> zzbf = new ArrayMap();
  private int zzbg = 0;
  private Bundle zzbh;
  
  public static zza zza(Activity paramActivity)
  {
    Object localObject = (WeakReference)zzbe.get(paramActivity);
    if (localObject != null)
    {
      localObject = (zza)((WeakReference)localObject).get();
      if (localObject != null) {
        return (zza)localObject;
      }
    }
    try
    {
      zza localzza = (zza)paramActivity.getFragmentManager().findFragmentByTag("LifecycleFragmentImpl");
      if (localzza != null)
      {
        localObject = localzza;
        if (!localzza.isRemoving()) {}
      }
      else
      {
        localObject = new zza();
        paramActivity.getFragmentManager().beginTransaction().add((Fragment)localObject, "LifecycleFragmentImpl").commitAllowingStateLoss();
      }
      zzbe.put(paramActivity, new WeakReference(localObject));
      return (zza)localObject;
    }
    catch (ClassCastException paramActivity)
    {
      throw new IllegalStateException("Fragment with tag LifecycleFragmentImpl is not a LifecycleFragmentImpl", paramActivity);
    }
  }
  
  public final void addCallback(String paramString, LifecycleCallback paramLifecycleCallback)
  {
    if (!this.zzbf.containsKey(paramString))
    {
      this.zzbf.put(paramString, paramLifecycleCallback);
      if (this.zzbg > 0) {
        new zze(Looper.getMainLooper()).post(new zzb(this, paramLifecycleCallback, paramString));
      }
      return;
    }
    paramLifecycleCallback = new StringBuilder(String.valueOf(paramString).length() + 59);
    paramLifecycleCallback.append("LifecycleCallback with tag ");
    paramLifecycleCallback.append(paramString);
    paramLifecycleCallback.append(" already added to this fragment.");
    throw new IllegalArgumentException(paramLifecycleCallback.toString());
  }
  
  public final void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    super.dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    Iterator localIterator = this.zzbf.values().iterator();
    while (localIterator.hasNext()) {
      ((LifecycleCallback)localIterator.next()).dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
  }
  
  public final <T extends LifecycleCallback> T getCallbackOrNull(String paramString, Class<T> paramClass)
  {
    return (LifecycleCallback)paramClass.cast(this.zzbf.get(paramString));
  }
  
  public final Activity getLifecycleActivity()
  {
    return getActivity();
  }
  
  public final boolean isCreated()
  {
    return this.zzbg > 0;
  }
  
  public final boolean isStarted()
  {
    return this.zzbg >= 2;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Iterator localIterator = this.zzbf.values().iterator();
    while (localIterator.hasNext()) {
      ((LifecycleCallback)localIterator.next()).onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.zzbg = 1;
    this.zzbh = paramBundle;
    Iterator localIterator = this.zzbf.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      LifecycleCallback localLifecycleCallback = (LifecycleCallback)((Map.Entry)localObject).getValue();
      if (paramBundle != null) {
        localObject = paramBundle.getBundle((String)((Map.Entry)localObject).getKey());
      } else {
        localObject = null;
      }
      localLifecycleCallback.onCreate((Bundle)localObject);
    }
  }
  
  public final void onDestroy()
  {
    super.onDestroy();
    this.zzbg = 5;
    Iterator localIterator = this.zzbf.values().iterator();
    while (localIterator.hasNext()) {
      ((LifecycleCallback)localIterator.next()).onDestroy();
    }
  }
  
  public final void onResume()
  {
    super.onResume();
    this.zzbg = 3;
    Iterator localIterator = this.zzbf.values().iterator();
    while (localIterator.hasNext()) {
      ((LifecycleCallback)localIterator.next()).onResume();
    }
  }
  
  public final void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (paramBundle == null) {
      return;
    }
    Iterator localIterator = this.zzbf.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      Bundle localBundle = new Bundle();
      ((LifecycleCallback)localEntry.getValue()).onSaveInstanceState(localBundle);
      paramBundle.putBundle((String)localEntry.getKey(), localBundle);
    }
  }
  
  public final void onStart()
  {
    super.onStart();
    this.zzbg = 2;
    Iterator localIterator = this.zzbf.values().iterator();
    while (localIterator.hasNext()) {
      ((LifecycleCallback)localIterator.next()).onStart();
    }
  }
  
  public final void onStop()
  {
    super.onStop();
    this.zzbg = 4;
    Iterator localIterator = this.zzbf.values().iterator();
    while (localIterator.hasNext()) {
      ((LifecycleCallback)localIterator.next()).onStop();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\api\internal\zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */