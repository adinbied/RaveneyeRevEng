package org.bouncycastle.operator.bc;

import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.crypto.Signer;
import org.bouncycastle.crypto.signers.DSADigestSigner;
import org.bouncycastle.crypto.signers.ECDSASigner;
import org.bouncycastle.operator.OperatorCreationException;

public class BcECContentSignerBuilder
  extends BcContentSignerBuilder
{
  public BcECContentSignerBuilder(AlgorithmIdentifier paramAlgorithmIdentifier1, AlgorithmIdentifier paramAlgorithmIdentifier2)
  {
    super(paramAlgorithmIdentifier1, paramAlgorithmIdentifier2);
  }
  
  protected Signer createSigner(AlgorithmIdentifier paramAlgorithmIdentifier1, AlgorithmIdentifier paramAlgorithmIdentifier2)
    throws OperatorCreationException
  {
    paramAlgorithmIdentifier1 = this.digestProvider.get(paramAlgorithmIdentifier2);
    return new DSADigestSigner(new ECDSASigner(), paramAlgorithmIdentifier1);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\operator\bc\BcECContentSignerBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */