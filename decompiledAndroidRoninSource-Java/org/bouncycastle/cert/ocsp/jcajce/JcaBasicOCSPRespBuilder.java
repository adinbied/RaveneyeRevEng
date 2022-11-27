package org.bouncycastle.cert.ocsp.jcajce;

import java.security.PublicKey;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.cert.ocsp.BasicOCSPRespBuilder;
import org.bouncycastle.cert.ocsp.OCSPException;
import org.bouncycastle.operator.DigestCalculator;

public class JcaBasicOCSPRespBuilder
  extends BasicOCSPRespBuilder
{
  public JcaBasicOCSPRespBuilder(PublicKey paramPublicKey, DigestCalculator paramDigestCalculator)
    throws OCSPException
  {
    super(SubjectPublicKeyInfo.getInstance(paramPublicKey.getEncoded()), paramDigestCalculator);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cert\ocsp\jcajce\JcaBasicOCSPRespBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */