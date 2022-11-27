package org.bouncycastle.cms;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.cms.KEKIdentifier;
import org.bouncycastle.asn1.cms.KEKRecipientInfo;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class KEKRecipientInformation
  extends RecipientInformation
{
  private KEKRecipientInfo info;
  
  KEKRecipientInformation(KEKRecipientInfo paramKEKRecipientInfo, AlgorithmIdentifier paramAlgorithmIdentifier, CMSSecureReadable paramCMSSecureReadable, AuthAttributesProvider paramAuthAttributesProvider)
  {
    super(paramKEKRecipientInfo.getKeyEncryptionAlgorithm(), paramAlgorithmIdentifier, paramCMSSecureReadable, paramAuthAttributesProvider);
    this.info = paramKEKRecipientInfo;
    this.rid = new KEKRecipientId(paramKEKRecipientInfo.getKekid().getKeyIdentifier().getOctets());
  }
  
  protected RecipientOperator getRecipientOperator(Recipient paramRecipient)
    throws CMSException, IOException
  {
    return ((KEKRecipient)paramRecipient).getRecipientOperator(this.keyEncAlg, this.messageAlgorithm, this.info.getEncryptedKey().getOctets());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\KEKRecipientInformation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */