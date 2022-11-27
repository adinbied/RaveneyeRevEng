package org.bouncycastle.jcajce.provider.symmetric;

import java.io.IOException;
import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.InvalidParameterSpecException;
import java.security.spec.KeySpec;
import javax.crypto.SecretKey;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PBKDF2Params;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import org.bouncycastle.jcajce.provider.symmetric.util.BCPBEKey;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameters;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseSecretKeyFactory;
import org.bouncycastle.jcajce.provider.symmetric.util.PBE.Util;
import org.bouncycastle.jcajce.provider.util.AlgorithmProvider;
import org.bouncycastle.jcajce.spec.PBKDF2KeySpec;

public class PBEPBKDF2
{
  public static class AlgParams
    extends BaseAlgorithmParameters
  {
    PBKDF2Params params;
    
    protected byte[] engineGetEncoded()
    {
      try
      {
        byte[] arrayOfByte = this.params.getEncoded("DER");
        return arrayOfByte;
      }
      catch (IOException localIOException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Oooops! ");
        localStringBuilder.append(localIOException.toString());
        throw new RuntimeException(localStringBuilder.toString());
      }
    }
    
    protected byte[] engineGetEncoded(String paramString)
    {
      if (isASN1FormatString(paramString)) {
        return engineGetEncoded();
      }
      return null;
    }
    
    protected void engineInit(AlgorithmParameterSpec paramAlgorithmParameterSpec)
      throws InvalidParameterSpecException
    {
      if ((paramAlgorithmParameterSpec instanceof PBEParameterSpec))
      {
        paramAlgorithmParameterSpec = (PBEParameterSpec)paramAlgorithmParameterSpec;
        this.params = new PBKDF2Params(paramAlgorithmParameterSpec.getSalt(), paramAlgorithmParameterSpec.getIterationCount());
        return;
      }
      throw new InvalidParameterSpecException("PBEParameterSpec required to initialise a PBKDF2 PBE parameters algorithm parameters object");
    }
    
    protected void engineInit(byte[] paramArrayOfByte)
      throws IOException
    {
      this.params = PBKDF2Params.getInstance(ASN1Primitive.fromByteArray(paramArrayOfByte));
    }
    
    protected void engineInit(byte[] paramArrayOfByte, String paramString)
      throws IOException
    {
      if (isASN1FormatString(paramString))
      {
        engineInit(paramArrayOfByte);
        return;
      }
      throw new IOException("Unknown parameters format in PBKDF2 parameters object");
    }
    
    protected String engineToString()
    {
      return "PBKDF2 Parameters";
    }
    
    protected AlgorithmParameterSpec localEngineGetParameterSpec(Class paramClass)
      throws InvalidParameterSpecException
    {
      if (paramClass == PBEParameterSpec.class) {
        return new PBEParameterSpec(this.params.getSalt(), this.params.getIterationCount().intValue());
      }
      throw new InvalidParameterSpecException("unknown parameter spec passed to PBKDF2 PBE parameters object.");
    }
  }
  
  public static class BasePBKDF2
    extends BaseSecretKeyFactory
  {
    private int defaultDigest;
    private int scheme;
    
    public BasePBKDF2(String paramString, int paramInt)
    {
      this(paramString, paramInt, 1);
    }
    
    public BasePBKDF2(String paramString, int paramInt1, int paramInt2)
    {
      super(PKCSObjectIdentifiers.id_PBKDF2);
      this.scheme = paramInt1;
      this.defaultDigest = paramInt2;
    }
    
    private int getDigestCode(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
      throws InvalidKeySpecException
    {
      if (paramASN1ObjectIdentifier.equals(CryptoProObjectIdentifiers.gostR3411Hmac)) {
        return 6;
      }
      if (paramASN1ObjectIdentifier.equals(PKCSObjectIdentifiers.id_hmacWithSHA1)) {
        return 1;
      }
      if (paramASN1ObjectIdentifier.equals(PKCSObjectIdentifiers.id_hmacWithSHA256)) {
        return 4;
      }
      if (paramASN1ObjectIdentifier.equals(PKCSObjectIdentifiers.id_hmacWithSHA224)) {
        return 7;
      }
      if (paramASN1ObjectIdentifier.equals(PKCSObjectIdentifiers.id_hmacWithSHA384)) {
        return 8;
      }
      if (paramASN1ObjectIdentifier.equals(PKCSObjectIdentifiers.id_hmacWithSHA512)) {
        return 9;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Invalid KeySpec: unknown PRF algorithm ");
      localStringBuilder.append(paramASN1ObjectIdentifier);
      throw new InvalidKeySpecException(localStringBuilder.toString());
    }
    
    protected SecretKey engineGenerateSecret(KeySpec paramKeySpec)
      throws InvalidKeySpecException
    {
      if ((paramKeySpec instanceof PBEKeySpec))
      {
        paramKeySpec = (PBEKeySpec)paramKeySpec;
        if (paramKeySpec.getSalt() != null)
        {
          if (paramKeySpec.getIterationCount() > 0)
          {
            if (paramKeySpec.getKeyLength() > 0)
            {
              if (paramKeySpec.getPassword().length != 0)
              {
                if ((paramKeySpec instanceof PBKDF2KeySpec))
                {
                  i = getDigestCode(((PBKDF2KeySpec)paramKeySpec).getPrf().getAlgorithm());
                  j = paramKeySpec.getKeyLength();
                  localObject = PBE.Util.makePBEMacParameters(paramKeySpec, this.scheme, i, j);
                  return new BCPBEKey(this.algName, this.algOid, this.scheme, i, j, -1, paramKeySpec, (CipherParameters)localObject);
                }
                int i = this.defaultDigest;
                int j = paramKeySpec.getKeyLength();
                localObject = PBE.Util.makePBEMacParameters(paramKeySpec, this.scheme, i, j);
                return new BCPBEKey(this.algName, this.algOid, this.scheme, i, j, -1, paramKeySpec, (CipherParameters)localObject);
              }
              throw new IllegalArgumentException("password empty");
            }
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("positive key length required: ");
            ((StringBuilder)localObject).append(paramKeySpec.getKeyLength());
            throw new InvalidKeySpecException(((StringBuilder)localObject).toString());
          }
          Object localObject = new StringBuilder();
          ((StringBuilder)localObject).append("positive iteration count required: ");
          ((StringBuilder)localObject).append(paramKeySpec.getIterationCount());
          throw new InvalidKeySpecException(((StringBuilder)localObject).toString());
        }
        throw new InvalidKeySpecException("missing required salt");
      }
      throw new InvalidKeySpecException("Invalid KeySpec");
    }
  }
  
  public static class Mappings
    extends AlgorithmProvider
  {
    private static final String PREFIX = PBEPBKDF2.class.getName();
    
    public void configure(ConfigurableProvider paramConfigurableProvider)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$AlgParams");
      paramConfigurableProvider.addAlgorithm("AlgorithmParameters.PBKDF2", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Alg.Alias.AlgorithmParameters.");
      localStringBuilder.append(PKCSObjectIdentifiers.id_PBKDF2);
      paramConfigurableProvider.addAlgorithm(localStringBuilder.toString(), "PBKDF2");
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$PBKDF2withUTF8");
      paramConfigurableProvider.addAlgorithm("SecretKeyFactory.PBKDF2", localStringBuilder.toString());
      paramConfigurableProvider.addAlgorithm("Alg.Alias.SecretKeyFactory.PBKDF2WITHHMACSHA1", "PBKDF2");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.SecretKeyFactory.PBKDF2WITHHMACSHA1ANDUTF8", "PBKDF2");
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Alg.Alias.SecretKeyFactory.");
      localStringBuilder.append(PKCSObjectIdentifiers.id_PBKDF2);
      paramConfigurableProvider.addAlgorithm(localStringBuilder.toString(), "PBKDF2");
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$PBKDF2with8BIT");
      paramConfigurableProvider.addAlgorithm("SecretKeyFactory.PBKDF2WITHASCII", localStringBuilder.toString());
      paramConfigurableProvider.addAlgorithm("Alg.Alias.SecretKeyFactory.PBKDF2WITH8BIT", "PBKDF2WITHASCII");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.SecretKeyFactory.PBKDF2WITHHMACSHA1AND8BIT", "PBKDF2WITHASCII");
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$PBKDF2withSHA224");
      paramConfigurableProvider.addAlgorithm("SecretKeyFactory.PBKDF2WITHHMACSHA224", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$PBKDF2withSHA256");
      paramConfigurableProvider.addAlgorithm("SecretKeyFactory.PBKDF2WITHHMACSHA256", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$PBKDF2withSHA384");
      paramConfigurableProvider.addAlgorithm("SecretKeyFactory.PBKDF2WITHHMACSHA384", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$PBKDF2withSHA512");
      paramConfigurableProvider.addAlgorithm("SecretKeyFactory.PBKDF2WITHHMACSHA512", localStringBuilder.toString());
    }
  }
  
  public static class PBKDF2with8BIT
    extends PBEPBKDF2.BasePBKDF2
  {
    public PBKDF2with8BIT()
    {
      super(1);
    }
  }
  
  public static class PBKDF2withSHA224
    extends PBEPBKDF2.BasePBKDF2
  {
    public PBKDF2withSHA224()
    {
      super(5, 7);
    }
  }
  
  public static class PBKDF2withSHA256
    extends PBEPBKDF2.BasePBKDF2
  {
    public PBKDF2withSHA256()
    {
      super(5, 4);
    }
  }
  
  public static class PBKDF2withSHA384
    extends PBEPBKDF2.BasePBKDF2
  {
    public PBKDF2withSHA384()
    {
      super(5, 8);
    }
  }
  
  public static class PBKDF2withSHA512
    extends PBEPBKDF2.BasePBKDF2
  {
    public PBKDF2withSHA512()
    {
      super(5, 9);
    }
  }
  
  public static class PBKDF2withUTF8
    extends PBEPBKDF2.BasePBKDF2
  {
    public PBKDF2withUTF8()
    {
      super(5);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\symmetric\PBEPBKDF2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */