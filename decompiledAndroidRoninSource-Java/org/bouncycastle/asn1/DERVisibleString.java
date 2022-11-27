package org.bouncycastle.asn1;

import java.io.IOException;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Strings;

public class DERVisibleString
  extends ASN1Primitive
  implements ASN1String
{
  private final byte[] string;
  
  public DERVisibleString(String paramString)
  {
    this.string = Strings.toByteArray(paramString);
  }
  
  DERVisibleString(byte[] paramArrayOfByte)
  {
    this.string = paramArrayOfByte;
  }
  
  public static DERVisibleString getInstance(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof DERVisibleString)))
    {
      if ((paramObject instanceof byte[])) {
        try
        {
          paramObject = (DERVisibleString)fromByteArray((byte[])paramObject);
          return (DERVisibleString)paramObject;
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
    return (DERVisibleString)paramObject;
  }
  
  public static DERVisibleString getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    paramASN1TaggedObject = paramASN1TaggedObject.getObject();
    if ((!paramBoolean) && (!(paramASN1TaggedObject instanceof DERVisibleString))) {
      return new DERVisibleString(ASN1OctetString.getInstance(paramASN1TaggedObject).getOctets());
    }
    return getInstance(paramASN1TaggedObject);
  }
  
  boolean asn1Equals(ASN1Primitive paramASN1Primitive)
  {
    if (!(paramASN1Primitive instanceof DERVisibleString)) {
      return false;
    }
    return Arrays.areEqual(this.string, ((DERVisibleString)paramASN1Primitive).string);
  }
  
  void encode(ASN1OutputStream paramASN1OutputStream)
    throws IOException
  {
    paramASN1OutputStream.writeEncoded(26, this.string);
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\DERVisibleString.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */