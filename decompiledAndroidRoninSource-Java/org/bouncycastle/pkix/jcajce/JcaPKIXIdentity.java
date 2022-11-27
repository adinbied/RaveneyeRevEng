package org.bouncycastle.pkix.jcajce;

import java.security.PrivateKey;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.jcajce.JcaX509CertificateHolder;
import org.bouncycastle.pkix.PKIXIdentity;

public class JcaPKIXIdentity
  extends PKIXIdentity
{
  private final X509Certificate[] certs;
  private final PrivateKey privKey;
  
  public JcaPKIXIdentity(PrivateKey paramPrivateKey, X509Certificate[] paramArrayOfX509Certificate)
  {
    super(getPrivateKeyInfo(paramPrivateKey), getCertificates(paramArrayOfX509Certificate));
    this.privKey = paramPrivateKey;
    paramPrivateKey = new X509Certificate[paramArrayOfX509Certificate.length];
    this.certs = paramPrivateKey;
    System.arraycopy(paramArrayOfX509Certificate, 0, paramPrivateKey, 0, paramArrayOfX509Certificate.length);
  }
  
  private static X509CertificateHolder[] getCertificates(X509Certificate[] paramArrayOfX509Certificate)
  {
    int j = paramArrayOfX509Certificate.length;
    Object localObject = new X509CertificateHolder[j];
    int i = 0;
    while (i != j) {
      try
      {
        localObject[i] = new JcaX509CertificateHolder(paramArrayOfX509Certificate[i]);
        i += 1;
      }
      catch (CertificateEncodingException paramArrayOfX509Certificate)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Unable to process certificates: ");
        ((StringBuilder)localObject).append(paramArrayOfX509Certificate.getMessage());
        throw new IllegalArgumentException(((StringBuilder)localObject).toString());
      }
    }
    return (X509CertificateHolder[])localObject;
  }
  
  private static PrivateKeyInfo getPrivateKeyInfo(PrivateKey paramPrivateKey)
  {
    try
    {
      paramPrivateKey = PrivateKeyInfo.getInstance(paramPrivateKey.getEncoded());
      return paramPrivateKey;
    }
    catch (Exception paramPrivateKey)
    {
      for (;;) {}
    }
    return null;
  }
  
  public PrivateKey getPrivateKey()
  {
    return this.privKey;
  }
  
  public X509Certificate getX509Certificate()
  {
    return this.certs[0];
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pkix\jcajce\JcaPKIXIdentity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */