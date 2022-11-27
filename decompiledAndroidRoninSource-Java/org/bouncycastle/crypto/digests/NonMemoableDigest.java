package org.bouncycastle.crypto.digests;

import org.bouncycastle.crypto.ExtendedDigest;

public class NonMemoableDigest
  implements ExtendedDigest
{
  private ExtendedDigest baseDigest;
  
  public NonMemoableDigest(ExtendedDigest paramExtendedDigest)
  {
    if (paramExtendedDigest != null)
    {
      this.baseDigest = paramExtendedDigest;
      return;
    }
    throw new IllegalArgumentException("baseDigest must not be null");
  }
  
  public int doFinal(byte[] paramArrayOfByte, int paramInt)
  {
    return this.baseDigest.doFinal(paramArrayOfByte, paramInt);
  }
  
  public String getAlgorithmName()
  {
    return this.baseDigest.getAlgorithmName();
  }
  
  public int getByteLength()
  {
    return this.baseDigest.getByteLength();
  }
  
  public int getDigestSize()
  {
    return this.baseDigest.getDigestSize();
  }
  
  public void reset()
  {
    this.baseDigest.reset();
  }
  
  public void update(byte paramByte)
  {
    this.baseDigest.update(paramByte);
  }
  
  public void update(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.baseDigest.update(paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\digests\NonMemoableDigest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */