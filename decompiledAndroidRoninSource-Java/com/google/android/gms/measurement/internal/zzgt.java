package com.google.android.gms.measurement.internal;

import android.os.Bundle;

public final class zzgt
{
  public static <T> T zza(Bundle paramBundle, String paramString, Class<T> paramClass, T paramT)
  {
    paramBundle = paramBundle.get(paramString);
    if (paramBundle == null) {
      return paramT;
    }
    if (paramClass.isAssignableFrom(paramBundle.getClass())) {
      return paramBundle;
    }
    throw new IllegalStateException(String.format("Invalid conditional user property field type. '%s' expected [%s] but was [%s]", new Object[] { paramString, paramClass.getCanonicalName(), paramBundle.getClass().getCanonicalName() }));
  }
  
  public static void zza(Bundle paramBundle, Object paramObject)
  {
    if ((paramObject instanceof Double))
    {
      paramBundle.putDouble("value", ((Double)paramObject).doubleValue());
      return;
    }
    if ((paramObject instanceof Long))
    {
      paramBundle.putLong("value", ((Long)paramObject).longValue());
      return;
    }
    paramBundle.putString("value", paramObject.toString());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\measurement\internal\zzgt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */