package org.bouncycastle.x509;

import java.security.cert.CertPath;
import java.security.cert.CertPathValidatorException;
import java.util.Collection;
import java.util.Set;

public abstract class PKIXAttrCertChecker
  implements Cloneable
{
  public abstract void check(X509AttributeCertificate paramX509AttributeCertificate, CertPath paramCertPath1, CertPath paramCertPath2, Collection paramCollection)
    throws CertPathValidatorException;
  
  public abstract Object clone();
  
  public abstract Set getSupportedExtensions();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\x509\PKIXAttrCertChecker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */