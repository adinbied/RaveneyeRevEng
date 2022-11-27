package org.bouncycastle.pqc.crypto.xmss;

import java.security.SecureRandom;
import org.bouncycastle.crypto.Digest;

public final class XMSSMTParameters
{
  private final int height;
  private final int layers;
  private final XMSSOid oid;
  private final XMSS xmss;
  
  public XMSSMTParameters(int paramInt1, int paramInt2, Digest paramDigest, SecureRandom paramSecureRandom)
  {
    this.height = paramInt1;
    this.layers = paramInt2;
    this.xmss = new XMSS(new XMSSParameters(xmssTreeHeight(paramInt1, paramInt2), paramDigest, paramSecureRandom));
    this.oid = DefaultXMSSMTOid.lookup(getDigest().getAlgorithmName(), getDigestSize(), getWinternitzParameter(), getLen(), getHeight(), paramInt2);
  }
  
  private static int xmssTreeHeight(int paramInt1, int paramInt2)
    throws IllegalArgumentException
  {
    if (paramInt1 >= 2)
    {
      if (paramInt1 % paramInt2 == 0)
      {
        paramInt1 /= paramInt2;
        if (paramInt1 != 1) {
          return paramInt1;
        }
        throw new IllegalArgumentException("height / layers must be greater than 1");
      }
      throw new IllegalArgumentException("layers must divide totalHeight without remainder");
    }
    throw new IllegalArgumentException("totalHeight must be > 1");
  }
  
  protected Digest getDigest()
  {
    return this.xmss.getParams().getDigest();
  }
  
  public int getDigestSize()
  {
    return this.xmss.getParams().getDigestSize();
  }
  
  public int getHeight()
  {
    return this.height;
  }
  
  public int getLayers()
  {
    return this.layers;
  }
  
  protected int getLen()
  {
    return this.xmss.getWOTSPlus().getParams().getLen();
  }
  
  protected WOTSPlus getWOTSPlus()
  {
    return this.xmss.getWOTSPlus();
  }
  
  public int getWinternitzParameter()
  {
    return this.xmss.getParams().getWinternitzParameter();
  }
  
  protected XMSS getXMSS()
  {
    return this.xmss;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\crypto\xmss\XMSSMTParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */