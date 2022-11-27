package org.bouncycastle.jce.provider;

import java.security.cert.TrustAnchor;
import java.security.cert.X509CRL;
import java.security.cert.X509Certificate;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.asn1.x500.X500Name;

class PrincipalUtils
{
  static X500Name getCA(TrustAnchor paramTrustAnchor)
  {
    return X500Name.getInstance(paramTrustAnchor.getCA().getEncoded());
  }
  
  static X500Name getEncodedIssuerPrincipal(Object paramObject)
  {
    if ((paramObject instanceof X509Certificate)) {
      return getIssuerPrincipal((X509Certificate)paramObject);
    }
    return X500Name.getInstance(((X500Principal)((org.bouncycastle.x509.X509AttributeCertificate)paramObject).getIssuer().getPrincipals()[0]).getEncoded());
  }
  
  static X500Name getIssuerPrincipal(X509CRL paramX509CRL)
  {
    return X500Name.getInstance(paramX509CRL.getIssuerX500Principal().getEncoded());
  }
  
  static X500Name getIssuerPrincipal(X509Certificate paramX509Certificate)
  {
    return X500Name.getInstance(paramX509Certificate.getIssuerX500Principal().getEncoded());
  }
  
  static X500Name getSubjectPrincipal(X509Certificate paramX509Certificate)
  {
    return X500Name.getInstance(paramX509Certificate.getSubjectX500Principal().getEncoded());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jce\provider\PrincipalUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */