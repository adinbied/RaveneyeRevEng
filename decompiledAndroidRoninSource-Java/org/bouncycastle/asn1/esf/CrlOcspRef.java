package org.bouncycastle.asn1.esf;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;

public class CrlOcspRef
  extends ASN1Object
{
  private CrlListID crlids;
  private OcspListID ocspids;
  private OtherRevRefs otherRev;
  
  private CrlOcspRef(ASN1Sequence paramASN1Sequence)
  {
    paramASN1Sequence = paramASN1Sequence.getObjects();
    while (paramASN1Sequence.hasMoreElements())
    {
      ASN1TaggedObject localASN1TaggedObject = (ASN1TaggedObject)paramASN1Sequence.nextElement();
      int i = localASN1TaggedObject.getTagNo();
      if (i != 0)
      {
        if (i != 1)
        {
          if (i == 2) {
            this.otherRev = OtherRevRefs.getInstance(localASN1TaggedObject.getObject());
          } else {
            throw new IllegalArgumentException("illegal tag");
          }
        }
        else {
          this.ocspids = OcspListID.getInstance(localASN1TaggedObject.getObject());
        }
      }
      else {
        this.crlids = CrlListID.getInstance(localASN1TaggedObject.getObject());
      }
    }
  }
  
  public CrlOcspRef(CrlListID paramCrlListID, OcspListID paramOcspListID, OtherRevRefs paramOtherRevRefs)
  {
    this.crlids = paramCrlListID;
    this.ocspids = paramOcspListID;
    this.otherRev = paramOtherRevRefs;
  }
  
  public static CrlOcspRef getInstance(Object paramObject)
  {
    if ((paramObject instanceof CrlOcspRef)) {
      return (CrlOcspRef)paramObject;
    }
    if (paramObject != null) {
      return new CrlOcspRef(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public CrlListID getCrlids()
  {
    return this.crlids;
  }
  
  public OcspListID getOcspids()
  {
    return this.ocspids;
  }
  
  public OtherRevRefs getOtherRev()
  {
    return this.otherRev;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    if (this.crlids != null) {
      localASN1EncodableVector.add(new DERTaggedObject(true, 0, this.crlids.toASN1Primitive()));
    }
    if (this.ocspids != null) {
      localASN1EncodableVector.add(new DERTaggedObject(true, 1, this.ocspids.toASN1Primitive()));
    }
    if (this.otherRev != null) {
      localASN1EncodableVector.add(new DERTaggedObject(true, 2, this.otherRev.toASN1Primitive()));
    }
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\esf\CrlOcspRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */