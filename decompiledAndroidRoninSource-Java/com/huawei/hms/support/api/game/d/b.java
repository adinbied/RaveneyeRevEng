package com.huawei.hms.support.api.game.d;

import android.content.Context;
import android.content.SharedPreferences;

public class b
{
  protected SharedPreferences a;
  
  public b(Context paramContext, String paramString)
  {
    if (paramContext != null)
    {
      this.a = paramContext.getSharedPreferences(paramString, 4);
      return;
    }
    throw new NullPointerException("context is null!");
  }
  
  public String a(String paramString)
  {
    return null;
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\game\d\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */