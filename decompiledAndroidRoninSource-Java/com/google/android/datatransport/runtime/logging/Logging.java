package com.google.android.datatransport.runtime.logging;

import android.util.Log;

public final class Logging
{
  public static void d(String paramString1, String paramString2)
  {
    Log.d(getTag(paramString1), paramString2);
  }
  
  public static void d(String paramString1, String paramString2, Object paramObject)
  {
    Log.d(getTag(paramString1), String.format(paramString2, new Object[] { paramObject }));
  }
  
  public static void d(String paramString1, String paramString2, Object paramObject1, Object paramObject2)
  {
    Log.d(getTag(paramString1), String.format(paramString2, new Object[] { paramObject1, paramObject2 }));
  }
  
  public static void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    Log.d(getTag(paramString1), String.format(paramString2, paramVarArgs));
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    Log.e(getTag(paramString1), paramString2, paramThrowable);
  }
  
  private static String getTag(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TransportRuntime.");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public static void i(String paramString1, String paramString2)
  {
    Log.i(getTag(paramString1), paramString2);
  }
  
  public static void w(String paramString1, String paramString2, Object paramObject)
  {
    Log.w(getTag(paramString1), String.format(paramString2, new Object[] { paramObject }));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\datatransport\runtime\logging\Logging.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */