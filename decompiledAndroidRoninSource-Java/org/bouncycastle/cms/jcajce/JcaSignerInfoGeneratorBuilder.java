package org.bouncycastle.cms.jcajce;

import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.jcajce.JcaX509CertificateHolder;
import org.bouncycastle.cms.CMSAttributeTableGenerator;
import org.bouncycastle.cms.CMSSignatureEncryptionAlgorithmFinder;
import org.bouncycastle.cms.DefaultCMSSignatureEncryptionAlgorithmFinder;
import org.bouncycastle.cms.SignerInfoGenerator;
import org.bouncycastle.cms.SignerInfoGeneratorBuilder;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.DigestCalculatorProvider;
import org.bouncycastle.operator.OperatorCreationException;

public class JcaSignerInfoGeneratorBuilder
{
  private SignerInfoGeneratorBuilder builder;
  
  public JcaSignerInfoGeneratorBuilder(DigestCalculatorProvider paramDigestCalculatorProvider)
  {
    this(paramDigestCalculatorProvider, new DefaultCMSSignatureEncryptionAlgorithmFinder());
  }
  
  public JcaSignerInfoGeneratorBuilder(DigestCalculatorProvider paramDigestCalculatorProvider, CMSSignatureEncryptionAlgorithmFinder paramCMSSignatureEncryptionAlgorithmFinder)
  {
    this.builder = new SignerInfoGeneratorBuilder(paramDigestCalculatorProvider, paramCMSSignatureEncryptionAlgorithmFinder);
  }
  
  public SignerInfoGenerator build(ContentSigner paramContentSigner, X509Certificate paramX509Certificate)
    throws OperatorCreationException, CertificateEncodingException
  {
    return build(paramContentSigner, new JcaX509CertificateHolder(paramX509Certificate));
  }
  
  public SignerInfoGenerator build(ContentSigner paramContentSigner, X509CertificateHolder paramX509CertificateHolder)
    throws OperatorCreationException
  {
    return this.builder.build(paramContentSigner, paramX509CertificateHolder);
  }
  
  public SignerInfoGenerator build(ContentSigner paramContentSigner, byte[] paramArrayOfByte)
    throws OperatorCreationException
  {
    return this.builder.build(paramContentSigner, paramArrayOfByte);
  }
  
  public JcaSignerInfoGeneratorBuilder setDirectSignature(boolean paramBoolean)
  {
    this.builder.setDirectSignature(paramBoolean);
    return this;
  }
  
  public JcaSignerInfoGeneratorBuilder setSignedAttributeGenerator(CMSAttributeTableGenerator paramCMSAttributeTableGenerator)
  {
    this.builder.setSignedAttributeGenerator(paramCMSAttributeTableGenerator);
    return this;
  }
  
  public JcaSignerInfoGeneratorBuilder setUnsignedAttributeGenerator(CMSAttributeTableGenerator paramCMSAttributeTableGenerator)
  {
    this.builder.setUnsignedAttributeGenerator(paramCMSAttributeTableGenerator);
    return this;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\jcajce\JcaSignerInfoGeneratorBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */