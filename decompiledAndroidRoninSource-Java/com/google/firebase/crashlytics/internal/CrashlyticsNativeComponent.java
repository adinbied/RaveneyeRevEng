package com.google.firebase.crashlytics.internal;

public abstract interface CrashlyticsNativeComponent
{
  public abstract boolean finalizeSession(String paramString);
  
  public abstract NativeSessionFileProvider getSessionFileProvider(String paramString);
  
  public abstract boolean hasCrashDataForSession(String paramString);
  
  public abstract boolean openSession(String paramString);
  
  public abstract void writeBeginSession(String paramString1, String paramString2, long paramLong);
  
  public abstract void writeSessionApp(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, String paramString6);
  
  public abstract void writeSessionDevice(String paramString1, int paramInt1, String paramString2, int paramInt2, long paramLong1, long paramLong2, boolean paramBoolean, int paramInt3, String paramString3, String paramString4);
  
  public abstract void writeSessionOs(String paramString1, String paramString2, String paramString3, boolean paramBoolean);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\internal\CrashlyticsNativeComponent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */