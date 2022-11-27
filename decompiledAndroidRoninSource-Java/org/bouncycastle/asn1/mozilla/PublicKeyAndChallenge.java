package org.bouncycastle.asn1.mozilla;

import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERIA5String;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;

public class PublicKeyAndChallenge
  extends ASN1Object
{
  private DERIA5String challenge;
  private ASN1Sequence pkacSeq;
  private SubjectPublicKeyInfo spki;
  
  private PublicKeyAndChallenge(ASN1Sequence paramASN1Sequence)
  {
    this.pkacSeq = paramASN1Sequence;
    this.spki = SubjectPublicKeyInfo.getInstance(paramASN1Sequence.getObjectAt(0));
    this.challenge = DERIA5String.getInstance(paramASN1Sequence.getObjectAt(1));
  }
  
  public static PublicKeyAndChallenge getInstance(Object paramObject)
  {
    if ((paramObject instanceof PublicKeyAndChallenge)) {
      return (PublicKeyAndChallenge)paramObject;
    }
    if (paramObject != null) {
      return new PublicKeyAndChallenge(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public DERIA5String getChallenge()
  {
    return this.challenge;
  }
  
  public SubjectPublicKeyInfo getSubjectPublicKeyInfo()
  {
    return this.spki;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    return this.pkacSeq;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\mozilla\PublicKeyAndChallenge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */