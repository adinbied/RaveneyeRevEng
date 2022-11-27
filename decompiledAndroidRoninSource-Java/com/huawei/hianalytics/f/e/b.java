package com.huawei.hianalytics.f.e;

import java.util.UUID;

public class b
{
  private volatile boolean a = false;
  private volatile long b = 0L;
  private a c = null;
  
  public String a()
  {
    return null;
  }
  
  /* Error */
  void a(long arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void b(long arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: return
  }
  
  public boolean b()
  {
    return false;
  }
  
  /* Error */
  public void c()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void c(long arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: return
  }
  
  private class a
  {
    String a = UUID.randomUUID().toString().replace("-", "");
    boolean b;
    private long d;
    
    a(long paramLong)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.a);
      localStringBuilder.append("_");
      localStringBuilder.append(paramLong);
      this.a = localStringBuilder.toString();
      this.d = paramLong;
      this.b = true;
      b.a(b.this, false);
    }
    
    private boolean a(long paramLong1, long paramLong2)
    {
      return false;
    }
    
    /* Error */
    private void b(long arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_3
      //   2: goto -2 -> 0
    }
    
    private boolean b(long paramLong1, long paramLong2)
    {
      return false;
    }
    
    /* Error */
    void a(long arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_3
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hianalytics\f\e\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */