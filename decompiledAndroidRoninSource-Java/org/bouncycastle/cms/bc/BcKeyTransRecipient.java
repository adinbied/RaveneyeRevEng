package org.bouncycastle.cms.bc;

import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.cms.CMSException;
import org.bouncycastle.cms.KeyTransRecipient;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.operator.AsymmetricKeyUnwrapper;
import org.bouncycastle.operator.OperatorException;
import org.bouncycastle.operator.bc.BcRSAAsymmetricKeyUnwrapper;

public abstract class BcKeyTransRecipient
  implements KeyTransRecipient
{
  private AsymmetricKeyParameter recipientKey;
  
  public BcKeyTransRecipient(AsymmetricKeyParameter paramAsymmetricKeyParameter)
  {
    this.recipientKey = paramAsymmetricKeyParameter;
  }
  
  protected CipherParameters extractSecretKey(AlgorithmIdentifier paramAlgorithmIdentifier1, AlgorithmIdentifier paramAlgorithmIdentifier2, byte[] paramArrayOfByte)
    throws CMSException
  {
    paramAlgorithmIdentifier1 = new BcRSAAsymmetricKeyUnwrapper(paramAlgorithmIdentifier1, this.recipientKey);
    try
    {
      paramAlgorithmIdentifier1 = CMSUtils.getBcKey(paramAlgorithmIdentifier1.generateUnwrappedKey(paramAlgorithmIdentifier2, paramArrayOfByte));
      return paramAlgorithmIdentifier1;
    }
    catch (OperatorException paramAlgorithmIdentifier1)
    {
      paramAlgorithmIdentifier2 = new StringBuilder();
      paramAlgorithmIdentifier2.append("exception unwrapping key: ");
      paramAlgorithmIdentifier2.append(paramAlgorithmIdentifier1.getMessage());
      throw new CMSException(paramAlgorithmIdentifier2.toString(), paramAlgorithmIdentifier1);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\bc\BcKeyTransRecipient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */