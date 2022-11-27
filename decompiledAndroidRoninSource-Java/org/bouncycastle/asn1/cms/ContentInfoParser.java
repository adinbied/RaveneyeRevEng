package org.bouncycastle.asn1.cms;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1SequenceParser;
import org.bouncycastle.asn1.ASN1TaggedObjectParser;

public class ContentInfoParser
{
  private ASN1TaggedObjectParser content;
  private ASN1ObjectIdentifier contentType;
  
  public ContentInfoParser(ASN1SequenceParser paramASN1SequenceParser)
    throws IOException
  {
    this.contentType = ((ASN1ObjectIdentifier)paramASN1SequenceParser.readObject());
    this.content = ((ASN1TaggedObjectParser)paramASN1SequenceParser.readObject());
  }
  
  public ASN1Encodable getContent(int paramInt)
    throws IOException
  {
    ASN1TaggedObjectParser localASN1TaggedObjectParser = this.content;
    if (localASN1TaggedObjectParser != null) {
      return localASN1TaggedObjectParser.getObjectParser(paramInt, true);
    }
    return null;
  }
  
  public ASN1ObjectIdentifier getContentType()
  {
    return this.contentType;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cms\ContentInfoParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */