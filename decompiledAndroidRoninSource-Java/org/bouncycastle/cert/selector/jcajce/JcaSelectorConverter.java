package org.bouncycastle.cert.selector.jcajce;

import java.io.IOException;
import java.security.cert.X509CertSelector;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.cert.selector.X509CertificateHolderSelector;

public class JcaSelectorConverter
{
  public X509CertificateHolderSelector getCertificateHolderSelector(X509CertSelector paramX509CertSelector)
  {
    try
    {
      if (paramX509CertSelector.getSubjectKeyIdentifier() != null) {
        return new X509CertificateHolderSelector(X500Name.getInstance(paramX509CertSelector.getIssuerAsBytes()), paramX509CertSelector.getSerialNumber(), ASN1OctetString.getInstance(paramX509CertSelector.getSubjectKeyIdentifier()).getOctets());
      }
      paramX509CertSelector = new X509CertificateHolderSelector(X500Name.getInstance(paramX509CertSelector.getIssuerAsBytes()), paramX509CertSelector.getSerialNumber());
      return paramX509CertSelector;
    }
    catch (IOException paramX509CertSelector)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("unable to convert issuer: ");
      localStringBuilder.append(paramX509CertSelector.getMessage());
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cert\selector\jcajce\JcaSelectorConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */