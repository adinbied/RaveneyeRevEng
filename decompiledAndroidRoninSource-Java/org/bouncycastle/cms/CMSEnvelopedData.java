package org.bouncycastle.cms;

import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.cms.AttributeTable;
import org.bouncycastle.asn1.cms.ContentInfo;
import org.bouncycastle.asn1.cms.EncryptedContentInfo;
import org.bouncycastle.asn1.cms.EnvelopedData;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.util.Encodable;

public class CMSEnvelopedData
  implements Encodable
{
  ContentInfo contentInfo;
  private AlgorithmIdentifier encAlg;
  private OriginatorInformation originatorInfo;
  RecipientInformationStore recipientInfoStore;
  private ASN1Set unprotectedAttributes;
  
  public CMSEnvelopedData(InputStream paramInputStream)
    throws CMSException
  {
    this(CMSUtils.readContentInfo(paramInputStream));
  }
  
  public CMSEnvelopedData(ContentInfo paramContentInfo)
    throws CMSException
  {
    this.contentInfo = paramContentInfo;
    try
    {
      paramContentInfo = EnvelopedData.getInstance(paramContentInfo.getContent());
      if (paramContentInfo.getOriginatorInfo() != null) {
        this.originatorInfo = new OriginatorInformation(paramContentInfo.getOriginatorInfo());
      }
      ASN1Set localASN1Set = paramContentInfo.getRecipientInfos();
      Object localObject = paramContentInfo.getEncryptedContentInfo();
      this.encAlg = ((EncryptedContentInfo)localObject).getContentEncryptionAlgorithm();
      localObject = new CMSProcessableByteArray(((EncryptedContentInfo)localObject).getEncryptedContent().getOctets());
      localObject = new CMSEnvelopedHelper.CMSEnvelopedSecureReadable(this.encAlg, (CMSReadable)localObject);
      this.recipientInfoStore = CMSEnvelopedHelper.buildRecipientInformationStore(localASN1Set, this.encAlg, (CMSSecureReadable)localObject);
      this.unprotectedAttributes = paramContentInfo.getUnprotectedAttrs();
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
  
  public CMSEnvelopedData(byte[] paramArrayOfByte)
    throws CMSException
  {
    this(CMSUtils.readContentInfo(paramArrayOfByte));
  }
  
  private byte[] encodeObj(ASN1Encodable paramASN1Encodable)
    throws IOException
  {
    if (paramASN1Encodable != null) {
      return paramASN1Encodable.toASN1Primitive().getEncoded();
    }
    return null;
  }
  
  public AlgorithmIdentifier getContentEncryptionAlgorithm()
  {
    return this.encAlg;
  }
  
  public byte[] getEncoded()
    throws IOException
  {
    return this.contentInfo.getEncoded();
  }
  
  public String getEncryptionAlgOID()
  {
    return this.encAlg.getAlgorithm().getId();
  }
  
  public byte[] getEncryptionAlgParams()
  {
    try
    {
      byte[] arrayOfByte = encodeObj(this.encAlg.getParameters());
      return arrayOfByte;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("exception getting encryption parameters ");
      localStringBuilder.append(localException);
      throw new RuntimeException(localStringBuilder.toString());
    }
  }
  
  public OriginatorInformation getOriginatorInfo()
  {
    return this.originatorInfo;
  }
  
  public RecipientInformationStore getRecipientInfos()
  {
    return this.recipientInfoStore;
  }
  
  public AttributeTable getUnprotectedAttributes()
  {
    ASN1Set localASN1Set = this.unprotectedAttributes;
    if (localASN1Set == null) {
      return null;
    }
    return new AttributeTable(localASN1Set);
  }
  
  public ContentInfo toASN1Structure()
  {
    return this.contentInfo;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\CMSEnvelopedData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */