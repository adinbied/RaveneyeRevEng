package com.huawei.hms.support.api.push.a.c;

import android.content.Context;
import android.content.Intent;

public class h
  extends Thread
{
  private Context a;
  private com.huawei.hms.support.api.push.a.b.a b;
  private String c;
  
  public h(Context paramContext, com.huawei.hms.support.api.push.a.b.a parama, String paramString)
  {
    this.a = paramContext;
    this.b = parama;
    this.c = paramString;
  }
  
  private static Intent b(Context paramContext, com.huawei.hms.support.api.push.a.b.a parama)
  {
    if (parama == null) {
      return null;
    }
    Intent localIntent1 = com.huawei.hms.support.api.push.a.d.a.b(paramContext, parama.s());
    if (parama.g() != null) {}
    try
    {
      localIntent2 = Intent.parseUri(parama.g(), 0);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Intent.parseUri(msg.intentUri, 0)，");
      ((StringBuilder)localObject).append(localIntent2.toURI());
      com.huawei.hms.support.log.a.a("PushSelfShowLog", ((StringBuilder)localObject).toString());
      boolean bool = com.huawei.hms.support.api.push.a.d.a.a(paramContext, parama.s(), localIntent2).booleanValue();
      localObject = localIntent1;
      if (!bool) {
        break label165;
      }
      return localIntent2;
    }
    catch (RuntimeException paramContext)
    {
      Intent localIntent2;
      Object localObject;
      for (;;) {}
    }
    catch (Exception paramContext)
    {
      for (;;) {}
    }
    com.huawei.hms.support.log.a.c("PushSelfShowLog", "intentUri error");
    return localIntent1;
    com.huawei.hms.support.log.a.c("PushSelfShowLog", "intentUri error");
    return localIntent1;
    localObject = localIntent1;
    if (parama.t() != null)
    {
      localIntent2 = new Intent(parama.t());
      localObject = localIntent1;
      if (com.huawei.hms.support.api.push.a.d.a.a(paramContext, parama.s(), localIntent2).booleanValue()) {
        localObject = localIntent2;
      }
    }
    ((Intent)localObject).setPackage(parama.s());
    label165:
    return (Intent)localObject;
  }
  
  public boolean a(Context paramContext)
  {
    return false;
  }
  
  public boolean a(Context paramContext, com.huawei.hms.support.api.push.a.b.a parama)
  {
    return false;
  }
  
  public boolean b(Context paramContext)
  {
    return false;
  }
  
  public boolean c(Context paramContext)
  {
    return com.huawei.hms.support.api.push.a.d.a.a(paramContext);
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\push\a\c\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */