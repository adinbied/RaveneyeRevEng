package com.google.firebase.crashlytics.internal.settings;

public enum SettingsCacheBehavior
{
  static
  {
    SKIP_CACHE_LOOKUP = new SettingsCacheBehavior("SKIP_CACHE_LOOKUP", 1);
    SettingsCacheBehavior localSettingsCacheBehavior = new SettingsCacheBehavior("IGNORE_CACHE_EXPIRATION", 2);
    IGNORE_CACHE_EXPIRATION = localSettingsCacheBehavior;
    $VALUES = new SettingsCacheBehavior[] { USE_CACHE, SKIP_CACHE_LOOKUP, localSettingsCacheBehavior };
  }
  
  private SettingsCacheBehavior() {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\internal\settings\SettingsCacheBehavior.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */