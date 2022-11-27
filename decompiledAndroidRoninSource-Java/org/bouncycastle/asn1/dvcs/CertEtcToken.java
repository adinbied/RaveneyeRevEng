package org.bouncycastle.asn1.dvcs;

import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.cmp.PKIStatusInfo;
import org.bouncycastle.asn1.cms.ContentInfo;
import org.bouncycastle.asn1.ess.ESSCertID;
import org.bouncycastle.asn1.ocsp.CertID;
import org.bouncycastle.asn1.ocsp.CertStatus;
import org.bouncycastle.asn1.ocsp.OCSPResponse;
import org.bouncycastle.asn1.smime.SMIMECapabilities;
import org.bouncycastle.asn1.x509.Certificate;
import org.bouncycastle.asn1.x509.CertificateList;
import org.bouncycastle.asn1.x509.Extension;

public class CertEtcToken
  extends ASN1Object
  implements ASN1Choice
{
  public static final int TAG_ASSERTION = 3;
  public static final int TAG_CAPABILITIES = 8;
  public static final int TAG_CERTIFICATE = 0;
  public static final int TAG_CRL = 4;
  public static final int TAG_ESSCERTID = 1;
  public static final int TAG_OCSPCERTID = 6;
  public static final int TAG_OCSPCERTSTATUS = 5;
  public static final int TAG_OCSPRESPONSE = 7;
  public static final int TAG_PKISTATUS = 2;
  private static final boolean[] explicit = { 0, 1, 0, 1, 0, 1, 0, 0, 1 };
  private Extension extension;
  private int tagNo;
  private ASN1Encodable value;
  
  public CertEtcToken(int paramInt, ASN1Encodable paramASN1Encodable)
  {
    this.tagNo = paramInt;
    this.value = paramASN1Encodable;
  }
  
  private CertEtcToken(ASN1TaggedObject paramASN1TaggedObject)
  {
    int i = paramASN1TaggedObject.getTagNo();
    this.tagNo = i;
    switch (i)
    {
    default: 
      paramASN1TaggedObject = new StringBuilder();
      paramASN1TaggedObject.append("Unknown tag: ");
      paramASN1TaggedObject.append(this.tagNo);
      throw new IllegalArgumentException(paramASN1TaggedObject.toString());
    case 8: 
      paramASN1TaggedObject = SMIMECapabilities.getInstance(paramASN1TaggedObject.getObject());
      break;
    case 7: 
      paramASN1TaggedObject = OCSPResponse.getInstance(paramASN1TaggedObject, false);
      break;
    case 6: 
      paramASN1TaggedObject = CertID.getInstance(paramASN1TaggedObject, false);
      break;
    case 5: 
      paramASN1TaggedObject = CertStatus.getInstance(paramASN1TaggedObject.getObject());
      break;
    case 4: 
      paramASN1TaggedObject = CertificateList.getInstance(paramASN1TaggedObject, false);
      break;
    case 3: 
      paramASN1TaggedObject = ContentInfo.getInstance(paramASN1TaggedObject.getObject());
      break;
    case 2: 
      paramASN1TaggedObject = PKIStatusInfo.getInstance(paramASN1TaggedObject, false);
      break;
    case 1: 
      paramASN1TaggedObject = ESSCertID.getInstance(paramASN1TaggedObject.getObject());
      break;
    case 0: 
      paramASN1TaggedObject = Certificate.getInstance(paramASN1TaggedObject, false);
    }
    this.value = paramASN1TaggedObject;
  }
  
  public CertEtcToken(Extension paramExtension)
  {
    this.tagNo = -1;
    this.extension = paramExtension;
  }
  
  public static CertEtcToken[] arrayFromSequence(ASN1Sequence paramASN1Sequence)
  {
    int j = paramASN1Sequence.size();
    CertEtcToken[] arrayOfCertEtcToken = new CertEtcToken[j];
    int i = 0;
    while (i != j)
    {
      arrayOfCertEtcToken[i] = getInstance(paramASN1Sequence.getObjectAt(i));
      i += 1;
    }
    return arrayOfCertEtcToken;
  }
  
  public static CertEtcToken getInstance(Object paramObject)
  {
    if ((paramObject instanceof CertEtcToken)) {
      return (CertEtcToken)paramObject;
    }
    if ((paramObject instanceof ASN1TaggedObject)) {
      return new CertEtcToken((ASN1TaggedObject)paramObject);
    }
    if (paramObject != null) {
      return new CertEtcToken(Extension.getInstance(paramObject));
    }
    return null;
  }
  
  public Extension getExtension()
  {
    return this.extension;
  }
  
  public int getTagNo()
  {
    return this.tagNo;
  }
  
  public ASN1Encodable getValue()
  {
    return this.value;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    Object localObject = this.extension;
    if (localObject == null)
    {
      localObject = explicit;
      int i = this.tagNo;
      return new DERTaggedObject(localObject[i], i, this.value);
    }
    return ((Extension)localObject).toASN1Primitive();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CertEtcToken {\n");
    localStringBuilder.append(this.value);
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\dvcs\CertEtcToken.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */