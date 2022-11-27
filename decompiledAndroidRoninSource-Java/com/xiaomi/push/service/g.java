package com.xiaomi.push.service;

import android.os.SystemClock;

public class g
{
  private static long jdField_a_of_type_Long;
  private static long b;
  private static long c;
  private final a jdField_a_of_type_ComXiaomiPushServiceG$a;
  private final c jdField_a_of_type_ComXiaomiPushServiceG$c;
  
  static
  {
    long l2 = SystemClock.elapsedRealtime();
    long l1 = 0L;
    if (l2 > 0L) {
      l1 = SystemClock.elapsedRealtime();
    }
    jdField_a_of_type_Long = l1;
    b = l1;
  }
  
  public g()
  {
    this(false);
  }
  
  public g(String paramString)
  {
    this(paramString, false);
  }
  
  public g(String paramString, boolean paramBoolean)
  {
    if (paramString != null)
    {
      paramString = new c(paramString, paramBoolean);
      this.jdField_a_of_type_ComXiaomiPushServiceG$c = paramString;
      this.jdField_a_of_type_ComXiaomiPushServiceG$a = new a(paramString);
      return;
    }
    throw new NullPointerException("name == null");
  }
  
  public g(boolean paramBoolean)
  {
    this(localStringBuilder.toString(), paramBoolean);
  }
  
  static long a()
  {
    try
    {
      long l = SystemClock.elapsedRealtime();
      if (l > b) {
        jdField_a_of_type_Long += l - b;
      }
      b = l;
      l = jdField_a_of_type_Long;
      return l;
    }
    finally {}
  }
  
  private static long b()
  {
    try
    {
      long l = c;
      c = 1L + l;
      return l;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  private void b(b arg1, long arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComXiaomiPushServiceG$c.a();
  }
  
  /* Error */
  public void a(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: return
  }
  
  /* Error */
  public void a(int arg1, b arg2)
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
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void a(b arg1, long arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComXiaomiPushServiceG$c.a();
  }
  
  public boolean a(int paramInt)
  {
    return false;
  }
  
  /* Error */
  public void b()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  private static final class a
  {
    private final g.c a;
    
    a(g.c paramc)
    {
      this.a = paramc;
    }
    
    /* Error */
    protected void finalize()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
  }
  
  public static abstract class b
    implements Runnable
  {
    protected int a;
    
    public b(int paramInt)
    {
      this.a = paramInt;
    }
  }
  
  private static final class c
    extends Thread
  {
    private volatile long jdField_a_of_type_Long = 0L;
    private a jdField_a_of_type_ComXiaomiPushServiceG$c$a = new a(null);
    private volatile boolean jdField_a_of_type_Boolean = false;
    private long jdField_b_of_type_Long = 50L;
    private boolean jdField_b_of_type_Boolean;
    private boolean c;
    
    c(String paramString, boolean paramBoolean)
    {
      setName(paramString);
      setDaemon(paramBoolean);
      start();
    }
    
    /* Error */
    private void a(g.d arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void a()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    public boolean a()
    {
      return false;
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    private static final class a
    {
      private int jdField_a_of_type_Int = 256;
      private g.d[] jdField_a_of_type_ArrayOfComXiaomiPushServiceG$d = new g.d['Ā'];
      private int b = 0;
      private int c = 0;
      
      private int a(g.d paramd)
      {
        return 0;
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
      private void c(int arg1)
      {
        // Byte code:
        //   0: return
        //   1: astore_2
        //   2: goto -2 -> 0
      }
      
      public g.d a()
      {
        return this.jdField_a_of_type_ArrayOfComXiaomiPushServiceG$d[0];
      }
      
      /* Error */
      public void a()
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: goto -2 -> 0
      }
      
      /* Error */
      public void a(int arg1)
      {
        // Byte code:
        //   0: return
        //   1: astore_2
        //   2: goto -2 -> 0
      }
      
      /* Error */
      public void a(int arg1, g.b arg2)
      {
        // Byte code:
        //   0: return
        //   1: astore_2
        //   2: goto -2 -> 0
      }
      
      /* Error */
      public void a(g.d arg1)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: goto -2 -> 0
      }
      
      public boolean a()
      {
        return this.b == 0;
      }
      
      public boolean a(int paramInt)
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
      
      /* Error */
      public void b(int arg1)
      {
        // Byte code:
        //   0: return
        //   1: astore_2
        //   2: goto -2 -> 0
      }
    }
  }
  
  static class d
  {
    int jdField_a_of_type_Int;
    long jdField_a_of_type_Long;
    g.b jdField_a_of_type_ComXiaomiPushServiceG$b;
    final Object jdField_a_of_type_JavaLangObject;
    boolean jdField_a_of_type_Boolean;
    private long b;
    
    d()
    {
      this.a = new Object();
    }
    
    /* Error */
    void a(long arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_3
      //   2: return
    }
    
    public boolean a()
    {
      return false;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\service\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */