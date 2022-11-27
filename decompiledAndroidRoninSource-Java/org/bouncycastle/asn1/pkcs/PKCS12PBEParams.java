package org.bouncycastle.asn1.pkcs;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;

public class PKCS12PBEParams
  extends ASN1Object
{
  ASN1Integer iterations;
  ASN1OctetString iv;
  
  private PKCS12PBEParams(ASN1Sequence paramASN1Sequence)
  {
    this.iv = ((ASN1OctetString)paramASN1Sequence.getObjectAt(0));
    this.iterations = ASN1Integer.getInstance(paramASN1Sequence.getObjectAt(1));
  }
  
  public PKCS12PBEParams(byte[] paramArrayOfByte, int paramInt)
  {
    this.iv = new DEROctetString(paramArrayOfByte);
    this.iterations = new ASN1Integer(paramInt);
  }
  
  public static PKCS12PBEParams getInstance(Object paramObject)
  {
    if ((paramObject instanceof PKCS12PBEParams)) {
      return (PKCS12PBEParams)paramObject;
    }
    if (paramObject != null) {
      return new PKCS12PBEParams(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public byte[] getIV()
  {
    return this.iv.getOctets();
  }
  
  public BigInteger getIterations()
  {
    return this.iterations.getValue();
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.iv);
    localASN1EncodableVector.add(this.iterations);
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\pkcs\PKCS12PBEParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */