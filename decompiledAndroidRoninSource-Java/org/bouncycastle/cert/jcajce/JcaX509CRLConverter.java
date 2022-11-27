package org.bouncycastle.cert.jcajce;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.cert.CRLException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509CRL;
import org.bouncycastle.cert.X509CRLHolder;

public class JcaX509CRLConverter
{
  private CertHelper helper = new DefaultCertHelper();
  
  public X509CRL getCRL(X509CRLHolder paramX509CRLHolder)
    throws CRLException
  {
    try
    {
      paramX509CRLHolder = (X509CRL)this.helper.getCertificateFactory("X.509").generateCRL(new ByteArrayInputStream(paramX509CRLHolder.getEncoded()));
      return paramX509CRLHolder;
    }
    catch (CertificateException paramX509CRLHolder)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("cannot create factory: ");
      localStringBuilder.append(paramX509CRLHolder.getMessage());
      throw new ExCRLException(localStringBuilder.toString(), paramX509CRLHolder);
    }
    catch (NoSuchProviderException paramX509CRLHolder)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("cannot find required provider:");
      localStringBuilder.append(paramX509CRLHolder.getMessage());
      throw new ExCRLException(localStringBuilder.toString(), paramX509CRLHolder);
    }
    catch (IOException paramX509CRLHolder)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("exception parsing certificate: ");
      localStringBuilder.append(paramX509CRLHolder.getMessage());
      throw new ExCRLException(localStringBuilder.toString(), paramX509CRLHolder);
    }
  }
  
  public JcaX509CRLConverter setProvider(String paramString)
  {
    this.helper = new NamedCertHelper(paramString);
    return this;
  }
  
  public JcaX509CRLConverter setProvider(Provider paramProvider)
  {
    this.helper = new ProviderCertHelper(paramProvider);
    return this;
  }
  
  private class ExCRLException
    extends CRLException
  {
    private Throwable cause;
    
    public ExCRLException(String paramString, Throwable paramThrowable)
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cert\jcajce\JcaX509CRLConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */