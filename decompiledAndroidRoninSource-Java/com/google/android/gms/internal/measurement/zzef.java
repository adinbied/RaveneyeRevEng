package com.google.android.gms.internal.measurement;

import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class zzef
{
  public static <T> zzec<T> zza(zzec<T> paramzzec)
  {
    if (!(paramzzec instanceof zzeh))
    {
      if ((paramzzec instanceof zzee)) {
        return paramzzec;
      }
      if ((paramzzec instanceof Serializable)) {
        return new zzee(paramzzec);
      }
      return new zzeh(paramzzec);
    }
    return paramzzec;
  }
  
  public static <T> zzec<T> zza(@NullableDecl T paramT)
  {
    return new zzeg(paramT);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */