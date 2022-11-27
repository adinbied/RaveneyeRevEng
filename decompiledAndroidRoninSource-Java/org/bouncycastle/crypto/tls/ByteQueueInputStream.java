package org.bouncycastle.crypto.tls;

import java.io.InputStream;

public class ByteQueueInputStream
  extends InputStream
{
  private ByteQueue buffer = new ByteQueue();
  
  public void addBytes(byte[] paramArrayOfByte)
  {
    this.buffer.addData(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public int available()
  {
    return this.buffer.available();
  }
  
  public void close() {}
  
  public int peek(byte[] paramArrayOfByte)
  {
    int i = Math.min(this.buffer.available(), paramArrayOfByte.length);
    this.buffer.read(paramArrayOfByte, 0, i, 0);
    return i;
  }
  
  public int read()
  {
    if (this.buffer.available() == 0) {
      return -1;
    }
    return this.buffer.removeData(1, 0)[0] & 0xFF;
  }
  
  public int read(byte[] paramArrayOfByte)
  {
    return read(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramInt2 = Math.min(this.buffer.available(), paramInt2);
    this.buffer.removeData(paramArrayOfByte, paramInt1, paramInt2, 0);
    return paramInt2;
  }
  
  public long skip(long paramLong)
  {
    int i = Math.min((int)paramLong, this.buffer.available());
    this.buffer.removeData(i);
    return i;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\ByteQueueInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */