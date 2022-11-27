package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import java.text.SimpleDateFormat;

public class ci
{
  private static String jdField_a_of_type_JavaLangString;
  private static SimpleDateFormat jdField_a_of_type_JavaTextSimpleDateFormat;
  
  static
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
    jdField_a_of_type_JavaTextSimpleDateFormat = localSimpleDateFormat;
    jdField_a_of_type_JavaLangString = localSimpleDateFormat.format(Long.valueOf(System.currentTimeMillis()));
  }
  
  public static hs a(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    hs localhs = new hs();
    localhs.d("category_push_stat");
    localhs.a("push_sdk_stat_channel");
    localhs.a(1L);
    localhs.b(paramString);
    localhs.a(true);
    localhs.b(System.currentTimeMillis());
    localhs.g(br.a(paramContext).a());
    localhs.e("com.xiaomi.xmsf");
    localhs.f("");
    localhs.c("push_stat");
    return localhs;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\ci.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */