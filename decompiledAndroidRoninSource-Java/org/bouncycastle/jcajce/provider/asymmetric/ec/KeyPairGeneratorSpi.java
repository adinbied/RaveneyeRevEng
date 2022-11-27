package org.bouncycastle.jcajce.provider.asymmetric.ec;

import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.ECGenParameterSpec;
import java.util.Hashtable;
import java.util.Map;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.x9.ECNamedCurveTable;
import org.bouncycastle.asn1.x9.X9ECParameters;
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
import org.bouncycastle.util.Integers;

public abstract class KeyPairGeneratorSpi
  extends KeyPairGenerator
{
  public KeyPairGeneratorSpi(String paramString)
  {
    super(paramString);
  }
  
  public static class EC
    extends KeyPairGeneratorSpi
  {
    private static Hashtable ecParameters;
    String algorithm;
    int certainty = 50;
    ProviderConfiguration configuration;
    Object ecParams = null;
    ECKeyPairGenerator engine = new ECKeyPairGenerator();
    boolean initialised = false;
    ECKeyGenerationParameters param;
    SecureRandom random = new SecureRandom();
    int strength = 239;
    
    static
    {
      Hashtable localHashtable = new Hashtable();
      ecParameters = localHashtable;
      localHashtable.put(Integers.valueOf(192), new ECGenParameterSpec("prime192v1"));
      ecParameters.put(Integers.valueOf(239), new ECGenParameterSpec("prime239v1"));
      ecParameters.put(Integers.valueOf(256), new ECGenParameterSpec("prime256v1"));
      ecParameters.put(Integers.valueOf(224), new ECGenParameterSpec("P-224"));
      ecParameters.put(Integers.valueOf(384), new ECGenParameterSpec("P-384"));
      ecParameters.put(Integers.valueOf(521), new ECGenParameterSpec("P-521"));
    }
    
    public EC()
    {
      super();
      this.algorithm = "EC";
      this.configuration = BouncyCastleProvider.CONFIGURATION;
    }
    
    public EC(String paramString, ProviderConfiguration paramProviderConfiguration)
    {
      super();
      this.algorithm = paramString;
      this.configuration = paramProviderConfiguration;
    }
    
    protected ECKeyGenerationParameters createKeyGenParamsBC(org.bouncycastle.jce.spec.ECParameterSpec paramECParameterSpec, SecureRandom paramSecureRandom)
    {
      return new ECKeyGenerationParameters(new ECDomainParameters(paramECParameterSpec.getCurve(), paramECParameterSpec.getG(), paramECParameterSpec.getN(), paramECParameterSpec.getH()), paramSecureRandom);
    }
    
    protected ECKeyGenerationParameters createKeyGenParamsJCE(java.security.spec.ECParameterSpec paramECParameterSpec, SecureRandom paramSecureRandom)
    {
      ECCurve localECCurve = EC5Util.convertCurve(paramECParameterSpec.getCurve());
      return new ECKeyGenerationParameters(new ECDomainParameters(localECCurve, EC5Util.convertPoint(localECCurve, paramECParameterSpec.getGenerator(), false), paramECParameterSpec.getOrder(), BigInteger.valueOf(paramECParameterSpec.getCofactor())), paramSecureRandom);
    }
    
    protected ECNamedCurveSpec createNamedCurveSpec(String paramString)
      throws InvalidAlgorithmParameterException
    {
      X9ECParameters localX9ECParameters = ECUtils.getDomainParametersFromName(paramString);
      Object localObject = localX9ECParameters;
      if (localX9ECParameters == null) {}
      try
      {
        localX9ECParameters = ECNamedCurveTable.getByOID(new ASN1ObjectIdentifier(paramString));
        localObject = localX9ECParameters;
        if (localX9ECParameters != null) {
          break label128;
        }
        localObject = (X9ECParameters)this.configuration.getAdditionalECParameters().get(new ASN1ObjectIdentifier(paramString));
        if (localObject != null) {
          break label128;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("unknown curve OID: ");
        ((StringBuilder)localObject).append(paramString);
        throw new InvalidAlgorithmParameterException(((StringBuilder)localObject).toString());
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        for (;;) {}
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("unknown curve name: ");
      ((StringBuilder)localObject).append(paramString);
      throw new InvalidAlgorithmParameterException(((StringBuilder)localObject).toString());
      label128:
      return new ECNamedCurveSpec(paramString, ((X9ECParameters)localObject).getCurve(), ((X9ECParameters)localObject).getG(), ((X9ECParameters)localObject).getN(), ((X9ECParameters)localObject).getH(), null);
    }
    
    public KeyPair generateKeyPair()
    {
      if (!this.initialised) {
        initialize(this.strength, new SecureRandom());
      }
      Object localObject1 = this.engine.generateKeyPair();
      Object localObject2 = (ECPublicKeyParameters)((AsymmetricCipherKeyPair)localObject1).getPublic();
      localObject1 = (ECPrivateKeyParameters)((AsymmetricCipherKeyPair)localObject1).getPrivate();
      Object localObject3 = this.ecParams;
      if ((localObject3 instanceof org.bouncycastle.jce.spec.ECParameterSpec))
      {
        localObject3 = (org.bouncycastle.jce.spec.ECParameterSpec)localObject3;
        localObject2 = new BCECPublicKey(this.algorithm, (ECPublicKeyParameters)localObject2, (org.bouncycastle.jce.spec.ECParameterSpec)localObject3, this.configuration);
        return new KeyPair((PublicKey)localObject2, new BCECPrivateKey(this.algorithm, (ECPrivateKeyParameters)localObject1, (BCECPublicKey)localObject2, (org.bouncycastle.jce.spec.ECParameterSpec)localObject3, this.configuration));
      }
      if (localObject3 == null) {
        return new KeyPair(new BCECPublicKey(this.algorithm, (ECPublicKeyParameters)localObject2, this.configuration), new BCECPrivateKey(this.algorithm, (ECPrivateKeyParameters)localObject1, this.configuration));
      }
      localObject3 = (java.security.spec.ECParameterSpec)localObject3;
      localObject2 = new BCECPublicKey(this.algorithm, (ECPublicKeyParameters)localObject2, (java.security.spec.ECParameterSpec)localObject3, this.configuration);
      return new KeyPair((PublicKey)localObject2, new BCECPrivateKey(this.algorithm, (ECPrivateKeyParameters)localObject1, (BCECPublicKey)localObject2, (java.security.spec.ECParameterSpec)localObject3, this.configuration));
    }
    
    public void initialize(int paramInt, SecureRandom paramSecureRandom)
    {
      this.strength = paramInt;
      this.random = paramSecureRandom;
      ECGenParameterSpec localECGenParameterSpec = (ECGenParameterSpec)ecParameters.get(Integers.valueOf(paramInt));
      if (localECGenParameterSpec != null) {}
      try
      {
        initialize(localECGenParameterSpec, paramSecureRandom);
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
      if (paramAlgorithmParameterSpec == null)
      {
        paramAlgorithmParameterSpec = this.configuration.getEcImplicitlyCa();
        if (paramAlgorithmParameterSpec != null) {
          this.ecParams = null;
        } else {
          throw new InvalidAlgorithmParameterException("null parameter passed but no implicitCA set");
        }
      }
      else
      {
        if (!(paramAlgorithmParameterSpec instanceof org.bouncycastle.jce.spec.ECParameterSpec)) {
          break label69;
        }
        this.ecParams = paramAlgorithmParameterSpec;
        paramAlgorithmParameterSpec = (org.bouncycastle.jce.spec.ECParameterSpec)paramAlgorithmParameterSpec;
      }
      for (paramAlgorithmParameterSpec = createKeyGenParamsBC(paramAlgorithmParameterSpec, paramSecureRandom);; paramAlgorithmParameterSpec = createKeyGenParamsJCE((java.security.spec.ECParameterSpec)paramAlgorithmParameterSpec, paramSecureRandom))
      {
        this.param = paramAlgorithmParameterSpec;
        break label136;
        label69:
        if (!(paramAlgorithmParameterSpec instanceof java.security.spec.ECParameterSpec)) {
          break;
        }
        this.ecParams = paramAlgorithmParameterSpec;
      }
      if ((paramAlgorithmParameterSpec instanceof ECGenParameterSpec)) {}
      for (paramAlgorithmParameterSpec = ((ECGenParameterSpec)paramAlgorithmParameterSpec).getName();; paramAlgorithmParameterSpec = ((ECNamedCurveGenParameterSpec)paramAlgorithmParameterSpec).getName())
      {
        initializeNamedCurve(paramAlgorithmParameterSpec, paramSecureRandom);
        break;
        if (!(paramAlgorithmParameterSpec instanceof ECNamedCurveGenParameterSpec)) {
          break label153;
        }
      }
      label136:
      this.engine.init(this.param);
      this.initialised = true;
      return;
      label153:
      throw new InvalidAlgorithmParameterException("parameter object not a ECParameterSpec");
    }
    
    protected void initializeNamedCurve(String paramString, SecureRandom paramSecureRandom)
      throws InvalidAlgorithmParameterException
    {
      paramString = createNamedCurveSpec(paramString);
      this.ecParams = paramString;
      this.param = createKeyGenParamsJCE(paramString, paramSecureRandom);
    }
  }
  
  public static class ECDH
    extends KeyPairGeneratorSpi.EC
  {
    public ECDH()
    {
      super(BouncyCastleProvider.CONFIGURATION);
    }
  }
  
  public static class ECDHC
    extends KeyPairGeneratorSpi.EC
  {
    public ECDHC()
    {
      super(BouncyCastleProvider.CONFIGURATION);
    }
  }
  
  public static class ECDSA
    extends KeyPairGeneratorSpi.EC
  {
    public ECDSA()
    {
      super(BouncyCastleProvider.CONFIGURATION);
    }
  }
  
  public static class ECMQV
    extends KeyPairGeneratorSpi.EC
  {
    public ECMQV()
    {
      super(BouncyCastleProvider.CONFIGURATION);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\asymmetric\ec\KeyPairGeneratorSpi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */