package org.bouncycastle.asn1.pkcs;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DLSequence;
import org.bouncycastle.asn1.DLTaggedObject;

public class SafeBag
  extends ASN1Object
{
  private ASN1Set bagAttributes;
  private ASN1ObjectIdentifier bagId;
  private ASN1Encodable bagValue;
  
  public SafeBag(ASN1ObjectIdentifier paramASN1ObjectIdentifier, ASN1Encodable paramASN1Encodable)
  {
    this.bagId = paramASN1ObjectIdentifier;
    this.bagValue = paramASN1Encodable;
    this.bagAttributes = null;
  }
  
  public SafeBag(ASN1ObjectIdentifier paramASN1ObjectIdentifier, ASN1Encodable paramASN1Encodable, ASN1Set paramASN1Set)
  {
    this.bagId = paramASN1ObjectIdentifier;
    this.bagValue = paramASN1Encodable;
    this.bagAttributes = paramASN1Set;
  }
  
  private SafeBag(ASN1Sequence paramASN1Sequence)
  {
    this.bagId = ((ASN1ObjectIdentifier)paramASN1Sequence.getObjectAt(0));
    this.bagValue = ((ASN1TaggedObject)paramASN1Sequence.getObjectAt(1)).getObject();
    if (paramASN1Sequence.size() == 3) {
      this.bagAttributes = ((ASN1Set)paramASN1Sequence.getObjectAt(2));
    }
  }
  
  public static SafeBag getInstance(Object paramObject)
  {
    if ((paramObject instanceof SafeBag)) {
      return (SafeBag)paramObject;
    }
    if (paramObject != null) {
      return new SafeBag(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public ASN1Set getBagAttributes()
  {
    return this.bagAttributes;
  }
  
  public ASN1ObjectIdentifier getBagId()
  {
    return this.bagId;
  }
  
  public ASN1Encodable getBagValue()
  {
    return this.bagValue;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.bagId);
    localASN1EncodableVector.add(new DLTaggedObject(true, 0, this.bagValue));
    ASN1Set localASN1Set = this.bagAttributes;
    if (localASN1Set != null) {
      localASN1EncodableVector.add(localASN1Set);
    }
    return new DLSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\pkcs\SafeBag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */