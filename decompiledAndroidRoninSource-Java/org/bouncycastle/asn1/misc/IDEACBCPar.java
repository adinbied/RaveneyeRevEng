package org.bouncycastle.asn1.misc;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.util.Arrays;

public class IDEACBCPar
  extends ASN1Object
{
  ASN1OctetString iv;
  
  public IDEACBCPar(ASN1Sequence paramASN1Sequence)
  {
    if (paramASN1Sequence.size() == 1) {
      paramASN1Sequence = (ASN1OctetString)paramASN1Sequence.getObjectAt(0);
    } else {
      paramASN1Sequence = null;
    }
    this.iv = paramASN1Sequence;
  }
  
  public IDEACBCPar(byte[] paramArrayOfByte)
  {
    this.iv = new DEROctetString(paramArrayOfByte);
  }
  
  public static IDEACBCPar getInstance(Object paramObject)
  {
    if ((paramObject instanceof IDEACBCPar)) {
      return (IDEACBCPar)paramObject;
    }
    if (paramObject != null) {
      return new IDEACBCPar(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public byte[] getIV()
  {
    ASN1OctetString localASN1OctetString = this.iv;
    if (localASN1OctetString != null) {
      return Arrays.clone(localASN1OctetString.getOctets());
    }
    return null;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    ASN1OctetString localASN1OctetString = this.iv;
    if (localASN1OctetString != null) {
      localASN1EncodableVector.add(localASN1OctetString);
    }
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\misc\IDEACBCPar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */