package org.bouncycastle.crypto.digests;

import org.bouncycastle.crypto.ExtendedDigest;
import org.bouncycastle.util.Memoable;
import org.bouncycastle.util.Pack;

public abstract class GeneralDigest
  implements ExtendedDigest, Memoable
{
  private static final int BYTE_LENGTH = 64;
  private long byteCount;
  private final byte[] xBuf;
  private int xBufOff;
  
  protected GeneralDigest()
  {
    this.xBuf = new byte[4];
    this.xBufOff = 0;
  }
  
  protected GeneralDigest(GeneralDigest paramGeneralDigest)
  {
    this.xBuf = new byte[4];
    copyIn(paramGeneralDigest);
  }
  
  protected GeneralDigest(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = new byte[4];
    this.xBuf = arrayOfByte;
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, arrayOfByte.length);
    this.xBufOff = Pack.bigEndianToInt(paramArrayOfByte, 4);
    this.byteCount = Pack.bigEndianToLong(paramArrayOfByte, 8);
  }
  
  protected void copyIn(GeneralDigest paramGeneralDigest)
  {
    byte[] arrayOfByte = paramGeneralDigest.xBuf;
    System.arraycopy(arrayOfByte, 0, this.xBuf, 0, arrayOfByte.length);
    this.xBufOff = paramGeneralDigest.xBufOff;
    this.byteCount = paramGeneralDigest.byteCount;
  }
  
  public void finish()
  {
    long l = this.byteCount;
    for (byte b = Byte.MIN_VALUE;; b = 0)
    {
      update(b);
      if (this.xBufOff == 0) {
        break;
      }
    }
    processLength(l << 3);
    processBlock();
  }
  
  public int getByteLength()
  {
    return 64;
  }
  
  protected void populateState(byte[] paramArrayOfByte)
  {
    System.arraycopy(this.xBuf, 0, paramArrayOfByte, 0, this.xBufOff);
    Pack.intToBigEndian(this.xBufOff, paramArrayOfByte, 4);
    Pack.longToBigEndian(this.byteCount, paramArrayOfByte, 8);
  }
  
  protected abstract void processBlock();
  
  protected abstract void processLength(long paramLong);
  
  protected abstract void processWord(byte[] paramArrayOfByte, int paramInt);
  
  public void reset()
  {
    this.byteCount = 0L;
    this.xBufOff = 0;
    int i = 0;
    for (;;)
    {
      byte[] arrayOfByte = this.xBuf;
      if (i >= arrayOfByte.length) {
        break;
      }
      arrayOfByte[i] = 0;
      i += 1;
    }
  }
  
  public void update(byte paramByte)
  {
    byte[] arrayOfByte = this.xBuf;
    int i = this.xBufOff;
    int j = i + 1;
    this.xBufOff = j;
    arrayOfByte[i] = paramByte;
    if (j == arrayOfByte.length)
    {
      processWord(arrayOfByte, 0);
      this.xBufOff = 0;
    }
    this.byteCount += 1L;
  }
  
  public void update(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = 0;
    int k = Math.max(0, paramInt2);
    paramInt2 = i;
    byte[] arrayOfByte;
    int j;
    if (this.xBufOff != 0) {
      for (paramInt2 = 0; paramInt2 < k; paramInt2 = i)
      {
        arrayOfByte = this.xBuf;
        j = this.xBufOff;
        int m = j + 1;
        this.xBufOff = m;
        i = paramInt2 + 1;
        arrayOfByte[j] = paramArrayOfByte[(paramInt2 + paramInt1)];
        if (m == 4)
        {
          processWord(arrayOfByte, 0);
          this.xBufOff = 0;
          paramInt2 = i;
          break;
        }
      }
    }
    for (i = paramInt2;; i = j + 4)
    {
      j = i;
      i = j;
      if (j >= (k - paramInt2 & 0xFFFFFFFC) + paramInt2) {
        break;
      }
      processWord(paramArrayOfByte, paramInt1 + j);
    }
    while (i < k)
    {
      arrayOfByte = this.xBuf;
      paramInt2 = this.xBufOff;
      this.xBufOff = (paramInt2 + 1);
      arrayOfByte[paramInt2] = paramArrayOfByte[(i + paramInt1)];
      i += 1;
    }
    this.byteCount += k;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\digests\GeneralDigest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */