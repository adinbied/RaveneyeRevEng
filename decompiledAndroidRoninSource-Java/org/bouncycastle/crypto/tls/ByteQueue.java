package org.bouncycastle.crypto.tls;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ByteQueue
{
  private static final int DEFAULT_CAPACITY = 1024;
  private int available = 0;
  private byte[] databuf;
  private boolean readOnlyBuf = false;
  private int skipped = 0;
  
  public ByteQueue()
  {
    this(1024);
  }
  
  public ByteQueue(int paramInt)
  {
    byte[] arrayOfByte;
    if (paramInt == 0) {
      arrayOfByte = TlsUtils.EMPTY_BYTES;
    } else {
      arrayOfByte = new byte[paramInt];
    }
    this.databuf = arrayOfByte;
  }
  
  public ByteQueue(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.databuf = paramArrayOfByte;
    this.skipped = paramInt1;
    this.available = paramInt2;
    this.readOnlyBuf = true;
  }
  
  public static int nextTwoPow(int paramInt)
  {
    paramInt |= paramInt >> 1;
    paramInt |= paramInt >> 2;
    paramInt |= paramInt >> 4;
    paramInt |= paramInt >> 8;
    return (paramInt | paramInt >> 16) + 1;
  }
  
  public void addData(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (!this.readOnlyBuf)
    {
      int i = this.skipped;
      int j = this.available;
      if (i + j + paramInt2 > this.databuf.length)
      {
        i = nextTwoPow(j + paramInt2);
        byte[] arrayOfByte1 = this.databuf;
        if (i > arrayOfByte1.length)
        {
          byte[] arrayOfByte2 = new byte[i];
          System.arraycopy(arrayOfByte1, this.skipped, arrayOfByte2, 0, this.available);
          this.databuf = arrayOfByte2;
        }
        else
        {
          System.arraycopy(arrayOfByte1, this.skipped, arrayOfByte1, 0, this.available);
        }
        this.skipped = 0;
      }
      System.arraycopy(paramArrayOfByte, paramInt1, this.databuf, this.skipped + this.available, paramInt2);
      this.available += paramInt2;
      return;
    }
    throw new IllegalStateException("Cannot add data to read-only buffer");
  }
  
  public int available()
  {
    return this.available;
  }
  
  public void copyTo(OutputStream paramOutputStream, int paramInt)
    throws IOException
  {
    if (paramInt <= this.available)
    {
      paramOutputStream.write(this.databuf, this.skipped, paramInt);
      return;
    }
    paramOutputStream = new StringBuilder();
    paramOutputStream.append("Cannot copy ");
    paramOutputStream.append(paramInt);
    paramOutputStream.append(" bytes, only got ");
    paramOutputStream.append(this.available);
    throw new IllegalStateException(paramOutputStream.toString());
  }
  
  public void read(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramArrayOfByte.length - paramInt1 >= paramInt2)
    {
      if (this.available - paramInt3 >= paramInt2)
      {
        System.arraycopy(this.databuf, this.skipped + paramInt3, paramArrayOfByte, paramInt1, paramInt2);
        return;
      }
      throw new IllegalStateException("Not enough data to read");
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Buffer size of ");
    localStringBuilder.append(paramArrayOfByte.length);
    localStringBuilder.append(" is too small for a read of ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(" bytes");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public ByteArrayInputStream readFrom(int paramInt)
  {
    int i = this.available;
    if (paramInt <= i)
    {
      int j = this.skipped;
      this.available = (i - paramInt);
      this.skipped = (j + paramInt);
      return new ByteArrayInputStream(this.databuf, j, paramInt);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Cannot read ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" bytes, only got ");
    localStringBuilder.append(this.available);
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public void removeData(int paramInt)
  {
    int i = this.available;
    if (paramInt <= i)
    {
      this.available = (i - paramInt);
      this.skipped += paramInt;
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Cannot remove ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" bytes, only got ");
    localStringBuilder.append(this.available);
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public void removeData(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    read(paramArrayOfByte, paramInt1, paramInt2, paramInt3);
    removeData(paramInt3 + paramInt2);
  }
  
  public byte[] removeData(int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = new byte[paramInt1];
    removeData(arrayOfByte, 0, paramInt1, paramInt2);
    return arrayOfByte;
  }
  
  public void shrink()
  {
    int i = this.available;
    if (i == 0) {}
    byte[] arrayOfByte2;
    for (this.databuf = TlsUtils.EMPTY_BYTES;; this.databuf = arrayOfByte2)
    {
      this.skipped = 0;
      return;
      i = nextTwoPow(i);
      byte[] arrayOfByte1 = this.databuf;
      if (i >= arrayOfByte1.length) {
        break;
      }
      arrayOfByte2 = new byte[i];
      System.arraycopy(arrayOfByte1, this.skipped, arrayOfByte2, 0, this.available);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\ByteQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */