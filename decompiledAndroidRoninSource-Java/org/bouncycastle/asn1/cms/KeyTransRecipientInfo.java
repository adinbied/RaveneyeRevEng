package org.bouncycastle.asn1.cms;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class KeyTransRecipientInfo
  extends ASN1Object
{
  private ASN1OctetString encryptedKey;
  private AlgorithmIdentifier keyEncryptionAlgorithm;
  private RecipientIdentifier rid;
  private ASN1Integer version;
  
  public KeyTransRecipientInfo(ASN1Sequence paramASN1Sequence)
  {
    this.version = ((ASN1Integer)paramASN1Sequence.getObjectAt(0));
    this.rid = RecipientIdentifier.getInstance(paramASN1Sequence.getObjectAt(1));
    this.keyEncryptionAlgorithm = AlgorithmIdentifier.getInstance(paramASN1Sequence.getObjectAt(2));
    this.encryptedKey = ((ASN1OctetString)paramASN1Sequence.getObjectAt(3));
  }
  
  public KeyTransRecipientInfo(RecipientIdentifier paramRecipientIdentifier, AlgorithmIdentifier paramAlgorithmIdentifier, ASN1OctetString paramASN1OctetString)
  {
    ASN1Integer localASN1Integer;
    if ((paramRecipientIdentifier.toASN1Primitive() instanceof ASN1TaggedObject)) {
      localASN1Integer = new ASN1Integer(2L);
    } else {
      localASN1Integer = new ASN1Integer(0L);
    }
    this.version = localASN1Integer;
    this.rid = paramRecipientIdentifier;
    this.keyEncryptionAlgorithm = paramAlgorithmIdentifier;
    this.encryptedKey = paramASN1OctetString;
  }
  
  public static KeyTransRecipientInfo getInstance(Object paramObject)
  {
    if ((paramObject instanceof KeyTransRecipientInfo)) {
      return (KeyTransRecipientInfo)paramObject;
    }
    if (paramObject != null) {
      return new KeyTransRecipientInfo(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public ASN1OctetString getEncryptedKey()
  {
    return this.encryptedKey;
  }
  
  public AlgorithmIdentifier getKeyEncryptionAlgorithm()
  {
    return this.keyEncryptionAlgorithm;
  }
  
  public RecipientIdentifier getRecipientIdentifier()
  {
    return this.rid;
  }
  
  public ASN1Integer getVersion()
  {
    return this.version;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.version);
    localASN1EncodableVector.add(this.rid);
    localASN1EncodableVector.add(this.keyEncryptionAlgorithm);
    localASN1EncodableVector.add(this.encryptedKey);
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cms\KeyTransRecipientInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */