package org.bouncycastle.asn1.cms;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class KeyAgreeRecipientInfo
  extends ASN1Object
{
  private AlgorithmIdentifier keyEncryptionAlgorithm;
  private OriginatorIdentifierOrKey originator;
  private ASN1Sequence recipientEncryptedKeys;
  private ASN1OctetString ukm;
  private ASN1Integer version;
  
  public KeyAgreeRecipientInfo(ASN1Sequence paramASN1Sequence)
  {
    this.version = ((ASN1Integer)paramASN1Sequence.getObjectAt(0));
    this.originator = OriginatorIdentifierOrKey.getInstance((ASN1TaggedObject)paramASN1Sequence.getObjectAt(1), true);
    int i = 2;
    if ((paramASN1Sequence.getObjectAt(2) instanceof ASN1TaggedObject))
    {
      this.ukm = ASN1OctetString.getInstance((ASN1TaggedObject)paramASN1Sequence.getObjectAt(2), true);
      i = 3;
    }
    this.keyEncryptionAlgorithm = AlgorithmIdentifier.getInstance(paramASN1Sequence.getObjectAt(i));
    this.recipientEncryptedKeys = ((ASN1Sequence)paramASN1Sequence.getObjectAt(i + 1));
  }
  
  public KeyAgreeRecipientInfo(OriginatorIdentifierOrKey paramOriginatorIdentifierOrKey, ASN1OctetString paramASN1OctetString, AlgorithmIdentifier paramAlgorithmIdentifier, ASN1Sequence paramASN1Sequence)
  {
    this.version = new ASN1Integer(3L);
    this.originator = paramOriginatorIdentifierOrKey;
    this.ukm = paramASN1OctetString;
    this.keyEncryptionAlgorithm = paramAlgorithmIdentifier;
    this.recipientEncryptedKeys = paramASN1Sequence;
  }
  
  public static KeyAgreeRecipientInfo getInstance(Object paramObject)
  {
    if ((paramObject instanceof KeyAgreeRecipientInfo)) {
      return (KeyAgreeRecipientInfo)paramObject;
    }
    if (paramObject != null) {
      return new KeyAgreeRecipientInfo(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public static KeyAgreeRecipientInfo getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    return getInstance(ASN1Sequence.getInstance(paramASN1TaggedObject, paramBoolean));
  }
  
  public AlgorithmIdentifier getKeyEncryptionAlgorithm()
  {
    return this.keyEncryptionAlgorithm;
  }
  
  public OriginatorIdentifierOrKey getOriginator()
  {
    return this.originator;
  }
  
  public ASN1Sequence getRecipientEncryptedKeys()
  {
    return this.recipientEncryptedKeys;
  }
  
  public ASN1OctetString getUserKeyingMaterial()
  {
    return this.ukm;
  }
  
  public ASN1Integer getVersion()
  {
    return this.version;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.version);
    localASN1EncodableVector.add(new DERTaggedObject(true, 0, this.originator));
    if (this.ukm != null) {
      localASN1EncodableVector.add(new DERTaggedObject(true, 1, this.ukm));
    }
    localASN1EncodableVector.add(this.keyEncryptionAlgorithm);
    localASN1EncodableVector.add(this.recipientEncryptedKeys);
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cms\KeyAgreeRecipientInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */