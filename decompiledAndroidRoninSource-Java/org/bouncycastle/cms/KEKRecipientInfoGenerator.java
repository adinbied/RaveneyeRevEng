package org.bouncycastle.cms;

import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.cms.KEKIdentifier;
import org.bouncycastle.asn1.cms.KEKRecipientInfo;
import org.bouncycastle.asn1.cms.RecipientInfo;
import org.bouncycastle.operator.GenericKey;
import org.bouncycastle.operator.OperatorException;
import org.bouncycastle.operator.SymmetricKeyWrapper;

public abstract class KEKRecipientInfoGenerator
  implements RecipientInfoGenerator
{
  private final KEKIdentifier kekIdentifier;
  protected final SymmetricKeyWrapper wrapper;
  
  protected KEKRecipientInfoGenerator(KEKIdentifier paramKEKIdentifier, SymmetricKeyWrapper paramSymmetricKeyWrapper)
  {
    this.kekIdentifier = paramKEKIdentifier;
    this.wrapper = paramSymmetricKeyWrapper;
  }
  
  public final RecipientInfo generate(GenericKey paramGenericKey)
    throws CMSException
  {
    try
    {
      paramGenericKey = new DEROctetString(this.wrapper.generateWrappedKey(paramGenericKey));
      paramGenericKey = new RecipientInfo(new KEKRecipientInfo(this.kekIdentifier, this.wrapper.getAlgorithmIdentifier(), paramGenericKey));
      return paramGenericKey;
    }
    catch (OperatorException paramGenericKey)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("exception wrapping content key: ");
      localStringBuilder.append(paramGenericKey.getMessage());
      throw new CMSException(localStringBuilder.toString(), paramGenericKey);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\KEKRecipientInfoGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */