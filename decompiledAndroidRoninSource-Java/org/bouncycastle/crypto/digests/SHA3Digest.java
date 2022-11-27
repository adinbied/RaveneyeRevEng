package org.bouncycastle.crypto.digests;

public class SHA3Digest
  extends KeccakDigest
{
  public SHA3Digest()
  {
    this(256);
  }
  
  public SHA3Digest(int paramInt)
  {
    super(checkBitLength(paramInt));
  }
  
  public SHA3Digest(SHA3Digest paramSHA3Digest)
  {
    super(paramSHA3Digest);
  }
  
  private static int checkBitLength(int paramInt)
  {
    if ((paramInt != 224) && (paramInt != 256) && (paramInt != 384))
    {
      if (paramInt == 512) {
        return paramInt;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("'bitLength' ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" not supported for SHA-3");
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return paramInt;
  }
  
  public int doFinal(byte[] paramArrayOfByte, int paramInt)
  {
    absorb(new byte[] { 2 }, 0, 2L);
    return super.doFinal(paramArrayOfByte, paramInt);
  }
  
  protected int doFinal(byte[] paramArrayOfByte, int paramInt1, byte paramByte, int paramInt2)
  {
    if ((paramInt2 >= 0) && (paramInt2 <= 7))
    {
      int i = paramByte & (1 << paramInt2) - 1 | 2 << paramInt2;
      byte b = paramInt2 + 2;
      paramInt2 = i;
      paramByte = b;
      if (b >= 8)
      {
        this.oneByte[0] = ((byte)i);
        absorb(this.oneByte, 0, 8L);
        paramByte = b - 8;
        paramInt2 = i >>> 8;
      }
      return super.doFinal(paramArrayOfByte, paramInt1, (byte)paramInt2, paramByte);
    }
    throw new IllegalArgumentException("'partialBits' must be in the range [0,7]");
  }
  
  public String getAlgorithmName()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SHA3-");
    localStringBuilder.append(this.fixedOutputLength);
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\digests\SHA3Digest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */