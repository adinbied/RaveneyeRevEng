package org.bouncycastle.cert.path.validations;

import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.cert.X509CertificateHolder;

class ValidationUtils
{
  static boolean isSelfIssued(X509CertificateHolder paramX509CertificateHolder)
  {
    return paramX509CertificateHolder.getSubject().equals(paramX509CertificateHolder.getIssuer());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cert\path\validations\ValidationUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */