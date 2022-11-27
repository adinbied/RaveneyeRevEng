package com.google.firebase.crashlytics.internal.settings.model;

public abstract interface Settings
{
  public abstract int getCacheDuration();
  
  public abstract long getExpiresAtMillis();
  
  public abstract FeaturesSettingsData getFeaturesData();
  
  public abstract SessionSettingsData getSessionData();
  
  public abstract int getSettingsVersion();
  
  public abstract boolean isExpired(long paramLong);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\internal\settings\model\Settings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */