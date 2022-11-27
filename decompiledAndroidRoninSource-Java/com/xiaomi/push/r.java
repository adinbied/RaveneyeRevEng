package com.xiaomi.push;

import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;

public final class r
{
  public static void a(SharedPreferences.Editor paramEditor)
  {
    if (Build.VERSION.SDK_INT > 8)
    {
      paramEditor.apply();
      return;
    }
    paramEditor.commit();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */