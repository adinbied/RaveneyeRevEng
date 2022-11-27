package org.bouncycastle.cms;

import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.cms.AuthEnvelopedData;
import org.bouncycastle.asn1.cms.ContentInfo;
import org.bouncycastle.asn1.cms.EncryptedContentInfo;
import org.bouncycastle.asn1.cms.OriginatorInfo;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

class CMSAuthEnvelopedData
{
  private ASN1Set authAttrs;
  private AlgorithmIdentifier authEncAlg;
  ContentInfo contentInfo;
  private byte[] mac;
  private OriginatorInfo originator;
  RecipientInformationStore recipientInfoStore;
  private ASN1Set unauthAttrs;
  
  public CMSAuthEnvelopedData(InputStream paramInputStream)
    throws CMSException
  {
    this(CMSUtils.readContentInfo(paramInputStream));
  }
  
  public CMSAuthEnvelopedData(ContentInfo paramContentInfo)
    throws CMSException
  {
    this.contentInfo = paramContentInfo;
    paramContentInfo = AuthEnvelopedData.getInstance(paramContentInfo.getContent());
    this.originator = paramContentInfo.getOriginatorInfo();
    ASN1Set localASN1Set = paramContentInfo.getRecipientInfos();
    this.authEncAlg = paramContentInfo.getAuthEncryptedContentInfo().getContentEncryptionAlgorithm();
    CMSSecureReadable local1 = new CMSSecureReadable()
    {
      public InputStream getInputStream()
        throws IOException, CMSException
      {
        return null;
      }
    };
    this.recipientInfoStore = CMSEnvelopedHelper.buildRecipientInformationStore(localASN1Set, this.authEncAlg, local1);
    this.authAttrs = paramContentInfo.getAuthAttrs();
    this.mac = paramContentInfo.getMac().getOctets();
    this.unauthAttrs = paramContentInfo.getUnauthAttrs();
  }
  
  public CMSAuthEnvelopedData(byte[] paramArrayOfByte)
    throws CMSException
  {
    this(CMSUtils.readContentInfo(paramArrayOfByte));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\CMSAuthEnvelopedData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */