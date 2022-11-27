package org.bouncycastle.asn1.ocsp;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class Signature
  extends ASN1Object
{
  ASN1Sequence certs;
  DERBitString signature;
  AlgorithmIdentifier signatureAlgorithm;
  
  private Signature(ASN1Sequence paramASN1Sequence)
  {
    this.signatureAlgorithm = AlgorithmIdentifier.getInstance(paramASN1Sequence.getObjectAt(0));
    this.signature = ((DERBitString)paramASN1Sequence.getObjectAt(1));
    if (paramASN1Sequence.size() == 3) {
      this.certs = ASN1Sequence.getInstance((ASN1TaggedObject)paramASN1Sequence.getObjectAt(2), true);
    }
  }
  
  public Signature(AlgorithmIdentifier paramAlgorithmIdentifier, DERBitString paramDERBitString)
  {
    this.signatureAlgorithm = paramAlgorithmIdentifier;
    this.signature = paramDERBitString;
  }
  
  public Signature(AlgorithmIdentifier paramAlgorithmIdentifier, DERBitString paramDERBitString, ASN1Sequence paramASN1Sequence)
  {
    this.signatureAlgorithm = paramAlgorithmIdentifier;
    this.signature = paramDERBitString;
    this.certs = paramASN1Sequence;
  }
  
  public static Signature getInstance(Object paramObject)
  {
    if ((paramObject instanceof Signature)) {
      return (Signature)paramObject;
    }
    if (paramObject != null) {
      return new Signature(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public static Signature getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    return getInstance(ASN1Sequence.getInstance(paramASN1TaggedObject, paramBoolean));
  }
  
  public ASN1Sequence getCerts()
  {
    return this.certs;
  }
  
  public DERBitString getSignature()
  {
    return this.signature;
  }
  
  public AlgorithmIdentifier getSignatureAlgorithm()
  {
    return this.signatureAlgorithm;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.signatureAlgorithm);
    localASN1EncodableVector.add(this.signature);
    ASN1Sequence localASN1Sequence = this.certs;
    if (localASN1Sequence != null) {
      localASN1EncodableVector.add(new DERTaggedObject(true, 0, localASN1Sequence));
    }
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\ocsp\Signature.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */