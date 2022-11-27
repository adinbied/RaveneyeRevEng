package com.huawei.hianalytics.log.f;

import android.text.TextUtils;
import com.huawei.hianalytics.g.b;
import com.huawei.hianalytics.log.e.f;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public final class a
{
  public static File a(String paramString1, String paramString2, int paramInt)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      paramString2 = new File(paramString1, paramString2);
    }
    try
    {
      if (!paramString2.createNewFile()) {
        break label51;
      }
      b.b("HiAnalytics/logServer", "log file createNewFile");
    }
    catch (IOException localIOException)
    {
      int n;
      int i1;
      int i;
      int j;
      int m;
      for (;;) {}
    }
    b.d("AppLogManager", "createNewFile Exception,log File creation failure!");
    label51:
    paramString1 = a(paramString1);
    n = f.b(paramString1);
    i1 = paramString1.length;
    i = 0;
    j = paramInt;
    m = 0;
    while (i < i1)
    {
      int k = j;
      if (paramString1[i].getName().equals("eventinfo.log"))
      {
        k = j + 1;
        m = 1;
      }
      i += 1;
      j = k;
    }
    if (n > j)
    {
      if (m == 0)
      {
        Arrays.sort(paramString1, new a());
        a(paramString1, paramInt);
        return paramString2;
      }
      paramString1 = a(paramString1);
      Arrays.sort(paramString1, new a());
      a(paramString1, paramInt);
    }
    return paramString2;
    b.d("AppLogManager", "createLogFile Exc, not have file path or name");
    return null;
  }
  
  public static void a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject = new File(paramString);
    File[] arrayOfFile = ((File)localObject).listFiles();
    if (arrayOfFile == null) {}
    for (paramString = "not have file in logzips!";; paramString = "zips number anomaly ,Delete the file ")
    {
      b.c("AppLogManager", paramString);
      return;
      if (arrayOfFile.length <= paramInt) {
        break;
      }
      com.huawei.hianalytics.log.e.a.a((File)localObject);
    }
    Arrays.sort(arrayOfFile, new a());
    int j = arrayOfFile.length;
    long l1 = 0L;
    int i = 0;
    while (i < j)
    {
      localObject = arrayOfFile[i];
      if ((((File)localObject).length() > 1887436.8D) && (((File)localObject).delete()))
      {
        b.c("HiAnalytics/logServer", "Delete a file with a length greater than 1.8M ");
        l1 = 0L;
      }
      else
      {
        long l2 = l1 + ((File)localObject).length();
        l1 = l2;
        if (l2 >= 1887436.8D)
        {
          if (f.a(arrayOfFile)) {}
          for (localObject = "delFullFile() true";; localObject = "delFullFile() Crash file deletion success")
          {
            b.b("HiAnalytics/logServer", (String)localObject);
            break;
            if (!arrayOfFile[0].delete()) {
              break;
            }
          }
          a(paramString, paramInt);
          l1 = l2;
        }
      }
      i += 1;
    }
  }
  
  public static boolean a(File paramFile)
  {
    return paramFile.length() <= 204800;
  }
  
  public static boolean a(File[] paramArrayOfFile, int paramInt)
  {
    if ((paramArrayOfFile != null) && (paramArrayOfFile.length >= paramInt))
    {
      boolean bool2 = true;
      int i = 0;
      int k;
      for (int j = 0; i < paramArrayOfFile.length; j = k)
      {
        boolean bool1 = bool2;
        k = j;
        if (i < paramArrayOfFile.length - paramInt + j) {
          if (paramArrayOfFile[i].getName().contains("Crash"))
          {
            k = j + 1;
            bool1 = bool2;
          }
          else if (!paramArrayOfFile[i].delete())
          {
            b.c("AppLogManager", "delete failed:");
            bool1 = false;
            k = j;
          }
          else
          {
            b.c("AppLogManager", "delete success:");
            k = j;
            bool1 = bool2;
          }
        }
        bool2 = bool1;
        if (k >= 5) {
          if (!paramArrayOfFile[0].delete())
          {
            b.c("AppLogManager", "delete failed:");
            bool2 = false;
          }
          else
          {
            b.c("AppLogManager", "delete success:");
            bool2 = bool1;
          }
        }
        i += 1;
      }
      return bool2;
    }
    b.b("AppLogManager", "files is empty or files size too much");
    return false;
  }
  
  public static File[] a(String paramString)
  {
    return new File(paramString).listFiles();
  }
  
  public static File[] a(File[] paramArrayOfFile)
  {
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayOfFile.length;
    int i = 0;
    while (i < j)
    {
      File localFile = paramArrayOfFile[i];
      if (!localFile.getName().equals("eventinfo.log")) {
        localArrayList.add(localFile);
      }
      i += 1;
    }
    return (File[])localArrayList.toArray(new File[localArrayList.size()]);
  }
  
  public static class a
    implements Serializable, Comparator<File>
  {
    public int a(File paramFile1, File paramFile2)
    {
      return 0;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hianalytics\log\f\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */