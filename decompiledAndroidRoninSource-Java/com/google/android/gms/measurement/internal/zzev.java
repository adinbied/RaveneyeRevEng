package com.google.android.gms.measurement.internal;

import android.os.Bundle;

public final class zzev
{
  public String zza;
  public Bundle zzb;
  private String zzc;
  private long zzd;
  
  private zzev(String paramString1, String paramString2, Bundle paramBundle, long paramLong)
  {
    this.zza = paramString1;
    this.zzc = paramString2;
    paramString1 = paramBundle;
    if (paramBundle == null) {
      paramString1 = new Bundle();
    }
    this.zzb = paramString1;
    this.zzd = paramLong;
  }
  
  public static zzev zza(zzar paramzzar)
  {
    return new zzev(paramzzar.zza, paramzzar.zzc, paramzzar.zzb.zzb(), paramzzar.zzd);
  }
  
  public final String toString()
  {
    String str1 = this.zzc;
    String str2 = this.zza;
    String str3 = String.valueOf(this.zzb);
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(str1).length() + 21 + String.valueOf(str2).length() + String.valueOf(str3).length());
    localStringBuilder.append("origin=");
    localStringBuilder.append(str1);
    localStringBuilder.append(",name=");
    localStringBuilder.append(str2);
    localStringBuilder.append(",params=");
    localStringBuilder.append(str3);
    return localStringBuilder.toString();
  }
  
  public final zzar zza()
  {
    return new zzar(this.zza, new zzam(new Bundle(this.zzb)), this.zzc, this.zzd);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\measurement\internal\zzev.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */