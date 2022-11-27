package org.bouncycastle.cms;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.cms.ContentInfo;
import org.bouncycastle.asn1.cms.EncryptedContentInfo;
import org.bouncycastle.asn1.cms.EncryptedData;
import org.bouncycastle.operator.InputDecryptor;
import org.bouncycastle.operator.InputDecryptorProvider;

public class CMSEncryptedData
{
  private ContentInfo contentInfo;
  private EncryptedData encryptedData;
  
  public CMSEncryptedData(ContentInfo paramContentInfo)
  {
    this.contentInfo = paramContentInfo;
    this.encryptedData = EncryptedData.getInstance(paramContentInfo.getContent());
  }
  
  public byte[] getContent(InputDecryptorProvider paramInputDecryptorProvider)
    throws CMSException
  {
    try
    {
      paramInputDecryptorProvider = CMSUtils.streamToByteArray(getContentStream(paramInputDecryptorProvider).getContentStream());
      return paramInputDecryptorProvider;
    }
    catch (IOException paramInputDecryptorProvider)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("unable to parse internal stream: ");
      localStringBuilder.append(paramInputDecryptorProvider.getMessage());
      throw new CMSException(localStringBuilder.toString(), paramInputDecryptorProvider);
    }
  }
  
  public CMSTypedStream getContentStream(InputDecryptorProvider paramInputDecryptorProvider)
    throws CMSException
  {
    try
    {
      localObject = this.encryptedData.getEncryptedContentInfo();
      paramInputDecryptorProvider = paramInputDecryptorProvider.get(((EncryptedContentInfo)localObject).getContentEncryptionAlgorithm());
      ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(((EncryptedContentInfo)localObject).getEncryptedContent().getOctets());
      paramInputDecryptorProvider = new CMSTypedStream(((EncryptedContentInfo)localObject).getContentType(), paramInputDecryptorProvider.getInputStream(localByteArrayInputStream));
      return paramInputDecryptorProvider;
    }
    catch (Exception paramInputDecryptorProvider)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("unable to create stream: ");
      ((StringBuilder)localObject).append(paramInputDecryptorProvider.getMessage());
      throw new CMSException(((StringBuilder)localObject).toString(), paramInputDecryptorProvider);
    }
  }
  
  public ContentInfo toASN1Structure()
  {
    return this.contentInfo;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\CMSEncryptedData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */