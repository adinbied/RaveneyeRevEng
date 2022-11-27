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

public class PasswordRecipientInfo
  extends ASN1Object
{
  private ASN1OctetString encryptedKey;
  private AlgorithmIdentifier keyDerivationAlgorithm;
  private AlgorithmIdentifier keyEncryptionAlgorithm;
  private ASN1Integer version;
  
  public PasswordRecipientInfo(ASN1Sequence paramASN1Sequence)
  {
    this.version = ((ASN1Integer)paramASN1Sequence.getObjectAt(0));
    if ((paramASN1Sequence.getObjectAt(1) instanceof ASN1TaggedObject))
    {
      this.keyDerivationAlgorithm = AlgorithmIdentifier.getInstance((ASN1TaggedObject)paramASN1Sequence.getObjectAt(1), false);
      this.keyEncryptionAlgorithm = AlgorithmIdentifier.getInstance(paramASN1Sequence.getObjectAt(2));
      paramASN1Sequence = paramASN1Sequence.getObjectAt(3);
    }
    else
    {
      this.keyEncryptionAlgorithm = AlgorithmIdentifier.getInstance(paramASN1Sequence.getObjectAt(1));
      paramASN1Sequence = paramASN1Sequence.getObjectAt(2);
    }
    this.encryptedKey = ((ASN1OctetString)paramASN1Sequence);
  }
  
  public PasswordRecipientInfo(AlgorithmIdentifier paramAlgorithmIdentifier, ASN1OctetString paramASN1OctetString)
  {
    this.version = new ASN1Integer(0L);
    this.keyEncryptionAlgorithm = paramAlgorithmIdentifier;
    this.encryptedKey = paramASN1OctetString;
  }
  
  public PasswordRecipientInfo(AlgorithmIdentifier paramAlgorithmIdentifier1, AlgorithmIdentifier paramAlgorithmIdentifier2, ASN1OctetString paramASN1OctetString)
  {
    this.version = new ASN1Integer(0L);
    this.keyDerivationAlgorithm = paramAlgorithmIdentifier1;
    this.keyEncryptionAlgorithm = paramAlgorithmIdentifier2;
    this.encryptedKey = paramASN1OctetString;
  }
  
  public static PasswordRecipientInfo getInstance(Object paramObject)
  {
    if ((paramObject instanceof PasswordRecipientInfo)) {
      return (PasswordRecipientInfo)paramObject;
    }
    if (paramObject != null) {
      return new PasswordRecipientInfo(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public static PasswordRecipientInfo getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    return getInstance(ASN1Sequence.getInstance(paramASN1TaggedObject, paramBoolean));
  }
  
  public ASN1OctetString getEncryptedKey()
  {
    return this.encryptedKey;
  }
  
  public AlgorithmIdentifier getKeyDerivationAlgorithm()
  {
    return this.keyDerivationAlgorithm;
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
    AlgorithmIdentifier localAlgorithmIdentifier = this.keyDerivationAlgorithm;
    if (localAlgorithmIdentifier != null) {
      localASN1EncodableVector.add(new DERTaggedObject(false, 0, localAlgorithmIdentifier));
    }
    localASN1EncodableVector.add(this.keyEncryptionAlgorithm);
    localASN1EncodableVector.add(this.encryptedKey);
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cms\PasswordRecipientInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */