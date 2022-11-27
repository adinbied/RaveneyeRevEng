package org.bouncycastle.x509;

import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.X509CertSelector;
import java.security.cert.X509Certificate;
import org.bouncycastle.util.Selector;

public class X509CertStoreSelector
  extends X509CertSelector
  implements Selector
{
  public static X509CertStoreSelector getInstance(X509CertSelector paramX509CertSelector)
  {
    if (paramX509CertSelector != null)
    {
      Object localObject = new X509CertStoreSelector();
      ((X509CertStoreSelector)localObject).setAuthorityKeyIdentifier(paramX509CertSelector.getAuthorityKeyIdentifier());
      ((X509CertStoreSelector)localObject).setBasicConstraints(paramX509CertSelector.getBasicConstraints());
      ((X509CertStoreSelector)localObject).setCertificate(paramX509CertSelector.getCertificate());
      ((X509CertStoreSelector)localObject).setCertificateValid(paramX509CertSelector.getCertificateValid());
      ((X509CertStoreSelector)localObject).setMatchAllSubjectAltNames(paramX509CertSelector.getMatchAllSubjectAltNames());
      try
      {
        ((X509CertStoreSelector)localObject).setPathToNames(paramX509CertSelector.getPathToNames());
        ((X509CertStoreSelector)localObject).setExtendedKeyUsage(paramX509CertSelector.getExtendedKeyUsage());
        ((X509CertStoreSelector)localObject).setNameConstraints(paramX509CertSelector.getNameConstraints());
        ((X509CertStoreSelector)localObject).setPolicy(paramX509CertSelector.getPolicy());
        ((X509CertStoreSelector)localObject).setSubjectPublicKeyAlgID(paramX509CertSelector.getSubjectPublicKeyAlgID());
        ((X509CertStoreSelector)localObject).setSubjectAlternativeNames(paramX509CertSelector.getSubjectAlternativeNames());
        ((X509CertStoreSelector)localObject).setIssuer(paramX509CertSelector.getIssuer());
        ((X509CertStoreSelector)localObject).setKeyUsage(paramX509CertSelector.getKeyUsage());
        ((X509CertStoreSelector)localObject).setPrivateKeyValid(paramX509CertSelector.getPrivateKeyValid());
        ((X509CertStoreSelector)localObject).setSerialNumber(paramX509CertSelector.getSerialNumber());
        ((X509CertStoreSelector)localObject).setSubject(paramX509CertSelector.getSubject());
        ((X509CertStoreSelector)localObject).setSubjectKeyIdentifier(paramX509CertSelector.getSubjectKeyIdentifier());
        ((X509CertStoreSelector)localObject).setSubjectPublicKey(paramX509CertSelector.getSubjectPublicKey());
        return (X509CertStoreSelector)localObject;
      }
      catch (IOException paramX509CertSelector)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("error in passed in selector: ");
        ((StringBuilder)localObject).append(paramX509CertSelector);
        throw new IllegalArgumentException(((StringBuilder)localObject).toString());
      }
    }
    throw new IllegalArgumentException("cannot create from null selector");
  }
  
  public Object clone()
  {
    return (X509CertStoreSelector)super.clone();
  }
  
  public boolean match(Object paramObject)
  {
    if (!(paramObject instanceof X509Certificate)) {
      return false;
    }
    return super.match((X509Certificate)paramObject);
  }
  
  public boolean match(Certificate paramCertificate)
  {
    return match(paramCertificate);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\x509\X509CertStoreSelector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */