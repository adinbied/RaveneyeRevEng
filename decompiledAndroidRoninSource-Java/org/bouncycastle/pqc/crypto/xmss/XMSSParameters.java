package org.bouncycastle.pqc.crypto.xmss;

import java.security.SecureRandom;
import org.bouncycastle.crypto.Digest;

public final class XMSSParameters
{
  private final int height;
  private final int k;
  private final XMSSOid oid;
  private final SecureRandom prng;
  private final WOTSPlus wotsPlus;
  
  public XMSSParameters(int paramInt, Digest paramDigest, SecureRandom paramSecureRandom)
  {
    if (paramInt >= 2)
    {
      if (paramDigest != null)
      {
        if (paramSecureRandom != null)
        {
          this.wotsPlus = new WOTSPlus(new WOTSPlusParameters(paramDigest));
          this.prng = paramSecureRandom;
          this.height = paramInt;
          this.k = determineMinK();
          this.oid = DefaultXMSSOid.lookup(getDigest().getAlgorithmName(), getDigestSize(), getWinternitzParameter(), this.wotsPlus.getParams().getLen(), paramInt);
          return;
        }
        throw new NullPointerException("prng == null");
      }
      throw new NullPointerException("digest == null");
    }
    throw new IllegalArgumentException("height must be >= 2");
  }
  
  private int determineMinK()
  {
    int i = 2;
    for (;;)
    {
      int j = this.height;
      if (i > j) {
        break;
      }
      if ((j - i) % 2 == 0) {
        return i;
      }
      i += 1;
    }
    throw new IllegalStateException("should never happen...");
  }
  
  protected Digest getDigest()
  {
    return this.wotsPlus.getParams().getDigest();
  }
  
  public int getDigestSize()
  {
    return this.wotsPlus.getParams().getDigestSize();
  }
  
  public int getHeight()
  {
    return this.height;
  }
  
  protected int getK()
  {
    return this.k;
  }
  
  protected SecureRandom getPRNG()
  {
    return this.prng;
  }
  
  protected WOTSPlus getWOTSPlus()
  {
    return this.wotsPlus;
  }
  
  public int getWinternitzParameter()
  {
    return this.wotsPlus.getParams().getWinternitzParameter();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\crypto\xmss\XMSSParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */