package com.huawei.hianalytics.f.f;

import android.content.Context;
import java.util.Map;

final class k
  implements i
{
  private static k a;
  private Context b;
  
  private k(Context paramContext)
  {
    this.b = paramContext;
  }
  
  public static i a(Context paramContext)
  {
    return b(paramContext);
  }
  
  private static i b(Context paramContext)
  {
    try
    {
      if (a == null) {
        a = new k(paramContext);
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  private Map<String, String> b(String paramString)
  {
    return null;
  }
  
  public String a(String paramString)
  {
    return null;
  }
  
  public boolean a(byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hianalytics\f\f\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */