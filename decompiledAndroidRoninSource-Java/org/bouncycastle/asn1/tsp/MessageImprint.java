package org.bouncycastle.asn1.tsp;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.util.Arrays;

public class MessageImprint
  extends ASN1Object
{
  AlgorithmIdentifier hashAlgorithm;
  byte[] hashedMessage;
  
  private MessageImprint(ASN1Sequence paramASN1Sequence)
  {
    this.hashAlgorithm = AlgorithmIdentifier.getInstance(paramASN1Sequence.getObjectAt(0));
    this.hashedMessage = ASN1OctetString.getInstance(paramASN1Sequence.getObjectAt(1)).getOctets();
  }
  
  public MessageImprint(AlgorithmIdentifier paramAlgorithmIdentifier, byte[] paramArrayOfByte)
  {
    this.hashAlgorithm = paramAlgorithmIdentifier;
    this.hashedMessage = Arrays.clone(paramArrayOfByte);
  }
  
  public static MessageImprint getInstance(Object paramObject)
  {
    if ((paramObject instanceof MessageImprint)) {
      return (MessageImprint)paramObject;
    }
    if (paramObject != null) {
      return new MessageImprint(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public AlgorithmIdentifier getHashAlgorithm()
  {
    return this.hashAlgorithm;
  }
  
  public byte[] getHashedMessage()
  {
    return Arrays.clone(this.hashedMessage);
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.hashAlgorithm);
    localASN1EncodableVector.add(new DEROctetString(this.hashedMessage));
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\tsp\MessageImprint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */