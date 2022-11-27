package com.xiaomi.push;

import java.util.Map;

public class fv
  implements Cloneable
{
  public static String a = "wcc-ml-test10.bj";
  public static final String b;
  public static String c = null;
  private int jdField_a_of_type_Int;
  private fy jdField_a_of_type_ComXiaomiPushFy;
  private boolean jdField_a_of_type_Boolean = fu.jdField_a_of_type_Boolean;
  private boolean b;
  private String d;
  private String e;
  private String f;
  
  static
  {
    jdField_b_of_type_JavaLangString = ae.a;
  }
  
  public fv(Map<String, Integer> paramMap, int paramInt, String paramString, fy paramfy)
  {
    this.jdField_b_of_type_Boolean = true;
    a(paramMap, paramInt, paramString, paramfy);
  }
  
  public static final String a()
  {
    String str = c;
    if (str != null) {
      return str;
    }
    if (ab.a()) {
      return "sandbox.xmpush.xiaomi.com";
    }
    if (ab.b()) {
      return jdField_b_of_type_JavaLangString;
    }
    return "app.chat.xiaomi.net";
  }
  
  public static final void a(String paramString)
  {
    c = paramString;
  }
  
  private void a(Map<String, Integer> paramMap, int paramInt, String paramString, fy paramfy)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.d = paramString;
    this.jdField_a_of_type_ComXiaomiPushFy = paramfy;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public byte[] a()
  {
    return null;
  }
  
  public String b()
  {
    return this.f;
  }
  
  public void b(String paramString)
  {
    this.f = paramString;
  }
  
  public String c()
  {
    return null;
  }
  
  public void c(String paramString)
  {
    this.e = paramString;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\fv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */