package org.bouncycastle.asn1.crmf;

import java.math.BigInteger;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.Extensions;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;

public class CertTemplate
  extends ASN1Object
{
  private Extensions extensions;
  private X500Name issuer;
  private DERBitString issuerUID;
  private SubjectPublicKeyInfo publicKey;
  private ASN1Sequence seq;
  private ASN1Integer serialNumber;
  private AlgorithmIdentifier signingAlg;
  private X500Name subject;
  private DERBitString subjectUID;
  private OptionalValidity validity;
  private ASN1Integer version;
  
  private CertTemplate(ASN1Sequence paramASN1Sequence)
  {
    this.seq = paramASN1Sequence;
    Object localObject = paramASN1Sequence.getObjects();
    while (((Enumeration)localObject).hasMoreElements())
    {
      paramASN1Sequence = (ASN1TaggedObject)((Enumeration)localObject).nextElement();
      switch (paramASN1Sequence.getTagNo())
      {
      default: 
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("unknown tag: ");
        ((StringBuilder)localObject).append(paramASN1Sequence.getTagNo());
        throw new IllegalArgumentException(((StringBuilder)localObject).toString());
      case 9: 
        this.extensions = Extensions.getInstance(paramASN1Sequence, false);
        break;
      case 8: 
        this.subjectUID = DERBitString.getInstance(paramASN1Sequence, false);
        break;
      case 7: 
        this.issuerUID = DERBitString.getInstance(paramASN1Sequence, false);
        break;
      case 6: 
        this.publicKey = SubjectPublicKeyInfo.getInstance(paramASN1Sequence, false);
        break;
      case 5: 
        this.subject = X500Name.getInstance(paramASN1Sequence, true);
        break;
      case 4: 
        this.validity = OptionalValidity.getInstance(ASN1Sequence.getInstance(paramASN1Sequence, false));
        break;
      case 3: 
        this.issuer = X500Name.getInstance(paramASN1Sequence, true);
        break;
      case 2: 
        this.signingAlg = AlgorithmIdentifier.getInstance(paramASN1Sequence, false);
        break;
      case 1: 
        this.serialNumber = ASN1Integer.getInstance(paramASN1Sequence, false);
        break;
      case 0: 
        this.version = ASN1Integer.getInstance(paramASN1Sequence, false);
      }
    }
  }
  
  public static CertTemplate getInstance(Object paramObject)
  {
    if ((paramObject instanceof CertTemplate)) {
      return (CertTemplate)paramObject;
    }
    if (paramObject != null) {
      return new CertTemplate(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public Extensions getExtensions()
  {
    return this.extensions;
  }
  
  public X500Name getIssuer()
  {
    return this.issuer;
  }
  
  public DERBitString getIssuerUID()
  {
    return this.issuerUID;
  }
  
  public SubjectPublicKeyInfo getPublicKey()
  {
    return this.publicKey;
  }
  
  public ASN1Integer getSerialNumber()
  {
    return this.serialNumber;
  }
  
  public AlgorithmIdentifier getSigningAlg()
  {
    return this.signingAlg;
  }
  
  public X500Name getSubject()
  {
    return this.subject;
  }
  
  public DERBitString getSubjectUID()
  {
    return this.subjectUID;
  }
  
  public OptionalValidity getValidity()
  {
    return this.validity;
  }
  
  public int getVersion()
  {
    return this.version.getValue().intValue();
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    return this.seq;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\crmf\CertTemplate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */