package org.bouncycastle.cms;

import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.cms.IssuerAndSerialNumber;
import org.bouncycastle.asn1.cms.KeyTransRecipientInfo;
import org.bouncycastle.asn1.cms.RecipientIdentifier;
import org.bouncycastle.asn1.cms.RecipientInfo;
import org.bouncycastle.operator.AsymmetricKeyWrapper;
import org.bouncycastle.operator.GenericKey;
import org.bouncycastle.operator.OperatorException;

public abstract class KeyTransRecipientInfoGenerator
  implements RecipientInfoGenerator
{
  private IssuerAndSerialNumber issuerAndSerial;
  private byte[] subjectKeyIdentifier;
  protected final AsymmetricKeyWrapper wrapper;
  
  protected KeyTransRecipientInfoGenerator(IssuerAndSerialNumber paramIssuerAndSerialNumber, AsymmetricKeyWrapper paramAsymmetricKeyWrapper)
  {
    this.issuerAndSerial = paramIssuerAndSerialNumber;
    this.wrapper = paramAsymmetricKeyWrapper;
  }
  
  protected KeyTransRecipientInfoGenerator(byte[] paramArrayOfByte, AsymmetricKeyWrapper paramAsymmetricKeyWrapper)
  {
    this.subjectKeyIdentifier = paramArrayOfByte;
    this.wrapper = paramAsymmetricKeyWrapper;
  }
  
  public final RecipientInfo generate(GenericKey paramGenericKey)
    throws CMSException
  {
    try
    {
      paramGenericKey = this.wrapper.generateWrappedKey(paramGenericKey);
      localObject = this.issuerAndSerial;
      if (localObject != null) {
        localObject = new RecipientIdentifier((IssuerAndSerialNumber)localObject);
      } else {
        localObject = new RecipientIdentifier(new DEROctetString(this.subjectKeyIdentifier));
      }
      return new RecipientInfo(new KeyTransRecipientInfo((RecipientIdentifier)localObject, this.wrapper.getAlgorithmIdentifier(), new DEROctetString(paramGenericKey)));
    }
    catch (OperatorException paramGenericKey)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("exception wrapping content key: ");
      ((StringBuilder)localObject).append(paramGenericKey.getMessage());
      throw new CMSException(((StringBuilder)localObject).toString(), paramGenericKey);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\KeyTransRecipientInfoGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */