package org.bouncycastle.asn1.cryptopro;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;

public class GOST3410PublicKeyAlgParameters
  extends ASN1Object
{
  private ASN1ObjectIdentifier digestParamSet;
  private ASN1ObjectIdentifier encryptionParamSet;
  private ASN1ObjectIdentifier publicKeyParamSet;
  
  public GOST3410PublicKeyAlgParameters(ASN1ObjectIdentifier paramASN1ObjectIdentifier1, ASN1ObjectIdentifier paramASN1ObjectIdentifier2)
  {
    this.publicKeyParamSet = paramASN1ObjectIdentifier1;
    this.digestParamSet = paramASN1ObjectIdentifier2;
    this.encryptionParamSet = null;
  }
  
  public GOST3410PublicKeyAlgParameters(ASN1ObjectIdentifier paramASN1ObjectIdentifier1, ASN1ObjectIdentifier paramASN1ObjectIdentifier2, ASN1ObjectIdentifier paramASN1ObjectIdentifier3)
  {
    this.publicKeyParamSet = paramASN1ObjectIdentifier1;
    this.digestParamSet = paramASN1ObjectIdentifier2;
    this.encryptionParamSet = paramASN1ObjectIdentifier3;
  }
  
  public GOST3410PublicKeyAlgParameters(ASN1Sequence paramASN1Sequence)
  {
    this.publicKeyParamSet = ((ASN1ObjectIdentifier)paramASN1Sequence.getObjectAt(0));
    this.digestParamSet = ((ASN1ObjectIdentifier)paramASN1Sequence.getObjectAt(1));
    if (paramASN1Sequence.size() > 2) {
      this.encryptionParamSet = ((ASN1ObjectIdentifier)paramASN1Sequence.getObjectAt(2));
    }
  }
  
  public static GOST3410PublicKeyAlgParameters getInstance(Object paramObject)
  {
    if ((paramObject instanceof GOST3410PublicKeyAlgParameters)) {
      return (GOST3410PublicKeyAlgParameters)paramObject;
    }
    if (paramObject != null) {
      return new GOST3410PublicKeyAlgParameters(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public static GOST3410PublicKeyAlgParameters getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    return getInstance(ASN1Sequence.getInstance(paramASN1TaggedObject, paramBoolean));
  }
  
  public ASN1ObjectIdentifier getDigestParamSet()
  {
    return this.digestParamSet;
  }
  
  public ASN1ObjectIdentifier getEncryptionParamSet()
  {
    return this.encryptionParamSet;
  }
  
  public ASN1ObjectIdentifier getPublicKeyParamSet()
  {
    return this.publicKeyParamSet;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.publicKeyParamSet);
    localASN1EncodableVector.add(this.digestParamSet);
    ASN1ObjectIdentifier localASN1ObjectIdentifier = this.encryptionParamSet;
    if (localASN1ObjectIdentifier != null) {
      localASN1EncodableVector.add(localASN1ObjectIdentifier);
    }
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cryptopro\GOST3410PublicKeyAlgParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */