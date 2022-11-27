package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.ho;
import com.xiaomi.push.hy;
import com.xiaomi.push.in;
import com.xiaomi.push.service.ak;

public class MiPushClient4VR
{
  public static void uploadData(Context paramContext, String paramString)
  {
    in localin = new in();
    localin.c(hy.N.a);
    localin.b(b.a(paramContext).a());
    localin.d(paramContext.getPackageName());
    localin.a("data", paramString);
    localin.a(ak.a());
    aw.a(paramContext).a(localin, ho.i, null);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\mipush\sdk\MiPushClient4VR.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */