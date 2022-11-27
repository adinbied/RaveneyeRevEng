package com.huawei.updatesdk.service.a;

public final class c
{
  private static c a;
  private static final Object c = new Object();
  private String[] b = { "" };
  
  public static c a()
  {
    synchronized (c)
    {
      if (a == null) {
        a = new c();
      }
      c localc = a;
      return localc;
    }
  }
  
  public String b()
  {
    return null;
  }
  
  protected static enum a
  {
    static
    {
      a locala = new a("TEST", 3);
      d = locala;
      e = new a[] { a, b, c, locala };
    }
    
    private a() {}
  }
  
  private static enum b
  {
    static
    {
      b localb = new b("STORE_URL", 0);
      a = localb;
      b = new b[] { localb };
    }
    
    private b() {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawe\\updatesdk\service\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */