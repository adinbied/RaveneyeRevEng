package org.bouncycastle.cert.path;

import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.util.Memoable;

public abstract interface CertPathValidation
  extends Memoable
{
  public abstract void validate(CertPathValidationContext paramCertPathValidationContext, X509CertificateHolder paramX509CertificateHolder)
    throws CertPathValidationException;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cert\path\CertPathValidation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */