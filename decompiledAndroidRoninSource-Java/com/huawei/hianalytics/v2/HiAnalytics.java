package com.huawei.hianalytics.v2;

import android.content.Context;
import com.huawei.hianalytics.process.HiAnalyticsInstance;
import com.huawei.hianalytics.process.HiAnalyticsManager;
import com.huawei.hianalytics.process.b;
import java.util.LinkedHashMap;

public abstract class HiAnalytics
{
  private static HiAnalyticsInstance defaultInstance;
  
  public static void clearCachedData() {}
  
  private static HiAnalyticsInstance getDefaultInstance()
  {
    try
    {
      if (defaultInstance == null) {
        defaultInstance = HiAnalyticsManager.getInstanceByTag("_default_config_tag");
      }
      HiAnalyticsInstance localHiAnalyticsInstance = defaultInstance;
      return localHiAnalyticsInstance;
    }
    finally {}
  }
  
  public static boolean getInitFlag()
  {
    return HiAnalyticsManager.getInitFlag("_default_config_tag");
  }
  
  public static void handleV1Cache()
  {
    b.a().a("_default_config_tag");
  }
  
  public static void onBackground(long paramLong)
  {
    if (getDefaultInstance() != null) {
      defaultInstance.onBackground(paramLong);
    }
  }
  
  public static void onEvent(int paramInt, String paramString, LinkedHashMap<String, String> paramLinkedHashMap)
  {
    if (getDefaultInstance() != null) {
      defaultInstance.onEvent(paramInt, paramString, paramLinkedHashMap);
    }
  }
  
  @Deprecated
  public static void onEvent(Context paramContext, String paramString1, String paramString2)
  {
    if (getDefaultInstance() != null) {
      defaultInstance.onEvent(paramContext, paramString1, paramString2);
    }
  }
  
  public static void onEvent(String paramString, LinkedHashMap<String, String> paramLinkedHashMap)
  {
    if (getDefaultInstance() != null) {
      defaultInstance.onEvent(0, paramString, paramLinkedHashMap);
    }
  }
  
  public static void onForeground(long paramLong)
  {
    if (getDefaultInstance() != null) {
      defaultInstance.onForeground(paramLong);
    }
  }
  
  public static void onPause(Context paramContext)
  {
    if (getDefaultInstance() != null) {
      defaultInstance.onPause(paramContext);
    }
  }
  
  public static void onPause(Context paramContext, LinkedHashMap<String, String> paramLinkedHashMap)
  {
    if (getDefaultInstance() != null) {
      defaultInstance.onPause(paramContext, paramLinkedHashMap);
    }
  }
  
  public static void onPause(String paramString, LinkedHashMap<String, String> paramLinkedHashMap)
  {
    if (getDefaultInstance() != null) {
      defaultInstance.onPause(paramString, paramLinkedHashMap);
    }
  }
  
  public static void onReport()
  {
    if (getDefaultInstance() != null) {
      defaultInstance.onReport(-1);
    }
  }
  
  @Deprecated
  public static void onReport(Context paramContext)
  {
    if (getDefaultInstance() != null) {
      defaultInstance.onReport(paramContext, -1);
    }
  }
  
  public static void onResume(Context paramContext)
  {
    if (getDefaultInstance() != null) {
      defaultInstance.onResume(paramContext);
    }
  }
  
  public static void onResume(Context paramContext, LinkedHashMap<String, String> paramLinkedHashMap)
  {
    if (getDefaultInstance() != null) {
      defaultInstance.onResume(paramContext, paramLinkedHashMap);
    }
  }
  
  public static void onResume(String paramString, LinkedHashMap<String, String> paramLinkedHashMap)
  {
    if (getDefaultInstance() != null) {
      defaultInstance.onResume(paramString, paramLinkedHashMap);
    }
  }
  
  public static void onStreamEvent(int paramInt, String paramString, LinkedHashMap<String, String> paramLinkedHashMap)
  {
    if (getDefaultInstance() != null) {
      defaultInstance.onStreamEvent(paramInt, paramString, paramLinkedHashMap);
    }
  }
  
  public static void setIsOaidTracking(boolean paramBoolean)
  {
    if (getDefaultInstance() != null)
    {
      defaultInstance.setOAIDTrackingFlag(1, paramBoolean);
      defaultInstance.setOAIDTrackingFlag(0, paramBoolean);
      defaultInstance.setOAIDTrackingFlag(3, paramBoolean);
      defaultInstance.setOAIDTrackingFlag(2, paramBoolean);
    }
  }
  
  public static void setOAID(String paramString)
  {
    if (getDefaultInstance() != null)
    {
      defaultInstance.setOAID(1, paramString);
      defaultInstance.setOAID(0, paramString);
      defaultInstance.setOAID(3, paramString);
      defaultInstance.setOAID(2, paramString);
    }
  }
  
  public static void setUPID(String paramString)
  {
    if (getDefaultInstance() != null)
    {
      defaultInstance.setUpid(1, paramString);
      defaultInstance.setUpid(0, paramString);
      defaultInstance.setUpid(3, paramString);
      defaultInstance.setUpid(2, paramString);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hianalytics\v2\HiAnalytics.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */