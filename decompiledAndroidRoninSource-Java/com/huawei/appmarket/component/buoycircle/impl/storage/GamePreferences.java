package com.huawei.appmarket.component.buoycircle.impl.storage;

import android.content.Context;
import android.content.SharedPreferences;

public class GamePreferences
{
  private static final String DEF_STRING_VALUE = "";
  protected SharedPreferences preferenses;
  
  public GamePreferences(Context paramContext, String paramString)
  {
    if (paramContext != null)
    {
      this.preferenses = paramContext.getSharedPreferences(paramString, 0);
      return;
    }
    throw new NullPointerException("context is null!");
  }
  
  public boolean clear()
  {
    return false;
  }
  
  public String getString(String paramString)
  {
    return null;
  }
  
  public boolean remove(String paramString)
  {
    return false;
  }
  
  public boolean saveString(String paramString1, String paramString2)
  {
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\appmarket\component\buoycircle\impl\storage\GamePreferences.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */