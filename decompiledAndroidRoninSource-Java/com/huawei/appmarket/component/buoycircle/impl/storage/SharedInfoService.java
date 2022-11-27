package com.huawei.appmarket.component.buoycircle.impl.storage;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedInfoService
{
  private static SharedInfoService util;
  private SharedPreferences mPreferences;
  
  private SharedInfoService(Context paramContext)
  {
    this.mPreferences = paramContext.getSharedPreferences("DeviceSession", 0);
  }
  
  public static SharedInfoService getInstance(Context paramContext)
  {
    try
    {
      if (util == null) {
        util = new SharedInfoService(paramContext);
      }
      paramContext = util;
      return paramContext;
    }
    finally {}
  }
  
  public float getPositionXPercent()
  {
    return 0.0F;
  }
  
  public float getPositionYPercent()
  {
    return 0.0F;
  }
  
  /* Error */
  public void setPositionXPercent(float arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setPositionYPercent(float arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  public static abstract interface SharedKeys
  {
    public static final String POSITION_X_PERCENT_KEY_PARAM = "buoy.positionxpercent.key.param";
    public static final String POSITION_Y_PERCENT_KEY_PARAM = "buoy.positionypercent.key.param";
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\appmarket\component\buoycircle\impl\storage\SharedInfoService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */