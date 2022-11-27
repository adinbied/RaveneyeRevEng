package com.xiaomi.push;

import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import java.io.File;

public class aa
{
  public static long a()
  {
    if (b()) {
      return 0L;
    }
    Object localObject1 = Environment.getExternalStorageDirectory();
    if (localObject1 != null) {
      if (TextUtils.isEmpty(((File)localObject1).getPath())) {
        return 0L;
      }
    }
    try
    {
      localObject1 = new StatFs(((File)localObject1).getPath());
      long l = ((StatFs)localObject1).getBlockSize();
      int i = ((StatFs)localObject1).getAvailableBlocks();
      return l * (i - 4L);
    }
    finally {}
    return 0L;
    return 0L;
  }
  
  public static boolean a()
  {
    try
    {
      boolean bool = Environment.getExternalStorageState().equals("removed");
      return bool;
    }
    catch (Exception localException)
    {
      b.a(localException);
    }
    return true;
  }
  
  public static boolean b()
  {
    try
    {
      boolean bool = Environment.getExternalStorageState().equals("mounted");
      return true ^ bool;
    }
    catch (Exception localException)
    {
      b.a(localException);
    }
    return true;
  }
  
  public static boolean c()
  {
    return a() <= 102400L;
  }
  
  public static boolean d()
  {
    return (!b()) && (!c()) && (!a());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */