package org.bouncycastle.asn1.x509;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.util.Strings;

public class CRLDistPoint
  extends ASN1Object
{
  ASN1Sequence seq = null;
  
  private CRLDistPoint(ASN1Sequence paramASN1Sequence)
  {
    this.seq = paramASN1Sequence;
  }
  
  public CRLDistPoint(DistributionPoint[] paramArrayOfDistributionPoint)
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    int i = 0;
    while (i != paramArrayOfDistributionPoint.length)
    {
      localASN1EncodableVector.add(paramArrayOfDistributionPoint[i]);
      i += 1;
    }
    this.seq = new DERSequence(localASN1EncodableVector);
  }
  
  public static CRLDistPoint getInstance(Object paramObject)
  {
    if ((paramObject instanceof CRLDistPoint)) {
      return (CRLDistPoint)paramObject;
    }
    if (paramObject != null) {
      return new CRLDistPoint(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public static CRLDistPoint getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    return getInstance(ASN1Sequence.getInstance(paramASN1TaggedObject, paramBoolean));
  }
  
  public DistributionPoint[] getDistributionPoints()
  {
    DistributionPoint[] arrayOfDistributionPoint = new DistributionPoint[this.seq.size()];
    int i = 0;
    while (i != this.seq.size())
    {
      arrayOfDistributionPoint[i] = DistributionPoint.getInstance(this.seq.getObjectAt(i));
      i += 1;
    }
    return arrayOfDistributionPoint;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    return this.seq;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    String str = Strings.lineSeparator();
    localStringBuffer.append("CRLDistPoint:");
    localStringBuffer.append(str);
    DistributionPoint[] arrayOfDistributionPoint = getDistributionPoints();
    int i = 0;
    while (i != arrayOfDistributionPoint.length)
    {
      localStringBuffer.append("    ");
      localStringBuffer.append(arrayOfDistributionPoint[i]);
      localStringBuffer.append(str);
      i += 1;
    }
    return localStringBuffer.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\asn1\x509\CRLDistPoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */