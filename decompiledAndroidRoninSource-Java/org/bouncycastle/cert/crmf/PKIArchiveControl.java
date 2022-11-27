package org.bouncycastle.cert.crmf;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.cms.CMSObjectIdentifiers;
import org.bouncycastle.asn1.cms.ContentInfo;
import org.bouncycastle.asn1.cms.EnvelopedData;
import org.bouncycastle.asn1.crmf.CRMFObjectIdentifiers;
import org.bouncycastle.asn1.crmf.EncryptedKey;
import org.bouncycastle.asn1.crmf.PKIArchiveOptions;
import org.bouncycastle.cms.CMSEnvelopedData;
import org.bouncycastle.cms.CMSException;

public class PKIArchiveControl
  implements Control
{
  public static final int archiveRemGenPrivKey = 2;
  public static final int encryptedPrivKey = 0;
  public static final int keyGenParameters = 1;
  private static final ASN1ObjectIdentifier type = CRMFObjectIdentifiers.id_regCtrl_pkiArchiveOptions;
  private final PKIArchiveOptions pkiArchiveOptions;
  
  public PKIArchiveControl(PKIArchiveOptions paramPKIArchiveOptions)
  {
    this.pkiArchiveOptions = paramPKIArchiveOptions;
  }
  
  public int getArchiveType()
  {
    return this.pkiArchiveOptions.getType();
  }
  
  public CMSEnvelopedData getEnvelopedData()
    throws CRMFException
  {
    try
    {
      Object localObject = EnvelopedData.getInstance(EncryptedKey.getInstance(this.pkiArchiveOptions.getValue()).getValue());
      localObject = new CMSEnvelopedData(new ContentInfo(CMSObjectIdentifiers.envelopedData, (ASN1Encodable)localObject));
      return (CMSEnvelopedData)localObject;
    }
    catch (Exception localException)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("CRMF parsing error: ");
      localStringBuilder.append(localException.getMessage());
      throw new CRMFException(localStringBuilder.toString(), localException);
    }
    catch (CMSException localCMSException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("CMS parsing error: ");
      localStringBuilder.append(localCMSException.getMessage());
      throw new CRMFException(localStringBuilder.toString(), localCMSException.getCause());
    }
  }
  
  public ASN1ObjectIdentifier getType()
  {
    return type;
  }
  
  public ASN1Encodable getValue()
  {
    return this.pkiArchiveOptions;
  }
  
  public boolean isEnvelopedData()
  {
    return EncryptedKey.getInstance(this.pkiArchiveOptions.getValue()).isEncryptedValue() ^ true;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cert\crmf\PKIArchiveControl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */