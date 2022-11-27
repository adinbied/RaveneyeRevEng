package org.bouncycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.util.Arrays;

public class DERUniversalString
  extends ASN1Primitive
  implements ASN1String
{
  private static final char[] table = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  private final byte[] string;
  
  public DERUniversalString(byte[] paramArrayOfByte)
  {
    this.string = Arrays.clone(paramArrayOfByte);
  }
  
  public static DERUniversalString getInstance(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof DERUniversalString)))
    {
      if ((paramObject instanceof byte[])) {
        try
        {
          paramObject = (DERUniversalString)fromByteArray((byte[])paramObject);
          return (DERUniversalString)paramObject;
        }
        catch (Exception paramObject)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("encoding error getInstance: ");
          localStringBuilder.append(((Exception)paramObject).toString());
          throw new IllegalArgumentException(localStringBuilder.toString());
        }
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("illegal object in getInstance: ");
      localStringBuilder.append(paramObject.getClass().getName());
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return (DERUniversalString)paramObject;
  }
  
  public static DERUniversalString getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    paramASN1TaggedObject = paramASN1TaggedObject.getObject();
    if ((!paramBoolean) && (!(paramASN1TaggedObject instanceof DERUniversalString))) {
      return new DERUniversalString(((ASN1OctetString)paramASN1TaggedObject).getOctets());
    }
    return getInstance(paramASN1TaggedObject);
  }
  
  boolean asn1Equals(ASN1Primitive paramASN1Primitive)
  {
    if (!(paramASN1Primitive instanceof DERUniversalString)) {
      return false;
    }
    return Arrays.areEqual(this.string, ((DERUniversalString)paramASN1Primitive).string);
  }
  
  void encode(ASN1OutputStream paramASN1OutputStream)
    throws IOException
  {
    paramASN1OutputStream.writeEncoded(28, getOctets());
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
    StringBuffer localStringBuffer = new StringBuffer("#");
    Object localObject = new ByteArrayOutputStream();
    ASN1OutputStream localASN1OutputStream = new ASN1OutputStream((OutputStream)localObject);
    try
    {
      localASN1OutputStream.writeObject(this);
      localObject = ((ByteArrayOutputStream)localObject).toByteArray();
      int i = 0;
      while (i != localObject.length)
      {
        localStringBuffer.append(table[(localObject[i] >>> 4 & 0xF)]);
        localStringBuffer.append(table[(localObject[i] & 0xF)]);
        i += 1;
      }
      return localStringBuffer.toString();
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
    throw new ASN1ParsingException("internal error encoding BitString");
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\DERUniversalString.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */