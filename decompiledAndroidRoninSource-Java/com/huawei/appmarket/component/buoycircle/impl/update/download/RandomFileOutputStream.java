package com.huawei.appmarket.component.buoycircle.impl.update.download;

import com.huawei.appmarket.component.buoycircle.impl.utils.IOUtil;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;

public class RandomFileOutputStream
  extends OutputStream
{
  private RandomAccessFile mRaf;
  
  public RandomFileOutputStream(File paramFile, int paramInt)
    throws IOException
  {
    try
    {
      paramFile = new RandomAccessFile(paramFile, "rwd");
      this.mRaf = paramFile;
      paramFile.setLength(paramInt);
      return;
    }
    catch (IOException paramFile)
    {
      IOUtil.closeQuietly(this.mRaf);
      throw paramFile;
    }
    catch (FileNotFoundException paramFile)
    {
      throw paramFile;
    }
  }
  
  public void close()
    throws IOException
  {
    this.mRaf.close();
  }
  
  public void seek(long paramLong)
    throws IOException
  {
    this.mRaf.seek(paramLong);
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
    this.mRaf.write(paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\appmarket\component\buoycircle\imp\\update\download\RandomFileOutputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */