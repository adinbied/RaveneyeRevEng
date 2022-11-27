package com.huawei.updatesdk.support.pm;

import com.huawei.updatesdk.sdk.a.c.a.a.a;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class f
{
  private static int a = -1;
  
  public static boolean a(File paramFile1, File paramFile2)
  {
    boolean bool = paramFile1.renameTo(paramFile2);
    int i = 0;
    if (!bool)
    {
      if (!b(paramFile1, paramFile2))
      {
        a.d("PkgManageUtils", "can not copy the file to new Path");
        return false;
      }
      i = 1;
    }
    if ((i != 0) && (!paramFile1.delete())) {
      a.d("PkgManageUtils", "can not delete old file");
    }
    return true;
  }
  
  private static boolean a(InputStream paramInputStream, File paramFile)
  {
    try
    {
      boolean bool = paramFile.exists();
      if ((bool) && (!paramFile.delete())) {
        a.b("PkgManageUtils", "destFile delete error.");
      }
      paramFile = new FileOutputStream(paramFile);
      try
      {
        byte[] arrayOfByte = new byte['က'];
        for (;;)
        {
          int i = paramInputStream.read(arrayOfByte);
          if (i < 0) {
            break;
          }
          paramFile.write(arrayOfByte, 0, i);
        }
        return true;
      }
      finally
      {
        try
        {
          paramFile.flush();
        }
        catch (IOException localIOException1)
        {
          a.a("PkgManageUtils", "", localIOException1);
        }
        try
        {
          paramFile.getFD().sync();
        }
        catch (IOException localIOException2)
        {
          a.a("PkgManageUtils", "", localIOException2);
        }
        try
        {
          paramFile.close();
        }
        catch (IOException paramFile)
        {
          a.a("PkgManageUtils", "", paramFile);
        }
      }
      return false;
    }
    catch (IOException paramInputStream) {}
  }
  
  private static boolean b(File paramFile1, File paramFile2)
  {
    try
    {
      paramFile1 = new FileInputStream(paramFile1);
      try
      {
        boolean bool = a(paramFile1, paramFile2);
        return bool;
      }
      finally
      {
        paramFile1.close();
      }
    }
    catch (IOException paramFile1)
    {
      for (;;) {}
    }
    a.d("PkgManageUtils", "copyFile IOException");
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawe\\updatesdk\support\pm\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */