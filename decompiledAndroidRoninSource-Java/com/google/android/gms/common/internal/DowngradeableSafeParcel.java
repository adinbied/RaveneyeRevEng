package com.google.android.gms.common.internal;

import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public abstract class DowngradeableSafeParcel
  extends AbstractSafeParcelable
  implements ReflectedParcelable
{
  private static final Object zzdc = new Object();
  private static ClassLoader zzdd = null;
  private static Integer zzde = null;
  private boolean zzdf = false;
  
  protected static boolean canUnparcelSafely(String paramString)
  {
    zzp();
    return true;
  }
  
  protected static Integer getUnparcelClientVersion()
  {
    synchronized (zzdc)
    {
      return null;
    }
  }
  
  private static ClassLoader zzp()
  {
    synchronized (zzdc)
    {
      return null;
    }
  }
  
  protected abstract boolean prepareForClientVersion(int paramInt);
  
  public void setShouldDowngrade(boolean paramBoolean)
  {
    this.zzdf = paramBoolean;
  }
  
  protected boolean shouldDowngrade()
  {
    return this.zzdf;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\internal\DowngradeableSafeParcel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */