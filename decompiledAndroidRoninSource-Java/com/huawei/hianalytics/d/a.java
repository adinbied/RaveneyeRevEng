package com.huawei.hianalytics.d;

import android.content.Context;
import android.util.Pair;
import com.huawei.hianalytics.a.d;

public class a
{
  private static a b;
  private Context a;
  
  public static a a()
  {
    try
    {
      if (b == null) {
        b = new a();
      }
      a locala = b;
      return locala;
    }
    finally {}
  }
  
  public com.huawei.hianalytics.c.a a(String paramString1, String paramString2)
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
  
  public Pair<String, String> b(String paramString1, String paramString2)
  {
    return null;
  }
  
  public com.huawei.hianalytics.c.a b()
  {
    return null;
  }
  
  public String c()
  {
    return null;
  }
  
  public String c(String paramString1, String paramString2)
  {
    return c.b(paramString1, paramString2);
  }
  
  public String d()
  {
    return null;
  }
  
  public String d(String paramString1, String paramString2)
  {
    return c.a(this.a, paramString1, paramString2);
  }
  
  public String e()
  {
    return null;
  }
  
  public String e(String paramString1, String paramString2)
  {
    return c.b(this.a, paramString1, paramString2);
  }
  
  public String f()
  {
    return null;
  }
  
  public String f(String paramString1, String paramString2)
  {
    return c.a(paramString1, paramString2);
  }
  
  public boolean g(String paramString1, String paramString2)
  {
    return c.c(paramString1, paramString2);
  }
  
  private static class a
    extends b
  {
    String a;
    String b;
    
    public a(String paramString1, String paramString2)
    {
      this.a = paramString1;
      this.b = paramString2;
    }
    
    public String a()
    {
      return null;
    }
    
    public String a(String paramString)
    {
      return com.huawei.hianalytics.util.c.a(paramString);
    }
    
    public String b()
    {
      return null;
    }
    
    public String c()
    {
      return null;
    }
    
    public int d()
    {
      return 0;
    }
  }
  
  private static class b
    extends b
  {
    public String a()
    {
      return d.p();
    }
    
    public String a(String paramString)
    {
      return paramString;
    }
    
    public String b()
    {
      return d.o();
    }
    
    public String c()
    {
      return d.q();
    }
    
    public int d()
    {
      return 0;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hianalytics\d\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */