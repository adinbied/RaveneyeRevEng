package com.huawei.hianalytics.log.e;

import android.content.Context;
import com.huawei.hianalytics.log.b.a.a;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class a
{
  public static void a(Context paramContext)
  {
    if (paramContext != null) {}
    try
    {
      com.huawei.hianalytics.g.b.b("HiAnalytics/logServer", "Clear all data of local log");
      paramContext = paramContext.getFilesDir().getPath();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramContext);
      localStringBuilder.append(a.a.a);
      b(new File(localStringBuilder.toString()));
    }
    finally {}
  }
  
  public static void a(File paramFile)
  {
    com.huawei.hianalytics.util.b.a(paramFile);
  }
  
  public static void a(String paramString)
  {
    File[] arrayOfFile = new File(paramString).listFiles();
    if (arrayOfFile != null)
    {
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        paramString = arrayOfFile[i];
        Object localObject = paramString.getName();
        if ((!((String)localObject).endsWith(".log")) && (!((String)localObject).endsWith(".zip")))
        {
          if (paramString.delete())
          {
            paramString = new StringBuilder();
            paramString.append("this file is not our fileName :");
            paramString.append((String)localObject);
          }
        }
        else {
          for (paramString = paramString.toString();; paramString = "out time file del ok")
          {
            com.huawei.hianalytics.g.b.b("HiAnalytics/logServer", paramString);
            break;
            if (((String)localObject).equals("eventinfo.log")) {
              break;
            }
            localObject = ((String)localObject).substring(0, ((String)localObject).lastIndexOf(".")).split("_");
            long l = b(localObject[(localObject.length - 1)].trim());
            if ((System.currentTimeMillis() - l < 604800000L) || (!paramString.delete())) {
              break;
            }
          }
        }
        i += 1;
      }
    }
  }
  
  private static long b(String paramString)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS", Locale.getDefault());
    try
    {
      paramString = localSimpleDateFormat.parse(paramString);
      if (paramString == null) {
        return 0L;
      }
      long l = paramString.getTime();
      return l;
    }
    catch (ParseException paramString)
    {
      for (;;) {}
    }
    com.huawei.hianalytics.g.b.c("HiAnalytics/logServer", "Time conversion Exception : getTimeMillis!");
    return 0L;
  }
  
  public static void b(File paramFile)
  {
    if (paramFile == null) {
      return;
    }
    if (paramFile.exists()) {
      if (paramFile.isFile())
      {
        if (paramFile.delete()) {}
      }
      else {
        do
        {
          String[] arrayOfString;
          for (;;)
          {
            com.huawei.hianalytics.g.b.c("HiAnalytics/logServer", "refresh clear file fail");
            return;
            if (!paramFile.isDirectory()) {
              return;
            }
            arrayOfString = paramFile.list();
            if (arrayOfString != null) {
              break;
            }
            if (paramFile.delete()) {
              return;
            }
          }
          int j = arrayOfString.length;
          int i = 0;
          while (i < j)
          {
            b(new File(paramFile, arrayOfString[i]));
            i += 1;
          }
        } while (!paramFile.delete());
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hianalytics\log\e\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */