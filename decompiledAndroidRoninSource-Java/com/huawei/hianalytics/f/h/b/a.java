package com.huawei.hianalytics.f.h.b;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hianalytics.f.g.g;
import com.huawei.hianalytics.g.b;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class a
{
  public static Long a(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    Long localLong = Long.valueOf(-1L);
    if (bool) {
      return localLong;
    }
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
    try
    {
      long l = localSimpleDateFormat.parse(paramString).getTime();
      return Long.valueOf(l);
    }
    catch (ParseException paramString)
    {
      for (;;) {}
    }
    b.c("V1Common", "timestampAdapter: convertBisdkTime failed to parse time");
    return localLong;
  }
  
  public static boolean a(Context paramContext)
  {
    return ((Boolean)g.b(g.b(paramContext, "global_v2"), "v1cacheHandleFlag", Boolean.valueOf(false))).booleanValue();
  }
  
  public static void b(Context paramContext)
  {
    g.a(g.b(paramContext, "global_v2"), "v1cacheHandleFlag", Boolean.valueOf(true));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hianalytics\f\h\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */