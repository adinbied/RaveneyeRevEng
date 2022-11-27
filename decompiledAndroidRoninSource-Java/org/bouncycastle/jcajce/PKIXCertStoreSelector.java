package org.bouncycastle.jcajce;

import java.io.IOException;
import java.security.cert.CertSelector;
import java.security.cert.CertStore;
import java.security.cert.CertStoreException;
import java.security.cert.Certificate;
import java.security.cert.X509CertSelector;
import java.util.Collection;
import org.bouncycastle.util.Selector;

public class PKIXCertStoreSelector<T extends Certificate>
  implements Selector<T>
{
  private final CertSelector baseSelector;
  
  private PKIXCertStoreSelector(CertSelector paramCertSelector)
  {
    this.baseSelector = paramCertSelector;
  }
  
  public static Collection<? extends Certificate> getCertificates(PKIXCertStoreSelector paramPKIXCertStoreSelector, CertStore paramCertStore)
    throws CertStoreException
  {
    return paramCertStore.getCertificates(new SelectorClone(paramPKIXCertStoreSelector));
  }
  
  public Object clone()
  {
    return new PKIXCertStoreSelector(this.baseSelector);
  }
  
  public boolean match(Certificate paramCertificate)
  {
    return this.baseSelector.match(paramCertificate);
  }
  
  public static class Builder
  {
    private final CertSelector baseSelector;
    
    public Builder(CertSelector paramCertSelector)
    {
      this.baseSelector = ((CertSelector)paramCertSelector.clone());
    }
    
    public PKIXCertStoreSelector<? extends Certificate> build()
    {
      return new PKIXCertStoreSelector(this.baseSelector, null);
    }
  }
  
  private static class SelectorClone
    extends X509CertSelector
  {
    private final PKIXCertStoreSelector selector;
    
    SelectorClone(PKIXCertStoreSelector paramPKIXCertStoreSelector)
    {
      this.selector = paramPKIXCertStoreSelector;
      if ((paramPKIXCertStoreSelector.baseSelector instanceof X509CertSelector))
      {
        paramPKIXCertStoreSelector = (X509CertSelector)paramPKIXCertStoreSelector.baseSelector;
        setAuthorityKeyIdentifier(paramPKIXCertStoreSelector.getAuthorityKeyIdentifier());
        setBasicConstraints(paramPKIXCertStoreSelector.getBasicConstraints());
        setCertificate(paramPKIXCertStoreSelector.getCertificate());
        setCertificateValid(paramPKIXCertStoreSelector.getCertificateValid());
        setKeyUsage(paramPKIXCertStoreSelector.getKeyUsage());
        setMatchAllSubjectAltNames(paramPKIXCertStoreSelector.getMatchAllSubjectAltNames());
        setPrivateKeyValid(paramPKIXCertStoreSelector.getPrivateKeyValid());
        setSerialNumber(paramPKIXCertStoreSelector.getSerialNumber());
        setSubjectKeyIdentifier(paramPKIXCertStoreSelector.getSubjectKeyIdentifier());
        setSubjectPublicKey(paramPKIXCertStoreSelector.getSubjectPublicKey());
        try
        {
          setExtendedKeyUsage(paramPKIXCertStoreSelector.getExtendedKeyUsage());
          setIssuer(paramPKIXCertStoreSelector.getIssuerAsBytes());
          setNameConstraints(paramPKIXCertStoreSelector.getNameConstraints());
          setPathToNames(paramPKIXCertStoreSelector.getPathToNames());
          setPolicy(paramPKIXCertStoreSelector.getPolicy());
          setSubject(paramPKIXCertStoreSelector.getSubjectAsBytes());
          setSubjectAlternativeNames(paramPKIXCertStoreSelector.getSubjectAlternativeNames());
          setSubjectPublicKeyAlgID(paramPKIXCertStoreSelector.getSubjectPublicKeyAlgID());
          return;
        }
        catch (IOException paramPKIXCertStoreSelector)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("base selector invalid: ");
          localStringBuilder.append(paramPKIXCertStoreSelector.getMessage());
          throw new IllegalStateException(localStringBuilder.toString(), paramPKIXCertStoreSelector);
        }
      }
    }
    
    public boolean match(Certificate paramCertificate)
    {
      PKIXCertStoreSelector localPKIXCertStoreSelector = this.selector;
      if (localPKIXCertStoreSelector == null) {
        return paramCertificate != null;
      }
      return localPKIXCertStoreSelector.match(paramCertificate);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\PKIXCertStoreSelector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */