package org.bouncycastle.asn1.eac;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.SimpleTimeZone;
import org.bouncycastle.util.Arrays;

public class PackedDate
{
  private byte[] time;
  
  public PackedDate(String paramString)
  {
    this.time = convert(paramString);
  }
  
  public PackedDate(Date paramDate)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyMMdd'Z'");
    localSimpleDateFormat.setTimeZone(new SimpleTimeZone(0, "Z"));
    this.time = convert(localSimpleDateFormat.format(paramDate));
  }
  
  public PackedDate(Date paramDate, Locale paramLocale)
  {
    paramLocale = new SimpleDateFormat("yyMMdd'Z'", paramLocale);
    paramLocale.setTimeZone(new SimpleTimeZone(0, "Z"));
    this.time = convert(paramLocale.format(paramDate));
  }
  
  PackedDate(byte[] paramArrayOfByte)
  {
    this.time = paramArrayOfByte;
  }
  
  private byte[] convert(String paramString)
  {
    paramString = paramString.toCharArray();
    byte[] arrayOfByte = new byte[6];
    int i = 0;
    while (i != 6)
    {
      arrayOfByte[i] = ((byte)(paramString[i] - '0'));
      i += 1;
    }
    return arrayOfByte;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof PackedDate)) {
      return false;
    }
    paramObject = (PackedDate)paramObject;
    return Arrays.areEqual(this.time, ((PackedDate)paramObject).time);
  }
  
  public Date getDate()
    throws ParseException
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyyMMdd");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("20");
    localStringBuilder.append(toString());
    return localSimpleDateFormat.parse(localStringBuilder.toString());
  }
  
  public byte[] getEncoding()
  {
    return Arrays.clone(this.time);
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(this.time);
  }
  
  public String toString()
  {
    int j = this.time.length;
    char[] arrayOfChar = new char[j];
    int i = 0;
    while (i != j)
    {
      arrayOfChar[i] = ((char)((this.time[i] & 0xFF) + 48));
      i += 1;
    }
    return new String(arrayOfChar);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\eac\PackedDate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */