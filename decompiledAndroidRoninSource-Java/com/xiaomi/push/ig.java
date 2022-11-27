package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

public class ig
  implements iz<ig, Object>, Serializable, Cloneable
{
  private static final jh jdField_a_of_type_ComXiaomiPushJh;
  private static final jp jdField_a_of_type_ComXiaomiPushJp = new jp("XmPushActionCheckClientInfo");
  private static final jh b;
  public int a;
  private BitSet jdField_a_of_type_JavaUtilBitSet = new BitSet(2);
  public int b;
  
  static
  {
    jdField_a_of_type_ComXiaomiPushJh = new jh("", (byte)8, (short)1);
    jdField_b_of_type_ComXiaomiPushJh = new jh("", (byte)8, (short)2);
  }
  
  public int a(ig paramig)
  {
    return 0;
  }
  
  public ig a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    a(true);
    return this;
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
  
  public boolean a(ig paramig)
  {
    return false;
  }
  
  public ig b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    b(true);
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\ig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */