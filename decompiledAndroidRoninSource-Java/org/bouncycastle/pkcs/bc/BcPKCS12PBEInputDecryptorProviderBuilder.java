package org.bouncycastle.pkcs.bc;

import java.io.InputStream;
import org.bouncycastle.asn1.pkcs.PKCS12PBEParams;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.crypto.ExtendedDigest;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.crypto.generators.PKCS12ParametersGenerator;
import org.bouncycastle.crypto.io.CipherInputStream;
import org.bouncycastle.crypto.paddings.PaddedBufferedBlockCipher;
import org.bouncycastle.operator.GenericKey;
import org.bouncycastle.operator.InputDecryptor;
import org.bouncycastle.operator.InputDecryptorProvider;

public class BcPKCS12PBEInputDecryptorProviderBuilder
{
  private ExtendedDigest digest;
  
  public BcPKCS12PBEInputDecryptorProviderBuilder()
  {
    this(new SHA1Digest());
  }
  
  public BcPKCS12PBEInputDecryptorProviderBuilder(ExtendedDigest paramExtendedDigest)
  {
    this.digest = paramExtendedDigest;
  }
  
  public InputDecryptorProvider build(final char[] paramArrayOfChar)
  {
    new InputDecryptorProvider()
    {
      public InputDecryptor get(final AlgorithmIdentifier paramAnonymousAlgorithmIdentifier)
      {
        final PaddedBufferedBlockCipher localPaddedBufferedBlockCipher = PKCS12PBEUtils.getEngine(paramAnonymousAlgorithmIdentifier.getAlgorithm());
        PKCS12PBEParams localPKCS12PBEParams = PKCS12PBEParams.getInstance(paramAnonymousAlgorithmIdentifier.getParameters());
        localPaddedBufferedBlockCipher.init(false, PKCS12PBEUtils.createCipherParameters(paramAnonymousAlgorithmIdentifier.getAlgorithm(), BcPKCS12PBEInputDecryptorProviderBuilder.this.digest, localPaddedBufferedBlockCipher.getBlockSize(), localPKCS12PBEParams, paramArrayOfChar));
        new InputDecryptor()
        {
          public AlgorithmIdentifier getAlgorithmIdentifier()
          {
            return paramAnonymousAlgorithmIdentifier;
          }
          
          public InputStream getInputStream(InputStream paramAnonymous2InputStream)
          {
            return new CipherInputStream(paramAnonymous2InputStream, localPaddedBufferedBlockCipher);
          }
          
          public GenericKey getKey()
          {
            return new GenericKey(PKCS12ParametersGenerator.PKCS12PasswordToBytes(BcPKCS12PBEInputDecryptorProviderBuilder.1.this.val$password));
          }
        };
      }
    };
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pkcs\bc\BcPKCS12PBEInputDecryptorProviderBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */