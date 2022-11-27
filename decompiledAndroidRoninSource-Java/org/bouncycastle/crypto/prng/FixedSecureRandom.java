package org.bouncycastle.crypto.prng;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.SecureRandom;

public class FixedSecureRandom
  extends SecureRandom
{
  private byte[] _data;
  private int _index;
  private int _intPad;
  
  public FixedSecureRandom(boolean paramBoolean, byte[] paramArrayOfByte)
  {
    this(paramBoolean, new byte[][] { paramArrayOfByte });
  }
  
  public FixedSecureRandom(boolean paramBoolean, byte[][] paramArrayOfByte)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    int i = 0;
    for (;;)
    {
      if (i == paramArrayOfByte.length) {
        break label46;
      }
      try
      {
        localByteArrayOutputStream.write(paramArrayOfByte[i]);
        i += 1;
      }
      catch (IOException paramArrayOfByte)
      {
        for (;;) {}
      }
    }
    throw new IllegalArgumentException("can't save value array.");
    label46:
    paramArrayOfByte = localByteArrayOutputStream.toByteArray();
    this._data = paramArrayOfByte;
    if (paramBoolean) {
      this._intPad = (paramArrayOfByte.length % 4);
    }
  }
  
  public FixedSecureRandom(byte[] paramArrayOfByte)
  {
    this(false, new byte[][] { paramArrayOfByte });
  }
  
  public FixedSecureRandom(byte[][] paramArrayOfByte)
  {
    this(false, paramArrayOfByte);
  }
  
  private int nextValue()
  {
    byte[] arrayOfByte = this._data;
    int i = this._index;
    this._index = (i + 1);
    return arrayOfByte[i] & 0xFF;
  }
  
  public byte[] generateSeed(int paramInt)
  {
    byte[] arrayOfByte = new byte[paramInt];
    nextBytes(arrayOfByte);
    return arrayOfByte;
  }
  
  public boolean isExhausted()
  {
    return this._index == this._data.length;
  }
  
  public void nextBytes(byte[] paramArrayOfByte)
  {
    System.arraycopy(this._data, this._index, paramArrayOfByte, 0, paramArrayOfByte.length);
    this._index += paramArrayOfByte.length;
  }
  
  public int nextInt()
  {
    int i = nextValue() << 24 | 0x0 | nextValue() << 16;
    int j = this._intPad;
    if (j == 2) {
      this._intPad = (j - 1);
    } else {
      i |= nextValue() << 8;
    }
    j = this._intPad;
    if (j == 1)
    {
      this._intPad = (j - 1);
      return i;
    }
    return i | nextValue();
  }
  
  public long nextLong()
  {
    return nextValue() << 56 | 0L | nextValue() << 48 | nextValue() << 40 | nextValue() << 32 | nextValue() << 24 | nextValue() << 16 | nextValue() << 8 | nextValue();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\prng\FixedSecureRandom.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */