package org.bouncycastle.asn1.x509;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x500.X500Name;

public class TBSCertificateStructure
  extends ASN1Object
  implements X509ObjectIdentifiers, PKCSObjectIdentifiers
{
  Time endDate;
  X509Extensions extensions;
  X500Name issuer;
  DERBitString issuerUniqueId;
  ASN1Sequence seq;
  ASN1Integer serialNumber;
  AlgorithmIdentifier signature;
  Time startDate;
  X500Name subject;
  SubjectPublicKeyInfo subjectPublicKeyInfo;
  DERBitString subjectUniqueId;
  ASN1Integer version;
  
  public TBSCertificateStructure(ASN1Sequence paramASN1Sequence)
  {
    this.seq = paramASN1Sequence;
    if ((paramASN1Sequence.getObjectAt(0) instanceof DERTaggedObject))
    {
      this.version = ASN1Integer.getInstance((ASN1TaggedObject)paramASN1Sequence.getObjectAt(0), true);
      i = 0;
    }
    else
    {
      this.version = new ASN1Integer(0L);
      i = -1;
    }
    this.serialNumber = ASN1Integer.getInstance(paramASN1Sequence.getObjectAt(i + 1));
    this.signature = AlgorithmIdentifier.getInstance(paramASN1Sequence.getObjectAt(i + 2));
    this.issuer = X500Name.getInstance(paramASN1Sequence.getObjectAt(i + 3));
    Object localObject = (ASN1Sequence)paramASN1Sequence.getObjectAt(i + 4);
    this.startDate = Time.getInstance(((ASN1Sequence)localObject).getObjectAt(0));
    this.endDate = Time.getInstance(((ASN1Sequence)localObject).getObjectAt(1));
    this.subject = X500Name.getInstance(paramASN1Sequence.getObjectAt(i + 5));
    int j = i + 6;
    this.subjectPublicKeyInfo = SubjectPublicKeyInfo.getInstance(paramASN1Sequence.getObjectAt(j));
    int i = paramASN1Sequence.size() - j - 1;
    while (i > 0)
    {
      localObject = (DERTaggedObject)paramASN1Sequence.getObjectAt(j + i);
      int k = ((DERTaggedObject)localObject).getTagNo();
      if (k != 1)
      {
        if (k != 2)
        {
          if (k == 3) {
            this.extensions = X509Extensions.getInstance(localObject);
          }
        }
        else {
          this.subjectUniqueId = DERBitString.getInstance((ASN1TaggedObject)localObject, false);
        }
      }
      else {
        this.issuerUniqueId = DERBitString.getInstance((ASN1TaggedObject)localObject, false);
      }
      i -= 1;
    }
  }
  
  public static TBSCertificateStructure getInstance(Object paramObject)
  {
    if ((paramObject instanceof TBSCertificateStructure)) {
      return (TBSCertificateStructure)paramObject;
    }
    if (paramObject != null) {
      return new TBSCertificateStructure(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public static TBSCertificateStructure getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    return getInstance(ASN1Sequence.getInstance(paramASN1TaggedObject, paramBoolean));
  }
  
  public Time getEndDate()
  {
    return this.endDate;
  }
  
  public X509Extensions getExtensions()
  {
    return this.extensions;
  }
  
  public X500Name getIssuer()
  {
    return this.issuer;
  }
  
  public DERBitString getIssuerUniqueId()
  {
    return this.issuerUniqueId;
  }
  
  public ASN1Integer getSerialNumber()
  {
    return this.serialNumber;
  }
  
  public AlgorithmIdentifier getSignature()
  {
    return this.signature;
  }
  
  public Time getStartDate()
  {
    return this.startDate;
  }
  
  public X500Name getSubject()
  {
    return this.subject;
  }
  
  public SubjectPublicKeyInfo getSubjectPublicKeyInfo()
  {
    return this.subjectPublicKeyInfo;
  }
  
  public DERBitString getSubjectUniqueId()
  {
    return this.subjectUniqueId;
  }
  
  public int getVersion()
  {
    return this.version.getValue().intValue() + 1;
  }
  
  public ASN1Integer getVersionNumber()
  {
    return this.version;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    return this.seq;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\asn1\x509\TBSCertificateStructure.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */