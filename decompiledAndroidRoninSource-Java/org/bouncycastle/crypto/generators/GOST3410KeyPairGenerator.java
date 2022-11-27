package org.bouncycastle.crypto.generators;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.bouncycastle.crypto.KeyGenerationParameters;
import org.bouncycastle.crypto.params.GOST3410KeyGenerationParameters;
import org.bouncycastle.crypto.params.GOST3410Parameters;
import org.bouncycastle.crypto.params.GOST3410PrivateKeyParameters;
import org.bouncycastle.crypto.params.GOST3410PublicKeyParameters;
import org.bouncycastle.math.ec.WNafUtil;

public class GOST3410KeyPairGenerator
  implements AsymmetricCipherKeyPairGenerator
{
  private GOST3410KeyGenerationParameters param;
  
  public AsymmetricCipherKeyPair generateKeyPair()
  {
    GOST3410Parameters localGOST3410Parameters = this.param.getParameters();
    SecureRandom localSecureRandom = this.param.getRandom();
    BigInteger localBigInteger1 = localGOST3410Parameters.getQ();
    BigInteger localBigInteger2 = localGOST3410Parameters.getP();
    BigInteger localBigInteger3 = localGOST3410Parameters.getA();
    BigInteger localBigInteger4;
    do
    {
      localBigInteger4 = new BigInteger(256, localSecureRandom);
    } while ((localBigInteger4.signum() < 1) || (localBigInteger4.compareTo(localBigInteger1) >= 0) || (WNafUtil.getNafWeight(localBigInteger4) < 64));
    return new AsymmetricCipherKeyPair(new GOST3410PublicKeyParameters(localBigInteger3.modPow(localBigInteger4, localBigInteger2), localGOST3410Parameters), new GOST3410PrivateKeyParameters(localBigInteger4, localGOST3410Parameters));
  }
  
  public void init(KeyGenerationParameters paramKeyGenerationParameters)
  {
    this.param = ((GOST3410KeyGenerationParameters)paramKeyGenerationParameters);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\generators\GOST3410KeyPairGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */