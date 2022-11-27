package org.bouncycastle.asn1;

import java.io.IOException;

public class DEROctetString
  extends ASN1OctetString
{
  public DEROctetString(ASN1Encodable paramASN1Encodable)
    throws IOException
  {
    super(paramASN1Encodable.toASN1Primitive().getEncoded("DER"));
  }
  
  public DEROctetString(byte[] paramArrayOfByte)
  {
    super(paramArrayOfByte);
  }
  
  static void encode(DEROutputStream paramDEROutputStream, byte[] paramArrayOfByte)
    throws IOException
  {
    paramDEROutputStream.writeEncoded(4, paramArrayOfByte);
  }
  
  void encode(ASN1OutputStream paramASN1OutputStream)
    throws IOException
  {
    paramASN1OutputStream.writeEncoded(4, this.string);
  }
  
  int encodedLength()
  {
    return StreamUtil.calculateBodyLength(this.string.length) + 1 + this.string.length;
  }
  
  boolean isConstructed()
  {
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\DEROctetString.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */