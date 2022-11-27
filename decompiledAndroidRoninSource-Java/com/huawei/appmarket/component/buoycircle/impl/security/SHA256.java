package com.huawei.appmarket.component.buoycircle.impl.security;

import com.huawei.appmarket.component.buoycircle.impl.log.BuoyLog;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public abstract class SHA256
{
  private static final int BUFF_SIZE = 4096;
  private static final String TAG = "SHA256";
  
  public static byte[] digest(File paramFile)
  {
    Object localObject2 = null;
    Object localObject4 = null;
    Object localObject1 = localObject4;
    for (;;)
    {
      try
      {
        label85:
        try
        {
          localMessageDigest = MessageDigest.getInstance("SHA-256");
          localObject1 = localObject4;
          paramFile = new BufferedInputStream(new FileInputStream(paramFile));
        }
        finally
        {
          MessageDigest localMessageDigest;
          int i;
          int j;
        }
      }
      catch (NoSuchAlgorithmException|IOException paramFile)
      {
        paramFile = (File)localObject3;
        continue;
      }
      try
      {
        try
        {
          localObject1 = new byte['က'];
          i = 0;
          j = paramFile.read((byte[])localObject1);
          if (j != -1)
          {
            i += j;
            localMessageDigest.update((byte[])localObject1, 0, j);
          }
          else if (i > 0)
          {
            localObject1 = localMessageDigest.digest();
          }
        }
        finally
        {
          try
          {
            paramFile.close();
          }
          catch (IOException paramFile)
          {
            continue;
          }
          localObject3 = finally;
          localObject1 = paramFile;
          paramFile = (File)localObject3;
        }
      }
      catch (NoSuchAlgorithmException|IOException localNoSuchAlgorithmException) {}
    }
    try
    {
      paramFile.close();
      return (byte[])localObject1;
    }
    catch (IOException paramFile)
    {
      break label85;
    }
    BuoyLog.e("SHA256", "An exception occurred while closing the 'Closeable' object.");
    return (byte[])localObject1;
    localObject1 = paramFile;
    BuoyLog.e("SHA256", "An exception occurred while computing file 'SHA-256'.");
    if (paramFile != null)
    {
      paramFile.close();
      break label145;
      BuoyLog.e("SHA256", "An exception occurred while closing the 'Closeable' object.");
    }
    label145:
    return new byte[0];
    if (localObject1 != null) {}
    try
    {
      ((InputStream)localObject1).close();
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
    BuoyLog.e("SHA256", "An exception occurred while closing the 'Closeable' object.");
    throw paramFile;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\appmarket\component\buoycircle\impl\security\SHA256.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */