package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

public class fk
  implements iz<fk, Object>, Serializable, Cloneable
{
  private static final jh jdField_a_of_type_ComXiaomiPushJh;
  private static final jp jdField_a_of_type_ComXiaomiPushJp = new jp("StatsEvent");
  private static final jh b;
  private static final jh c;
  private static final jh d;
  private static final jh e = new jh("", (byte)11, (short)5);
  private static final jh f = new jh("", (byte)8, (short)6);
  private static final jh g = new jh("", (byte)11, (short)7);
  private static final jh h = new jh("", (byte)11, (short)8);
  private static final jh i = new jh("", (byte)8, (short)9);
  private static final jh j = new jh("", (byte)8, (short)10);
  public byte a;
  public int a;
  public String a;
  private BitSet jdField_a_of_type_JavaUtilBitSet = new BitSet(6);
  public int b;
  public String b;
  public int c;
  public String c;
  public int d;
  public String d;
  public int e;
  
  static
  {
    jdField_a_of_type_ComXiaomiPushJh = new jh("", (byte)3, (short)1);
    jdField_b_of_type_ComXiaomiPushJh = new jh("", (byte)8, (short)2);
    jdField_c_of_type_ComXiaomiPushJh = new jh("", (byte)8, (short)3);
    jdField_d_of_type_ComXiaomiPushJh = new jh("", (byte)11, (short)4);
  }
  
  public int a(fk paramfk)
  {
    return 0;
  }
  
  public fk a(byte paramByte)
  {
    this.jdField_a_of_type_Byte = paramByte;
    a(true);
    return this;
  }
  
  public fk a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    b(true);
    return this;
  }
  
  public fk a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
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
    return this.jdField_a_of_type_JavaUtilBitSet.get(0);
  }
  
  public boolean a(fk paramfk)
  {
    return false;
  }
  
  public fk b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    c(true);
    return this;
  }
  
  public fk b(String paramString)
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
    return this.jdField_a_of_type_JavaUtilBitSet.get(1);
  }
  
  public fk c(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
    d(true);
    return this;
  }
  
  public fk c(String paramString)
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
    return this.jdField_a_of_type_JavaUtilBitSet.get(2);
  }
  
  public fk d(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
    e(true);
    return this;
  }
  
  public fk d(String paramString)
  {
    this.jdField_d_of_type_JavaLangString = paramString;
    return this;
  }
  
  public void d(boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilBitSet.set(3, paramBoolean);
  }
  
  public boolean d()
  {
    return this.jdField_a_of_type_JavaLangString != null;
  }
  
  public void e(boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilBitSet.set(4, paramBoolean);
  }
  
  public boolean e()
  {
    return this.jdField_b_of_type_JavaLangString != null;
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
    return this.jdField_a_of_type_JavaUtilBitSet.get(3);
  }
  
  public boolean g()
  {
    return this.jdField_c_of_type_JavaLangString != null;
  }
  
  public boolean h()
  {
    return this.jdField_d_of_type_JavaLangString != null;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public boolean i()
  {
    return this.jdField_a_of_type_JavaUtilBitSet.get(4);
  }
  
  public boolean j()
  {
    return this.jdField_a_of_type_JavaUtilBitSet.get(5);
  }
  
  public String toString()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\fk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */