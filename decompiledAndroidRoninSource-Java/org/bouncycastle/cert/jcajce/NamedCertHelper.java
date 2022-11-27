package org.bouncycastle.cert.jcajce;

import java.security.NoSuchProviderException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;

class NamedCertHelper
  extends CertHelper
{
  private final String providerName;
  
  NamedCertHelper(String paramString)
  {
    this.providerName = paramString;
  }
  
  protected CertificateFactory createCertificateFactory(String paramString)
    throws CertificateException, NoSuchProviderException
  {
    return CertificateFactory.getInstance(paramString, this.providerName);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cert\jcajce\NamedCertHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */