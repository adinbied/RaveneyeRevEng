package org.bouncycastle.asn1.cms.ecc;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.cms.OriginatorPublicKey;

public class MQVuserKeyingMaterial
  extends ASN1Object
{
  private ASN1OctetString addedukm;
  private OriginatorPublicKey ephemeralPublicKey;
  
  private MQVuserKeyingMaterial(ASN1Sequence paramASN1Sequence)
  {
    if ((paramASN1Sequence.size() != 1) && (paramASN1Sequence.size() != 2)) {
      throw new IllegalArgumentException("Sequence has incorrect number of elements");
    }
    this.ephemeralPublicKey = OriginatorPublicKey.getInstance(paramASN1Sequence.getObjectAt(0));
    if (paramASN1Sequence.size() > 1) {
      this.addedukm = ASN1OctetString.getInstance((ASN1TaggedObject)paramASN1Sequence.getObjectAt(1), true);
    }
  }
  
  public MQVuserKeyingMaterial(OriginatorPublicKey paramOriginatorPublicKey, ASN1OctetString paramASN1OctetString)
  {
    if (paramOriginatorPublicKey != null)
    {
      this.ephemeralPublicKey = paramOriginatorPublicKey;
      this.addedukm = paramASN1OctetString;
      return;
    }
    throw new IllegalArgumentException("Ephemeral public key cannot be null");
  }
  
  public static MQVuserKeyingMaterial getInstance(Object paramObject)
  {
    if ((paramObject instanceof MQVuserKeyingMaterial)) {
      return (MQVuserKeyingMaterial)paramObject;
    }
    if (paramObject != null) {
      return new MQVuserKeyingMaterial(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public static MQVuserKeyingMaterial getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    return getInstance(ASN1Sequence.getInstance(paramASN1TaggedObject, paramBoolean));
  }
  
  public ASN1OctetString getAddedukm()
  {
    return this.addedukm;
  }
  
  public OriginatorPublicKey getEphemeralPublicKey()
  {
    return this.ephemeralPublicKey;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.ephemeralPublicKey);
    ASN1OctetString localASN1OctetString = this.addedukm;
    if (localASN1OctetString != null) {
      localASN1EncodableVector.add(new DERTaggedObject(true, 0, localASN1OctetString));
    }
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cms\ecc\MQVuserKeyingMaterial.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */