package com.huawei.hms.api;

import android.app.Activity;
import android.content.Context;
import java.util.HashMap;
import java.util.Map;

public abstract class HuaweiApiAvailability
{
  public static final String ACTIVITY_NAME = "com.huawei.hms.core.activity.JumpActivity";
  public static final String APPID_HMS = "C10132067";
  public static final String HMS_API_NAME_GAME = "HuaweiGame.API";
  public static final String HMS_API_NAME_ID = "HuaweiID.API";
  public static final String HMS_API_NAME_OD = "HuaweiOpenDevice.API";
  public static final String HMS_API_NAME_PAY = "HuaweiPay.API";
  public static final String HMS_API_NAME_PUSH = "HuaweiPush.API";
  public static final String HMS_API_NAME_SNS = "HuaweiSns.API";
  public static final int HMS_SDK_VERSION_CODE = 20603301;
  public static final String HMS_SDK_VERSION_NAME = "2.6.3.301";
  public static final int HMS_VERSION_CODE_GAME = 20503000;
  public static final int HMS_VERSION_CODE_ID = 20503000;
  public static final int HMS_VERSION_CODE_MIN = 20503000;
  public static final int HMS_VERSION_CODE_OD = 20601000;
  public static final int HMS_VERSION_CODE_PAY = 20503000;
  public static final int HMS_VERSION_CODE_PUSH = 20503000;
  public static final int HMS_VERSION_CODE_SNS = 20503000;
  public static final int HMS_VERSION_MAX = 20600000;
  public static final int HMS_VERSION_MIN = 20503000;
  public static final int NOTICE_VERSION_CODE = 20600000;
  public static final String SERVICES_ACTION = "com.huawei.hms.core.aidlservice";
  public static final String SERVICES_PACKAGE = "com.huawei.hwid";
  public static final String SERVICES_SIGNATURE = "B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05";
  private static int a;
  private static final Map<String, Integer> b;
  
  static
  {
    HashMap localHashMap = new HashMap();
    b = localHashMap;
    Integer localInteger = Integer.valueOf(20503000);
    localHashMap.put("HuaweiID.API", localInteger);
    b.put("HuaweiSns.API", localInteger);
    b.put("HuaweiPay.API", localInteger);
    b.put("HuaweiPush.API", localInteger);
    b.put("HuaweiGame.API", localInteger);
    b.put("HuaweiOpenDevice.API", Integer.valueOf(20601000));
  }
  
  public static Map<String, Integer> getApiMap()
  {
    return b;
  }
  
  public static HuaweiApiAvailability getInstance()
  {
    return d.a();
  }
  
  public static int getServicesVersionCode()
  {
    return a;
  }
  
  public static void setServicesVersionCode(int paramInt)
  {
    a = paramInt;
  }
  
  public abstract int isHuaweiMobileNoticeAvailable(Context paramContext);
  
  public abstract int isHuaweiMobileServicesAvailable(Context paramContext, int paramInt);
  
  public abstract boolean isUserResolvableError(int paramInt);
  
  public abstract void resolveError(Activity paramActivity, int paramInt1, int paramInt2);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\api\HuaweiApiAvailability.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */