package org.bouncycastle.cms.bc;

import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cms.CMSSignatureAlgorithmNameGenerator;
import org.bouncycastle.cms.SignerInformationVerifier;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.operator.DigestAlgorithmIdentifierFinder;
import org.bouncycastle.operator.DigestCalculatorProvider;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.operator.SignatureAlgorithmIdentifierFinder;
import org.bouncycastle.operator.bc.BcRSAContentVerifierProviderBuilder;

public class BcRSASignerInfoVerifierBuilder
{
  private BcRSAContentVerifierProviderBuilder contentVerifierProviderBuilder;
  private DigestCalculatorProvider digestCalculatorProvider;
  private SignatureAlgorithmIdentifierFinder sigAlgIdFinder;
  private CMSSignatureAlgorithmNameGenerator sigAlgNameGen;
  
  public BcRSASignerInfoVerifierBuilder(CMSSignatureAlgorithmNameGenerator paramCMSSignatureAlgorithmNameGenerator, SignatureAlgorithmIdentifierFinder paramSignatureAlgorithmIdentifierFinder, DigestAlgorithmIdentifierFinder paramDigestAlgorithmIdentifierFinder, DigestCalculatorProvider paramDigestCalculatorProvider)
  {
    this.sigAlgNameGen = paramCMSSignatureAlgorithmNameGenerator;
    this.sigAlgIdFinder = paramSignatureAlgorithmIdentifierFinder;
    this.contentVerifierProviderBuilder = new BcRSAContentVerifierProviderBuilder(paramDigestAlgorithmIdentifierFinder);
    this.digestCalculatorProvider = paramDigestCalculatorProvider;
  }
  
  public SignerInformationVerifier build(X509CertificateHolder paramX509CertificateHolder)
    throws OperatorCreationException
  {
    return new SignerInformationVerifier(this.sigAlgNameGen, this.sigAlgIdFinder, this.contentVerifierProviderBuilder.build(paramX509CertificateHolder), this.digestCalculatorProvider);
  }
  
  public SignerInformationVerifier build(AsymmetricKeyParameter paramAsymmetricKeyParameter)
    throws OperatorCreationException
  {
    return new SignerInformationVerifier(this.sigAlgNameGen, this.sigAlgIdFinder, this.contentVerifierProviderBuilder.build(paramAsymmetricKeyParameter), this.digestCalculatorProvider);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\bc\BcRSASignerInfoVerifierBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */