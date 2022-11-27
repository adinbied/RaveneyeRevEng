package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ib
  implements iz<ib, Object>, Serializable, Cloneable
{
  private static final jh jdField_a_of_type_ComXiaomiPushJh;
  private static final jp jdField_a_of_type_ComXiaomiPushJp = new jp("PushMetaInfo");
  private static final jh b;
  private static final jh c;
  private static final jh d;
  private static final jh e;
  private static final jh f = new jh("", (byte)8, (short)6);
  private static final jh g = new jh("", (byte)11, (short)7);
  private static final jh h = new jh("", (byte)8, (short)8);
  private static final jh i = new jh("", (byte)8, (short)9);
  private static final jh j = new jh("", (byte)13, (short)10);
  private static final jh k = new jh("", (byte)13, (short)11);
  private static final jh l = new jh("", (byte)2, (short)12);
  private static final jh m = new jh("", (byte)13, (short)13);
  public int a;
  public long a;
  public String a;
  private BitSet jdField_a_of_type_JavaUtilBitSet;
  public Map<String, String> a;
  public boolean a;
  public int b;
  public String b;
  public Map<String, String> b;
  public int c;
  public String c;
  public Map<String, String> c;
  public String d;
  public String e;
  
  static
  {
    jdField_a_of_type_ComXiaomiPushJh = new jh("", (byte)11, (short)1);
    jdField_b_of_type_ComXiaomiPushJh = new jh("", (byte)10, (short)2);
    jdField_c_of_type_ComXiaomiPushJh = new jh("", (byte)11, (short)3);
    jdField_d_of_type_ComXiaomiPushJh = new jh("", (byte)11, (short)4);
    jdField_e_of_type_ComXiaomiPushJh = new jh("", (byte)11, (short)5);
  }
  
  public ib()
  {
    this.jdField_a_of_type_JavaUtilBitSet = new BitSet(5);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public ib(ib paramib)
  {
    Object localObject1 = new BitSet(5);
    this.jdField_a_of_type_JavaUtilBitSet = ((BitSet)localObject1);
    ((BitSet)localObject1).clear();
    this.jdField_a_of_type_JavaUtilBitSet.or(paramib.jdField_a_of_type_JavaUtilBitSet);
    if (paramib.a()) {
      this.jdField_a_of_type_JavaLangString = paramib.jdField_a_of_type_JavaLangString;
    }
    this.jdField_a_of_type_Long = paramib.jdField_a_of_type_Long;
    if (paramib.c()) {
      this.jdField_b_of_type_JavaLangString = paramib.jdField_b_of_type_JavaLangString;
    }
    if (paramib.d()) {
      this.jdField_c_of_type_JavaLangString = paramib.jdField_c_of_type_JavaLangString;
    }
    if (paramib.e()) {
      this.jdField_d_of_type_JavaLangString = paramib.jdField_d_of_type_JavaLangString;
    }
    this.jdField_a_of_type_Int = paramib.jdField_a_of_type_Int;
    if (paramib.g()) {
      this.jdField_e_of_type_JavaLangString = paramib.jdField_e_of_type_JavaLangString;
    }
    this.jdField_b_of_type_Int = paramib.jdField_b_of_type_Int;
    this.jdField_c_of_type_Int = paramib.jdField_c_of_type_Int;
    Object localObject2;
    Map.Entry localEntry;
    if (paramib.j())
    {
      localObject1 = new HashMap();
      localObject2 = paramib.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localEntry = (Map.Entry)((Iterator)localObject2).next();
        ((Map)localObject1).put((String)localEntry.getKey(), (String)localEntry.getValue());
      }
      this.jdField_a_of_type_JavaUtilMap = ((Map)localObject1);
    }
    if (paramib.k())
    {
      localObject1 = new HashMap();
      localObject2 = paramib.jdField_b_of_type_JavaUtilMap.entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localEntry = (Map.Entry)((Iterator)localObject2).next();
        ((Map)localObject1).put((String)localEntry.getKey(), (String)localEntry.getValue());
      }
      this.jdField_b_of_type_JavaUtilMap = ((Map)localObject1);
    }
    this.jdField_a_of_type_Boolean = paramib.jdField_a_of_type_Boolean;
    if (paramib.n())
    {
      localObject1 = new HashMap();
      paramib = paramib.jdField_c_of_type_JavaUtilMap.entrySet().iterator();
      while (paramib.hasNext())
      {
        localObject2 = (Map.Entry)paramib.next();
        ((Map)localObject1).put((String)((Map.Entry)localObject2).getKey(), (String)((Map.Entry)localObject2).getValue());
      }
      this.jdField_c_of_type_JavaUtilMap = ((Map)localObject1);
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public int a(ib paramib)
  {
    return 0;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public ib a()
  {
    return new ib(this);
  }
  
  public ib a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    b(true);
    return this;
  }
  
  public ib a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public ib a(Map<String, String> paramMap)
  {
    this.jdField_a_of_type_JavaUtilMap = paramMap;
    return this;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public Map<String, String> a()
  {
    return this.jdField_a_of_type_JavaUtilMap;
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
  public void a(jk arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void a(String arg1, String arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilBitSet.set(0, paramBoolean);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaLangString != null;
  }
  
  public boolean a(ib paramib)
  {
    return false;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public ib b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    c(true);
    return this;
  }
  
  public ib b(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    return this;
  }
  
  public String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public Map<String, String> b()
  {
    return this.jdField_b_of_type_JavaUtilMap;
  }
  
  /* Error */
  public void b(jk arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void b(String arg1, String arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilBitSet.set(1, paramBoolean);
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_JavaUtilBitSet.get(0);
  }
  
  public int c()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public ib c(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
    d(true);
    return this;
  }
  
  public ib c(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
    return this;
  }
  
  public String c()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilBitSet.set(2, paramBoolean);
  }
  
  public boolean c()
  {
    return this.jdField_b_of_type_JavaLangString != null;
  }
  
  public ib d(String paramString)
  {
    this.jdField_d_of_type_JavaLangString = paramString;
    return this;
  }
  
  public String d()
  {
    return this.jdField_d_of_type_JavaLangString;
  }
  
  public void d(boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilBitSet.set(3, paramBoolean);
  }
  
  public boolean d()
  {
    return this.jdField_c_of_type_JavaLangString != null;
  }
  
  public void e(boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilBitSet.set(4, paramBoolean);
  }
  
  public boolean e()
  {
    return this.jdField_d_of_type_JavaLangString != null;
  }
  
  public boolean equals(Object paramObject)
  {
    return false;
  }
  
  public boolean f()
  {
    return this.jdField_a_of_type_JavaUtilBitSet.get(1);
  }
  
  public boolean g()
  {
    return this.jdField_e_of_type_JavaLangString != null;
  }
  
  public boolean h()
  {
    return this.jdField_a_of_type_JavaUtilBitSet.get(2);
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public boolean i()
  {
    return this.jdField_a_of_type_JavaUtilBitSet.get(3);
  }
  
  public boolean j()
  {
    return this.jdField_a_of_type_JavaUtilMap != null;
  }
  
  public boolean k()
  {
    return this.jdField_b_of_type_JavaUtilMap != null;
  }
  
  public boolean l()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean m()
  {
    return this.jdField_a_of_type_JavaUtilBitSet.get(4);
  }
  
  public boolean n()
  {
    return this.jdField_c_of_type_JavaUtilMap != null;
  }
  
  public String toString()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\ib.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */