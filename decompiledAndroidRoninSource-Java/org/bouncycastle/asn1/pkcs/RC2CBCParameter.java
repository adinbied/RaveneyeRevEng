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

public class RC2CBCParameter
  extends ASN1Object
{
  ASN1OctetString iv;
  ASN1Integer version;
  
  public RC2CBCParameter(int paramInt, byte[] paramArrayOfByte)
  {
    this.version = new ASN1Integer(paramInt);
    this.iv = new DEROctetString(paramArrayOfByte);
  }
  
  private RC2CBCParameter(ASN1Sequence paramASN1Sequence)
  {
    if (paramASN1Sequence.size() == 1)
    {
      this.version = null;
      paramASN1Sequence = paramASN1Sequence.getObjectAt(0);
    }
    else
    {
      this.version = ((ASN1Integer)paramASN1Sequence.getObjectAt(0));
      paramASN1Sequence = paramASN1Sequence.getObjectAt(1);
    }
    this.iv = ((ASN1OctetString)paramASN1Sequence);
  }
  
  public RC2CBCParameter(byte[] paramArrayOfByte)
  {
    this.version = null;
    this.iv = new DEROctetString(paramArrayOfByte);
  }
  
  public static RC2CBCParameter getInstance(Object paramObject)
  {
    if ((paramObject instanceof RC2CBCParameter)) {
      return (RC2CBCParameter)paramObject;
    }
    if (paramObject != null) {
      return new RC2CBCParameter(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public byte[] getIV()
  {
    return this.iv.getOctets();
  }
  
  public BigInteger getRC2ParameterVersion()
  {
    ASN1Integer localASN1Integer = this.version;
    if (localASN1Integer == null) {
      return null;
    }
    return localASN1Integer.getValue();
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    ASN1Integer localASN1Integer = this.version;
    if (localASN1Integer != null) {
      localASN1EncodableVector.add(localASN1Integer);
    }
    localASN1EncodableVector.add(this.iv);
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\pkcs\RC2CBCParameter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */