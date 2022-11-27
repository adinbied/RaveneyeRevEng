package org.bouncycastle.asn1.cms;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;

public class OtherRevocationInfoFormat
  extends ASN1Object
{
  private ASN1Encodable otherRevInfo;
  private ASN1ObjectIdentifier otherRevInfoFormat;
  
  public OtherRevocationInfoFormat(ASN1ObjectIdentifier paramASN1ObjectIdentifier, ASN1Encodable paramASN1Encodable)
  {
    this.otherRevInfoFormat = paramASN1ObjectIdentifier;
    this.otherRevInfo = paramASN1Encodable;
  }
  
  private OtherRevocationInfoFormat(ASN1Sequence paramASN1Sequence)
  {
    this.otherRevInfoFormat = ASN1ObjectIdentifier.getInstance(paramASN1Sequence.getObjectAt(0));
    this.otherRevInfo = paramASN1Sequence.getObjectAt(1);
  }
  
  public static OtherRevocationInfoFormat getInstance(Object paramObject)
  {
    if ((paramObject instanceof OtherRevocationInfoFormat)) {
      return (OtherRevocationInfoFormat)paramObject;
    }
    if (paramObject != null) {
      return new OtherRevocationInfoFormat(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public static OtherRevocationInfoFormat getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    return getInstance(ASN1Sequence.getInstance(paramASN1TaggedObject, paramBoolean));
  }
  
  public ASN1Encodable getInfo()
  {
    return this.otherRevInfo;
  }
  
  public ASN1ObjectIdentifier getInfoFormat()
  {
    return this.otherRevInfoFormat;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.otherRevInfoFormat);
    localASN1EncodableVector.add(this.otherRevInfo);
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cms\OtherRevocationInfoFormat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */