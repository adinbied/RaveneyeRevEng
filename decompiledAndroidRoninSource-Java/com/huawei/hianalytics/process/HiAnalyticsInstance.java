package com.huawei.hianalytics.process;

import android.content.Context;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract interface HiAnalyticsInstance
{
  public abstract void clearData();
  
  public abstract void onBackground(long paramLong);
  
  public abstract void onEvent(int paramInt, String paramString, LinkedHashMap<String, String> paramLinkedHashMap);
  
  @Deprecated
  public abstract void onEvent(Context paramContext, String paramString1, String paramString2);
  
  public abstract void onEvent(String paramString, LinkedHashMap<String, String> paramLinkedHashMap);
  
  public abstract void onForeground(long paramLong);
  
  public abstract void onPause(Context paramContext);
  
  public abstract void onPause(Context paramContext, LinkedHashMap<String, String> paramLinkedHashMap);
  
  public abstract void onPause(String paramString, LinkedHashMap<String, String> paramLinkedHashMap);
  
  public abstract void onReport(int paramInt);
  
  @Deprecated
  public abstract void onReport(Context paramContext, int paramInt);
  
  public abstract void onResume(Context paramContext);
  
  public abstract void onResume(Context paramContext, LinkedHashMap<String, String> paramLinkedHashMap);
  
  public abstract void onResume(String paramString, LinkedHashMap<String, String> paramLinkedHashMap);
  
  public abstract void onStreamEvent(int paramInt, String paramString, LinkedHashMap<String, String> paramLinkedHashMap);
  
  public abstract void refresh(int paramInt, HiAnalyticsConfig paramHiAnalyticsConfig);
  
  public abstract void setCommonProp(int paramInt, Map<String, String> paramMap);
  
  public abstract void setOAID(int paramInt, String paramString);
  
  public abstract void setOAIDTrackingFlag(int paramInt, boolean paramBoolean);
  
  public abstract void setUpid(int paramInt, String paramString);
  
  public static final class Builder
  {
    private HiAnalyticsConfig diffConf = null;
    private Context mContext;
    private HiAnalyticsConfig maintConf = null;
    private HiAnalyticsConfig operConf = null;
    
    public Builder(Context paramContext)
    {
      this.mContext = paramContext;
    }
    
    /* Error */
    private void setConf(d arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public HiAnalyticsInstance create(String paramString)
    {
      return null;
    }
    
    public HiAnalyticsInstance refresh(String paramString)
    {
      return null;
    }
    
    public Builder setDiffConf(HiAnalyticsConfig paramHiAnalyticsConfig)
    {
      this.diffConf = paramHiAnalyticsConfig;
      return this;
    }
    
    public Builder setMaintConf(HiAnalyticsConfig paramHiAnalyticsConfig)
    {
      this.maintConf = paramHiAnalyticsConfig;
      return this;
    }
    
    public Builder setOperConf(HiAnalyticsConfig paramHiAnalyticsConfig)
    {
      this.operConf = paramHiAnalyticsConfig;
      return this;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hianalytics\process\HiAnalyticsInstance.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */