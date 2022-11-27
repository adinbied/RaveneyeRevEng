package com.xiaomi.push;

import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.am.b;
import java.util.Hashtable;

public class hi
{
  private static final int a = fj.c.a();
  
  public static void a()
  {
    a(0, a);
  }
  
  public static void a(int paramInt)
  {
    fk localfk = hg.a().a();
    localfk.a(fj.ac.a());
    localfk.c(paramInt);
    hg.a().a(localfk);
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    if (paramInt2 < 16777215) {}
    try
    {
      a.a.put(Integer.valueOf(paramInt1 << 24 | paramInt2), Long.valueOf(System.currentTimeMillis()));
      break label39;
      b.d("stats key should less than 16777215");
      label39:
      return;
    }
    finally {}
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, String paramString, int paramInt4)
  {
    fk localfk = hg.a().a();
    localfk.a((byte)paramInt1);
    localfk.a(paramInt2);
    localfk.b(paramInt3);
    localfk.b(paramString);
    localfk.c(paramInt4);
    hg.a().a(localfk);
  }
  
  public static void a(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    try
    {
      long l = System.currentTimeMillis();
      paramInt1 = paramInt1 << 24 | paramInt2;
      if (a.a.containsKey(Integer.valueOf(paramInt1)))
      {
        fk localfk = hg.a().a();
        localfk.a(paramInt2);
        localfk.b((int)(l - ((Long)a.a.get(Integer.valueOf(paramInt1))).longValue()));
        localfk.b(paramString);
        if (paramInt3 > -1) {
          localfk.c(paramInt3);
        }
        hg.a().a(localfk);
        a.a.remove(Integer.valueOf(paramInt2));
      }
      else
      {
        b.d("stats key not found");
      }
      return;
    }
    finally {}
  }
  
  public static void a(XMPushService paramXMPushService, am.b paramb)
  {
    new hb(paramXMPushService, paramb).a();
  }
  
  public static void a(String paramString, int paramInt, Exception paramException)
  {
    fk localfk = hg.a().a();
    if (paramInt > 0)
    {
      localfk.a(fj.i.a());
      localfk.b(paramString);
      localfk.b(paramInt);
      hg.a().a(localfk);
      return;
    }
    try
    {
      paramException = he.a(paramException);
      localfk.a(paramException.jdField_a_of_type_ComXiaomiPushFj.a());
      localfk.c(paramException.jdField_a_of_type_JavaLangString);
      localfk.b(paramString);
      hg.a().a(localfk);
      return;
    }
    catch (NullPointerException paramString) {}
  }
  
  public static void a(String paramString, Exception paramException)
  {
    try
    {
      paramException = he.b(paramException);
      fk localfk = hg.a().a();
      localfk.a(paramException.jdField_a_of_type_ComXiaomiPushFj.a());
      localfk.c(paramException.jdField_a_of_type_JavaLangString);
      localfk.b(paramString);
      hg.a().a(localfk);
      return;
    }
    catch (NullPointerException paramString) {}
  }
  
  public static byte[] a()
  {
    fl localfl = hg.a().a();
    if (localfl != null) {
      return iy.a(localfl);
    }
    return null;
  }
  
  public static void b()
  {
    a(0, a, null, -1);
  }
  
  public static void b(String paramString, Exception paramException)
  {
    try
    {
      paramException = he.d(paramException);
      fk localfk = hg.a().a();
      localfk.a(paramException.jdField_a_of_type_ComXiaomiPushFj.a());
      localfk.c(paramException.jdField_a_of_type_JavaLangString);
      localfk.b(paramString);
      hg.a().a(localfk);
      return;
    }
    catch (NullPointerException paramString) {}
  }
  
  static class a
  {
    static Hashtable<Integer, Long> a = new Hashtable();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\hi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */