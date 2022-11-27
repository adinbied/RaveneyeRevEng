package org.bouncycastle.asn1.x509;

import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.x500.X500Name;

public class Certificate
  extends ASN1Object
{
  ASN1Sequence seq;
  DERBitString sig;
  AlgorithmIdentifier sigAlgId;
  TBSCertificate tbsCert;
  
  private Certificate(ASN1Sequence paramASN1Sequence)
  {
    this.seq = paramASN1Sequence;
    if (paramASN1Sequence.size() == 3)
    {
      this.tbsCert = TBSCertificate.getInstance(paramASN1Sequence.getObjectAt(0));
      this.sigAlgId = AlgorithmIdentifier.getInstance(paramASN1Sequence.getObjectAt(1));
      this.sig = DERBitString.getInstance(paramASN1Sequence.getObjectAt(2));
      return;
    }
    throw new IllegalArgumentException("sequence wrong size for a certificate");
  }
  
  public static Certificate getInstance(Object paramObject)
  {
    if ((paramObject instanceof Certificate)) {
      return (Certificate)paramObject;
    }
    if (paramObject != null) {
      return new Certificate(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public static Certificate getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    return getInstance(ASN1Sequence.getInstance(paramASN1TaggedObject, paramBoolean));
  }
  
  public Time getEndDate()
  {
    return this.tbsCert.getEndDate();
  }
  
  public X500Name getIssuer()
  {
    return this.tbsCert.getIssuer();
  }
  
  public ASN1Integer getSerialNumber()
  {
    return this.tbsCert.getSerialNumber();
  }
  
  public DERBitString getSignature()
  {
    return this.sig;
  }
  
  public AlgorithmIdentifier getSignatureAlgorithm()
  {
    return this.sigAlgId;
  }
  
  public Time getStartDate()
  {
    return this.tbsCert.getStartDate();
  }
  
  public X500Name getSubject()
  {
    return this.tbsCert.getSubject();
  }
  
  public SubjectPublicKeyInfo getSubjectPublicKeyInfo()
  {
    return this.tbsCert.getSubjectPublicKeyInfo();
  }
  
  public TBSCertificate getTBSCertificate()
  {
    return this.tbsCert;
  }
  
  public ASN1Integer getVersion()
  {
    return this.tbsCert.getVersion();
  }
  
  public int getVersionNumber()
  {
    return this.tbsCert.getVersionNumber();
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    return this.seq;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\asn1\x509\Certificate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */