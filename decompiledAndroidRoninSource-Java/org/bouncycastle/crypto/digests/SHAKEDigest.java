package org.bouncycastle.crypto.digests;

import org.bouncycastle.crypto.Xof;

public class SHAKEDigest
  extends KeccakDigest
  implements Xof
{
  public SHAKEDigest()
  {
    this(128);
  }
  
  public SHAKEDigest(int paramInt)
  {
    super(checkBitLength(paramInt));
  }
  
  public SHAKEDigest(SHAKEDigest paramSHAKEDigest)
  {
    super(paramSHAKEDigest);
  }
  
  private static int checkBitLength(int paramInt)
  {
    if (paramInt != 128)
    {
      if (paramInt == 256) {
        return paramInt;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("'bitLength' ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" not supported for SHAKE");
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return paramInt;
  }
  
  public int doFinal(byte[] paramArrayOfByte, int paramInt)
  {
    return doFinal(paramArrayOfByte, paramInt, getDigestSize());
  }
  
  protected int doFinal(byte[] paramArrayOfByte, int paramInt1, byte paramByte, int paramInt2)
  {
    return doFinal(paramArrayOfByte, paramInt1, getDigestSize(), paramByte, paramInt2);
  }
  
  public int doFinal(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramInt1 = doOutput(paramArrayOfByte, paramInt1, paramInt2);
    reset();
    return paramInt1;
  }
  
  protected int doFinal(byte[] paramArrayOfByte, int paramInt1, int paramInt2, byte paramByte, int paramInt3)
  {
    if ((paramInt3 >= 0) && (paramInt3 <= 7))
    {
      int i = paramByte & (1 << paramInt3) - 1 | 15 << paramInt3;
      byte b = paramInt3 + 4;
      paramInt3 = i;
      paramByte = b;
      if (b >= 8)
      {
        this.oneByte[0] = ((byte)i);
        absorb(this.oneByte, 0, 8L);
        paramByte = b - 8;
        paramInt3 = i >>> 8;
      }
      if (paramByte > 0)
      {
        this.oneByte[0] = ((byte)paramInt3);
        absorb(this.oneByte, 0, paramByte);
      }
      squeeze(paramArrayOfByte, paramInt1, paramInt2 * 8L);
      reset();
      return paramInt2;
    }
    throw new IllegalArgumentException("'partialBits' must be in the range [0,7]");
  }
  
  public int doOutput(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (!this.squeezing) {
      absorb(new byte[] { 15 }, 0, 4L);
    }
    squeeze(paramArrayOfByte, paramInt1, paramInt2 * 8L);
    return paramInt2;
  }
  
  public String getAlgorithmName()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SHAKE");
    localStringBuilder.append(this.fixedOutputLength);
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\digests\SHAKEDigest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */