package org.bouncycastle.crypto.tls;

import org.bouncycastle.crypto.BasicAgreement;
import org.bouncycastle.crypto.agreement.DHBasicAgreement;
import org.bouncycastle.crypto.agreement.ECDHBasicAgreement;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.DHPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.util.BigIntegers;

public class DefaultTlsAgreementCredentials
  extends AbstractTlsAgreementCredentials
{
  protected BasicAgreement basicAgreement;
  protected Certificate certificate;
  protected AsymmetricKeyParameter privateKey;
  protected boolean truncateAgreement;
  
  public DefaultTlsAgreementCredentials(Certificate paramCertificate, AsymmetricKeyParameter paramAsymmetricKeyParameter)
  {
    if (paramCertificate != null)
    {
      if (!paramCertificate.isEmpty())
      {
        if (paramAsymmetricKeyParameter != null)
        {
          if (paramAsymmetricKeyParameter.isPrivate())
          {
            if ((paramAsymmetricKeyParameter instanceof DHPrivateKeyParameters)) {
              this.basicAgreement = new DHBasicAgreement();
            }
            for (boolean bool = true;; bool = false)
            {
              this.truncateAgreement = bool;
              break;
              if (!(paramAsymmetricKeyParameter instanceof ECPrivateKeyParameters)) {
                break label88;
              }
              this.basicAgreement = new ECDHBasicAgreement();
            }
            this.certificate = paramCertificate;
            this.privateKey = paramAsymmetricKeyParameter;
            return;
            label88:
            paramCertificate = new StringBuilder();
            paramCertificate.append("'privateKey' type not supported: ");
            paramCertificate.append(paramAsymmetricKeyParameter.getClass().getName());
            throw new IllegalArgumentException(paramCertificate.toString());
          }
          throw new IllegalArgumentException("'privateKey' must be private");
        }
        throw new IllegalArgumentException("'privateKey' cannot be null");
      }
      throw new IllegalArgumentException("'certificate' cannot be empty");
    }
    throw new IllegalArgumentException("'certificate' cannot be null");
  }
  
  public byte[] generateAgreement(AsymmetricKeyParameter paramAsymmetricKeyParameter)
  {
    this.basicAgreement.init(this.privateKey);
    paramAsymmetricKeyParameter = this.basicAgreement.calculateAgreement(paramAsymmetricKeyParameter);
    if (this.truncateAgreement) {
      return BigIntegers.asUnsignedByteArray(paramAsymmetricKeyParameter);
    }
    return BigIntegers.asUnsignedByteArray(this.basicAgreement.getFieldSize(), paramAsymmetricKeyParameter);
  }
  
  public Certificate getCertificate()
  {
    return this.certificate;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\DefaultTlsAgreementCredentials.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */