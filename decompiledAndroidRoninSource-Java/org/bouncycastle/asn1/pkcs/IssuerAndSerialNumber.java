package org.bouncycastle.asn1.pkcs;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.X509Name;

public class IssuerAndSerialNumber
  extends ASN1Object
{
  ASN1Integer certSerialNumber;
  X500Name name;
  
  private IssuerAndSerialNumber(ASN1Sequence paramASN1Sequence)
  {
    this.name = X500Name.getInstance(paramASN1Sequence.getObjectAt(0));
    this.certSerialNumber = ((ASN1Integer)paramASN1Sequence.getObjectAt(1));
  }
  
  public IssuerAndSerialNumber(X500Name paramX500Name, BigInteger paramBigInteger)
  {
    this.name = paramX500Name;
    this.certSerialNumber = new ASN1Integer(paramBigInteger);
  }
  
  public IssuerAndSerialNumber(X509Name paramX509Name, BigInteger paramBigInteger)
  {
    this.name = X500Name.getInstance(paramX509Name.toASN1Primitive());
    this.certSerialNumber = new ASN1Integer(paramBigInteger);
  }
  
  public IssuerAndSerialNumber(X509Name paramX509Name, ASN1Integer paramASN1Integer)
  {
    this.name = X500Name.getInstance(paramX509Name.toASN1Primitive());
    this.certSerialNumber = paramASN1Integer;
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
  
  public ASN1Integer getCertificateSerialNumber()
  {
    return this.certSerialNumber;
  }
  
  public X500Name getName()
  {
    return this.name;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.name);
    localASN1EncodableVector.add(this.certSerialNumber);
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\pkcs\IssuerAndSerialNumber.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */