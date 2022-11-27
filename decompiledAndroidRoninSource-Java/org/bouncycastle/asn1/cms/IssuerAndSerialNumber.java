package org.bouncycastle.asn1.cms;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.Certificate;
import org.bouncycastle.asn1.x509.X509CertificateStructure;
import org.bouncycastle.asn1.x509.X509Name;

public class IssuerAndSerialNumber
  extends ASN1Object
{
  private X500Name name;
  private ASN1Integer serialNumber;
  
  public IssuerAndSerialNumber(ASN1Sequence paramASN1Sequence)
  {
    this.name = X500Name.getInstance(paramASN1Sequence.getObjectAt(0));
    this.serialNumber = ((ASN1Integer)paramASN1Sequence.getObjectAt(1));
  }
  
  public IssuerAndSerialNumber(X500Name paramX500Name, BigInteger paramBigInteger)
  {
    this.name = paramX500Name;
    this.serialNumber = new ASN1Integer(paramBigInteger);
  }
  
  public IssuerAndSerialNumber(Certificate paramCertificate)
  {
    this.name = paramCertificate.getIssuer();
    this.serialNumber = paramCertificate.getSerialNumber();
  }
  
  public IssuerAndSerialNumber(X509CertificateStructure paramX509CertificateStructure)
  {
    this.name = paramX509CertificateStructure.getIssuer();
    this.serialNumber = paramX509CertificateStructure.getSerialNumber();
  }
  
  public IssuerAndSerialNumber(X509Name paramX509Name, BigInteger paramBigInteger)
  {
    this.name = X500Name.getInstance(paramX509Name);
    this.serialNumber = new ASN1Integer(paramBigInteger);
  }
  
  public IssuerAndSerialNumber(X509Name paramX509Name, ASN1Integer paramASN1Integer)
  {
    this.name = X500Name.getInstance(paramX509Name);
    this.serialNumber = paramASN1Integer;
  }
  
  public static IssuerAndSerialNumber getInstance(Object paramObject)
  {
    if ((paramObject instanceof IssuerAndSerialNumber)) {
      return (IssuerAndSerialNumber)paramObject;
    }
    if (paramObject != null) {
      return new IssuerAndSerialNumber(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public X500Name getName()
  {
    return this.name;
  }
  
  public ASN1Integer getSerialNumber()
  {
    return this.serialNumber;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.name);
    localASN1EncodableVector.add(this.serialNumber);
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cms\IssuerAndSerialNumber.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */