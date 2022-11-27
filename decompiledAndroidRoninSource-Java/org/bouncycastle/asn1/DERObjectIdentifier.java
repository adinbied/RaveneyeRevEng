package org.bouncycastle.asn1;

public class DERObjectIdentifier
  extends ASN1ObjectIdentifier
{
  public DERObjectIdentifier(String paramString)
  {
    super(paramString);
  }
  
  DERObjectIdentifier(ASN1ObjectIdentifier paramASN1ObjectIdentifier, String paramString)
  {
    super(paramASN1ObjectIdentifier, paramString);
  }
  
  DERObjectIdentifier(byte[] paramArrayOfByte)
  {
    super(paramArrayOfByte);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\DERObjectIdentifier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */