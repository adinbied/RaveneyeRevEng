package org.bouncycastle.cms;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetStringParser;
import org.bouncycastle.asn1.ASN1SequenceParser;
import org.bouncycastle.asn1.cms.CompressedDataParser;
import org.bouncycastle.asn1.cms.ContentInfoParser;
import org.bouncycastle.operator.InputExpander;
import org.bouncycastle.operator.InputExpanderProvider;

public class CMSCompressedDataParser
  extends CMSContentInfoParser
{
  public CMSCompressedDataParser(InputStream paramInputStream)
    throws CMSException
  {
    super(paramInputStream);
  }
  
  public CMSCompressedDataParser(byte[] paramArrayOfByte)
    throws CMSException
  {
    this(new ByteArrayInputStream(paramArrayOfByte));
  }
  
  public CMSTypedStream getContent(InputExpanderProvider paramInputExpanderProvider)
    throws CMSException
  {
    try
    {
      Object localObject = new CompressedDataParser((ASN1SequenceParser)this._contentInfo.getContent(16));
      ContentInfoParser localContentInfoParser = ((CompressedDataParser)localObject).getEncapContentInfo();
      paramInputExpanderProvider = paramInputExpanderProvider.get(((CompressedDataParser)localObject).getCompressionAlgorithmIdentifier());
      localObject = (ASN1OctetStringParser)localContentInfoParser.getContent(4);
      paramInputExpanderProvider = new CMSTypedStream(localContentInfoParser.getContentType().getId(), paramInputExpanderProvider.getInputStream(((ASN1OctetStringParser)localObject).getOctetStream()));
      return paramInputExpanderProvider;
    }
    catch (IOException paramInputExpanderProvider)
    {
      throw new CMSException("IOException reading compressed content.", paramInputExpanderProvider);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\CMSCompressedDataParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */