package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
import java.util.Map;

public class ie
  implements iz<ie, Object>, Serializable, Cloneable
{
  private static final jh jdField_a_of_type_ComXiaomiPushJh;
  private static final jp jdField_a_of_type_ComXiaomiPushJp = new jp("XmPushActionAckMessage");
  private static final jh b;
  private static final jh c;
  private static final jh d;
  private static final jh e;
  private static final jh f;
  private static final jh g;
  private static final jh h;
  private static final jh i;
  private static final jh j;
  private static final jh k;
  private static final jh l;
  private static final jh m = new jh("", (byte)11, (short)13);
  private static final jh n = new jh("", (byte)11, (short)14);
  private static final jh o = new jh("", (byte)6, (short)15);
  private static final jh p = new jh("", (byte)6, (short)16);
  private static final jh q = new jh("", (byte)11, (short)20);
  private static final jh r = new jh("", (byte)11, (short)21);
  private static final jh s = new jh("", (byte)8, (short)22);
  private static final jh t = new jh("", (byte)13, (short)23);
  public int a;
  public long a;
  public id a;
  public ir a;
  public String a;
  private BitSet jdField_a_of_type_JavaUtilBitSet = new BitSet(5);
  public Map<String, String> a;
  public short a;
  public boolean a;
  public String b;
  public short b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  public String j;
  public String k;
  public String l;
  
  static
  {
    jdField_a_of_type_ComXiaomiPushJh = new jh("", (byte)11, (short)1);
    jdField_b_of_type_ComXiaomiPushJh = new jh("", (byte)12, (short)2);
    jdField_c_of_type_ComXiaomiPushJh = new jh("", (byte)11, (short)3);
    jdField_d_of_type_ComXiaomiPushJh = new jh("", (byte)11, (short)4);
    jdField_e_of_type_ComXiaomiPushJh = new jh("", (byte)10, (short)5);
    jdField_f_of_type_ComXiaomiPushJh = new jh("", (byte)11, (short)6);
    jdField_g_of_type_ComXiaomiPushJh = new jh("", (byte)11, (short)7);
    jdField_h_of_type_ComXiaomiPushJh = new jh("", (byte)12, (short)8);
    jdField_i_of_type_ComXiaomiPushJh = new jh("", (byte)11, (short)9);
    jdField_j_of_type_ComXiaomiPushJh = new jh("", (byte)11, (short)10);
    jdField_k_of_type_ComXiaomiPushJh = new jh("", (byte)2, (short)11);
    jdField_l_of_type_ComXiaomiPushJh = new jh("", (byte)11, (short)12);
  }
  
  public ie()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public int a(ie paramie)
  {
    return 0;
  }
  
  public ie a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
    a(true);
    return this;
  }
  
  public ie a(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    return this;
  }
  
  public ie a(short paramShort)
  {
    this.jdField_a_of_type_Short = paramShort;
    c(true);
    return this;
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
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilBitSet.set(0, paramBoolean);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaLangString != null;
  }
  
  public boolean a(ie paramie)
  {
    return false;
  }
  
  public ie b(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
    return this;
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
    return this.jdField_a_of_type_ComXiaomiPushId != null;
  }
  
  public ie c(String paramString)
  {
    this.jdField_d_of_type_JavaLangString = paramString;
    return this;
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilBitSet.set(2, paramBoolean);
  }
  
  public boolean c()
  {
    return this.jdField_b_of_type_JavaLangString != null;
  }
  
  public ie d(String paramString)
  {
    this.jdField_e_of_type_JavaLangString = paramString;
    return this;
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
    return this.jdField_a_of_type_JavaUtilBitSet.get(0);
  }
  
  public boolean equals(Object paramObject)
  {
    return false;
  }
  
  public boolean f()
  {
    return this.jdField_d_of_type_JavaLangString != null;
  }
  
  public boolean g()
  {
    return this.jdField_e_of_type_JavaLangString != null;
  }
  
  public boolean h()
  {
    return this.jdField_a_of_type_ComXiaomiPushIr != null;
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
    return this.jdField_g_of_type_JavaLangString != null;
  }
  
  public boolean k()
  {
    return this.jdField_a_of_type_JavaUtilBitSet.get(1);
  }
  
  public boolean l()
  {
    return this.jdField_h_of_type_JavaLangString != null;
  }
  
  public boolean m()
  {
    return this.jdField_i_of_type_JavaLangString != null;
  }
  
  public boolean n()
  {
    return this.jdField_j_of_type_JavaLangString != null;
  }
  
  public boolean o()
  {
    return this.jdField_a_of_type_JavaUtilBitSet.get(2);
  }
  
  public boolean p()
  {
    return this.jdField_a_of_type_JavaUtilBitSet.get(3);
  }
  
  public boolean q()
  {
    return this.jdField_k_of_type_JavaLangString != null;
  }
  
  public boolean r()
  {
    return this.jdField_l_of_type_JavaLangString != null;
  }
  
  public boolean s()
  {
    return this.jdField_a_of_type_JavaUtilBitSet.get(4);
  }
  
  public boolean t()
  {
    return this.jdField_a_of_type_JavaUtilMap != null;
  }
  
  public String toString()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\ie.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */