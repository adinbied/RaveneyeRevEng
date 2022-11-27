package org.bouncycastle.cert.jcajce;

import java.security.Provider;
import java.security.cert.CertificateException;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.X509ContentVerifierProviderBuilder;
import org.bouncycastle.operator.ContentVerifierProvider;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.operator.jcajce.JcaContentVerifierProviderBuilder;

public class JcaX509ContentVerifierProviderBuilder
  implements X509ContentVerifierProviderBuilder
{
  private JcaContentVerifierProviderBuilder builder = new JcaContentVerifierProviderBuilder();
  
  public ContentVerifierProvider build(SubjectPublicKeyInfo paramSubjectPublicKeyInfo)
    throws OperatorCreationException
  {
    return this.builder.build(paramSubjectPublicKeyInfo);
  }
  
  public ContentVerifierProvider build(X509CertificateHolder paramX509CertificateHolder)
    throws OperatorCreationException
  {
    try
    {
      paramX509CertificateHolder = this.builder.build(paramX509CertificateHolder);
      return paramX509CertificateHolder;
    }
    catch (CertificateException paramX509CertificateHolder)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unable to process certificate: ");
      localStringBuilder.append(paramX509CertificateHolder.getMessage());
      throw new OperatorCreationException(localStringBuilder.toString(), paramX509CertificateHolder);
    }
  }
  
  public JcaX509ContentVerifierProviderBuilder setProvider(String paramString)
  {
    this.builder.setProvider(paramString);
    return this;
  }
  
  public JcaX509ContentVerifierProviderBuilder setProvider(Provider paramProvider)
  {
    this.builder.setProvider(paramProvider);
    return this;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cert\jcajce\JcaX509ContentVerifierProviderBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */