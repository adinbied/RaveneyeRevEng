package org.bouncycastle.crypto.prng;

public class ThreadedSeedGenerator
{
  public byte[] generateSeed(int paramInt, boolean paramBoolean)
  {
    return new SeedGenerator(null).generateSeed(paramInt, paramBoolean);
  }
  
  private class SeedGenerator
    implements Runnable
  {
    private volatile int counter = 0;
    private volatile boolean stop = false;
    
    private SeedGenerator() {}
    
    public byte[] generateSeed(int paramInt, boolean paramBoolean)
    {
      Thread localThread = new Thread(this);
      byte[] arrayOfByte = new byte[paramInt];
      int i = 0;
      this.counter = 0;
      this.stop = false;
      localThread.start();
      if (!paramBoolean) {
        paramInt *= 8;
      }
      int j = 0;
      while (i < paramInt)
      {
        while (this.counter == j) {
          try
          {
            Thread.sleep(1L);
          }
          catch (InterruptedException localInterruptedException)
          {
            int k;
            for (;;) {}
          }
        }
        j = this.counter;
        if (paramBoolean)
        {
          arrayOfByte[i] = ((byte)(j & 0xFF));
        }
        else
        {
          k = i / 8;
          arrayOfByte[k] = ((byte)(arrayOfByte[k] << 1 | j & 0x1));
        }
        i += 1;
      }
      this.stop = true;
      return arrayOfByte;
    }
    
    public void run()
    {
      while (!this.stop) {
        this.counter += 1;
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\prng\ThreadedSeedGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */