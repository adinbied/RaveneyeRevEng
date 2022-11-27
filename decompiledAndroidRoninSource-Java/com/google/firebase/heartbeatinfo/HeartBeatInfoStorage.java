package com.google.firebase.heartbeatinfo;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

class HeartBeatInfoStorage
{
  private static final String GLOBAL = "fire-global";
  private static HeartBeatInfoStorage instance;
  private static final String preferencesName = "FirebaseAppHeartBeat";
  private final SharedPreferences sharedPreferences;
  
  private HeartBeatInfoStorage(Context paramContext)
  {
    this.sharedPreferences = paramContext.getSharedPreferences("FirebaseAppHeartBeat", 0);
  }
  
  HeartBeatInfoStorage(SharedPreferences paramSharedPreferences)
  {
    this.sharedPreferences = paramSharedPreferences;
  }
  
  static HeartBeatInfoStorage getInstance(Context paramContext)
  {
    try
    {
      if (instance == null) {
        instance = new HeartBeatInfoStorage(paramContext);
      }
      paramContext = instance;
      return paramContext;
    }
    finally {}
  }
  
  boolean shouldSendGlobalHeartBeat(long paramLong)
  {
    try
    {
      boolean bool = shouldSendSdkHeartBeat("fire-global", paramLong);
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  boolean shouldSendSdkHeartBeat(String paramString, long paramLong)
  {
    try
    {
      if (this.sharedPreferences.contains(paramString))
      {
        if (paramLong - this.sharedPreferences.getLong(paramString, -1L) >= 86400000L)
        {
          this.sharedPreferences.edit().putLong(paramString, paramLong).apply();
          return true;
        }
        return false;
      }
      this.sharedPreferences.edit().putLong(paramString, paramLong).apply();
      return true;
    }
    finally {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\heartbeatinfo\HeartBeatInfoStorage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */