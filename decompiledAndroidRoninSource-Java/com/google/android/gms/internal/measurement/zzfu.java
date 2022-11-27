package com.google.android.gms.internal.measurement;

final class zzfu<E>
  extends zzfg<E>
{
  private final transient E zza;
  private transient int zzb;
  
  zzfu(E paramE)
  {
    this.zza = zzeb.zza(paramE);
  }
  
  zzfu(E paramE, int paramInt)
  {
    this.zza = paramE;
    this.zzb = paramInt;
  }
  
  public final boolean contains(Object paramObject)
  {
    return this.zza.equals(paramObject);
  }
  
  public final int hashCode()
  {
    int j = this.zzb;
    int i = j;
    if (j == 0)
    {
      i = this.zza.hashCode();
      this.zzb = i;
    }
    return i;
  }
  
  public final int size()
  {
    return 1;
  }
  
  public final String toString()
  {
    String str = this.zza.toString();
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(str).length() + 2);
    localStringBuilder.append('[');
    localStringBuilder.append(str);
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
  
  final int zza(Object[] paramArrayOfObject, int paramInt)
  {
    paramArrayOfObject[paramInt] = this.zza;
    return paramInt + 1;
  }
  
  public final zzfx<E> zza()
  {
    return new zzfl(this.zza);
  }
  
  final boolean zzf()
  {
    return false;
  }
  
  final boolean zzg()
  {
    return this.zzb != 0;
  }
  
  final zzfb<E> zzh()
  {
    return zzfb.zza(this.zza);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzfu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */