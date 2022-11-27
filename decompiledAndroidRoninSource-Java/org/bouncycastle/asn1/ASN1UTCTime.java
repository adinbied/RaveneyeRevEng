package org.bouncycastle.asn1;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.SimpleTimeZone;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Strings;

public class ASN1UTCTime
  extends ASN1Primitive
{
  private byte[] time;
  
  public ASN1UTCTime(String paramString)
  {
    this.time = Strings.toByteArray(paramString);
    try
    {
      getDate();
      return;
    }
    catch (ParseException paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("invalid date string: ");
      localStringBuilder.append(paramString.getMessage());
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
  }
  
  public ASN1UTCTime(Date paramDate)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyMMddHHmmss'Z'");
    localSimpleDateFormat.setTimeZone(new SimpleTimeZone(0, "Z"));
    this.time = Strings.toByteArray(localSimpleDateFormat.format(paramDate));
  }
  
  public ASN1UTCTime(Date paramDate, Locale paramLocale)
  {
    paramLocale = new SimpleDateFormat("yyMMddHHmmss'Z'", paramLocale);
    paramLocale.setTimeZone(new SimpleTimeZone(0, "Z"));
    this.time = Strings.toByteArray(paramLocale.format(paramDate));
  }
  
  ASN1UTCTime(byte[] paramArrayOfByte)
  {
    this.time = paramArrayOfByte;
  }
  
  public static ASN1UTCTime getInstance(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof ASN1UTCTime)))
    {
      if ((paramObject instanceof byte[])) {
        try
        {
          paramObject = (ASN1UTCTime)fromByteArray((byte[])paramObject);
          return (ASN1UTCTime)paramObject;
        }
        catch (Exception paramObject)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("encoding error in getInstance: ");
          localStringBuilder.append(((Exception)paramObject).toString());
          throw new IllegalArgumentException(localStringBuilder.toString());
        }
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("illegal object in getInstance: ");
      localStringBuilder.append(paramObject.getClass().getName());
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return (ASN1UTCTime)paramObject;
  }
  
  public static ASN1UTCTime getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    paramASN1TaggedObject = paramASN1TaggedObject.getObject();
    if ((!paramBoolean) && (!(paramASN1TaggedObject instanceof ASN1UTCTime))) {
      return new ASN1UTCTime(((ASN1OctetString)paramASN1TaggedObject).getOctets());
    }
    return getInstance(paramASN1TaggedObject);
  }
  
  boolean asn1Equals(ASN1Primitive paramASN1Primitive)
  {
    if (!(paramASN1Primitive instanceof ASN1UTCTime)) {
      return false;
    }
    return Arrays.areEqual(this.time, ((ASN1UTCTime)paramASN1Primitive).time);
  }
  
  void encode(ASN1OutputStream paramASN1OutputStream)
    throws IOException
  {
    paramASN1OutputStream.write(23);
    int j = this.time.length;
    paramASN1OutputStream.writeLength(j);
    int i = 0;
    while (i != j)
    {
      paramASN1OutputStream.write(this.time[i]);
      i += 1;
    }
  }
  
  int encodedLength()
  {
    int i = this.time.length;
    return StreamUtil.calculateBodyLength(i) + 1 + i;
  }
  
  public Date getAdjustedDate()
    throws ParseException
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssz");
    localSimpleDateFormat.setTimeZone(new SimpleTimeZone(0, "Z"));
    return localSimpleDateFormat.parse(getAdjustedTime());
  }
  
  public String getAdjustedTime()
  {
    String str2 = getTime();
    StringBuilder localStringBuilder;
    if (str2.charAt(0) < '5') {
      localStringBuilder = new StringBuilder();
    }
    for (String str1 = "20";; str1 = "19")
    {
      localStringBuilder.append(str1);
      localStringBuilder.append(str2);
      return localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
    }
  }
  
  public Date getDate()
    throws ParseException
  {
    return new SimpleDateFormat("yyMMddHHmmssz").parse(getTime());
  }
  
  public String getTime()
  {
    Object localObject2 = Strings.fromByteArray(this.time);
    Object localObject1;
    Object localObject3;
    if ((((String)localObject2).indexOf('-') < 0) && (((String)localObject2).indexOf('+') < 0)) {
      if (((String)localObject2).length() == 11)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(((String)localObject2).substring(0, 10));
        localObject3 = "00GMT+00:00";
        localObject2 = localObject1;
        localObject1 = localObject3;
      }
    }
    for (;;)
    {
      ((StringBuilder)localObject2).append((String)localObject1);
      return ((StringBuilder)localObject2).toString();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(((String)localObject2).substring(0, 12));
      localObject1 = "GMT+00:00";
      localObject2 = localObject3;
      continue;
      int j = ((String)localObject2).indexOf('-');
      int i = j;
      if (j < 0) {
        i = ((String)localObject2).indexOf('+');
      }
      localObject1 = localObject2;
      if (i == ((String)localObject2).length() - 3)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append("00");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      if (i == 10)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(((String)localObject1).substring(0, 10));
        ((StringBuilder)localObject2).append("00GMT");
        ((StringBuilder)localObject2).append(((String)localObject1).substring(10, 13));
        ((StringBuilder)localObject2).append(":");
        localObject1 = ((String)localObject1).substring(13, 15);
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(((String)localObject1).substring(0, 12));
        ((StringBuilder)localObject2).append("GMT");
        ((StringBuilder)localObject2).append(((String)localObject1).substring(12, 15));
        ((StringBuilder)localObject2).append(":");
        localObject1 = ((String)localObject1).substring(15, 17);
      }
    }
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(this.time);
  }
  
  boolean isConstructed()
  {
    return false;
  }
  
  public String toString()
  {
    return Strings.fromByteArray(this.time);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\ASN1UTCTime.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */