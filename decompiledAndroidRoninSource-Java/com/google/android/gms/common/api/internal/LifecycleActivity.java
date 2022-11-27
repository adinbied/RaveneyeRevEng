package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.ContextWrapper;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.common.internal.Preconditions;

public class LifecycleActivity
{
  private final Object zzbd;
  
  public LifecycleActivity(Activity paramActivity)
  {
    Preconditions.checkNotNull(paramActivity, "Activity must not be null");
    this.zzbd = paramActivity;
  }
  
  public LifecycleActivity(ContextWrapper paramContextWrapper)
  {
    throw new UnsupportedOperationException();
  }
  
  public Activity asActivity()
  {
    return (Activity)this.zzbd;
  }
  
  public FragmentActivity asFragmentActivity()
  {
    return (FragmentActivity)this.zzbd;
  }
  
  public Object asObject()
  {
    return this.zzbd;
  }
  
  public boolean isChimera()
  {
    return false;
  }
  
  public boolean isSupport()
  {
    return this.zzbd instanceof FragmentActivity;
  }
  
  public final boolean zzh()
  {
    return this.zzbd instanceof Activity;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\api\internal\LifecycleActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */