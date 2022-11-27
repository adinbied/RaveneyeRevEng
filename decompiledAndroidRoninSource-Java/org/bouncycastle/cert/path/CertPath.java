package org.bouncycastle.cert.path;

import org.bouncycastle.cert.X509CertificateHolder;

public class CertPath
{
  private final X509CertificateHolder[] certificates = copyArray(paramArrayOfX509CertificateHolder);
  
  public CertPath(X509CertificateHolder[] paramArrayOfX509CertificateHolder) {}
  
  private X509CertificateHolder[] copyArray(X509CertificateHolder[] paramArrayOfX509CertificateHolder)
  {
    int i = paramArrayOfX509CertificateHolder.length;
    X509CertificateHolder[] arrayOfX509CertificateHolder = new X509CertificateHolder[i];
    System.arraycopy(paramArrayOfX509CertificateHolder, 0, arrayOfX509CertificateHolder, 0, i);
    return arrayOfX509CertificateHolder;
  }
  
  public CertPathValidationResult evaluate(CertPathValidation[] paramArrayOfCertPathValidation)
  {
    CertPathValidationContext localCertPathValidationContext = new CertPathValidationContext(CertPathUtils.getCriticalExtensionsOIDs(this.certificates));
    CertPathValidationResultBuilder localCertPathValidationResultBuilder = new CertPathValidationResultBuilder();
    int i = 0;
    while (i != paramArrayOfCertPathValidation.length)
    {
      int j = this.certificates.length - 1;
      while (j >= 0)
      {
        boolean bool;
        if (j == 0) {
          bool = true;
        } else {
          bool = false;
        }
        try
        {
          localCertPathValidationContext.setIsEndEntity(bool);
          paramArrayOfCertPathValidation[i].validate(localCertPathValidationContext, this.certificates[j]);
        }
        catch (CertPathValidationException localCertPathValidationException)
        {
          localCertPathValidationResultBuilder.addException(localCertPathValidationException);
        }
        j -= 1;
      }
      i += 1;
    }
    return localCertPathValidationResultBuilder.build();
  }
  
  public X509CertificateHolder[] getCertificates()
  {
    return copyArray(this.certificates);
  }
  
  public int length()
  {
    return this.certificates.length;
  }
  
  public CertPathValidationResult validate(CertPathValidation[] paramArrayOfCertPathValidation)
  {
    CertPathValidationContext localCertPathValidationContext = new CertPathValidationContext(CertPathUtils.getCriticalExtensionsOIDs(this.certificates));
    int i = 0;
    while (i != paramArrayOfCertPathValidation.length)
    {
      int j = this.certificates.length - 1;
      while (j >= 0)
      {
        boolean bool;
        if (j == 0) {
          bool = true;
        } else {
          bool = false;
        }
        try
        {
          localCertPathValidationContext.setIsEndEntity(bool);
          paramArrayOfCertPathValidation[i].validate(localCertPathValidationContext, this.certificates[j]);
          j -= 1;
        }
        catch (CertPathValidationException paramArrayOfCertPathValidation)
        {
          return new CertPathValidationResult(localCertPathValidationContext, j, i, paramArrayOfCertPathValidation);
        }
      }
      i += 1;
    }
    return new CertPathValidationResult(localCertPathValidationContext);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cert\path\CertPath.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */