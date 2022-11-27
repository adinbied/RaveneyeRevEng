package org.bouncycastle.asn1.pkcs;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.asn1.x509.X509Name;

public class CertificationRequestInfo
  extends ASN1Object
{
  ASN1Set attributes = null;
  X500Name subject;
  SubjectPublicKeyInfo subjectPKInfo;
  ASN1Integer version = new ASN1Integer(0L);
  
  public CertificationRequestInfo(ASN1Sequence paramASN1Sequence)
  {
    this.version = ((ASN1Integer)paramASN1Sequence.getObjectAt(0));
    this.subject = X500Name.getInstance(paramASN1Sequence.getObjectAt(1));
    this.subjectPKInfo = SubjectPublicKeyInfo.getInstance(paramASN1Sequence.getObjectAt(2));
    if (paramASN1Sequence.size() > 3) {
      this.attributes = ASN1Set.getInstance((ASN1TaggedObject)paramASN1Sequence.getObjectAt(3), false);
    }
    validateAttributes(this.attributes);
    if ((this.subject != null) && (this.version != null) && (this.subjectPKInfo != null)) {
      return;
    }
    throw new IllegalArgumentException("Not all mandatory fields set in CertificationRequestInfo generator.");
  }
  
  public CertificationRequestInfo(X500Name paramX500Name, SubjectPublicKeyInfo paramSubjectPublicKeyInfo, ASN1Set paramASN1Set)
  {
    if ((paramX500Name != null) && (paramSubjectPublicKeyInfo != null))
    {
      validateAttributes(paramASN1Set);
      this.subject = paramX500Name;
      this.subjectPKInfo = paramSubjectPublicKeyInfo;
      this.attributes = paramASN1Set;
      return;
    }
    throw new IllegalArgumentException("Not all mandatory fields set in CertificationRequestInfo generator.");
  }
  
  public CertificationRequestInfo(X509Name paramX509Name, SubjectPublicKeyInfo paramSubjectPublicKeyInfo, ASN1Set paramASN1Set)
  {
    this(X500Name.getInstance(paramX509Name.toASN1Primitive()), paramSubjectPublicKeyInfo, paramASN1Set);
  }
  
  public static CertificationRequestInfo getInstance(Object paramObject)
  {
    if ((paramObject instanceof CertificationRequestInfo)) {
      return (CertificationRequestInfo)paramObject;
    }
    if (paramObject != null) {
      return new CertificationRequestInfo(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  private static void validateAttributes(ASN1Set paramASN1Set)
  {
    if (paramASN1Set == null) {
      return;
    }
    paramASN1Set = paramASN1Set.getObjects();
    while (paramASN1Set.hasMoreElements())
    {
      Attribute localAttribute = Attribute.getInstance(paramASN1Set.nextElement());
      if ((localAttribute.getAttrType().equals(PKCSObjectIdentifiers.pkcs_9_at_challengePassword)) && (localAttribute.getAttrValues().size() != 1)) {
        throw new IllegalArgumentException("challengePassword attribute must have one value");
      }
    }
  }
  
  public ASN1Set getAttributes()
  {
    return this.attributes;
  }
  
  public X500Name getSubject()
  {
    return this.subject;
  }
  
  public SubjectPublicKeyInfo getSubjectPublicKeyInfo()
  {
    return this.subjectPKInfo;
  }
  
  public ASN1Integer getVersion()
  {
    return this.version;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.version);
    localASN1EncodableVector.add(this.subject);
    localASN1EncodableVector.add(this.subjectPKInfo);
    ASN1Set localASN1Set = this.attributes;
    if (localASN1Set != null) {
      localASN1EncodableVector.add(new DERTaggedObject(false, 0, localASN1Set));
    }
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\pkcs\CertificationRequestInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */