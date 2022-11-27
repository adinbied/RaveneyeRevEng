package com.huawei.hianalytics.v2;

import android.content.Context;
import com.huawei.hianalytics.process.HiAnalyticsConfig.Builder;
import com.huawei.hianalytics.process.HiAnalyticsLogConfig;

public class HiAnalyticsConf
{
  public static class Builder
  {
    String appid;
    HiAnalyticsConfig.Builder diffConfigBuilder;
    HiAnalyticsLogConfig logConfig;
    Context mContext;
    HiAnalyticsConfig.Builder maintConfigBuilder;
    HiAnalyticsConfig.Builder operConfigBuilder;
    HiAnalyticsConfig.Builder preConfigBuilder;
    
    public Builder(Context paramContext)
    {
      this.mContext = paramContext;
      this.maintConfigBuilder = new HiAnalyticsConfig.Builder();
      this.operConfigBuilder = new HiAnalyticsConfig.Builder();
      this.diffConfigBuilder = new HiAnalyticsConfig.Builder();
      this.preConfigBuilder = new HiAnalyticsConfig.Builder();
    }
    
    /* Error */
    public void create()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void refresh(boolean arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_2
      //   2: goto -2 -> 0
    }
    
    public Builder setAndroidId(String paramString)
    {
      return null;
    }
    
    public Builder setAppID(String paramString)
    {
      return null;
    }
    
    public Builder setAutoReportThreshold(int paramInt)
    {
      return null;
    }
    
    public Builder setCacheExpireTime(int paramInt)
    {
      return null;
    }
    
    public Builder setChannel(String paramString)
    {
      return null;
    }
    
    public Builder setCollectURL(int paramInt, String paramString)
    {
      return null;
    }
    
    @Deprecated
    public Builder setEnableAndroidID(boolean paramBoolean)
    {
      return null;
    }
    
    public Builder setEnableCollectLog(HiAnalyticsLogConfig paramHiAnalyticsLogConfig)
    {
      return null;
    }
    
    @Deprecated
    public Builder setEnableImei(boolean paramBoolean)
    {
      return null;
    }
    
    public Builder setEnableMccMnc(boolean paramBoolean)
    {
      return null;
    }
    
    @Deprecated
    public Builder setEnableSN(boolean paramBoolean)
    {
      return null;
    }
    
    public Builder setEnableSession(boolean paramBoolean)
    {
      return null;
    }
    
    @Deprecated
    public Builder setEnableUDID(boolean paramBoolean)
    {
      return null;
    }
    
    public Builder setEnableUUID(boolean paramBoolean)
    {
      return null;
    }
    
    public Builder setIMEI(String paramString)
    {
      return null;
    }
    
    public Builder setSN(String paramString)
    {
      return null;
    }
    
    public Builder setUDID(String paramString)
    {
      return null;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hianalytics\v2\HiAnalyticsConf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */