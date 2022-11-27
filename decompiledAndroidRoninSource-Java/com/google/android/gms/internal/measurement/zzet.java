package com.google.android.gms.internal.measurement;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

abstract class zzet<T>
  implements Iterator<T>
{
  private int zza = zzem.zza(this.zzd);
  private int zzb = this.zzd.zzd();
  private int zzc = -1;
  
  private zzet(zzem paramzzem) {}
  
  private final void zza()
  {
    if (zzem.zza(this.zzd) == this.zza) {
      return;
    }
    throw new ConcurrentModificationException();
  }
  
  public boolean hasNext()
  {
    return this.zzb >= 0;
  }
  
  public T next()
  {
    zza();
    if (hasNext())
    {
      int i = this.zzb;
      this.zzc = i;
      Object localObject = zza(i);
      this.zzb = this.zzd.zza(this.zzb);
      return (T)localObject;
    }
    throw new NoSuchElementException();
  }
  
  public void remove()
  {
    zza();
    boolean bool;
    if (this.zzc >= 0) {
      bool = true;
    } else {
      bool = false;
    }
    zzeb.zzb(bool, "no calls to next() since the last call to remove()");
    this.zza += 32;
    zzem localzzem = this.zzd;
    localzzem.remove(localzzem.zzb[this.zzc]);
    this.zzb = zzem.zzb(this.zzb, this.zzc);
    this.zzc = -1;
  }
  
  abstract T zza(int paramInt);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */