package org.bouncycastle.openssl.jcajce;

import java.io.IOException;
import java.security.Key;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.cert.CRLException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509CRL;
import java.security.cert.X509Certificate;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.cert.jcajce.JcaX509CRLHolder;
import org.bouncycastle.cert.jcajce.JcaX509CertificateHolder;
import org.bouncycastle.openssl.MiscPEMGenerator;
import org.bouncycastle.openssl.PEMEncryptor;

public class JcaMiscPEMGenerator
  extends MiscPEMGenerator
{
  private String algorithm;
  private Object obj;
  private char[] password;
  private Provider provider;
  private SecureRandom random;
  
  public JcaMiscPEMGenerator(Object paramObject)
    throws IOException
  {
    super(convertObject(paramObject));
  }
  
  public JcaMiscPEMGenerator(Object paramObject, PEMEncryptor paramPEMEncryptor)
    throws IOException
  {
    super(convertObject(paramObject), paramPEMEncryptor);
  }
  
  private static Object convertObject(Object paramObject)
    throws IOException
  {
    if ((paramObject instanceof X509Certificate)) {
      try
      {
        paramObject = new JcaX509CertificateHolder((X509Certificate)paramObject);
        return paramObject;
      }
      catch (CertificateEncodingException paramObject)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Cannot encode object: ");
        ((StringBuilder)localObject).append(((CertificateEncodingException)paramObject).toString());
        throw new IllegalArgumentException(((StringBuilder)localObject).toString());
      }
    }
    if ((paramObject instanceof X509CRL)) {
      try
      {
        paramObject = new JcaX509CRLHolder((X509CRL)paramObject);
        return paramObject;
      }
      catch (CRLException paramObject)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Cannot encode object: ");
        ((StringBuilder)localObject).append(((CRLException)paramObject).toString());
        throw new IllegalArgumentException(((StringBuilder)localObject).toString());
      }
    }
    if ((paramObject instanceof KeyPair)) {
      return convertObject(((KeyPair)paramObject).getPrivate());
    }
    if ((paramObject instanceof PrivateKey)) {
      return PrivateKeyInfo.getInstance(((Key)paramObject).getEncoded());
    }
    Object localObject = paramObject;
    if ((paramObject instanceof PublicKey)) {
      localObject = SubjectPublicKeyInfo.getInstance(((PublicKey)paramObject).getEncoded());
    }
    return localObject;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\openssl\jcajce\JcaMiscPEMGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */