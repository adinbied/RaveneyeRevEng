package org.bouncycastle.asn1;

import java.io.IOException;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Strings;

public class DERUTF8String
  extends ASN1Primitive
  implements ASN1String
{
  private final byte[] string;
  
  public DERUTF8String(String paramString)
  {
    this.string = Strings.toUTF8ByteArray(paramString);
  }
  
  DERUTF8String(byte[] paramArrayOfByte)
  {
    this.string = paramArrayOfByte;
  }
  
  public static DERUTF8String getInstance(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof DERUTF8String)))
    {
      if ((paramObject instanceof byte[])) {
        try
        {
          paramObject = (DERUTF8String)fromByteArray((byte[])paramObject);
          return (DERUTF8String)paramObject;
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
    return (DERUTF8String)paramObject;
  }
  
  public static DERUTF8String getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    paramASN1TaggedObject = paramASN1TaggedObject.getObject();
    if ((!paramBoolean) && (!(paramASN1TaggedObject instanceof DERUTF8String))) {
      return new DERUTF8String(ASN1OctetString.getInstance(paramASN1TaggedObject).getOctets());
    }
    return getInstance(paramASN1TaggedObject);
  }
  
  boolean asn1Equals(ASN1Primitive paramASN1Primitive)
  {
    if (!(paramASN1Primitive instanceof DERUTF8String)) {
      return false;
    }
    paramASN1Primitive = (DERUTF8String)paramASN1Primitive;
    return Arrays.areEqual(this.string, paramASN1Primitive.string);
  }
  
  void encode(ASN1OutputStream paramASN1OutputStream)
    throws IOException
  {
    paramASN1OutputStream.writeEncoded(12, this.string);
  }
  
  int encodedLength()
    throws IOException
  {
    return StreamUtil.calculateBodyLength(this.string.length) + 1 + this.string.length;
  }
  
  public String getString()
  {
    return Strings.fromUTF8ByteArray(this.string);
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\DERUTF8String.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */