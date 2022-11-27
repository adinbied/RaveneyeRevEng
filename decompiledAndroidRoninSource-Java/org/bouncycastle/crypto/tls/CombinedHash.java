package org.bouncycastle.crypto.tls;

import org.bouncycastle.crypto.Digest;

class CombinedHash
  implements TlsHandshakeHash
{
  protected TlsContext context;
  protected Digest md5;
  protected Digest sha1;
  
  CombinedHash()
  {
    this.md5 = TlsUtils.createHash((short)1);
    this.sha1 = TlsUtils.createHash((short)2);
  }
  
  CombinedHash(CombinedHash paramCombinedHash)
  {
    this.context = paramCombinedHash.context;
    this.md5 = TlsUtils.cloneHash((short)1, paramCombinedHash.md5);
    this.sha1 = TlsUtils.cloneHash((short)2, paramCombinedHash.sha1);
  }
  
  public int doFinal(byte[] paramArrayOfByte, int paramInt)
  {
    TlsContext localTlsContext = this.context;
    if ((localTlsContext != null) && (TlsUtils.isSSL(localTlsContext)))
    {
      ssl3Complete(this.md5, SSL3Mac.IPAD, SSL3Mac.OPAD, 48);
      ssl3Complete(this.sha1, SSL3Mac.IPAD, SSL3Mac.OPAD, 40);
    }
    int i = this.md5.doFinal(paramArrayOfByte, paramInt);
    return i + this.sha1.doFinal(paramArrayOfByte, paramInt + i);
  }
  
  public Digest forkPRFHash()
  {
    return new CombinedHash(this);
  }
  
  public String getAlgorithmName()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.md5.getAlgorithmName());
    localStringBuilder.append(" and ");
    localStringBuilder.append(this.sha1.getAlgorithmName());
    return localStringBuilder.toString();
  }
  
  public int getDigestSize()
  {
    return this.md5.getDigestSize() + this.sha1.getDigestSize();
  }
  
  public byte[] getFinalHash(short paramShort)
  {
    throw new IllegalStateException("CombinedHash doesn't support multiple hashes");
  }
  
  public void init(TlsContext paramTlsContext)
  {
    this.context = paramTlsContext;
  }
  
  public TlsHandshakeHash notifyPRFDetermined()
  {
    return this;
  }
  
  public void reset()
  {
    this.md5.reset();
    this.sha1.reset();
  }
  
  public void sealHashAlgorithms() {}
  
  protected void ssl3Complete(Digest paramDigest, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt)
  {
    byte[] arrayOfByte = this.context.getSecurityParameters().masterSecret;
    paramDigest.update(arrayOfByte, 0, arrayOfByte.length);
    paramDigest.update(paramArrayOfByte1, 0, paramInt);
    int i = paramDigest.getDigestSize();
    paramArrayOfByte1 = new byte[i];
    paramDigest.doFinal(paramArrayOfByte1, 0);
    paramDigest.update(arrayOfByte, 0, arrayOfByte.length);
    paramDigest.update(paramArrayOfByte2, 0, paramInt);
    paramDigest.update(paramArrayOfByte1, 0, i);
  }
  
  public TlsHandshakeHash stopTracking()
  {
    return new CombinedHash(this);
  }
  
  public void trackHashAlgorithm(short paramShort)
  {
    throw new IllegalStateException("CombinedHash only supports calculating the legacy PRF for handshake hash");
  }
  
  public void update(byte paramByte)
  {
    this.md5.update(paramByte);
    this.sha1.update(paramByte);
  }
  
  public void update(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.md5.update(paramArrayOfByte, paramInt1, paramInt2);
    this.sha1.update(paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\CombinedHash.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */