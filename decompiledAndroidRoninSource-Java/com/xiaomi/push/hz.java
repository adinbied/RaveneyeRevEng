package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

public class hz
  implements iz<hz, Object>, Serializable, Cloneable
{
  private static final jh jdField_a_of_type_ComXiaomiPushJh;
  private static final jp jdField_a_of_type_ComXiaomiPushJp = new jp("OnlineConfigItem");
  private static final jh b;
  private static final jh c;
  private static final jh d = new jh("", (byte)8, (short)4);
  private static final jh e = new jh("", (byte)10, (short)5);
  private static final jh f = new jh("", (byte)11, (short)6);
  private static final jh g = new jh("", (byte)2, (short)7);
  public int a;
  public long a;
  public String a;
  private BitSet jdField_a_of_type_JavaUtilBitSet = new BitSet(6);
  public boolean a;
  public int b;
  public boolean b;
  public int c;
  
  static
  {
    jdField_a_of_type_ComXiaomiPushJh = new jh("", (byte)8, (short)1);
    jdField_b_of_type_ComXiaomiPushJh = new jh("", (byte)8, (short)2);
    jdField_c_of_type_ComXiaomiPushJh = new jh("", (byte)2, (short)3);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public int a(hz paramhz)
  {
    return 0;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
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
    return this.jdField_a_of_type_JavaUtilBitSet.get(0);
  }
  
  public boolean a(hz paramhz)
  {
    return false;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
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
    return this.jdField_a_of_type_JavaUtilBitSet.get(1);
  }
  
  public int c()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilBitSet.set(2, paramBoolean);
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_JavaUtilBitSet.get(2);
  }
  
  public void d(boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilBitSet.set(3, paramBoolean);
  }
  
  public boolean d()
  {
    return this.jdField_a_of_type_JavaUtilBitSet.get(3);
  }
  
  public void e(boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilBitSet.set(4, paramBoolean);
  }
  
  public boolean e()
  {
    return this.jdField_a_of_type_JavaUtilBitSet.get(4);
  }
  
  public boolean equals(Object paramObject)
  {
    return false;
  }
  
  public void f(boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilBitSet.set(5, paramBoolean);
  }
  
  public boolean f()
  {
    return this.jdField_a_of_type_JavaLangString != null;
  }
  
  public boolean g()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public boolean h()
  {
    return this.jdField_a_of_type_JavaUtilBitSet.get(5);
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public String toString()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\hz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */