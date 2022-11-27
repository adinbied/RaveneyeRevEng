package org.bouncycastle.asn1.cms;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1SequenceParser;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class CompressedDataParser
{
  private AlgorithmIdentifier _compressionAlgorithm;
  private ContentInfoParser _encapContentInfo;
  private ASN1Integer _version;
  
  public CompressedDataParser(ASN1SequenceParser paramASN1SequenceParser)
    throws IOException
  {
    this._version = ((ASN1Integer)paramASN1SequenceParser.readObject());
    this._compressionAlgorithm = AlgorithmIdentifier.getInstance(paramASN1SequenceParser.readObject().toASN1Primitive());
    this._encapContentInfo = new ContentInfoParser((ASN1SequenceParser)paramASN1SequenceParser.readObject());
  }
  
  public AlgorithmIdentifier getCompressionAlgorithmIdentifier()
  {
    return this._compressionAlgorithm;
  }
  
  public ContentInfoParser getEncapContentInfo()
  {
    return this._encapContentInfo;
  }
  
  public ASN1Integer getVersion()
  {
    return this._version;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cms\CompressedDataParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */