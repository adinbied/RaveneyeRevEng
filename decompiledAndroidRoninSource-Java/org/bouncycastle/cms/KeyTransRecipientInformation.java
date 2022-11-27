package org.bouncycastle.cms;

import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.cms.IssuerAndSerialNumber;
import org.bouncycastle.asn1.cms.KeyTransRecipientInfo;
import org.bouncycastle.asn1.cms.RecipientIdentifier;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class KeyTransRecipientInformation
  extends RecipientInformation
{
  private KeyTransRecipientInfo info;
  
  KeyTransRecipientInformation(KeyTransRecipientInfo paramKeyTransRecipientInfo, AlgorithmIdentifier paramAlgorithmIdentifier, CMSSecureReadable paramCMSSecureReadable, AuthAttributesProvider paramAuthAttributesProvider)
  {
    super(paramKeyTransRecipientInfo.getKeyEncryptionAlgorithm(), paramAlgorithmIdentifier, paramCMSSecureReadable, paramAuthAttributesProvider);
    this.info = paramKeyTransRecipientInfo;
    paramKeyTransRecipientInfo = paramKeyTransRecipientInfo.getRecipientIdentifier();
    boolean bool = paramKeyTransRecipientInfo.isTagged();
    paramKeyTransRecipientInfo = paramKeyTransRecipientInfo.getId();
    if (bool)
    {
      paramKeyTransRecipientInfo = new KeyTransRecipientId(ASN1OctetString.getInstance(paramKeyTransRecipientInfo).getOctets());
    }
    else
    {
      paramKeyTransRecipientInfo = IssuerAndSerialNumber.getInstance(paramKeyTransRecipientInfo);
      paramKeyTransRecipientInfo = new KeyTransRecipientId(paramKeyTransRecipientInfo.getName(), paramKeyTransRecipientInfo.getSerialNumber().getValue());
    }
    this.rid = paramKeyTransRecipientInfo;
  }
  
  protected RecipientOperator getRecipientOperator(Recipient paramRecipient)
    throws CMSException
  {
    return ((KeyTransRecipient)paramRecipient).getRecipientOperator(this.keyEncAlg, this.messageAlgorithm, this.info.getEncryptedKey().getOctets());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\KeyTransRecipientInformation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */