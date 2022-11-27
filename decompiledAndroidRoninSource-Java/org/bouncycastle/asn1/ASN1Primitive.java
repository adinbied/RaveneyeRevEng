package org.bouncycastle.asn1;

import java.io.IOException;

public abstract class ASN1Primitive
  extends ASN1Object
{
  public static ASN1Primitive fromByteArray(byte[] paramArrayOfByte)
    throws IOException
  {
    paramArrayOfByte = new ASN1InputStream(paramArrayOfByte);
    try
    {
      ASN1Primitive localASN1Primitive = paramArrayOfByte.readObject();
      if (paramArrayOfByte.available() == 0) {
        return localASN1Primitive;
      }
      throw new IOException("Extra data detected in stream");
    }
    catch (ClassCastException paramArrayOfByte)
    {
      for (;;) {}
    }
    throw new IOException("cannot recognise object in stream");
  }
  
  abstract boolean asn1Equals(ASN1Primitive paramASN1Primitive);
  
  abstract void encode(ASN1OutputStream paramASN1OutputStream)
    throws IOException;
  
  abstract int encodedLength()
    throws IOException;
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    return ((paramObject instanceof ASN1Encodable)) && (asn1Equals(((ASN1Encodable)paramObject).toASN1Primitive()));
  }
  
  public abstract int hashCode();
  
  abstract boolean isConstructed();
  
  public ASN1Primitive toASN1Primitive()
  {
    return this;
  }
  
  ASN1Primitive toDERObject()
  {
    return this;
  }
  
  ASN1Primitive toDLObject()
  {
    return this;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\ASN1Primitive.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */