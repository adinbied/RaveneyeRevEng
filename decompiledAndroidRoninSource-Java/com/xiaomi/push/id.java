package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

public class id
  implements iz<id, Object>, Serializable, Cloneable
{
  private static final jh jdField_a_of_type_ComXiaomiPushJh;
  private static final jp jdField_a_of_type_ComXiaomiPushJp = new jp("Target");
  private static final jh b;
  private static final jh c;
  private static final jh d;
  private static final jh e = new jh("", (byte)2, (short)5);
  private static final jh f = new jh("", (byte)11, (short)7);
  public long a;
  public String a;
  private BitSet jdField_a_of_type_JavaUtilBitSet = new BitSet(2);
  public boolean a;
  public String b;
  public String c;
  public String d;
  
  static
  {
    jdField_a_of_type_ComXiaomiPushJh = new jh("", (byte)10, (short)1);
    jdField_b_of_type_ComXiaomiPushJh = new jh("", (byte)11, (short)2);
    jdField_c_of_type_ComXiaomiPushJh = new jh("", (byte)11, (short)3);
    jdField_d_of_type_ComXiaomiPushJh = new jh("", (byte)11, (short)4);
  }
  
  public id()
  {
    this.jdField_a_of_type_Long = 5L;
    this.jdField_b_of_type_JavaLangString = "xiaomi.com";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_a_of_type_Boolean = false;
  }
  
  public int a(id paramid)
  {
    return 0;
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
    return this.jdField_a_of_type_JavaUtilBitSet.get(0);
  }
  
  public boolean a(id paramid)
  {
    return false;
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
  
  public boolean c()
  {
    return this.jdField_b_of_type_JavaLangString != null;
  }
  
  public boolean d()
  {
    return this.jdField_c_of_type_JavaLangString != null;
  }
  
  public boolean e()
  {
    return this.jdField_a_of_type_JavaUtilBitSet.get(1);
  }
  
  public boolean equals(Object paramObject)
  {
    return false;
  }
  
  public boolean f()
  {
    return this.jdField_d_of_type_JavaLangString != null;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\id.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */