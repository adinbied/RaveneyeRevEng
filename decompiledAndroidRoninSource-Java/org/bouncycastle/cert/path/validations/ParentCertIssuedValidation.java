package org.bouncycastle.cert.path.validations;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Null;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.cert.CertException;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.X509ContentVerifierProviderBuilder;
import org.bouncycastle.cert.path.CertPathValidation;
import org.bouncycastle.cert.path.CertPathValidationContext;
import org.bouncycastle.cert.path.CertPathValidationException;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.util.Memoable;

public class ParentCertIssuedValidation
  implements CertPathValidation
{
  private X509ContentVerifierProviderBuilder contentVerifierProvider;
  private AlgorithmIdentifier workingAlgId;
  private X500Name workingIssuerName;
  private SubjectPublicKeyInfo workingPublicKey;
  
  public ParentCertIssuedValidation(X509ContentVerifierProviderBuilder paramX509ContentVerifierProviderBuilder)
  {
    this.contentVerifierProvider = paramX509ContentVerifierProviderBuilder;
  }
  
  private boolean isNull(ASN1Encodable paramASN1Encodable)
  {
    return (paramASN1Encodable == null) || ((paramASN1Encodable instanceof ASN1Null));
  }
  
  public Memoable copy()
  {
    ParentCertIssuedValidation localParentCertIssuedValidation = new ParentCertIssuedValidation(this.contentVerifierProvider);
    localParentCertIssuedValidation.workingAlgId = this.workingAlgId;
    localParentCertIssuedValidation.workingIssuerName = this.workingIssuerName;
    localParentCertIssuedValidation.workingPublicKey = this.workingPublicKey;
    return localParentCertIssuedValidation;
  }
  
  public void reset(Memoable paramMemoable)
  {
    paramMemoable = (ParentCertIssuedValidation)paramMemoable;
    this.contentVerifierProvider = paramMemoable.contentVerifierProvider;
    this.workingAlgId = paramMemoable.workingAlgId;
    this.workingIssuerName = paramMemoable.workingIssuerName;
    this.workingPublicKey = paramMemoable.workingPublicKey;
  }
  
  public void validate(CertPathValidationContext paramCertPathValidationContext, X509CertificateHolder paramX509CertificateHolder)
    throws CertPathValidationException
  {
    paramCertPathValidationContext = this.workingIssuerName;
    if ((paramCertPathValidationContext != null) && (!paramCertPathValidationContext.equals(paramX509CertificateHolder.getIssuer()))) {
      throw new CertPathValidationException("Certificate issue does not match parent");
    }
    paramCertPathValidationContext = this.workingPublicKey;
    if (paramCertPathValidationContext != null) {
      try
      {
        if (paramCertPathValidationContext.getAlgorithm().equals(this.workingAlgId)) {
          paramCertPathValidationContext = this.workingPublicKey;
        } else {
          paramCertPathValidationContext = new SubjectPublicKeyInfo(this.workingAlgId, this.workingPublicKey.parsePublicKey());
        }
        if (!paramX509CertificateHolder.isSignatureValid(this.contentVerifierProvider.build(paramCertPathValidationContext))) {
          throw new CertPathValidationException("Certificate signature not for public key in parent");
        }
      }
      catch (IOException paramCertPathValidationContext)
      {
        paramX509CertificateHolder = new StringBuilder();
        paramX509CertificateHolder.append("Unable to build public key: ");
        paramX509CertificateHolder.append(paramCertPathValidationContext.getMessage());
        throw new CertPathValidationException(paramX509CertificateHolder.toString(), paramCertPathValidationContext);
      }
      catch (CertException paramCertPathValidationContext)
      {
        paramX509CertificateHolder = new StringBuilder();
        paramX509CertificateHolder.append("Unable to validate signature: ");
        paramX509CertificateHolder.append(paramCertPathValidationContext.getMessage());
        throw new CertPathValidationException(paramX509CertificateHolder.toString(), paramCertPathValidationContext);
      }
      catch (OperatorCreationException paramCertPathValidationContext)
      {
        paramX509CertificateHolder = new StringBuilder();
        paramX509CertificateHolder.append("Unable to create verifier: ");
        paramX509CertificateHolder.append(paramCertPathValidationContext.getMessage());
        throw new CertPathValidationException(paramX509CertificateHolder.toString(), paramCertPathValidationContext);
      }
    }
    this.workingIssuerName = paramX509CertificateHolder.getSubject();
    paramCertPathValidationContext = paramX509CertificateHolder.getSubjectPublicKeyInfo();
    this.workingPublicKey = paramCertPathValidationContext;
    AlgorithmIdentifier localAlgorithmIdentifier = this.workingAlgId;
    paramX509CertificateHolder = paramCertPathValidationContext.getAlgorithm();
    paramCertPathValidationContext = paramX509CertificateHolder;
    if (localAlgorithmIdentifier != null)
    {
      if ((!paramX509CertificateHolder.getAlgorithm().equals(this.workingAlgId.getAlgorithm())) || (!isNull(this.workingPublicKey.getAlgorithm().getParameters()))) {
        paramCertPathValidationContext = this.workingPublicKey.getAlgorithm();
      }
    }
    else {
      this.workingAlgId = paramCertPathValidationContext;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cert\path\validations\ParentCertIssuedValidation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */