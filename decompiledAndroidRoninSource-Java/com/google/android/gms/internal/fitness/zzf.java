package com.google.android.gms.internal.fitness;

import java.util.List;

public final class zzf
{
  public static <T> int zza(T paramT, List<T> paramList)
  {
    if (paramT == null) {
      return -1;
    }
    int i = paramList.indexOf(paramT);
    if (i >= 0) {
      return i;
    }
    paramList.add(paramT);
    return paramList.size() - 1;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\fitness\zzf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */