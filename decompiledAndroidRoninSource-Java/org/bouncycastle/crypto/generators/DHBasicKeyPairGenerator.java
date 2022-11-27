package org.bouncycastle.crypto.generators;

import java.math.BigInteger;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.bouncycastle.crypto.KeyGenerationParameters;
import org.bouncycastle.crypto.params.DHKeyGenerationParameters;
import org.bouncycastle.crypto.params.DHParameters;
import org.bouncycastle.crypto.params.DHPrivateKeyParameters;
import org.bouncycastle.crypto.params.DHPublicKeyParameters;

public class DHBasicKeyPairGenerator
  implements AsymmetricCipherKeyPairGenerator
{
  private DHKeyGenerationParameters param;
  
  public AsymmetricCipherKeyPair generateKeyPair()
  {
    DHKeyGeneratorHelper localDHKeyGeneratorHelper = DHKeyGeneratorHelper.INSTANCE;
    DHParameters localDHParameters = this.param.getParameters();
    BigInteger localBigInteger = localDHKeyGeneratorHelper.calculatePrivate(localDHParameters, this.param.getRandom());
    return new AsymmetricCipherKeyPair(new DHPublicKeyParameters(localDHKeyGeneratorHelper.calculatePublic(localDHParameters, localBigInteger), localDHParameters), new DHPrivateKeyParameters(localBigInteger, localDHParameters));
  }
  
  public void init(KeyGenerationParameters paramKeyGenerationParameters)
  {
    this.param = ((DHKeyGenerationParameters)paramKeyGenerationParameters);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\generators\DHBasicKeyPairGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */