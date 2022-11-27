package org.bouncycastle.asn1;

import java.io.IOException;
import java.io.InputStream;

public class DEROctetStringParser
  implements ASN1OctetStringParser
{
  private DefiniteLengthInputStream stream;
  
  DEROctetStringParser(DefiniteLengthInputStream paramDefiniteLengthInputStream)
  {
    this.stream = paramDefiniteLengthInputStream;
  }
  
  public ASN1Primitive getLoadedObject()
    throws IOException
  {
    return new DEROctetString(this.stream.toByteArray());
  }
  
  public InputStream getOctetStream()
  {
    return this.stream;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\DEROctetStringParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */