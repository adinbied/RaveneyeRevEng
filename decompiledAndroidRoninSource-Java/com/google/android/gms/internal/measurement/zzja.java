package com.google.android.gms.internal.measurement;

final class zzja
  implements zzji
{
  private zzji[] zza;
  
  zzja(zzji... paramVarArgs)
  {
    this.zza = paramVarArgs;
  }
  
  public final boolean zza(Class<?> paramClass)
  {
    zzji[] arrayOfzzji = this.zza;
    int j = arrayOfzzji.length;
    int i = 0;
    while (i < j)
    {
      if (arrayOfzzji[i].zza(paramClass)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public final zzjf zzb(Class<?> paramClass)
  {
    zzji[] arrayOfzzji = this.zza;
    int j = arrayOfzzji.length;
    int i = 0;
    while (i < j)
    {
      zzji localzzji = arrayOfzzji[i];
      if (localzzji.zza(paramClass)) {
        return localzzji.zzb(paramClass);
      }
      i += 1;
    }
    paramClass = String.valueOf(paramClass.getName());
    if (paramClass.length() != 0) {
      paramClass = "No factory is available for message type: ".concat(paramClass);
    } else {
      paramClass = new String("No factory is available for message type: ");
    }
    throw new UnsupportedOperationException(paramClass);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzja.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */