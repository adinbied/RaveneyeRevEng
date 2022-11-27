package org.bouncycastle.crypto.prng;

public class ReversedWindowGenerator
  implements RandomGenerator
{
  private final RandomGenerator generator;
  private byte[] window;
  private int windowCount;
  
  public ReversedWindowGenerator(RandomGenerator paramRandomGenerator, int paramInt)
  {
    if (paramRandomGenerator != null)
    {
      if (paramInt >= 2)
      {
        this.generator = paramRandomGenerator;
        this.window = new byte[paramInt];
        return;
      }
      throw new IllegalArgumentException("windowSize must be at least 2");
    }
    throw new IllegalArgumentException("generator cannot be null");
  }
  
  private void doNextBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = 0;
    for (;;)
    {
      if (i < paramInt2) {}
      try
      {
        if (this.windowCount < 1)
        {
          this.generator.nextBytes(this.window, 0, this.window.length);
          this.windowCount = this.window.length;
        }
        byte[] arrayOfByte = this.window;
        int j = this.windowCount - 1;
        this.windowCount = j;
        paramArrayOfByte[(i + paramInt1)] = arrayOfByte[j];
        i += 1;
      }
      finally {}
    }
  }
  
  public void addSeedMaterial(long paramLong)
  {
    try
    {
      this.windowCount = 0;
      this.generator.addSeedMaterial(paramLong);
      return;
    }
    finally {}
  }
  
  public void addSeedMaterial(byte[] paramArrayOfByte)
  {
    try
    {
      this.windowCount = 0;
      this.generator.addSeedMaterial(paramArrayOfByte);
      return;
    }
    finally {}
  }
  
  public void nextBytes(byte[] paramArrayOfByte)
  {
    doNextBytes(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public void nextBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    doNextBytes(paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\prng\ReversedWindowGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */