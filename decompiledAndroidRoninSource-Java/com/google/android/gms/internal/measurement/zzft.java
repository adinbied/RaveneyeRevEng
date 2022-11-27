package com.google.android.gms.internal.measurement;

final class zzft
  extends zzfb<Object>
{
  private final transient Object[] zza;
  private final transient int zzb;
  private final transient int zzc;
  
  zzft(Object[] paramArrayOfObject, int paramInt1, int paramInt2)
  {
    this.zza = paramArrayOfObject;
    this.zzb = paramInt1;
    this.zzc = paramInt2;
  }
  
  public final Object get(int paramInt)
  {
    zzeb.zza(paramInt, this.zzc);
    return this.zza[(paramInt * 2 + this.zzb)];
  }
  
  public final int size()
  {
    return this.zzc;
  }
  
  final boolean zzf()
  {
    return true;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzft.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */