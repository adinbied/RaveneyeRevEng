package org.bouncycastle.asn1.misc;

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

public class CAST5CBCParameters
  extends ASN1Object
{
  ASN1OctetString iv;
  ASN1Integer keyLength;
  
  public CAST5CBCParameters(ASN1Sequence paramASN1Sequence)
  {
    this.iv = ((ASN1OctetString)paramASN1Sequence.getObjectAt(0));
    this.keyLength = ((ASN1Integer)paramASN1Sequence.getObjectAt(1));
  }
  
  public CAST5CBCParameters(byte[] paramArrayOfByte, int paramInt)
  {
    this.iv = new DEROctetString(Arrays.clone(paramArrayOfByte));
    this.keyLength = new ASN1Integer(paramInt);
  }
  
  public static CAST5CBCParameters getInstance(Object paramObject)
  {
    if ((paramObject instanceof CAST5CBCParameters)) {
      return (CAST5CBCParameters)paramObject;
    }
    if (paramObject != null) {
      return new CAST5CBCParameters(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public byte[] getIV()
  {
    return Arrays.clone(this.iv.getOctets());
  }
  
  public int getKeyLength()
  {
    return this.keyLength.getValue().intValue();
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.iv);
    localASN1EncodableVector.add(this.keyLength);
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\misc\CAST5CBCParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */