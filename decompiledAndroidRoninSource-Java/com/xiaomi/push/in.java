package com.xiaomi.push;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;
import java.util.Map;

public class in
  implements iz<in, Object>, Serializable, Cloneable
{
  private static final jh jdField_a_of_type_ComXiaomiPushJh;
  private static final jp jdField_a_of_type_ComXiaomiPushJp = new jp("XmPushActionNotification");
  private static final jh b;
  private static final jh c;
  private static final jh d;
  private static final jh e;
  private static final jh f;
  private static final jh g;
  private static final jh h;
  private static final jh i;
  private static final jh j = new jh("", (byte)11, (short)10);
  private static final jh k = new jh("", (byte)11, (short)12);
  private static final jh l = new jh("", (byte)11, (short)13);
  private static final jh m = new jh("", (byte)11, (short)14);
  private static final jh n = new jh("", (byte)10, (short)15);
  private static final jh o = new jh("", (byte)2, (short)20);
  public long a;
  public id a;
  public String a;
  public ByteBuffer a;
  private BitSet jdField_a_of_type_JavaUtilBitSet = new BitSet(3);
  public Map<String, String> a;
  public boolean a;
  public String b;
  public boolean b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  
  static
  {
    jdField_a_of_type_ComXiaomiPushJh = new jh("", (byte)11, (short)1);
    jdField_b_of_type_ComXiaomiPushJh = new jh("", (byte)12, (short)2);
    jdField_c_of_type_ComXiaomiPushJh = new jh("", (byte)11, (short)3);
    jdField_d_of_type_ComXiaomiPushJh = new jh("", (byte)11, (short)4);
    jdField_e_of_type_ComXiaomiPushJh = new jh("", (byte)11, (short)5);
    jdField_f_of_type_ComXiaomiPushJh = new jh("", (byte)2, (short)6);
    jdField_g_of_type_ComXiaomiPushJh = new jh("", (byte)11, (short)7);
    jdField_h_of_type_ComXiaomiPushJh = new jh("", (byte)13, (short)8);
    jdField_i_of_type_ComXiaomiPushJh = new jh("", (byte)11, (short)9);
  }
  
  public in()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
  }
  
  public in(String paramString, boolean paramBoolean)
  {
    this();
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = paramBoolean;
    a(true);
  }
  
  public int a(in paramin)
  {
    return 0;
  }
  
  public in a(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    return this;
  }
  
  public in a(ByteBuffer paramByteBuffer)
  {
    this.jdField_a_of_type_JavaNioByteBuffer = paramByteBuffer;
    return this;
  }
  
  public in a(Map<String, String> paramMap)
  {
    this.jdField_a_of_type_JavaUtilMap = paramMap;
    return this;
  }
  
  public in a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    a(true);
    return this;
  }
  
  public in a(byte[] paramArrayOfByte)
  {
    a(ByteBuffer.wrap(paramArrayOfByte));
    return this;
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
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
  
  public boolean a(in paramin)
  {
    return false;
  }
  
  public byte[] a()
  {
    return null;
  }
  
  public in b(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
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
    return this.jdField_a_of_type_ComXiaomiPushId != null;
  }
  
  public in c(String paramString)
  {
    this.jdField_d_of_type_JavaLangString = paramString;
    return this;
  }
  
  public String c()
  {
    return this.jdField_f_of_type_JavaLangString;
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilBitSet.set(2, paramBoolean);
  }
  
  public boolean c()
  {
    return this.jdField_b_of_type_JavaLangString != null;
  }
  
  public in d(String paramString)
  {
    this.jdField_f_of_type_JavaLangString = paramString;
    return this;
  }
  
  public boolean d()
  {
    return this.jdField_c_of_type_JavaLangString != null;
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
    return this.jdField_a_of_type_JavaUtilBitSet.get(0);
  }
  
  public boolean g()
  {
    return this.jdField_e_of_type_JavaLangString != null;
  }
  
  public boolean h()
  {
    return this.jdField_a_of_type_JavaUtilMap != null;
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
    return this.jdField_h_of_type_JavaLangString != null;
  }
  
  public boolean l()
  {
    return this.jdField_i_of_type_JavaLangString != null;
  }
  
  public boolean m()
  {
    return this.jdField_a_of_type_JavaNioByteBuffer != null;
  }
  
  public boolean n()
  {
    return this.jdField_a_of_type_JavaUtilBitSet.get(1);
  }
  
  public boolean o()
  {
    return this.jdField_a_of_type_JavaUtilBitSet.get(2);
  }
  
  public String toString()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\in.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */