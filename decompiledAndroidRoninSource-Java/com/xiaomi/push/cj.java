package com.xiaomi.push;

import android.os.Build.VERSION;
import android.system.Os;
import android.system.StructStat;
import com.xiaomi.channel.commonutils.logger.b;
import java.io.File;

public class cj
{
  public static long a(String paramString)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      try
      {
        if (new File(paramString).exists())
        {
          long l = Os.stat(paramString).st_size;
          return l;
        }
      }
      catch (Exception paramString)
      {
        b.a(paramString);
      }
    }
    return 0L;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\cj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */