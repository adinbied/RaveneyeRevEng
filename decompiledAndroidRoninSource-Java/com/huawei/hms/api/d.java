package com.huawei.hms.api;

import android.app.Activity;
import android.content.Context;
import com.huawei.hms.activity.BridgeActivity;

final class d
  extends HuaweiApiAvailability
{
  private static final d a = new d();
  
  public static d a()
  {
    return a;
  }
  
  private static void a(Activity paramActivity, String paramString, int paramInt)
  {
    paramActivity.startActivityForResult(BridgeActivity.getIntentStartBridgeActivity(paramActivity, paramString), paramInt);
  }
  
  public int isHuaweiMobileNoticeAvailable(Context paramContext)
  {
    return 0;
  }
  
  public int isHuaweiMobileServicesAvailable(Context paramContext, int paramInt)
  {
    return 0;
  }
  
  public boolean isUserResolvableError(int paramInt)
  {
    return false;
  }
  
  /* Error */
  public void resolveError(Activity arg1, int arg2, int arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\api\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */