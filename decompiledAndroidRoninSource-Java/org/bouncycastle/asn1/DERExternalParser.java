package org.bouncycastle.asn1;

import java.io.IOException;

public class DERExternalParser
  implements ASN1Encodable, InMemoryRepresentable
{
  private ASN1StreamParser _parser;
  
  public DERExternalParser(ASN1StreamParser paramASN1StreamParser)
  {
    this._parser = paramASN1StreamParser;
  }
  
  public ASN1Primitive getLoadedObject()
    throws IOException
  {
    try
    {
      DERExternal localDERExternal = new DERExternal(this._parser.readVector());
      return localDERExternal;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      throw new ASN1Exception(localIllegalArgumentException.getMessage(), localIllegalArgumentException);
    }
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
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      throw new ASN1ParsingException("unable to get DER object", localIllegalArgumentException);
    }
    catch (IOException localIOException)
    {
      throw new ASN1ParsingException("unable to get DER object", localIOException);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\DERExternalParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */