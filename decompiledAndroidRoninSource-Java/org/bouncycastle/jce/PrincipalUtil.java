package org.bouncycastle.jce;

import java.io.IOException;
import java.security.cert.CRLException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509CRL;
import java.security.cert.X509Certificate;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.x509.TBSCertList;
import org.bouncycastle.asn1.x509.TBSCertificateStructure;
import org.bouncycastle.asn1.x509.X509Name;

public class PrincipalUtil
{
  public static X509Principal getIssuerX509Principal(X509CRL paramX509CRL)
    throws CRLException
  {
    try
    {
      paramX509CRL = new X509Principal(X509Name.getInstance(TBSCertList.getInstance(ASN1Primitive.fromByteArray(paramX509CRL.getTBSCertList())).getIssuer()));
      return paramX509CRL;
    }
    catch (IOException paramX509CRL)
    {
      throw new CRLException(paramX509CRL.toString());
    }
  }
  
  public static X509Principal getIssuerX509Principal(X509Certificate paramX509Certificate)
    throws CertificateEncodingException
  {
    try
    {
      paramX509Certificate = new X509Principal(X509Name.getInstance(TBSCertificateStructure.getInstance(ASN1Primitive.fromByteArray(paramX509Certificate.getTBSCertificate())).getIssuer()));
      return paramX509Certificate;
    }
    catch (IOException paramX509Certificate)
    {
      throw new CertificateEncodingException(paramX509Certificate.toString());
    }
  }
  
  public static X509Principal getSubjectX509Principal(X509Certificate paramX509Certificate)
    throws CertificateEncodingException
  {
    try
    {
      paramX509Certificate = new X509Principal(X509Name.getInstance(TBSCertificateStructure.getInstance(ASN1Primitive.fromByteArray(paramX509Certificate.getTBSCertificate())).getSubject()));
      return paramX509Certificate;
    }
    catch (IOException paramX509Certificate)
    {
      throw new CertificateEncodingException(paramX509Certificate.toString());
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jce\PrincipalUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */