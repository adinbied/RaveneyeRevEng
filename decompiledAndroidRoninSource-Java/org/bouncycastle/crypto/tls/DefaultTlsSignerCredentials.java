package org.bouncycastle.crypto.tls;

import java.io.IOException;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.DSAPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.RSAKeyParameters;

public class DefaultTlsSignerCredentials
  extends AbstractTlsSignerCredentials
{
  protected Certificate certificate;
  protected TlsContext context;
  protected AsymmetricKeyParameter privateKey;
  protected SignatureAndHashAlgorithm signatureAndHashAlgorithm;
  protected TlsSigner signer;
  
  public DefaultTlsSignerCredentials(TlsContext paramTlsContext, Certificate paramCertificate, AsymmetricKeyParameter paramAsymmetricKeyParameter)
  {
    this(paramTlsContext, paramCertificate, paramAsymmetricKeyParameter, null);
  }
  
  public DefaultTlsSignerCredentials(TlsContext paramTlsContext, Certificate paramCertificate, AsymmetricKeyParameter paramAsymmetricKeyParameter, SignatureAndHashAlgorithm paramSignatureAndHashAlgorithm)
  {
    if (paramCertificate != null)
    {
      if (!paramCertificate.isEmpty())
      {
        if (paramAsymmetricKeyParameter != null)
        {
          if (paramAsymmetricKeyParameter.isPrivate())
          {
            if ((TlsUtils.isTLSv12(paramTlsContext)) && (paramSignatureAndHashAlgorithm == null)) {
              throw new IllegalArgumentException("'signatureAndHashAlgorithm' cannot be null for (D)TLS 1.2+");
            }
            Object localObject;
            if ((paramAsymmetricKeyParameter instanceof RSAKeyParameters)) {
              localObject = new TlsRSASigner();
            }
            for (;;)
            {
              this.signer = ((TlsSigner)localObject);
              break;
              if ((paramAsymmetricKeyParameter instanceof DSAPrivateKeyParameters))
              {
                localObject = new TlsDSSSigner();
              }
              else
              {
                if (!(paramAsymmetricKeyParameter instanceof ECPrivateKeyParameters)) {
                  break label146;
                }
                localObject = new TlsECDSASigner();
              }
            }
            this.signer.init(paramTlsContext);
            this.context = paramTlsContext;
            this.certificate = paramCertificate;
            this.privateKey = paramAsymmetricKeyParameter;
            this.signatureAndHashAlgorithm = paramSignatureAndHashAlgorithm;
            return;
            label146:
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
  
  public byte[] generateCertificateSignature(byte[] paramArrayOfByte)
    throws IOException
  {
    try
    {
      if (TlsUtils.isTLSv12(this.context)) {
        return this.signer.generateRawSignature(this.signatureAndHashAlgorithm, this.privateKey, paramArrayOfByte);
      }
      paramArrayOfByte = this.signer.generateRawSignature(this.privateKey, paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (CryptoException paramArrayOfByte)
    {
      throw new TlsFatalAlert((short)80, paramArrayOfByte);
    }
  }
  
  public Certificate getCertificate()
  {
    return this.certificate;
  }
  
  public SignatureAndHashAlgorithm getSignatureAndHashAlgorithm()
  {
    return this.signatureAndHashAlgorithm;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\DefaultTlsSignerCredentials.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */