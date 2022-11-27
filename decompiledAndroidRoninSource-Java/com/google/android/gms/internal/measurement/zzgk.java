package com.google.android.gms.internal.measurement;

final class zzgk
{
  private static final Class<?> zza = zza("libcore.io.Memory");
  private static final boolean zzb;
  
  static
  {
    boolean bool;
    if (zza("org.robolectric.Robolectric") != null) {
      bool = true;
    } else {
      bool = false;
    }
    zzb = bool;
  }
  
  private static <T> Class<T> zza(String paramString)
  {
    try
    {
      paramString = Class.forName(paramString);
      return paramString;
    }
    finally
    {
      for (;;) {}
    }
    return null;
  }
  
  static boolean zza()
  {
    return (zza != null) && (!zzb);
  }
  
  static Class<?> zzb()
  {
    return zza;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzgk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */