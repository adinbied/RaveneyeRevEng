package com.huawei.updatesdk.support.e;

import android.content.Context;
import android.content.res.Resources;

public final class d
{
  private static String a;
  private static Resources b;
  
  public static int a(Context paramContext, String paramString)
  {
    return a(paramContext, paramString, "id");
  }
  
  private static int a(Context paramContext, String paramString1, String paramString2)
  {
    if (b == null) {
      b = paramContext.getResources();
    }
    return b.getIdentifier(paramString1, paramString2, a(paramContext));
  }
  
  private static String a(Context paramContext)
  {
    if (a == null) {
      a = paramContext.getPackageName();
    }
    return a;
  }
  
  public static int b(Context paramContext, String paramString)
  {
    return a(paramContext, paramString, "string");
  }
  
  public static int c(Context paramContext, String paramString)
  {
    return a(paramContext, paramString, "layout");
  }
  
  public static int d(Context paramContext, String paramString)
  {
    return a(paramContext, paramString, "drawable");
  }
  
  public static int e(Context paramContext, String paramString)
  {
    return a(paramContext, paramString, "color");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawe\\updatesdk\support\e\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */