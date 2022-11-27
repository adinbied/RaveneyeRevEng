package com.xiaomi.push;

import android.os.Bundle;

public class gn
  extends gl
{
  private int jdField_a_of_type_Int = Integer.MIN_VALUE;
  private a jdField_a_of_type_ComXiaomiPushGn$a = null;
  private b jdField_a_of_type_ComXiaomiPushGn$b = b.jdField_a_of_type_ComXiaomiPushGn$b;
  private String b = null;
  
  public gn(Bundle paramBundle)
  {
    super(paramBundle);
    if (paramBundle.containsKey("ext_pres_type")) {
      this.jdField_a_of_type_ComXiaomiPushGn$b = b.valueOf(paramBundle.getString("ext_pres_type"));
    }
    if (paramBundle.containsKey("ext_pres_status")) {
      this.b = paramBundle.getString("ext_pres_status");
    }
    if (paramBundle.containsKey("ext_pres_prio")) {
      this.jdField_a_of_type_Int = paramBundle.getInt("ext_pres_prio");
    }
    if (paramBundle.containsKey("ext_pres_mode")) {
      this.jdField_a_of_type_ComXiaomiPushGn$a = a.valueOf(paramBundle.getString("ext_pres_mode"));
    }
  }
  
  public gn(b paramb)
  {
    a(paramb);
  }
  
  public Bundle a()
  {
    return null;
  }
  
  public String a()
  {
    return null;
  }
  
  /* Error */
  public void a(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  public void a(a parama)
  {
    this.jdField_a_of_type_ComXiaomiPushGn$a = parama;
  }
  
  /* Error */
  public void a(b arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void a(String paramString)
  {
    this.b = paramString;
  }
  
  public static enum a
  {
    static
    {
      jdField_a_of_type_ComXiaomiPushGn$a = new a("chat", 0);
      b = new a("available", 1);
      c = new a("away", 2);
      d = new a("xa", 3);
      a locala = new a("dnd", 4);
      e = locala;
      jdField_a_of_type_ArrayOfComXiaomiPushGn$a = new a[] { jdField_a_of_type_ComXiaomiPushGn$a, b, c, d, locala };
    }
    
    private a() {}
  }
  
  public static enum b
  {
    static
    {
      jdField_a_of_type_ComXiaomiPushGn$b = new b("available", 0);
      b = new b("unavailable", 1);
      c = new b("subscribe", 2);
      d = new b("subscribed", 3);
      e = new b("unsubscribe", 4);
      f = new b("unsubscribed", 5);
      g = new b("error", 6);
      b localb = new b("probe", 7);
      h = localb;
      jdField_a_of_type_ArrayOfComXiaomiPushGn$b = new b[] { jdField_a_of_type_ComXiaomiPushGn$b, b, c, d, e, f, g, localb };
    }
    
    private b() {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\gn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */