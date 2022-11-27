package org.bouncycastle.x509;

import java.io.IOException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.x509.Certificate;
import org.bouncycastle.asn1.x509.CertificatePair;
import org.bouncycastle.jcajce.util.BCJcaJceHelper;
import org.bouncycastle.jcajce.util.JcaJceHelper;
import org.bouncycastle.jce.provider.X509CertificateObject;

public class X509CertificatePair
{
  private final JcaJceHelper bcHelper = new BCJcaJceHelper();
  private X509Certificate forward;
  private X509Certificate reverse;
  
  public X509CertificatePair(X509Certificate paramX509Certificate1, X509Certificate paramX509Certificate2)
  {
    this.forward = paramX509Certificate1;
    this.reverse = paramX509Certificate2;
  }
  
  public X509CertificatePair(CertificatePair paramCertificatePair)
    throws CertificateParsingException
  {
    if (paramCertificatePair.getForward() != null) {
      this.forward = new X509CertificateObject(paramCertificatePair.getForward());
    }
    if (paramCertificatePair.getReverse() != null) {
      this.reverse = new X509CertificateObject(paramCertificatePair.getReverse());
    }
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool4 = false;
    if (paramObject == null) {
      return false;
    }
    if (!(paramObject instanceof X509CertificatePair)) {
      return false;
    }
    paramObject = (X509CertificatePair)paramObject;
    X509Certificate localX509Certificate = this.forward;
    boolean bool1;
    if (localX509Certificate != null) {
      bool1 = localX509Certificate.equals(((X509CertificatePair)paramObject).forward);
    } else if (((X509CertificatePair)paramObject).forward != null) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    localX509Certificate = this.reverse;
    paramObject = ((X509CertificatePair)paramObject).reverse;
    boolean bool2;
    if (localX509Certificate != null) {
      bool2 = localX509Certificate.equals(paramObject);
    } else if (paramObject != null) {
      bool2 = false;
    } else {
      bool2 = true;
    }
    boolean bool3 = bool4;
    if (bool1)
    {
      bool3 = bool4;
      if (bool2) {
        bool3 = true;
      }
    }
    return bool3;
  }
  
  public byte[] getEncoded()
    throws CertificateEncodingException
  {
    for (;;)
    {
      try
      {
        Object localObject1 = this.forward;
        Certificate localCertificate = null;
        if (localObject1 != null)
        {
          localObject1 = Certificate.getInstance(new ASN1InputStream(this.forward.getEncoded()).readObject());
          if (localObject1 == null) {
            throw new CertificateEncodingException("unable to get encoding for forward");
          }
          if (this.reverse != null)
          {
            localCertificate = Certificate.getInstance(new ASN1InputStream(this.reverse.getEncoded()).readObject());
            if (localCertificate == null) {
              throw new CertificateEncodingException("unable to get encoding for reverse");
            }
          }
          localObject1 = new CertificatePair((Certificate)localObject1, localCertificate).getEncoded("DER");
          return (byte[])localObject1;
        }
      }
      catch (IOException localIOException)
      {
        throw new ExtCertificateEncodingException(localIOException.toString(), localIOException);
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        throw new ExtCertificateEncodingException(localIllegalArgumentException.toString(), localIllegalArgumentException);
      }
      Object localObject2 = null;
    }
  }
  
  public X509Certificate getForward()
  {
    return this.forward;
  }
  
  public X509Certificate getReverse()
  {
    return this.reverse;
  }
  
  public int hashCode()
  {
    X509Certificate localX509Certificate = this.forward;
    int i = -1;
    if (localX509Certificate != null) {
      i = 0xFFFFFFFF ^ localX509Certificate.hashCode();
    }
    localX509Certificate = this.reverse;
    int j = i;
    if (localX509Certificate != null) {
      j = i * 17 ^ localX509Certificate.hashCode();
    }
    return j;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\x509\X509CertificatePair.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */