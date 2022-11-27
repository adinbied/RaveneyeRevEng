package org.bouncycastle.crypto.generators;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.bouncycastle.crypto.KeyGenerationParameters;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECKeyGenerationParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECMultiplier;
import org.bouncycastle.math.ec.FixedPointCombMultiplier;
import org.bouncycastle.math.ec.WNafUtil;

public class ECKeyPairGenerator
  implements AsymmetricCipherKeyPairGenerator, ECConstants
{
  ECDomainParameters params;
  SecureRandom random;
  
  protected ECMultiplier createBasePointMultiplier()
  {
    return new FixedPointCombMultiplier();
  }
  
  public AsymmetricCipherKeyPair generateKeyPair()
  {
    BigInteger localBigInteger1 = this.params.getN();
    int i = localBigInteger1.bitLength();
    BigInteger localBigInteger2;
    do
    {
      localBigInteger2 = new BigInteger(i, this.random);
    } while ((localBigInteger2.compareTo(TWO) < 0) || (localBigInteger2.compareTo(localBigInteger1) >= 0) || (WNafUtil.getNafWeight(localBigInteger2) < i >>> 2));
    return new AsymmetricCipherKeyPair(new ECPublicKeyParameters(createBasePointMultiplier().multiply(this.params.getG(), localBigInteger2), this.params), new ECPrivateKeyParameters(localBigInteger2, this.params));
  }
  
  public void init(KeyGenerationParameters paramKeyGenerationParameters)
  {
    paramKeyGenerationParameters = (ECKeyGenerationParameters)paramKeyGenerationParameters;
    this.random = paramKeyGenerationParameters.getRandom();
    this.params = paramKeyGenerationParameters.getDomainParameters();
    if (this.random == null) {
      this.random = new SecureRandom();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\generators\ECKeyPairGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */