package com.google.android.gms.internal.measurement;

import java.lang.reflect.Constructor;

final class zzjr
{
  private static final zzjp zza = ;
  private static final zzjp zzb = new zzjs();
  
  static zzjp zza()
  {
    return zza;
  }
  
  static zzjp zzb()
  {
    return zzb;
  }
  
  private static zzjp zzc()
  {
    try
    {
      zzjp localzzjp = (zzjp)Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
      return localzzjp;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzjr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */