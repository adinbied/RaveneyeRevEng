package com.google.android.gms.internal.measurement;

final class zzfm<E>
  extends zzfb<E>
{
  static final zzfb<Object> zza = new zzfm(new Object[0], 0);
  private final transient Object[] zzb;
  private final transient int zzc;
  
  zzfm(Object[] paramArrayOfObject, int paramInt)
  {
    this.zzb = paramArrayOfObject;
    this.zzc = paramInt;
  }
  
  public final E get(int paramInt)
  {
    zzeb.zza(paramInt, this.zzc);
    return (E)this.zzb[paramInt];
  }
  
  public final int size()
  {
    return this.zzc;
  }
  
  final int zza(Object[] paramArrayOfObject, int paramInt)
  {
    System.arraycopy(this.zzb, 0, paramArrayOfObject, paramInt, this.zzc);
    return paramInt + this.zzc;
  }
  
  final Object[] zzb()
  {
    return this.zzb;
  }
  
  final int zzc()
  {
    return 0;
  }
  
  final int zzd()
  {
    return this.zzc;
  }
  
  final boolean zzf()
  {
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzfm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */