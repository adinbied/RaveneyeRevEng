package org.bouncycastle.asn1;

import java.io.IOException;

public abstract interface ASN1SequenceParser
  extends ASN1Encodable, InMemoryRepresentable
{
  public abstract ASN1Encodable readObject()
    throws IOException;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\ASN1SequenceParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */