package com.huawei.hms.c;

import android.content.Context;
import com.huawei.hms.support.log.a;
import java.io.File;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public abstract class b
{
  private static boolean a;
  private static ScheduledExecutorService b = ;
  
  public static void a(Context paramContext, File paramFile1, File paramFile2, String paramString, long paramLong, int paramInt)
  {
    if ((paramFile1 != null) && (paramFile1.isFile()) && (paramFile1.exists()))
    {
      if (!a)
      {
        if ((paramFile2 != null) && (paramFile2.exists()) && (!paramFile2.delete())) {
          a.d("FileUtil", "file delete failed.");
        }
        a = true;
      }
      paramContext = new StringBuilder();
      paramContext.append(paramString);
      paramContext.append("|");
      paramContext.append(paramLong);
      paramContext.append("|");
      paramContext.append(paramInt);
      a(paramFile2, paramContext.toString(), 10240L);
    }
  }
  
  public static void a(File paramFile, String paramString, long paramLong)
  {
    b.execute(new c(paramFile, paramLong, paramString));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\c\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */