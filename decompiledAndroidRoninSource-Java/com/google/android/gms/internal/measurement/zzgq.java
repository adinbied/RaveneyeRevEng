package com.google.android.gms.internal.measurement;

import java.util.NoSuchElementException;

final class zzgq
  extends zzgs
{
  private int zza = 0;
  private final int zzb = this.zzc.zza();
  
  zzgq(zzgr paramzzgr) {}
  
  public final boolean hasNext()
  {
    return this.zza < this.zzb;
  }
  
  public final byte zza()
  {
    int i = this.zza;
    if (i < this.zzb)
    {
      this.zza = (i + 1);
      return this.zzc.zzb(i);
    }
    throw new NoSuchElementException();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzgq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */