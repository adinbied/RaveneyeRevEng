package org.bouncycastle.pqc.crypto.newhope;

import java.security.SecureRandom;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.pqc.crypto.ExchangePair;
import org.bouncycastle.pqc.crypto.ExchangePairGenerator;

public class NHExchangePairGenerator
  implements ExchangePairGenerator
{
  private final SecureRandom random;
  
  public NHExchangePairGenerator(SecureRandom paramSecureRandom)
  {
    this.random = paramSecureRandom;
  }
  
  public ExchangePair GenerateExchange(AsymmetricKeyParameter paramAsymmetricKeyParameter)
  {
    return generateExchange(paramAsymmetricKeyParameter);
  }
  
  public ExchangePair generateExchange(AsymmetricKeyParameter paramAsymmetricKeyParameter)
  {
    paramAsymmetricKeyParameter = (NHPublicKeyParameters)paramAsymmetricKeyParameter;
    byte[] arrayOfByte1 = new byte[32];
    byte[] arrayOfByte2 = new byte['ࠀ'];
    NewHope.sharedB(this.random, arrayOfByte1, arrayOfByte2, paramAsymmetricKeyParameter.pubData);
    return new ExchangePair(new NHPublicKeyParameters(arrayOfByte2), arrayOfByte1);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\crypto\newhope\NHExchangePairGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */