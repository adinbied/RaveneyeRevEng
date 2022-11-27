package org.bouncycastle.asn1;

import java.io.IOException;
import org.bouncycastle.util.Arrays;

public class DERBMPString
  extends ASN1Primitive
  implements ASN1String
{
  private final char[] string;
  
  public DERBMPString(String paramString)
  {
    this.string = paramString.toCharArray();
  }
  
  DERBMPString(byte[] paramArrayOfByte)
  {
    int j = paramArrayOfByte.length / 2;
    char[] arrayOfChar = new char[j];
    int i = 0;
    while (i != j)
    {
      int k = i * 2;
      int m = paramArrayOfByte[k];
      arrayOfChar[i] = ((char)(paramArrayOfByte[(k + 1)] & 0xFF | m << 8));
      i += 1;
    }
    this.string = arrayOfChar;
  }
  
  DERBMPString(char[] paramArrayOfChar)
  {
    this.string = paramArrayOfChar;
  }
  
  public static DERBMPString getInstance(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof DERBMPString)))
    {
      if ((paramObject instanceof byte[])) {
        try
        {
          paramObject = (DERBMPString)fromByteArray((byte[])paramObject);
          return (DERBMPString)paramObject;
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
    return (DERBMPString)paramObject;
  }
  
  public static DERBMPString getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    paramASN1TaggedObject = paramASN1TaggedObject.getObject();
    if ((!paramBoolean) && (!(paramASN1TaggedObject instanceof DERBMPString))) {
      return new DERBMPString(ASN1OctetString.getInstance(paramASN1TaggedObject).getOctets());
    }
    return getInstance(paramASN1TaggedObject);
  }
  
  protected boolean asn1Equals(ASN1Primitive paramASN1Primitive)
  {
    if (!(paramASN1Primitive instanceof DERBMPString)) {
      return false;
    }
    paramASN1Primitive = (DERBMPString)paramASN1Primitive;
    return Arrays.areEqual(this.string, paramASN1Primitive.string);
  }
  
  void encode(ASN1OutputStream paramASN1OutputStream)
    throws IOException
  {
    paramASN1OutputStream.write(30);
    paramASN1OutputStream.writeLength(this.string.length * 2);
    int i = 0;
    for (;;)
    {
      char[] arrayOfChar = this.string;
      if (i == arrayOfChar.length) {
        break;
      }
      int j = arrayOfChar[i];
      paramASN1OutputStream.write((byte)(j >> 8));
      paramASN1OutputStream.write((byte)j);
      i += 1;
    }
  }
  
  int encodedLength()
  {
    return StreamUtil.calculateBodyLength(this.string.length * 2) + 1 + this.string.length * 2;
  }
  
  public String getString()
  {
    return new String(this.string);
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\DERBMPString.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */