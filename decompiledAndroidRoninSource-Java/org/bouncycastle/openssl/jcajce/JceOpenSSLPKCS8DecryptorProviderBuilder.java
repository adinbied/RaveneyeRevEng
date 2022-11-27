package org.bouncycastle.openssl.jcajce;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.AlgorithmParameters;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.Provider;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.SecretKey;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.pkcs.EncryptionScheme;
import org.bouncycastle.asn1.pkcs.KeyDerivationFunc;
import org.bouncycastle.asn1.pkcs.PBEParameter;
import org.bouncycastle.asn1.pkcs.PBES2Parameters;
import org.bouncycastle.asn1.pkcs.PBKDF2Params;
import org.bouncycastle.asn1.pkcs.PKCS12PBEParams;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.crypto.CharToByteConverter;
import org.bouncycastle.jcajce.PBKDF1KeyWithParameters;
import org.bouncycastle.jcajce.PKCS12KeyWithParameters;
import org.bouncycastle.jcajce.util.DefaultJcaJceHelper;
import org.bouncycastle.jcajce.util.JcaJceHelper;
import org.bouncycastle.jcajce.util.NamedJcaJceHelper;
import org.bouncycastle.jcajce.util.ProviderJcaJceHelper;
import org.bouncycastle.openssl.PEMException;
import org.bouncycastle.operator.InputDecryptor;
import org.bouncycastle.operator.InputDecryptorProvider;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.util.Strings;

public class JceOpenSSLPKCS8DecryptorProviderBuilder
{
  private JcaJceHelper helper = new DefaultJcaJceHelper();
  
  public InputDecryptorProvider build(final char[] paramArrayOfChar)
    throws OperatorCreationException
  {
    new InputDecryptorProvider()
    {
      public InputDecryptor get(final AlgorithmIdentifier paramAnonymousAlgorithmIdentifier)
        throws OperatorCreationException
      {
        try
        {
          if (PEMUtilities.isPKCS5Scheme2(paramAnonymousAlgorithmIdentifier.getAlgorithm()))
          {
            localObject2 = PBES2Parameters.getInstance(paramAnonymousAlgorithmIdentifier.getParameters());
            localObject1 = ((PBES2Parameters)localObject2).getKeyDerivationFunc();
            localObject2 = ((PBES2Parameters)localObject2).getEncryptionScheme();
            localObject1 = (PBKDF2Params)((KeyDerivationFunc)localObject1).getParameters();
            int i = ((PBKDF2Params)localObject1).getIterationCount().intValue();
            localObject1 = ((PBKDF2Params)localObject1).getSalt();
            Object localObject3 = ((EncryptionScheme)localObject2).getAlgorithm().getId();
            SecretKey localSecretKey = PEMUtilities.generateSecretKeyForPKCS5Scheme2(JceOpenSSLPKCS8DecryptorProviderBuilder.this.helper, (String)localObject3, paramArrayOfChar, (byte[])localObject1, i);
            localObject1 = JceOpenSSLPKCS8DecryptorProviderBuilder.this.helper.createCipher((String)localObject3);
            localObject3 = JceOpenSSLPKCS8DecryptorProviderBuilder.this.helper.createAlgorithmParameters((String)localObject3);
            ((AlgorithmParameters)localObject3).init(((EncryptionScheme)localObject2).getParameters().toASN1Primitive().getEncoded());
            ((Cipher)localObject1).init(2, localSecretKey, (AlgorithmParameters)localObject3);
          }
          else
          {
            if (PEMUtilities.isPKCS12(paramAnonymousAlgorithmIdentifier.getAlgorithm()))
            {
              localObject2 = PKCS12PBEParams.getInstance(paramAnonymousAlgorithmIdentifier.getParameters());
              localObject1 = JceOpenSSLPKCS8DecryptorProviderBuilder.this.helper.createCipher(paramAnonymousAlgorithmIdentifier.getAlgorithm().getId());
            }
            for (localObject2 = new PKCS12KeyWithParameters(paramArrayOfChar, ((PKCS12PBEParams)localObject2).getIV(), ((PKCS12PBEParams)localObject2).getIterations().intValue());; localObject2 = new PBKDF1KeyWithParameters(paramArrayOfChar, new CharToByteConverter()
                {
                  public byte[] convert(char[] paramAnonymous2ArrayOfChar)
                  {
                    return Strings.toByteArray(paramAnonymous2ArrayOfChar);
                  }
                  
                  public String getType()
                  {
                    return "ASCII";
                  }
                }, ((PBEParameter)localObject2).getSalt(), ((PBEParameter)localObject2).getIterationCount().intValue()))
            {
              ((Cipher)localObject1).init(2, (Key)localObject2);
              break;
              if (!PEMUtilities.isPKCS5Scheme1(paramAnonymousAlgorithmIdentifier.getAlgorithm())) {
                break label306;
              }
              localObject2 = PBEParameter.getInstance(paramAnonymousAlgorithmIdentifier.getParameters());
              localObject1 = JceOpenSSLPKCS8DecryptorProviderBuilder.this.helper.createCipher(paramAnonymousAlgorithmIdentifier.getAlgorithm().getId());
            }
          }
          new InputDecryptor()
          {
            public AlgorithmIdentifier getAlgorithmIdentifier()
            {
              return paramAnonymousAlgorithmIdentifier;
            }
            
            public InputStream getInputStream(InputStream paramAnonymous2InputStream)
            {
              return new CipherInputStream(paramAnonymous2InputStream, localObject1);
            }
          };
          label306:
          final Object localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("Unknown algorithm: ");
          ((StringBuilder)localObject1).append(paramAnonymousAlgorithmIdentifier.getAlgorithm());
          throw new PEMException(((StringBuilder)localObject1).toString());
        }
        catch (GeneralSecurityException localGeneralSecurityException)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(paramAnonymousAlgorithmIdentifier.getAlgorithm());
          ((StringBuilder)localObject2).append(" not available: ");
          ((StringBuilder)localObject2).append(localGeneralSecurityException.getMessage());
          throw new OperatorCreationException(((StringBuilder)localObject2).toString(), localGeneralSecurityException);
        }
        catch (IOException localIOException)
        {
          Object localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(paramAnonymousAlgorithmIdentifier.getAlgorithm());
          ((StringBuilder)localObject2).append(" not available: ");
          ((StringBuilder)localObject2).append(localIOException.getMessage());
          throw new OperatorCreationException(((StringBuilder)localObject2).toString(), localIOException);
        }
      }
    };
  }
  
  public JceOpenSSLPKCS8DecryptorProviderBuilder setProvider(String paramString)
  {
    this.helper = new NamedJcaJceHelper(paramString);
    return this;
  }
  
  public JceOpenSSLPKCS8DecryptorProviderBuilder setProvider(Provider paramProvider)
  {
    this.helper = new ProviderJcaJceHelper(paramProvider);
    return this;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\openssl\jcajce\JceOpenSSLPKCS8DecryptorProviderBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */