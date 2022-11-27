package com.huawei.hianalytics.process;

import java.util.List;

public abstract class HiAnalyticsManager
{
  public static void clearCachedData()
  {
    a.b().e();
  }
  
  public static List<String> getAllTags()
  {
    return a.b().c();
  }
  
  public static boolean getInitFlag(String paramString)
  {
    return a.b().b(paramString);
  }
  
  public static HiAnalyticsInstance getInstanceByTag(String paramString)
  {
    return a.b().a(paramString);
  }
  
  public static HiAnalyticsInstanceEx getInstanceEx()
  {
    return a.b().d();
  }
  
  public static void setAppid(String paramString)
  {
    a.b().d(paramString);
  }
  
  public static void setCacheSize(int paramInt)
  {
    a.b().a(paramInt);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hianalytics\process\HiAnalyticsManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */