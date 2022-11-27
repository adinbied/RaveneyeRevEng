package org.bouncycastle.cms.jcajce;

import java.io.IOException;
import java.security.cert.X509CertSelector;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.cms.KeyTransRecipientId;
import org.bouncycastle.cms.SignerId;

public class JcaSelectorConverter
{
  public KeyTransRecipientId getKeyTransRecipientId(X509CertSelector paramX509CertSelector)
  {
    try
    {
      if (paramX509CertSelector.getSubjectKeyIdentifier() != null) {
        return new KeyTransRecipientId(X500Name.getInstance(paramX509CertSelector.getIssuerAsBytes()), paramX509CertSelector.getSerialNumber(), ASN1OctetString.getInstance(paramX509CertSelector.getSubjectKeyIdentifier()).getOctets());
      }
      paramX509CertSelector = new KeyTransRecipientId(X500Name.getInstance(paramX509CertSelector.getIssuerAsBytes()), paramX509CertSelector.getSerialNumber());
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
  
  public SignerId getSignerId(X509CertSelector paramX509CertSelector)
  {
    try
    {
      if (paramX509CertSelector.getSubjectKeyIdentifier() != null) {
        return new SignerId(X500Name.getInstance(paramX509CertSelector.getIssuerAsBytes()), paramX509CertSelector.getSerialNumber(), ASN1OctetString.getInstance(paramX509CertSelector.getSubjectKeyIdentifier()).getOctets());
      }
      paramX509CertSelector = new SignerId(X500Name.getInstance(paramX509CertSelector.getIssuerAsBytes()), paramX509CertSelector.getSerialNumber());
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\jcajce\JcaSelectorConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */