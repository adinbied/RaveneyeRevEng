package com.huawei.updatesdk.service.a;

import android.text.TextUtils;

public abstract interface a
{
  public static class a
  {
    private static String a = c.a().b();
    private static boolean b = false;
    private static boolean c = false;
    
    public static String a()
    {
      return a;
    }
    
    public static void a(int paramInt)
    {
      if ((!b) && (paramInt != 0) && (!a.contains("192")))
      {
        b = true;
        String str = a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramInt);
        localStringBuilder.append(".");
        a = str.replaceFirst("\\.", localStringBuilder.toString());
      }
    }
    
    public static void a(boolean paramBoolean)
    {
      c = paramBoolean;
    }
    
    public static String b()
    {
      String str1 = a;
      Object localObject = str1;
      if (c)
      {
        String str2 = b.a().g();
        localObject = str1;
        if (!TextUtils.isEmpty(str2)) {
          localObject = str2;
        }
      }
      return (String)localObject;
    }
    
    public static boolean c()
    {
      return c;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawe\\updatesdk\service\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */