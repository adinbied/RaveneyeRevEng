package org.bouncycastle.cert.jcajce;

import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;

class DefaultCertHelper
  extends CertHelper
{
  protected CertificateFactory createCertificateFactory(String paramString)
    throws CertificateException
  {
    return CertificateFactory.getInstance(paramString);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cert\jcajce\DefaultCertHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */