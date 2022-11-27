package com.huawei.hianalytics.b;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

public class a
  implements Thread.UncaughtExceptionHandler
{
  private static a d;
  private b a;
  private b b;
  private Thread.UncaughtExceptionHandler c;
  private String[] e = new String[0];
  private boolean f;
  private boolean g;
  private Context h;
  private String i = "";
  private String j = "";
  private Map<String, String> k = new HashMap();
  
  public static a a()
  {
    try
    {
      if (d == null) {
        d = new a();
      }
      a locala = d;
      return locala;
    }
    finally {}
  }
  
  /* Error */
  private void a(Context arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  private boolean a(String paramString)
  {
    return false;
  }
  
  private String b(Throwable paramThrowable)
  {
    return d(paramThrowable);
  }
  
  /* Error */
  private void b(Context arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  private String c(Throwable paramThrowable)
  {
    return null;
  }
  
  private String d(Throwable paramThrowable)
  {
    return null;
  }
  
  public void a(Context paramContext, b paramb)
  {
    this.a = paramb;
    this.g = true;
    a(paramContext);
  }
  
  public void a(Context paramContext, String[] paramArrayOfString, b paramb)
  {
    this.b = paramb;
    this.e = ((String[])paramArrayOfString.clone());
    this.f = true;
    a(paramContext);
  }
  
  public boolean a(Throwable paramThrowable)
  {
    return false;
  }
  
  /* Error */
  public void b()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void c()
  {
    this.g = false;
  }
  
  /* Error */
  public void uncaughtException(Thread arg1, Throwable arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hianalytics\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */