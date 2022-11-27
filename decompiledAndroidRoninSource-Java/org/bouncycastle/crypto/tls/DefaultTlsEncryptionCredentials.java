package org.bouncycastle.crypto.tls;

import java.io.IOException;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.RSAKeyParameters;

public class DefaultTlsEncryptionCredentials
  extends AbstractTlsEncryptionCredentials
{
  protected Certificate certificate;
  protected TlsContext context;
  protected AsymmetricKeyParameter privateKey;
  
  public DefaultTlsEncryptionCredentials(TlsContext paramTlsContext, Certificate paramCertificate, AsymmetricKeyParameter paramAsymmetricKeyParameter)
  {
    if (paramCertificate != null)
    {
      if (!paramCertificate.isEmpty())
      {
        if (paramAsymmetricKeyParameter != null)
        {
          if (paramAsymmetricKeyParameter.isPrivate())
          {
            if ((paramAsymmetricKeyParameter instanceof RSAKeyParameters))
            {
              this.context = paramTlsContext;
              this.certificate = paramCertificate;
              this.privateKey = paramAsymmetricKeyParameter;
              return;
            }
            paramTlsContext = new StringBuilder();
            paramTlsContext.append("'privateKey' type not supported: ");
            paramTlsContext.append(paramAsymmetricKeyParameter.getClass().getName());
            throw new IllegalArgumentException(paramTlsContext.toString());
          }
          throw new IllegalArgumentException("'privateKey' must be private");
        }
        throw new IllegalArgumentException("'privateKey' cannot be null");
      }
      throw new IllegalArgumentException("'certificate' cannot be empty");
    }
    throw new IllegalArgumentException("'certificate' cannot be null");
  }
  
  public byte[] decryptPreMasterSecret(byte[] paramArrayOfByte)
    throws IOException
  {
    return TlsRSAUtils.safeDecryptPreMasterSecret(this.context, (RSAKeyParameters)this.privateKey, paramArrayOfByte);
  }
  
  public Certificate getCertificate()
  {
    return this.certificate;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\DefaultTlsEncryptionCredentials.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */