package com.huawei.hms.c;

import android.content.Context;
import android.content.res.Resources;

public abstract class h
{
  private static Context a;
  private static String b;
  
  public static int a(String paramString)
  {
    return a.getResources().getIdentifier(paramString, "layout", b);
  }
  
  public static Context a()
  {
    return a;
  }
  
  public static String a(String paramString, Object... paramVarArgs)
  {
    paramVarArgs = a.getResources().getString(c(paramString), paramVarArgs);
    paramString = paramVarArgs;
    if (paramVarArgs == null) {
      paramString = "";
    }
    return paramString;
  }
  
  public static void a(Context paramContext)
  {
    a = paramContext;
    b = paramContext.getPackageName();
  }
  
  public static int b(String paramString)
  {
    return a.getResources().getIdentifier(paramString, "id", b);
  }
  
  public static int c(String paramString)
  {
    return a.getResources().getIdentifier(paramString, "string", b);
  }
  
  public static String d(String paramString)
  {
    String str = a.getResources().getString(c(paramString));
    paramString = str;
    if (str == null) {
      paramString = "";
    }
    return paramString;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\c\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */