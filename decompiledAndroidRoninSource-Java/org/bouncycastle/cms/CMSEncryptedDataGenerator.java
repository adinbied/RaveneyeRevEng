package org.bouncycastle.cms;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.BEROctetString;
import org.bouncycastle.asn1.BERSet;
import org.bouncycastle.asn1.cms.AttributeTable;
import org.bouncycastle.asn1.cms.CMSObjectIdentifiers;
import org.bouncycastle.asn1.cms.ContentInfo;
import org.bouncycastle.asn1.cms.EncryptedContentInfo;
import org.bouncycastle.asn1.cms.EncryptedData;
import org.bouncycastle.operator.OutputEncryptor;

public class CMSEncryptedDataGenerator
  extends CMSEncryptedGenerator
{
  private CMSEncryptedData doGenerate(CMSTypedData paramCMSTypedData, OutputEncryptor paramOutputEncryptor)
    throws CMSException
  {
    Object localObject = new ByteArrayOutputStream();
    try
    {
      OutputStream localOutputStream = paramOutputEncryptor.getOutputStream((OutputStream)localObject);
      paramCMSTypedData.write(localOutputStream);
      localOutputStream.close();
      localObject = ((ByteArrayOutputStream)localObject).toByteArray();
      paramOutputEncryptor = paramOutputEncryptor.getAlgorithmIdentifier();
      localObject = new BEROctetString((byte[])localObject);
      paramOutputEncryptor = new EncryptedContentInfo(paramCMSTypedData.getContentType(), paramOutputEncryptor, (ASN1OctetString)localObject);
      paramCMSTypedData = null;
      if (this.unprotectedAttributeGenerator != null) {
        paramCMSTypedData = new BERSet(this.unprotectedAttributeGenerator.getAttributes(new HashMap()).toASN1EncodableVector());
      }
      return new CMSEncryptedData(new ContentInfo(CMSObjectIdentifiers.encryptedData, new EncryptedData(paramOutputEncryptor, paramCMSTypedData)));
    }
    catch (IOException paramCMSTypedData)
    {
      for (;;) {}
    }
    throw new CMSException("");
  }
  
  public CMSEncryptedData generate(CMSTypedData paramCMSTypedData, OutputEncryptor paramOutputEncryptor)
    throws CMSException
  {
    return doGenerate(paramCMSTypedData, paramOutputEncryptor);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\CMSEncryptedDataGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */