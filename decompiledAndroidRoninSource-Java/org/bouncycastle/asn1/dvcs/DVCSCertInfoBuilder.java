package org.bouncycastle.asn1.dvcs;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.cmp.PKIStatusInfo;
import org.bouncycastle.asn1.x509.DigestInfo;
import org.bouncycastle.asn1.x509.Extensions;
import org.bouncycastle.asn1.x509.PolicyInformation;

public class DVCSCertInfoBuilder
{
  private static final int DEFAULT_VERSION = 1;
  private static final int TAG_CERTS = 3;
  private static final int TAG_DV_STATUS = 0;
  private static final int TAG_POLICY = 1;
  private static final int TAG_REQ_SIGNATURE = 2;
  private ASN1Sequence certs;
  private DVCSRequestInformation dvReqInfo;
  private PKIStatusInfo dvStatus;
  private Extensions extensions;
  private DigestInfo messageImprint;
  private PolicyInformation policy;
  private ASN1Set reqSignature;
  private DVCSTime responseTime;
  private ASN1Integer serialNumber;
  private int version = 1;
  
  public DVCSCertInfoBuilder(DVCSRequestInformation paramDVCSRequestInformation, DigestInfo paramDigestInfo, ASN1Integer paramASN1Integer, DVCSTime paramDVCSTime)
  {
    this.dvReqInfo = paramDVCSRequestInformation;
    this.messageImprint = paramDigestInfo;
    this.serialNumber = paramASN1Integer;
    this.responseTime = paramDVCSTime;
  }
  
  public DVCSCertInfo build()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    int i = this.version;
    if (i != 1) {
      localASN1EncodableVector.add(new ASN1Integer(i));
    }
    localASN1EncodableVector.add(this.dvReqInfo);
    localASN1EncodableVector.add(this.messageImprint);
    localASN1EncodableVector.add(this.serialNumber);
    localASN1EncodableVector.add(this.responseTime);
    Object localObject = this.dvStatus;
    if (localObject != null) {
      localASN1EncodableVector.add(new DERTaggedObject(false, 0, (ASN1Encodable)localObject));
    }
    localObject = this.policy;
    if (localObject != null) {
      localASN1EncodableVector.add(new DERTaggedObject(false, 1, (ASN1Encodable)localObject));
    }
    localObject = this.reqSignature;
    if (localObject != null) {
      localASN1EncodableVector.add(new DERTaggedObject(false, 2, (ASN1Encodable)localObject));
    }
    localObject = this.certs;
    if (localObject != null) {
      localASN1EncodableVector.add(new DERTaggedObject(false, 3, (ASN1Encodable)localObject));
    }
    localObject = this.extensions;
    if (localObject != null) {
      localASN1EncodableVector.add((ASN1Encodable)localObject);
    }
    return DVCSCertInfo.getInstance(new DERSequence(localASN1EncodableVector));
  }
  
  public void setCerts(TargetEtcChain[] paramArrayOfTargetEtcChain)
  {
    this.certs = new DERSequence(paramArrayOfTargetEtcChain);
  }
  
  public void setDvReqInfo(DVCSRequestInformation paramDVCSRequestInformation)
  {
    this.dvReqInfo = paramDVCSRequestInformation;
  }
  
  public void setDvStatus(PKIStatusInfo paramPKIStatusInfo)
  {
    this.dvStatus = paramPKIStatusInfo;
  }
  
  public void setExtensions(Extensions paramExtensions)
  {
    this.extensions = paramExtensions;
  }
  
  public void setMessageImprint(DigestInfo paramDigestInfo)
  {
    this.messageImprint = paramDigestInfo;
  }
  
  public void setPolicy(PolicyInformation paramPolicyInformation)
  {
    this.policy = paramPolicyInformation;
  }
  
  public void setReqSignature(ASN1Set paramASN1Set)
  {
    this.reqSignature = paramASN1Set;
  }
  
  public void setResponseTime(DVCSTime paramDVCSTime)
  {
    this.responseTime = paramDVCSTime;
  }
  
  public void setSerialNumber(ASN1Integer paramASN1Integer)
  {
    this.serialNumber = paramASN1Integer;
  }
  
  public void setVersion(int paramInt)
  {
    this.version = paramInt;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\dvcs\DVCSCertInfoBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */