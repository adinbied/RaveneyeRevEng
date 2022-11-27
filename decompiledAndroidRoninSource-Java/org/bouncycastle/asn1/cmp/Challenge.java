package org.bouncycastle.asn1.cmp;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class Challenge
  extends ASN1Object
{
  private ASN1OctetString challenge;
  private AlgorithmIdentifier owf;
  private ASN1OctetString witness;
  
  private Challenge(ASN1Sequence paramASN1Sequence)
  {
    int j = paramASN1Sequence.size();
    int i = 0;
    if (j == 3)
    {
      this.owf = AlgorithmIdentifier.getInstance(paramASN1Sequence.getObjectAt(0));
      i = 1;
    }
    this.witness = ASN1OctetString.getInstance(paramASN1Sequence.getObjectAt(i));
    this.challenge = ASN1OctetString.getInstance(paramASN1Sequence.getObjectAt(i + 1));
  }
  
  public Challenge(AlgorithmIdentifier paramAlgorithmIdentifier, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    this.owf = paramAlgorithmIdentifier;
    this.witness = new DEROctetString(paramArrayOfByte1);
    this.challenge = new DEROctetString(paramArrayOfByte2);
  }
  
  public Challenge(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    this(null, paramArrayOfByte1, paramArrayOfByte2);
  }
  
  private void addOptional(ASN1EncodableVector paramASN1EncodableVector, ASN1Encodable paramASN1Encodable)
  {
    if (paramASN1Encodable != null) {
      paramASN1EncodableVector.add(paramASN1Encodable);
    }
  }
  
  public static Challenge getInstance(Object paramObject)
  {
    if ((paramObject instanceof Challenge)) {
      return (Challenge)paramObject;
    }
    if (paramObject != null) {
      return new Challenge(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public byte[] getChallenge()
  {
    return this.challenge.getOctets();
  }
  
  public AlgorithmIdentifier getOwf()
  {
    return this.owf;
  }
  
  public byte[] getWitness()
  {
    return this.witness.getOctets();
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    addOptional(localASN1EncodableVector, this.owf);
    localASN1EncodableVector.add(this.witness);
    localASN1EncodableVector.add(this.challenge);
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cmp\Challenge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */