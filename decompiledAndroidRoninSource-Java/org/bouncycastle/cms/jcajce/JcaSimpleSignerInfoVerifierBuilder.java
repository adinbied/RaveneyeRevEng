package org.bouncycastle.cms.jcajce;

import java.security.Provider;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cms.DefaultCMSSignatureAlgorithmNameGenerator;
import org.bouncycastle.cms.SignerInformationVerifier;
import org.bouncycastle.operator.ContentVerifierProvider;
import org.bouncycastle.operator.DefaultSignatureAlgorithmIdentifierFinder;
import org.bouncycastle.operator.DigestCalculatorProvider;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.operator.jcajce.JcaContentVerifierProviderBuilder;
import org.bouncycastle.operator.jcajce.JcaDigestCalculatorProviderBuilder;

public class JcaSimpleSignerInfoVerifierBuilder
{
  private Helper helper = new Helper(null);
  
  public SignerInformationVerifier build(PublicKey paramPublicKey)
    throws OperatorCreationException
  {
    return new SignerInformationVerifier(new DefaultCMSSignatureAlgorithmNameGenerator(), new DefaultSignatureAlgorithmIdentifierFinder(), this.helper.createContentVerifierProvider(paramPublicKey), this.helper.createDigestCalculatorProvider());
  }
  
  public SignerInformationVerifier build(X509Certificate paramX509Certificate)
    throws OperatorCreationException
  {
    return new SignerInformationVerifier(new DefaultCMSSignatureAlgorithmNameGenerator(), new DefaultSignatureAlgorithmIdentifierFinder(), this.helper.createContentVerifierProvider(paramX509Certificate), this.helper.createDigestCalculatorProvider());
  }
  
  public SignerInformationVerifier build(X509CertificateHolder paramX509CertificateHolder)
    throws OperatorCreationException, CertificateException
  {
    return new SignerInformationVerifier(new DefaultCMSSignatureAlgorithmNameGenerator(), new DefaultSignatureAlgorithmIdentifierFinder(), this.helper.createContentVerifierProvider(paramX509CertificateHolder), this.helper.createDigestCalculatorProvider());
  }
  
  public JcaSimpleSignerInfoVerifierBuilder setProvider(String paramString)
  {
    this.helper = new NamedHelper(paramString);
    return this;
  }
  
  public JcaSimpleSignerInfoVerifierBuilder setProvider(Provider paramProvider)
  {
    this.helper = new ProviderHelper(paramProvider);
    return this;
  }
  
  private class Helper
  {
    private Helper() {}
    
    ContentVerifierProvider createContentVerifierProvider(PublicKey paramPublicKey)
      throws OperatorCreationException
    {
      return new JcaContentVerifierProviderBuilder().build(paramPublicKey);
    }
    
    ContentVerifierProvider createContentVerifierProvider(X509Certificate paramX509Certificate)
      throws OperatorCreationException
    {
      return new JcaContentVerifierProviderBuilder().build(paramX509Certificate);
    }
    
    ContentVerifierProvider createContentVerifierProvider(X509CertificateHolder paramX509CertificateHolder)
      throws OperatorCreationException, CertificateException
    {
      return new JcaContentVerifierProviderBuilder().build(paramX509CertificateHolder);
    }
    
    DigestCalculatorProvider createDigestCalculatorProvider()
      throws OperatorCreationException
    {
      return new JcaDigestCalculatorProviderBuilder().build();
    }
  }
  
  private class NamedHelper
    extends JcaSimpleSignerInfoVerifierBuilder.Helper
  {
    private final String providerName;
    
    public NamedHelper(String paramString)
    {
      super(null);
      this.providerName = paramString;
    }
    
    ContentVerifierProvider createContentVerifierProvider(PublicKey paramPublicKey)
      throws OperatorCreationException
    {
      return new JcaContentVerifierProviderBuilder().setProvider(this.providerName).build(paramPublicKey);
    }
    
    ContentVerifierProvider createContentVerifierProvider(X509Certificate paramX509Certificate)
      throws OperatorCreationException
    {
      return new JcaContentVerifierProviderBuilder().setProvider(this.providerName).build(paramX509Certificate);
    }
    
    ContentVerifierProvider createContentVerifierProvider(X509CertificateHolder paramX509CertificateHolder)
      throws OperatorCreationException, CertificateException
    {
      return new JcaContentVerifierProviderBuilder().setProvider(this.providerName).build(paramX509CertificateHolder);
    }
    
    DigestCalculatorProvider createDigestCalculatorProvider()
      throws OperatorCreationException
    {
      return new JcaDigestCalculatorProviderBuilder().setProvider(this.providerName).build();
    }
  }
  
  private class ProviderHelper
    extends JcaSimpleSignerInfoVerifierBuilder.Helper
  {
    private final Provider provider;
    
    public ProviderHelper(Provider paramProvider)
    {
      super(null);
      this.provider = paramProvider;
    }
    
    ContentVerifierProvider createContentVerifierProvider(PublicKey paramPublicKey)
      throws OperatorCreationException
    {
      return new JcaContentVerifierProviderBuilder().setProvider(this.provider).build(paramPublicKey);
    }
    
    ContentVerifierProvider createContentVerifierProvider(X509Certificate paramX509Certificate)
      throws OperatorCreationException
    {
      return new JcaContentVerifierProviderBuilder().setProvider(this.provider).build(paramX509Certificate);
    }
    
    ContentVerifierProvider createContentVerifierProvider(X509CertificateHolder paramX509CertificateHolder)
      throws OperatorCreationException, CertificateException
    {
      return new JcaContentVerifierProviderBuilder().setProvider(this.provider).build(paramX509CertificateHolder);
    }
    
    DigestCalculatorProvider createDigestCalculatorProvider()
      throws OperatorCreationException
    {
      return new JcaDigestCalculatorProviderBuilder().setProvider(this.provider).build();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\jcajce\JcaSimpleSignerInfoVerifierBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */