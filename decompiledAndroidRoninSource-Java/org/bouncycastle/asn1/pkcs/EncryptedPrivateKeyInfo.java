package org.bouncycastle.asn1.pkcs;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class EncryptedPrivateKeyInfo
  extends ASN1Object
{
  private AlgorithmIdentifier algId;
  private ASN1OctetString data;
  
  private EncryptedPrivateKeyInfo(ASN1Sequence paramASN1Sequence)
  {
    paramASN1Sequence = paramASN1Sequence.getObjects();
    this.algId = AlgorithmIdentifier.getInstance(paramASN1Sequence.nextElement());
    this.data = ASN1OctetString.getInstance(paramASN1Sequence.nextElement());
  }
  
  public EncryptedPrivateKeyInfo(AlgorithmIdentifier paramAlgorithmIdentifier, byte[] paramArrayOfByte)
  {
    this.algId = paramAlgorithmIdentifier;
    this.data = new DEROctetString(paramArrayOfByte);
  }
  
  public static EncryptedPrivateKeyInfo getInstance(Object paramObject)
  {
    if ((paramObject instanceof EncryptedPrivateKeyInfo)) {
      return (EncryptedPrivateKeyInfo)paramObject;
    }
    if (paramObject != null) {
      return new EncryptedPrivateKeyInfo(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public byte[] getEncryptedData()
  {
    return this.data.getOctets();
  }
  
  public AlgorithmIdentifier getEncryptionAlgorithm()
  {
    return this.algId;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.algId);
    localASN1EncodableVector.add(this.data);
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\pkcs\EncryptedPrivateKeyInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */