package org.bouncycastle.asn1.cmp;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.crmf.EncryptedValue;
import org.bouncycastle.asn1.crmf.PKIPublicationInfo;

public class CertifiedKeyPair
  extends ASN1Object
{
  private CertOrEncCert certOrEncCert;
  private EncryptedValue privateKey;
  private PKIPublicationInfo publicationInfo;
  
  private CertifiedKeyPair(ASN1Sequence paramASN1Sequence)
  {
    this.certOrEncCert = CertOrEncCert.getInstance(paramASN1Sequence.getObjectAt(0));
    if (paramASN1Sequence.size() >= 2)
    {
      if (paramASN1Sequence.size() == 2)
      {
        paramASN1Sequence = ASN1TaggedObject.getInstance(paramASN1Sequence.getObjectAt(1));
        int i = paramASN1Sequence.getTagNo();
        ASN1Primitive localASN1Primitive = paramASN1Sequence.getObject();
        paramASN1Sequence = localASN1Primitive;
        if (i == 0) {
          this.privateKey = EncryptedValue.getInstance(localASN1Primitive);
        }
      }
      else
      {
        this.privateKey = EncryptedValue.getInstance(ASN1TaggedObject.getInstance(paramASN1Sequence.getObjectAt(1)));
        paramASN1Sequence = ASN1TaggedObject.getInstance(paramASN1Sequence.getObjectAt(2));
      }
      this.publicationInfo = PKIPublicationInfo.getInstance(paramASN1Sequence);
    }
  }
  
  public CertifiedKeyPair(CertOrEncCert paramCertOrEncCert)
  {
    this(paramCertOrEncCert, null, null);
  }
  
  public CertifiedKeyPair(CertOrEncCert paramCertOrEncCert, EncryptedValue paramEncryptedValue, PKIPublicationInfo paramPKIPublicationInfo)
  {
    if (paramCertOrEncCert != null)
    {
      this.certOrEncCert = paramCertOrEncCert;
      this.privateKey = paramEncryptedValue;
      this.publicationInfo = paramPKIPublicationInfo;
      return;
    }
    throw new IllegalArgumentException("'certOrEncCert' cannot be null");
  }
  
  public static CertifiedKeyPair getInstance(Object paramObject)
  {
    if ((paramObject instanceof CertifiedKeyPair)) {
      return (CertifiedKeyPair)paramObject;
    }
    if (paramObject != null) {
      return new CertifiedKeyPair(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public CertOrEncCert getCertOrEncCert()
  {
    return this.certOrEncCert;
  }
  
  public EncryptedValue getPrivateKey()
  {
    return this.privateKey;
  }
  
  public PKIPublicationInfo getPublicationInfo()
  {
    return this.publicationInfo;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.certOrEncCert);
    Object localObject = this.privateKey;
    if (localObject != null) {
      localASN1EncodableVector.add(new DERTaggedObject(true, 0, (ASN1Encodable)localObject));
    }
    localObject = this.publicationInfo;
    if (localObject != null) {
      localASN1EncodableVector.add(new DERTaggedObject(true, 1, (ASN1Encodable)localObject));
    }
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cmp\CertifiedKeyPair.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */