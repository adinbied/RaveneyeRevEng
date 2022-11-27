package org.bouncycastle.asn1;

import java.io.IOException;

public class BERTaggedObjectParser
  implements ASN1TaggedObjectParser
{
  private boolean _constructed;
  private ASN1StreamParser _parser;
  private int _tagNumber;
  
  BERTaggedObjectParser(boolean paramBoolean, int paramInt, ASN1StreamParser paramASN1StreamParser)
  {
    this._constructed = paramBoolean;
    this._tagNumber = paramInt;
    this._parser = paramASN1StreamParser;
  }
  
  public ASN1Primitive getLoadedObject()
    throws IOException
  {
    return this._parser.readTaggedObject(this._constructed, this._tagNumber);
  }
  
  public ASN1Encodable getObjectParser(int paramInt, boolean paramBoolean)
    throws IOException
  {
    if (paramBoolean)
    {
      if (this._constructed) {
        return this._parser.readObject();
      }
      throw new IOException("Explicit tags must be constructed (see X.690 8.14.2)");
    }
    return this._parser.readImplicit(this._constructed, paramInt);
  }
  
  public int getTagNo()
  {
    return this._tagNumber;
  }
  
  public boolean isConstructed()
  {
    return this._constructed;
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
      throw new ASN1ParsingException(localIOException.getMessage());
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\BERTaggedObjectParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */