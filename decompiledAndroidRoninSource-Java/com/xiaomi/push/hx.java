package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
import java.util.List;

public class hx
  implements iz<hx, Object>, Serializable, Cloneable
{
  private static final jh jdField_a_of_type_ComXiaomiPushJh = new jh("", (byte)8, (short)1);
  private static final jp jdField_a_of_type_ComXiaomiPushJp = new jp("NormalConfig");
  private static final jh b = new jh("", (byte)15, (short)2);
  private static final jh c = new jh("", (byte)8, (short)3);
  public int a;
  public hu a;
  private BitSet jdField_a_of_type_JavaUtilBitSet = new BitSet(1);
  public List<hz> a;
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public int a(hx paramhx)
  {
    return 0;
  }
  
  public hu a()
  {
    return this.jdField_a_of_type_ComXiaomiPushHu;
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
  
  public boolean a(hx paramhx)
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
    return this.jdField_a_of_type_JavaUtilList != null;
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_ComXiaomiPushHu != null;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\hx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */