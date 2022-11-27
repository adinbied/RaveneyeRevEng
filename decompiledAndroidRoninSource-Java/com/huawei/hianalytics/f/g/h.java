package com.huawei.hianalytics.f.g;

import com.huawei.hianalytics.g.b;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.Deflater;

public final class h
{
  public static int a(String paramString)
  {
    if ("preins".equals(paramString)) {
      return 2;
    }
    if ("maint".equals(paramString)) {
      return 1;
    }
    return 0;
  }
  
  private static void a(OutputStream paramOutputStream)
  {
    if (paramOutputStream != null) {}
    try
    {
      paramOutputStream.close();
      return;
    }
    catch (IOException paramOutputStream)
    {
      for (;;) {}
    }
    b.c("StreamUtil", "closeStream(): Exception: close OutputStream error!");
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    Deflater localDeflater = new Deflater();
    localDeflater.setInput(paramArrayOfByte);
    localDeflater.finish();
    paramArrayOfByte = new byte['Ѐ'];
    while (!localDeflater.finished()) {
      localByteArrayOutputStream.write(paramArrayOfByte, 0, localDeflater.deflate(paramArrayOfByte));
    }
    paramArrayOfByte = localByteArrayOutputStream.toByteArray();
    localDeflater.end();
    a(localByteArrayOutputStream);
    return paramArrayOfByte;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hianalytics\f\g\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */