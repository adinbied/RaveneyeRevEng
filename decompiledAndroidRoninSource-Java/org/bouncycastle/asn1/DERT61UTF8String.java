package org.bouncycastle.asn1;

import java.io.IOException;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Strings;

public class DERT61UTF8String
  extends ASN1Primitive
  implements ASN1String
{
  private byte[] string;
  
  public DERT61UTF8String(String paramString)
  {
    this(Strings.toUTF8ByteArray(paramString));
  }
  
  public DERT61UTF8String(byte[] paramArrayOfByte)
  {
    this.string = paramArrayOfByte;
  }
  
  public static DERT61UTF8String getInstance(Object paramObject)
  {
    if ((paramObject instanceof DERT61String)) {
      return new DERT61UTF8String(((DERT61String)paramObject).getOctets());
    }
    if ((paramObject != null) && (!(paramObject instanceof DERT61UTF8String)))
    {
      if ((paramObject instanceof byte[])) {
        try
        {
          paramObject = new DERT61UTF8String(((DERT61String)fromByteArray((byte[])paramObject)).getOctets());
          return (DERT61UTF8String)paramObject;
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
    return (DERT61UTF8String)paramObject;
  }
  
  public static DERT61UTF8String getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    paramASN1TaggedObject = paramASN1TaggedObject.getObject();
    if ((!paramBoolean) && (!(paramASN1TaggedObject instanceof DERT61String)) && (!(paramASN1TaggedObject instanceof DERT61UTF8String))) {
      return new DERT61UTF8String(ASN1OctetString.getInstance(paramASN1TaggedObject).getOctets());
    }
    return getInstance(paramASN1TaggedObject);
  }
  
  boolean asn1Equals(ASN1Primitive paramASN1Primitive)
  {
    if (!(paramASN1Primitive instanceof DERT61UTF8String)) {
      return false;
    }
    return Arrays.areEqual(this.string, ((DERT61UTF8String)paramASN1Primitive).string);
  }
  
  void encode(ASN1OutputStream paramASN1OutputStream)
    throws IOException
  {
    paramASN1OutputStream.writeEncoded(20, this.string);
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\DERT61UTF8String.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */