package com.xiaomi.push;

import java.text.SimpleDateFormat;

public class bp
  implements gg
{
  public static boolean a;
  private a jdField_a_of_type_ComXiaomiPushBp$a = null;
  private fu jdField_a_of_type_ComXiaomiPushFu = null;
  private fx jdField_a_of_type_ComXiaomiPushFx = null;
  private final String jdField_a_of_type_JavaLangString = "[Slim] ";
  private SimpleDateFormat jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("hh:mm:ss aaa");
  private a b = null;
  
  static
  {
    int i = t.a();
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    jdField_a_of_type_Boolean = bool;
  }
  
  public bp(fu paramfu)
  {
    this.jdField_a_of_type_ComXiaomiPushFu = paramfu;
    a();
  }
  
  /* Error */
  private void a()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  class a
    implements fz, gh
  {
    String jdField_a_of_type_JavaLangString;
    
    a(boolean paramBoolean)
    {
      if (paramBoolean) {
        this$1 = " RCV ";
      } else {
        this$1 = " Sent ";
      }
      this.jdField_a_of_type_JavaLangString = bp.this;
    }
    
    /* Error */
    public void a(fn arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void a(gl arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public boolean a(gl paramgl)
    {
      return true;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\bp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */