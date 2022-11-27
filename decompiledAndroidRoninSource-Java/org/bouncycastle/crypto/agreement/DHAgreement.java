package org.bouncycastle.crypto.agreement;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.generators.DHKeyPairGenerator;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.DHKeyGenerationParameters;
import org.bouncycastle.crypto.params.DHParameters;
import org.bouncycastle.crypto.params.DHPrivateKeyParameters;
import org.bouncycastle.crypto.params.DHPublicKeyParameters;
import org.bouncycastle.crypto.params.ParametersWithRandom;

public class DHAgreement
{
  private static final BigInteger ONE = BigInteger.valueOf(1L);
  private DHParameters dhParams;
  private DHPrivateKeyParameters key;
  private BigInteger privateValue;
  private SecureRandom random;
  
  public BigInteger calculateAgreement(DHPublicKeyParameters paramDHPublicKeyParameters, BigInteger paramBigInteger)
  {
    if (paramDHPublicKeyParameters.getParameters().equals(this.dhParams))
    {
      BigInteger localBigInteger = this.dhParams.getP();
      paramDHPublicKeyParameters = paramDHPublicKeyParameters.getY().modPow(this.privateValue, localBigInteger);
      if (paramDHPublicKeyParameters.compareTo(ONE) != 0) {
        return paramBigInteger.modPow(this.key.getX(), localBigInteger).multiply(paramDHPublicKeyParameters).mod(localBigInteger);
      }
      throw new IllegalStateException("Shared key can't be 1");
    }
    throw new IllegalArgumentException("Diffie-Hellman public key has wrong parameters.");
  }
  
  public BigInteger calculateMessage()
  {
    Object localObject = new DHKeyPairGenerator();
    ((DHKeyPairGenerator)localObject).init(new DHKeyGenerationParameters(this.random, this.dhParams));
    localObject = ((DHKeyPairGenerator)localObject).generateKeyPair();
    this.privateValue = ((DHPrivateKeyParameters)((AsymmetricCipherKeyPair)localObject).getPrivate()).getX();
    return ((DHPublicKeyParameters)((AsymmetricCipherKeyPair)localObject).getPublic()).getY();
  }
  
  public void init(CipherParameters paramCipherParameters)
  {
    if ((paramCipherParameters instanceof ParametersWithRandom))
    {
      paramCipherParameters = (ParametersWithRandom)paramCipherParameters;
      this.random = paramCipherParameters.getRandom();
      paramCipherParameters = paramCipherParameters.getParameters();
    }
    else
    {
      this.random = new SecureRandom();
    }
    paramCipherParameters = (AsymmetricKeyParameter)paramCipherParameters;
    if ((paramCipherParameters instanceof DHPrivateKeyParameters))
    {
      paramCipherParameters = (DHPrivateKeyParameters)paramCipherParameters;
      this.key = paramCipherParameters;
      this.dhParams = paramCipherParameters.getParameters();
      return;
    }
    throw new IllegalArgumentException("DHEngine expects DHPrivateKeyParameters");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\agreement\DHAgreement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */