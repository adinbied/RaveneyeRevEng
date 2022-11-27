package com.xiaomi.push;

import java.io.Serializable;
import java.util.List;

public class fl
  implements iz<fl, Object>, Serializable, Cloneable
{
  private static final jh jdField_a_of_type_ComXiaomiPushJh;
  private static final jp jdField_a_of_type_ComXiaomiPushJp = new jp("StatsEvents");
  private static final jh b;
  private static final jh c = new jh("", (byte)15, (short)3);
  public String a;
  public List<fk> a;
  public String b;
  
  static
  {
    jdField_a_of_type_ComXiaomiPushJh = new jh("", (byte)11, (short)1);
    jdField_b_of_type_ComXiaomiPushJh = new jh("", (byte)11, (short)2);
  }
  
  public fl() {}
  
  public fl(String paramString, List<fk> paramList)
  {
    this();
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public int a(fl paramfl)
  {
    return 0;
  }
  
  public fl a(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
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
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaLangString != null;
  }
  
  public boolean a(fl paramfl)
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
    return this.jdField_b_of_type_JavaLangString != null;
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_JavaUtilList != null;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\fl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */