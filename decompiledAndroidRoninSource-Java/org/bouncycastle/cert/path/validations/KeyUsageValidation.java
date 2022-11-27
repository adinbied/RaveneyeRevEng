package org.bouncycastle.cert.path.validations;

import org.bouncycastle.asn1.x509.Extension;
import org.bouncycastle.asn1.x509.KeyUsage;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.path.CertPathValidation;
import org.bouncycastle.cert.path.CertPathValidationContext;
import org.bouncycastle.cert.path.CertPathValidationException;
import org.bouncycastle.util.Memoable;

public class KeyUsageValidation
  implements CertPathValidation
{
  private boolean isMandatory;
  
  public KeyUsageValidation()
  {
    this(true);
  }
  
  public KeyUsageValidation(boolean paramBoolean)
  {
    this.isMandatory = paramBoolean;
  }
  
  public Memoable copy()
  {
    return new KeyUsageValidation(this.isMandatory);
  }
  
  public void reset(Memoable paramMemoable)
  {
    this.isMandatory = ((KeyUsageValidation)paramMemoable).isMandatory;
  }
  
  public void validate(CertPathValidationContext paramCertPathValidationContext, X509CertificateHolder paramX509CertificateHolder)
    throws CertPathValidationException
  {
    paramCertPathValidationContext.addHandledExtension(Extension.keyUsage);
    if (!paramCertPathValidationContext.isEndEntity())
    {
      paramCertPathValidationContext = KeyUsage.fromExtensions(paramX509CertificateHolder.getExtensions());
      if (paramCertPathValidationContext != null)
      {
        if (paramCertPathValidationContext.hasUsages(4)) {
          return;
        }
        throw new CertPathValidationException("Issuer certificate KeyUsage extension does not permit key signing");
      }
      if (!this.isMandatory) {
        return;
      }
      throw new CertPathValidationException("KeyUsage extension not present in CA certificate");
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cert\path\validations\KeyUsageValidation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */