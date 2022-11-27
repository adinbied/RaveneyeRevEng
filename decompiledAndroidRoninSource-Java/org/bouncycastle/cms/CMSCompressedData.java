package org.bouncycastle.cms;

import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.cms.CompressedData;
import org.bouncycastle.asn1.cms.ContentInfo;
import org.bouncycastle.operator.InputExpander;
import org.bouncycastle.operator.InputExpanderProvider;
import org.bouncycastle.util.Encodable;

public class CMSCompressedData
  implements Encodable
{
  CompressedData comData;
  ContentInfo contentInfo;
  
  public CMSCompressedData(InputStream paramInputStream)
    throws CMSException
  {
    this(CMSUtils.readContentInfo(paramInputStream));
  }
  
  public CMSCompressedData(ContentInfo paramContentInfo)
    throws CMSException
  {
    this.contentInfo = paramContentInfo;
    try
    {
      this.comData = CompressedData.getInstance(paramContentInfo.getContent());
      return;
    }
    catch (IllegalArgumentException paramContentInfo)
    {
      throw new CMSException("Malformed content.", paramContentInfo);
    }
    catch (ClassCastException paramContentInfo)
    {
      throw new CMSException("Malformed content.", paramContentInfo);
    }
  }
  
  public CMSCompressedData(byte[] paramArrayOfByte)
    throws CMSException
  {
    this(CMSUtils.readContentInfo(paramArrayOfByte));
  }
  
  public byte[] getContent(InputExpanderProvider paramInputExpanderProvider)
    throws CMSException
  {
    ASN1OctetString localASN1OctetString = (ASN1OctetString)this.comData.getEncapContentInfo().getContent();
    paramInputExpanderProvider = paramInputExpanderProvider.get(this.comData.getCompressionAlgorithmIdentifier()).getInputStream(localASN1OctetString.getOctetStream());
    try
    {
      paramInputExpanderProvider = CMSUtils.streamToByteArray(paramInputExpanderProvider);
      return paramInputExpanderProvider;
    }
    catch (IOException paramInputExpanderProvider)
    {
      throw new CMSException("exception reading compressed stream.", paramInputExpanderProvider);
    }
  }
  
  public ASN1ObjectIdentifier getContentType()
  {
    return this.contentInfo.getContentType();
  }
  
  public byte[] getEncoded()
    throws IOException
  {
    return this.contentInfo.getEncoded();
  }
  
  public ContentInfo toASN1Structure()
  {
    return this.contentInfo;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\CMSCompressedData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */