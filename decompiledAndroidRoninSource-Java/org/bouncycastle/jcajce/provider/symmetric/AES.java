package org.bouncycastle.jcajce.provider.symmetric;

import java.io.IOException;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.spec.IvParameterSpec;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.bc.BCObjectIdentifiers;
import org.bouncycastle.asn1.cms.CCMParameters;
import org.bouncycastle.asn1.cms.GCMParameters;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.CipherKeyGenerator;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.engines.AESEngine;
import org.bouncycastle.crypto.engines.AESWrapEngine;
import org.bouncycastle.crypto.engines.AESWrapPadEngine;
import org.bouncycastle.crypto.engines.RFC3211WrapEngine;
import org.bouncycastle.crypto.engines.RFC5649WrapEngine;
import org.bouncycastle.crypto.generators.Poly1305KeyGenerator;
import org.bouncycastle.crypto.macs.CMac;
import org.bouncycastle.crypto.macs.GMac;
import org.bouncycastle.crypto.macs.Poly1305;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.crypto.modes.CCMBlockCipher;
import org.bouncycastle.crypto.modes.CFBBlockCipher;
import org.bouncycastle.crypto.modes.GCMBlockCipher;
import org.bouncycastle.crypto.modes.OFBBlockCipher;
import org.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameterGenerator;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameters;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseMac;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseSecretKeyFactory;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseWrapCipher;
import org.bouncycastle.jcajce.provider.symmetric.util.BlockCipherProvider;
import org.bouncycastle.jcajce.provider.symmetric.util.IvAlgorithmParameters;
import org.bouncycastle.jcajce.provider.symmetric.util.PBESecretKeyFactory;
import org.bouncycastle.jcajce.spec.AEADParameterSpec;

public final class AES
{
  private static final Class gcmSpecClass = lookup("javax.crypto.spec.GCMParameterSpec");
  private static final Map<String, String> generalAesAttributes;
  
  static
  {
    HashMap localHashMap = new HashMap();
    generalAesAttributes = localHashMap;
    localHashMap.put("SupportedKeyClasses", "javax.crypto.SecretKey");
    generalAesAttributes.put("SupportedKeyFormats", "RAW");
  }
  
  private static Class lookup(String paramString)
  {
    try
    {
      paramString = AES.class.getClassLoader().loadClass(paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;) {}
    }
    return null;
  }
  
  public static class AESCCMMAC
    extends BaseMac
  {
    public AESCCMMAC()
    {
      super();
    }
    
    private static class CCMMac
      implements Mac
    {
      private final CCMBlockCipher ccm = new CCMBlockCipher(new AESEngine());
      private int macLength = 8;
      
      public int doFinal(byte[] paramArrayOfByte, int paramInt)
        throws DataLengthException, IllegalStateException
      {
        try
        {
          paramInt = this.ccm.doFinal(paramArrayOfByte, 0);
          return paramInt;
        }
        catch (InvalidCipherTextException paramArrayOfByte)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("exception on doFinal(): ");
          localStringBuilder.append(paramArrayOfByte.toString());
          throw new IllegalStateException(localStringBuilder.toString());
        }
      }
      
      public String getAlgorithmName()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.ccm.getAlgorithmName());
        localStringBuilder.append("Mac");
        return localStringBuilder.toString();
      }
      
      public int getMacSize()
      {
        return this.macLength;
      }
      
      public void init(CipherParameters paramCipherParameters)
        throws IllegalArgumentException
      {
        this.ccm.init(true, paramCipherParameters);
        this.macLength = this.ccm.getMac().length;
      }
      
      public void reset()
      {
        this.ccm.reset();
      }
      
      public void update(byte paramByte)
        throws IllegalStateException
      {
        this.ccm.processAADByte(paramByte);
      }
      
      public void update(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
        throws DataLengthException, IllegalStateException
      {
        this.ccm.processAADBytes(paramArrayOfByte, paramInt1, paramInt2);
      }
    }
  }
  
  public static class AESCMAC
    extends BaseMac
  {
    public AESCMAC()
    {
      super();
    }
  }
  
  public static class AESGMAC
    extends BaseMac
  {
    public AESGMAC()
    {
      super();
    }
  }
  
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
        AlgorithmParameters localAlgorithmParameters = createParametersInstance("AES");
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
      throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for AES parameter generation.");
    }
  }
  
  public static class AlgParamGenCCM
    extends BaseAlgorithmParameterGenerator
  {
    protected AlgorithmParameters engineGenerateParameters()
    {
      byte[] arrayOfByte = new byte[12];
      if (this.random == null) {
        this.random = new SecureRandom();
      }
      this.random.nextBytes(arrayOfByte);
      try
      {
        AlgorithmParameters localAlgorithmParameters = createParametersInstance("CCM");
        localAlgorithmParameters.init(new CCMParameters(arrayOfByte, 12).getEncoded());
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
      throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for AES parameter generation.");
    }
  }
  
  public static class AlgParamGenGCM
    extends BaseAlgorithmParameterGenerator
  {
    protected AlgorithmParameters engineGenerateParameters()
    {
      byte[] arrayOfByte = new byte[12];
      if (this.random == null) {
        this.random = new SecureRandom();
      }
      this.random.nextBytes(arrayOfByte);
      try
      {
        AlgorithmParameters localAlgorithmParameters = createParametersInstance("GCM");
        localAlgorithmParameters.init(new GCMParameters(arrayOfByte, 16).getEncoded());
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
      throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for AES parameter generation.");
    }
  }
  
  public static class AlgParams
    extends IvAlgorithmParameters
  {
    protected String engineToString()
    {
      return "AES IV";
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
  
  public static class CCM
    extends BaseBlockCipher
  {
    public CCM()
    {
      super(false, 16);
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
          return new AESEngine();
        }
      };
    }
  }
  
  public static class GCM
    extends BaseBlockCipher
  {
    public GCM()
    {
      super();
    }
  }
  
  public static class KeyFactory
    extends BaseSecretKeyFactory
  {
    public KeyFactory()
    {
      super(null);
    }
  }
  
  public static class KeyGen
    extends BaseKeyGenerator
  {
    public KeyGen()
    {
      this(192);
    }
    
    public KeyGen(int paramInt)
    {
      super(paramInt, new CipherKeyGenerator());
    }
  }
  
  public static class KeyGen128
    extends AES.KeyGen
  {
    public KeyGen128()
    {
      super();
    }
  }
  
  public static class KeyGen192
    extends AES.KeyGen
  {
    public KeyGen192()
    {
      super();
    }
  }
  
  public static class KeyGen256
    extends AES.KeyGen
  {
    public KeyGen256()
    {
      super();
    }
  }
  
  public static class Mappings
    extends SymmetricAlgorithmProvider
  {
    private static final String PREFIX = AES.class.getName();
    private static final String wrongAES128 = "2.16.840.1.101.3.4.2";
    private static final String wrongAES192 = "2.16.840.1.101.3.4.22";
    private static final String wrongAES256 = "2.16.840.1.101.3.4.42";
    
    public void configure(ConfigurableProvider paramConfigurableProvider)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$AlgParams");
      paramConfigurableProvider.addAlgorithm("AlgorithmParameters.AES", ((StringBuilder)localObject).toString());
      paramConfigurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.2.16.840.1.101.3.4.2", "AES");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.2.16.840.1.101.3.4.22", "AES");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.2.16.840.1.101.3.4.42", "AES");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Alg.Alias.AlgorithmParameters.");
      ((StringBuilder)localObject).append(NISTObjectIdentifiers.id_aes128_CBC);
      paramConfigurableProvider.addAlgorithm(((StringBuilder)localObject).toString(), "AES");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Alg.Alias.AlgorithmParameters.");
      ((StringBuilder)localObject).append(NISTObjectIdentifiers.id_aes192_CBC);
      paramConfigurableProvider.addAlgorithm(((StringBuilder)localObject).toString(), "AES");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Alg.Alias.AlgorithmParameters.");
      ((StringBuilder)localObject).append(NISTObjectIdentifiers.id_aes256_CBC);
      paramConfigurableProvider.addAlgorithm(((StringBuilder)localObject).toString(), "AES");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$AlgParamsGCM");
      paramConfigurableProvider.addAlgorithm("AlgorithmParameters.GCM", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Alg.Alias.AlgorithmParameters.");
      ((StringBuilder)localObject).append(NISTObjectIdentifiers.id_aes128_GCM);
      paramConfigurableProvider.addAlgorithm(((StringBuilder)localObject).toString(), "GCM");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Alg.Alias.AlgorithmParameters.");
      ((StringBuilder)localObject).append(NISTObjectIdentifiers.id_aes192_GCM);
      paramConfigurableProvider.addAlgorithm(((StringBuilder)localObject).toString(), "GCM");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Alg.Alias.AlgorithmParameters.");
      ((StringBuilder)localObject).append(NISTObjectIdentifiers.id_aes256_GCM);
      paramConfigurableProvider.addAlgorithm(((StringBuilder)localObject).toString(), "GCM");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$AlgParamsCCM");
      paramConfigurableProvider.addAlgorithm("AlgorithmParameters.CCM", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Alg.Alias.AlgorithmParameters.");
      ((StringBuilder)localObject).append(NISTObjectIdentifiers.id_aes128_CCM);
      paramConfigurableProvider.addAlgorithm(((StringBuilder)localObject).toString(), "CCM");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Alg.Alias.AlgorithmParameters.");
      ((StringBuilder)localObject).append(NISTObjectIdentifiers.id_aes192_CCM);
      paramConfigurableProvider.addAlgorithm(((StringBuilder)localObject).toString(), "CCM");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Alg.Alias.AlgorithmParameters.");
      ((StringBuilder)localObject).append(NISTObjectIdentifiers.id_aes256_CCM);
      paramConfigurableProvider.addAlgorithm(((StringBuilder)localObject).toString(), "CCM");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$AlgParamGen");
      paramConfigurableProvider.addAlgorithm("AlgorithmParameterGenerator.AES", ((StringBuilder)localObject).toString());
      paramConfigurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameterGenerator.2.16.840.1.101.3.4.2", "AES");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameterGenerator.2.16.840.1.101.3.4.22", "AES");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameterGenerator.2.16.840.1.101.3.4.42", "AES");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Alg.Alias.AlgorithmParameterGenerator.");
      ((StringBuilder)localObject).append(NISTObjectIdentifiers.id_aes128_CBC);
      paramConfigurableProvider.addAlgorithm(((StringBuilder)localObject).toString(), "AES");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Alg.Alias.AlgorithmParameterGenerator.");
      ((StringBuilder)localObject).append(NISTObjectIdentifiers.id_aes192_CBC);
      paramConfigurableProvider.addAlgorithm(((StringBuilder)localObject).toString(), "AES");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Alg.Alias.AlgorithmParameterGenerator.");
      ((StringBuilder)localObject).append(NISTObjectIdentifiers.id_aes256_CBC);
      paramConfigurableProvider.addAlgorithm(((StringBuilder)localObject).toString(), "AES");
      paramConfigurableProvider.addAttributes("Cipher.AES", AES.generalAesAttributes);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$ECB");
      paramConfigurableProvider.addAlgorithm("Cipher.AES", ((StringBuilder)localObject).toString());
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher.2.16.840.1.101.3.4.2", "AES");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher.2.16.840.1.101.3.4.22", "AES");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher.2.16.840.1.101.3.4.42", "AES");
      localObject = NISTObjectIdentifiers.id_aes128_ECB;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$ECB");
      paramConfigurableProvider.addAlgorithm("Cipher", (ASN1ObjectIdentifier)localObject, localStringBuilder.toString());
      localObject = NISTObjectIdentifiers.id_aes192_ECB;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$ECB");
      paramConfigurableProvider.addAlgorithm("Cipher", (ASN1ObjectIdentifier)localObject, localStringBuilder.toString());
      localObject = NISTObjectIdentifiers.id_aes256_ECB;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$ECB");
      paramConfigurableProvider.addAlgorithm("Cipher", (ASN1ObjectIdentifier)localObject, localStringBuilder.toString());
      localObject = NISTObjectIdentifiers.id_aes128_CBC;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$CBC");
      paramConfigurableProvider.addAlgorithm("Cipher", (ASN1ObjectIdentifier)localObject, localStringBuilder.toString());
      localObject = NISTObjectIdentifiers.id_aes192_CBC;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$CBC");
      paramConfigurableProvider.addAlgorithm("Cipher", (ASN1ObjectIdentifier)localObject, localStringBuilder.toString());
      localObject = NISTObjectIdentifiers.id_aes256_CBC;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$CBC");
      paramConfigurableProvider.addAlgorithm("Cipher", (ASN1ObjectIdentifier)localObject, localStringBuilder.toString());
      localObject = NISTObjectIdentifiers.id_aes128_OFB;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$OFB");
      paramConfigurableProvider.addAlgorithm("Cipher", (ASN1ObjectIdentifier)localObject, localStringBuilder.toString());
      localObject = NISTObjectIdentifiers.id_aes192_OFB;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$OFB");
      paramConfigurableProvider.addAlgorithm("Cipher", (ASN1ObjectIdentifier)localObject, localStringBuilder.toString());
      localObject = NISTObjectIdentifiers.id_aes256_OFB;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$OFB");
      paramConfigurableProvider.addAlgorithm("Cipher", (ASN1ObjectIdentifier)localObject, localStringBuilder.toString());
      localObject = NISTObjectIdentifiers.id_aes128_CFB;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$CFB");
      paramConfigurableProvider.addAlgorithm("Cipher", (ASN1ObjectIdentifier)localObject, localStringBuilder.toString());
      localObject = NISTObjectIdentifiers.id_aes192_CFB;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$CFB");
      paramConfigurableProvider.addAlgorithm("Cipher", (ASN1ObjectIdentifier)localObject, localStringBuilder.toString());
      localObject = NISTObjectIdentifiers.id_aes256_CFB;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$CFB");
      paramConfigurableProvider.addAlgorithm("Cipher", (ASN1ObjectIdentifier)localObject, localStringBuilder.toString());
      paramConfigurableProvider.addAttributes("Cipher.AESWRAP", AES.generalAesAttributes);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$Wrap");
      paramConfigurableProvider.addAlgorithm("Cipher.AESWRAP", ((StringBuilder)localObject).toString());
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher", NISTObjectIdentifiers.id_aes128_wrap, "AESWRAP");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher", NISTObjectIdentifiers.id_aes192_wrap, "AESWRAP");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher", NISTObjectIdentifiers.id_aes256_wrap, "AESWRAP");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher.AESKW", "AESWRAP");
      paramConfigurableProvider.addAttributes("Cipher.AESWRAPPAD", AES.generalAesAttributes);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$WrapPad");
      paramConfigurableProvider.addAlgorithm("Cipher.AESWRAPPAD", ((StringBuilder)localObject).toString());
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher", NISTObjectIdentifiers.id_aes128_wrap_pad, "AESWRAPPAD");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher", NISTObjectIdentifiers.id_aes192_wrap_pad, "AESWRAPPAD");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher", NISTObjectIdentifiers.id_aes256_wrap_pad, "AESWRAPPAD");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher.AESKWP", "AESWRAPPAD");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$RFC3211Wrap");
      paramConfigurableProvider.addAlgorithm("Cipher.AESRFC3211WRAP", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$RFC5649Wrap");
      paramConfigurableProvider.addAlgorithm("Cipher.AESRFC5649WRAP", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$AlgParamGenCCM");
      paramConfigurableProvider.addAlgorithm("AlgorithmParameterGenerator.CCM", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Alg.Alias.AlgorithmParameterGenerator.");
      ((StringBuilder)localObject).append(NISTObjectIdentifiers.id_aes128_CCM);
      paramConfigurableProvider.addAlgorithm(((StringBuilder)localObject).toString(), "CCM");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Alg.Alias.AlgorithmParameterGenerator.");
      ((StringBuilder)localObject).append(NISTObjectIdentifiers.id_aes192_CCM);
      paramConfigurableProvider.addAlgorithm(((StringBuilder)localObject).toString(), "CCM");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Alg.Alias.AlgorithmParameterGenerator.");
      ((StringBuilder)localObject).append(NISTObjectIdentifiers.id_aes256_CCM);
      paramConfigurableProvider.addAlgorithm(((StringBuilder)localObject).toString(), "CCM");
      paramConfigurableProvider.addAttributes("Cipher.CCM", AES.generalAesAttributes);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$CCM");
      paramConfigurableProvider.addAlgorithm("Cipher.CCM", ((StringBuilder)localObject).toString());
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher", NISTObjectIdentifiers.id_aes128_CCM, "CCM");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher", NISTObjectIdentifiers.id_aes192_CCM, "CCM");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher", NISTObjectIdentifiers.id_aes256_CCM, "CCM");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$AlgParamGenGCM");
      paramConfigurableProvider.addAlgorithm("AlgorithmParameterGenerator.GCM", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Alg.Alias.AlgorithmParameterGenerator.");
      ((StringBuilder)localObject).append(NISTObjectIdentifiers.id_aes128_GCM);
      paramConfigurableProvider.addAlgorithm(((StringBuilder)localObject).toString(), "GCM");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Alg.Alias.AlgorithmParameterGenerator.");
      ((StringBuilder)localObject).append(NISTObjectIdentifiers.id_aes192_GCM);
      paramConfigurableProvider.addAlgorithm(((StringBuilder)localObject).toString(), "GCM");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Alg.Alias.AlgorithmParameterGenerator.");
      ((StringBuilder)localObject).append(NISTObjectIdentifiers.id_aes256_GCM);
      paramConfigurableProvider.addAlgorithm(((StringBuilder)localObject).toString(), "GCM");
      paramConfigurableProvider.addAttributes("Cipher.GCM", AES.generalAesAttributes);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$GCM");
      paramConfigurableProvider.addAlgorithm("Cipher.GCM", ((StringBuilder)localObject).toString());
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher", NISTObjectIdentifiers.id_aes128_GCM, "GCM");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher", NISTObjectIdentifiers.id_aes192_GCM, "GCM");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher", NISTObjectIdentifiers.id_aes256_GCM, "GCM");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$KeyGen");
      paramConfigurableProvider.addAlgorithm("KeyGenerator.AES", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$KeyGen128");
      paramConfigurableProvider.addAlgorithm("KeyGenerator.2.16.840.1.101.3.4.2", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$KeyGen192");
      paramConfigurableProvider.addAlgorithm("KeyGenerator.2.16.840.1.101.3.4.22", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$KeyGen256");
      paramConfigurableProvider.addAlgorithm("KeyGenerator.2.16.840.1.101.3.4.42", ((StringBuilder)localObject).toString());
      localObject = NISTObjectIdentifiers.id_aes128_ECB;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$KeyGen128");
      paramConfigurableProvider.addAlgorithm("KeyGenerator", (ASN1ObjectIdentifier)localObject, localStringBuilder.toString());
      localObject = NISTObjectIdentifiers.id_aes128_CBC;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$KeyGen128");
      paramConfigurableProvider.addAlgorithm("KeyGenerator", (ASN1ObjectIdentifier)localObject, localStringBuilder.toString());
      localObject = NISTObjectIdentifiers.id_aes128_OFB;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$KeyGen128");
      paramConfigurableProvider.addAlgorithm("KeyGenerator", (ASN1ObjectIdentifier)localObject, localStringBuilder.toString());
      localObject = NISTObjectIdentifiers.id_aes128_CFB;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$KeyGen128");
      paramConfigurableProvider.addAlgorithm("KeyGenerator", (ASN1ObjectIdentifier)localObject, localStringBuilder.toString());
      localObject = NISTObjectIdentifiers.id_aes192_ECB;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$KeyGen192");
      paramConfigurableProvider.addAlgorithm("KeyGenerator", (ASN1ObjectIdentifier)localObject, localStringBuilder.toString());
      localObject = NISTObjectIdentifiers.id_aes192_CBC;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$KeyGen192");
      paramConfigurableProvider.addAlgorithm("KeyGenerator", (ASN1ObjectIdentifier)localObject, localStringBuilder.toString());
      localObject = NISTObjectIdentifiers.id_aes192_OFB;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$KeyGen192");
      paramConfigurableProvider.addAlgorithm("KeyGenerator", (ASN1ObjectIdentifier)localObject, localStringBuilder.toString());
      localObject = NISTObjectIdentifiers.id_aes192_CFB;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$KeyGen192");
      paramConfigurableProvider.addAlgorithm("KeyGenerator", (ASN1ObjectIdentifier)localObject, localStringBuilder.toString());
      localObject = NISTObjectIdentifiers.id_aes256_ECB;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$KeyGen256");
      paramConfigurableProvider.addAlgorithm("KeyGenerator", (ASN1ObjectIdentifier)localObject, localStringBuilder.toString());
      localObject = NISTObjectIdentifiers.id_aes256_CBC;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$KeyGen256");
      paramConfigurableProvider.addAlgorithm("KeyGenerator", (ASN1ObjectIdentifier)localObject, localStringBuilder.toString());
      localObject = NISTObjectIdentifiers.id_aes256_OFB;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$KeyGen256");
      paramConfigurableProvider.addAlgorithm("KeyGenerator", (ASN1ObjectIdentifier)localObject, localStringBuilder.toString());
      localObject = NISTObjectIdentifiers.id_aes256_CFB;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$KeyGen256");
      paramConfigurableProvider.addAlgorithm("KeyGenerator", (ASN1ObjectIdentifier)localObject, localStringBuilder.toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$KeyGen");
      paramConfigurableProvider.addAlgorithm("KeyGenerator.AESWRAP", ((StringBuilder)localObject).toString());
      localObject = NISTObjectIdentifiers.id_aes128_wrap;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$KeyGen128");
      paramConfigurableProvider.addAlgorithm("KeyGenerator", (ASN1ObjectIdentifier)localObject, localStringBuilder.toString());
      localObject = NISTObjectIdentifiers.id_aes192_wrap;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$KeyGen192");
      paramConfigurableProvider.addAlgorithm("KeyGenerator", (ASN1ObjectIdentifier)localObject, localStringBuilder.toString());
      localObject = NISTObjectIdentifiers.id_aes256_wrap;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$KeyGen256");
      paramConfigurableProvider.addAlgorithm("KeyGenerator", (ASN1ObjectIdentifier)localObject, localStringBuilder.toString());
      localObject = NISTObjectIdentifiers.id_aes128_GCM;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$KeyGen128");
      paramConfigurableProvider.addAlgorithm("KeyGenerator", (ASN1ObjectIdentifier)localObject, localStringBuilder.toString());
      localObject = NISTObjectIdentifiers.id_aes192_GCM;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$KeyGen192");
      paramConfigurableProvider.addAlgorithm("KeyGenerator", (ASN1ObjectIdentifier)localObject, localStringBuilder.toString());
      localObject = NISTObjectIdentifiers.id_aes256_GCM;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$KeyGen256");
      paramConfigurableProvider.addAlgorithm("KeyGenerator", (ASN1ObjectIdentifier)localObject, localStringBuilder.toString());
      localObject = NISTObjectIdentifiers.id_aes128_CCM;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$KeyGen128");
      paramConfigurableProvider.addAlgorithm("KeyGenerator", (ASN1ObjectIdentifier)localObject, localStringBuilder.toString());
      localObject = NISTObjectIdentifiers.id_aes192_CCM;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$KeyGen192");
      paramConfigurableProvider.addAlgorithm("KeyGenerator", (ASN1ObjectIdentifier)localObject, localStringBuilder.toString());
      localObject = NISTObjectIdentifiers.id_aes256_CCM;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$KeyGen256");
      paramConfigurableProvider.addAlgorithm("KeyGenerator", (ASN1ObjectIdentifier)localObject, localStringBuilder.toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$KeyGen");
      paramConfigurableProvider.addAlgorithm("KeyGenerator.AESWRAPPAD", ((StringBuilder)localObject).toString());
      localObject = NISTObjectIdentifiers.id_aes128_wrap_pad;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$KeyGen128");
      paramConfigurableProvider.addAlgorithm("KeyGenerator", (ASN1ObjectIdentifier)localObject, localStringBuilder.toString());
      localObject = NISTObjectIdentifiers.id_aes192_wrap_pad;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$KeyGen192");
      paramConfigurableProvider.addAlgorithm("KeyGenerator", (ASN1ObjectIdentifier)localObject, localStringBuilder.toString());
      localObject = NISTObjectIdentifiers.id_aes256_wrap_pad;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$KeyGen256");
      paramConfigurableProvider.addAlgorithm("KeyGenerator", (ASN1ObjectIdentifier)localObject, localStringBuilder.toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$AESCMAC");
      paramConfigurableProvider.addAlgorithm("Mac.AESCMAC", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$AESCCMMAC");
      paramConfigurableProvider.addAlgorithm("Mac.AESCCMMAC", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Alg.Alias.Mac.");
      ((StringBuilder)localObject).append(NISTObjectIdentifiers.id_aes128_CCM.getId());
      paramConfigurableProvider.addAlgorithm(((StringBuilder)localObject).toString(), "AESCCMMAC");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Alg.Alias.Mac.");
      ((StringBuilder)localObject).append(NISTObjectIdentifiers.id_aes192_CCM.getId());
      paramConfigurableProvider.addAlgorithm(((StringBuilder)localObject).toString(), "AESCCMMAC");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Alg.Alias.Mac.");
      ((StringBuilder)localObject).append(NISTObjectIdentifiers.id_aes256_CCM.getId());
      paramConfigurableProvider.addAlgorithm(((StringBuilder)localObject).toString(), "AESCCMMAC");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher", BCObjectIdentifiers.bc_pbe_sha1_pkcs12_aes128_cbc, "PBEWITHSHAAND128BITAES-CBC-BC");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher", BCObjectIdentifiers.bc_pbe_sha1_pkcs12_aes192_cbc, "PBEWITHSHAAND192BITAES-CBC-BC");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher", BCObjectIdentifiers.bc_pbe_sha1_pkcs12_aes256_cbc, "PBEWITHSHAAND256BITAES-CBC-BC");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher", BCObjectIdentifiers.bc_pbe_sha256_pkcs12_aes128_cbc, "PBEWITHSHA256AND128BITAES-CBC-BC");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher", BCObjectIdentifiers.bc_pbe_sha256_pkcs12_aes192_cbc, "PBEWITHSHA256AND192BITAES-CBC-BC");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher", BCObjectIdentifiers.bc_pbe_sha256_pkcs12_aes256_cbc, "PBEWITHSHA256AND256BITAES-CBC-BC");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$PBEWithSHA1AESCBC128");
      paramConfigurableProvider.addAlgorithm("Cipher.PBEWITHSHAAND128BITAES-CBC-BC", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$PBEWithSHA1AESCBC192");
      paramConfigurableProvider.addAlgorithm("Cipher.PBEWITHSHAAND192BITAES-CBC-BC", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$PBEWithSHA1AESCBC256");
      paramConfigurableProvider.addAlgorithm("Cipher.PBEWITHSHAAND256BITAES-CBC-BC", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$PBEWithSHA256AESCBC128");
      paramConfigurableProvider.addAlgorithm("Cipher.PBEWITHSHA256AND128BITAES-CBC-BC", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$PBEWithSHA256AESCBC192");
      paramConfigurableProvider.addAlgorithm("Cipher.PBEWITHSHA256AND192BITAES-CBC-BC", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$PBEWithSHA256AESCBC256");
      paramConfigurableProvider.addAlgorithm("Cipher.PBEWITHSHA256AND256BITAES-CBC-BC", ((StringBuilder)localObject).toString());
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher.PBEWITHSHA1AND128BITAES-CBC-BC", "PBEWITHSHAAND128BITAES-CBC-BC");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher.PBEWITHSHA1AND192BITAES-CBC-BC", "PBEWITHSHAAND192BITAES-CBC-BC");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher.PBEWITHSHA1AND256BITAES-CBC-BC", "PBEWITHSHAAND256BITAES-CBC-BC");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher.PBEWITHSHA-1AND128BITAES-CBC-BC", "PBEWITHSHAAND128BITAES-CBC-BC");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher.PBEWITHSHA-1AND192BITAES-CBC-BC", "PBEWITHSHAAND192BITAES-CBC-BC");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher.PBEWITHSHA-1AND256BITAES-CBC-BC", "PBEWITHSHAAND256BITAES-CBC-BC");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher.PBEWITHSHAAND128BITAES-BC", "PBEWITHSHAAND128BITAES-CBC-BC");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher.PBEWITHSHAAND192BITAES-BC", "PBEWITHSHAAND192BITAES-CBC-BC");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher.PBEWITHSHAAND256BITAES-BC", "PBEWITHSHAAND256BITAES-CBC-BC");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher.PBEWITHSHA1AND128BITAES-BC", "PBEWITHSHAAND128BITAES-CBC-BC");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher.PBEWITHSHA1AND192BITAES-BC", "PBEWITHSHAAND192BITAES-CBC-BC");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher.PBEWITHSHA1AND256BITAES-BC", "PBEWITHSHAAND256BITAES-CBC-BC");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher.PBEWITHSHA-1AND128BITAES-BC", "PBEWITHSHAAND128BITAES-CBC-BC");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher.PBEWITHSHA-1AND192BITAES-BC", "PBEWITHSHAAND192BITAES-CBC-BC");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher.PBEWITHSHA-1AND256BITAES-BC", "PBEWITHSHAAND256BITAES-CBC-BC");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher.PBEWITHSHA-256AND128BITAES-CBC-BC", "PBEWITHSHA256AND128BITAES-CBC-BC");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher.PBEWITHSHA-256AND192BITAES-CBC-BC", "PBEWITHSHA256AND192BITAES-CBC-BC");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher.PBEWITHSHA-256AND256BITAES-CBC-BC", "PBEWITHSHA256AND256BITAES-CBC-BC");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher.PBEWITHSHA256AND128BITAES-BC", "PBEWITHSHA256AND128BITAES-CBC-BC");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher.PBEWITHSHA256AND192BITAES-BC", "PBEWITHSHA256AND192BITAES-CBC-BC");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher.PBEWITHSHA256AND256BITAES-BC", "PBEWITHSHA256AND256BITAES-CBC-BC");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher.PBEWITHSHA-256AND128BITAES-BC", "PBEWITHSHA256AND128BITAES-CBC-BC");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher.PBEWITHSHA-256AND192BITAES-BC", "PBEWITHSHA256AND192BITAES-CBC-BC");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher.PBEWITHSHA-256AND256BITAES-BC", "PBEWITHSHA256AND256BITAES-CBC-BC");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$PBEWithAESCBC");
      paramConfigurableProvider.addAlgorithm("Cipher.PBEWITHMD5AND128BITAES-CBC-OPENSSL", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$PBEWithAESCBC");
      paramConfigurableProvider.addAlgorithm("Cipher.PBEWITHMD5AND192BITAES-CBC-OPENSSL", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$PBEWithAESCBC");
      paramConfigurableProvider.addAlgorithm("Cipher.PBEWITHMD5AND256BITAES-CBC-OPENSSL", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$KeyFactory");
      paramConfigurableProvider.addAlgorithm("SecretKeyFactory.AES", ((StringBuilder)localObject).toString());
      localObject = NISTObjectIdentifiers.aes;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$KeyFactory");
      paramConfigurableProvider.addAlgorithm("SecretKeyFactory", (ASN1ObjectIdentifier)localObject, localStringBuilder.toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$PBEWithMD5And128BitAESCBCOpenSSL");
      paramConfigurableProvider.addAlgorithm("SecretKeyFactory.PBEWITHMD5AND128BITAES-CBC-OPENSSL", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$PBEWithMD5And192BitAESCBCOpenSSL");
      paramConfigurableProvider.addAlgorithm("SecretKeyFactory.PBEWITHMD5AND192BITAES-CBC-OPENSSL", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$PBEWithMD5And256BitAESCBCOpenSSL");
      paramConfigurableProvider.addAlgorithm("SecretKeyFactory.PBEWITHMD5AND256BITAES-CBC-OPENSSL", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$PBEWithSHAAnd128BitAESBC");
      paramConfigurableProvider.addAlgorithm("SecretKeyFactory.PBEWITHSHAAND128BITAES-CBC-BC", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$PBEWithSHAAnd192BitAESBC");
      paramConfigurableProvider.addAlgorithm("SecretKeyFactory.PBEWITHSHAAND192BITAES-CBC-BC", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$PBEWithSHAAnd256BitAESBC");
      paramConfigurableProvider.addAlgorithm("SecretKeyFactory.PBEWITHSHAAND256BITAES-CBC-BC", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$PBEWithSHA256And128BitAESBC");
      paramConfigurableProvider.addAlgorithm("SecretKeyFactory.PBEWITHSHA256AND128BITAES-CBC-BC", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$PBEWithSHA256And192BitAESBC");
      paramConfigurableProvider.addAlgorithm("SecretKeyFactory.PBEWITHSHA256AND192BITAES-CBC-BC", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$PBEWithSHA256And256BitAESBC");
      paramConfigurableProvider.addAlgorithm("SecretKeyFactory.PBEWITHSHA256AND256BITAES-CBC-BC", ((StringBuilder)localObject).toString());
      paramConfigurableProvider.addAlgorithm("Alg.Alias.SecretKeyFactory.PBEWITHSHA1AND128BITAES-CBC-BC", "PBEWITHSHAAND128BITAES-CBC-BC");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.SecretKeyFactory.PBEWITHSHA1AND192BITAES-CBC-BC", "PBEWITHSHAAND192BITAES-CBC-BC");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.SecretKeyFactory.PBEWITHSHA1AND256BITAES-CBC-BC", "PBEWITHSHAAND256BITAES-CBC-BC");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.SecretKeyFactory.PBEWITHSHA-1AND128BITAES-CBC-BC", "PBEWITHSHAAND128BITAES-CBC-BC");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.SecretKeyFactory.PBEWITHSHA-1AND192BITAES-CBC-BC", "PBEWITHSHAAND192BITAES-CBC-BC");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.SecretKeyFactory.PBEWITHSHA-1AND256BITAES-CBC-BC", "PBEWITHSHAAND256BITAES-CBC-BC");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.SecretKeyFactory.PBEWITHSHA-256AND128BITAES-CBC-BC", "PBEWITHSHA256AND128BITAES-CBC-BC");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.SecretKeyFactory.PBEWITHSHA-256AND192BITAES-CBC-BC", "PBEWITHSHA256AND192BITAES-CBC-BC");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.SecretKeyFactory.PBEWITHSHA-256AND256BITAES-CBC-BC", "PBEWITHSHA256AND256BITAES-CBC-BC");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.SecretKeyFactory.PBEWITHSHA-256AND128BITAES-BC", "PBEWITHSHA256AND128BITAES-CBC-BC");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.SecretKeyFactory.PBEWITHSHA-256AND192BITAES-BC", "PBEWITHSHA256AND192BITAES-CBC-BC");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.SecretKeyFactory.PBEWITHSHA-256AND256BITAES-BC", "PBEWITHSHA256AND256BITAES-CBC-BC");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.SecretKeyFactory", BCObjectIdentifiers.bc_pbe_sha1_pkcs12_aes128_cbc, "PBEWITHSHAAND128BITAES-CBC-BC");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.SecretKeyFactory", BCObjectIdentifiers.bc_pbe_sha1_pkcs12_aes192_cbc, "PBEWITHSHAAND192BITAES-CBC-BC");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.SecretKeyFactory", BCObjectIdentifiers.bc_pbe_sha1_pkcs12_aes256_cbc, "PBEWITHSHAAND256BITAES-CBC-BC");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.SecretKeyFactory", BCObjectIdentifiers.bc_pbe_sha256_pkcs12_aes128_cbc, "PBEWITHSHA256AND128BITAES-CBC-BC");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.SecretKeyFactory", BCObjectIdentifiers.bc_pbe_sha256_pkcs12_aes192_cbc, "PBEWITHSHA256AND192BITAES-CBC-BC");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.SecretKeyFactory", BCObjectIdentifiers.bc_pbe_sha256_pkcs12_aes256_cbc, "PBEWITHSHA256AND256BITAES-CBC-BC");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.PBEWITHSHAAND128BITAES-CBC-BC", "PKCS12PBE");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.PBEWITHSHAAND192BITAES-CBC-BC", "PKCS12PBE");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.PBEWITHSHAAND256BITAES-CBC-BC", "PKCS12PBE");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.PBEWITHSHA256AND128BITAES-CBC-BC", "PKCS12PBE");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.PBEWITHSHA256AND192BITAES-CBC-BC", "PKCS12PBE");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.PBEWITHSHA256AND256BITAES-CBC-BC", "PKCS12PBE");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.PBEWITHSHA1AND128BITAES-CBC-BC", "PKCS12PBE");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.PBEWITHSHA1AND192BITAES-CBC-BC", "PKCS12PBE");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.PBEWITHSHA1AND256BITAES-CBC-BC", "PKCS12PBE");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.PBEWITHSHA-1AND128BITAES-CBC-BC", "PKCS12PBE");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.PBEWITHSHA-1AND192BITAES-CBC-BC", "PKCS12PBE");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.PBEWITHSHA-1AND256BITAES-CBC-BC", "PKCS12PBE");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.PBEWITHSHA-256AND128BITAES-CBC-BC", "PKCS12PBE");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.PBEWITHSHA-256AND192BITAES-CBC-BC", "PKCS12PBE");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.PBEWITHSHA-256AND256BITAES-CBC-BC", "PKCS12PBE");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Alg.Alias.AlgorithmParameters.");
      ((StringBuilder)localObject).append(BCObjectIdentifiers.bc_pbe_sha1_pkcs12_aes128_cbc.getId());
      paramConfigurableProvider.addAlgorithm(((StringBuilder)localObject).toString(), "PKCS12PBE");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Alg.Alias.AlgorithmParameters.");
      ((StringBuilder)localObject).append(BCObjectIdentifiers.bc_pbe_sha1_pkcs12_aes192_cbc.getId());
      paramConfigurableProvider.addAlgorithm(((StringBuilder)localObject).toString(), "PKCS12PBE");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Alg.Alias.AlgorithmParameters.");
      ((StringBuilder)localObject).append(BCObjectIdentifiers.bc_pbe_sha1_pkcs12_aes256_cbc.getId());
      paramConfigurableProvider.addAlgorithm(((StringBuilder)localObject).toString(), "PKCS12PBE");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Alg.Alias.AlgorithmParameters.");
      ((StringBuilder)localObject).append(BCObjectIdentifiers.bc_pbe_sha256_pkcs12_aes128_cbc.getId());
      paramConfigurableProvider.addAlgorithm(((StringBuilder)localObject).toString(), "PKCS12PBE");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Alg.Alias.AlgorithmParameters.");
      ((StringBuilder)localObject).append(BCObjectIdentifiers.bc_pbe_sha256_pkcs12_aes192_cbc.getId());
      paramConfigurableProvider.addAlgorithm(((StringBuilder)localObject).toString(), "PKCS12PBE");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Alg.Alias.AlgorithmParameters.");
      ((StringBuilder)localObject).append(BCObjectIdentifiers.bc_pbe_sha256_pkcs12_aes256_cbc.getId());
      paramConfigurableProvider.addAlgorithm(((StringBuilder)localObject).toString(), "PKCS12PBE");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$AESGMAC");
      localObject = ((StringBuilder)localObject).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$KeyGen128");
      addGMacAlgorithm(paramConfigurableProvider, "AES", (String)localObject, localStringBuilder.toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$Poly1305");
      localObject = ((StringBuilder)localObject).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$Poly1305KeyGen");
      addPoly1305Algorithm(paramConfigurableProvider, "AES", (String)localObject, localStringBuilder.toString());
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
  
  public static class PBEWithAESCBC
    extends BaseBlockCipher
  {
    public PBEWithAESCBC()
    {
      super();
    }
  }
  
  public static class PBEWithMD5And128BitAESCBCOpenSSL
    extends PBESecretKeyFactory
  {
    public PBEWithMD5And128BitAESCBCOpenSSL()
    {
      super(null, true, 3, 0, 128, 128);
    }
  }
  
  public static class PBEWithMD5And192BitAESCBCOpenSSL
    extends PBESecretKeyFactory
  {
    public PBEWithMD5And192BitAESCBCOpenSSL()
    {
      super(null, true, 3, 0, 192, 128);
    }
  }
  
  public static class PBEWithMD5And256BitAESCBCOpenSSL
    extends PBESecretKeyFactory
  {
    public PBEWithMD5And256BitAESCBCOpenSSL()
    {
      super(null, true, 3, 0, 256, 128);
    }
  }
  
  public static class PBEWithSHA1AESCBC128
    extends BaseBlockCipher
  {
    public PBEWithSHA1AESCBC128()
    {
      super(2, 1, 128, 16);
    }
  }
  
  public static class PBEWithSHA1AESCBC192
    extends BaseBlockCipher
  {
    public PBEWithSHA1AESCBC192()
    {
      super(2, 1, 192, 16);
    }
  }
  
  public static class PBEWithSHA1AESCBC256
    extends BaseBlockCipher
  {
    public PBEWithSHA1AESCBC256()
    {
      super(2, 1, 256, 16);
    }
  }
  
  public static class PBEWithSHA256AESCBC128
    extends BaseBlockCipher
  {
    public PBEWithSHA256AESCBC128()
    {
      super(2, 4, 128, 16);
    }
  }
  
  public static class PBEWithSHA256AESCBC192
    extends BaseBlockCipher
  {
    public PBEWithSHA256AESCBC192()
    {
      super(2, 4, 192, 16);
    }
  }
  
  public static class PBEWithSHA256AESCBC256
    extends BaseBlockCipher
  {
    public PBEWithSHA256AESCBC256()
    {
      super(2, 4, 256, 16);
    }
  }
  
  public static class PBEWithSHA256And128BitAESBC
    extends PBESecretKeyFactory
  {
    public PBEWithSHA256And128BitAESBC()
    {
      super(null, true, 2, 4, 128, 128);
    }
  }
  
  public static class PBEWithSHA256And192BitAESBC
    extends PBESecretKeyFactory
  {
    public PBEWithSHA256And192BitAESBC()
    {
      super(null, true, 2, 4, 192, 128);
    }
  }
  
  public static class PBEWithSHA256And256BitAESBC
    extends PBESecretKeyFactory
  {
    public PBEWithSHA256And256BitAESBC()
    {
      super(null, true, 2, 4, 256, 128);
    }
  }
  
  public static class PBEWithSHAAnd128BitAESBC
    extends PBESecretKeyFactory
  {
    public PBEWithSHAAnd128BitAESBC()
    {
      super(null, true, 2, 1, 128, 128);
    }
  }
  
  public static class PBEWithSHAAnd192BitAESBC
    extends PBESecretKeyFactory
  {
    public PBEWithSHAAnd192BitAESBC()
    {
      super(null, true, 2, 1, 192, 128);
    }
  }
  
  public static class PBEWithSHAAnd256BitAESBC
    extends PBESecretKeyFactory
  {
    public PBEWithSHAAnd256BitAESBC()
    {
      super(null, true, 2, 1, 256, 128);
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
  
  public static class RFC5649Wrap
    extends BaseWrapCipher
  {
    public RFC5649Wrap()
    {
      super();
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\symmetric\AES.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */