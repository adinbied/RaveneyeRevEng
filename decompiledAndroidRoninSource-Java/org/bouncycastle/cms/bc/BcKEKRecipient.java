package org.bouncycastle.cms.bc;

import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.cms.CMSException;
import org.bouncycastle.cms.KEKRecipient;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.operator.OperatorException;
import org.bouncycastle.operator.SymmetricKeyUnwrapper;
import org.bouncycastle.operator.bc.BcSymmetricKeyUnwrapper;

public abstract class BcKEKRecipient
  implements KEKRecipient
{
  private SymmetricKeyUnwrapper unwrapper;
  
  public BcKEKRecipient(BcSymmetricKeyUnwrapper paramBcSymmetricKeyUnwrapper)
  {
    this.unwrapper = paramBcSymmetricKeyUnwrapper;
  }
  
  protected CipherParameters extractSecretKey(AlgorithmIdentifier paramAlgorithmIdentifier1, AlgorithmIdentifier paramAlgorithmIdentifier2, byte[] paramArrayOfByte)
    throws CMSException
  {
    try
    {
      paramAlgorithmIdentifier1 = CMSUtils.getBcKey(this.unwrapper.generateUnwrappedKey(paramAlgorithmIdentifier2, paramArrayOfByte));
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\bc\BcKEKRecipient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */