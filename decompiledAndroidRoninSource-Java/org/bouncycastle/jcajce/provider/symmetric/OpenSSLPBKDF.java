package org.bouncycastle.jcajce.provider.symmetric;

import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import javax.crypto.SecretKey;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.crypto.generators.OpenSSLPBEParametersGenerator;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseSecretKeyFactory;
import org.bouncycastle.jcajce.provider.util.AlgorithmProvider;
import org.bouncycastle.util.Strings;

public final class OpenSSLPBKDF
{
  public static class Mappings
    extends AlgorithmProvider
  {
    private static final String PREFIX = OpenSSLPBKDF.class.getName();
    
    public void configure(ConfigurableProvider paramConfigurableProvider)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      localStringBuilder.append("$PBKDF");
      paramConfigurableProvider.addAlgorithm("SecretKeyFactory.PBKDF-OPENSSL", localStringBuilder.toString());
    }
  }
  
  public static class PBKDF
    extends BaseSecretKeyFactory
  {
    public PBKDF()
    {
      super(null);
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
                localObject = new OpenSSLPBEParametersGenerator();
                ((OpenSSLPBEParametersGenerator)localObject).init(Strings.toByteArray(paramKeySpec.getPassword()), paramKeySpec.getSalt());
                return new SecretKeySpec(((KeyParameter)((OpenSSLPBEParametersGenerator)localObject).generateDerivedParameters(paramKeySpec.getKeyLength())).getKey(), "OpenSSLPBKDF");
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
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\symmetric\OpenSSLPBKDF.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */