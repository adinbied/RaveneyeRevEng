package com.google.android.gms.measurement.module;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzfv;
import com.google.android.gms.measurement.internal.zzgs;
import com.google.android.gms.measurement.internal.zzgv;

public class Analytics
{
  public static final String CRASH_ORIGIN = "crash";
  public static final String FCM_ORIGIN = "fcm";
  public static final String FIAM_ORIGIN = "fiam";
  private static volatile Analytics zza;
  private final zzfv zzb;
  
  private Analytics(zzfv paramzzfv)
  {
    Preconditions.checkNotNull(paramzzfv);
    this.zzb = paramzzfv;
  }
  
  public static Analytics getInstance(Context paramContext)
  {
    if (zza == null) {
      try
      {
        if (zza == null) {
          zza = new Analytics(zzfv.zza(paramContext, null, null));
        }
      }
      finally {}
    }
    return zza;
  }
  
  public static final class Event
    extends zzgs
  {
    public static final String AD_REWARD = "_ar";
    public static final String APP_EXCEPTION = "_ae";
  }
  
  public static final class Param
    extends zzgv
  {
    public static final String FATAL = "fatal";
    public static final String TIMESTAMP = "timestamp";
    public static final String TYPE = "type";
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\measurement\module\Analytics.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */