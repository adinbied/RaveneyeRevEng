package com.xiaomi.push;

import android.util.Pair;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.am.b;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class fu
{
  private static final AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  public static boolean a;
  protected int a;
  protected long a;
  protected fv a;
  protected gg a;
  protected XMPushService a;
  protected String a;
  private final Collection<fx> jdField_a_of_type_JavaUtilCollection = new CopyOnWriteArrayList();
  private LinkedList<Pair<Integer, Long>> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  protected final Map<fz, a> a;
  protected final int b;
  protected volatile long b;
  protected String b;
  protected final Map<fz, a> b;
  private int c;
  protected volatile long c;
  protected long d = 0L;
  private long e = 0L;
  
  static
  {
    jdField_a_of_type_Boolean = false;
    try
    {
      jdField_a_of_type_Boolean = Boolean.getBoolean("smack.debugEnabled");
      ga.a();
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  protected fu(XMPushService paramXMPushService, fv paramfv)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Long = -1L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
    this.jdField_b_of_type_JavaUtilMap = new ConcurrentHashMap();
    this.jdField_a_of_type_ComXiaomiPushGg = null;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_Int = 2;
    this.jdField_b_of_type_Int = jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement();
    this.jdField_a_of_type_ComXiaomiPushFv = paramfv;
    this.jdField_a_of_type_ComXiaomiPushServiceXMPushService = paramXMPushService;
    b();
  }
  
  private String a(int paramInt)
  {
    return null;
  }
  
  /* Error */
  private void a(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: return
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public long a()
  {
    return this.jdField_c_of_type_Long;
  }
  
  public fv a()
  {
    return this.jdField_a_of_type_ComXiaomiPushFv;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComXiaomiPushFv.c();
  }
  
  /* Error */
  public void a(int arg1, int arg2, Exception arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void a(fx arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void a(fz arg1, gh arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public abstract void a(gl paramgl);
  
  public abstract void a(am.b paramb);
  
  /* Error */
  public void a(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public abstract void a(String paramString1, String paramString2);
  
  public abstract void a(fn[] paramArrayOffn);
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(long paramLong)
  {
    return false;
  }
  
  public int b()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_ComXiaomiPushFv.b();
  }
  
  /* Error */
  protected void b()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public abstract void b(int paramInt, Exception paramException);
  
  public abstract void b(fn paramfn);
  
  public void b(fx paramfx)
  {
    this.jdField_a_of_type_JavaUtilCollection.remove(paramfx);
  }
  
  /* Error */
  public void b(fz arg1, gh arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public abstract void b(boolean paramBoolean);
  
  public boolean b()
  {
    return this.jdField_c_of_type_Int == 0;
  }
  
  /* Error */
  public void c()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public boolean c()
  {
    return this.jdField_c_of_type_Int == 1;
  }
  
  /* Error */
  public void d()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public boolean d()
  {
    return false;
  }
  
  public boolean e()
  {
    return false;
  }
  
  public static class a
  {
    private fz jdField_a_of_type_ComXiaomiPushFz;
    private gh jdField_a_of_type_ComXiaomiPushGh;
    
    public a(fz paramfz, gh paramgh)
    {
      this.jdField_a_of_type_ComXiaomiPushFz = paramfz;
      this.jdField_a_of_type_ComXiaomiPushGh = paramgh;
    }
    
    public void a(fn paramfn)
    {
      this.jdField_a_of_type_ComXiaomiPushFz.a(paramfn);
    }
    
    /* Error */
    public void a(gl arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\fu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */