package com.xiaomi.push;

import android.content.Context;

public class dz
{
  private static volatile dz jdField_a_of_type_ComXiaomiPushDz;
  private Context jdField_a_of_type_AndroidContentContext;
  
  private dz(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private int a(int paramInt)
  {
    return Math.max(60, paramInt);
  }
  
  public static dz a(Context paramContext)
  {
    if (jdField_a_of_type_ComXiaomiPushDz == null) {
      try
      {
        if (jdField_a_of_type_ComXiaomiPushDz == null) {
          jdField_a_of_type_ComXiaomiPushDz = new dz(paramContext);
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComXiaomiPushDz;
  }
  
  private boolean a()
  {
    return false;
  }
  
  /* Error */
  private void b()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\dz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */