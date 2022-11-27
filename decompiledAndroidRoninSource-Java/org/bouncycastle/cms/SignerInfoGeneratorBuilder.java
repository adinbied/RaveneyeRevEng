package org.bouncycastle.cms;

import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.cms.IssuerAndSerialNumber;
import org.bouncycastle.asn1.cms.SignerIdentifier;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.DigestCalculatorProvider;
import org.bouncycastle.operator.OperatorCreationException;

public class SignerInfoGeneratorBuilder
{
  private DigestCalculatorProvider digestProvider;
  private boolean directSignature;
  private CMSSignatureEncryptionAlgorithmFinder sigEncAlgFinder;
  private CMSAttributeTableGenerator signedGen;
  private CMSAttributeTableGenerator unsignedGen;
  
  public SignerInfoGeneratorBuilder(DigestCalculatorProvider paramDigestCalculatorProvider)
  {
    this(paramDigestCalculatorProvider, new DefaultCMSSignatureEncryptionAlgorithmFinder());
  }
  
  public SignerInfoGeneratorBuilder(DigestCalculatorProvider paramDigestCalculatorProvider, CMSSignatureEncryptionAlgorithmFinder paramCMSSignatureEncryptionAlgorithmFinder)
  {
    this.digestProvider = paramDigestCalculatorProvider;
    this.sigEncAlgFinder = paramCMSSignatureEncryptionAlgorithmFinder;
  }
  
  private SignerInfoGenerator createGenerator(ContentSigner paramContentSigner, SignerIdentifier paramSignerIdentifier)
    throws OperatorCreationException
  {
    if (this.directSignature) {
      return new SignerInfoGenerator(paramSignerIdentifier, paramContentSigner, this.digestProvider, this.sigEncAlgFinder, true);
    }
    if ((this.signedGen == null) && (this.unsignedGen == null)) {
      return new SignerInfoGenerator(paramSignerIdentifier, paramContentSigner, this.digestProvider, this.sigEncAlgFinder);
    }
    if (this.signedGen == null) {
      this.signedGen = new DefaultSignedAttributeTableGenerator();
    }
    return new SignerInfoGenerator(paramSignerIdentifier, paramContentSigner, this.digestProvider, this.sigEncAlgFinder, this.signedGen, this.unsignedGen);
  }
  
  public SignerInfoGenerator build(ContentSigner paramContentSigner, X509CertificateHolder paramX509CertificateHolder)
    throws OperatorCreationException
  {
    paramContentSigner = createGenerator(paramContentSigner, new SignerIdentifier(new IssuerAndSerialNumber(paramX509CertificateHolder.toASN1Structure())));
    paramContentSigner.setAssociatedCertificate(paramX509CertificateHolder);
    return paramContentSigner;
  }
  
  public SignerInfoGenerator build(ContentSigner paramContentSigner, byte[] paramArrayOfByte)
    throws OperatorCreationException
  {
    return createGenerator(paramContentSigner, new SignerIdentifier(new DEROctetString(paramArrayOfByte)));
  }
  
  public SignerInfoGeneratorBuilder setDirectSignature(boolean paramBoolean)
  {
    this.directSignature = paramBoolean;
    return this;
  }
  
  public SignerInfoGeneratorBuilder setSignedAttributeGenerator(CMSAttributeTableGenerator paramCMSAttributeTableGenerator)
  {
    this.signedGen = paramCMSAttributeTableGenerator;
    return this;
  }
  
  public SignerInfoGeneratorBuilder setUnsignedAttributeGenerator(CMSAttributeTableGenerator paramCMSAttributeTableGenerator)
  {
    this.unsignedGen = paramCMSAttributeTableGenerator;
    return this;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\SignerInfoGeneratorBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */