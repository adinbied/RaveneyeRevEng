package com.huawei.hianalytics.log.f;

import android.content.Context;
import com.huawei.hianalytics.log.a.a;
import com.huawei.hianalytics.log.e.d;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class b
  implements c
{
  private String a(String paramString)
  {
    return null;
  }
  
  private static void a(ZipInputStream paramZipInputStream, File paramFile)
  {
    localObject2 = null;
    Object localObject3 = null;
    FileOutputStream localFileOutputStream = null;
    Object localObject1 = localFileOutputStream;
    for (;;)
    {
      try
      {
        try
        {
          ZipEntry localZipEntry = paramZipInputStream.getNextEntry();
          if (localZipEntry == null)
          {
            d.a(0, null);
            return;
          }
          localObject1 = localFileOutputStream;
          localObject4 = c(localZipEntry.getName());
          localObject1 = localFileOutputStream;
          if (((String)localObject4).equals(""))
          {
            localObject1 = localFileOutputStream;
            com.huawei.hianalytics.g.b.c("SendManagerImpl", "File name exception, stop unzip");
            d.a(0, null);
            return;
          }
          localObject1 = localFileOutputStream;
          StringBuilder localStringBuilder = new StringBuilder();
          localObject1 = localFileOutputStream;
          localStringBuilder.append(paramFile.getAbsolutePath());
          localObject1 = localFileOutputStream;
          localStringBuilder.append(File.separator);
          localObject1 = localFileOutputStream;
          localStringBuilder.append((String)localObject4);
          localObject1 = localFileOutputStream;
          localObject4 = new File(localStringBuilder.toString());
          localObject1 = localFileOutputStream;
          boolean bool = localZipEntry.isDirectory();
          if (bool)
          {
            localObject1 = localFileOutputStream;
            if (!((File)localObject4).mkdirs())
            {
              paramZipInputStream = "fileUnZip() Unzip file creation failure";
              localObject1 = localFileOutputStream;
              com.huawei.hianalytics.g.b.b("HiAnalytics/logServer", paramZipInputStream);
              paramZipInputStream = (ZipInputStream)localObject3;
            }
            else
            {
              localObject1 = localFileOutputStream;
              a(paramZipInputStream, paramFile);
              paramZipInputStream = (ZipInputStream)localObject3;
            }
          }
          else
          {
            localObject1 = localFileOutputStream;
            if (!((File)localObject4).createNewFile())
            {
              paramZipInputStream = "fileUnZip() Failure to create new files";
              continue;
            }
            localObject1 = localFileOutputStream;
            localFileOutputStream = new FileOutputStream((File)localObject4);
          }
        }
        finally
        {
          Object localObject4;
          int i;
          int j;
        }
      }
      catch (IOException paramZipInputStream)
      {
        paramZipInputStream = (ZipInputStream)localObject2;
        continue;
      }
      try
      {
        try
        {
          localObject1 = new byte['ࠀ'];
          i = 0;
          j = paramZipInputStream.read((byte[])localObject1);
          if (j != -1)
          {
            i += j;
            if (a(i, (File)localObject4))
            {
              localFileOutputStream.write((byte[])localObject1, 0, j);
              continue;
            }
          }
          a(paramZipInputStream, paramFile);
          paramZipInputStream = localFileOutputStream;
        }
        finally
        {
          localObject1 = localFileOutputStream;
        }
      }
      catch (IOException paramZipInputStream) {}
    }
    paramZipInputStream = localFileOutputStream;
    localObject1 = paramZipInputStream;
    com.huawei.hianalytics.g.b.d("SendManagerImpl", "fileUnZip() File creation failure or Stream Exception!");
    d.a(0, paramZipInputStream);
    return;
    d.a(0, (Closeable)localObject1);
    throw paramZipInputStream;
  }
  
  private static boolean a(int paramInt, File paramFile)
  {
    if (paramInt > 5242880)
    {
      com.huawei.hianalytics.g.b.d("SendManagerImpl", "Single File being unzipped is too big.");
      if ((paramFile.exists()) && (paramFile.delete())) {
        com.huawei.hianalytics.g.b.b("SendManagerImpl", "Delete large files successfully");
      }
      return false;
    }
    return true;
  }
  
  private String b(String paramString1, String paramString2, String paramString3)
  {
    return a.a(paramString1, paramString2, paramString3);
  }
  
  /* Error */
  private void b(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private static String c(String paramString)
  {
    paramString = new File(paramString);
    try
    {
      paramString = paramString.getCanonicalPath();
      if (paramString.startsWith(new File(".").getCanonicalPath())) {
        return paramString;
      }
      com.huawei.hianalytics.g.b.d("SendManagerImpl", "File is outside extraction target directory.");
      return "";
    }
    catch (IOException paramString) {}
    return "";
  }
  
  /* Error */
  public void a(String arg1, String arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void a(String arg1, String arg2, java.security.Key arg3)
  {
    // Byte code:
    //   0: goto +9 -> 9
    //   3: goto +6 -> 9
    //   6: return
    //   7: astore_1
    //   8: return
    //   9: goto -3 -> 6
  }
  
  public boolean a(String paramString1, String paramString2, Context paramContext)
  {
    return false;
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3)
  {
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hianalytics\log\f\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */