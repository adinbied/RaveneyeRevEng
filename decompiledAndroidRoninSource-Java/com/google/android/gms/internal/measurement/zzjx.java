package com.google.android.gms.internal.measurement;

final class zzjx
  implements zzjf
{
  private final zzjh zza;
  private final String zzb;
  private final Object[] zzc;
  private final int zzd;
  
  zzjx(zzjh paramzzjh, String paramString, Object[] paramArrayOfObject)
  {
    this.zza = paramzzjh;
    this.zzb = paramString;
    this.zzc = paramArrayOfObject;
    int i = paramString.charAt(0);
    if (i < 55296)
    {
      this.zzd = i;
      return;
    }
    int k = i & 0x1FFF;
    int j = 13;
    i = 1;
    int m;
    for (;;)
    {
      m = paramString.charAt(i);
      if (m < 55296) {
        break;
      }
      k |= (m & 0x1FFF) << j;
      j += 13;
      i += 1;
    }
    this.zzd = (k | m << j);
  }
  
  public final int zza()
  {
    if ((this.zzd & 0x1) == 1) {
      return zzjw.zza;
    }
    return zzjw.zzb;
  }
  
  public final boolean zzb()
  {
    return (this.zzd & 0x2) == 2;
  }
  
  public final zzjh zzc()
  {
    return this.zza;
  }
  
  final String zzd()
  {
    return this.zzb;
  }
  
  final Object[] zze()
  {
    return this.zzc;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzjx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */