package org.bouncycastle.asn1.bc;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.util.Arrays;

public class SecretKeyData
  extends ASN1Object
{
  private final ASN1ObjectIdentifier keyAlgorithm;
  private final ASN1OctetString keyBytes;
  
  public SecretKeyData(ASN1ObjectIdentifier paramASN1ObjectIdentifier, byte[] paramArrayOfByte)
  {
    this.keyAlgorithm = paramASN1ObjectIdentifier;
    this.keyBytes = new DEROctetString(Arrays.clone(paramArrayOfByte));
  }
  
  private SecretKeyData(ASN1Sequence paramASN1Sequence)
  {
    this.keyAlgorithm = ASN1ObjectIdentifier.getInstance(paramASN1Sequence.getObjectAt(0));
    this.keyBytes = ASN1OctetString.getInstance(paramASN1Sequence.getObjectAt(1));
  }
  
  public static SecretKeyData getInstance(Object paramObject)
  {
    if ((paramObject instanceof SecretKeyData)) {
      return (SecretKeyData)paramObject;
    }
    if (paramObject != null) {
      return new SecretKeyData(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public ASN1ObjectIdentifier getKeyAlgorithm()
  {
    return this.keyAlgorithm;
  }
  
  public byte[] getKeyBytes()
  {
    return Arrays.clone(this.keyBytes.getOctets());
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.keyAlgorithm);
    localASN1EncodableVector.add(this.keyBytes);
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\bc\SecretKeyData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */