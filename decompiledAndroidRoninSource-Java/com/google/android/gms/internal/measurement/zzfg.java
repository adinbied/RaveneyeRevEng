package com.google.android.gms.internal.measurement;

import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class zzfg<E>
  extends zzey<E>
  implements Set<E>
{
  @NullableDecl
  private transient zzfb<E> zza;
  
  static int zza(int paramInt)
  {
    int i = Math.max(paramInt, 2);
    boolean bool = true;
    if (i < 751619276)
    {
      paramInt = Integer.highestOneBit(i - 1) << 1;
      while (paramInt * 0.7D < i) {
        paramInt <<= 1;
      }
      return paramInt;
    }
    if (i >= 1073741824) {
      bool = false;
    }
    zzeb.zza(bool, "collection too large");
    return 1073741824;
  }
  
  public boolean equals(@NullableDecl Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (((paramObject instanceof zzfg)) && (zzg()) && (((zzfg)paramObject).zzg()) && (hashCode() != paramObject.hashCode())) {
      return false;
    }
    return zzfv.zza(this, paramObject);
  }
  
  public int hashCode()
  {
    return zzfv.zza(this);
  }
  
  public zzfb<E> zze()
  {
    zzfb localzzfb2 = this.zza;
    zzfb localzzfb1 = localzzfb2;
    if (localzzfb2 == null)
    {
      localzzfb1 = zzh();
      this.zza = localzzfb1;
    }
    return localzzfb1;
  }
  
  boolean zzg()
  {
    return false;
  }
  
  zzfb<E> zzh()
  {
    return zzfb.zza(toArray());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */