package org.bouncycastle.asn1.crmf;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.Extensions;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.asn1.x509.X509Extensions;

public class CertTemplateBuilder
{
  private Extensions extensions;
  private X500Name issuer;
  private DERBitString issuerUID;
  private SubjectPublicKeyInfo publicKey;
  private ASN1Integer serialNumber;
  private AlgorithmIdentifier signingAlg;
  private X500Name subject;
  private DERBitString subjectUID;
  private OptionalValidity validity;
  private ASN1Integer version;
  
  private void addOptional(ASN1EncodableVector paramASN1EncodableVector, int paramInt, boolean paramBoolean, ASN1Encodable paramASN1Encodable)
  {
    if (paramASN1Encodable != null) {
      paramASN1EncodableVector.add(new DERTaggedObject(paramBoolean, paramInt, paramASN1Encodable));
    }
  }
  
  public CertTemplate build()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    addOptional(localASN1EncodableVector, 0, false, this.version);
    addOptional(localASN1EncodableVector, 1, false, this.serialNumber);
    addOptional(localASN1EncodableVector, 2, false, this.signingAlg);
    addOptional(localASN1EncodableVector, 3, true, this.issuer);
    addOptional(localASN1EncodableVector, 4, false, this.validity);
    addOptional(localASN1EncodableVector, 5, true, this.subject);
    addOptional(localASN1EncodableVector, 6, false, this.publicKey);
    addOptional(localASN1EncodableVector, 7, false, this.issuerUID);
    addOptional(localASN1EncodableVector, 8, false, this.subjectUID);
    addOptional(localASN1EncodableVector, 9, false, this.extensions);
    return CertTemplate.getInstance(new DERSequence(localASN1EncodableVector));
  }
  
  public CertTemplateBuilder setExtensions(Extensions paramExtensions)
  {
    this.extensions = paramExtensions;
    return this;
  }
  
  public CertTemplateBuilder setExtensions(X509Extensions paramX509Extensions)
  {
    return setExtensions(Extensions.getInstance(paramX509Extensions));
  }
  
  public CertTemplateBuilder setIssuer(X500Name paramX500Name)
  {
    this.issuer = paramX500Name;
    return this;
  }
  
  public CertTemplateBuilder setIssuerUID(DERBitString paramDERBitString)
  {
    this.issuerUID = paramDERBitString;
    return this;
  }
  
  public CertTemplateBuilder setPublicKey(SubjectPublicKeyInfo paramSubjectPublicKeyInfo)
  {
    this.publicKey = paramSubjectPublicKeyInfo;
    return this;
  }
  
  public CertTemplateBuilder setSerialNumber(ASN1Integer paramASN1Integer)
  {
    this.serialNumber = paramASN1Integer;
    return this;
  }
  
  public CertTemplateBuilder setSigningAlg(AlgorithmIdentifier paramAlgorithmIdentifier)
  {
    this.signingAlg = paramAlgorithmIdentifier;
    return this;
  }
  
  public CertTemplateBuilder setSubject(X500Name paramX500Name)
  {
    this.subject = paramX500Name;
    return this;
  }
  
  public CertTemplateBuilder setSubjectUID(DERBitString paramDERBitString)
  {
    this.subjectUID = paramDERBitString;
    return this;
  }
  
  public CertTemplateBuilder setValidity(OptionalValidity paramOptionalValidity)
  {
    this.validity = paramOptionalValidity;
    return this;
  }
  
  public CertTemplateBuilder setVersion(int paramInt)
  {
    this.version = new ASN1Integer(paramInt);
    return this;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\crmf\CertTemplateBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */