package org.bouncycastle.asn1;

import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.util.io.Streams;

public class BEROctetStringParser
  implements ASN1OctetStringParser
{
  private ASN1StreamParser _parser;
  
  BEROctetStringParser(ASN1StreamParser paramASN1StreamParser)
  {
    this._parser = paramASN1StreamParser;
  }
  
  public ASN1Primitive getLoadedObject()
    throws IOException
  {
    return new BEROctetString(Streams.readAll(getOctetStream()));
  }
  
  public InputStream getOctetStream()
  {
    return new ConstructedOctetStream(this._parser);
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("IOException converting stream to byte array: ");
      localStringBuilder.append(localIOException.getMessage());
      throw new ASN1ParsingException(localStringBuilder.toString(), localIOException);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\BEROctetStringParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */