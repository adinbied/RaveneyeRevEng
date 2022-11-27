package com.google.android.gms.internal.measurement;

final class zzen
{
  static void zza(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 != null)
    {
      if (paramObject2 != null) {
        return;
      }
      paramObject1 = String.valueOf(paramObject1);
      paramObject2 = new StringBuilder(String.valueOf(paramObject1).length() + 26);
      ((StringBuilder)paramObject2).append("null value in entry: ");
      ((StringBuilder)paramObject2).append((String)paramObject1);
      ((StringBuilder)paramObject2).append("=null");
      throw new NullPointerException(((StringBuilder)paramObject2).toString());
    }
    paramObject1 = String.valueOf(paramObject2);
    paramObject2 = new StringBuilder(String.valueOf(paramObject1).length() + 24);
    ((StringBuilder)paramObject2).append("null key in entry: null=");
    ((StringBuilder)paramObject2).append((String)paramObject1);
    throw new NullPointerException(((StringBuilder)paramObject2).toString());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzen.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */