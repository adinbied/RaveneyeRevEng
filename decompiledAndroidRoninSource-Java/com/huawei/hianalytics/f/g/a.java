package com.huawei.hianalytics.f.g;

import android.content.Context;
import java.io.File;

public final class a
{
  private static a d;
  private String a;
  private String b;
  private Context c;
  private String e;
  
  private a(Context paramContext)
  {
    this.c = paramContext;
    this.e = paramContext.getFilesDir().getPath();
  }
  
  public static a a(Context paramContext)
  {
    try
    {
      if (d == null) {
        d = new a(paramContext);
      }
      paramContext = d;
      return paramContext;
    }
    finally {}
  }
  
  private String a(File paramFile)
  {
    return null;
  }
  
  private String a(File paramFile, String paramString)
  {
    return null;
  }
  
  private String a(String paramString1, String paramString2)
  {
    return null;
  }
  
  /* Error */
  private void a(android.content.SharedPreferences arg1, String arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static String b()
  {
    String str1 = i.a();
    String str2 = com.huawei.hianalytics.f.a.a.a();
    String str3 = e.c();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str1);
    localStringBuilder.append(str2);
    localStringBuilder.append(str3);
    return i.a(localStringBuilder.toString(), 4);
  }
  
  private String b(Context paramContext)
  {
    return null;
  }
  
  /* Error */
  private void b(File arg1, String arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  private void c()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private String d()
  {
    return null;
  }
  
  private String e()
  {
    return null;
  }
  
  private String f()
  {
    return this.e;
  }
  
  public String a()
  {
    return null;
  }
  
  /* Error */
  public void a(String arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hianalytics\f\g\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */