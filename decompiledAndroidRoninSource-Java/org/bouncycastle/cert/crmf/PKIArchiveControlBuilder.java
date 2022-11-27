package org.bouncycastle.cert.crmf;

import java.io.IOException;
import org.bouncycastle.asn1.cms.ContentInfo;
import org.bouncycastle.asn1.cms.EnvelopedData;
import org.bouncycastle.asn1.crmf.CRMFObjectIdentifiers;
import org.bouncycastle.asn1.crmf.EncKeyWithID;
import org.bouncycastle.asn1.crmf.EncryptedKey;
import org.bouncycastle.asn1.crmf.PKIArchiveOptions;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.cms.CMSEnvelopedData;
import org.bouncycastle.cms.CMSEnvelopedDataGenerator;
import org.bouncycastle.cms.CMSException;
import org.bouncycastle.cms.CMSProcessableByteArray;
import org.bouncycastle.cms.RecipientInfoGenerator;
import org.bouncycastle.operator.OutputEncryptor;

public class PKIArchiveControlBuilder
{
  private CMSEnvelopedDataGenerator envGen;
  private CMSProcessableByteArray keyContent;
  
  public PKIArchiveControlBuilder(PrivateKeyInfo paramPrivateKeyInfo, GeneralName paramGeneralName)
  {
    paramPrivateKeyInfo = new EncKeyWithID(paramPrivateKeyInfo, paramGeneralName);
    try
    {
      this.keyContent = new CMSProcessableByteArray(CRMFObjectIdentifiers.id_ct_encKeyWithID, paramPrivateKeyInfo.getEncoded());
      this.envGen = new CMSEnvelopedDataGenerator();
      return;
    }
    catch (IOException paramPrivateKeyInfo)
    {
      for (;;) {}
    }
    throw new IllegalStateException("unable to encode key and general name info");
  }
  
  public PKIArchiveControlBuilder addRecipientGenerator(RecipientInfoGenerator paramRecipientInfoGenerator)
  {
    this.envGen.addRecipientInfoGenerator(paramRecipientInfoGenerator);
    return this;
  }
  
  public PKIArchiveControl build(OutputEncryptor paramOutputEncryptor)
    throws CMSException
  {
    return new PKIArchiveControl(new PKIArchiveOptions(new EncryptedKey(EnvelopedData.getInstance(this.envGen.generate(this.keyContent, paramOutputEncryptor).toASN1Structure().getContent()))));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cert\crmf\PKIArchiveControlBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */