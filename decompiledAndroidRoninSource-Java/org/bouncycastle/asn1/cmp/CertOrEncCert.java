package org.bouncycastle.asn1.cmp;

import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.crmf.EncryptedValue;

public class CertOrEncCert
  extends ASN1Object
  implements ASN1Choice
{
  private CMPCertificate certificate;
  private EncryptedValue encryptedCert;
  
  private CertOrEncCert(ASN1TaggedObject paramASN1TaggedObject)
  {
    if (paramASN1TaggedObject.getTagNo() == 0)
    {
      this.certificate = CMPCertificate.getInstance(paramASN1TaggedObject.getObject());
      return;
    }
    if (paramASN1TaggedObject.getTagNo() == 1)
    {
      this.encryptedCert = EncryptedValue.getInstance(paramASN1TaggedObject.getObject());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("unknown tag: ");
    localStringBuilder.append(paramASN1TaggedObject.getTagNo());
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public CertOrEncCert(CMPCertificate paramCMPCertificate)
  {
    if (paramCMPCertificate != null)
    {
      this.certificate = paramCMPCertificate;
      return;
    }
    throw new IllegalArgumentException("'certificate' cannot be null");
  }
  
  public CertOrEncCert(EncryptedValue paramEncryptedValue)
  {
    if (paramEncryptedValue != null)
    {
      this.encryptedCert = paramEncryptedValue;
      return;
    }
    throw new IllegalArgumentException("'encryptedCert' cannot be null");
  }
  
  public static CertOrEncCert getInstance(Object paramObject)
  {
    if ((paramObject instanceof CertOrEncCert)) {
      return (CertOrEncCert)paramObject;
    }
    if ((paramObject instanceof ASN1TaggedObject)) {
      return new CertOrEncCert((ASN1TaggedObject)paramObject);
    }
    return null;
  }
  
  public CMPCertificate getCertificate()
  {
    return this.certificate;
  }
  
  public EncryptedValue getEncryptedCert()
  {
    return this.encryptedCert;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    CMPCertificate localCMPCertificate = this.certificate;
    if (localCMPCertificate != null) {
      return new DERTaggedObject(true, 0, localCMPCertificate);
    }
    return new DERTaggedObject(true, 1, this.encryptedCert);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cmp\CertOrEncCert.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */