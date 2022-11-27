package org.bouncycastle.cert.selector.jcajce;

import java.math.BigInteger;
import java.security.cert.X509Certificate;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.Extension;
import org.bouncycastle.cert.selector.X509CertificateHolderSelector;

public class JcaX509CertificateHolderSelector
  extends X509CertificateHolderSelector
{
  public JcaX509CertificateHolderSelector(X509Certificate paramX509Certificate)
  {
    super(convertPrincipal(paramX509Certificate.getIssuerX500Principal()), paramX509Certificate.getSerialNumber(), getSubjectKeyId(paramX509Certificate));
  }
  
  public JcaX509CertificateHolderSelector(X500Principal paramX500Principal, BigInteger paramBigInteger)
  {
    super(convertPrincipal(paramX500Principal), paramBigInteger);
  }
  
  public JcaX509CertificateHolderSelector(X500Principal paramX500Principal, BigInteger paramBigInteger, byte[] paramArrayOfByte)
  {
    super(convertPrincipal(paramX500Principal), paramBigInteger, paramArrayOfByte);
  }
  
  private static X500Name convertPrincipal(X500Principal paramX500Principal)
  {
    if (paramX500Principal == null) {
      return null;
    }
    return X500Name.getInstance(paramX500Principal.getEncoded());
  }
  
  private static byte[] getSubjectKeyId(X509Certificate paramX509Certificate)
  {
    paramX509Certificate = paramX509Certificate.getExtensionValue(Extension.subjectKeyIdentifier.getId());
    if (paramX509Certificate != null) {
      return ASN1OctetString.getInstance(ASN1OctetString.getInstance(paramX509Certificate).getOctets()).getOctets();
    }
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cert\selector\jcajce\JcaX509CertificateHolderSelector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */