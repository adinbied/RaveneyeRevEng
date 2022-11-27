package org.bouncycastle.asn1;

import java.io.IOException;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Strings;

public class DERNumericString
  extends ASN1Primitive
  implements ASN1String
{
  private final byte[] string;
  
  public DERNumericString(String paramString)
  {
    this(paramString, false);
  }
  
  public DERNumericString(String paramString, boolean paramBoolean)
  {
    if ((paramBoolean) && (!isNumericString(paramString))) {
      throw new IllegalArgumentException("string contains illegal characters");
    }
    this.string = Strings.toByteArray(paramString);
  }
  
  DERNumericString(byte[] paramArrayOfByte)
  {
    this.string = paramArrayOfByte;
  }
  
  public static DERNumericString getInstance(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof DERNumericString)))
    {
      if ((paramObject instanceof byte[])) {
        try
        {
          paramObject = (DERNumericString)fromByteArray((byte[])paramObject);
          return (DERNumericString)paramObject;
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
    return (DERNumericString)paramObject;
  }
  
  public static DERNumericString getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    paramASN1TaggedObject = paramASN1TaggedObject.getObject();
    if ((!paramBoolean) && (!(paramASN1TaggedObject instanceof DERNumericString))) {
      return new DERNumericString(ASN1OctetString.getInstance(paramASN1TaggedObject).getOctets());
    }
    return getInstance(paramASN1TaggedObject);
  }
  
  public static boolean isNumericString(String paramString)
  {
    int i = paramString.length() - 1;
    while (i >= 0)
    {
      int j = paramString.charAt(i);
      if (j > 127) {
        return false;
      }
      if (((48 <= j) && (j <= 57)) || (j == 32)) {
        i -= 1;
      } else {
        return false;
      }
    }
    return true;
  }
  
  boolean asn1Equals(ASN1Primitive paramASN1Primitive)
  {
    if (!(paramASN1Primitive instanceof DERNumericString)) {
      return false;
    }
    paramASN1Primitive = (DERNumericString)paramASN1Primitive;
    return Arrays.areEqual(this.string, paramASN1Primitive.string);
  }
  
  void encode(ASN1OutputStream paramASN1OutputStream)
    throws IOException
  {
    paramASN1OutputStream.writeEncoded(18, this.string);
  }
  
  int encodedLength()
  {
    return StreamUtil.calculateBodyLength(this.string.length) + 1 + this.string.length;
  }
  
  public byte[] getOctets()
  {
    return Arrays.clone(this.string);
  }
  
  public String getString()
  {
    return Strings.fromByteArray(this.string);
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(this.string);
  }
  
  boolean isConstructed()
  {
    return false;
  }
  
  public String toString()
  {
    return getString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\DERNumericString.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */