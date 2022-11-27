package org.bouncycastle.pkcs.jcajce;

import java.io.IOException;
import java.security.PrivateKey;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.Certificate;
import org.bouncycastle.operator.OutputEncryptor;
import org.bouncycastle.pkcs.PKCS12SafeBagBuilder;
import org.bouncycastle.pkcs.PKCSIOException;

public class JcaPKCS12SafeBagBuilder
  extends PKCS12SafeBagBuilder
{
  public JcaPKCS12SafeBagBuilder(PrivateKey paramPrivateKey)
  {
    super(PrivateKeyInfo.getInstance(paramPrivateKey.getEncoded()));
  }
  
  public JcaPKCS12SafeBagBuilder(PrivateKey paramPrivateKey, OutputEncryptor paramOutputEncryptor)
  {
    super(PrivateKeyInfo.getInstance(paramPrivateKey.getEncoded()), paramOutputEncryptor);
  }
  
  public JcaPKCS12SafeBagBuilder(X509Certificate paramX509Certificate)
    throws IOException
  {
    super(convertCert(paramX509Certificate));
  }
  
  private static Certificate convertCert(X509Certificate paramX509Certificate)
    throws IOException
  {
    try
    {
      paramX509Certificate = Certificate.getInstance(paramX509Certificate.getEncoded());
      return paramX509Certificate;
    }
    catch (CertificateEncodingException paramX509Certificate)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("cannot encode certificate: ");
      localStringBuilder.append(paramX509Certificate.getMessage());
      throw new PKCSIOException(localStringBuilder.toString(), paramX509Certificate);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pkcs\jcajce\JcaPKCS12SafeBagBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */