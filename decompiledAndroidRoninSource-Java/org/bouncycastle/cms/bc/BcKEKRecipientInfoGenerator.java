package org.bouncycastle.cms.bc;

import org.bouncycastle.asn1.cms.KEKIdentifier;
import org.bouncycastle.cms.KEKRecipientInfoGenerator;
import org.bouncycastle.operator.bc.BcSymmetricKeyWrapper;

public class BcKEKRecipientInfoGenerator
  extends KEKRecipientInfoGenerator
{
  public BcKEKRecipientInfoGenerator(KEKIdentifier paramKEKIdentifier, BcSymmetricKeyWrapper paramBcSymmetricKeyWrapper)
  {
    super(paramKEKIdentifier, paramBcSymmetricKeyWrapper);
  }
  
  public BcKEKRecipientInfoGenerator(byte[] paramArrayOfByte, BcSymmetricKeyWrapper paramBcSymmetricKeyWrapper)
  {
    this(new KEKIdentifier(paramArrayOfByte, null, null), paramBcSymmetricKeyWrapper);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\bc\BcKEKRecipientInfoGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */