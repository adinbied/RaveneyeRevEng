package org.bouncycastle.asn1.bc;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.util.Arrays;

public class EncryptedSecretKeyData
  extends ASN1Object
{
  private final ASN1OctetString encryptedKeyData;
  private final AlgorithmIdentifier keyEncryptionAlgorithm;
  
  private EncryptedSecretKeyData(ASN1Sequence paramASN1Sequence)
  {
    this.keyEncryptionAlgorithm = AlgorithmIdentifier.getInstance(paramASN1Sequence.getObjectAt(0));
    this.encryptedKeyData = ASN1OctetString.getInstance(paramASN1Sequence.getObjectAt(1));
  }
  
  public EncryptedSecretKeyData(AlgorithmIdentifier paramAlgorithmIdentifier, byte[] paramArrayOfByte)
  {
    this.keyEncryptionAlgorithm = paramAlgorithmIdentifier;
    this.encryptedKeyData = new DEROctetString(Arrays.clone(paramArrayOfByte));
  }
  
  public static EncryptedSecretKeyData getInstance(Object paramObject)
  {
    if ((paramObject instanceof EncryptedSecretKeyData)) {
      return (EncryptedSecretKeyData)paramObject;
    }
    if (paramObject != null) {
      return new EncryptedSecretKeyData(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public byte[] getEncryptedKeyData()
  {
    return Arrays.clone(this.encryptedKeyData.getOctets());
  }
  
  public AlgorithmIdentifier getKeyEncryptionAlgorithm()
  {
    return this.keyEncryptionAlgorithm;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.keyEncryptionAlgorithm);
    localASN1EncodableVector.add(this.encryptedKeyData);
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\bc\EncryptedSecretKeyData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */