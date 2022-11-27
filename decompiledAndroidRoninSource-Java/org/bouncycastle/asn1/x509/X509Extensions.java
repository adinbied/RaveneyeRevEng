package org.bouncycastle.asn1.x509;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.bouncycastle.asn1.ASN1Boolean;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;

public class X509Extensions
  extends ASN1Object
{
  public static final ASN1ObjectIdentifier AuditIdentity = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.4");
  public static final ASN1ObjectIdentifier AuthorityInfoAccess;
  public static final ASN1ObjectIdentifier AuthorityKeyIdentifier;
  public static final ASN1ObjectIdentifier BasicConstraints;
  public static final ASN1ObjectIdentifier BiometricInfo;
  public static final ASN1ObjectIdentifier CRLDistributionPoints;
  public static final ASN1ObjectIdentifier CRLNumber;
  public static final ASN1ObjectIdentifier CertificateIssuer;
  public static final ASN1ObjectIdentifier CertificatePolicies;
  public static final ASN1ObjectIdentifier DeltaCRLIndicator;
  public static final ASN1ObjectIdentifier ExtendedKeyUsage;
  public static final ASN1ObjectIdentifier FreshestCRL;
  public static final ASN1ObjectIdentifier InhibitAnyPolicy;
  public static final ASN1ObjectIdentifier InstructionCode;
  public static final ASN1ObjectIdentifier InvalidityDate;
  public static final ASN1ObjectIdentifier IssuerAlternativeName;
  public static final ASN1ObjectIdentifier IssuingDistributionPoint;
  public static final ASN1ObjectIdentifier KeyUsage;
  public static final ASN1ObjectIdentifier LogoType;
  public static final ASN1ObjectIdentifier NameConstraints;
  public static final ASN1ObjectIdentifier NoRevAvail = new ASN1ObjectIdentifier("2.5.29.56");
  public static final ASN1ObjectIdentifier PolicyConstraints;
  public static final ASN1ObjectIdentifier PolicyMappings;
  public static final ASN1ObjectIdentifier PrivateKeyUsagePeriod;
  public static final ASN1ObjectIdentifier QCStatements;
  public static final ASN1ObjectIdentifier ReasonCode;
  public static final ASN1ObjectIdentifier SubjectAlternativeName;
  public static final ASN1ObjectIdentifier SubjectDirectoryAttributes = new ASN1ObjectIdentifier("2.5.29.9");
  public static final ASN1ObjectIdentifier SubjectInfoAccess;
  public static final ASN1ObjectIdentifier SubjectKeyIdentifier = new ASN1ObjectIdentifier("2.5.29.14");
  public static final ASN1ObjectIdentifier TargetInformation = new ASN1ObjectIdentifier("2.5.29.55");
  private Hashtable extensions = new Hashtable();
  private Vector ordering = new Vector();
  
  static
  {
    KeyUsage = new ASN1ObjectIdentifier("2.5.29.15");
    PrivateKeyUsagePeriod = new ASN1ObjectIdentifier("2.5.29.16");
    SubjectAlternativeName = new ASN1ObjectIdentifier("2.5.29.17");
    IssuerAlternativeName = new ASN1ObjectIdentifier("2.5.29.18");
    BasicConstraints = new ASN1ObjectIdentifier("2.5.29.19");
    CRLNumber = new ASN1ObjectIdentifier("2.5.29.20");
    ReasonCode = new ASN1ObjectIdentifier("2.5.29.21");
    InstructionCode = new ASN1ObjectIdentifier("2.5.29.23");
    InvalidityDate = new ASN1ObjectIdentifier("2.5.29.24");
    DeltaCRLIndicator = new ASN1ObjectIdentifier("2.5.29.27");
    IssuingDistributionPoint = new ASN1ObjectIdentifier("2.5.29.28");
    CertificateIssuer = new ASN1ObjectIdentifier("2.5.29.29");
    NameConstraints = new ASN1ObjectIdentifier("2.5.29.30");
    CRLDistributionPoints = new ASN1ObjectIdentifier("2.5.29.31");
    CertificatePolicies = new ASN1ObjectIdentifier("2.5.29.32");
    PolicyMappings = new ASN1ObjectIdentifier("2.5.29.33");
    AuthorityKeyIdentifier = new ASN1ObjectIdentifier("2.5.29.35");
    PolicyConstraints = new ASN1ObjectIdentifier("2.5.29.36");
    ExtendedKeyUsage = new ASN1ObjectIdentifier("2.5.29.37");
    FreshestCRL = new ASN1ObjectIdentifier("2.5.29.46");
    InhibitAnyPolicy = new ASN1ObjectIdentifier("2.5.29.54");
    AuthorityInfoAccess = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.1");
    SubjectInfoAccess = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.11");
    LogoType = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.12");
    BiometricInfo = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.2");
    QCStatements = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.3");
  }
  
  public X509Extensions(Hashtable paramHashtable)
  {
    this(null, paramHashtable);
  }
  
  public X509Extensions(Vector paramVector, Hashtable paramHashtable)
  {
    if (paramVector == null) {
      paramVector = paramHashtable.keys();
    } else {
      paramVector = paramVector.elements();
    }
    while (paramVector.hasMoreElements()) {
      this.ordering.addElement(ASN1ObjectIdentifier.getInstance(paramVector.nextElement()));
    }
    paramVector = this.ordering.elements();
    while (paramVector.hasMoreElements())
    {
      ASN1ObjectIdentifier localASN1ObjectIdentifier = ASN1ObjectIdentifier.getInstance(paramVector.nextElement());
      X509Extension localX509Extension = (X509Extension)paramHashtable.get(localASN1ObjectIdentifier);
      this.extensions.put(localASN1ObjectIdentifier, localX509Extension);
    }
  }
  
  public X509Extensions(Vector paramVector1, Vector paramVector2)
  {
    paramVector1 = paramVector1.elements();
    while (paramVector1.hasMoreElements()) {
      this.ordering.addElement(paramVector1.nextElement());
    }
    int i = 0;
    paramVector1 = this.ordering.elements();
    while (paramVector1.hasMoreElements())
    {
      ASN1ObjectIdentifier localASN1ObjectIdentifier = (ASN1ObjectIdentifier)paramVector1.nextElement();
      X509Extension localX509Extension = (X509Extension)paramVector2.elementAt(i);
      this.extensions.put(localASN1ObjectIdentifier, localX509Extension);
      i += 1;
    }
  }
  
  public X509Extensions(ASN1Sequence paramASN1Sequence)
  {
    Object localObject = paramASN1Sequence.getObjects();
    while (((Enumeration)localObject).hasMoreElements())
    {
      paramASN1Sequence = ASN1Sequence.getInstance(((Enumeration)localObject).nextElement());
      if (paramASN1Sequence.size() == 3)
      {
        this.extensions.put(paramASN1Sequence.getObjectAt(0), new X509Extension(ASN1Boolean.getInstance(paramASN1Sequence.getObjectAt(1)), ASN1OctetString.getInstance(paramASN1Sequence.getObjectAt(2))));
      }
      else
      {
        if (paramASN1Sequence.size() != 2) {
          break label149;
        }
        this.extensions.put(paramASN1Sequence.getObjectAt(0), new X509Extension(false, ASN1OctetString.getInstance(paramASN1Sequence.getObjectAt(1))));
      }
      this.ordering.addElement(paramASN1Sequence.getObjectAt(0));
      continue;
      label149:
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Bad sequence size: ");
      ((StringBuilder)localObject).append(paramASN1Sequence.size());
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
  }
  
  private ASN1ObjectIdentifier[] getExtensionOIDs(boolean paramBoolean)
  {
    Vector localVector = new Vector();
    int i = 0;
    while (i != this.ordering.size())
    {
      Object localObject = this.ordering.elementAt(i);
      if (((X509Extension)this.extensions.get(localObject)).isCritical() == paramBoolean) {
        localVector.addElement(localObject);
      }
      i += 1;
    }
    return toOidArray(localVector);
  }
  
  public static X509Extensions getInstance(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof X509Extensions)))
    {
      if ((paramObject instanceof ASN1Sequence)) {
        return new X509Extensions((ASN1Sequence)paramObject);
      }
      if ((paramObject instanceof Extensions)) {
        return new X509Extensions((ASN1Sequence)((Extensions)paramObject).toASN1Primitive());
      }
      if ((paramObject instanceof ASN1TaggedObject)) {
        return getInstance(((ASN1TaggedObject)paramObject).getObject());
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("illegal object in getInstance: ");
      localStringBuilder.append(paramObject.getClass().getName());
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return (X509Extensions)paramObject;
  }
  
  public static X509Extensions getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    return getInstance(ASN1Sequence.getInstance(paramASN1TaggedObject, paramBoolean));
  }
  
  private ASN1ObjectIdentifier[] toOidArray(Vector paramVector)
  {
    int j = paramVector.size();
    ASN1ObjectIdentifier[] arrayOfASN1ObjectIdentifier = new ASN1ObjectIdentifier[j];
    int i = 0;
    while (i != j)
    {
      arrayOfASN1ObjectIdentifier[i] = ((ASN1ObjectIdentifier)paramVector.elementAt(i));
      i += 1;
    }
    return arrayOfASN1ObjectIdentifier;
  }
  
  public boolean equivalent(X509Extensions paramX509Extensions)
  {
    if (this.extensions.size() != paramX509Extensions.extensions.size()) {
      return false;
    }
    Enumeration localEnumeration = this.extensions.keys();
    while (localEnumeration.hasMoreElements())
    {
      Object localObject = localEnumeration.nextElement();
      if (!this.extensions.get(localObject).equals(paramX509Extensions.extensions.get(localObject))) {
        return false;
      }
    }
    return true;
  }
  
  public ASN1ObjectIdentifier[] getCriticalExtensionOIDs()
  {
    return getExtensionOIDs(true);
  }
  
  public X509Extension getExtension(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
  {
    return (X509Extension)this.extensions.get(paramASN1ObjectIdentifier);
  }
  
  public ASN1ObjectIdentifier[] getExtensionOIDs()
  {
    return toOidArray(this.ordering);
  }
  
  public ASN1ObjectIdentifier[] getNonCriticalExtensionOIDs()
  {
    return getExtensionOIDs(false);
  }
  
  public Enumeration oids()
  {
    return this.ordering.elements();
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector1 = new ASN1EncodableVector();
    Enumeration localEnumeration = this.ordering.elements();
    while (localEnumeration.hasMoreElements())
    {
      ASN1ObjectIdentifier localASN1ObjectIdentifier = (ASN1ObjectIdentifier)localEnumeration.nextElement();
      X509Extension localX509Extension = (X509Extension)this.extensions.get(localASN1ObjectIdentifier);
      ASN1EncodableVector localASN1EncodableVector2 = new ASN1EncodableVector();
      localASN1EncodableVector2.add(localASN1ObjectIdentifier);
      if (localX509Extension.isCritical()) {
        localASN1EncodableVector2.add(ASN1Boolean.TRUE);
      }
      localASN1EncodableVector2.add(localX509Extension.getValue());
      localASN1EncodableVector1.add(new DERSequence(localASN1EncodableVector2));
    }
    return new DERSequence(localASN1EncodableVector1);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\asn1\x509\X509Extensions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */