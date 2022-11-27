package org.bouncycastle.asn1.util;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Primitive;

public class DERDump
  extends ASN1Dump
{
  public static String dumpAsString(ASN1Encodable paramASN1Encodable)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    _dumpAsString("", false, paramASN1Encodable.toASN1Primitive(), localStringBuffer);
    return localStringBuffer.toString();
  }
  
  public static String dumpAsString(ASN1Primitive paramASN1Primitive)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    _dumpAsString("", false, paramASN1Primitive, localStringBuffer);
    return localStringBuffer.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn\\util\DERDump.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */