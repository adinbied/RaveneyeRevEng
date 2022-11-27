package org.bouncycastle.crypto.generators;

import java.math.BigInteger;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.bouncycastle.crypto.KeyGenerationParameters;
import org.bouncycastle.crypto.params.DHParameters;
import org.bouncycastle.crypto.params.ElGamalKeyGenerationParameters;
import org.bouncycastle.crypto.params.ElGamalParameters;
import org.bouncycastle.crypto.params.ElGamalPrivateKeyParameters;
import org.bouncycastle.crypto.params.ElGamalPublicKeyParameters;

public class ElGamalKeyPairGenerator
  implements AsymmetricCipherKeyPairGenerator
{
  private ElGamalKeyGenerationParameters param;
  
  public AsymmetricCipherKeyPair generateKeyPair()
  {
    DHKeyGeneratorHelper localDHKeyGeneratorHelper = DHKeyGeneratorHelper.INSTANCE;
    ElGamalParameters localElGamalParameters = this.param.getParameters();
    DHParameters localDHParameters = new DHParameters(localElGamalParameters.getP(), localElGamalParameters.getG(), null, localElGamalParameters.getL());
    BigInteger localBigInteger = localDHKeyGeneratorHelper.calculatePrivate(localDHParameters, this.param.getRandom());
    return new AsymmetricCipherKeyPair(new ElGamalPublicKeyParameters(localDHKeyGeneratorHelper.calculatePublic(localDHParameters, localBigInteger), localElGamalParameters), new ElGamalPrivateKeyParameters(localBigInteger, localElGamalParameters));
  }
  
  public void init(KeyGenerationParameters paramKeyGenerationParameters)
  {
    this.param = ((ElGamalKeyGenerationParameters)paramKeyGenerationParameters);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\generators\ElGamalKeyPairGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */