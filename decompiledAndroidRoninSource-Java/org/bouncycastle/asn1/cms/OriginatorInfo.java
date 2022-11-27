package org.bouncycastle.asn1.cms;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;

public class OriginatorInfo
  extends ASN1Object
{
  private ASN1Set certs;
  private ASN1Set crls;
  
  private OriginatorInfo(ASN1Sequence paramASN1Sequence)
  {
    int i = paramASN1Sequence.size();
    if (i != 0)
    {
      if (i != 1) {
        if (i == 2)
        {
          this.certs = ASN1Set.getInstance((ASN1TaggedObject)paramASN1Sequence.getObjectAt(0), false);
          paramASN1Sequence = (ASN1TaggedObject)paramASN1Sequence.getObjectAt(1);
        }
      }
      do
      {
        this.crls = ASN1Set.getInstance(paramASN1Sequence, false);
        return;
        throw new IllegalArgumentException("OriginatorInfo too big");
        paramASN1Sequence = (ASN1TaggedObject)paramASN1Sequence.getObjectAt(0);
        i = paramASN1Sequence.getTagNo();
        if (i == 0) {
          break;
        }
      } while (i == 1);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Bad tag in OriginatorInfo: ");
      localStringBuilder.append(paramASN1Sequence.getTagNo());
      throw new IllegalArgumentException(localStringBuilder.toString());
      this.certs = ASN1Set.getInstance(paramASN1Sequence, false);
    }
  }
  
  public OriginatorInfo(ASN1Set paramASN1Set1, ASN1Set paramASN1Set2)
  {
    this.certs = paramASN1Set1;
    this.crls = paramASN1Set2;
  }
  
  public static OriginatorInfo getInstance(Object paramObject)
  {
    if ((paramObject instanceof OriginatorInfo)) {
      return (OriginatorInfo)paramObject;
    }
    if (paramObject != null) {
      return new OriginatorInfo(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public static OriginatorInfo getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    return getInstance(ASN1Sequence.getInstance(paramASN1TaggedObject, paramBoolean));
  }
  
  public ASN1Set getCRLs()
  {
    return this.crls;
  }
  
  public ASN1Set getCertificates()
  {
    return this.certs;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    if (this.certs != null) {
      localASN1EncodableVector.add(new DERTaggedObject(false, 0, this.certs));
    }
    if (this.crls != null) {
      localASN1EncodableVector.add(new DERTaggedObject(false, 1, this.crls));
    }
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cms\OriginatorInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */