package org.bouncycastle.asn1.cms;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.SimpleTimeZone;
import java.util.TimeZone;
import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1GeneralizedTime;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.ASN1UTCTime;
import org.bouncycastle.asn1.DERGeneralizedTime;
import org.bouncycastle.asn1.DERUTCTime;

public class Time
  extends ASN1Object
  implements ASN1Choice
{
  ASN1Primitive time;
  
  public Time(Date paramDate)
  {
    Object localObject = new SimpleTimeZone(0, "Z");
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
    localSimpleDateFormat.setTimeZone((TimeZone)localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(localSimpleDateFormat.format(paramDate));
    ((StringBuilder)localObject).append("Z");
    paramDate = ((StringBuilder)localObject).toString();
    int i = Integer.parseInt(paramDate.substring(0, 4));
    if ((i >= 1950) && (i <= 2049)) {
      paramDate = new DERUTCTime(paramDate.substring(2));
    } else {
      paramDate = new DERGeneralizedTime(paramDate);
    }
    this.time = paramDate;
  }
  
  public Time(Date paramDate, Locale paramLocale)
  {
    Object localObject = new SimpleTimeZone(0, "Z");
    paramLocale = new SimpleDateFormat("yyyyMMddHHmmss", paramLocale);
    paramLocale.setTimeZone((TimeZone)localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramLocale.format(paramDate));
    ((StringBuilder)localObject).append("Z");
    paramDate = ((StringBuilder)localObject).toString();
    int i = Integer.parseInt(paramDate.substring(0, 4));
    if ((i >= 1950) && (i <= 2049)) {
      paramDate = new DERUTCTime(paramDate.substring(2));
    } else {
      paramDate = new DERGeneralizedTime(paramDate);
    }
    this.time = paramDate;
  }
  
  public Time(ASN1Primitive paramASN1Primitive)
  {
    if ((!(paramASN1Primitive instanceof ASN1UTCTime)) && (!(paramASN1Primitive instanceof ASN1GeneralizedTime))) {
      throw new IllegalArgumentException("unknown object passed to Time");
    }
    this.time = paramASN1Primitive;
  }
  
  public static Time getInstance(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof Time)))
    {
      if ((paramObject instanceof ASN1UTCTime)) {
        return new Time((ASN1UTCTime)paramObject);
      }
      if ((paramObject instanceof ASN1GeneralizedTime)) {
        return new Time((ASN1GeneralizedTime)paramObject);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("unknown object in factory: ");
      localStringBuilder.append(paramObject.getClass().getName());
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return (Time)paramObject;
  }
  
  public static Time getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    return getInstance(paramASN1TaggedObject.getObject());
  }
  
  public Date getDate()
  {
    try
    {
      if ((this.time instanceof ASN1UTCTime)) {
        return ((ASN1UTCTime)this.time).getAdjustedDate();
      }
      Date localDate = ((ASN1GeneralizedTime)this.time).getDate();
      return localDate;
    }
    catch (ParseException localParseException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("invalid date string: ");
      localStringBuilder.append(localParseException.getMessage());
      throw new IllegalStateException(localStringBuilder.toString());
    }
  }
  
  public String getTime()
  {
    ASN1Primitive localASN1Primitive = this.time;
    if ((localASN1Primitive instanceof ASN1UTCTime)) {
      return ((ASN1UTCTime)localASN1Primitive).getAdjustedTime();
    }
    return ((ASN1GeneralizedTime)localASN1Primitive).getTime();
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    return this.time;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cms\Time.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */