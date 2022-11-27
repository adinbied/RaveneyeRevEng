package com.huawei.updatesdk.service.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class d
{
  protected SharedPreferences a;
  
  public d(SharedPreferences paramSharedPreferences)
  {
    this.a = paramSharedPreferences;
  }
  
  public static d a(String paramString, Context paramContext)
  {
    return new d(paramContext.getSharedPreferences(paramString, 0));
  }
  
  public SharedPreferences.Editor a()
  {
    return this.a.edit();
  }
  
  /* Error */
  public void a(String arg1, long arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void a(String arg1, String arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public long b(String paramString, long paramLong)
  {
    return 1006646481L;
  }
  
  public String b(String paramString1, String paramString2)
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawe\\updatesdk\service\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */