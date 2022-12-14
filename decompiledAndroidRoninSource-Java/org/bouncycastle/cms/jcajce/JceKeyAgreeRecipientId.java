package org.bouncycastle.cms.jcajce;

import java.math.BigInteger;
import java.security.cert.X509Certificate;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.cms.KeyAgreeRecipientId;

public class JceKeyAgreeRecipientId
  extends KeyAgreeRecipientId
{
  public JceKeyAgreeRecipientId(X509Certificate paramX509Certificate)
  {
    this(paramX509Certificate.getIssuerX500Principal(), paramX509Certificate.getSerialNumber());
  }
  
  public JceKeyAgreeRecipientId(X500Principal paramX500Principal, BigInteger paramBigInteger)
  {
    super(X500Name.getInstance(paramX500Principal.getEncoded()), paramBigInteger);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\jcajce\JceKeyAgreeRecipientId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */