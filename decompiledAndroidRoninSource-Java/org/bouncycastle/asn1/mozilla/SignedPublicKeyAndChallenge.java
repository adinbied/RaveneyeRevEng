package org.bouncycastle.asn1.mozilla;

import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class SignedPublicKeyAndChallenge
  extends ASN1Object
{
  private final ASN1Sequence pkacSeq;
  private final PublicKeyAndChallenge pubKeyAndChal;
  
  private SignedPublicKeyAndChallenge(ASN1Sequence paramASN1Sequence)
  {
    this.pkacSeq = paramASN1Sequence;
    this.pubKeyAndChal = PublicKeyAndChallenge.getInstance(paramASN1Sequence.getObjectAt(0));
  }
  
  public static SignedPublicKeyAndChallenge getInstance(Object paramObject)
  {
    if ((paramObject instanceof SignedPublicKeyAndChallenge)) {
      return (SignedPublicKeyAndChallenge)paramObject;
    }
    if (paramObject != null) {
      return new SignedPublicKeyAndChallenge(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public PublicKeyAndChallenge getPublicKeyAndChallenge()
  {
    return this.pubKeyAndChal;
  }
  
  public DERBitString getSignature()
  {
    return DERBitString.getInstance(this.pkacSeq.getObjectAt(2));
  }
  
  public AlgorithmIdentifier getSignatureAlgorithm()
  {
    return AlgorithmIdentifier.getInstance(this.pkacSeq.getObjectAt(1));
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    return this.pkacSeq;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\mozilla\SignedPublicKeyAndChallenge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */