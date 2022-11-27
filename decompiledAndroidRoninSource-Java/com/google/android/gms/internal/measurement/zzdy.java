package com.google.android.gms.internal.measurement;

import java.io.Serializable;

public abstract class zzdy<T>
  implements Serializable
{
  public static <T> zzdy<T> zza(T paramT)
  {
    return new zzea(zzeb.zza(paramT));
  }
  
  public static <T> zzdy<T> zzc()
  {
    return zzdu.zza;
  }
  
  public abstract boolean zza();
  
  public abstract T zzb();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzdy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */