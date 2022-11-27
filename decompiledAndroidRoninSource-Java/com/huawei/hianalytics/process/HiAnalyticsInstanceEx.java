package com.huawei.hianalytics.process;

import android.content.Context;
import com.huawei.hianalytics.global.AutoCollectEventType;
import java.util.List;

public abstract interface HiAnalyticsInstanceEx
  extends HiAnalyticsInstance
{
  public abstract void enableLogCollection(Context paramContext, HiAnalyticsLogConfig paramHiAnalyticsLogConfig);
  
  @Deprecated
  public abstract void handleV1Cache();
  
  public abstract void onStartApp(String paramString1, String paramString2);
  
  public abstract void refreshLogCollection(HiAnalyticsLogConfig paramHiAnalyticsLogConfig, boolean paramBoolean);
  
  public static final class Builder
  {
    private HiAnalyticsConfig diffConf = null;
    private List<AutoCollectEventType> lsCollectTypes = null;
    private Context mContext;
    private HiAnalyticsConfig maintConf = null;
    private HiAnalyticsConfig operConf = null;
    
    public Builder(Context paramContext)
    {
      this.mContext = paramContext;
    }
    
    /* Error */
    private void setConfEx(d arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public Builder autoCollect(List<AutoCollectEventType> paramList)
    {
      this.lsCollectTypes = paramList;
      return this;
    }
    
    public HiAnalyticsInstanceEx create()
    {
      return null;
    }
    
    public HiAnalyticsInstanceEx refresh()
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hianalytics\process\HiAnalyticsInstanceEx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */