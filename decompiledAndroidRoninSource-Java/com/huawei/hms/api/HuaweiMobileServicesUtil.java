package com.huawei.hms.api;

import android.content.Context;
import android.os.Build.VERSION;
import com.huawei.hms.c.g;
import com.huawei.hms.c.g.a;

public abstract class HuaweiMobileServicesUtil
{
  public static int isHuaweiMobileServicesAvailable(Context paramContext, int paramInt)
  {
    com.huawei.hms.c.a.a(paramContext, "context must not be null.");
    if (Build.VERSION.SDK_INT < 16) {
      return 21;
    }
    paramContext = new g(paramContext);
    g.a locala = paramContext.a("com.huawei.hwid");
    if (g.a.c.equals(locala)) {
      return 1;
    }
    if (g.a.b.equals(locala)) {
      return 3;
    }
    if (!"B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05".equalsIgnoreCase(paramContext.c("com.huawei.hwid"))) {
      return 9;
    }
    int i = paramContext.b("com.huawei.hwid");
    paramContext = new StringBuilder();
    paramContext.append("connect versionCode:");
    paramContext.append(i);
    com.huawei.hms.support.log.a.b("HuaweiMobileServicesUtil", paramContext.toString());
    if (i < paramInt) {
      return 2;
    }
    return 0;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\api\HuaweiMobileServicesUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */