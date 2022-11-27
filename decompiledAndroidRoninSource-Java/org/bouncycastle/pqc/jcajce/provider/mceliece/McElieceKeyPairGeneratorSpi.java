package org.bouncycastle.pqc.jcajce.provider.mceliece;

import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.pqc.crypto.mceliece.McElieceKeyGenerationParameters;
import org.bouncycastle.pqc.crypto.mceliece.McElieceKeyPairGenerator;
import org.bouncycastle.pqc.crypto.mceliece.McElieceParameters;
import org.bouncycastle.pqc.crypto.mceliece.McEliecePrivateKeyParameters;
import org.bouncycastle.pqc.crypto.mceliece.McEliecePublicKeyParameters;
import org.bouncycastle.pqc.jcajce.spec.McElieceKeyGenParameterSpec;

public class McElieceKeyPairGeneratorSpi
  extends KeyPairGenerator
{
  McElieceKeyPairGenerator kpg;
  
  public McElieceKeyPairGeneratorSpi()
  {
    super("McEliece");
  }
  
  public KeyPair generateKeyPair()
  {
    AsymmetricCipherKeyPair localAsymmetricCipherKeyPair = this.kpg.generateKeyPair();
    McEliecePrivateKeyParameters localMcEliecePrivateKeyParameters = (McEliecePrivateKeyParameters)localAsymmetricCipherKeyPair.getPrivate();
    return new KeyPair(new BCMcEliecePublicKey((McEliecePublicKeyParameters)localAsymmetricCipherKeyPair.getPublic()), new BCMcEliecePrivateKey(localMcEliecePrivateKeyParameters));
  }
  
  public void initialize(int paramInt, SecureRandom paramSecureRandom)
  {
    paramSecureRandom = new McElieceKeyGenParameterSpec();
    try
    {
      initialize(paramSecureRandom);
      return;
    }
    catch (InvalidAlgorithmParameterException paramSecureRandom) {}
  }
  
  public void initialize(AlgorithmParameterSpec paramAlgorithmParameterSpec)
    throws InvalidAlgorithmParameterException
  {
    this.kpg = new McElieceKeyPairGenerator();
    super.initialize(paramAlgorithmParameterSpec);
    paramAlgorithmParameterSpec = (McElieceKeyGenParameterSpec)paramAlgorithmParameterSpec;
    paramAlgorithmParameterSpec = new McElieceKeyGenerationParameters(new SecureRandom(), new McElieceParameters(paramAlgorithmParameterSpec.getM(), paramAlgorithmParameterSpec.getT()));
    this.kpg.init(paramAlgorithmParameterSpec);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\jcajce\provider\mceliece\McElieceKeyPairGeneratorSpi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */