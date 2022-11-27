package org.bouncycastle.jcajce.provider.symmetric;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import javax.crypto.SecretKey;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.crypto.CipherKeyGenerator;
import org.bouncycastle.crypto.KeyGenerationParameters;
import org.bouncycastle.crypto.engines.DESEngine;
import org.bouncycastle.crypto.engines.RFC3211WrapEngine;
import org.bouncycastle.crypto.generators.DESKeyGenerator;
import org.bouncycastle.crypto.macs.CBCBlockCipherMac;
import org.bouncycastle.crypto.macs.CFBBlockCipherMac;
import org.bouncycastle.crypto.macs.CMac;
import org.bouncycastle.crypto.macs.ISO9797Alg3Mac;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.crypto.paddings.ISO7816d4Padding;
import org.bouncycastle.crypto.params.DESParameters;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import org.bouncycastle.jcajce.provider.symmetric.util.BCPBEKey;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameterGenerator;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseMac;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseSecretKeyFactory;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseWrapCipher;
import org.bouncycastle.jcajce.provider.symmetric.util.PBE.Util;
import org.bouncycastle.jcajce.provider.util.AlgorithmProvider;

public final class DES
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
  
  public static class DES64
    extends BaseMac
  {
    public DES64()
    {
      super();
    }
  }
  
  public static class DES64with7816d4
    extends BaseMac
  {
    public DES64with7816d4()
    {
      super();
    }
  }
  
  public static class DES9797Alg3
    extends BaseMac
  {
    public DES9797Alg3()
    {
      super();
    }
  }
  
  public static class DES9797Alg3with7816d4
    extends BaseMac
  {
    public DES9797Alg3with7816d4()
    {
      super();
    }
  }
  
  public static class DESCFB8
    extends BaseMac
  {
    public DESCFB8()
    {
      super();
    }
  }
  
  public static class DESPBEKeyFactory
    extends BaseSecretKeyFactory
  {
    private int digest;
    private boolean forCipher;
    private int ivSize;
    private int keySize;
    private int scheme;
    
    public DESPBEKeyFactory(String paramString, ASN1ObjectIdentifier paramASN1ObjectIdentifier, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      super(paramASN1ObjectIdentifier);
      this.forCipher = paramBoolean;
      this.scheme = paramInt1;
      this.digest = paramInt2;
      this.keySize = paramInt3;
      this.ivSize = paramInt4;
    }
    
    protected SecretKey engineGenerateSecret(KeySpec paramKeySpec)
      throws InvalidKeySpecException
    {
      if ((paramKeySpec instanceof PBEKeySpec))
      {
        PBEKeySpec localPBEKeySpec = (PBEKeySpec)paramKeySpec;
        if (localPBEKeySpec.getSalt() == null) {
          return new BCPBEKey(this.algName, this.algOid, this.scheme, this.digest, this.keySize, this.ivSize, localPBEKeySpec, null);
        }
        if (this.forCipher) {
          paramKeySpec = PBE.Util.makePBEParameters(localPBEKeySpec, this.scheme, this.digest, this.keySize, this.ivSize);
        } else {
          paramKeySpec = PBE.Util.makePBEMacParameters(localPBEKeySpec, this.scheme, this.digest, this.keySize);
        }
        KeyParameter localKeyParameter;
        if ((paramKeySpec instanceof ParametersWithIV)) {
          localKeyParameter = (KeyParameter)((ParametersWithIV)paramKeySpec).getParameters();
        } else {
          localKeyParameter = (KeyParameter)paramKeySpec;
        }
        DESParameters.setOddParity(localKeyParameter.getKey());
        return new BCPBEKey(this.algName, this.algOid, this.scheme, this.digest, this.keySize, this.ivSize, localPBEKeySpec, paramKeySpec);
      }
      throw new InvalidKeySpecException("Invalid KeySpec");
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
      if ((paramKeySpec instanceof DESKeySpec)) {
        return new SecretKeySpec(((DESKeySpec)paramKeySpec).getKey(), "DES");
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
          if (DESKeySpec.class.isAssignableFrom(paramClass))
          {
            paramSecretKey = paramSecretKey.getEncoded();
            try
            {
              paramSecretKey = new DESKeySpec(paramSecretKey);
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
    public KeyGenerator()
    {
      super(64, new DESKeyGenerator());
    }
    
    protected SecretKey engineGenerateKey()
    {
      if (this.uninitialised)
      {
        this.engine.init(new KeyGenerationParameters(new SecureRandom(), this.defaultKeySize));
        this.uninitialised = false;
      }
      return new SecretKeySpec(this.engine.generateKey(), this.algName);
    }
    
    protected void engineInit(int paramInt, SecureRandom paramSecureRandom)
    {
      super.engineInit(paramInt, paramSecureRandom);
    }
  }
  
  public static class Mappings
    extends AlgorithmProvider
  {
    private static final String PACKAGE = "org.bouncycastle.jcajce.provider.symmetric";
    private static final String PREFIX = DES.class.getName();
    
    private void addAlias(ConfigurableProvider paramConfigurableProvider, ASN1ObjectIdentifier paramASN1ObjectIdentifier, String paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Alg.Alias.KeyGenerator.");
      localStringBuilder.append(paramASN1ObjectIdentifier.getId());
      paramConfigurableProvider.addAlgorithm(localStringBuilder.toString(), paramString);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Alg.Alias.KeyFactory.");
      localStringBuilder.append(paramASN1ObjectIdentifier.getId());
      paramConfigurableProvider.addAlgorithm(localStringBuilder.toString(), paramString);
    }
    
    public void configure(ConfigurableProvider paramConfigurableProvider)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$ECB");
      paramConfigurableProvider.addAlgorithm("Cipher.DES", ((StringBuilder)localObject).toString());
      localObject = OIWObjectIdentifiers.desCBC;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$CBC");
      paramConfigurableProvider.addAlgorithm("Cipher", (ASN1ObjectIdentifier)localObject, localStringBuilder.toString());
      addAlias(paramConfigurableProvider, OIWObjectIdentifiers.desCBC, "DES");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$RFC3211");
      paramConfigurableProvider.addAlgorithm("Cipher.DESRFC3211WRAP", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$KeyGenerator");
      paramConfigurableProvider.addAlgorithm("KeyGenerator.DES", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$KeyFactory");
      paramConfigurableProvider.addAlgorithm("SecretKeyFactory.DES", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$CMAC");
      paramConfigurableProvider.addAlgorithm("Mac.DESCMAC", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$CBCMAC");
      paramConfigurableProvider.addAlgorithm("Mac.DESMAC", ((StringBuilder)localObject).toString());
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Mac.DES", "DESMAC");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$DESCFB8");
      paramConfigurableProvider.addAlgorithm("Mac.DESMAC/CFB8", ((StringBuilder)localObject).toString());
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Mac.DES/CFB8", "DESMAC/CFB8");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$DES64");
      paramConfigurableProvider.addAlgorithm("Mac.DESMAC64", ((StringBuilder)localObject).toString());
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Mac.DES64", "DESMAC64");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$DES64with7816d4");
      paramConfigurableProvider.addAlgorithm("Mac.DESMAC64WITHISO7816-4PADDING", ((StringBuilder)localObject).toString());
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Mac.DES64WITHISO7816-4PADDING", "DESMAC64WITHISO7816-4PADDING");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Mac.DESISO9797ALG1MACWITHISO7816-4PADDING", "DESMAC64WITHISO7816-4PADDING");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Mac.DESISO9797ALG1WITHISO7816-4PADDING", "DESMAC64WITHISO7816-4PADDING");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$DES9797Alg3");
      paramConfigurableProvider.addAlgorithm("Mac.DESWITHISO9797", ((StringBuilder)localObject).toString());
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Mac.DESISO9797MAC", "DESWITHISO9797");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$DES9797Alg3");
      paramConfigurableProvider.addAlgorithm("Mac.ISO9797ALG3MAC", ((StringBuilder)localObject).toString());
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Mac.ISO9797ALG3", "ISO9797ALG3MAC");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$DES9797Alg3with7816d4");
      paramConfigurableProvider.addAlgorithm("Mac.ISO9797ALG3WITHISO7816-4PADDING", ((StringBuilder)localObject).toString());
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Mac.ISO9797ALG3MACWITHISO7816-4PADDING", "ISO9797ALG3WITHISO7816-4PADDING");
      paramConfigurableProvider.addAlgorithm("AlgorithmParameters.DES", "org.bouncycastle.jcajce.provider.symmetric.util.IvAlgorithmParameters");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters", OIWObjectIdentifiers.desCBC, "DES");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$AlgParamGen");
      paramConfigurableProvider.addAlgorithm("AlgorithmParameterGenerator.DES", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Alg.Alias.AlgorithmParameterGenerator.");
      ((StringBuilder)localObject).append(OIWObjectIdentifiers.desCBC);
      paramConfigurableProvider.addAlgorithm(((StringBuilder)localObject).toString(), "DES");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$PBEWithMD2");
      paramConfigurableProvider.addAlgorithm("Cipher.PBEWITHMD2ANDDES", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$PBEWithMD5");
      paramConfigurableProvider.addAlgorithm("Cipher.PBEWITHMD5ANDDES", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$PBEWithSHA1");
      paramConfigurableProvider.addAlgorithm("Cipher.PBEWITHSHA1ANDDES", ((StringBuilder)localObject).toString());
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher", PKCSObjectIdentifiers.pbeWithMD2AndDES_CBC, "PBEWITHMD2ANDDES");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher", PKCSObjectIdentifiers.pbeWithMD5AndDES_CBC, "PBEWITHMD5ANDDES");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher", PKCSObjectIdentifiers.pbeWithSHA1AndDES_CBC, "PBEWITHSHA1ANDDES");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher.PBEWITHMD2ANDDES-CBC", "PBEWITHMD2ANDDES");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher.PBEWITHMD5ANDDES-CBC", "PBEWITHMD5ANDDES");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher.PBEWITHSHA1ANDDES-CBC", "PBEWITHSHA1ANDDES");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$PBEWithMD2KeyFactory");
      paramConfigurableProvider.addAlgorithm("SecretKeyFactory.PBEWITHMD2ANDDES", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$PBEWithMD5KeyFactory");
      paramConfigurableProvider.addAlgorithm("SecretKeyFactory.PBEWITHMD5ANDDES", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$PBEWithSHA1KeyFactory");
      paramConfigurableProvider.addAlgorithm("SecretKeyFactory.PBEWITHSHA1ANDDES", ((StringBuilder)localObject).toString());
      paramConfigurableProvider.addAlgorithm("Alg.Alias.SecretKeyFactory.PBEWITHMD2ANDDES-CBC", "PBEWITHMD2ANDDES");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.SecretKeyFactory.PBEWITHMD5ANDDES-CBC", "PBEWITHMD5ANDDES");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.SecretKeyFactory.PBEWITHSHA1ANDDES-CBC", "PBEWITHSHA1ANDDES");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Alg.Alias.SecretKeyFactory.");
      ((StringBuilder)localObject).append(PKCSObjectIdentifiers.pbeWithMD2AndDES_CBC);
      paramConfigurableProvider.addAlgorithm(((StringBuilder)localObject).toString(), "PBEWITHMD2ANDDES");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Alg.Alias.SecretKeyFactory.");
      ((StringBuilder)localObject).append(PKCSObjectIdentifiers.pbeWithMD5AndDES_CBC);
      paramConfigurableProvider.addAlgorithm(((StringBuilder)localObject).toString(), "PBEWITHMD5ANDDES");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Alg.Alias.SecretKeyFactory.");
      ((StringBuilder)localObject).append(PKCSObjectIdentifiers.pbeWithSHA1AndDES_CBC);
      paramConfigurableProvider.addAlgorithm(((StringBuilder)localObject).toString(), "PBEWITHSHA1ANDDES");
    }
  }
  
  public static class PBEWithMD2
    extends BaseBlockCipher
  {
    public PBEWithMD2()
    {
      super(0, 5, 64, 8);
    }
  }
  
  public static class PBEWithMD2KeyFactory
    extends DES.DESPBEKeyFactory
  {
    public PBEWithMD2KeyFactory()
    {
      super(PKCSObjectIdentifiers.pbeWithMD2AndDES_CBC, true, 0, 5, 64, 64);
    }
  }
  
  public static class PBEWithMD5
    extends BaseBlockCipher
  {
    public PBEWithMD5()
    {
      super(0, 0, 64, 8);
    }
  }
  
  public static class PBEWithMD5KeyFactory
    extends DES.DESPBEKeyFactory
  {
    public PBEWithMD5KeyFactory()
    {
      super(PKCSObjectIdentifiers.pbeWithMD5AndDES_CBC, true, 0, 0, 64, 64);
    }
  }
  
  public static class PBEWithSHA1
    extends BaseBlockCipher
  {
    public PBEWithSHA1()
    {
      super(0, 1, 64, 8);
    }
  }
  
  public static class PBEWithSHA1KeyFactory
    extends DES.DESPBEKeyFactory
  {
    public PBEWithSHA1KeyFactory()
    {
      super(PKCSObjectIdentifiers.pbeWithSHA1AndDES_CBC, true, 0, 1, 64, 64);
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
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\symmetric\DES.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */