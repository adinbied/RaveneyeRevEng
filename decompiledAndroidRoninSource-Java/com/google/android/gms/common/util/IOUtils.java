package com.google.android.gms.common.util;

import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.internal.Preconditions;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.annotation.Nullable;

@Deprecated
public final class IOUtils
{
  public static void closeQuietly(@Nullable ParcelFileDescriptor paramParcelFileDescriptor)
  {
    if (paramParcelFileDescriptor != null) {}
    try
    {
      paramParcelFileDescriptor.close();
      return;
    }
    catch (IOException paramParcelFileDescriptor) {}
  }
  
  public static void closeQuietly(@Nullable Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable) {}
  }
  
  @Deprecated
  public static long copyStream(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException
  {
    return zza(paramInputStream, paramOutputStream, false);
  }
  
  @Deprecated
  public static long copyStream(InputStream paramInputStream, OutputStream paramOutputStream, boolean paramBoolean, int paramInt)
    throws IOException
  {
    byte[] arrayOfByte = new byte[paramInt];
    long l = 0L;
    try
    {
      for (;;)
      {
        int i = paramInputStream.read(arrayOfByte, 0, paramInt);
        if (i == -1) {
          break;
        }
        l += i;
        paramOutputStream.write(arrayOfByte, 0, i);
      }
      return l;
    }
    finally
    {
      if (paramBoolean)
      {
        closeQuietly(paramInputStream);
        closeQuietly(paramOutputStream);
      }
    }
  }
  
  public static boolean isGzipByteBuffer(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length > 1)
    {
      int i = paramArrayOfByte[0];
      if (((paramArrayOfByte[1] & 0xFF) << 8 | i & 0xFF) == 35615) {
        return true;
      }
    }
    return false;
  }
  
  @Deprecated
  public static byte[] readInputStreamFully(InputStream paramInputStream)
    throws IOException
  {
    return readInputStreamFully(paramInputStream, true);
  }
  
  @Deprecated
  public static byte[] readInputStreamFully(InputStream paramInputStream, boolean paramBoolean)
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    zza(paramInputStream, localByteArrayOutputStream, paramBoolean);
    return localByteArrayOutputStream.toByteArray();
  }
  
  @Deprecated
  public static byte[] toByteArray(InputStream paramInputStream)
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    Preconditions.checkNotNull(paramInputStream);
    Preconditions.checkNotNull(localByteArrayOutputStream);
    byte[] arrayOfByte = new byte['က'];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i == -1) {
        break;
      }
      localByteArrayOutputStream.write(arrayOfByte, 0, i);
    }
    return localByteArrayOutputStream.toByteArray();
  }
  
  @Deprecated
  private static long zza(InputStream paramInputStream, OutputStream paramOutputStream, boolean paramBoolean)
    throws IOException
  {
    return copyStream(paramInputStream, paramOutputStream, paramBoolean, 1024);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\commo\\util\IOUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */