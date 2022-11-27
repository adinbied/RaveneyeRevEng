package org.bouncycastle.cert.jcajce;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import org.bouncycastle.cert.X509CertificateHolder;

public class JcaX509CertificateConverter
{
  private CertHelper helper = new DefaultCertHelper();
  
  public X509Certificate getCertificate(X509CertificateHolder paramX509CertificateHolder)
    throws CertificateException
  {
    try
    {
      paramX509CertificateHolder = (X509Certificate)this.helper.getCertificateFactory("X.509").generateCertificate(new ByteArrayInputStream(paramX509CertificateHolder.getEncoded()));
      return paramX509CertificateHolder;
    }
    catch (NoSuchProviderException paramX509CertificateHolder)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("cannot find required provider:");
      localStringBuilder.append(paramX509CertificateHolder.getMessage());
      throw new ExCertificateException(localStringBuilder.toString(), paramX509CertificateHolder);
    }
    catch (IOException paramX509CertificateHolder)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("exception parsing certificate: ");
      localStringBuilder.append(paramX509CertificateHolder.getMessage());
      throw new ExCertificateParsingException(localStringBuilder.toString(), paramX509CertificateHolder);
    }
  }
  
  public JcaX509CertificateConverter setProvider(String paramString)
  {
    this.helper = new NamedCertHelper(paramString);
    return this;
  }
  
  public JcaX509CertificateConverter setProvider(Provider paramProvider)
  {
    this.helper = new ProviderCertHelper(paramProvider);
    return this;
  }
  
  private class ExCertificateException
    extends CertificateException
  {
    private Throwable cause;
    
    public ExCertificateException(String paramString, Throwable paramThrowable)
    {
      super();
      this.cause = paramThrowable;
    }
    
    public Throwable getCause()
    {
      return this.cause;
    }
  }
  
  private class ExCertificateParsingException
    extends CertificateParsingException
  {
    private Throwable cause;
    
    public ExCertificateParsingException(String paramString, Throwable paramThrowable)
    {
      super();
      this.cause = paramThrowable;
    }
    
    public Throwable getCause()
    {
      return this.cause;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cert\jcajce\JcaX509CertificateConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */