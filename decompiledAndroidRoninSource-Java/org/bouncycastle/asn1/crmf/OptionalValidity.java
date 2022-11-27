package org.bouncycastle.asn1.crmf;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.Time;

public class OptionalValidity
  extends ASN1Object
{
  private Time notAfter;
  private Time notBefore;
  
  private OptionalValidity(ASN1Sequence paramASN1Sequence)
  {
    paramASN1Sequence = paramASN1Sequence.getObjects();
    while (paramASN1Sequence.hasMoreElements())
    {
      Object localObject = (ASN1TaggedObject)paramASN1Sequence.nextElement();
      int i = ((ASN1TaggedObject)localObject).getTagNo();
      localObject = Time.getInstance((ASN1TaggedObject)localObject, true);
      if (i == 0) {
        this.notBefore = ((Time)localObject);
      } else {
        this.notAfter = ((Time)localObject);
      }
    }
  }
  
  public OptionalValidity(Time paramTime1, Time paramTime2)
  {
    if ((paramTime1 == null) && (paramTime2 == null)) {
      throw new IllegalArgumentException("at least one of notBefore/notAfter must not be null.");
    }
    this.notBefore = paramTime1;
    this.notAfter = paramTime2;
  }
  
  public static OptionalValidity getInstance(Object paramObject)
  {
    if ((paramObject instanceof OptionalValidity)) {
      return (OptionalValidity)paramObject;
    }
    if (paramObject != null) {
      return new OptionalValidity(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public Time getNotAfter()
  {
    return this.notAfter;
  }
  
  public Time getNotBefore()
  {
    return this.notBefore;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    Time localTime = this.notBefore;
    if (localTime != null) {
      localASN1EncodableVector.add(new DERTaggedObject(true, 0, localTime));
    }
    localTime = this.notAfter;
    if (localTime != null) {
      localASN1EncodableVector.add(new DERTaggedObject(true, 1, localTime));
    }
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\crmf\OptionalValidity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */