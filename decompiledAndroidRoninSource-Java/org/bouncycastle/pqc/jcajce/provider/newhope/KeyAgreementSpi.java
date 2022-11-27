package org.bouncycastle.pqc.jcajce.provider.newhope;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.ShortBufferException;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.jcajce.provider.asymmetric.util.BaseAgreementSpi;
import org.bouncycastle.pqc.crypto.ExchangePair;
import org.bouncycastle.pqc.crypto.newhope.NHAgreement;
import org.bouncycastle.pqc.crypto.newhope.NHExchangePairGenerator;
import org.bouncycastle.pqc.crypto.newhope.NHPublicKeyParameters;
import org.bouncycastle.util.Arrays;

public class KeyAgreementSpi
  extends BaseAgreementSpi
{
  private NHAgreement agreement;
  private NHExchangePairGenerator exchangePairGenerator;
  private BCNHPublicKey otherPartyKey;
  private byte[] shared;
  
  public KeyAgreementSpi()
  {
    super("NH", null);
  }
  
  protected byte[] calcSecret()
  {
    return engineGenerateSecret();
  }
  
  protected Key engineDoPhase(Key paramKey, boolean paramBoolean)
    throws InvalidKeyException, IllegalStateException
  {
    if (paramBoolean)
    {
      paramKey = (BCNHPublicKey)paramKey;
      this.otherPartyKey = paramKey;
      NHExchangePairGenerator localNHExchangePairGenerator = this.exchangePairGenerator;
      if (localNHExchangePairGenerator != null)
      {
        paramKey = localNHExchangePairGenerator.generateExchange((AsymmetricKeyParameter)paramKey.getKeyParams());
        this.shared = paramKey.getSharedValue();
        return new BCNHPublicKey((NHPublicKeyParameters)paramKey.getPublicKey());
      }
      this.shared = this.agreement.calculateAgreement(paramKey.getKeyParams());
      return null;
    }
    throw new IllegalStateException("NewHope can only be between two parties.");
  }
  
  protected int engineGenerateSecret(byte[] paramArrayOfByte, int paramInt)
    throws IllegalStateException, ShortBufferException
  {
    byte[] arrayOfByte = this.shared;
    System.arraycopy(arrayOfByte, 0, paramArrayOfByte, paramInt, arrayOfByte.length);
    Arrays.fill(this.shared, (byte)0);
    return this.shared.length;
  }
  
  protected byte[] engineGenerateSecret()
    throws IllegalStateException
  {
    byte[] arrayOfByte = Arrays.clone(this.shared);
    Arrays.fill(this.shared, (byte)0);
    return arrayOfByte;
  }
  
  protected void engineInit(Key paramKey, SecureRandom paramSecureRandom)
    throws InvalidKeyException
  {
    if (paramKey != null)
    {
      paramSecureRandom = new NHAgreement();
      this.agreement = paramSecureRandom;
      paramSecureRandom.init(((BCNHPrivateKey)paramKey).getKeyParams());
      return;
    }
    this.exchangePairGenerator = new NHExchangePairGenerator(paramSecureRandom);
  }
  
  protected void engineInit(Key paramKey, AlgorithmParameterSpec paramAlgorithmParameterSpec, SecureRandom paramSecureRandom)
    throws InvalidKeyException, InvalidAlgorithmParameterException
  {
    throw new InvalidAlgorithmParameterException("NewHope does not require parameters");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\jcajce\provider\newhope\KeyAgreementSpi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */