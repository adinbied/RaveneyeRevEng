package com.huawei.updatesdk.service.a;

import android.content.Context;
import com.huawei.updatesdk.sdk.service.a.a;

public final class b
{
  private static final byte[] a = new byte[0];
  private static final Object b = new Object();
  private static b c;
  private d d;
  private String e;
  
  private b(Context paramContext)
  {
    this.d = d.a("DeviceSessionUpdateSDK_V1", paramContext);
  }
  
  public static b a()
  {
    synchronized (b)
    {
      if (c == null) {
        c = new b(a.a().b());
      }
      b localb = c;
      return localb;
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (paramInt == 3) {
      e(paramString);
    }
  }
  
  /* Error */
  public void a(long arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  public void a(String paramString)
  {
    this.d.a("appstore.client.sign.param", paramString);
  }
  
  public String b()
  {
    return null;
  }
  
  /* Error */
  public void b(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public String c()
  {
    return null;
  }
  
  /* Error */
  public void c(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public long d()
  {
    return 1006646474L;
  }
  
  public void d(String paramString)
  {
    this.e = paramString;
  }
  
  public String e()
  {
    return null;
  }
  
  /* Error */
  public void e(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public String f()
  {
    return this.e;
  }
  
  public String g()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawe\\updatesdk\service\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */