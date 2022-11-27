package org.bouncycastle.asn1.pkcs;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class SignerInfo
  extends ASN1Object
{
  private ASN1Set authenticatedAttributes;
  private AlgorithmIdentifier digAlgorithm;
  private AlgorithmIdentifier digEncryptionAlgorithm;
  private ASN1OctetString encryptedDigest;
  private IssuerAndSerialNumber issuerAndSerialNumber;
  private ASN1Set unauthenticatedAttributes;
  private ASN1Integer version;
  
  public SignerInfo(ASN1Integer paramASN1Integer, IssuerAndSerialNumber paramIssuerAndSerialNumber, AlgorithmIdentifier paramAlgorithmIdentifier1, ASN1Set paramASN1Set1, AlgorithmIdentifier paramAlgorithmIdentifier2, ASN1OctetString paramASN1OctetString, ASN1Set paramASN1Set2)
  {
    this.version = paramASN1Integer;
    this.issuerAndSerialNumber = paramIssuerAndSerialNumber;
    this.digAlgorithm = paramAlgorithmIdentifier1;
    this.authenticatedAttributes = paramASN1Set1;
    this.digEncryptionAlgorithm = paramAlgorithmIdentifier2;
    this.encryptedDigest = paramASN1OctetString;
    this.unauthenticatedAttributes = paramASN1Set2;
  }
  
  public SignerInfo(ASN1Sequence paramASN1Sequence)
  {
    Enumeration localEnumeration = paramASN1Sequence.getObjects();
    this.version = ((ASN1Integer)localEnumeration.nextElement());
    this.issuerAndSerialNumber = IssuerAndSerialNumber.getInstance(localEnumeration.nextElement());
    this.digAlgorithm = AlgorithmIdentifier.getInstance(localEnumeration.nextElement());
    paramASN1Sequence = localEnumeration.nextElement();
    if ((paramASN1Sequence instanceof ASN1TaggedObject))
    {
      this.authenticatedAttributes = ASN1Set.getInstance((ASN1TaggedObject)paramASN1Sequence, false);
      paramASN1Sequence = localEnumeration.nextElement();
    }
    else
    {
      this.authenticatedAttributes = null;
    }
    this.digEncryptionAlgorithm = AlgorithmIdentifier.getInstance(paramASN1Sequence);
    this.encryptedDigest = DEROctetString.getInstance(localEnumeration.nextElement());
    if (localEnumeration.hasMoreElements())
    {
      this.unauthenticatedAttributes = ASN1Set.getInstance((ASN1TaggedObject)localEnumeration.nextElement(), false);
      return;
    }
    this.unauthenticatedAttributes = null;
  }
  
  public static SignerInfo getInstance(Object paramObject)
  {
    if ((paramObject instanceof SignerInfo)) {
      return (SignerInfo)paramObject;
    }
    if ((paramObject instanceof ASN1Sequence)) {
      return new SignerInfo((ASN1Sequence)paramObject);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("unknown object in factory: ");
    localStringBuilder.append(paramObject.getClass().getName());
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public ASN1Set getAuthenticatedAttributes()
  {
    return this.authenticatedAttributes;
  }
  
  public AlgorithmIdentifier getDigestAlgorithm()
  {
    return this.digAlgorithm;
  }
  
  public AlgorithmIdentifier getDigestEncryptionAlgorithm()
  {
    return this.digEncryptionAlgorithm;
  }
  
  public ASN1OctetString getEncryptedDigest()
  {
    return this.encryptedDigest;
  }
  
  public IssuerAndSerialNumber getIssuerAndSerialNumber()
  {
    return this.issuerAndSerialNumber;
  }
  
  public ASN1Set getUnauthenticatedAttributes()
  {
    return this.unauthenticatedAttributes;
  }
  
  public ASN1Integer getVersion()
  {
    return this.version;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.version);
    localASN1EncodableVector.add(this.issuerAndSerialNumber);
    localASN1EncodableVector.add(this.digAlgorithm);
    if (this.authenticatedAttributes != null) {
      localASN1EncodableVector.add(new DERTaggedObject(false, 0, this.authenticatedAttributes));
    }
    localASN1EncodableVector.add(this.digEncryptionAlgorithm);
    localASN1EncodableVector.add(this.encryptedDigest);
    if (this.unauthenticatedAttributes != null) {
      localASN1EncodableVector.add(new DERTaggedObject(false, 1, this.unauthenticatedAttributes));
    }
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\pkcs\SignerInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */