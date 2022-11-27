package org.bouncycastle.cms;

import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.operator.ContentVerifier;
import org.bouncycastle.operator.ContentVerifierProvider;
import org.bouncycastle.operator.DigestCalculator;
import org.bouncycastle.operator.DigestCalculatorProvider;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.operator.SignatureAlgorithmIdentifierFinder;

public class SignerInformationVerifier
{
  private DigestCalculatorProvider digestProvider;
  private SignatureAlgorithmIdentifierFinder sigAlgorithmFinder;
  private CMSSignatureAlgorithmNameGenerator sigNameGenerator;
  private ContentVerifierProvider verifierProvider;
  
  public SignerInformationVerifier(CMSSignatureAlgorithmNameGenerator paramCMSSignatureAlgorithmNameGenerator, SignatureAlgorithmIdentifierFinder paramSignatureAlgorithmIdentifierFinder, ContentVerifierProvider paramContentVerifierProvider, DigestCalculatorProvider paramDigestCalculatorProvider)
  {
    this.sigNameGenerator = paramCMSSignatureAlgorithmNameGenerator;
    this.sigAlgorithmFinder = paramSignatureAlgorithmIdentifierFinder;
    this.verifierProvider = paramContentVerifierProvider;
    this.digestProvider = paramDigestCalculatorProvider;
  }
  
  public X509CertificateHolder getAssociatedCertificate()
  {
    return this.verifierProvider.getAssociatedCertificate();
  }
  
  public ContentVerifier getContentVerifier(AlgorithmIdentifier paramAlgorithmIdentifier1, AlgorithmIdentifier paramAlgorithmIdentifier2)
    throws OperatorCreationException
  {
    paramAlgorithmIdentifier2 = this.sigNameGenerator.getSignatureName(paramAlgorithmIdentifier2, paramAlgorithmIdentifier1);
    paramAlgorithmIdentifier2 = this.sigAlgorithmFinder.find(paramAlgorithmIdentifier2);
    return this.verifierProvider.get(new AlgorithmIdentifier(paramAlgorithmIdentifier2.getAlgorithm(), paramAlgorithmIdentifier1.getParameters()));
  }
  
  public DigestCalculator getDigestCalculator(AlgorithmIdentifier paramAlgorithmIdentifier)
    throws OperatorCreationException
  {
    return this.digestProvider.get(paramAlgorithmIdentifier);
  }
  
  public boolean hasAssociatedCertificate()
  {
    return this.verifierProvider.hasAssociatedCertificate();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\SignerInformationVerifier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */