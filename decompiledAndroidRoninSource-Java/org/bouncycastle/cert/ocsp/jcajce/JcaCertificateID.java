package org.bouncycastle.cert.ocsp.jcajce;

import java.math.BigInteger;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import org.bouncycastle.cert.jcajce.JcaX509CertificateHolder;
import org.bouncycastle.cert.ocsp.CertificateID;
import org.bouncycastle.cert.ocsp.OCSPException;
import org.bouncycastle.operator.DigestCalculator;

public class JcaCertificateID
  extends CertificateID
{
  public JcaCertificateID(DigestCalculator paramDigestCalculator, X509Certificate paramX509Certificate, BigInteger paramBigInteger)
    throws OCSPException, CertificateEncodingException
  {
    super(paramDigestCalculator, new JcaX509CertificateHolder(paramX509Certificate), paramBigInteger);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cert\ocsp\jcajce\JcaCertificateID.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */