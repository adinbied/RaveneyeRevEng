package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.util.List;
import java.util.Map;

final class zzez
  implements Runnable
{
  private final zzew zza;
  private final int zzb;
  private final Throwable zzc;
  private final byte[] zzd;
  private final String zze;
  private final Map<String, List<String>> zzf;
  
  private zzez(String paramString, zzew paramzzew, int paramInt, Throwable paramThrowable, byte[] paramArrayOfByte, Map<String, List<String>> paramMap)
  {
    Preconditions.checkNotNull(paramzzew);
    this.zza = paramzzew;
    this.zzb = paramInt;
    this.zzc = paramThrowable;
    this.zzd = paramArrayOfByte;
    this.zze = paramString;
    this.zzf = paramMap;
  }
  
  public final void run()
  {
    this.zza.zza(this.zze, this.zzb, this.zzc, this.zzd, this.zzf);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\measurement\internal\zzez.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */