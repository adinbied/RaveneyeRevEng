package org.bouncycastle.asn1.ocsp;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class CertID
  extends ASN1Object
{
  AlgorithmIdentifier hashAlgorithm;
  ASN1OctetString issuerKeyHash;
  ASN1OctetString issuerNameHash;
  ASN1Integer serialNumber;
  
  private CertID(ASN1Sequence paramASN1Sequence)
  {
    this.hashAlgorithm = AlgorithmIdentifier.getInstance(paramASN1Sequence.getObjectAt(0));
    this.issuerNameHash = ((ASN1OctetString)paramASN1Sequence.getObjectAt(1));
    this.issuerKeyHash = ((ASN1OctetString)paramASN1Sequence.getObjectAt(2));
    this.serialNumber = ((ASN1Integer)paramASN1Sequence.getObjectAt(3));
  }
  
  public CertID(AlgorithmIdentifier paramAlgorithmIdentifier, ASN1OctetString paramASN1OctetString1, ASN1OctetString paramASN1OctetString2, ASN1Integer paramASN1Integer)
  {
    this.hashAlgorithm = paramAlgorithmIdentifier;
    this.issuerNameHash = paramASN1OctetString1;
    this.issuerKeyHash = paramASN1OctetString2;
    this.serialNumber = paramASN1Integer;
  }
  
  public static CertID getInstance(Object paramObject)
  {
    if ((paramObject instanceof CertID)) {
      return (CertID)paramObject;
    }
    if (paramObject != null) {
      return new CertID(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public static CertID getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    return getInstance(ASN1Sequence.getInstance(paramASN1TaggedObject, paramBoolean));
  }
  
  public AlgorithmIdentifier getHashAlgorithm()
  {
    return this.hashAlgorithm;
  }
  
  public ASN1OctetString getIssuerKeyHash()
  {
    return this.issuerKeyHash;
  }
  
  public ASN1OctetString getIssuerNameHash()
  {
    return this.issuerNameHash;
  }
  
  public ASN1Integer getSerialNumber()
  {
    return this.serialNumber;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.hashAlgorithm);
    localASN1EncodableVector.add(this.issuerNameHash);
    localASN1EncodableVector.add(this.issuerKeyHash);
    localASN1EncodableVector.add(this.serialNumber);
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\ocsp\CertID.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */