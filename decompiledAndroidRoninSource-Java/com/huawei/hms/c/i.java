package com.huawei.hms.c;

import com.huawei.hms.support.log.a;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public abstract class i
{
  public static byte[] a(File paramFile)
  {
    Object localObject2 = null;
    Object localObject4 = null;
    Object localObject1 = localObject4;
    try
    {
      try
      {
        MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-256");
        localObject1 = localObject4;
        paramFile = new BufferedInputStream(new FileInputStream(paramFile));
        int i;
        int j;
        localObject1 = paramFile;
      }
      finally
      {
        try
        {
          try
          {
            localObject1 = new byte['က'];
            i = 0;
            for (;;)
            {
              j = paramFile.read((byte[])localObject1);
              if (j == -1) {
                break;
              }
              i += j;
              localMessageDigest.update((byte[])localObject1, 0, j);
            }
            if (i > 0)
            {
              localObject1 = localMessageDigest.digest();
              e.a(paramFile);
              return (byte[])localObject1;
            }
            e.a(paramFile);
          }
          finally
          {
            localObject1 = paramFile;
            paramFile = (File)localObject3;
            break label126;
          }
        }
        catch (NoSuchAlgorithmException|IOException localNoSuchAlgorithmException)
        {
          for (;;) {}
        }
        paramFile = finally;
        break label126;
      }
    }
    catch (NoSuchAlgorithmException|IOException paramFile)
    {
      for (;;)
      {
        paramFile = (File)localObject3;
      }
    }
    a.d("SHA256", "An exception occurred while computing file 'SHA-256'.");
    e.a(paramFile);
    return new byte[0];
    label126:
    e.a((InputStream)localObject1);
    throw paramFile;
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = MessageDigest.getInstance("SHA-256").digest(paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (NoSuchAlgorithmException paramArrayOfByte)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("NoSuchAlgorithmException");
      localStringBuilder.append(paramArrayOfByte.getMessage());
      a.d("SHA256", localStringBuilder.toString());
    }
    return new byte[0];
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\c\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */