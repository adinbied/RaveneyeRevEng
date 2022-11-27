package org.bouncycastle.crypto.prng;

import org.bouncycastle.crypto.BlockCipher;

public class X931RNG
{
  private static final int BLOCK128_MAX_BITS_REQUEST = 262144;
  private static final long BLOCK128_RESEED_MAX = 8388608L;
  private static final int BLOCK64_MAX_BITS_REQUEST = 4096;
  private static final long BLOCK64_RESEED_MAX = 32768L;
  private final byte[] DT;
  private final byte[] I;
  private final byte[] R;
  private byte[] V;
  private final BlockCipher engine;
  private final EntropySource entropySource;
  private long reseedCounter = 1L;
  
  public X931RNG(BlockCipher paramBlockCipher, byte[] paramArrayOfByte, EntropySource paramEntropySource)
  {
    this.engine = paramBlockCipher;
    this.entropySource = paramEntropySource;
    paramEntropySource = new byte[paramBlockCipher.getBlockSize()];
    this.DT = paramEntropySource;
    System.arraycopy(paramArrayOfByte, 0, paramEntropySource, 0, paramEntropySource.length);
    this.I = new byte[paramBlockCipher.getBlockSize()];
    this.R = new byte[paramBlockCipher.getBlockSize()];
  }
  
  private void increment(byte[] paramArrayOfByte)
  {
    int j = paramArrayOfByte.length - 1;
    while (j >= 0)
    {
      int i = (byte)(paramArrayOfByte[j] + 1);
      paramArrayOfByte[j] = i;
      if (i != 0) {
        return;
      }
      j -= 1;
    }
  }
  
  private static boolean isTooLarge(byte[] paramArrayOfByte, int paramInt)
  {
    return (paramArrayOfByte != null) && (paramArrayOfByte.length > paramInt);
  }
  
  private void process(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    int i = 0;
    while (i != paramArrayOfByte1.length)
    {
      paramArrayOfByte1[i] = ((byte)(paramArrayOfByte2[i] ^ paramArrayOfByte3[i]));
      i += 1;
    }
    this.engine.processBlock(paramArrayOfByte1, 0, paramArrayOfByte1, 0);
  }
  
  int generate(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    if (this.R.length == 8)
    {
      if (this.reseedCounter > 32768L) {
        return -1;
      }
      if (isTooLarge(paramArrayOfByte, 512)) {
        throw new IllegalArgumentException("Number of bits per request limited to 4096");
      }
    }
    else
    {
      if (this.reseedCounter > 8388608L) {
        return -1;
      }
      if (isTooLarge(paramArrayOfByte, 32768)) {
        break label336;
      }
    }
    byte[] arrayOfByte;
    if ((paramBoolean) || (this.V == null))
    {
      arrayOfByte = this.entropySource.getEntropy();
      this.V = arrayOfByte;
      if (arrayOfByte.length != this.engine.getBlockSize()) {}
    }
    else
    {
      int j = paramArrayOfByte.length / this.R.length;
      int i = 0;
      while (i < j)
      {
        this.engine.processBlock(this.DT, 0, this.I, 0);
        process(this.R, this.I, this.V);
        process(this.V, this.R, this.I);
        arrayOfByte = this.R;
        System.arraycopy(arrayOfByte, 0, paramArrayOfByte, arrayOfByte.length * i, arrayOfByte.length);
        increment(this.DT);
        i += 1;
      }
      i = paramArrayOfByte.length - this.R.length * j;
      if (i > 0)
      {
        this.engine.processBlock(this.DT, 0, this.I, 0);
        process(this.R, this.I, this.V);
        process(this.V, this.R, this.I);
        arrayOfByte = this.R;
        System.arraycopy(arrayOfByte, 0, paramArrayOfByte, j * arrayOfByte.length, i);
        increment(this.DT);
      }
      this.reseedCounter += 1L;
      return paramArrayOfByte.length;
    }
    throw new IllegalStateException("Insufficient entropy returned");
    label336:
    throw new IllegalArgumentException("Number of bits per request limited to 262144");
  }
  
  EntropySource getEntropySource()
  {
    return this.entropySource;
  }
  
  void reseed()
  {
    byte[] arrayOfByte = this.entropySource.getEntropy();
    this.V = arrayOfByte;
    if (arrayOfByte.length == this.engine.getBlockSize())
    {
      this.reseedCounter = 1L;
      return;
    }
    throw new IllegalStateException("Insufficient entropy returned");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\prng\X931RNG.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */