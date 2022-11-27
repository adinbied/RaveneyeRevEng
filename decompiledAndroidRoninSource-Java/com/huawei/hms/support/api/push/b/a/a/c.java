package com.huawei.hms.support.api.push.b.a.a;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Map;

public class c
{
  protected SharedPreferences a;
  
  public c(Context paramContext, String paramString)
  {
    if (paramContext != null)
    {
      this.a = paramContext.getSharedPreferences(paramString, 4);
      return;
    }
    throw new NullPointerException("context is null!");
  }
  
  public Map<String, ?> a()
  {
    return null;
  }
  
  /* Error */
  public void a(String arg1, Long arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void a(String arg1, boolean arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean a(String paramString)
  {
    return false;
  }
  
  public boolean a(String paramString, Object paramObject)
  {
    return false;
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    return false;
  }
  
  public String b(String paramString)
  {
    return null;
  }
  
  public boolean c(String paramString)
  {
    return false;
  }
  
  public boolean d(String paramString)
  {
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\push\b\a\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */