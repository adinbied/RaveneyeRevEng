package org.bouncycastle.cms;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.BEROctetString;
import org.bouncycastle.asn1.BERSet;
import org.bouncycastle.asn1.DERSet;
import org.bouncycastle.asn1.cms.AttributeTable;
import org.bouncycastle.asn1.cms.CMSObjectIdentifiers;
import org.bouncycastle.asn1.cms.ContentInfo;
import org.bouncycastle.asn1.cms.EncryptedContentInfo;
import org.bouncycastle.asn1.cms.EnvelopedData;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.operator.OutputEncryptor;

public class CMSEnvelopedDataGenerator
  extends CMSEnvelopedGenerator
{
  private CMSEnvelopedData doGenerate(CMSTypedData paramCMSTypedData, OutputEncryptor paramOutputEncryptor)
    throws CMSException
  {
    ASN1EncodableVector localASN1EncodableVector;
    Object localObject1;
    if (this.oldRecipientInfoGenerators.isEmpty())
    {
      localASN1EncodableVector = new ASN1EncodableVector();
      localObject1 = new ByteArrayOutputStream();
    }
    try
    {
      Object localObject2 = paramOutputEncryptor.getOutputStream((OutputStream)localObject1);
      paramCMSTypedData.write((OutputStream)localObject2);
      ((OutputStream)localObject2).close();
      localObject2 = ((ByteArrayOutputStream)localObject1).toByteArray();
      localObject1 = paramOutputEncryptor.getAlgorithmIdentifier();
      localObject2 = new BEROctetString((byte[])localObject2);
      paramOutputEncryptor = paramOutputEncryptor.getKey();
      Iterator localIterator = this.recipientInfoGenerators.iterator();
      while (localIterator.hasNext()) {
        localASN1EncodableVector.add(((RecipientInfoGenerator)localIterator.next()).generate(paramOutputEncryptor));
      }
      paramOutputEncryptor = new EncryptedContentInfo(paramCMSTypedData.getContentType(), (AlgorithmIdentifier)localObject1, (ASN1OctetString)localObject2);
      paramCMSTypedData = null;
      if (this.unprotectedAttributeGenerator != null) {
        paramCMSTypedData = new BERSet(this.unprotectedAttributeGenerator.getAttributes(new HashMap()).toASN1EncodableVector());
      }
      return new CMSEnvelopedData(new ContentInfo(CMSObjectIdentifiers.envelopedData, new EnvelopedData(this.originatorInfo, new DERSet(localASN1EncodableVector), paramOutputEncryptor, paramCMSTypedData)));
    }
    catch (IOException paramCMSTypedData)
    {
      for (;;) {}
    }
    throw new CMSException("");
    throw new IllegalStateException("can only use addRecipientGenerator() with this method");
  }
  
  public CMSEnvelopedData generate(CMSTypedData paramCMSTypedData, OutputEncryptor paramOutputEncryptor)
    throws CMSException
  {
    return doGenerate(paramCMSTypedData, paramOutputEncryptor);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\CMSEnvelopedDataGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */