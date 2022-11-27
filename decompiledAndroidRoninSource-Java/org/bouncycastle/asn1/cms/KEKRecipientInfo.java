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

public class KEKRecipientInfo
  extends ASN1Object
{
  private ASN1OctetString encryptedKey;
  private KEKIdentifier kekid;
  private AlgorithmIdentifier keyEncryptionAlgorithm;
  private ASN1Integer version;
  
  public KEKRecipientInfo(ASN1Sequence paramASN1Sequence)
  {
    this.version = ((ASN1Integer)paramASN1Sequence.getObjectAt(0));
    this.kekid = KEKIdentifier.getInstance(paramASN1Sequence.getObjectAt(1));
    this.keyEncryptionAlgorithm = AlgorithmIdentifier.getInstance(paramASN1Sequence.getObjectAt(2));
    this.encryptedKey = ((ASN1OctetString)paramASN1Sequence.getObjectAt(3));
  }
  
  public KEKRecipientInfo(KEKIdentifier paramKEKIdentifier, AlgorithmIdentifier paramAlgorithmIdentifier, ASN1OctetString paramASN1OctetString)
  {
    this.version = new ASN1Integer(4L);
    this.kekid = paramKEKIdentifier;
    this.keyEncryptionAlgorithm = paramAlgorithmIdentifier;
    this.encryptedKey = paramASN1OctetString;
  }
  
  public static KEKRecipientInfo getInstance(Object paramObject)
  {
    if ((paramObject instanceof KEKRecipientInfo)) {
      return (KEKRecipientInfo)paramObject;
    }
    if (paramObject != null) {
      return new KEKRecipientInfo(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public static KEKRecipientInfo getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    return getInstance(ASN1Sequence.getInstance(paramASN1TaggedObject, paramBoolean));
  }
  
  public ASN1OctetString getEncryptedKey()
  {
    return this.encryptedKey;
  }
  
  public KEKIdentifier getKekid()
  {
    return this.kekid;
  }
  
  public AlgorithmIdentifier getKeyEncryptionAlgorithm()
  {
    return this.keyEncryptionAlgorithm;
  }
  
  public ASN1Integer getVersion()
  {
    return this.version;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.version);
    localASN1EncodableVector.add(this.kekid);
    localASN1EncodableVector.add(this.keyEncryptionAlgorithm);
    localASN1EncodableVector.add(this.encryptedKey);
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cms\KEKRecipientInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */