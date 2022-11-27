package com.google.android.gms.internal.measurement;

import java.util.NoSuchElementException;

final class zzfl
  extends zzfx<T>
{
  private boolean zza;
  
  zzfl(Object paramObject) {}
  
  public final boolean hasNext()
  {
    return !this.zza;
  }
  
  public final T next()
  {
    if (!this.zza)
    {
      this.zza = true;
      return (T)this.zzb;
    }
    throw new NoSuchElementException();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzfl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */