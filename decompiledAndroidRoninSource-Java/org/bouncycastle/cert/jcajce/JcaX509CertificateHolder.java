package org.bouncycastle.cert.jcajce;

import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import org.bouncycastle.asn1.x509.Certificate;
import org.bouncycastle.cert.X509CertificateHolder;

public class JcaX509CertificateHolder
  extends X509CertificateHolder
{
  public JcaX509CertificateHolder(X509Certificate paramX509Certificate)
    throws CertificateEncodingException
  {
    super(Certificate.getInstance(paramX509Certificate.getEncoded()));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cert\jcajce\JcaX509CertificateHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */