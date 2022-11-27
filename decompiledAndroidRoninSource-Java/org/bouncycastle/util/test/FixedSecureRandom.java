package org.bouncycastle.util.test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.Provider;
import java.security.SecureRandom;
import org.bouncycastle.util.Pack;
import org.bouncycastle.util.encoders.Hex;

public class FixedSecureRandom
  extends SecureRandom
{
  private static BigInteger ANDROID;
  private static BigInteger CLASSPATH;
  private static BigInteger REGULAR = new BigInteger("01020304ffffffff0506070811111111", 16);
  private static final boolean isAndroidStyle;
  private static final boolean isClasspathStyle;
  private static final boolean isRegularStyle;
  private byte[] _data;
  private int _index;
  
  static
  {
    ANDROID = new BigInteger("1111111105060708ffffffff01020304", 16);
    CLASSPATH = new BigInteger("3020104ffffffff05060708111111", 16);
    BigInteger localBigInteger1 = new BigInteger(128, new RandomChecker());
    BigInteger localBigInteger2 = new BigInteger(120, new RandomChecker());
    isAndroidStyle = localBigInteger1.equals(ANDROID);
    isRegularStyle = localBigInteger1.equals(REGULAR);
    isClasspathStyle = localBigInteger2.equals(CLASSPATH);
  }
  
  public FixedSecureRandom(byte[] paramArrayOfByte)
  {
    this(new Source[] { new Data(paramArrayOfByte) });
  }
  
  public FixedSecureRandom(Source[] paramArrayOfSource)
  {
    super(null, new DummyProvider());
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    boolean bool = isRegularStyle;
    int i = 0;
    j = 0;
    if (bool) {
      if (isClasspathStyle) {
        i = j;
      }
    }
    for (;;)
    {
      if (i == paramArrayOfSource.length) {
        break label365;
      }
      try
      {
        if ((paramArrayOfSource[i] instanceof BigInteger))
        {
          arrayOfByte = paramArrayOfSource[i].data;
          k = arrayOfByte.length - arrayOfByte.length % 4;
          j = arrayOfByte.length - k - 1;
          while (j >= 0)
          {
            localByteArrayOutputStream.write(arrayOfByte[j]);
            j -= 1;
          }
          j = arrayOfByte.length - k;
          while (j < arrayOfByte.length)
          {
            localByteArrayOutputStream.write(arrayOfByte, j, 4);
            j += 4;
          }
        }
        localByteArrayOutputStream.write(paramArrayOfSource[i].data);
        i += 1;
      }
      catch (IOException paramArrayOfSource)
      {
        byte[] arrayOfByte;
        int k;
        for (;;) {}
      }
    }
    throw new IllegalArgumentException("can't save value source.");
    for (;;)
    {
      if (i == paramArrayOfSource.length) {
        break label365;
      }
      try
      {
        localByteArrayOutputStream.write(paramArrayOfSource[i].data);
        i += 1;
      }
      catch (IOException paramArrayOfSource)
      {
        label365:
        for (;;) {}
      }
    }
    throw new IllegalArgumentException("can't save value source.");
    if (isAndroidStyle)
    {
      i = 0;
      while (i != paramArrayOfSource.length)
      {
        for (;;)
        {
          try
          {
            if (!(paramArrayOfSource[i] instanceof BigInteger)) {
              continue;
            }
            arrayOfByte = paramArrayOfSource[i].data;
            k = arrayOfByte.length - arrayOfByte.length % 4;
            j = 0;
            if (j < k)
            {
              int m = arrayOfByte.length;
              j += 4;
              localByteArrayOutputStream.write(arrayOfByte, m - j, 4);
              continue;
            }
            if (arrayOfByte.length - k == 0) {
              continue;
            }
            j = 0;
            if (j == 4 - (arrayOfByte.length - k)) {
              continue;
            }
            localByteArrayOutputStream.write(0);
            j += 1;
            continue;
          }
          catch (IOException paramArrayOfSource)
          {
            continue;
            j = 0;
            continue;
          }
          if (j == arrayOfByte.length - k) {
            continue;
          }
          localByteArrayOutputStream.write(arrayOfByte[(k + j)]);
          j += 1;
        }
        localByteArrayOutputStream.write(paramArrayOfSource[i].data);
        i += 1;
        continue;
        throw new IllegalArgumentException("can't save value source.");
      }
      this._data = localByteArrayOutputStream.toByteArray();
      return;
    }
    throw new IllegalStateException("Unrecognized BigInteger implementation");
  }
  
  public FixedSecureRandom(byte[][] paramArrayOfByte)
  {
    this(buildDataArray(paramArrayOfByte));
  }
  
  private static Data[] buildDataArray(byte[][] paramArrayOfByte)
  {
    Data[] arrayOfData = new Data[paramArrayOfByte.length];
    int i = 0;
    while (i != paramArrayOfByte.length)
    {
      arrayOfData[i] = new Data(paramArrayOfByte[i]);
      i += 1;
    }
    return arrayOfData;
  }
  
  private static byte[] expandToBitLength(int paramInt, byte[] paramArrayOfByte)
  {
    int i = (paramInt + 7) / 8;
    if (i > paramArrayOfByte.length)
    {
      byte[] arrayOfByte = new byte[i];
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte, i - paramArrayOfByte.length, paramArrayOfByte.length);
      if (isAndroidStyle)
      {
        paramInt %= 8;
        if (paramInt != 0) {
          Pack.intToBigEndian(Pack.bigEndianToInt(arrayOfByte, 0) << 8 - paramInt, arrayOfByte, 0);
        }
      }
      return arrayOfByte;
    }
    if ((isAndroidStyle) && (paramInt < paramArrayOfByte.length * 8))
    {
      paramInt %= 8;
      if (paramInt != 0) {
        Pack.intToBigEndian(Pack.bigEndianToInt(paramArrayOfByte, 0) << 8 - paramInt, paramArrayOfByte, 0);
      }
    }
    return paramArrayOfByte;
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
    return nextValue() << 24 | 0x0 | nextValue() << 16 | nextValue() << 8 | nextValue();
  }
  
  public long nextLong()
  {
    return nextValue() << 56 | 0L | nextValue() << 48 | nextValue() << 40 | nextValue() << 32 | nextValue() << 24 | nextValue() << 16 | nextValue() << 8 | nextValue();
  }
  
  public static class BigInteger
    extends FixedSecureRandom.Source
  {
    public BigInteger(int paramInt, String paramString)
    {
      super();
    }
    
    public BigInteger(int paramInt, byte[] paramArrayOfByte)
    {
      super();
    }
    
    public BigInteger(String paramString)
    {
      this(Hex.decode(paramString));
    }
    
    public BigInteger(byte[] paramArrayOfByte)
    {
      super();
    }
  }
  
  public static class Data
    extends FixedSecureRandom.Source
  {
    public Data(byte[] paramArrayOfByte)
    {
      super();
    }
  }
  
  private static class DummyProvider
    extends Provider
  {
    DummyProvider()
    {
      super(1.0D, "BCFIPS Fixed Secure Random Provider");
    }
  }
  
  private static class RandomChecker
    extends SecureRandom
  {
    byte[] data = Hex.decode("01020304ffffffff0506070811111111");
    int index = 0;
    
    RandomChecker()
    {
      super(new FixedSecureRandom.DummyProvider());
    }
    
    public void nextBytes(byte[] paramArrayOfByte)
    {
      System.arraycopy(this.data, this.index, paramArrayOfByte, 0, paramArrayOfByte.length);
      this.index += paramArrayOfByte.length;
    }
  }
  
  public static class Source
  {
    byte[] data;
    
    Source(byte[] paramArrayOfByte)
    {
      this.data = paramArrayOfByte;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastl\\util\test\FixedSecureRandom.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */