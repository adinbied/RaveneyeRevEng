package org.bouncycastle.asn1;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.SimpleTimeZone;
import java.util.TimeZone;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Strings;

public class ASN1GeneralizedTime
  extends ASN1Primitive
{
  private byte[] time;
  
  public ASN1GeneralizedTime(String paramString)
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
  
  public ASN1GeneralizedTime(Date paramDate)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss'Z'");
    localSimpleDateFormat.setTimeZone(new SimpleTimeZone(0, "Z"));
    this.time = Strings.toByteArray(localSimpleDateFormat.format(paramDate));
  }
  
  public ASN1GeneralizedTime(Date paramDate, Locale paramLocale)
  {
    paramLocale = new SimpleDateFormat("yyyyMMddHHmmss'Z'", paramLocale);
    paramLocale.setTimeZone(new SimpleTimeZone(0, "Z"));
    this.time = Strings.toByteArray(paramLocale.format(paramDate));
  }
  
  ASN1GeneralizedTime(byte[] paramArrayOfByte)
  {
    this.time = paramArrayOfByte;
  }
  
  private String calculateGMTOffset()
  {
    Object localObject = TimeZone.getDefault();
    i = ((TimeZone)localObject).getRawOffset();
    String str;
    if (i < 0)
    {
      i = -i;
      str = "-";
    }
    else
    {
      str = "+";
    }
    j = i / 3600000;
    int k = (i - j * 60 * 60 * 1000) / 60000;
    i = j;
    try
    {
      if (((TimeZone)localObject).useDaylightTime())
      {
        i = j;
        if (((TimeZone)localObject).inDaylightTime(getDate()))
        {
          boolean bool = str.equals("+");
          if (bool) {
            i = 1;
          } else {
            i = -1;
          }
          i = j + i;
        }
      }
    }
    catch (ParseException localParseException)
    {
      for (;;)
      {
        i = j;
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("GMT");
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append(convert(i));
    ((StringBuilder)localObject).append(":");
    ((StringBuilder)localObject).append(convert(k));
    return ((StringBuilder)localObject).toString();
  }
  
  private String convert(int paramInt)
  {
    if (paramInt < 10)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("0");
      localStringBuilder.append(paramInt);
      return localStringBuilder.toString();
    }
    return Integer.toString(paramInt);
  }
  
  public static ASN1GeneralizedTime getInstance(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof ASN1GeneralizedTime)))
    {
      if ((paramObject instanceof byte[])) {
        try
        {
          paramObject = (ASN1GeneralizedTime)fromByteArray((byte[])paramObject);
          return (ASN1GeneralizedTime)paramObject;
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
    return (ASN1GeneralizedTime)paramObject;
  }
  
  public static ASN1GeneralizedTime getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    paramASN1TaggedObject = paramASN1TaggedObject.getObject();
    if ((!paramBoolean) && (!(paramASN1TaggedObject instanceof ASN1GeneralizedTime))) {
      return new ASN1GeneralizedTime(((ASN1OctetString)paramASN1TaggedObject).getOctets());
    }
    return getInstance(paramASN1TaggedObject);
  }
  
  private boolean hasFractionalSeconds()
  {
    int i = 0;
    for (;;)
    {
      byte[] arrayOfByte = this.time;
      if (i == arrayOfByte.length) {
        break;
      }
      if ((arrayOfByte[i] == 46) && (i == 14)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  boolean asn1Equals(ASN1Primitive paramASN1Primitive)
  {
    if (!(paramASN1Primitive instanceof ASN1GeneralizedTime)) {
      return false;
    }
    return Arrays.areEqual(this.time, ((ASN1GeneralizedTime)paramASN1Primitive).time);
  }
  
  void encode(ASN1OutputStream paramASN1OutputStream)
    throws IOException
  {
    paramASN1OutputStream.writeEncoded(24, this.time);
  }
  
  int encodedLength()
  {
    int i = this.time.length;
    return StreamUtil.calculateBodyLength(i) + 1 + i;
  }
  
  public Date getDate()
    throws ParseException
  {
    Object localObject3 = Strings.fromByteArray(this.time);
    Object localObject4;
    Object localObject1;
    if (((String)localObject3).endsWith("Z"))
    {
      if (hasFractionalSeconds()) {
        localObject2 = new SimpleDateFormat("yyyyMMddHHmmss.SSS'Z'");
      } else {
        localObject2 = new SimpleDateFormat("yyyyMMddHHmmss'Z'");
      }
      localObject4 = new SimpleTimeZone(0, "Z");
      localObject1 = localObject3;
    }
    for (;;)
    {
      ((SimpleDateFormat)localObject2).setTimeZone((TimeZone)localObject4);
      localObject4 = localObject2;
      break;
      if ((((String)localObject3).indexOf('-') <= 0) && (((String)localObject3).indexOf('+') <= 0))
      {
        if (hasFractionalSeconds()) {
          localObject1 = new SimpleDateFormat("yyyyMMddHHmmss.SSS");
        } else {
          localObject1 = new SimpleDateFormat("yyyyMMddHHmmss");
        }
        localObject4 = localObject1;
        ((SimpleDateFormat)localObject4).setTimeZone(new SimpleTimeZone(0, TimeZone.getDefault().getID()));
        localObject1 = localObject3;
        break;
      }
      localObject1 = getTime();
      if (hasFractionalSeconds()) {
        localObject2 = new SimpleDateFormat("yyyyMMddHHmmss.SSSz");
      } else {
        localObject2 = new SimpleDateFormat("yyyyMMddHHmmssz");
      }
      localObject4 = new SimpleTimeZone(0, "Z");
    }
    Object localObject2 = localObject1;
    if (hasFractionalSeconds())
    {
      localObject3 = ((String)localObject1).substring(14);
      int i = 1;
      while (i < ((String)localObject3).length())
      {
        j = ((String)localObject3).charAt(i);
        if ((48 > j) || (j > 57)) {
          break;
        }
        i += 1;
      }
      int j = i - 1;
      if (j > 3)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(((String)localObject3).substring(0, 4));
        ((StringBuilder)localObject2).append(((String)localObject3).substring(i));
        localObject2 = ((StringBuilder)localObject2).toString();
        localObject3 = new StringBuilder();
      }
      for (;;)
      {
        ((StringBuilder)localObject3).append(((String)localObject1).substring(0, 14));
        ((StringBuilder)localObject3).append((String)localObject2);
        localObject2 = ((StringBuilder)localObject3).toString();
        break;
        if (j == 1)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(((String)localObject3).substring(0, i));
          ((StringBuilder)localObject2).append("00");
          ((StringBuilder)localObject2).append(((String)localObject3).substring(i));
          localObject2 = ((StringBuilder)localObject2).toString();
          localObject3 = new StringBuilder();
        }
        else
        {
          localObject2 = localObject1;
          if (j != 2) {
            break;
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(((String)localObject3).substring(0, i));
          ((StringBuilder)localObject2).append("0");
          ((StringBuilder)localObject2).append(((String)localObject3).substring(i));
          localObject2 = ((StringBuilder)localObject2).toString();
          localObject3 = new StringBuilder();
        }
      }
    }
    return ((SimpleDateFormat)localObject4).parse((String)localObject2);
  }
  
  public String getTime()
  {
    String str = Strings.fromByteArray(this.time);
    if (str.charAt(str.length() - 1) == 'Z')
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str.substring(0, str.length() - 1));
      localStringBuilder.append("GMT+00:00");
      return localStringBuilder.toString();
    }
    int i = str.length() - 5;
    int j = str.charAt(i);
    if ((j != 45) && (j != 43))
    {
      i = str.length() - 3;
      j = str.charAt(i);
      if ((j != 45) && (j != 43))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append(calculateGMTOffset());
        return localStringBuilder.toString();
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str.substring(0, i));
      localStringBuilder.append("GMT");
      localStringBuilder.append(str.substring(i));
      localStringBuilder.append(":00");
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str.substring(0, i));
    localStringBuilder.append("GMT");
    j = i + 3;
    localStringBuilder.append(str.substring(i, j));
    localStringBuilder.append(":");
    localStringBuilder.append(str.substring(j));
    return localStringBuilder.toString();
  }
  
  public String getTimeString()
  {
    return Strings.fromByteArray(this.time);
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(this.time);
  }
  
  boolean isConstructed()
  {
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\ASN1GeneralizedTime.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */