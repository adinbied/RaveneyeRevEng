package org.bouncycastle.pqc.jcajce.provider.newhope;

import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.KeyGenerationParameters;
import org.bouncycastle.pqc.crypto.newhope.NHKeyPairGenerator;
import org.bouncycastle.pqc.crypto.newhope.NHPrivateKeyParameters;
import org.bouncycastle.pqc.crypto.newhope.NHPublicKeyParameters;

public class NHKeyPairGeneratorSpi
  extends KeyPairGenerator
{
  NHKeyPairGenerator engine = new NHKeyPairGenerator();
  boolean initialised = false;
  SecureRandom random = new SecureRandom();
  
  public NHKeyPairGeneratorSpi()
  {
    super("NH");
  }
  
  public KeyPair generateKeyPair()
  {
    if (!this.initialised)
    {
      this.engine.init(new KeyGenerationParameters(this.random, 1024));
      this.initialised = true;
    }
    Object localObject = this.engine.generateKeyPair();
    NHPublicKeyParameters localNHPublicKeyParameters = (NHPublicKeyParameters)((AsymmetricCipherKeyPair)localObject).getPublic();
    localObject = (NHPrivateKeyParameters)((AsymmetricCipherKeyPair)localObject).getPrivate();
    return new KeyPair(new BCNHPublicKey(localNHPublicKeyParameters), new BCNHPrivateKey((NHPrivateKeyParameters)localObject));
  }
  
  public void initialize(int paramInt, SecureRandom paramSecureRandom)
  {
    if (paramInt == 1024)
    {
      this.engine.init(new KeyGenerationParameters(paramSecureRandom, 1024));
      this.initialised = true;
      return;
    }
    throw new IllegalArgumentException("strength must be 1024 bits");
  }
  
  public void initialize(AlgorithmParameterSpec paramAlgorithmParameterSpec, SecureRandom paramSecureRandom)
    throws InvalidAlgorithmParameterException
  {
    throw new InvalidAlgorithmParameterException("parameter object not recognised");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\jcajce\provider\newhope\NHKeyPairGeneratorSpi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */