package org.bouncycastle.cms.jcajce;

import java.security.PrivateKey;
import java.security.Provider;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import org.bouncycastle.asn1.cms.AttributeTable;
import org.bouncycastle.cert.jcajce.JcaX509CertificateHolder;
import org.bouncycastle.cms.CMSAttributeTableGenerator;
import org.bouncycastle.cms.DefaultSignedAttributeTableGenerator;
import org.bouncycastle.cms.SignerInfoGenerator;
import org.bouncycastle.cms.SignerInfoGeneratorBuilder;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.DigestCalculatorProvider;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;
import org.bouncycastle.operator.jcajce.JcaDigestCalculatorProviderBuilder;

public class JcaSimpleSignerInfoGeneratorBuilder
{
  private boolean hasNoSignedAttributes;
  private Helper helper = new Helper(null);
  private CMSAttributeTableGenerator signedGen;
  private CMSAttributeTableGenerator unsignedGen;
  
  public JcaSimpleSignerInfoGeneratorBuilder()
    throws OperatorCreationException
  {}
  
  private SignerInfoGeneratorBuilder configureAndBuild()
    throws OperatorCreationException
  {
    SignerInfoGeneratorBuilder localSignerInfoGeneratorBuilder = new SignerInfoGeneratorBuilder(this.helper.createDigestCalculatorProvider());
    localSignerInfoGeneratorBuilder.setDirectSignature(this.hasNoSignedAttributes);
    localSignerInfoGeneratorBuilder.setSignedAttributeGenerator(this.signedGen);
    localSignerInfoGeneratorBuilder.setUnsignedAttributeGenerator(this.unsignedGen);
    return localSignerInfoGeneratorBuilder;
  }
  
  public SignerInfoGenerator build(String paramString, PrivateKey paramPrivateKey, X509Certificate paramX509Certificate)
    throws OperatorCreationException, CertificateEncodingException
  {
    paramString = this.helper.createContentSigner(paramString, paramPrivateKey);
    return configureAndBuild().build(paramString, new JcaX509CertificateHolder(paramX509Certificate));
  }
  
  public SignerInfoGenerator build(String paramString, PrivateKey paramPrivateKey, byte[] paramArrayOfByte)
    throws OperatorCreationException, CertificateEncodingException
  {
    paramString = this.helper.createContentSigner(paramString, paramPrivateKey);
    return configureAndBuild().build(paramString, paramArrayOfByte);
  }
  
  public JcaSimpleSignerInfoGeneratorBuilder setDirectSignature(boolean paramBoolean)
  {
    this.hasNoSignedAttributes = paramBoolean;
    return this;
  }
  
  public JcaSimpleSignerInfoGeneratorBuilder setProvider(String paramString)
    throws OperatorCreationException
  {
    this.helper = new NamedHelper(paramString);
    return this;
  }
  
  public JcaSimpleSignerInfoGeneratorBuilder setProvider(Provider paramProvider)
    throws OperatorCreationException
  {
    this.helper = new ProviderHelper(paramProvider);
    return this;
  }
  
  public JcaSimpleSignerInfoGeneratorBuilder setSignedAttributeGenerator(AttributeTable paramAttributeTable)
  {
    this.signedGen = new DefaultSignedAttributeTableGenerator(paramAttributeTable);
    return this;
  }
  
  public JcaSimpleSignerInfoGeneratorBuilder setSignedAttributeGenerator(CMSAttributeTableGenerator paramCMSAttributeTableGenerator)
  {
    this.signedGen = paramCMSAttributeTableGenerator;
    return this;
  }
  
  public JcaSimpleSignerInfoGeneratorBuilder setUnsignedAttributeGenerator(CMSAttributeTableGenerator paramCMSAttributeTableGenerator)
  {
    this.unsignedGen = paramCMSAttributeTableGenerator;
    return this;
  }
  
  private class Helper
  {
    private Helper() {}
    
    ContentSigner createContentSigner(String paramString, PrivateKey paramPrivateKey)
      throws OperatorCreationException
    {
      return new JcaContentSignerBuilder(paramString).build(paramPrivateKey);
    }
    
    DigestCalculatorProvider createDigestCalculatorProvider()
      throws OperatorCreationException
    {
      return new JcaDigestCalculatorProviderBuilder().build();
    }
  }
  
  private class NamedHelper
    extends JcaSimpleSignerInfoGeneratorBuilder.Helper
  {
    private final String providerName;
    
    public NamedHelper(String paramString)
    {
      super(null);
      this.providerName = paramString;
    }
    
    ContentSigner createContentSigner(String paramString, PrivateKey paramPrivateKey)
      throws OperatorCreationException
    {
      return new JcaContentSignerBuilder(paramString).setProvider(this.providerName).build(paramPrivateKey);
    }
    
    DigestCalculatorProvider createDigestCalculatorProvider()
      throws OperatorCreationException
    {
      return new JcaDigestCalculatorProviderBuilder().setProvider(this.providerName).build();
    }
  }
  
  private class ProviderHelper
    extends JcaSimpleSignerInfoGeneratorBuilder.Helper
  {
    private final Provider provider;
    
    public ProviderHelper(Provider paramProvider)
    {
      super(null);
      this.provider = paramProvider;
    }
    
    ContentSigner createContentSigner(String paramString, PrivateKey paramPrivateKey)
      throws OperatorCreationException
    {
      return new JcaContentSignerBuilder(paramString).setProvider(this.provider).build(paramPrivateKey);
    }
    
    DigestCalculatorProvider createDigestCalculatorProvider()
      throws OperatorCreationException
    {
      return new JcaDigestCalculatorProviderBuilder().setProvider(this.provider).build();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\jcajce\JcaSimpleSignerInfoGeneratorBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */