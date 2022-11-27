package org.bouncycastle.asn1;

import java.io.IOException;

public class DERNull
  extends ASN1Null
{
  public static final DERNull INSTANCE = new DERNull();
  private static final byte[] zeroBytes = new byte[0];
  
  void encode(ASN1OutputStream paramASN1OutputStream)
    throws IOException
  {
    paramASN1OutputStream.writeEncoded(5, zeroBytes);
  }
  
  int encodedLength()
  {
    return 2;
  }
  
  boolean isConstructed()
  {
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\DERNull.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */