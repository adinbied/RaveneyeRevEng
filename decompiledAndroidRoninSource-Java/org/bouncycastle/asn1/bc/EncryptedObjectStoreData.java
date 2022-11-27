package org.bouncycastle.asn1.bc;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class EncryptedObjectStoreData
  extends ASN1Object
{
  private final ASN1OctetString encryptedContent;
  private final AlgorithmIdentifier encryptionAlgorithm;
  
  private EncryptedObjectStoreData(ASN1Sequence paramASN1Sequence)
  {
    this.encryptionAlgorithm = AlgorithmIdentifier.getInstance(paramASN1Sequence.getObjectAt(0));
    this.encryptedContent = ASN1OctetString.getInstance(paramASN1Sequence.getObjectAt(1));
  }
  
  public EncryptedObjectStoreData(AlgorithmIdentifier paramAlgorithmIdentifier, byte[] paramArrayOfByte)
  {
    this.encryptionAlgorithm = paramAlgorithmIdentifier;
    this.encryptedContent = new DEROctetString(paramArrayOfByte);
  }
  
  public static EncryptedObjectStoreData getInstance(Object paramObject)
  {
    if ((paramObject instanceof EncryptedObjectStoreData)) {
      return (EncryptedObjectStoreData)paramObject;
    }
    if (paramObject != null) {
      return new EncryptedObjectStoreData(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public ASN1OctetString getEncryptedContent()
  {
    return this.encryptedContent;
  }
  
  public AlgorithmIdentifier getEncryptionAlgorithm()
  {
    return this.encryptionAlgorithm;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.encryptionAlgorithm);
    localASN1EncodableVector.add(this.encryptedContent);
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\bc\EncryptedObjectStoreData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */