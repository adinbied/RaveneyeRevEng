package org.bouncycastle.asn1.cms;

import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERTaggedObject;

public class Evidence
  extends ASN1Object
  implements ASN1Choice
{
  private TimeStampTokenEvidence tstEvidence;
  
  private Evidence(ASN1TaggedObject paramASN1TaggedObject)
  {
    if (paramASN1TaggedObject.getTagNo() == 0) {
      this.tstEvidence = TimeStampTokenEvidence.getInstance(paramASN1TaggedObject, false);
    }
  }
  
  public Evidence(TimeStampTokenEvidence paramTimeStampTokenEvidence)
  {
    this.tstEvidence = paramTimeStampTokenEvidence;
  }
  
  public static Evidence getInstance(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof Evidence)))
    {
      if ((paramObject instanceof ASN1TaggedObject)) {
        return new Evidence(ASN1TaggedObject.getInstance(paramObject));
      }
      throw new IllegalArgumentException("unknown object in getInstance");
    }
    return (Evidence)paramObject;
  }
  
  public TimeStampTokenEvidence getTstEvidence()
  {
    return this.tstEvidence;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    TimeStampTokenEvidence localTimeStampTokenEvidence = this.tstEvidence;
    if (localTimeStampTokenEvidence != null) {
      return new DERTaggedObject(false, 0, localTimeStampTokenEvidence);
    }
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cms\Evidence.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */