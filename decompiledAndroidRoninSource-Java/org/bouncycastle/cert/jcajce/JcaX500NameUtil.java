package org.bouncycastle.cert.jcajce;

import java.security.cert.X509Certificate;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x500.X500NameStyle;

public class JcaX500NameUtil
{
  public static X500Name getIssuer(X509Certificate paramX509Certificate)
  {
    return X500Name.getInstance(paramX509Certificate.getIssuerX500Principal().getEncoded());
  }
  
  public static X500Name getIssuer(X500NameStyle paramX500NameStyle, X509Certificate paramX509Certificate)
  {
    return X500Name.getInstance(paramX500NameStyle, paramX509Certificate.getIssuerX500Principal().getEncoded());
  }
  
  public static X500Name getSubject(X509Certificate paramX509Certificate)
  {
    return X500Name.getInstance(paramX509Certificate.getSubjectX500Principal().getEncoded());
  }
  
  public static X500Name getSubject(X500NameStyle paramX500NameStyle, X509Certificate paramX509Certificate)
  {
    return X500Name.getInstance(paramX500NameStyle, paramX509Certificate.getSubjectX500Principal().getEncoded());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cert\jcajce\JcaX500NameUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */