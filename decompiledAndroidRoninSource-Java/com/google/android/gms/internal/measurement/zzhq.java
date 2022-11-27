package com.google.android.gms.internal.measurement;

import java.lang.reflect.Constructor;

final class zzhq
{
  private static final zzho<?> zza = new zzhn();
  private static final zzho<?> zzb = zzc();
  
  static zzho<?> zza()
  {
    return zza;
  }
  
  static zzho<?> zzb()
  {
    zzho localzzho = zzb;
    if (localzzho != null) {
      return localzzho;
    }
    throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
  }
  
  private static zzho<?> zzc()
  {
    try
    {
      zzho localzzho = (zzho)Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
      return localzzho;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzhq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */