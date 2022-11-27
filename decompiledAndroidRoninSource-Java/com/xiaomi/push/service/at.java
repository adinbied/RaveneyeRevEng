package com.xiaomi.push.service;

import android.content.Context;
import android.net.Uri;

public class at
{
  private static at jdField_a_of_type_ComXiaomiPushServiceAt;
  private int jdField_a_of_type_Int = 0;
  private Context jdField_a_of_type_AndroidContentContext;
  
  private at(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
  }
  
  public static at a(Context paramContext)
  {
    if (jdField_a_of_type_ComXiaomiPushServiceAt == null) {
      jdField_a_of_type_ComXiaomiPushServiceAt = new at(paramContext);
    }
    return jdField_a_of_type_ComXiaomiPushServiceAt;
  }
  
  public int a()
  {
    return 0;
  }
  
  public Uri a()
  {
    return null;
  }
  
  public boolean a()
  {
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\service\at.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */