package org.bouncycastle.operator.bc;

import java.io.IOException;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.crypto.Signer;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.signers.DSADigestSigner;
import org.bouncycastle.crypto.signers.DSASigner;
import org.bouncycastle.crypto.util.PublicKeyFactory;
import org.bouncycastle.operator.DigestAlgorithmIdentifierFinder;
import org.bouncycastle.operator.OperatorCreationException;

public class BcDSAContentVerifierProviderBuilder
  extends BcContentVerifierProviderBuilder
{
  private DigestAlgorithmIdentifierFinder digestAlgorithmFinder;
  
  public BcDSAContentVerifierProviderBuilder(DigestAlgorithmIdentifierFinder paramDigestAlgorithmIdentifierFinder)
  {
    this.digestAlgorithmFinder = paramDigestAlgorithmIdentifierFinder;
  }
  
  protected Signer createSigner(AlgorithmIdentifier paramAlgorithmIdentifier)
    throws OperatorCreationException
  {
    paramAlgorithmIdentifier = this.digestAlgorithmFinder.find(paramAlgorithmIdentifier);
    paramAlgorithmIdentifier = this.digestProvider.get(paramAlgorithmIdentifier);
    return new DSADigestSigner(new DSASigner(), paramAlgorithmIdentifier);
  }
  
  protected AsymmetricKeyParameter extractKeyParameters(SubjectPublicKeyInfo paramSubjectPublicKeyInfo)
    throws IOException
  {
    return PublicKeyFactory.createKey(paramSubjectPublicKeyInfo);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\operator\bc\BcDSAContentVerifierProviderBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */