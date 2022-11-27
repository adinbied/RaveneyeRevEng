package com.huawei.hianalytics.util;

import java.io.File;

public class b
{
  public static void a(File paramFile)
  {
    if (paramFile != null)
    {
      if (!paramFile.exists()) {
        return;
      }
      if (paramFile.isFile())
      {
        if (!paramFile.delete()) {
          com.huawei.hianalytics.g.b.c("HianalyticsSDK", "remover file fail!");
        }
      }
      else
      {
        paramFile = paramFile.listFiles();
        if (paramFile == null)
        {
          com.huawei.hianalytics.g.b.c("HianalyticsSDK", "not have file remove!");
          return;
        }
        int j = paramFile.length;
        int i = 0;
        while (i < j)
        {
          File localFile = paramFile[i];
          if (localFile.isDirectory()) {
            a(localFile);
          } else if (!localFile.delete()) {
            com.huawei.hianalytics.g.b.d("HianalyticsSDK", "remover file fail!");
          }
          i += 1;
        }
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hianalytic\\util\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */