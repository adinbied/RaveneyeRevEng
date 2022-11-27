package com.xiaomi.push;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;

public class ik
  implements iz<ik, Object>, Serializable, Cloneable
{
  private static final jh jdField_a_of_type_ComXiaomiPushJh;
  private static final jp jdField_a_of_type_ComXiaomiPushJp = new jp("XmPushActionContainer");
  private static final jh b;
  private static final jh c = new jh("", (byte)2, (short)3);
  private static final jh d = new jh("", (byte)11, (short)4);
  private static final jh e = new jh("", (byte)11, (short)5);
  private static final jh f = new jh("", (byte)11, (short)6);
  private static final jh g = new jh("", (byte)12, (short)7);
  private static final jh h = new jh("", (byte)12, (short)8);
  public ho a;
  public ib a;
  public id a;
  public String a;
  public ByteBuffer a;
  private BitSet jdField_a_of_type_JavaUtilBitSet = new BitSet(2);
  public boolean a;
  public String b;
  public boolean b;
  
  static
  {
    jdField_a_of_type_ComXiaomiPushJh = new jh("", (byte)8, (short)1);
    jdField_b_of_type_ComXiaomiPushJh = new jh("", (byte)2, (short)2);
  }
  
  public ik()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = true;
  }
  
  public int a(ik paramik)
  {
    return 0;
  }
  
  public ho a()
  {
    return this.jdField_a_of_type_ComXiaomiPushHo;
  }
  
  public ib a()
  {
    return this.jdField_a_of_type_ComXiaomiPushIb;
  }
  
  public ik a(ho paramho)
  {
    this.jdField_a_of_type_ComXiaomiPushHo = paramho;
    return this;
  }
  
  public ik a(ib paramib)
  {
    this.jdField_a_of_type_ComXiaomiPushIb = paramib;
    return this;
  }
  
  public ik a(id paramid)
  {
    this.jdField_a_of_type_ComXiaomiPushId = paramid;
    return this;
  }
  
  public ik a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public ik a(ByteBuffer paramByteBuffer)
  {
    this.jdField_a_of_type_JavaNioByteBuffer = paramByteBuffer;
    return this;
  }
  
  public ik a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    a(true);
    return this;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
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
    return this.jdField_a_of_type_ComXiaomiPushHo != null;
  }
  
  public boolean a(ik paramik)
  {
    return false;
  }
  
  public byte[] a()
  {
    return null;
  }
  
  public ik b(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    return this;
  }
  
  public ik b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    b(true);
    return this;
  }
  
  public String b()
  {
    return this.jdField_b_of_type_JavaLangString;
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
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_JavaUtilBitSet.get(0);
  }
  
  public boolean d()
  {
    return this.jdField_a_of_type_JavaUtilBitSet.get(1);
  }
  
  public boolean e()
  {
    return this.jdField_a_of_type_JavaNioByteBuffer != null;
  }
  
  public boolean equals(Object paramObject)
  {
    return false;
  }
  
  public boolean f()
  {
    return this.jdField_a_of_type_JavaLangString != null;
  }
  
  public boolean g()
  {
    return this.jdField_b_of_type_JavaLangString != null;
  }
  
  public boolean h()
  {
    return this.jdField_a_of_type_ComXiaomiPushId != null;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public boolean i()
  {
    return this.jdField_a_of_type_ComXiaomiPushIb != null;
  }
  
  public String toString()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\ik.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */