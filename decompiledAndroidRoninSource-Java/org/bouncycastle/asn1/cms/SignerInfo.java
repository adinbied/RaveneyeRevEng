package org.bouncycastle.asn1.cms;

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
  private SignerIdentifier sid;
  private ASN1Set unauthenticatedAttributes;
  private ASN1Integer version;
  
  public SignerInfo(ASN1Sequence paramASN1Sequence)
  {
    Enumeration localEnumeration = paramASN1Sequence.getObjects();
    this.version = ((ASN1Integer)localEnumeration.nextElement());
    this.sid = SignerIdentifier.getInstance(localEnumeration.nextElement());
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
  
  public SignerInfo(SignerIdentifier paramSignerIdentifier, AlgorithmIdentifier paramAlgorithmIdentifier1, ASN1Set paramASN1Set1, AlgorithmIdentifier paramAlgorithmIdentifier2, ASN1OctetString paramASN1OctetString, ASN1Set paramASN1Set2)
  {
    ASN1Integer localASN1Integer;
    if (paramSignerIdentifier.isTagged()) {
      localASN1Integer = new ASN1Integer(3L);
    } else {
      localASN1Integer = new ASN1Integer(1L);
    }
    this.version = localASN1Integer;
    this.sid = paramSignerIdentifier;
    this.digAlgorithm = paramAlgorithmIdentifier1;
    this.authenticatedAttributes = paramASN1Set1;
    this.digEncryptionAlgorithm = paramAlgorithmIdentifier2;
    this.encryptedDigest = paramASN1OctetString;
    this.unauthenticatedAttributes = paramASN1Set2;
  }
  
  public SignerInfo(SignerIdentifier paramSignerIdentifier, AlgorithmIdentifier paramAlgorithmIdentifier1, Attributes paramAttributes1, AlgorithmIdentifier paramAlgorithmIdentifier2, ASN1OctetString paramASN1OctetString, Attributes paramAttributes2)
  {
    ASN1Integer localASN1Integer;
    if (paramSignerIdentifier.isTagged()) {
      localASN1Integer = new ASN1Integer(3L);
    } else {
      localASN1Integer = new ASN1Integer(1L);
    }
    this.version = localASN1Integer;
    this.sid = paramSignerIdentifier;
    this.digAlgorithm = paramAlgorithmIdentifier1;
    this.authenticatedAttributes = ASN1Set.getInstance(paramAttributes1);
    this.digEncryptionAlgorithm = paramAlgorithmIdentifier2;
    this.encryptedDigest = paramASN1OctetString;
    this.unauthenticatedAttributes = ASN1Set.getInstance(paramAttributes2);
  }
  
  public static SignerInfo getInstance(Object paramObject)
    throws IllegalArgumentException
  {
    if ((paramObject instanceof SignerInfo)) {
      return (SignerInfo)paramObject;
    }
    if (paramObject != null) {
      return new SignerInfo(ASN1Sequence.getInstance(paramObject));
    }
    return null;
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
  
  public SignerIdentifier getSID()
  {
    return this.sid;
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
    localASN1EncodableVector.add(this.sid);
    localASN1EncodableVector.add(this.digAlgorithm);
    ASN1Set localASN1Set = this.authenticatedAttributes;
    if (localASN1Set != null) {
      localASN1EncodableVector.add(new DERTaggedObject(false, 0, localASN1Set));
    }
    localASN1EncodableVector.add(this.digEncryptionAlgorithm);
    localASN1EncodableVector.add(this.encryptedDigest);
    localASN1Set = this.unauthenticatedAttributes;
    if (localASN1Set != null) {
      localASN1EncodableVector.add(new DERTaggedObject(false, 1, localASN1Set));
    }
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cms\SignerInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */