package com.google.android.gms.internal.measurement;

public final class zzfn
{
  static Object zza(Object paramObject, int paramInt)
  {
    if (paramObject != null) {
      return paramObject;
    }
    paramObject = new StringBuilder(20);
    ((StringBuilder)paramObject).append("at index ");
    ((StringBuilder)paramObject).append(paramInt);
    throw new NullPointerException(((StringBuilder)paramObject).toString());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzfn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */