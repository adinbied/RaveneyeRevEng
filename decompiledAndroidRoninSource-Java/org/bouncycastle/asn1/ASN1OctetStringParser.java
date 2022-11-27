package org.bouncycastle.asn1;

import java.io.InputStream;

public abstract interface ASN1OctetStringParser
  extends ASN1Encodable, InMemoryRepresentable
{
  public abstract InputStream getOctetStream();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\ASN1OctetStringParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */