package org.bouncycastle.crypto.modes;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.SkippingStreamCipher;
import org.bouncycastle.crypto.StreamBlockCipher;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Pack;

public class SICBlockCipher
  extends StreamBlockCipher
  implements SkippingStreamCipher
{
  private byte[] IV;
  private final int blockSize;
  private int byteCount;
  private final BlockCipher cipher;
  private byte[] counter;
  private byte[] counterOut;
  
  public SICBlockCipher(BlockCipher paramBlockCipher)
  {
    super(paramBlockCipher);
    this.cipher = paramBlockCipher;
    int i = paramBlockCipher.getBlockSize();
    this.blockSize = i;
    this.IV = new byte[i];
    this.counter = new byte[i];
    this.counterOut = new byte[i];
    this.byteCount = 0;
  }
  
  private void adjustCounter(long paramLong)
  {
    int i = 5;
    long l5 = 0L;
    long l3;
    long l1;
    long l2;
    if (paramLong >= 0L)
    {
      l3 = (this.byteCount + paramLong) / this.blockSize;
      l1 = l3;
      l2 = l1;
      if (l3 > 255L) {
        for (;;)
        {
          l2 = l1;
          if (i < 1) {
            break;
          }
          l2 = 1L << i * 8;
          while (l1 >= l2)
          {
            incrementCounterAt(i);
            l1 -= l2;
          }
          i -= 1;
        }
      }
      incrementCounter((int)l2);
    }
    for (i = (int)(paramLong + this.byteCount - this.blockSize * l3);; i = this.blockSize + i)
    {
      this.byteCount = i;
      return;
      long l4 = (-paramLong - this.byteCount) / this.blockSize;
      l1 = l4;
      l2 = l1;
      l3 = l5;
      if (l4 > 255L) {
        for (;;)
        {
          l2 = l1;
          l3 = l5;
          if (i < 1) {
            break;
          }
          l2 = 1L << i * 8;
          while (l1 > l2)
          {
            decrementCounterAt(i);
            l1 -= l2;
          }
          i -= 1;
        }
      }
      while (l3 != l2)
      {
        decrementCounterAt(0);
        l3 += 1L;
      }
      i = (int)(this.byteCount + paramLong + this.blockSize * l4);
      if (i >= 0)
      {
        this.byteCount = 0;
        return;
      }
      decrementCounterAt(0);
    }
  }
  
  private void checkCounter()
  {
    if (this.IV.length < this.blockSize)
    {
      int i = 0;
      for (;;)
      {
        byte[] arrayOfByte = this.IV;
        if (i == arrayOfByte.length) {
          return;
        }
        if (this.counter[i] != arrayOfByte[i]) {
          break;
        }
        i += 1;
      }
      throw new IllegalStateException("Counter in CTR/SIC mode out of range.");
    }
  }
  
  private void decrementCounterAt(int paramInt)
  {
    paramInt = this.counter.length - paramInt;
    int i;
    do
    {
      paramInt -= 1;
      if (paramInt < 0) {
        break;
      }
      byte[] arrayOfByte = this.counter;
      i = (byte)(arrayOfByte[paramInt] - 1);
      arrayOfByte[paramInt] = i;
    } while (i == -1);
  }
  
  private void incrementCounter(int paramInt)
  {
    byte[] arrayOfByte = this.counter;
    int i = arrayOfByte[(arrayOfByte.length - 1)];
    int j = arrayOfByte.length - 1;
    arrayOfByte[j] = ((byte)(arrayOfByte[j] + paramInt));
    if ((i != 0) && (arrayOfByte[(arrayOfByte.length - 1)] < i)) {
      incrementCounterAt(1);
    }
  }
  
  private void incrementCounterAt(int paramInt)
  {
    paramInt = this.counter.length - paramInt;
    int i;
    do
    {
      paramInt -= 1;
      if (paramInt < 0) {
        break;
      }
      byte[] arrayOfByte = this.counter;
      i = (byte)(arrayOfByte[paramInt] + 1);
      arrayOfByte[paramInt] = i;
    } while (i == 0);
  }
  
  protected byte calculateByte(byte paramByte)
    throws DataLengthException, IllegalStateException
  {
    int i = this.byteCount;
    if (i == 0)
    {
      this.cipher.processBlock(this.counter, 0, this.counterOut, 0);
      arrayOfByte = this.counterOut;
      i = this.byteCount;
      this.byteCount = (i + 1);
      return (byte)(paramByte ^ arrayOfByte[i]);
    }
    byte[] arrayOfByte = this.counterOut;
    int j = i + 1;
    this.byteCount = j;
    byte b = (byte)(paramByte ^ arrayOfByte[i]);
    if (j == this.counter.length)
    {
      this.byteCount = 0;
      incrementCounterAt(0);
      checkCounter();
    }
    return b;
  }
  
  public String getAlgorithmName()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.cipher.getAlgorithmName());
    localStringBuilder.append("/SIC");
    return localStringBuilder.toString();
  }
  
  public int getBlockSize()
  {
    return this.cipher.getBlockSize();
  }
  
  public long getPosition()
  {
    byte[] arrayOfByte2 = this.counter;
    int m = arrayOfByte2.length;
    byte[] arrayOfByte1 = new byte[m];
    System.arraycopy(arrayOfByte2, 0, arrayOfByte1, 0, m);
    int j = m - 1;
    while (j >= 1)
    {
      arrayOfByte2 = this.IV;
      int i;
      if (j < arrayOfByte2.length) {
        i = (arrayOfByte1[j] & 0xFF) - (arrayOfByte2[j] & 0xFF);
      } else {
        i = arrayOfByte1[j] & 0xFF;
      }
      int k = i;
      if (i < 0)
      {
        k = j - 1;
        arrayOfByte1[k] = ((byte)(arrayOfByte1[k] - 1));
        k = i + 256;
      }
      arrayOfByte1[j] = ((byte)k);
      j -= 1;
    }
    return Pack.bigEndianToLong(arrayOfByte1, m - 8) * this.blockSize + this.byteCount;
  }
  
  public void init(boolean paramBoolean, CipherParameters paramCipherParameters)
    throws IllegalArgumentException
  {
    if ((paramCipherParameters instanceof ParametersWithIV))
    {
      paramCipherParameters = (ParametersWithIV)paramCipherParameters;
      byte[] arrayOfByte = Arrays.clone(paramCipherParameters.getIV());
      this.IV = arrayOfByte;
      int j = this.blockSize;
      if (j >= arrayOfByte.length)
      {
        int k = j / 2;
        int i = 8;
        if (8 > k) {
          i = j / 2;
        }
        if (this.blockSize - this.IV.length <= i)
        {
          if (paramCipherParameters.getParameters() != null) {
            this.cipher.init(true, paramCipherParameters.getParameters());
          }
          reset();
          return;
        }
        paramCipherParameters = new StringBuilder();
        paramCipherParameters.append("CTR/SIC mode requires IV of at least: ");
        paramCipherParameters.append(this.blockSize - i);
        paramCipherParameters.append(" bytes.");
        throw new IllegalArgumentException(paramCipherParameters.toString());
      }
      paramCipherParameters = new StringBuilder();
      paramCipherParameters.append("CTR/SIC mode requires IV no greater than: ");
      paramCipherParameters.append(this.blockSize);
      paramCipherParameters.append(" bytes.");
      throw new IllegalArgumentException(paramCipherParameters.toString());
    }
    throw new IllegalArgumentException("CTR/SIC mode requires ParametersWithIV");
  }
  
  public int processBlock(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
    throws DataLengthException, IllegalStateException
  {
    processBytes(paramArrayOfByte1, paramInt1, this.blockSize, paramArrayOfByte2, paramInt2);
    return this.blockSize;
  }
  
  public void reset()
  {
    Arrays.fill(this.counter, (byte)0);
    byte[] arrayOfByte = this.IV;
    System.arraycopy(arrayOfByte, 0, this.counter, 0, arrayOfByte.length);
    this.cipher.reset();
    this.byteCount = 0;
  }
  
  public long seekTo(long paramLong)
  {
    reset();
    return skip(paramLong);
  }
  
  public long skip(long paramLong)
  {
    adjustCounter(paramLong);
    checkCounter();
    this.cipher.processBlock(this.counter, 0, this.counterOut, 0);
    return paramLong;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\modes\SICBlockCipher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */