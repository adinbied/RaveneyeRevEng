package org.bouncycastle.asn1.x9;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;

public class OtherInfo
  extends ASN1Object
{
  private KeySpecificInfo keyInfo;
  private ASN1OctetString partyAInfo;
  private ASN1OctetString suppPubInfo;
  
  private OtherInfo(ASN1Sequence paramASN1Sequence)
  {
    paramASN1Sequence = paramASN1Sequence.getObjects();
    this.keyInfo = KeySpecificInfo.getInstance(paramASN1Sequence.nextElement());
    while (paramASN1Sequence.hasMoreElements())
    {
      ASN1TaggedObject localASN1TaggedObject = (ASN1TaggedObject)paramASN1Sequence.nextElement();
      if (localASN1TaggedObject.getTagNo() == 0) {
        this.partyAInfo = ((ASN1OctetString)localASN1TaggedObject.getObject());
      } else if (localASN1TaggedObject.getTagNo() == 2) {
        this.suppPubInfo = ((ASN1OctetString)localASN1TaggedObject.getObject());
      }
    }
  }
  
  public OtherInfo(KeySpecificInfo paramKeySpecificInfo, ASN1OctetString paramASN1OctetString1, ASN1OctetString paramASN1OctetString2)
  {
    this.keyInfo = paramKeySpecificInfo;
    this.partyAInfo = paramASN1OctetString1;
    this.suppPubInfo = paramASN1OctetString2;
  }
  
  public static OtherInfo getInstance(Object paramObject)
  {
    if ((paramObject instanceof OtherInfo)) {
      return (OtherInfo)paramObject;
    }
    if (paramObject != null) {
      return new OtherInfo(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public KeySpecificInfo getKeyInfo()
  {
    return this.keyInfo;
  }
  
  public ASN1OctetString getPartyAInfo()
  {
    return this.partyAInfo;
  }
  
  public ASN1OctetString getSuppPubInfo()
  {
    return this.suppPubInfo;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.keyInfo);
    if (this.partyAInfo != null) {
      localASN1EncodableVector.add(new DERTaggedObject(0, this.partyAInfo));
    }
    localASN1EncodableVector.add(new DERTaggedObject(2, this.suppPubInfo));
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\asn1\x9\OtherInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */