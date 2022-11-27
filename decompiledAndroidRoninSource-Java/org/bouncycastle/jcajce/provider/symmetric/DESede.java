package org.bouncycastle.jcajce.provider.symmetric;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import javax.crypto.SecretKey;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.crypto.CipherKeyGenerator;
import org.bouncycastle.crypto.KeyGenerationParameters;
import org.bouncycastle.crypto.engines.DESedeEngine;
import org.bouncycastle.crypto.engines.DESedeWrapEngine;
import org.bouncycastle.crypto.engines.RFC3211WrapEngine;
import org.bouncycastle.crypto.generators.DESedeKeyGenerator;
import org.bouncycastle.crypto.macs.CBCBlockCipherMac;
import org.bouncycastle.crypto.macs.CFBBlockCipherMac;
import org.bouncycastle.crypto.macs.CMac;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.crypto.paddings.ISO7816d4Padding;
import org.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameterGenerator;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseMac;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseSecretKeyFactory;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseWrapCipher;
import org.bouncycastle.jcajce.provider.util.AlgorithmProvider;

public final class DESede
{
  public static class AlgParamGen
    extends BaseAlgorithmParameterGenerator
  {
    protected AlgorithmParameters engineGenerateParameters()
    {
      byte[] arrayOfByte = new byte[8];
      if (this.random == null) {
        this.random = new SecureRandom();
      }
      this.random.nextBytes(arrayOfByte);
      try
      {
        AlgorithmParameters localAlgorithmParameters = createParametersInstance("DES");
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
      throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for DES parameter generation.");
    }
  }
  
  public static class CBC
    extends BaseBlockCipher
  {
    public CBC()
    {
      super(64);
    }
  }
  
  public static class CBCMAC
    extends BaseMac
  {
    public CBCMAC()
    {
      super();
    }
  }
  
  public static class CMAC
    extends BaseMac
  {
    public CMAC()
    {
      super();
    }
  }
  
  public static class DESede64
    extends BaseMac
  {
    public DESede64()
    {
      super();
    }
  }
  
  public static class DESede64with7816d4
    extends BaseMac
  {
    public DESede64with7816d4()
    {
      super();
    }
  }
  
  public static class DESedeCFB8
    extends BaseMac
  {
    public DESedeCFB8()
    {
      super();
    }
  }
  
  public static class ECB
    extends BaseBlockCipher
  {
    public ECB()
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
    
    protected SecretKey engineGenerateSecret(KeySpec paramKeySpec)
      throws InvalidKeySpecException
    {
      if ((paramKeySpec instanceof DESedeKeySpec)) {
        return new SecretKeySpec(((DESedeKeySpec)paramKeySpec).getKey(), "DESede");
      }
      return super.engineGenerateSecret(paramKeySpec);
    }
    
    protected KeySpec engineGetKeySpec(SecretKey paramSecretKey, Class paramClass)
      throws InvalidKeySpecException
    {
      if (paramClass != null)
      {
        if (paramSecretKey != null)
        {
          if (SecretKeySpec.class.isAssignableFrom(paramClass)) {
            return new SecretKeySpec(paramSecretKey.getEncoded(), this.algName);
          }
          if (DESedeKeySpec.class.isAssignableFrom(paramClass))
          {
            paramSecretKey = paramSecretKey.getEncoded();
            try
            {
              if (paramSecretKey.length == 16)
              {
                paramClass = new byte[24];
                System.arraycopy(paramSecretKey, 0, paramClass, 0, 16);
                System.arraycopy(paramSecretKey, 0, paramClass, 16, 8);
                return new DESedeKeySpec(paramClass);
              }
              paramSecretKey = new DESedeKeySpec(paramSecretKey);
              return paramSecretKey;
            }
            catch (Exception paramSecretKey)
            {
              throw new InvalidKeySpecException(paramSecretKey.toString());
            }
          }
          throw new InvalidKeySpecException("Invalid KeySpec");
        }
        throw new InvalidKeySpecException("key parameter is null");
      }
      throw new InvalidKeySpecException("keySpec parameter is null");
    }
  }
  
  public static class KeyGenerator
    extends BaseKeyGenerator
  {
    private boolean keySizeSet = false;
    
    public KeyGenerator()
    {
      super(192, new DESedeKeyGenerator());
    }
    
    protected SecretKey engineGenerateKey()
    {
      if (this.uninitialised)
      {
        this.engine.init(new KeyGenerationParameters(new SecureRandom(), this.defaultKeySize));
        this.uninitialised = false;
      }
      if (!this.keySizeSet)
      {
        byte[] arrayOfByte = this.engine.generateKey();
        System.arraycopy(arrayOfByte, 0, arrayOfByte, 16, 8);
        return new SecretKeySpec(arrayOfByte, this.algName);
      }
      return new SecretKeySpec(this.engine.generateKey(), this.algName);
    }
    
    protected void engineInit(int paramInt, SecureRandom paramSecureRandom)
    {
      super.engineInit(paramInt, paramSecureRandom);
      this.keySizeSet = true;
    }
  }
  
  public static class KeyGenerator3
    extends BaseKeyGenerator
  {
    public KeyGenerator3()
    {
      super(192, new DESedeKeyGenerator());
    }
  }
  
  public static class Mappings
    extends AlgorithmProvider
  {
    private static final String PACKAGE = "org.bouncycastle.jcajce.provider.symmetric";
    private static final String PREFIX = DESede.class.getName();
    
    public void configure(ConfigurableProvider paramConfigurableProvider)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$ECB");
      paramConfigurableProvider.addAlgorithm("Cipher.DESEDE", ((StringBuilder)localObject).toString());
      localObject = PKCSObjectIdentifiers.des_EDE3_CBC;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$CBC");
      paramConfigurableProvider.addAlgorithm("Cipher", (ASN1ObjectIdentifier)localObject, localStringBuilder.toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$Wrap");
      paramConfigurableProvider.addAlgorithm("Cipher.DESEDEWRAP", ((StringBuilder)localObject).toString());
      localObject = PKCSObjectIdentifiers.id_alg_CMS3DESwrap;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$Wrap");
      paramConfigurableProvider.addAlgorithm("Cipher", (ASN1ObjectIdentifier)localObject, localStringBuilder.toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$RFC3211");
      paramConfigurableProvider.addAlgorithm("Cipher.DESEDERFC3211WRAP", ((StringBuilder)localObject).toString());
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher.DESEDERFC3217WRAP", "DESEDEWRAP");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher.TDEA", "DESEDE");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher.TDEAWRAP", "DESEDEWRAP");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.KeyGenerator.TDEA", "DESEDE");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.TDEA", "DESEDE");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameterGenerator.TDEA", "DESEDE");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.SecretKeyFactory.TDEA", "DESEDE");
      if (paramConfigurableProvider.hasAlgorithm("MessageDigest", "SHA-1"))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(PREFIX);
        ((StringBuilder)localObject).append("$PBEWithSHAAndDES3Key");
        paramConfigurableProvider.addAlgorithm("Cipher.PBEWITHSHAAND3-KEYTRIPLEDES-CBC", ((StringBuilder)localObject).toString());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(PREFIX);
        ((StringBuilder)localObject).append("$BrokePBEWithSHAAndDES3Key");
        paramConfigurableProvider.addAlgorithm("Cipher.BROKENPBEWITHSHAAND3-KEYTRIPLEDES-CBC", ((StringBuilder)localObject).toString());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(PREFIX);
        ((StringBuilder)localObject).append("$OldPBEWithSHAAndDES3Key");
        paramConfigurableProvider.addAlgorithm("Cipher.OLDPBEWITHSHAAND3-KEYTRIPLEDES-CBC", ((StringBuilder)localObject).toString());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(PREFIX);
        ((StringBuilder)localObject).append("$PBEWithSHAAndDES2Key");
        paramConfigurableProvider.addAlgorithm("Cipher.PBEWITHSHAAND2-KEYTRIPLEDES-CBC", ((StringBuilder)localObject).toString());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(PREFIX);
        ((StringBuilder)localObject).append("$BrokePBEWithSHAAndDES2Key");
        paramConfigurableProvider.addAlgorithm("Cipher.BROKENPBEWITHSHAAND2-KEYTRIPLEDES-CBC", ((StringBuilder)localObject).toString());
        paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher", PKCSObjectIdentifiers.pbeWithSHAAnd3_KeyTripleDES_CBC, "PBEWITHSHAAND3-KEYTRIPLEDES-CBC");
        paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher", PKCSObjectIdentifiers.pbeWithSHAAnd2_KeyTripleDES_CBC, "PBEWITHSHAAND2-KEYTRIPLEDES-CBC");
        paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher.PBEWITHSHA1ANDDESEDE", "PBEWITHSHAAND3-KEYTRIPLEDES-CBC");
        paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher.PBEWITHSHA1AND3-KEYTRIPLEDES-CBC", "PBEWITHSHAAND3-KEYTRIPLEDES-CBC");
        paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher.PBEWITHSHA1AND2-KEYTRIPLEDES-CBC", "PBEWITHSHAAND2-KEYTRIPLEDES-CBC");
        paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher.PBEWITHSHAAND3-KEYDESEDE-CBC", "PBEWITHSHAAND3-KEYTRIPLEDES-CBC");
        paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher.PBEWITHSHAAND2-KEYDESEDE-CBC", "PBEWITHSHAAND2-KEYTRIPLEDES-CBC");
        paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher.PBEWITHSHA1AND3-KEYDESEDE-CBC", "PBEWITHSHAAND3-KEYTRIPLEDES-CBC");
        paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher.PBEWITHSHA1AND2-KEYDESEDE-CBC", "PBEWITHSHAAND2-KEYTRIPLEDES-CBC");
        paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher.PBEWITHSHA1ANDDESEDE-CBC", "PBEWITHSHAAND3-KEYTRIPLEDES-CBC");
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$KeyGenerator");
      paramConfigurableProvider.addAlgorithm("KeyGenerator.DESEDE", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("KeyGenerator.");
      ((StringBuilder)localObject).append(PKCSObjectIdentifiers.des_EDE3_CBC);
      localObject = ((StringBuilder)localObject).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$KeyGenerator3");
      paramConfigurableProvider.addAlgorithm((String)localObject, localStringBuilder.toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$KeyGenerator");
      paramConfigurableProvider.addAlgorithm("KeyGenerator.DESEDEWRAP", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$KeyFactory");
      paramConfigurableProvider.addAlgorithm("SecretKeyFactory.DESEDE", ((StringBuilder)localObject).toString());
      localObject = OIWObjectIdentifiers.desEDE;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$KeyFactory");
      paramConfigurableProvider.addAlgorithm("SecretKeyFactory", (ASN1ObjectIdentifier)localObject, localStringBuilder.toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$CMAC");
      paramConfigurableProvider.addAlgorithm("Mac.DESEDECMAC", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$CBCMAC");
      paramConfigurableProvider.addAlgorithm("Mac.DESEDEMAC", ((StringBuilder)localObject).toString());
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Mac.DESEDE", "DESEDEMAC");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$DESedeCFB8");
      paramConfigurableProvider.addAlgorithm("Mac.DESEDEMAC/CFB8", ((StringBuilder)localObject).toString());
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Mac.DESEDE/CFB8", "DESEDEMAC/CFB8");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$DESede64");
      paramConfigurableProvider.addAlgorithm("Mac.DESEDEMAC64", ((StringBuilder)localObject).toString());
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Mac.DESEDE64", "DESEDEMAC64");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$DESede64with7816d4");
      paramConfigurableProvider.addAlgorithm("Mac.DESEDEMAC64WITHISO7816-4PADDING", ((StringBuilder)localObject).toString());
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Mac.DESEDE64WITHISO7816-4PADDING", "DESEDEMAC64WITHISO7816-4PADDING");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Mac.DESEDEISO9797ALG1MACWITHISO7816-4PADDING", "DESEDEMAC64WITHISO7816-4PADDING");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Mac.DESEDEISO9797ALG1WITHISO7816-4PADDING", "DESEDEMAC64WITHISO7816-4PADDING");
      paramConfigurableProvider.addAlgorithm("AlgorithmParameters.DESEDE", "org.bouncycastle.jcajce.provider.symmetric.util.IvAlgorithmParameters");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Alg.Alias.AlgorithmParameters.");
      ((StringBuilder)localObject).append(PKCSObjectIdentifiers.des_EDE3_CBC);
      paramConfigurableProvider.addAlgorithm(((StringBuilder)localObject).toString(), "DESEDE");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$AlgParamGen");
      paramConfigurableProvider.addAlgorithm("AlgorithmParameterGenerator.DESEDE", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Alg.Alias.AlgorithmParameterGenerator.");
      ((StringBuilder)localObject).append(PKCSObjectIdentifiers.des_EDE3_CBC);
      paramConfigurableProvider.addAlgorithm(((StringBuilder)localObject).toString(), "DESEDE");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$PBEWithSHAAndDES3KeyFactory");
      paramConfigurableProvider.addAlgorithm("SecretKeyFactory.PBEWITHSHAAND3-KEYTRIPLEDES-CBC", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$PBEWithSHAAndDES2KeyFactory");
      paramConfigurableProvider.addAlgorithm("SecretKeyFactory.PBEWITHSHAAND2-KEYTRIPLEDES-CBC", ((StringBuilder)localObject).toString());
      paramConfigurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.PBEWITHSHAAND3-KEYTRIPLEDES", "PKCS12PBE");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.PBEWITHSHAAND2-KEYTRIPLEDES", "PKCS12PBE");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.PBEWITHSHAAND3-KEYTRIPLEDES-CBC", "PKCS12PBE");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.PBEWITHSHAAND2-KEYTRIPLEDES-CBC", "PKCS12PBE");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.PBEWITHSHAANDDES3KEY-CBC", "PKCS12PBE");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.PBEWITHSHAANDDES2KEY-CBC", "PKCS12PBE");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.SecretKeyFactory.1.2.840.113549.1.12.1.3", "PBEWITHSHAAND3-KEYTRIPLEDES-CBC");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.SecretKeyFactory.1.2.840.113549.1.12.1.4", "PBEWITHSHAAND2-KEYTRIPLEDES-CBC");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.SecretKeyFactory.PBEWithSHAAnd3KeyTripleDES", "PBEWITHSHAAND3-KEYTRIPLEDES-CBC");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.1.2.840.113549.1.12.1.3", "PKCS12PBE");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.1.2.840.113549.1.12.1.4", "PKCS12PBE");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher.PBEWithSHAAnd3KeyTripleDES", "PBEWITHSHAAND3-KEYTRIPLEDES-CBC");
    }
  }
  
  public static class PBEWithSHAAndDES2Key
    extends BaseBlockCipher
  {
    public PBEWithSHAAndDES2Key()
    {
      super(2, 1, 128, 8);
    }
  }
  
  public static class PBEWithSHAAndDES2KeyFactory
    extends DES.DESPBEKeyFactory
  {
    public PBEWithSHAAndDES2KeyFactory()
    {
      super(PKCSObjectIdentifiers.pbeWithSHAAnd2_KeyTripleDES_CBC, true, 2, 1, 128, 64);
    }
  }
  
  public static class PBEWithSHAAndDES3Key
    extends BaseBlockCipher
  {
    public PBEWithSHAAndDES3Key()
    {
      super(2, 1, 192, 8);
    }
  }
  
  public static class PBEWithSHAAndDES3KeyFactory
    extends DES.DESPBEKeyFactory
  {
    public PBEWithSHAAndDES3KeyFactory()
    {
      super(PKCSObjectIdentifiers.pbeWithSHAAnd3_KeyTripleDES_CBC, true, 2, 1, 192, 64);
    }
  }
  
  public static class RFC3211
    extends BaseWrapCipher
  {
    public RFC3211()
    {
      super(8);
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
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\symmetric\DESede.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */