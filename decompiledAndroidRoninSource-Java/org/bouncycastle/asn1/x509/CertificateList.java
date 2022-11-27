package org.bouncycastle.asn1.x509;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x500.X500Name;

public class CertificateList
  extends ASN1Object
{
  int hashCodeValue;
  boolean isHashCodeSet = false;
  DERBitString sig;
  AlgorithmIdentifier sigAlgId;
  TBSCertList tbsCertList;
  
  public CertificateList(ASN1Sequence paramASN1Sequence)
  {
    if (paramASN1Sequence.size() == 3)
    {
      this.tbsCertList = TBSCertList.getInstance(paramASN1Sequence.getObjectAt(0));
      this.sigAlgId = AlgorithmIdentifier.getInstance(paramASN1Sequence.getObjectAt(1));
      this.sig = DERBitString.getInstance(paramASN1Sequence.getObjectAt(2));
      return;
    }
    throw new IllegalArgumentException("sequence wrong size for CertificateList");
  }
  
  public static CertificateList getInstance(Object paramObject)
  {
    if ((paramObject instanceof CertificateList)) {
      return (CertificateList)paramObject;
    }
    if (paramObject != null) {
      return new CertificateList(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public static CertificateList getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    return getInstance(ASN1Sequence.getInstance(paramASN1TaggedObject, paramBoolean));
  }
  
  public X500Name getIssuer()
  {
    return this.tbsCertList.getIssuer();
  }
  
  public Time getNextUpdate()
  {
    return this.tbsCertList.getNextUpdate();
  }
  
  public Enumeration getRevokedCertificateEnumeration()
  {
    return this.tbsCertList.getRevokedCertificateEnumeration();
  }
  
  public TBSCertList.CRLEntry[] getRevokedCertificates()
  {
    return this.tbsCertList.getRevokedCertificates();
  }
  
  public DERBitString getSignature()
  {
    return this.sig;
  }
  
  public AlgorithmIdentifier getSignatureAlgorithm()
  {
    return this.sigAlgId;
  }
  
  public TBSCertList getTBSCertList()
  {
    return this.tbsCertList;
  }
  
  public Time getThisUpdate()
  {
    return this.tbsCertList.getThisUpdate();
  }
  
  public int getVersionNumber()
  {
    return this.tbsCertList.getVersionNumber();
  }
  
  public int hashCode()
  {
    if (!this.isHashCodeSet)
    {
      this.hashCodeValue = super.hashCode();
      this.isHashCodeSet = true;
    }
    return this.hashCodeValue;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.tbsCertList);
    localASN1EncodableVector.add(this.sigAlgId);
    localASN1EncodableVector.add(this.sig);
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\asn1\x509\CertificateList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */