package com.huawei.updatesdk.sdk.service.download.bean;

public class b
{
  private static int a = ;
  private static final Object g = new Object();
  private int b = -1;
  private int c = -1;
  private long d = 0L;
  private long e = 0L;
  private long f = 0L;
  
  public b() {}
  
  public b(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramLong1;
    this.e = paramLong2;
  }
  
  public static int a()
  {
    synchronized (g)
    {
      int i = a + 1;
      a = i;
      if (i == Integer.MIN_VALUE) {
        a = com.huawei.updatesdk.sdk.a.d.a.b.a();
      }
      i = a;
      return i;
    }
  }
  
  public void a(long paramLong)
  {
    this.f = paramLong;
  }
  
  public long b()
  {
    return this.d;
  }
  
  public long c()
  {
    return this.e;
  }
  
  public long d()
  {
    return this.f;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawe\\updatesdk\sdk\service\download\bean\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */