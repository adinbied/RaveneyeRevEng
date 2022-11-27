package com.huawei.hms.update.a;

import com.huawei.hms.c.e;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;

public class b
  extends OutputStream
{
  private RandomAccessFile a;
  
  public b(File paramFile, int paramInt)
    throws IOException
  {
    try
    {
      paramFile = new RandomAccessFile(paramFile, "rwd");
      this.a = paramFile;
      paramFile.setLength(paramInt);
      return;
    }
    catch (IOException paramFile)
    {
      e.a(this.a);
      throw paramFile;
    }
    catch (FileNotFoundException paramFile)
    {
      throw paramFile;
    }
  }
  
  public void a(long paramLong)
    throws IOException
  {
    this.a.seek(paramLong);
  }
  
  public void close()
    throws IOException
  {
    this.a.close();
  }
  
  /* Error */
  public void write(int arg1)
    throws IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    this.a.write(paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hm\\update\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */