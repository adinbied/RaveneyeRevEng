package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public final class zzkw
  extends AbstractList<String>
  implements zzis, RandomAccess
{
  private final zzis zza;
  
  public zzkw(zzis paramzzis)
  {
    this.zza = paramzzis;
  }
  
  public final Iterator<String> iterator()
  {
    return new zzky(this);
  }
  
  public final ListIterator<String> listIterator(int paramInt)
  {
    return new zzkv(this, paramInt);
  }
  
  public final int size()
  {
    return this.zza.size();
  }
  
  public final void zza(zzgr paramzzgr)
  {
    throw new UnsupportedOperationException();
  }
  
  public final Object zzb(int paramInt)
  {
    return this.zza.zzb(paramInt);
  }
  
  public final List<?> zzd()
  {
    return this.zza.zzd();
  }
  
  public final zzis zze()
  {
    return this;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzkw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */