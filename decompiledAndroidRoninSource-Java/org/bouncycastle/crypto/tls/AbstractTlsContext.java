package org.bouncycastle.crypto.tls;

import java.security.SecureRandom;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.prng.DigestRandomGenerator;
import org.bouncycastle.crypto.prng.RandomGenerator;
import org.bouncycastle.util.Times;

abstract class AbstractTlsContext
  implements TlsContext
{
  private static long counter = ;
  private ProtocolVersion clientVersion = null;
  private RandomGenerator nonceRandom;
  private SecureRandom secureRandom;
  private SecurityParameters securityParameters;
  private ProtocolVersion serverVersion = null;
  private TlsSession session = null;
  private Object userObject = null;
  
  AbstractTlsContext(SecureRandom paramSecureRandom, SecurityParameters paramSecurityParameters)
  {
    Object localObject = TlsUtils.createHash((short)4);
    byte[] arrayOfByte = new byte[((Digest)localObject).getDigestSize()];
    paramSecureRandom.nextBytes(arrayOfByte);
    localObject = new DigestRandomGenerator((Digest)localObject);
    this.nonceRandom = ((RandomGenerator)localObject);
    ((RandomGenerator)localObject).addSeedMaterial(nextCounterValue());
    this.nonceRandom.addSeedMaterial(Times.nanoTime());
    this.nonceRandom.addSeedMaterial(arrayOfByte);
    this.secureRandom = paramSecureRandom;
    this.securityParameters = paramSecurityParameters;
  }
  
  private static long nextCounterValue()
  {
    try
    {
      long l = counter + 1L;
      counter = l;
      return l;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public byte[] exportKeyingMaterial(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    if ((paramArrayOfByte != null) && (!TlsUtils.isValidUint16(paramArrayOfByte.length))) {
      throw new IllegalArgumentException("'context_value' must have length less than 2^16 (or be null)");
    }
    SecurityParameters localSecurityParameters = getSecurityParameters();
    byte[] arrayOfByte1 = localSecurityParameters.getClientRandom();
    byte[] arrayOfByte2 = localSecurityParameters.getServerRandom();
    int j = arrayOfByte1.length + arrayOfByte2.length;
    int i = j;
    if (paramArrayOfByte != null) {
      i = j + (paramArrayOfByte.length + 2);
    }
    byte[] arrayOfByte3 = new byte[i];
    System.arraycopy(arrayOfByte1, 0, arrayOfByte3, 0, arrayOfByte1.length);
    j = arrayOfByte1.length + 0;
    System.arraycopy(arrayOfByte2, 0, arrayOfByte3, j, arrayOfByte2.length);
    int k = j + arrayOfByte2.length;
    j = k;
    if (paramArrayOfByte != null)
    {
      TlsUtils.writeUint16(paramArrayOfByte.length, arrayOfByte3, k);
      j = k + 2;
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte3, j, paramArrayOfByte.length);
      j += paramArrayOfByte.length;
    }
    if (j == i) {
      return TlsUtils.PRF(this, localSecurityParameters.getMasterSecret(), paramString, arrayOfByte3, paramInt);
    }
    throw new IllegalStateException("error in calculation of seed for export");
  }
  
  public ProtocolVersion getClientVersion()
  {
    return this.clientVersion;
  }
  
  public RandomGenerator getNonceRandomGenerator()
  {
    return this.nonceRandom;
  }
  
  public TlsSession getResumableSession()
  {
    return this.session;
  }
  
  public SecureRandom getSecureRandom()
  {
    return this.secureRandom;
  }
  
  public SecurityParameters getSecurityParameters()
  {
    return this.securityParameters;
  }
  
  public ProtocolVersion getServerVersion()
  {
    return this.serverVersion;
  }
  
  public Object getUserObject()
  {
    return this.userObject;
  }
  
  void setClientVersion(ProtocolVersion paramProtocolVersion)
  {
    this.clientVersion = paramProtocolVersion;
  }
  
  void setResumableSession(TlsSession paramTlsSession)
  {
    this.session = paramTlsSession;
  }
  
  void setServerVersion(ProtocolVersion paramProtocolVersion)
  {
    this.serverVersion = paramProtocolVersion;
  }
  
  public void setUserObject(Object paramObject)
  {
    this.userObject = paramObject;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\AbstractTlsContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */