package com.huawei.hms.support.b;

import android.content.Context;
import java.util.Map;

public class a
{
  private static a a;
  private static final Object b = new Object();
  
  public static a a()
  {
    synchronized (b)
    {
      if (a == null) {
        a = new a();
      }
      a locala = a;
      return locala;
    }
  }
  
  private String a(Context paramContext, String paramString)
  {
    return null;
  }
  
  private String a(Map<String, String> paramMap)
  {
    return null;
  }
  
  /* Error */
  public void a(Context arg1, String arg2, String arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void a(Context arg1, String arg2, Map<String, String> arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void b(Context arg1, String arg2, String arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean b()
  {
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */