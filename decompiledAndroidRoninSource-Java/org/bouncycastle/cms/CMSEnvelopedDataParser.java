package org.bouncycastle.cms;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetStringParser;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1SequenceParser;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.ASN1SetParser;
import org.bouncycastle.asn1.DERSet;
import org.bouncycastle.asn1.cms.AttributeTable;
import org.bouncycastle.asn1.cms.ContentInfoParser;
import org.bouncycastle.asn1.cms.EncryptedContentInfoParser;
import org.bouncycastle.asn1.cms.EnvelopedDataParser;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class CMSEnvelopedDataParser
  extends CMSContentInfoParser
{
  private boolean attrNotRead = true;
  private AlgorithmIdentifier encAlg;
  EnvelopedDataParser envelopedData;
  private OriginatorInformation originatorInfo;
  RecipientInformationStore recipientInfoStore;
  private AttributeTable unprotectedAttributes;
  
  public CMSEnvelopedDataParser(InputStream paramInputStream)
    throws CMSException, IOException
  {
    super(paramInputStream);
    paramInputStream = new EnvelopedDataParser((ASN1SequenceParser)this._contentInfo.getContent(16));
    this.envelopedData = paramInputStream;
    paramInputStream = paramInputStream.getOriginatorInfo();
    if (paramInputStream != null) {
      this.originatorInfo = new OriginatorInformation(paramInputStream);
    }
    paramInputStream = ASN1Set.getInstance(this.envelopedData.getRecipientInfos().toASN1Primitive());
    Object localObject = this.envelopedData.getEncryptedContentInfo();
    this.encAlg = ((EncryptedContentInfoParser)localObject).getContentEncryptionAlgorithm();
    localObject = new CMSProcessableInputStream(((ASN1OctetStringParser)((EncryptedContentInfoParser)localObject).getEncryptedContent(4)).getOctetStream());
    localObject = new CMSEnvelopedHelper.CMSEnvelopedSecureReadable(this.encAlg, (CMSReadable)localObject);
    this.recipientInfoStore = CMSEnvelopedHelper.buildRecipientInformationStore(paramInputStream, this.encAlg, (CMSSecureReadable)localObject);
  }
  
  public CMSEnvelopedDataParser(byte[] paramArrayOfByte)
    throws CMSException, IOException
  {
    this(new ByteArrayInputStream(paramArrayOfByte));
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
  
  public String getEncryptionAlgOID()
  {
    return this.encAlg.getAlgorithm().toString();
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
    throws IOException
  {
    if ((this.unprotectedAttributes == null) && (this.attrNotRead))
    {
      ASN1SetParser localASN1SetParser = this.envelopedData.getUnprotectedAttrs();
      this.attrNotRead = false;
      if (localASN1SetParser != null)
      {
        ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
        for (;;)
        {
          ASN1Encodable localASN1Encodable = localASN1SetParser.readObject();
          if (localASN1Encodable == null) {
            break;
          }
          localASN1EncodableVector.add(((ASN1SequenceParser)localASN1Encodable).toASN1Primitive());
        }
        this.unprotectedAttributes = new AttributeTable(new DERSet(localASN1EncodableVector));
      }
    }
    return this.unprotectedAttributes;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\CMSEnvelopedDataParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */