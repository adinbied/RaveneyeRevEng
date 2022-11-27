package com.xiaomi.push;

import com.xiaomi.channel.commonutils.logger.b;
import java.io.File;
import java.util.HashMap;

public class x
{
  private static final HashMap<String, String> a;
  
  static
  {
    HashMap localHashMap = new HashMap();
    a = localHashMap;
    localHashMap.put("FFD8FF", "jpg");
    a.put("89504E47", "png");
    a.put("47494638", "gif");
    a.put("474946", "gif");
    a.put("424D", "bmp");
  }
  
  public static long a(File paramFile)
  {
    long l1 = 0L;
    long l2 = l1;
    try
    {
      paramFile = paramFile.listFiles();
      int i = 0;
      long l3;
      for (;;)
      {
        l2 = l1;
        l3 = l1;
        if (i >= paramFile.length) {
          break;
        }
        l2 = l1;
        if (paramFile[i].isDirectory())
        {
          l2 = l1;
          l3 = a(paramFile[i]);
          l2 = l3;
        }
        else
        {
          l2 = l1;
          l3 = paramFile[i].length();
          l2 = l3;
        }
        l1 += l2;
        i += 1;
      }
      return l3;
    }
    catch (Exception paramFile)
    {
      b.a(paramFile);
      l3 = l2;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */