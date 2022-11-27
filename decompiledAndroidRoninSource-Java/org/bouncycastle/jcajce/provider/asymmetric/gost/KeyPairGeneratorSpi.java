package org.bouncycastle.jcajce.provider.asymmetric.gost;

import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.generators.GOST3410KeyPairGenerator;
import org.bouncycastle.crypto.params.GOST3410KeyGenerationParameters;
import org.bouncycastle.crypto.params.GOST3410Parameters;
import org.bouncycastle.crypto.params.GOST3410PrivateKeyParameters;
import org.bouncycastle.crypto.params.GOST3410PublicKeyParameters;
import org.bouncycastle.jce.spec.GOST3410ParameterSpec;
import org.bouncycastle.jce.spec.GOST3410PublicKeyParameterSetSpec;

public class KeyPairGeneratorSpi
  extends KeyPairGenerator
{
  GOST3410KeyPairGenerator engine = new GOST3410KeyPairGenerator();
  GOST3410ParameterSpec gost3410Params;
  boolean initialised = false;
  GOST3410KeyGenerationParameters param;
  SecureRandom random = null;
  int strength = 1024;
  
  public KeyPairGeneratorSpi()
  {
    super("GOST3410");
  }
  
  private void init(GOST3410ParameterSpec paramGOST3410ParameterSpec, SecureRandom paramSecureRandom)
  {
    GOST3410PublicKeyParameterSetSpec localGOST3410PublicKeyParameterSetSpec = paramGOST3410ParameterSpec.getPublicKeyParameters();
    paramSecureRandom = new GOST3410KeyGenerationParameters(paramSecureRandom, new GOST3410Parameters(localGOST3410PublicKeyParameterSetSpec.getP(), localGOST3410PublicKeyParameterSetSpec.getQ(), localGOST3410PublicKeyParameterSetSpec.getA()));
    this.param = paramSecureRandom;
    this.engine.init(paramSecureRandom);
    this.initialised = true;
    this.gost3410Params = paramGOST3410ParameterSpec;
  }
  
  public KeyPair generateKeyPair()
  {
    if (!this.initialised) {
      init(new GOST3410ParameterSpec(CryptoProObjectIdentifiers.gostR3410_94_CryptoPro_A.getId()), new SecureRandom());
    }
    Object localObject = this.engine.generateKeyPair();
    GOST3410PublicKeyParameters localGOST3410PublicKeyParameters = (GOST3410PublicKeyParameters)((AsymmetricCipherKeyPair)localObject).getPublic();
    localObject = (GOST3410PrivateKeyParameters)((AsymmetricCipherKeyPair)localObject).getPrivate();
    return new KeyPair(new BCGOST3410PublicKey(localGOST3410PublicKeyParameters, this.gost3410Params), new BCGOST3410PrivateKey((GOST3410PrivateKeyParameters)localObject, this.gost3410Params));
  }
  
  public void initialize(int paramInt, SecureRandom paramSecureRandom)
  {
    this.strength = paramInt;
    this.random = paramSecureRandom;
  }
  
  public void initialize(AlgorithmParameterSpec paramAlgorithmParameterSpec, SecureRandom paramSecureRandom)
    throws InvalidAlgorithmParameterException
  {
    if ((paramAlgorithmParameterSpec instanceof GOST3410ParameterSpec))
    {
      init((GOST3410ParameterSpec)paramAlgorithmParameterSpec, paramSecureRandom);
      return;
    }
    throw new InvalidAlgorithmParameterException("parameter object not a GOST3410ParameterSpec");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\asymmetric\gost\KeyPairGeneratorSpi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */