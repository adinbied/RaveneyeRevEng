package com.huawei.appmarket.component.buoycircle.impl.bi;

import android.content.Context;
import com.huawei.appmarket.component.buoycircle.api.AppInfo;
import com.huawei.appmarket.component.buoycircle.api.IBuoyBIHandler;
import java.util.Map;

public class BuoyAnalyticHelper
{
  private static final String TAG = "BuoyAnalyticHelper";
  private static BuoyAnalyticHelper instance;
  private IBuoyBIHandler buoyBIHandler;
  
  private Builder getBaseBuilder(String paramString1, String paramString2, String paramString3)
  {
    return null;
  }
  
  public static BuoyAnalyticHelper getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new BuoyAnalyticHelper();
      }
      BuoyAnalyticHelper localBuoyAnalyticHelper = instance;
      return localBuoyAnalyticHelper;
    }
    finally {}
  }
  
  private String getPlayerId(String paramString)
  {
    return null;
  }
  
  private String getReportJson(Map<String, String> paramMap)
  {
    return null;
  }
  
  private boolean hasError(Context paramContext, AppInfo paramAppInfo)
  {
    return false;
  }
  
  private void onEventReport(String paramString1, String paramString2)
  {
    this.buoyBIHandler.onBIReport(paramString1, paramString2);
  }
  
  public void init(IBuoyBIHandler paramIBuoyBIHandler)
  {
    this.buoyBIHandler = paramIBuoyBIHandler;
  }
  
  /* Error */
  public void onReportClickSmallBuoy(Context arg1, AppInfo arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onReportHideSmallBuoy(Context arg1, AppInfo arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onReportOpenBigBuoyResult(Context arg1, AppInfo arg2, int arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onReportOpenSmallBuoyBySensor(Context arg1, AppInfo arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onReportShowBuoy(Context arg1, AppInfo arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onReportUpdateHiAppResult(Context arg1, String arg2, String arg3, String arg4, String arg5, int arg6)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static abstract interface BUOY
  {
    public static final String BUOY_HIDE_KEY = "15150806";
    public static final String BUOY_SENSOR_SHOW_KEY = "15150906";
    public static final String NUMBER_01 = "01";
    public static final String OPEN_BIG_KEY = "150106";
    public static final String OPEN_BIG_RESULT_KEY = "15150107";
    public static final String SHOW_BUOY_KEY = "15151012";
    public static final String UPDATE_HIAPP_KEY = "HMS_SDK_UPDATE";
  }
  
  private static class Builder
  {
    private StringBuffer buffer = new StringBuffer();
    
    Builder addTag(int paramInt)
    {
      return null;
    }
    
    Builder addTag(String paramString)
    {
      return null;
    }
    
    Builder appId(String paramString)
    {
      return addTag(paramString);
    }
    
    String build()
    {
      return this.buffer.toString();
    }
    
    Builder deviceModel(String paramString)
    {
      return addTag(paramString);
    }
    
    Builder emuiVersion(String paramString)
    {
      return addTag(paramString);
    }
    
    Builder fromPkg(String paramString)
    {
      return addTag(paramString);
    }
    
    Builder hasNetwork(boolean paramBoolean)
    {
      if (paramBoolean) {
        return addTag("01");
      }
      return addTag("02");
    }
    
    Builder playerId(String paramString)
    {
      return addTag(paramString);
    }
    
    Builder sdkVerCode(String paramString)
    {
      return addTag(paramString);
    }
    
    Builder startTag(String paramString)
    {
      this.buffer.append(paramString);
      return this;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\appmarket\component\buoycircle\impl\bi\BuoyAnalyticHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */