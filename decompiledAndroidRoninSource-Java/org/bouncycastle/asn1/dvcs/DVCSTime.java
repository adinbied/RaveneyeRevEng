package org.bouncycastle.asn1.dvcs;

import java.util.Date;
import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1GeneralizedTime;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.cms.ContentInfo;

public class DVCSTime
  extends ASN1Object
  implements ASN1Choice
{
  private final ASN1GeneralizedTime genTime;
  private final ContentInfo timeStampToken;
  
  public DVCSTime(Date paramDate)
  {
    this(new ASN1GeneralizedTime(paramDate));
  }
  
  public DVCSTime(ASN1GeneralizedTime paramASN1GeneralizedTime)
  {
    this.genTime = paramASN1GeneralizedTime;
    this.timeStampToken = null;
  }
  
  public DVCSTime(ContentInfo paramContentInfo)
  {
    this.genTime = null;
    this.timeStampToken = paramContentInfo;
  }
  
  public static DVCSTime getInstance(Object paramObject)
  {
    if ((paramObject instanceof DVCSTime)) {
      return (DVCSTime)paramObject;
    }
    if ((paramObject instanceof ASN1GeneralizedTime)) {
      return new DVCSTime(ASN1GeneralizedTime.getInstance(paramObject));
    }
    if (paramObject != null) {
      return new DVCSTime(ContentInfo.getInstance(paramObject));
    }
    return null;
  }
  
  public static DVCSTime getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    return getInstance(paramASN1TaggedObject.getObject());
  }
  
  public ASN1GeneralizedTime getGenTime()
  {
    return this.genTime;
  }
  
  public ContentInfo getTimeStampToken()
  {
    return this.timeStampToken;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1GeneralizedTime localASN1GeneralizedTime = this.genTime;
    if (localASN1GeneralizedTime != null) {
      return localASN1GeneralizedTime;
    }
    return this.timeStampToken.toASN1Primitive();
  }
  
  public String toString()
  {
    ASN1GeneralizedTime localASN1GeneralizedTime = this.genTime;
    if (localASN1GeneralizedTime != null) {
      return localASN1GeneralizedTime.toString();
    }
    return this.timeStampToken.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\dvcs\DVCSTime.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */