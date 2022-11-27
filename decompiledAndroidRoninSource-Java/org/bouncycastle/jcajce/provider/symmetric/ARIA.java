package org.bouncycastle.jcajce.provider.symmetric;

import java.io.IOException;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import javax.crypto.spec.IvParameterSpec;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.cms.CCMParameters;
import org.bouncycastle.asn1.cms.GCMParameters;
import org.bouncycastle.asn1.nsri.NSRIObjectIdentifiers;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.CipherKeyGenerator;
import org.bouncycastle.crypto.engines.ARIAEngine;
import org.bouncycastle.crypto.engines.ARIAWrapEngine;
import org.bouncycastle.crypto.engines.ARIAWrapPadEngine;
import org.bouncycastle.crypto.engines.RFC3211WrapEngine;
import org.bouncycastle.crypto.generators.Poly1305KeyGenerator;
import org.bouncycastle.crypto.macs.GMac;
import org.bouncycastle.crypto.macs.Poly1305;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.crypto.modes.CFBBlockCipher;
import org.bouncycastle.crypto.modes.GCMBlockCipher;
import org.bouncycastle.crypto.modes.OFBBlockCipher;
import org.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameterGenerator;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameters;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseMac;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseWrapCipher;
import org.bouncycastle.jcajce.provider.symmetric.util.BlockCipherProvider;
import org.bouncycastle.jcajce.provider.symmetric.util.IvAlgorithmParameters;
import org.bouncycastle.jcajce.spec.AEADParameterSpec;

public final class ARIA
{
  public static class AlgParamGen
    extends BaseAlgorithmParameterGenerator
  {
    protected AlgorithmParameters engineGenerateParameters()
    {
      byte[] arrayOfByte = new byte[16];
      if (this.random == null) {
        this.random = new SecureRandom();
      }
      this.random.nextBytes(arrayOfByte);
      try
      {
        AlgorithmParameters localAlgorithmParameters = createParametersInstance("ARIA");
        localAlgorithmParameters.init(new IvParameterSpec(arrayOfByte));
        return localAlgorithmParameters;
      }
      catch (Exception localException)
      {
        throw new RuntimeException(localException.getMessage());
      }
    }
    
    protected void engineInit(AlgorithmParameterSpec paramAlgorithmParameterSpec, SecureRandom paramSecureRandom)
      throws InvalidAlgorithmParameterException
    {
      throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for ARIA parameter generation.");
    }
  }
  
  public static class AlgParams
    extends IvAlgorithmParameters
  {
    protected String engineToString()
    {
      return "ARIA IV";
    }
  }
  
  public static class AlgParamsCCM
    extends BaseAlgorithmParameters
  {
    private CCMParameters ccmParams;
    
    protected byte[] engineGetEncoded()
      throws IOException
    {
      return this.ccmParams.getEncoded();
    }
    
    protected byte[] engineGetEncoded(String paramString)
      throws IOException
    {
      if (isASN1FormatString(paramString)) {
        return this.ccmParams.getEncoded();
      }
      throw new IOException("unknown format specified");
    }
    
    protected void engineInit(AlgorithmParameterSpec paramAlgorithmParameterSpec)
      throws InvalidParameterSpecException
    {
      if (GcmSpecUtil.isGcmSpec(paramAlgorithmParameterSpec))
      {
        this.ccmParams = CCMParameters.getInstance(GcmSpecUtil.extractGcmParameters(paramAlgorithmParameterSpec));
        return;
      }
      if ((paramAlgorithmParameterSpec instanceof AEADParameterSpec))
      {
        paramAlgorithmParameterSpec = (AEADParameterSpec)paramAlgorithmParameterSpec;
        this.ccmParams = new CCMParameters(paramAlgorithmParameterSpec.getNonce(), paramAlgorithmParameterSpec.getMacSizeInBits() / 8);
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("AlgorithmParameterSpec class not recognized: ");
      localStringBuilder.append(paramAlgorithmParameterSpec.getClass().getName());
      throw new InvalidParameterSpecException(localStringBuilder.toString());
    }
    
    protected void engineInit(byte[] paramArrayOfByte)
      throws IOException
    {
      this.ccmParams = CCMParameters.getInstance(paramArrayOfByte);
    }
    
    protected void engineInit(byte[] paramArrayOfByte, String paramString)
      throws IOException
    {
      if (isASN1FormatString(paramString))
      {
        this.ccmParams = CCMParameters.getInstance(paramArrayOfByte);
        return;
      }
      throw new IOException("unknown format specified");
    }
    
    protected String engineToString()
    {
      return "CCM";
    }
    
    protected AlgorithmParameterSpec localEngineGetParameterSpec(Class paramClass)
      throws InvalidParameterSpecException
    {
      if ((paramClass != AlgorithmParameterSpec.class) && (!GcmSpecUtil.isGcmSpec(paramClass)))
      {
        if (paramClass == AEADParameterSpec.class) {
          return new AEADParameterSpec(this.ccmParams.getNonce(), this.ccmParams.getIcvLen() * 8);
        }
        if (paramClass == IvParameterSpec.class) {
          return new IvParameterSpec(this.ccmParams.getNonce());
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("AlgorithmParameterSpec not recognized: ");
        localStringBuilder.append(paramClass.getName());
        throw new InvalidParameterSpecException(localStringBuilder.toString());
      }
      if (GcmSpecUtil.gcmSpecExists()) {
        return GcmSpecUtil.extractGcmSpec(this.ccmParams.toASN1Primitive());
      }
      return new AEADParameterSpec(this.ccmParams.getNonce(), this.ccmParams.getIcvLen() * 8);
    }
  }
  
  public static class AlgParamsGCM
    extends BaseAlgorithmParameters
  {
    private GCMParameters gcmParams;
    
    protected byte[] engineGetEncoded()
      throws IOException
    {
      return this.gcmParams.getEncoded();
    }
    
    protected byte[] engineGetEncoded(String paramString)
      throws IOException
    {
      if (isASN1FormatString(paramString)) {
        return this.gcmParams.getEncoded();
      }
      throw new IOException("unknown format specified");
    }
    
    protected void engineInit(AlgorithmParameterSpec paramAlgorithmParameterSpec)
      throws InvalidParameterSpecException
    {
      if (GcmSpecUtil.isGcmSpec(paramAlgorithmParameterSpec))
      {
        this.gcmParams = GcmSpecUtil.extractGcmParameters(paramAlgorithmParameterSpec);
        return;
      }
      if ((paramAlgorithmParameterSpec instanceof AEADParameterSpec))
      {
        paramAlgorithmParameterSpec = (AEADParameterSpec)paramAlgorithmParameterSpec;
        this.gcmParams = new GCMParameters(paramAlgorithmParameterSpec.getNonce(), paramAlgorithmParameterSpec.getMacSizeInBits() / 8);
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("AlgorithmParameterSpec class not recognized: ");
      localStringBuilder.append(paramAlgorithmParameterSpec.getClass().getName());
      throw new InvalidParameterSpecException(localStringBuilder.toString());
    }
    
    protected void engineInit(byte[] paramArrayOfByte)
      throws IOException
    {
      this.gcmParams = GCMParameters.getInstance(paramArrayOfByte);
    }
    
    protected void engineInit(byte[] paramArrayOfByte, String paramString)
      throws IOException
    {
      if (isASN1FormatString(paramString))
      {
        this.gcmParams = GCMParameters.getInstance(paramArrayOfByte);
        return;
      }
      throw new IOException("unknown format specified");
    }
    
    protected String engineToString()
    {
      return "GCM";
    }
    
    protected AlgorithmParameterSpec localEngineGetParameterSpec(Class paramClass)
      throws InvalidParameterSpecException
    {
      if ((paramClass != AlgorithmParameterSpec.class) && (!GcmSpecUtil.isGcmSpec(paramClass)))
      {
        if (paramClass == AEADParameterSpec.class) {
          return new AEADParameterSpec(this.gcmParams.getNonce(), this.gcmParams.getIcvLen() * 8);
        }
        if (paramClass == IvParameterSpec.class) {
          return new IvParameterSpec(this.gcmParams.getNonce());
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("AlgorithmParameterSpec not recognized: ");
        localStringBuilder.append(paramClass.getName());
        throw new InvalidParameterSpecException(localStringBuilder.toString());
      }
      if (GcmSpecUtil.gcmSpecExists()) {
        return GcmSpecUtil.extractGcmSpec(this.gcmParams.toASN1Primitive());
      }
      return new AEADParameterSpec(this.gcmParams.getNonce(), this.gcmParams.getIcvLen() * 8);
    }
  }
  
  public static class CBC
    extends BaseBlockCipher
  {
    public CBC()
    {
      super(128);
    }
  }
  
  public static class CFB
    extends BaseBlockCipher
  {
    public CFB()
    {
      super(128);
    }
  }
  
  public static class ECB
    extends BaseBlockCipher
  {
    public ECB()
    {
      super()
      {
        public BlockCipher get()
        {
          return new ARIAEngine();
        }
      };
    }
  }
  
  public static class GMAC
    extends BaseMac
  {
    public GMAC()
    {
      super();
    }
  }
  
  public static class KeyGen
    extends BaseKeyGenerator
  {
    public KeyGen()
    {
      this(256);
    }
    
    public KeyGen(int paramInt)
    {
      super(paramInt, new CipherKeyGenerator());
    }
  }
  
  public static class KeyGen128
    extends ARIA.KeyGen
  {
    public KeyGen128()
    {
      super();
    }
  }
  
  public static class KeyGen192
    extends ARIA.KeyGen
  {
    public KeyGen192()
    {
      super();
    }
  }
  
  public static class KeyGen256
    extends ARIA.KeyGen
  {
    public KeyGen256()
    {
      super();
    }
  }
  
  public static class Mappings
    extends SymmetricAlgorithmProvider
  {
    private static final String PREFIX = ARIA.class.getName();
    
    public void configure(ConfigurableProvider paramConfigurableProvider)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$AlgParams");
      paramConfigurableProvider.addAlgorithm("AlgorithmParameters.ARIA", ((StringBuilder)localObject).toString());
      paramConfigurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters", NSRIObjectIdentifiers.id_aria128_cbc, "ARIA");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters", NSRIObjectIdentifiers.id_aria192_cbc, "ARIA");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters", NSRIObjectIdentifiers.id_aria256_cbc, "ARIA");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$AlgParamGen");
      paramConfigurableProvider.addAlgorithm("AlgorithmParameterGenerator.ARIA", ((StringBuilder)localObject).toString());
      paramConfigurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameterGenerator", NSRIObjectIdentifiers.id_aria128_cbc, "ARIA");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameterGenerator", NSRIObjectIdentifiers.id_aria192_cbc, "ARIA");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameterGenerator", NSRIObjectIdentifiers.id_aria256_cbc, "ARIA");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameterGenerator", NSRIObjectIdentifiers.id_aria128_ofb, "ARIA");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameterGenerator", NSRIObjectIdentifiers.id_aria192_ofb, "ARIA");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameterGenerator", NSRIObjectIdentifiers.id_aria256_ofb, "ARIA");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameterGenerator", NSRIObjectIdentifiers.id_aria128_cfb, "ARIA");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameterGenerator", NSRIObjectIdentifiers.id_aria192_cfb, "ARIA");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameterGenerator", NSRIObjectIdentifiers.id_aria256_cfb, "ARIA");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$ECB");
      paramConfigurableProvider.addAlgorithm("Cipher.ARIA", ((StringBuilder)localObject).toString());
      localObject = NSRIObjectIdentifiers.id_aria128_ecb;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$ECB");
      paramConfigurableProvider.addAlgorithm("Cipher", (ASN1ObjectIdentifier)localObject, localStringBuilder.toString());
      localObject = NSRIObjectIdentifiers.id_aria192_ecb;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$ECB");
      paramConfigurableProvider.addAlgorithm("Cipher", (ASN1ObjectIdentifier)localObject, localStringBuilder.toString());
      localObject = NSRIObjectIdentifiers.id_aria256_ecb;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$ECB");
      paramConfigurableProvider.addAlgorithm("Cipher", (ASN1ObjectIdentifier)localObject, localStringBuilder.toString());
      localObject = NSRIObjectIdentifiers.id_aria128_cbc;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$CBC");
      paramConfigurableProvider.addAlgorithm("Cipher", (ASN1ObjectIdentifier)localObject, localStringBuilder.toString());
      localObject = NSRIObjectIdentifiers.id_aria192_cbc;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$CBC");
      paramConfigurableProvider.addAlgorithm("Cipher", (ASN1ObjectIdentifier)localObject, localStringBuilder.toString());
      localObject = NSRIObjectIdentifiers.id_aria256_cbc;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$CBC");
      paramConfigurableProvider.addAlgorithm("Cipher", (ASN1ObjectIdentifier)localObject, localStringBuilder.toString());
      localObject = NSRIObjectIdentifiers.id_aria128_cfb;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$CFB");
      paramConfigurableProvider.addAlgorithm("Cipher", (ASN1ObjectIdentifier)localObject, localStringBuilder.toString());
      localObject = NSRIObjectIdentifiers.id_aria192_cfb;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$CFB");
      paramConfigurableProvider.addAlgorithm("Cipher", (ASN1ObjectIdentifier)localObject, localStringBuilder.toString());
      localObject = NSRIObjectIdentifiers.id_aria256_cfb;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$CFB");
      paramConfigurableProvider.addAlgorithm("Cipher", (ASN1ObjectIdentifier)localObject, localStringBuilder.toString());
      localObject = NSRIObjectIdentifiers.id_aria128_ofb;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$OFB");
      paramConfigurableProvider.addAlgorithm("Cipher", (ASN1ObjectIdentifier)localObject, localStringBuilder.toString());
      localObject = NSRIObjectIdentifiers.id_aria192_ofb;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$OFB");
      paramConfigurableProvider.addAlgorithm("Cipher", (ASN1ObjectIdentifier)localObject, localStringBuilder.toString());
      localObject = NSRIObjectIdentifiers.id_aria256_ofb;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$OFB");
      paramConfigurableProvider.addAlgorithm("Cipher", (ASN1ObjectIdentifier)localObject, localStringBuilder.toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$RFC3211Wrap");
      paramConfigurableProvider.addAlgorithm("Cipher.ARIARFC3211WRAP", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$Wrap");
      paramConfigurableProvider.addAlgorithm("Cipher.ARIAWRAP", ((StringBuilder)localObject).toString());
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher", NSRIObjectIdentifiers.id_aria128_kw, "ARIAWRAP");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher", NSRIObjectIdentifiers.id_aria192_kw, "ARIAWRAP");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher", NSRIObjectIdentifiers.id_aria256_kw, "ARIAWRAP");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher.ARIAKW", "ARIAWRAP");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$WrapPad");
      paramConfigurableProvider.addAlgorithm("Cipher.ARIAWRAPPAD", ((StringBuilder)localObject).toString());
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher", NSRIObjectIdentifiers.id_aria128_kwp, "ARIAWRAPPAD");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher", NSRIObjectIdentifiers.id_aria192_kwp, "ARIAWRAPPAD");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher", NSRIObjectIdentifiers.id_aria256_kwp, "ARIAWRAPPAD");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher.ARIAKWP", "ARIAWRAPPAD");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$KeyGen");
      paramConfigurableProvider.addAlgorithm("KeyGenerator.ARIA", ((StringBuilder)localObject).toString());
      localObject = NSRIObjectIdentifiers.id_aria128_kw;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$KeyGen128");
      paramConfigurableProvider.addAlgorithm("KeyGenerator", (ASN1ObjectIdentifier)localObject, localStringBuilder.toString());
      localObject = NSRIObjectIdentifiers.id_aria192_kw;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$KeyGen192");
      paramConfigurableProvider.addAlgorithm("KeyGenerator", (ASN1ObjectIdentifier)localObject, localStringBuilder.toString());
      localObject = NSRIObjectIdentifiers.id_aria256_kw;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$KeyGen256");
      paramConfigurableProvider.addAlgorithm("KeyGenerator", (ASN1ObjectIdentifier)localObject, localStringBuilder.toString());
      localObject = NSRIObjectIdentifiers.id_aria128_kwp;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$KeyGen128");
      paramConfigurableProvider.addAlgorithm("KeyGenerator", (ASN1ObjectIdentifier)localObject, localStringBuilder.toString());
      localObject = NSRIObjectIdentifiers.id_aria192_kwp;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$KeyGen192");
      paramConfigurableProvider.addAlgorithm("KeyGenerator", (ASN1ObjectIdentifier)localObject, localStringBuilder.toString());
      localObject = NSRIObjectIdentifiers.id_aria256_kwp;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$KeyGen256");
      paramConfigurableProvider.addAlgorithm("KeyGenerator", (ASN1ObjectIdentifier)localObject, localStringBuilder.toString());
      localObject = NSRIObjectIdentifiers.id_aria128_ecb;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$KeyGen128");
      paramConfigurableProvider.addAlgorithm("KeyGenerator", (ASN1ObjectIdentifier)localObject, localStringBuilder.toString());
      localObject = NSRIObjectIdentifiers.id_aria192_ecb;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$KeyGen192");
      paramConfigurableProvider.addAlgorithm("KeyGenerator", (ASN1ObjectIdentifier)localObject, localStringBuilder.toString());
      localObject = NSRIObjectIdentifiers.id_aria256_ecb;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$KeyGen256");
      paramConfigurableProvider.addAlgorithm("KeyGenerator", (ASN1ObjectIdentifier)localObject, localStringBuilder.toString());
      localObject = NSRIObjectIdentifiers.id_aria128_cbc;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$KeyGen128");
      paramConfigurableProvider.addAlgorithm("KeyGenerator", (ASN1ObjectIdentifier)localObject, localStringBuilder.toString());
      localObject = NSRIObjectIdentifiers.id_aria192_cbc;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$KeyGen192");
      paramConfigurableProvider.addAlgorithm("KeyGenerator", (ASN1ObjectIdentifier)localObject, localStringBuilder.toString());
      localObject = NSRIObjectIdentifiers.id_aria256_cbc;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$KeyGen256");
      paramConfigurableProvider.addAlgorithm("KeyGenerator", (ASN1ObjectIdentifier)localObject, localStringBuilder.toString());
      localObject = NSRIObjectIdentifiers.id_aria128_cfb;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$KeyGen128");
      paramConfigurableProvider.addAlgorithm("KeyGenerator", (ASN1ObjectIdentifier)localObject, localStringBuilder.toString());
      localObject = NSRIObjectIdentifiers.id_aria192_cfb;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$KeyGen192");
      paramConfigurableProvider.addAlgorithm("KeyGenerator", (ASN1ObjectIdentifier)localObject, localStringBuilder.toString());
      localObject = NSRIObjectIdentifiers.id_aria256_cfb;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$KeyGen256");
      paramConfigurableProvider.addAlgorithm("KeyGenerator", (ASN1ObjectIdentifier)localObject, localStringBuilder.toString());
      localObject = NSRIObjectIdentifiers.id_aria128_ofb;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$KeyGen128");
      paramConfigurableProvider.addAlgorithm("KeyGenerator", (ASN1ObjectIdentifier)localObject, localStringBuilder.toString());
      localObject = NSRIObjectIdentifiers.id_aria192_ofb;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$KeyGen192");
      paramConfigurableProvider.addAlgorithm("KeyGenerator", (ASN1ObjectIdentifier)localObject, localStringBuilder.toString());
      localObject = NSRIObjectIdentifiers.id_aria256_ofb;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$KeyGen256");
      paramConfigurableProvider.addAlgorithm("KeyGenerator", (ASN1ObjectIdentifier)localObject, localStringBuilder.toString());
      localObject = NSRIObjectIdentifiers.id_aria128_ccm;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$KeyGen128");
      paramConfigurableProvider.addAlgorithm("KeyGenerator", (ASN1ObjectIdentifier)localObject, localStringBuilder.toString());
      localObject = NSRIObjectIdentifiers.id_aria192_ccm;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$KeyGen192");
      paramConfigurableProvider.addAlgorithm("KeyGenerator", (ASN1ObjectIdentifier)localObject, localStringBuilder.toString());
      localObject = NSRIObjectIdentifiers.id_aria256_ccm;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$KeyGen256");
      paramConfigurableProvider.addAlgorithm("KeyGenerator", (ASN1ObjectIdentifier)localObject, localStringBuilder.toString());
      localObject = NSRIObjectIdentifiers.id_aria128_gcm;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$KeyGen128");
      paramConfigurableProvider.addAlgorithm("KeyGenerator", (ASN1ObjectIdentifier)localObject, localStringBuilder.toString());
      localObject = NSRIObjectIdentifiers.id_aria192_gcm;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$KeyGen192");
      paramConfigurableProvider.addAlgorithm("KeyGenerator", (ASN1ObjectIdentifier)localObject, localStringBuilder.toString());
      localObject = NSRIObjectIdentifiers.id_aria256_gcm;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$KeyGen256");
      paramConfigurableProvider.addAlgorithm("KeyGenerator", (ASN1ObjectIdentifier)localObject, localStringBuilder.toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$AlgParamGenCCM");
      paramConfigurableProvider.addAlgorithm("AlgorithmParameterGenerator.ARIACCM", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Alg.Alias.AlgorithmParameterGenerator.");
      ((StringBuilder)localObject).append(NSRIObjectIdentifiers.id_aria128_ccm);
      paramConfigurableProvider.addAlgorithm(((StringBuilder)localObject).toString(), "CCM");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Alg.Alias.AlgorithmParameterGenerator.");
      ((StringBuilder)localObject).append(NSRIObjectIdentifiers.id_aria192_ccm);
      paramConfigurableProvider.addAlgorithm(((StringBuilder)localObject).toString(), "CCM");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Alg.Alias.AlgorithmParameterGenerator.");
      ((StringBuilder)localObject).append(NSRIObjectIdentifiers.id_aria256_ccm);
      paramConfigurableProvider.addAlgorithm(((StringBuilder)localObject).toString(), "CCM");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher", NSRIObjectIdentifiers.id_aria128_ccm, "CCM");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher", NSRIObjectIdentifiers.id_aria192_ccm, "CCM");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher", NSRIObjectIdentifiers.id_aria256_ccm, "CCM");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$AlgParamGenGCM");
      paramConfigurableProvider.addAlgorithm("AlgorithmParameterGenerator.ARIAGCM", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Alg.Alias.AlgorithmParameterGenerator.");
      ((StringBuilder)localObject).append(NSRIObjectIdentifiers.id_aria128_gcm);
      paramConfigurableProvider.addAlgorithm(((StringBuilder)localObject).toString(), "GCM");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Alg.Alias.AlgorithmParameterGenerator.");
      ((StringBuilder)localObject).append(NSRIObjectIdentifiers.id_aria192_gcm);
      paramConfigurableProvider.addAlgorithm(((StringBuilder)localObject).toString(), "GCM");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Alg.Alias.AlgorithmParameterGenerator.");
      ((StringBuilder)localObject).append(NSRIObjectIdentifiers.id_aria256_gcm);
      paramConfigurableProvider.addAlgorithm(((StringBuilder)localObject).toString(), "GCM");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher", NSRIObjectIdentifiers.id_aria128_gcm, "GCM");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher", NSRIObjectIdentifiers.id_aria192_gcm, "GCM");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher", NSRIObjectIdentifiers.id_aria256_gcm, "GCM");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$GMAC");
      localObject = ((StringBuilder)localObject).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$KeyGen");
      addGMacAlgorithm(paramConfigurableProvider, "ARIA", (String)localObject, localStringBuilder.toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$Poly1305");
      localObject = ((StringBuilder)localObject).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$Poly1305KeyGen");
      addPoly1305Algorithm(paramConfigurableProvider, "ARIA", (String)localObject, localStringBuilder.toString());
    }
  }
  
  public static class OFB
    extends BaseBlockCipher
  {
    public OFB()
    {
      super(128);
    }
  }
  
  public static class Poly1305
    extends BaseMac
  {
    public Poly1305()
    {
      super();
    }
  }
  
  public static class Poly1305KeyGen
    extends BaseKeyGenerator
  {
    public Poly1305KeyGen()
    {
      super(256, new Poly1305KeyGenerator());
    }
  }
  
  public static class RFC3211Wrap
    extends BaseWrapCipher
  {
    public RFC3211Wrap()
    {
      super(16);
    }
  }
  
  public static class Wrap
    extends BaseWrapCipher
  {
    public Wrap()
    {
      super();
    }
  }
  
  public static class WrapPad
    extends BaseWrapCipher
  {
    public WrapPad()
    {
      super();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\symmetric\ARIA.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */