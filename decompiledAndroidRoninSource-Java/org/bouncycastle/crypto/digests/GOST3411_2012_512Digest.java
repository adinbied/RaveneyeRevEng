package org.bouncycastle.crypto.digests;

import org.bouncycastle.util.Memoable;

public class GOST3411_2012_512Digest
  extends GOST3411_2012Digest
{
  private static final byte[] IV = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
  
  public GOST3411_2012_512Digest()
  {
    super(IV);
  }
  
  public GOST3411_2012_512Digest(GOST3411_2012_512Digest paramGOST3411_2012_512Digest)
  {
    super(IV);
    reset(paramGOST3411_2012_512Digest);
  }
  
  public Memoable copy()
  {
    return new GOST3411_2012_512Digest(this);
  }
  
  public String getAlgorithmName()
  {
    return "GOST3411-2012-512";
  }
  
  public int getDigestSize()
  {
    return 64;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\digests\GOST3411_2012_512Digest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */