package com.huawei.hianalytics.log.d;

import android.content.Context;

public class a
{
  private static a b;
  private static final Object c = new Object();
  private Context a;
  
  public static a a()
  {
    if (b == null) {
      b();
    }
    return b;
  }
  
  private static void b()
  {
    try
    {
      if (b == null) {
        b = new a();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  private void c()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void a(Context arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void a(boolean arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hianalytics\log\d\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */