package org.bouncycastle.asn1.cms;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;

public class TimeStampTokenEvidence
  extends ASN1Object
{
  private TimeStampAndCRL[] timeStampAndCRLs;
  
  private TimeStampTokenEvidence(ASN1Sequence paramASN1Sequence)
  {
    this.timeStampAndCRLs = new TimeStampAndCRL[paramASN1Sequence.size()];
    paramASN1Sequence = paramASN1Sequence.getObjects();
    int i = 0;
    while (paramASN1Sequence.hasMoreElements())
    {
      this.timeStampAndCRLs[i] = TimeStampAndCRL.getInstance(paramASN1Sequence.nextElement());
      i += 1;
    }
  }
  
  public TimeStampTokenEvidence(TimeStampAndCRL paramTimeStampAndCRL)
  {
    TimeStampAndCRL[] arrayOfTimeStampAndCRL = new TimeStampAndCRL[1];
    this.timeStampAndCRLs = arrayOfTimeStampAndCRL;
    arrayOfTimeStampAndCRL[0] = paramTimeStampAndCRL;
  }
  
  public TimeStampTokenEvidence(TimeStampAndCRL[] paramArrayOfTimeStampAndCRL)
  {
    this.timeStampAndCRLs = paramArrayOfTimeStampAndCRL;
  }
  
  public static TimeStampTokenEvidence getInstance(Object paramObject)
  {
    if ((paramObject instanceof TimeStampTokenEvidence)) {
      return (TimeStampTokenEvidence)paramObject;
    }
    if (paramObject != null) {
      return new TimeStampTokenEvidence(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public static TimeStampTokenEvidence getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    return getInstance(ASN1Sequence.getInstance(paramASN1TaggedObject, paramBoolean));
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    int i = 0;
    for (;;)
    {
      TimeStampAndCRL[] arrayOfTimeStampAndCRL = this.timeStampAndCRLs;
      if (i == arrayOfTimeStampAndCRL.length) {
        break;
      }
      localASN1EncodableVector.add(arrayOfTimeStampAndCRL[i]);
      i += 1;
    }
    return new DERSequence(localASN1EncodableVector);
  }
  
  public TimeStampAndCRL[] toTimeStampAndCRLArray()
  {
    return this.timeStampAndCRLs;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cms\TimeStampTokenEvidence.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */