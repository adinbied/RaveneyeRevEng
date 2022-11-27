package org.bouncycastle.jcajce.provider.symmetric;

import java.io.IOException;
import java.math.BigInteger;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.RC2ParameterSpec;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.RC2CBCParameter;
import org.bouncycastle.crypto.CipherKeyGenerator;
import org.bouncycastle.crypto.engines.RC2Engine;
import org.bouncycastle.crypto.engines.RC2WrapEngine;
import org.bouncycastle.crypto.macs.CBCBlockCipherMac;
import org.bouncycastle.crypto.macs.CFBBlockCipherMac;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameterGenerator;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameters;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseMac;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseWrapCipher;
import org.bouncycastle.jcajce.provider.symmetric.util.PBESecretKeyFactory;
import org.bouncycastle.jcajce.provider.util.AlgorithmProvider;
import org.bouncycastle.util.Arrays;

public final class RC2
{
  public static class AlgParamGen
    extends BaseAlgorithmParameterGenerator
  {
    RC2ParameterSpec spec = null;
    
    protected AlgorithmParameters engineGenerateParameters()
    {
      if (this.spec == null)
      {
        byte[] arrayOfByte = new byte[8];
        if (this.random == null) {
          this.random = new SecureRandom();
        }
        this.random.nextBytes(arrayOfByte);
        try
        {
          AlgorithmParameters localAlgorithmParameters2 = createParametersInstance("RC2");
          localAlgorithmParameters2.init(new IvParameterSpec(arrayOfByte));
          return localAlgorithmParameters2;
        }
        catch (Exception localException1)
        {
          throw new RuntimeException(localException1.getMessage());
        }
      }
      try
      {
        AlgorithmParameters localAlgorithmParameters1 = createParametersInstance("RC2");
        localAlgorithmParameters1.init(this.spec);
        return localAlgorithmParameters1;
      }
      catch (Exception localException2)
      {
        throw new RuntimeException(localException2.getMessage());
      }
    }
    
    protected void engineInit(AlgorithmParameterSpec paramAlgorithmParameterSpec, SecureRandom paramSecureRandom)
      throws InvalidAlgorithmParameterException
    {
      if ((paramAlgorithmParameterSpec instanceof RC2ParameterSpec))
      {
        this.spec = ((RC2ParameterSpec)paramAlgorithmParameterSpec);
        return;
      }
      throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for RC2 parameter generation.");
    }
  }
  
  public static class AlgParams
    extends BaseAlgorithmParameters
  {
    private static final short[] ekb = { 93, 190, 155, 139, 17, 153, 110, 77, 89, 243, 133, 166, 63, 183, 131, 197, 228, 115, 107, 58, 104, 90, 192, 71, 160, 100, 52, 12, 241, 208, 82, 165, 185, 30, 150, 67, 65, 216, 212, 44, 219, 248, 7, 119, 42, 202, 235, 239, 16, 28, 22, 13, 56, 114, 47, 137, 193, 249, 128, 196, 109, 174, 48, 61, 206, 32, 99, 254, 230, 26, 199, 184, 80, 232, 36, 23, 252, 37, 111, 187, 106, 163, 68, 83, 217, 162, 1, 171, 188, 182, 31, 152, 238, 154, 167, 45, 79, 158, 142, 172, 224, 198, 73, 70, 41, 244, 148, 138, 175, 225, 91, 195, 179, 123, 87, 209, 124, 156, 237, 135, 64, 140, 226, 203, 147, 20, 201, 97, 46, 229, 204, 246, 94, 168, 92, 214, 117, 141, 98, 149, 88, 105, 118, 161, 74, 181, 85, 9, 120, 51, 130, 215, 221, 121, 245, 27, 11, 222, 38, 33, 40, 116, 4, 151, 86, 223, 60, 240, 55, 57, 220, 255, 6, 164, 234, 66, 8, 218, 180, 113, 176, 207, 18, 122, 78, 250, 108, 29, 132, 0, 200, 127, 145, 69, 170, 43, 194, 177, 143, 213, 186, 242, 173, 25, 178, 103, 54, 247, 15, 10, 146, 125, 227, 157, 233, 144, 62, 35, 39, 102, 19, 236, 129, 21, 189, 34, 191, 159, 126, 169, 81, 75, 76, 251, 2, 211, 112, 134, 49, 231, 59, 5, 3, 84, 96, 72, 101, 24, 210, 205, 95, 50, 136, 14, 53, 253 };
    private static final short[] table = { 189, 86, 234, 242, 162, 241, 172, 42, 176, 147, 209, 156, 27, 51, 253, 208, 48, 4, 182, 220, 125, 223, 50, 75, 247, 203, 69, 155, 49, 187, 33, 90, 65, 159, 225, 217, 74, 77, 158, 218, 160, 104, 44, 195, 39, 95, 128, 54, 62, 238, 251, 149, 26, 254, 206, 168, 52, 169, 19, 240, 166, 63, 216, 12, 120, 36, 175, 35, 82, 193, 103, 23, 245, 102, 144, 231, 232, 7, 184, 96, 72, 230, 30, 83, 243, 146, 164, 114, 140, 8, 21, 110, 134, 0, 132, 250, 244, 127, 138, 66, 25, 246, 219, 205, 20, 141, 80, 18, 186, 60, 6, 78, 236, 179, 53, 17, 161, 136, 142, 43, 148, 153, 183, 113, 116, 211, 228, 191, 58, 222, 150, 14, 188, 10, 237, 119, 252, 55, 107, 3, 121, 137, 98, 198, 215, 192, 210, 124, 106, 139, 34, 163, 91, 5, 93, 2, 117, 213, 97, 227, 24, 143, 85, 81, 173, 31, 11, 94, 133, 229, 194, 87, 99, 202, 61, 108, 180, 197, 204, 112, 178, 145, 89, 13, 71, 32, 200, 79, 88, 224, 1, 226, 22, 56, 196, 111, 59, 15, 101, 70, 190, 126, 45, 123, 130, 249, 64, 181, 29, 115, 248, 235, 38, 199, 135, 151, 37, 84, 177, 40, 170, 152, 157, 165, 100, 109, 122, 212, 16, 129, 68, 239, 73, 214, 174, 46, 221, 118, 92, 47, 167, 28, 201, 9, 105, 154, 131, 207, 41, 57, 185, 233, 76, 255, 67, 171 };
    private byte[] iv;
    private int parameterVersion = 58;
    
    protected byte[] engineGetEncoded()
    {
      return Arrays.clone(this.iv);
    }
    
    protected byte[] engineGetEncoded(String paramString)
      throws IOException
    {
      if (isASN1FormatString(paramString))
      {
        int i = this.parameterVersion;
        if (i == -1) {
          return new RC2CBCParameter(engineGetEncoded()).getEncoded();
        }
        return new RC2CBCParameter(i, engineGetEncoded()).getEncoded();
      }
      if (paramString.equals("RAW")) {
        return engineGetEncoded();
      }
      return null;
    }
    
    protected void engineInit(AlgorithmParameterSpec paramAlgorithmParameterSpec)
      throws InvalidParameterSpecException
    {
      if ((paramAlgorithmParameterSpec instanceof IvParameterSpec))
      {
        this.iv = ((IvParameterSpec)paramAlgorithmParameterSpec).getIV();
        return;
      }
      if ((paramAlgorithmParameterSpec instanceof RC2ParameterSpec))
      {
        paramAlgorithmParameterSpec = (RC2ParameterSpec)paramAlgorithmParameterSpec;
        int j = paramAlgorithmParameterSpec.getEffectiveKeyBits();
        if (j != -1)
        {
          int i = j;
          if (j < 256) {
            i = table[j];
          }
          this.parameterVersion = i;
        }
        this.iv = paramAlgorithmParameterSpec.getIV();
        return;
      }
      throw new InvalidParameterSpecException("IvParameterSpec or RC2ParameterSpec required to initialise a RC2 parameters algorithm parameters object");
    }
    
    protected void engineInit(byte[] paramArrayOfByte)
      throws IOException
    {
      this.iv = Arrays.clone(paramArrayOfByte);
    }
    
    protected void engineInit(byte[] paramArrayOfByte, String paramString)
      throws IOException
    {
      if (isASN1FormatString(paramString))
      {
        paramArrayOfByte = RC2CBCParameter.getInstance(ASN1Primitive.fromByteArray(paramArrayOfByte));
        if (paramArrayOfByte.getRC2ParameterVersion() != null) {
          this.parameterVersion = paramArrayOfByte.getRC2ParameterVersion().intValue();
        }
        this.iv = paramArrayOfByte.getIV();
        return;
      }
      if (paramString.equals("RAW"))
      {
        engineInit(paramArrayOfByte);
        return;
      }
      throw new IOException("Unknown parameters format in IV parameters object");
    }
    
    protected String engineToString()
    {
      return "RC2 Parameters";
    }
    
    protected AlgorithmParameterSpec localEngineGetParameterSpec(Class paramClass)
      throws InvalidParameterSpecException
    {
      if ((paramClass == RC2ParameterSpec.class) || (paramClass == AlgorithmParameterSpec.class))
      {
        int i = this.parameterVersion;
        if (i != -1)
        {
          if (i < 256) {
            return new RC2ParameterSpec(ekb[this.parameterVersion], this.iv);
          }
          return new RC2ParameterSpec(this.parameterVersion, this.iv);
        }
      }
      if ((paramClass != IvParameterSpec.class) && (paramClass != AlgorithmParameterSpec.class)) {
        throw new InvalidParameterSpecException("unknown parameter spec passed to RC2 parameters object.");
      }
      return new IvParameterSpec(this.iv);
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
  
  public static class CFB8MAC
    extends BaseMac
  {
    public CFB8MAC()
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
  
  public static class KeyGenerator
    extends BaseKeyGenerator
  {
    public KeyGenerator()
    {
      super(128, new CipherKeyGenerator());
    }
  }
  
  public static class Mappings
    extends AlgorithmProvider
  {
    private static final String PREFIX = RC2.class.getName();
    
    public void configure(ConfigurableProvider paramConfigurableProvider)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$AlgParamGen");
      paramConfigurableProvider.addAlgorithm("AlgorithmParameterGenerator.RC2", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$AlgParamGen");
      paramConfigurableProvider.addAlgorithm("AlgorithmParameterGenerator.1.2.840.113549.3.2", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$KeyGenerator");
      paramConfigurableProvider.addAlgorithm("KeyGenerator.RC2", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$KeyGenerator");
      paramConfigurableProvider.addAlgorithm("KeyGenerator.1.2.840.113549.3.2", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$AlgParams");
      paramConfigurableProvider.addAlgorithm("AlgorithmParameters.RC2", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$AlgParams");
      paramConfigurableProvider.addAlgorithm("AlgorithmParameters.1.2.840.113549.3.2", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$ECB");
      paramConfigurableProvider.addAlgorithm("Cipher.RC2", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$Wrap");
      paramConfigurableProvider.addAlgorithm("Cipher.RC2WRAP", ((StringBuilder)localObject).toString());
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher", PKCSObjectIdentifiers.id_alg_CMSRC2wrap, "RC2WRAP");
      localObject = PKCSObjectIdentifiers.RC2_CBC;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$CBC");
      paramConfigurableProvider.addAlgorithm("Cipher", (ASN1ObjectIdentifier)localObject, localStringBuilder.toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$CBCMAC");
      paramConfigurableProvider.addAlgorithm("Mac.RC2MAC", ((StringBuilder)localObject).toString());
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Mac.RC2", "RC2MAC");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$CFB8MAC");
      paramConfigurableProvider.addAlgorithm("Mac.RC2MAC/CFB8", ((StringBuilder)localObject).toString());
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Mac.RC2/CFB8", "RC2MAC/CFB8");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.SecretKeyFactory.PBEWITHMD2ANDRC2-CBC", "PBEWITHMD2ANDRC2");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.SecretKeyFactory.PBEWITHMD5ANDRC2-CBC", "PBEWITHMD5ANDRC2");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.SecretKeyFactory.PBEWITHSHA1ANDRC2-CBC", "PBEWITHSHA1ANDRC2");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.SecretKeyFactory", PKCSObjectIdentifiers.pbeWithMD2AndRC2_CBC, "PBEWITHMD2ANDRC2");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.SecretKeyFactory", PKCSObjectIdentifiers.pbeWithMD5AndRC2_CBC, "PBEWITHMD5ANDRC2");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.SecretKeyFactory", PKCSObjectIdentifiers.pbeWithSHA1AndRC2_CBC, "PBEWITHSHA1ANDRC2");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.SecretKeyFactory.1.2.840.113549.1.12.1.5", "PBEWITHSHAAND128BITRC2-CBC");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.SecretKeyFactory.1.2.840.113549.1.12.1.6", "PBEWITHSHAAND40BITRC2-CBC");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$PBEWithMD2KeyFactory");
      paramConfigurableProvider.addAlgorithm("SecretKeyFactory.PBEWITHMD2ANDRC2", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$PBEWithMD5KeyFactory");
      paramConfigurableProvider.addAlgorithm("SecretKeyFactory.PBEWITHMD5ANDRC2", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$PBEWithSHA1KeyFactory");
      paramConfigurableProvider.addAlgorithm("SecretKeyFactory.PBEWITHSHA1ANDRC2", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$PBEWithSHAAnd128BitKeyFactory");
      paramConfigurableProvider.addAlgorithm("SecretKeyFactory.PBEWITHSHAAND128BITRC2-CBC", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$PBEWithSHAAnd40BitKeyFactory");
      paramConfigurableProvider.addAlgorithm("SecretKeyFactory.PBEWITHSHAAND40BITRC2-CBC", ((StringBuilder)localObject).toString());
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher", PKCSObjectIdentifiers.pbeWithMD2AndRC2_CBC, "PBEWITHMD2ANDRC2");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher", PKCSObjectIdentifiers.pbeWithMD5AndRC2_CBC, "PBEWITHMD5ANDRC2");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher", PKCSObjectIdentifiers.pbeWithSHA1AndRC2_CBC, "PBEWITHSHA1ANDRC2");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.1.2.840.113549.1.12.1.5", "PKCS12PBE");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.1.2.840.113549.1.12.1.6", "PKCS12PBE");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.PBEWithSHAAnd3KeyTripleDES", "PKCS12PBE");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher", PKCSObjectIdentifiers.pbeWithSHAAnd128BitRC2_CBC, "PBEWITHSHAAND128BITRC2-CBC");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher", PKCSObjectIdentifiers.pbeWithSHAAnd40BitRC2_CBC, "PBEWITHSHAAND40BITRC2-CBC");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher.PBEWITHSHA1AND128BITRC2-CBC", "PBEWITHSHAAND128BITRC2-CBC");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher.PBEWITHSHA1AND40BITRC2-CBC", "PBEWITHSHAAND40BITRC2-CBC");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$PBEWithSHA1AndRC2");
      paramConfigurableProvider.addAlgorithm("Cipher.PBEWITHSHA1ANDRC2", ((StringBuilder)localObject).toString());
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher.PBEWITHSHAANDRC2-CBC", "PBEWITHSHA1ANDRC2");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher.PBEWITHSHA1ANDRC2-CBC", "PBEWITHSHA1ANDRC2");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$PBEWithSHAAnd128BitRC2");
      paramConfigurableProvider.addAlgorithm("Cipher.PBEWITHSHAAND128BITRC2-CBC", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$PBEWithSHAAnd40BitRC2");
      paramConfigurableProvider.addAlgorithm("Cipher.PBEWITHSHAAND40BITRC2-CBC", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PREFIX);
      ((StringBuilder)localObject).append("$PBEWithMD5AndRC2");
      paramConfigurableProvider.addAlgorithm("Cipher.PBEWITHMD5ANDRC2", ((StringBuilder)localObject).toString());
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Cipher.PBEWITHMD5ANDRC2-CBC", "PBEWITHMD5ANDRC2");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.PBEWITHSHA1ANDRC2", "PKCS12PBE");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.PBEWITHSHAANDRC2", "PKCS12PBE");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.PBEWITHSHA1ANDRC2-CBC", "PKCS12PBE");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.PBEWITHSHAAND40BITRC2-CBC", "PKCS12PBE");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.PBEWITHSHAAND128BITRC2-CBC", "PKCS12PBE");
    }
  }
  
  public static class PBEWithMD2KeyFactory
    extends PBESecretKeyFactory
  {
    public PBEWithMD2KeyFactory()
    {
      super(PKCSObjectIdentifiers.pbeWithMD2AndRC2_CBC, true, 0, 5, 64, 64);
    }
  }
  
  public static class PBEWithMD5AndRC2
    extends BaseBlockCipher
  {
    public PBEWithMD5AndRC2()
    {
      super(0, 0, 64, 8);
    }
  }
  
  public static class PBEWithMD5KeyFactory
    extends PBESecretKeyFactory
  {
    public PBEWithMD5KeyFactory()
    {
      super(PKCSObjectIdentifiers.pbeWithMD5AndRC2_CBC, true, 0, 0, 64, 64);
    }
  }
  
  public static class PBEWithSHA1AndRC2
    extends BaseBlockCipher
  {
    public PBEWithSHA1AndRC2()
    {
      super(0, 1, 64, 8);
    }
  }
  
  public static class PBEWithSHA1KeyFactory
    extends PBESecretKeyFactory
  {
    public PBEWithSHA1KeyFactory()
    {
      super(PKCSObjectIdentifiers.pbeWithSHA1AndRC2_CBC, true, 0, 1, 64, 64);
    }
  }
  
  public static class PBEWithSHAAnd128BitKeyFactory
    extends PBESecretKeyFactory
  {
    public PBEWithSHAAnd128BitKeyFactory()
    {
      super(PKCSObjectIdentifiers.pbeWithSHAAnd128BitRC2_CBC, true, 2, 1, 128, 64);
    }
  }
  
  public static class PBEWithSHAAnd128BitRC2
    extends BaseBlockCipher
  {
    public PBEWithSHAAnd128BitRC2()
    {
      super(2, 1, 128, 8);
    }
  }
  
  public static class PBEWithSHAAnd40BitKeyFactory
    extends PBESecretKeyFactory
  {
    public PBEWithSHAAnd40BitKeyFactory()
    {
      super(PKCSObjectIdentifiers.pbeWithSHAAnd40BitRC2_CBC, true, 2, 1, 40, 64);
    }
  }
  
  public static class PBEWithSHAAnd40BitRC2
    extends BaseBlockCipher
  {
    public PBEWithSHAAnd40BitRC2()
    {
      super(2, 1, 40, 8);
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\symmetric\RC2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */