package org.bouncycastle.cert.jcajce;

import java.security.NoSuchProviderException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;

abstract class CertHelper
{
  protected abstract CertificateFactory createCertificateFactory(String paramString)
    throws CertificateException, NoSuchProviderException;
  
  public CertificateFactory getCertificateFactory(String paramString)
    throws NoSuchProviderException, CertificateException
  {
    return createCertificateFactory(paramString);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cert\jcajce\CertHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */