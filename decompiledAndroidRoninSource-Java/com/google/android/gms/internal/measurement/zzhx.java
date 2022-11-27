package com.google.android.gms.internal.measurement;

final class zzhx
  implements zzji
{
  private static final zzhx zza = new zzhx();
  
  public static zzhx zza()
  {
    return zza;
  }
  
  public final boolean zza(Class<?> paramClass)
  {
    return zzhz.class.isAssignableFrom(paramClass);
  }
  
  public final zzjf zzb(Class<?> paramClass)
  {
    if (!zzhz.class.isAssignableFrom(paramClass))
    {
      paramClass = String.valueOf(paramClass.getName());
      if (paramClass.length() != 0) {
        paramClass = "Unsupported message type: ".concat(paramClass);
      } else {
        paramClass = new String("Unsupported message type: ");
      }
      throw new IllegalArgumentException(paramClass);
    }
    try
    {
      zzjf localzzjf = (zzjf)zzhz.zza(paramClass.asSubclass(zzhz.class)).zza(zzhz.zzf.zzc, null, null);
      return localzzjf;
    }
    catch (Exception localException)
    {
      paramClass = String.valueOf(paramClass.getName());
      if (paramClass.length() != 0) {
        paramClass = "Unable to get message info for ".concat(paramClass);
      } else {
        paramClass = new String("Unable to get message info for ");
      }
      throw new RuntimeException(paramClass, localException);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzhx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */