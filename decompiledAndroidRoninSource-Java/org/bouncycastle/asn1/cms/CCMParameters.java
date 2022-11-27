package org.bouncycastle.asn1.cms;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.util.Arrays;

public class CCMParameters
  extends ASN1Object
{
  private int icvLen;
  private byte[] nonce;
  
  private CCMParameters(ASN1Sequence paramASN1Sequence)
  {
    this.nonce = ASN1OctetString.getInstance(paramASN1Sequence.getObjectAt(0)).getOctets();
    int i;
    if (paramASN1Sequence.size() == 2) {
      i = ASN1Integer.getInstance(paramASN1Sequence.getObjectAt(1)).getValue().intValue();
    } else {
      i = 12;
    }
    this.icvLen = i;
  }
  
  public CCMParameters(byte[] paramArrayOfByte, int paramInt)
  {
    this.nonce = Arrays.clone(paramArrayOfByte);
    this.icvLen = paramInt;
  }
  
  public static CCMParameters getInstance(Object paramObject)
  {
    if ((paramObject instanceof CCMParameters)) {
      return (CCMParameters)paramObject;
    }
    if (paramObject != null) {
      return new CCMParameters(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public int getIcvLen()
  {
    return this.icvLen;
  }
  
  public byte[] getNonce()
  {
    return Arrays.clone(this.nonce);
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(new DEROctetString(this.nonce));
    int i = this.icvLen;
    if (i != 12) {
      localASN1EncodableVector.add(new ASN1Integer(i));
    }
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cms\CCMParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */