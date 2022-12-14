package org.bouncycastle.cert.jcajce;

import java.security.Provider;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;

class ProviderCertHelper
  extends CertHelper
{
  private final Provider provider;
  
  ProviderCertHelper(Provider paramProvider)
  {
    this.provider = paramProvider;
  }
  
  protected CertificateFactory createCertificateFactory(String paramString)
    throws CertificateException
  {
    return CertificateFactory.getInstance(paramString, this.provider);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cert\jcajce\ProviderCertHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */