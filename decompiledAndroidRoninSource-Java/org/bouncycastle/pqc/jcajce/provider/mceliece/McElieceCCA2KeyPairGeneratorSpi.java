package org.bouncycastle.pqc.jcajce.provider.mceliece;

import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.pqc.crypto.mceliece.McElieceCCA2KeyGenerationParameters;
import org.bouncycastle.pqc.crypto.mceliece.McElieceCCA2KeyPairGenerator;
import org.bouncycastle.pqc.crypto.mceliece.McElieceCCA2Parameters;
import org.bouncycastle.pqc.crypto.mceliece.McElieceCCA2PrivateKeyParameters;
import org.bouncycastle.pqc.crypto.mceliece.McElieceCCA2PublicKeyParameters;
import org.bouncycastle.pqc.jcajce.spec.McElieceCCA2KeyGenParameterSpec;

public class McElieceCCA2KeyPairGeneratorSpi
  extends KeyPairGenerator
{
  private McElieceCCA2KeyPairGenerator kpg;
  
  public McElieceCCA2KeyPairGeneratorSpi()
  {
    super("McEliece-CCA2");
  }
  
  public KeyPair generateKeyPair()
  {
    AsymmetricCipherKeyPair localAsymmetricCipherKeyPair = this.kpg.generateKeyPair();
    McElieceCCA2PrivateKeyParameters localMcElieceCCA2PrivateKeyParameters = (McElieceCCA2PrivateKeyParameters)localAsymmetricCipherKeyPair.getPrivate();
    return new KeyPair(new BCMcElieceCCA2PublicKey((McElieceCCA2PublicKeyParameters)localAsymmetricCipherKeyPair.getPublic()), new BCMcElieceCCA2PrivateKey(localMcElieceCCA2PrivateKeyParameters));
  }
  
  public void initialize(int paramInt, SecureRandom paramSecureRandom)
  {
    this.kpg = new McElieceCCA2KeyPairGenerator();
    paramSecureRandom = new McElieceCCA2KeyGenerationParameters(paramSecureRandom, new McElieceCCA2Parameters());
    this.kpg.init(paramSecureRandom);
  }
  
  public void initialize(AlgorithmParameterSpec paramAlgorithmParameterSpec)
    throws InvalidAlgorithmParameterException
  {
    this.kpg = new McElieceCCA2KeyPairGenerator();
    super.initialize(paramAlgorithmParameterSpec);
    paramAlgorithmParameterSpec = (McElieceCCA2KeyGenParameterSpec)paramAlgorithmParameterSpec;
    paramAlgorithmParameterSpec = new McElieceCCA2KeyGenerationParameters(new SecureRandom(), new McElieceCCA2Parameters(paramAlgorithmParameterSpec.getM(), paramAlgorithmParameterSpec.getT(), paramAlgorithmParameterSpec.getDigest()));
    this.kpg.init(paramAlgorithmParameterSpec);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\jcajce\provider\mceliece\McElieceCCA2KeyPairGeneratorSpi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */