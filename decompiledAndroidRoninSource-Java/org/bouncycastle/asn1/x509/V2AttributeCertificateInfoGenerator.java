package org.bouncycastle.asn1.x509;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1GeneralizedTime;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERSet;

public class V2AttributeCertificateInfoGenerator
{
  private ASN1EncodableVector attributes = new ASN1EncodableVector();
  private ASN1GeneralizedTime endDate;
  private Extensions extensions;
  private Holder holder;
  private AttCertIssuer issuer;
  private DERBitString issuerUniqueID;
  private ASN1Integer serialNumber;
  private AlgorithmIdentifier signature;
  private ASN1GeneralizedTime startDate;
  private ASN1Integer version = new ASN1Integer(1L);
  
  public void addAttribute(String paramString, ASN1Encodable paramASN1Encodable)
  {
    this.attributes.add(new Attribute(new ASN1ObjectIdentifier(paramString), new DERSet(paramASN1Encodable)));
  }
  
  public void addAttribute(Attribute paramAttribute)
  {
    this.attributes.add(paramAttribute);
  }
  
  public AttributeCertificateInfo generateAttributeCertificateInfo()
  {
    if ((this.serialNumber != null) && (this.signature != null) && (this.issuer != null) && (this.startDate != null) && (this.endDate != null) && (this.holder != null) && (this.attributes != null))
    {
      ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
      localASN1EncodableVector.add(this.version);
      localASN1EncodableVector.add(this.holder);
      localASN1EncodableVector.add(this.issuer);
      localASN1EncodableVector.add(this.signature);
      localASN1EncodableVector.add(this.serialNumber);
      localASN1EncodableVector.add(new AttCertValidityPeriod(this.startDate, this.endDate));
      localASN1EncodableVector.add(new DERSequence(this.attributes));
      Object localObject = this.issuerUniqueID;
      if (localObject != null) {
        localASN1EncodableVector.add((ASN1Encodable)localObject);
      }
      localObject = this.extensions;
      if (localObject != null) {
        localASN1EncodableVector.add((ASN1Encodable)localObject);
      }
      return AttributeCertificateInfo.getInstance(new DERSequence(localASN1EncodableVector));
    }
    throw new IllegalStateException("not all mandatory fields set in V2 AttributeCertificateInfo generator");
  }
  
  public void setEndDate(ASN1GeneralizedTime paramASN1GeneralizedTime)
  {
    this.endDate = paramASN1GeneralizedTime;
  }
  
  public void setExtensions(Extensions paramExtensions)
  {
    this.extensions = paramExtensions;
  }
  
  public void setExtensions(X509Extensions paramX509Extensions)
  {
    this.extensions = Extensions.getInstance(paramX509Extensions.toASN1Primitive());
  }
  
  public void setHolder(Holder paramHolder)
  {
    this.holder = paramHolder;
  }
  
  public void setIssuer(AttCertIssuer paramAttCertIssuer)
  {
    this.issuer = paramAttCertIssuer;
  }
  
  public void setIssuerUniqueID(DERBitString paramDERBitString)
  {
    this.issuerUniqueID = paramDERBitString;
  }
  
  public void setSerialNumber(ASN1Integer paramASN1Integer)
  {
    this.serialNumber = paramASN1Integer;
  }
  
  public void setSignature(AlgorithmIdentifier paramAlgorithmIdentifier)
  {
    this.signature = paramAlgorithmIdentifier;
  }
  
  public void setStartDate(ASN1GeneralizedTime paramASN1GeneralizedTime)
  {
    this.startDate = paramASN1GeneralizedTime;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\asn1\x509\V2AttributeCertificateInfoGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */