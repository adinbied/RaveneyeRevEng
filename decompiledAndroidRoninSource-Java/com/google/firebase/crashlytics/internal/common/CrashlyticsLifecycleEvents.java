package com.google.firebase.crashlytics.internal.common;

abstract interface CrashlyticsLifecycleEvents
{
  public abstract void onBeginSession(String paramString, long paramLong);
  
  public abstract void onCustomKey(String paramString1, String paramString2);
  
  public abstract void onLog(long paramLong, String paramString);
  
  public abstract void onUserId(String paramString);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\internal\common\CrashlyticsLifecycleEvents.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */