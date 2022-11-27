package org.bouncycastle.crypto.digests;

import org.bouncycastle.util.Memoable;

public final class GOST3411_2012_256Digest
  extends GOST3411_2012Digest
{
  private static final byte[] IV = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
  
  public GOST3411_2012_256Digest()
  {
    super(IV);
  }
  
  public GOST3411_2012_256Digest(GOST3411_2012_256Digest paramGOST3411_2012_256Digest)
  {
    super(IV);
    reset(paramGOST3411_2012_256Digest);
  }
  
  public Memoable copy()
  {
    return new GOST3411_2012_256Digest(this);
  }
  
  public int doFinal(byte[] paramArrayOfByte, int paramInt)
  {
    byte[] arrayOfByte = new byte[64];
    super.doFinal(arrayOfByte, 0);
    System.arraycopy(arrayOfByte, 32, paramArrayOfByte, paramInt, 32);
    return 32;
  }
  
  public String getAlgorithmName()
  {
    return "GOST3411-2012-256";
  }
  
  public int getDigestSize()
  {
    return 32;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\digests\GOST3411_2012_256Digest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */