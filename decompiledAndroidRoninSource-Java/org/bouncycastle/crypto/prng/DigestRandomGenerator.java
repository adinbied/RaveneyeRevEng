package org.bouncycastle.crypto.prng;

import org.bouncycastle.crypto.Digest;

public class DigestRandomGenerator
  implements RandomGenerator
{
  private static long CYCLE_COUNT = 10L;
  private Digest digest;
  private byte[] seed;
  private long seedCounter;
  private byte[] state;
  private long stateCounter;
  
  public DigestRandomGenerator(Digest paramDigest)
  {
    this.digest = paramDigest;
    this.seed = new byte[paramDigest.getDigestSize()];
    this.seedCounter = 1L;
    this.state = new byte[paramDigest.getDigestSize()];
    this.stateCounter = 1L;
  }
  
  private void cycleSeed()
  {
    digestUpdate(this.seed);
    long l = this.seedCounter;
    this.seedCounter = (1L + l);
    digestAddCounter(l);
    digestDoFinal(this.seed);
  }
  
  private void digestAddCounter(long paramLong)
  {
    int i = 0;
    while (i != 8)
    {
      this.digest.update((byte)(int)paramLong);
      paramLong >>>= 8;
      i += 1;
    }
  }
  
  private void digestDoFinal(byte[] paramArrayOfByte)
  {
    this.digest.doFinal(paramArrayOfByte, 0);
  }
  
  private void digestUpdate(byte[] paramArrayOfByte)
  {
    this.digest.update(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  private void generateState()
  {
    long l = this.stateCounter;
    this.stateCounter = (1L + l);
    digestAddCounter(l);
    digestUpdate(this.state);
    digestUpdate(this.seed);
    digestDoFinal(this.state);
    if (this.stateCounter % CYCLE_COUNT == 0L) {
      cycleSeed();
    }
  }
  
  public void addSeedMaterial(long paramLong)
  {
    try
    {
      digestAddCounter(paramLong);
      digestUpdate(this.seed);
      digestDoFinal(this.seed);
      return;
    }
    finally {}
  }
  
  public void addSeedMaterial(byte[] paramArrayOfByte)
  {
    try
    {
      digestUpdate(paramArrayOfByte);
      digestUpdate(this.seed);
      digestDoFinal(this.seed);
      return;
    }
    finally {}
  }
  
  public void nextBytes(byte[] paramArrayOfByte)
  {
    nextBytes(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public void nextBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      generateState();
      int i = 0;
      int k;
      for (int j = paramInt1;; j = k)
      {
        k = j;
        if (k == paramInt2 + paramInt1) {
          break;
        }
        j = i;
        if (i == this.state.length)
        {
          generateState();
          j = 0;
        }
        paramArrayOfByte[k] = this.state[j];
        k += 1;
        i = j + 1;
      }
      return;
    }
    finally {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\prng\DigestRandomGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */