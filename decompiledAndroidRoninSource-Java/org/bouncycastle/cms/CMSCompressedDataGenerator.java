package org.bouncycastle.cms;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.BEROctetString;
import org.bouncycastle.asn1.cms.CMSObjectIdentifiers;
import org.bouncycastle.asn1.cms.CompressedData;
import org.bouncycastle.asn1.cms.ContentInfo;
import org.bouncycastle.operator.OutputCompressor;

public class CMSCompressedDataGenerator
{
  public static final String ZLIB = "1.2.840.113549.1.9.16.3.8";
  
  public CMSCompressedData generate(CMSTypedData paramCMSTypedData, OutputCompressor paramOutputCompressor)
    throws CMSException
  {
    try
    {
      Object localObject = new ByteArrayOutputStream();
      OutputStream localOutputStream = paramOutputCompressor.getOutputStream((OutputStream)localObject);
      paramCMSTypedData.write(localOutputStream);
      localOutputStream.close();
      paramOutputCompressor = paramOutputCompressor.getAlgorithmIdentifier();
      localObject = new BEROctetString(((ByteArrayOutputStream)localObject).toByteArray());
      paramCMSTypedData = new ContentInfo(paramCMSTypedData.getContentType(), (ASN1Encodable)localObject);
      return new CMSCompressedData(new ContentInfo(CMSObjectIdentifiers.compressedData, new CompressedData(paramOutputCompressor, paramCMSTypedData)));
    }
    catch (IOException paramCMSTypedData)
    {
      throw new CMSException("exception encoding data.", paramCMSTypedData);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\CMSCompressedDataGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */