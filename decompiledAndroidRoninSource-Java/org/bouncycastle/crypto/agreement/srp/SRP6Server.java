package org.bouncycastle.crypto.agreement.srp;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.params.SRP6GroupParameters;

public class SRP6Server
{
  protected BigInteger A;
  protected BigInteger B;
  protected BigInteger Key;
  protected BigInteger M1;
  protected BigInteger M2;
  protected BigInteger N;
  protected BigInteger S;
  protected BigInteger b;
  protected Digest digest;
  protected BigInteger g;
  protected SecureRandom random;
  protected BigInteger u;
  protected BigInteger v;
  
  private BigInteger calculateS()
  {
    return this.v.modPow(this.u, this.N).multiply(this.A).mod(this.N).modPow(this.b, this.N);
  }
  
  public BigInteger calculateSecret(BigInteger paramBigInteger)
    throws CryptoException
  {
    paramBigInteger = SRP6Util.validatePublicValue(this.N, paramBigInteger);
    this.A = paramBigInteger;
    this.u = SRP6Util.calculateU(this.digest, this.N, paramBigInteger, this.B);
    paramBigInteger = calculateS();
    this.S = paramBigInteger;
    return paramBigInteger;
  }
  
  public BigInteger calculateServerEvidenceMessage()
    throws CryptoException
  {
    BigInteger localBigInteger1 = this.A;
    if (localBigInteger1 != null)
    {
      BigInteger localBigInteger2 = this.M1;
      if (localBigInteger2 != null)
      {
        BigInteger localBigInteger3 = this.S;
        if (localBigInteger3 != null)
        {
          localBigInteger1 = SRP6Util.calculateM2(this.digest, this.N, localBigInteger1, localBigInteger2, localBigInteger3);
          this.M2 = localBigInteger1;
          return localBigInteger1;
        }
      }
    }
    throw new CryptoException("Impossible to compute M2: some data are missing from the previous operations (A,M1,S)");
  }
  
  public BigInteger calculateSessionKey()
    throws CryptoException
  {
    BigInteger localBigInteger = this.S;
    if ((localBigInteger != null) && (this.M1 != null) && (this.M2 != null))
    {
      localBigInteger = SRP6Util.calculateKey(this.digest, this.N, localBigInteger);
      this.Key = localBigInteger;
      return localBigInteger;
    }
    throw new CryptoException("Impossible to compute Key: some data are missing from the previous operations (S,M1,M2)");
  }
  
  public BigInteger generateServerCredentials()
  {
    BigInteger localBigInteger = SRP6Util.calculateK(this.digest, this.N, this.g);
    this.b = selectPrivateValue();
    localBigInteger = localBigInteger.multiply(this.v).mod(this.N).add(this.g.modPow(this.b, this.N)).mod(this.N);
    this.B = localBigInteger;
    return localBigInteger;
  }
  
  public void init(BigInteger paramBigInteger1, BigInteger paramBigInteger2, BigInteger paramBigInteger3, Digest paramDigest, SecureRandom paramSecureRandom)
  {
    this.N = paramBigInteger1;
    this.g = paramBigInteger2;
    this.v = paramBigInteger3;
    this.random = paramSecureRandom;
    this.digest = paramDigest;
  }
  
  public void init(SRP6GroupParameters paramSRP6GroupParameters, BigInteger paramBigInteger, Digest paramDigest, SecureRandom paramSecureRandom)
  {
    init(paramSRP6GroupParameters.getN(), paramSRP6GroupParameters.getG(), paramBigInteger, paramDigest, paramSecureRandom);
  }
  
  protected BigInteger selectPrivateValue()
  {
    return SRP6Util.generatePrivateValue(this.digest, this.N, this.g, this.random);
  }
  
  public boolean verifyClientEvidenceMessage(BigInteger paramBigInteger)
    throws CryptoException
  {
    BigInteger localBigInteger1 = this.A;
    if (localBigInteger1 != null)
    {
      BigInteger localBigInteger2 = this.B;
      if (localBigInteger2 != null)
      {
        BigInteger localBigInteger3 = this.S;
        if (localBigInteger3 != null)
        {
          if (SRP6Util.calculateM1(this.digest, this.N, localBigInteger1, localBigInteger2, localBigInteger3).equals(paramBigInteger))
          {
            this.M1 = paramBigInteger;
            return true;
          }
          return false;
        }
      }
    }
    throw new CryptoException("Impossible to compute and verify M1: some data are missing from the previous operations (A,B,S)");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\agreement\srp\SRP6Server.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */