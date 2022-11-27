package com.huawei.updatesdk.support.d;

import java.util.ArrayList;
import java.util.List;

public final class c
{
  private static c a = new c();
  private static a b = new a()
  {
    private final List<b> a = new ArrayList();
    
    /* Error */
    public void a(int arg1, com.huawei.updatesdk.sdk.service.secure.a arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_2
      //   2: return
    }
    
    /* Error */
    public void a(b arg1)
    {
      // Byte code:
      //   0: goto +9 -> 9
      //   3: goto +6 -> 9
      //   6: return
      //   7: astore_1
      //   8: return
      //   9: goto -3 -> 6
    }
    
    /* Error */
    public void b(b arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
  };
  
  public static c a()
  {
    return a;
  }
  
  public static a b()
  {
    return b;
  }
  
  public void a(com.huawei.updatesdk.sdk.service.secure.a parama)
  {
    b.a(0, parama);
  }
  
  public void b(com.huawei.updatesdk.sdk.service.secure.a parama)
  {
    b.a(1, parama);
  }
  
  public void c(com.huawei.updatesdk.sdk.service.secure.a parama)
  {
    b.a(2, parama);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawe\\updatesdk\support\d\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */