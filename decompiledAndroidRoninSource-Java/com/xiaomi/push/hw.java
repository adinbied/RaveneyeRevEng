package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

public class hw
  implements iz<hw, Object>, Serializable, Cloneable
{
  private static final jh jdField_a_of_type_ComXiaomiPushJh = new jh("", (byte)10, (short)1);
  private static final jp jdField_a_of_type_ComXiaomiPushJp = new jp("DataCollectionItem");
  private static final jh b = new jh("", (byte)8, (short)2);
  private static final jh c = new jh("", (byte)11, (short)3);
  public long a;
  public hq a;
  public String a;
  private BitSet jdField_a_of_type_JavaUtilBitSet = new BitSet(1);
  
  public int a(hw paramhw)
  {
    return 0;
  }
  
  public hw a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
    a(true);
    return this;
  }
  
  public hw a(hq paramhq)
  {
    this.jdField_a_of_type_ComXiaomiPushHq = paramhq;
    return this;
  }
  
  public hw a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
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
    return this.jdField_a_of_type_JavaUtilBitSet.get(0);
  }
  
  public boolean a(hw paramhw)
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
  
  public boolean b()
  {
    return this.jdField_a_of_type_ComXiaomiPushHq != null;
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_JavaLangString != null;
  }
  
  public boolean equals(Object paramObject)
  {
    return false;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\hw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */