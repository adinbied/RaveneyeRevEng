package com.xiaomi.push;

import android.os.Bundle;
import java.util.HashMap;
import java.util.Map;

public class gj
  extends gl
{
  private a jdField_a_of_type_ComXiaomiPushGj$a = a.jdField_a_of_type_ComXiaomiPushGj$a;
  private final Map<String, String> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  public gj() {}
  
  public gj(Bundle paramBundle)
  {
    super(paramBundle);
    if (paramBundle.containsKey("ext_iq_type")) {
      this.jdField_a_of_type_ComXiaomiPushGj$a = a.a(paramBundle.getString("ext_iq_type"));
    }
  }
  
  public Bundle a()
  {
    return null;
  }
  
  public a a()
  {
    return this.jdField_a_of_type_ComXiaomiPushGj$a;
  }
  
  public String a()
  {
    return null;
  }
  
  public void a(a parama)
  {
    a locala = parama;
    if (parama == null) {
      locala = a.jdField_a_of_type_ComXiaomiPushGj$a;
    }
    this.jdField_a_of_type_ComXiaomiPushGj$a = locala;
  }
  
  /* Error */
  public void a(Map<String, String> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public String b()
  {
    return null;
  }
  
  public static class a
  {
    public static final a a;
    public static final a b = new a("set");
    public static final a c = new a("result");
    public static final a d = new a("error");
    public static final a e = new a("command");
    private String a;
    
    static
    {
      jdField_a_of_type_ComXiaomiPushGj$a = new a("get");
    }
    
    private a(String paramString)
    {
      this.jdField_a_of_type_JavaLangString = paramString;
    }
    
    public static a a(String paramString)
    {
      if (paramString == null) {
        return null;
      }
      paramString = paramString.toLowerCase();
      if (jdField_a_of_type_ComXiaomiPushGj$a.toString().equals(paramString)) {
        return jdField_a_of_type_ComXiaomiPushGj$a;
      }
      if (b.toString().equals(paramString)) {
        return b;
      }
      if (d.toString().equals(paramString)) {
        return d;
      }
      if (c.toString().equals(paramString)) {
        return c;
      }
      if (e.toString().equals(paramString)) {
        return e;
      }
      return null;
    }
    
    public String toString()
    {
      return this.jdField_a_of_type_JavaLangString;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\gj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */