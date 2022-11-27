package org.bouncycastle.pqc.crypto.xmss;

import org.bouncycastle.crypto.Digest;

public final class WOTSPlusParameters
{
  private final Digest digest;
  private final int digestSize;
  private final int len;
  private final int len1;
  private final int len2;
  private final XMSSOid oid;
  private final int winternitzParameter;
  
  protected WOTSPlusParameters(Digest paramDigest)
  {
    if (paramDigest != null)
    {
      this.digest = paramDigest;
      int i = XMSSUtil.getDigestSize(paramDigest);
      this.digestSize = i;
      this.winternitzParameter = 16;
      i = (int)Math.ceil(i * 8 / XMSSUtil.log2(16));
      this.len1 = i;
      i = (int)Math.floor(XMSSUtil.log2(i * (this.winternitzParameter - 1)) / XMSSUtil.log2(this.winternitzParameter)) + 1;
      this.len2 = i;
      this.len = (this.len1 + i);
      Object localObject = WOTSPlusOid.lookup(paramDigest.getAlgorithmName(), this.digestSize, this.winternitzParameter, this.len);
      this.oid = ((XMSSOid)localObject);
      if (localObject != null) {
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("cannot find OID for digest algorithm: ");
      ((StringBuilder)localObject).append(paramDigest.getAlgorithmName());
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    throw new NullPointerException("digest == null");
  }
  
  protected Digest getDigest()
  {
    return this.digest;
  }
  
  protected int getDigestSize()
  {
    return this.digestSize;
  }
  
  protected int getLen()
  {
    return this.len;
  }
  
  protected int getLen1()
  {
    return this.len1;
  }
  
  protected int getLen2()
  {
    return this.len2;
  }
  
  protected XMSSOid getOid()
  {
    return this.oid;
  }
  
  protected int getWinternitzParameter()
  {
    return this.winternitzParameter;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\crypto\xmss\WOTSPlusParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */