package org.bouncycastle.cert.ocsp.jcajce;

import java.security.PublicKey;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.cert.ocsp.OCSPException;
import org.bouncycastle.cert.ocsp.RespID;
import org.bouncycastle.operator.DigestCalculator;

public class JcaRespID
  extends RespID
{
  public JcaRespID(PublicKey paramPublicKey, DigestCalculator paramDigestCalculator)
    throws OCSPException
  {
    super(SubjectPublicKeyInfo.getInstance(paramPublicKey.getEncoded()), paramDigestCalculator);
  }
  
  public JcaRespID(X500Principal paramX500Principal)
  {
    super(X500Name.getInstance(paramX500Principal.getEncoded()));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cert\ocsp\jcajce\JcaRespID.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */