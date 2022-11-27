package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
import java.util.List;

public class ii
  implements iz<ii, Object>, Serializable, Cloneable
{
  private static final jh jdField_a_of_type_ComXiaomiPushJh;
  private static final jp jdField_a_of_type_ComXiaomiPushJp = new jp("XmPushActionCommand");
  private static final jh b;
  private static final jh c;
  private static final jh d;
  private static final jh e;
  private static final jh f = new jh("", (byte)11, (short)7);
  private static final jh g = new jh("", (byte)11, (short)9);
  private static final jh h = new jh("", (byte)2, (short)10);
  private static final jh i = new jh("", (byte)2, (short)11);
  private static final jh j = new jh("", (byte)10, (short)12);
  public long a;
  public id a;
  public String a;
  private BitSet jdField_a_of_type_JavaUtilBitSet = new BitSet(3);
  public List<String> a;
  public boolean a;
  public String b;
  public boolean b;
  public String c;
  public String d;
  public String e;
  
  static
  {
    jdField_a_of_type_ComXiaomiPushJh = new jh("", (byte)12, (short)2);
    jdField_b_of_type_ComXiaomiPushJh = new jh("", (byte)11, (short)3);
    jdField_c_of_type_ComXiaomiPushJh = new jh("", (byte)11, (short)4);
    jdField_d_of_type_ComXiaomiPushJh = new jh("", (byte)11, (short)5);
    jdField_e_of_type_ComXiaomiPushJh = new jh("", (byte)15, (short)6);
  }
  
  public ii()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = true;
  }
  
  public int a(ii paramii)
  {
    return 0;
  }
  
  public ii a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public ii a(List<String> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    return this;
  }
  
  public String a()
  {
    return this.jdField_c_of_type_JavaLangString;
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
  public void a(String arg1)
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
    return this.jdField_a_of_type_ComXiaomiPushId != null;
  }
  
  public boolean a(ii paramii)
  {
    return false;
  }
  
  public ii b(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
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
    return this.jdField_a_of_type_JavaLangString != null;
  }
  
  public ii c(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
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
  
  public ii d(String paramString)
  {
    this.jdField_d_of_type_JavaLangString = paramString;
    return this;
  }
  
  public boolean d()
  {
    return this.jdField_c_of_type_JavaLangString != null;
  }
  
  public ii e(String paramString)
  {
    this.jdField_e_of_type_JavaLangString = paramString;
    return this;
  }
  
  public boolean e()
  {
    return this.jdField_a_of_type_JavaUtilList != null;
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
    return this.jdField_a_of_type_JavaUtilBitSet.get(0);
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public boolean i()
  {
    return this.jdField_a_of_type_JavaUtilBitSet.get(1);
  }
  
  public boolean j()
  {
    return this.jdField_a_of_type_JavaUtilBitSet.get(2);
  }
  
  public String toString()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\ii.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */