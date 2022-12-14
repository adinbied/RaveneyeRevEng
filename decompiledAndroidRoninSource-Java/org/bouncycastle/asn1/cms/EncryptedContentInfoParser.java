package org.bouncycastle.asn1.cms;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1SequenceParser;
import org.bouncycastle.asn1.ASN1TaggedObjectParser;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class EncryptedContentInfoParser
{
  private AlgorithmIdentifier _contentEncryptionAlgorithm;
  private ASN1ObjectIdentifier _contentType;
  private ASN1TaggedObjectParser _encryptedContent;
  
  public EncryptedContentInfoParser(ASN1SequenceParser paramASN1SequenceParser)
    throws IOException
  {
    this._contentType = ((ASN1ObjectIdentifier)paramASN1SequenceParser.readObject());
    this._contentEncryptionAlgorithm = AlgorithmIdentifier.getInstance(paramASN1SequenceParser.readObject().toASN1Primitive());
    this._encryptedContent = ((ASN1TaggedObjectParser)paramASN1SequenceParser.readObject());
  }
  
  public AlgorithmIdentifier getContentEncryptionAlgorithm()
  {
    return this._contentEncryptionAlgorithm;
  }
  
  public ASN1ObjectIdentifier getContentType()
  {
    return this._contentType;
  }
  
  public ASN1Encodable getEncryptedContent(int paramInt)
    throws IOException
  {
    return this._encryptedContent.getObjectParser(paramInt, false);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cms\EncryptedContentInfoParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */