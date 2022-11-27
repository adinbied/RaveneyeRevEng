package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
import java.util.Map;

public class hs
  implements iz<hs, Object>, Serializable, Cloneable
{
  private static final jh jdField_a_of_type_ComXiaomiPushJh;
  private static final jp jdField_a_of_type_ComXiaomiPushJp = new jp("ClientUploadDataItem");
  private static final jh b;
  private static final jh c;
  private static final jh d;
  private static final jh e;
  private static final jh f;
  private static final jh g;
  private static final jh h = new jh("", (byte)11, (short)8);
  private static final jh i = new jh("", (byte)11, (short)9);
  private static final jh j = new jh("", (byte)13, (short)10);
  private static final jh k = new jh("", (byte)11, (short)11);
  public long a;
  public String a;
  private BitSet jdField_a_of_type_JavaUtilBitSet = new BitSet(3);
  public Map<String, String> a;
  public boolean a;
  public long b;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  
  static
  {
    jdField_a_of_type_ComXiaomiPushJh = new jh("", (byte)11, (short)1);
    jdField_b_of_type_ComXiaomiPushJh = new jh("", (byte)11, (short)2);
    jdField_c_of_type_ComXiaomiPushJh = new jh("", (byte)11, (short)3);
    jdField_d_of_type_ComXiaomiPushJh = new jh("", (byte)10, (short)4);
    jdField_e_of_type_ComXiaomiPushJh = new jh("", (byte)10, (short)5);
    jdField_f_of_type_ComXiaomiPushJh = new jh("", (byte)2, (short)6);
    jdField_g_of_type_ComXiaomiPushJh = new jh("", (byte)11, (short)7);
  }
  
  public int a(hs paramhs)
  {
    return 0;
  }
  
  public long a()
  {
    return this.jdField_b_of_type_Long;
  }
  
  public hs a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
    a(true);
    return this;
  }
  
  public hs a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public hs a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    c(true);
    return this;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a() {}
  
  /* Error */
  public void a(jk arg1)
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
  
  public boolean a(hs paramhs)
  {
    return false;
  }
  
  public hs b(long paramLong)
  {
    this.jdField_b_of_type_Long = paramLong;
    b(true);
    return this;
  }
  
  public hs b(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    return this;
  }
  
  public String b()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  /* Error */
  public void b(jk arg1)
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
    return this.jdField_b_of_type_JavaLangString != null;
  }
  
  public hs c(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
    return this;
  }
  
  public String c()
  {
    return this.jdField_e_of_type_JavaLangString;
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilBitSet.set(2, paramBoolean);
  }
  
  public boolean c()
  {
    return this.jdField_c_of_type_JavaLangString != null;
  }
  
  public hs d(String paramString)
  {
    this.jdField_d_of_type_JavaLangString = paramString;
    return this;
  }
  
  public String d()
  {
    return this.jdField_f_of_type_JavaLangString;
  }
  
  public boolean d()
  {
    return this.jdField_a_of_type_JavaUtilBitSet.get(0);
  }
  
  public hs e(String paramString)
  {
    this.jdField_e_of_type_JavaLangString = paramString;
    return this;
  }
  
  public String e()
  {
    return this.jdField_g_of_type_JavaLangString;
  }
  
  public boolean e()
  {
    return this.jdField_a_of_type_JavaUtilBitSet.get(1);
  }
  
  public boolean equals(Object paramObject)
  {
    return false;
  }
  
  public hs f(String paramString)
  {
    this.jdField_f_of_type_JavaLangString = paramString;
    return this;
  }
  
  public boolean f()
  {
    return this.jdField_a_of_type_JavaUtilBitSet.get(2);
  }
  
  public hs g(String paramString)
  {
    this.jdField_g_of_type_JavaLangString = paramString;
    return this;
  }
  
  public boolean g()
  {
    return this.jdField_d_of_type_JavaLangString != null;
  }
  
  public boolean h()
  {
    return this.jdField_e_of_type_JavaLangString != null;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public boolean i()
  {
    return this.jdField_f_of_type_JavaLangString != null;
  }
  
  public boolean j()
  {
    return this.jdField_a_of_type_JavaUtilMap != null;
  }
  
  public boolean k()
  {
    return this.jdField_g_of_type_JavaLangString != null;
  }
  
  public String toString()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\hs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */