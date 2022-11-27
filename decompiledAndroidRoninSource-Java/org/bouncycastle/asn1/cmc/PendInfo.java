package org.bouncycastle.asn1.cmc;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1GeneralizedTime;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.util.Arrays;

public class PendInfo
  extends ASN1Object
{
  private final ASN1GeneralizedTime pendTime;
  private final byte[] pendToken;
  
  private PendInfo(ASN1Sequence paramASN1Sequence)
  {
    if (paramASN1Sequence.size() == 2)
    {
      this.pendToken = Arrays.clone(ASN1OctetString.getInstance(paramASN1Sequence.getObjectAt(0)).getOctets());
      this.pendTime = ASN1GeneralizedTime.getInstance(paramASN1Sequence.getObjectAt(1));
      return;
    }
    throw new IllegalArgumentException("incorrect sequence size");
  }
  
  public PendInfo(byte[] paramArrayOfByte, ASN1GeneralizedTime paramASN1GeneralizedTime)
  {
    this.pendToken = Arrays.clone(paramArrayOfByte);
    this.pendTime = paramASN1GeneralizedTime;
  }
  
  public static PendInfo getInstance(Object paramObject)
  {
    if ((paramObject instanceof PendInfo)) {
      return (PendInfo)paramObject;
    }
    if (paramObject != null) {
      return new PendInfo(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public ASN1GeneralizedTime getPendTime()
  {
    return this.pendTime;
  }
  
  public byte[] getPendToken()
  {
    return this.pendToken;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(new DEROctetString(this.pendToken));
    localASN1EncodableVector.add(this.pendTime);
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cmc\PendInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */