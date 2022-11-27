package com.google.android.gms.internal.measurement;

final class zzfd
  extends zzfb<E>
{
  private final transient int zza;
  private final transient int zzb;
  
  zzfd(zzfb paramzzfb, int paramInt1, int paramInt2)
  {
    this.zza = paramInt1;
    this.zzb = paramInt2;
  }
  
  public final E get(int paramInt)
  {
    zzeb.zza(paramInt, this.zzb);
    return (E)this.zzc.get(paramInt + this.zza);
  }
  
  public final int size()
  {
    return this.zzb;
  }
  
  public final zzfb<E> zza(int paramInt1, int paramInt2)
  {
    zzeb.zza(paramInt1, paramInt2, this.zzb);
    zzfb localzzfb = this.zzc;
    int i = this.zza;
    return (zzfb)localzzfb.subList(paramInt1 + i, paramInt2 + i);
  }
  
  final Object[] zzb()
  {
    return this.zzc.zzb();
  }
  
  final int zzc()
  {
    return this.zzc.zzc() + this.zza;
  }
  
  final int zzd()
  {
    return this.zzc.zzc() + this.zza + this.zzb;
  }
  
  final boolean zzf()
  {
    return true;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzfd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */