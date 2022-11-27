package com.xiaomi.push;

import java.util.LinkedList;

public class bb
{
  private LinkedList<a> a = new LinkedList();
  
  public static bb a()
  {
    return a.a();
  }
  
  /* Error */
  private void a()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public int a()
  {
    return 0;
  }
  
  public LinkedList<a> a()
  {
    return null;
  }
  
  /* Error */
  public void a(Object arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public static class a
  {
    private static final bb a;
    public int a;
    public Object a;
    public String a;
    
    static
    {
      jdField_a_of_type_ComXiaomiPushBb = new bb();
    }
    
    a(int paramInt, Object paramObject)
    {
      this.jdField_a_of_type_Int = paramInt;
      this.jdField_a_of_type_JavaLangObject = paramObject;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\bb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */