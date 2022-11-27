package org.bouncycastle.crypto.digests;

import org.bouncycastle.crypto.ExtendedDigest;

public class ShortenedDigest
  implements ExtendedDigest
{
  private ExtendedDigest baseDigest;
  private int length;
  
  public ShortenedDigest(ExtendedDigest paramExtendedDigest, int paramInt)
  {
    if (paramExtendedDigest != null)
    {
      if (paramInt <= paramExtendedDigest.getDigestSize())
      {
        this.baseDigest = paramExtendedDigest;
        this.length = paramInt;
        return;
      }
      throw new IllegalArgumentException("baseDigest output not large enough to support length");
    }
    throw new IllegalArgumentException("baseDigest must not be null");
  }
  
  public int doFinal(byte[] paramArrayOfByte, int paramInt)
  {
    byte[] arrayOfByte = new byte[this.baseDigest.getDigestSize()];
    this.baseDigest.doFinal(arrayOfByte, 0);
    System.arraycopy(arrayOfByte, 0, paramArrayOfByte, paramInt, this.length);
    return this.length;
  }
  
  public String getAlgorithmName()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.baseDigest.getAlgorithmName());
    localStringBuilder.append("(");
    localStringBuilder.append(this.length * 8);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public int getByteLength()
  {
    return this.baseDigest.getByteLength();
  }
  
  public int getDigestSize()
  {
    return this.length;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\digests\ShortenedDigest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */