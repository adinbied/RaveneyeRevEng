package org.bouncycastle.cms;

import java.io.IOException;
import java.util.List;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.cms.IssuerAndSerialNumber;
import org.bouncycastle.asn1.cms.KeyAgreeRecipientIdentifier;
import org.bouncycastle.asn1.cms.KeyAgreeRecipientInfo;
import org.bouncycastle.asn1.cms.OriginatorIdentifierOrKey;
import org.bouncycastle.asn1.cms.OriginatorPublicKey;
import org.bouncycastle.asn1.cms.RecipientEncryptedKey;
import org.bouncycastle.asn1.cms.RecipientKeyIdentifier;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectKeyIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;

public class KeyAgreeRecipientInformation
  extends RecipientInformation
{
  private ASN1OctetString encryptedKey;
  private KeyAgreeRecipientInfo info;
  
  KeyAgreeRecipientInformation(KeyAgreeRecipientInfo paramKeyAgreeRecipientInfo, RecipientId paramRecipientId, ASN1OctetString paramASN1OctetString, AlgorithmIdentifier paramAlgorithmIdentifier, CMSSecureReadable paramCMSSecureReadable, AuthAttributesProvider paramAuthAttributesProvider)
  {
    super(paramKeyAgreeRecipientInfo.getKeyEncryptionAlgorithm(), paramAlgorithmIdentifier, paramCMSSecureReadable, paramAuthAttributesProvider);
    this.info = paramKeyAgreeRecipientInfo;
    this.rid = paramRecipientId;
    this.encryptedKey = paramASN1OctetString;
  }
  
  private SubjectPublicKeyInfo getPublicKeyInfoFromOriginatorId(OriginatorId paramOriginatorId)
    throws CMSException
  {
    throw new CMSException("No support for 'originator' as IssuerAndSerialNumber or SubjectKeyIdentifier");
  }
  
  private SubjectPublicKeyInfo getPublicKeyInfoFromOriginatorPublicKey(AlgorithmIdentifier paramAlgorithmIdentifier, OriginatorPublicKey paramOriginatorPublicKey)
  {
    return new SubjectPublicKeyInfo(paramAlgorithmIdentifier, paramOriginatorPublicKey.getPublicKey().getBytes());
  }
  
  private SubjectPublicKeyInfo getSenderPublicKeyInfo(AlgorithmIdentifier paramAlgorithmIdentifier, OriginatorIdentifierOrKey paramOriginatorIdentifierOrKey)
    throws CMSException, IOException
  {
    OriginatorPublicKey localOriginatorPublicKey = paramOriginatorIdentifierOrKey.getOriginatorKey();
    if (localOriginatorPublicKey != null) {
      return getPublicKeyInfoFromOriginatorPublicKey(paramAlgorithmIdentifier, localOriginatorPublicKey);
    }
    paramAlgorithmIdentifier = paramOriginatorIdentifierOrKey.getIssuerAndSerialNumber();
    if (paramAlgorithmIdentifier != null) {
      paramAlgorithmIdentifier = new OriginatorId(paramAlgorithmIdentifier.getName(), paramAlgorithmIdentifier.getSerialNumber().getValue());
    } else {
      paramAlgorithmIdentifier = new OriginatorId(paramOriginatorIdentifierOrKey.getSubjectKeyIdentifier().getKeyIdentifier());
    }
    return getPublicKeyInfoFromOriginatorId(paramAlgorithmIdentifier);
  }
  
  static void readRecipientInfo(List paramList, KeyAgreeRecipientInfo paramKeyAgreeRecipientInfo, AlgorithmIdentifier paramAlgorithmIdentifier, CMSSecureReadable paramCMSSecureReadable, AuthAttributesProvider paramAuthAttributesProvider)
  {
    ASN1Sequence localASN1Sequence = paramKeyAgreeRecipientInfo.getRecipientEncryptedKeys();
    int i = 0;
    while (i < localASN1Sequence.size())
    {
      RecipientEncryptedKey localRecipientEncryptedKey = RecipientEncryptedKey.getInstance(localASN1Sequence.getObjectAt(i));
      Object localObject = localRecipientEncryptedKey.getIdentifier();
      IssuerAndSerialNumber localIssuerAndSerialNumber = ((KeyAgreeRecipientIdentifier)localObject).getIssuerAndSerialNumber();
      if (localIssuerAndSerialNumber != null) {
        localObject = new KeyAgreeRecipientId(localIssuerAndSerialNumber.getName(), localIssuerAndSerialNumber.getSerialNumber().getValue());
      } else {
        localObject = new KeyAgreeRecipientId(((KeyAgreeRecipientIdentifier)localObject).getRKeyID().getSubjectKeyIdentifier().getOctets());
      }
      paramList.add(new KeyAgreeRecipientInformation(paramKeyAgreeRecipientInfo, (RecipientId)localObject, localRecipientEncryptedKey.getEncryptedKey(), paramAlgorithmIdentifier, paramCMSSecureReadable, paramAuthAttributesProvider));
      i += 1;
    }
  }
  
  protected RecipientOperator getRecipientOperator(Recipient paramRecipient)
    throws CMSException, IOException
  {
    paramRecipient = (KeyAgreeRecipient)paramRecipient;
    AlgorithmIdentifier localAlgorithmIdentifier = paramRecipient.getPrivateKeyAlgorithmIdentifier();
    return paramRecipient.getRecipientOperator(this.keyEncAlg, this.messageAlgorithm, getSenderPublicKeyInfo(localAlgorithmIdentifier, this.info.getOriginator()), this.info.getUserKeyingMaterial(), this.encryptedKey.getOctets());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\KeyAgreeRecipientInformation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */