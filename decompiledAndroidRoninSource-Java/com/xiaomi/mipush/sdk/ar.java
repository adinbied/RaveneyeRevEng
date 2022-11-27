package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.ba;

public class ar
{
  public static AbstractPushManager a(Context paramContext, d paramd)
  {
    return b(paramContext, paramd);
  }
  
  private static AbstractPushManager b(Context paramContext, d paramd)
  {
    paramd = k.a(paramd);
    if ((paramd != null) && (!TextUtils.isEmpty(paramd.a)) && (!TextUtils.isEmpty(paramd.b))) {
      return (AbstractPushManager)ba.a(paramd.a, paramd.b, new Object[] { paramContext });
    }
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\mipush\sdk\ar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */