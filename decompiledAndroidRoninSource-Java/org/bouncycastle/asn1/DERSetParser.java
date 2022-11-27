package org.bouncycastle.asn1;

import java.io.IOException;

public class DERSetParser
  implements ASN1SetParser
{
  private ASN1StreamParser _parser;
  
  DERSetParser(ASN1StreamParser paramASN1StreamParser)
  {
    this._parser = paramASN1StreamParser;
  }
  
  public ASN1Primitive getLoadedObject()
    throws IOException
  {
    return new DERSet(this._parser.readVector(), false);
  }
  
  public ASN1Encodable readObject()
    throws IOException
  {
    return this._parser.readObject();
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    try
    {
      ASN1Primitive localASN1Primitive = getLoadedObject();
      return localASN1Primitive;
    }
    catch (IOException localIOException)
    {
      throw new ASN1ParsingException(localIOException.getMessage(), localIOException);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\DERSetParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */