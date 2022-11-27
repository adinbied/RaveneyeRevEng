package org.bouncycastle.crypto.agreement.srp;

import java.math.BigInteger;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.params.SRP6GroupParameters;

public class SRP6VerifierGenerator
{
  protected BigInteger N;
  protected Digest digest;
  protected BigInteger g;
  
  public BigInteger generateVerifier(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    paramArrayOfByte1 = SRP6Util.calculateX(this.digest, this.N, paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3);
    return this.g.modPow(paramArrayOfByte1, this.N);
  }
  
  public void init(BigInteger paramBigInteger1, BigInteger paramBigInteger2, Digest paramDigest)
  {
    this.N = paramBigInteger1;
    this.g = paramBigInteger2;
    this.digest = paramDigest;
  }
  
  public void init(SRP6GroupParameters paramSRP6GroupParameters, Digest paramDigest)
  {
    this.N = paramSRP6GroupParameters.getN();
    this.g = paramSRP6GroupParameters.getG();
    this.digest = paramDigest;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\agreement\srp\SRP6VerifierGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */