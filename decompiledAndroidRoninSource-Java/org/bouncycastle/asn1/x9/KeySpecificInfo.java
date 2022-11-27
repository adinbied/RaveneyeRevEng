package org.bouncycastle.asn1.x9;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

public class KeySpecificInfo
  extends ASN1Object
{
  private ASN1ObjectIdentifier algorithm;
  private ASN1OctetString counter;
  
  public KeySpecificInfo(ASN1ObjectIdentifier paramASN1ObjectIdentifier, ASN1OctetString paramASN1OctetString)
  {
    this.algorithm = paramASN1ObjectIdentifier;
    this.counter = paramASN1OctetString;
  }
  
  private KeySpecificInfo(ASN1Sequence paramASN1Sequence)
  {
    paramASN1Sequence = paramASN1Sequence.getObjects();
    this.algorithm = ((ASN1ObjectIdentifier)paramASN1Sequence.nextElement());
    this.counter = ((ASN1OctetString)paramASN1Sequence.nextElement());
  }
  
  public static KeySpecificInfo getInstance(Object paramObject)
  {
    if ((paramObject instanceof KeySpecificInfo)) {
      return (KeySpecificInfo)paramObject;
    }
    if (paramObject != null) {
      return new KeySpecificInfo(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public ASN1ObjectIdentifier getAlgorithm()
  {
    return this.algorithm;
  }
  
  public ASN1OctetString getCounter()
  {
    return this.counter;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.algorithm);
    localASN1EncodableVector.add(this.counter);
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\asn1\x9\KeySpecificInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */