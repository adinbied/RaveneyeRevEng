package org.bouncycastle.jcajce.provider.asymmetric.ecgost;

import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.ECGenParameterSpec;
import org.bouncycastle.asn1.cryptopro.ECGOST3410NamedCurves;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.generators.ECKeyPairGenerator;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECKeyGenerationParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.jcajce.provider.asymmetric.util.EC5Util;
import org.bouncycastle.jcajce.provider.config.ProviderConfiguration;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.spec.ECNamedCurveGenParameterSpec;
import org.bouncycastle.jce.spec.ECNamedCurveSpec;
import org.bouncycastle.math.ec.ECCurve;

public class KeyPairGeneratorSpi
  extends KeyPairGenerator
{
  String algorithm = "ECGOST3410";
  Object ecParams = null;
  ECKeyPairGenerator engine = new ECKeyPairGenerator();
  boolean initialised = false;
  ECKeyGenerationParameters param;
  SecureRandom random = null;
  int strength = 239;
  
  public KeyPairGeneratorSpi()
  {
    super("ECGOST3410");
  }
  
  public KeyPair generateKeyPair()
  {
    if (this.initialised)
    {
      Object localObject1 = this.engine.generateKeyPair();
      Object localObject2 = (ECPublicKeyParameters)((AsymmetricCipherKeyPair)localObject1).getPublic();
      localObject1 = (ECPrivateKeyParameters)((AsymmetricCipherKeyPair)localObject1).getPrivate();
      Object localObject3 = this.ecParams;
      if ((localObject3 instanceof org.bouncycastle.jce.spec.ECParameterSpec))
      {
        localObject3 = (org.bouncycastle.jce.spec.ECParameterSpec)localObject3;
        localObject2 = new BCECGOST3410PublicKey(this.algorithm, (ECPublicKeyParameters)localObject2, (org.bouncycastle.jce.spec.ECParameterSpec)localObject3);
        return new KeyPair((PublicKey)localObject2, new BCECGOST3410PrivateKey(this.algorithm, (ECPrivateKeyParameters)localObject1, (BCECGOST3410PublicKey)localObject2, (org.bouncycastle.jce.spec.ECParameterSpec)localObject3));
      }
      if (localObject3 == null) {
        return new KeyPair(new BCECGOST3410PublicKey(this.algorithm, (ECPublicKeyParameters)localObject2), new BCECGOST3410PrivateKey(this.algorithm, (ECPrivateKeyParameters)localObject1));
      }
      localObject3 = (java.security.spec.ECParameterSpec)localObject3;
      localObject2 = new BCECGOST3410PublicKey(this.algorithm, (ECPublicKeyParameters)localObject2, (java.security.spec.ECParameterSpec)localObject3);
      return new KeyPair((PublicKey)localObject2, new BCECGOST3410PrivateKey(this.algorithm, (ECPrivateKeyParameters)localObject1, (BCECGOST3410PublicKey)localObject2, (java.security.spec.ECParameterSpec)localObject3));
    }
    throw new IllegalStateException("EC Key Pair Generator not initialised");
  }
  
  public void initialize(int paramInt, SecureRandom paramSecureRandom)
  {
    this.strength = paramInt;
    this.random = paramSecureRandom;
    Object localObject = this.ecParams;
    if (localObject != null) {}
    try
    {
      initialize((ECGenParameterSpec)localObject, paramSecureRandom);
      return;
    }
    catch (InvalidAlgorithmParameterException paramSecureRandom)
    {
      for (;;) {}
    }
    throw new InvalidParameterException("key size not configurable.");
    throw new InvalidParameterException("unknown key size.");
  }
  
  public void initialize(AlgorithmParameterSpec paramAlgorithmParameterSpec, SecureRandom paramSecureRandom)
    throws InvalidAlgorithmParameterException
  {
    Object localObject;
    if ((paramAlgorithmParameterSpec instanceof org.bouncycastle.jce.spec.ECParameterSpec))
    {
      localObject = (org.bouncycastle.jce.spec.ECParameterSpec)paramAlgorithmParameterSpec;
      this.ecParams = paramAlgorithmParameterSpec;
      paramAlgorithmParameterSpec = new ECKeyGenerationParameters(new ECDomainParameters(((org.bouncycastle.jce.spec.ECParameterSpec)localObject).getCurve(), ((org.bouncycastle.jce.spec.ECParameterSpec)localObject).getG(), ((org.bouncycastle.jce.spec.ECParameterSpec)localObject).getN(), ((org.bouncycastle.jce.spec.ECParameterSpec)localObject).getH()), paramSecureRandom);
      this.param = paramAlgorithmParameterSpec;
      this.engine.init(paramAlgorithmParameterSpec);
      label67:
      this.initialised = true;
      return;
    }
    if ((paramAlgorithmParameterSpec instanceof java.security.spec.ECParameterSpec))
    {
      localObject = (java.security.spec.ECParameterSpec)paramAlgorithmParameterSpec;
      this.ecParams = paramAlgorithmParameterSpec;
      paramAlgorithmParameterSpec = EC5Util.convertCurve(((java.security.spec.ECParameterSpec)localObject).getCurve());
    }
    for (paramAlgorithmParameterSpec = new ECKeyGenerationParameters(new ECDomainParameters(paramAlgorithmParameterSpec, EC5Util.convertPoint(paramAlgorithmParameterSpec, ((java.security.spec.ECParameterSpec)localObject).getGenerator(), false), ((java.security.spec.ECParameterSpec)localObject).getOrder(), BigInteger.valueOf(((java.security.spec.ECParameterSpec)localObject).getCofactor())), paramSecureRandom);; paramAlgorithmParameterSpec = new ECKeyGenerationParameters(new ECDomainParameters((ECCurve)localObject, EC5Util.convertPoint((ECCurve)localObject, paramAlgorithmParameterSpec.getGenerator(), false), paramAlgorithmParameterSpec.getOrder(), BigInteger.valueOf(paramAlgorithmParameterSpec.getCofactor())), paramSecureRandom))
    {
      this.param = paramAlgorithmParameterSpec;
      this.engine.init(paramAlgorithmParameterSpec);
      break label67;
      boolean bool = paramAlgorithmParameterSpec instanceof ECGenParameterSpec;
      if ((!bool) && (!(paramAlgorithmParameterSpec instanceof ECNamedCurveGenParameterSpec)))
      {
        if ((paramAlgorithmParameterSpec == null) && (BouncyCastleProvider.CONFIGURATION.getEcImplicitlyCa() != null))
        {
          localObject = BouncyCastleProvider.CONFIGURATION.getEcImplicitlyCa();
          this.ecParams = paramAlgorithmParameterSpec;
          paramAlgorithmParameterSpec = new ECKeyGenerationParameters(new ECDomainParameters(((org.bouncycastle.jce.spec.ECParameterSpec)localObject).getCurve(), ((org.bouncycastle.jce.spec.ECParameterSpec)localObject).getG(), ((org.bouncycastle.jce.spec.ECParameterSpec)localObject).getN(), ((org.bouncycastle.jce.spec.ECParameterSpec)localObject).getH()), paramSecureRandom);
          break;
        }
        if ((paramAlgorithmParameterSpec == null) && (BouncyCastleProvider.CONFIGURATION.getEcImplicitlyCa() == null)) {
          throw new InvalidAlgorithmParameterException("null parameter passed but no implicitCA set");
        }
        paramSecureRandom = new StringBuilder();
        paramSecureRandom.append("parameter object not a ECParameterSpec: ");
        paramSecureRandom.append(paramAlgorithmParameterSpec.getClass().getName());
        throw new InvalidAlgorithmParameterException(paramSecureRandom.toString());
      }
      if (bool) {
        paramAlgorithmParameterSpec = ((ECGenParameterSpec)paramAlgorithmParameterSpec).getName();
      } else {
        paramAlgorithmParameterSpec = ((ECNamedCurveGenParameterSpec)paramAlgorithmParameterSpec).getName();
      }
      localObject = ECGOST3410NamedCurves.getByName(paramAlgorithmParameterSpec);
      if (localObject == null) {
        break label439;
      }
      paramAlgorithmParameterSpec = new ECNamedCurveSpec(paramAlgorithmParameterSpec, ((ECDomainParameters)localObject).getCurve(), ((ECDomainParameters)localObject).getG(), ((ECDomainParameters)localObject).getN(), ((ECDomainParameters)localObject).getH(), ((ECDomainParameters)localObject).getSeed());
      this.ecParams = paramAlgorithmParameterSpec;
      paramAlgorithmParameterSpec = (java.security.spec.ECParameterSpec)paramAlgorithmParameterSpec;
      localObject = EC5Util.convertCurve(paramAlgorithmParameterSpec.getCurve());
    }
    label439:
    paramSecureRandom = new StringBuilder();
    paramSecureRandom.append("unknown curve name: ");
    paramSecureRandom.append(paramAlgorithmParameterSpec);
    throw new InvalidAlgorithmParameterException(paramSecureRandom.toString());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\asymmetric\ecgost\KeyPairGeneratorSpi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */