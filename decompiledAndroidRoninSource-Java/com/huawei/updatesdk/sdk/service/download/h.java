package com.huawei.updatesdk.sdk.service.download;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class h
  extends RandomAccessFile
{
  public h(String paramString1, String paramString2)
    throws FileNotFoundException
  {
    super(paramString1, paramString2);
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    try
    {
      super.write(paramArrayOfByte, paramInt1, paramInt2);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      throw new a(paramArrayOfByte);
    }
  }
  
  public static class a
    extends IOException
  {
    public a(Exception paramException)
    {
      super();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawe\\updatesdk\sdk\service\download\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */