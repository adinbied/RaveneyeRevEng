package org.bouncycastle.asn1.x509;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;

public class DigestInfo
  extends ASN1Object
{
  private AlgorithmIdentifier algId;
  private byte[] digest;
  
  public DigestInfo(ASN1Sequence paramASN1Sequence)
  {
    paramASN1Sequence = paramASN1Sequence.getObjects();
    this.algId = AlgorithmIdentifier.getInstance(paramASN1Sequence.nextElement());
    this.digest = ASN1OctetString.getInstance(paramASN1Sequence.nextElement()).getOctets();
  }
  
  public DigestInfo(AlgorithmIdentifier paramAlgorithmIdentifier, byte[] paramArrayOfByte)
  {
    this.digest = paramArrayOfByte;
    this.algId = paramAlgorithmIdentifier;
  }
  
  public static DigestInfo getInstance(Object paramObject)
  {
    if ((paramObject instanceof DigestInfo)) {
      return (DigestInfo)paramObject;
    }
    if (paramObject != null) {
      return new DigestInfo(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public static DigestInfo getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    return getInstance(ASN1Sequence.getInstance(paramASN1TaggedObject, paramBoolean));
  }
  
  public AlgorithmIdentifier getAlgorithmId()
  {
    return this.algId;
  }
  
  public byte[] getDigest()
  {
    return this.digest;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.algId);
    localASN1EncodableVector.add(new DEROctetString(this.digest));
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\asn1\x509\DigestInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */