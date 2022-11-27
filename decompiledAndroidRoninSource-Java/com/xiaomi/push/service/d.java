package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import com.xiaomi.push.fn;
import com.xiaomi.push.gl;

public class d
{
  private p a = new p();
  
  public static String a(am.b paramb)
  {
    Object localObject2;
    Object localObject1;
    if (!"9".equals(paramb.g))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramb.a);
      localObject1 = ".permission.MIPUSH_RECEIVE";
      paramb = (am.b)localObject2;
    }
    for (;;)
    {
      paramb.append((String)localObject1);
      return paramb.toString();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramb.a);
      localObject2 = ".permission.MIMC_RECEIVE";
      paramb = (am.b)localObject1;
      localObject1 = localObject2;
    }
  }
  
  private static void a(Context paramContext, Intent paramIntent, am.b paramb)
  {
    if ("com.xiaomi.xmsf".equals(paramContext.getPackageName()))
    {
      paramContext.sendBroadcast(paramIntent);
      return;
    }
    paramContext.sendBroadcast(paramIntent, a(paramb));
  }
  
  am.b a(fn paramfn)
  {
    return null;
  }
  
  am.b a(gl paramgl)
  {
    return null;
  }
  
  /* Error */
  public void a(Context arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void a(Context arg1, am.b arg2, int arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void a(Context arg1, am.b arg2, String arg3, String arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void a(Context arg1, am.b arg2, boolean arg3, int arg4, String arg5)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void a(XMPushService arg1, String arg2, fn arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void a(XMPushService arg1, String arg2, gl arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\service\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */