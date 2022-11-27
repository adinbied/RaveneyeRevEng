package com.xiaomi.push.service;

import android.text.TextUtils;
import com.xiaomi.push.bf;

public class ak
{
  private static long jdField_a_of_type_Long = 0L;
  private static String jdField_a_of_type_JavaLangString = "";
  
  public static String a()
  {
    if (TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) {
      jdField_a_of_type_JavaLangString = bf.a(4);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_a_of_type_JavaLangString);
    long l = jdField_a_of_type_Long;
    jdField_a_of_type_Long = 1L + l;
    localStringBuilder.append(l);
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\service\ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */