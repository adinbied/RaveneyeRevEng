package org.bouncycastle.crypto.tls;

import java.math.BigInteger;
import org.bouncycastle.crypto.params.SRP6GroupParameters;

public class TlsSRPLoginParameters
{
  protected SRP6GroupParameters group;
  protected byte[] salt;
  protected BigInteger verifier;
  
  public TlsSRPLoginParameters(SRP6GroupParameters paramSRP6GroupParameters, BigInteger paramBigInteger, byte[] paramArrayOfByte)
  {
    this.group = paramSRP6GroupParameters;
    this.verifier = paramBigInteger;
    this.salt = paramArrayOfByte;
  }
  
  public SRP6GroupParameters getGroup()
  {
    return this.group;
  }
  
  public byte[] getSalt()
  {
    return this.salt;
  }
  
  public BigInteger getVerifier()
  {
    return this.verifier;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\TlsSRPLoginParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */