package org.bouncycastle.pkcs.bc;

import java.security.SecureRandom;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCS12PBEParams;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.crypto.ExtendedDigest;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.operator.MacCalculator;
import org.bouncycastle.pkcs.PKCS12MacCalculatorBuilder;

public class BcPKCS12MacCalculatorBuilder
  implements PKCS12MacCalculatorBuilder
{
  private AlgorithmIdentifier algorithmIdentifier;
  private ExtendedDigest digest;
  private int iterationCount = 1024;
  private SecureRandom random;
  private int saltLength;
  
  public BcPKCS12MacCalculatorBuilder()
  {
    this(new SHA1Digest(), new AlgorithmIdentifier(OIWObjectIdentifiers.idSHA1, DERNull.INSTANCE));
  }
  
  public BcPKCS12MacCalculatorBuilder(ExtendedDigest paramExtendedDigest, AlgorithmIdentifier paramAlgorithmIdentifier)
  {
    this.digest = paramExtendedDigest;
    this.algorithmIdentifier = paramAlgorithmIdentifier;
    this.saltLength = paramExtendedDigest.getDigestSize();
  }
  
  public MacCalculator build(char[] paramArrayOfChar)
  {
    if (this.random == null) {
      this.random = new SecureRandom();
    }
    byte[] arrayOfByte = new byte[this.saltLength];
    this.random.nextBytes(arrayOfByte);
    return PKCS12PBEUtils.createMacCalculator(this.algorithmIdentifier.getAlgorithm(), this.digest, new PKCS12PBEParams(arrayOfByte, this.iterationCount), paramArrayOfChar);
  }
  
  public AlgorithmIdentifier getDigestAlgorithmIdentifier()
  {
    return this.algorithmIdentifier;
  }
  
  public BcPKCS12MacCalculatorBuilder setIterationCount(int paramInt)
  {
    this.iterationCount = paramInt;
    return this;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pkcs\bc\BcPKCS12MacCalculatorBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */