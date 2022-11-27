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

public class PBEParameter
  extends ASN1Object
{
  ASN1Integer iterations;
  ASN1OctetString salt;
  
  private PBEParameter(ASN1Sequence paramASN1Sequence)
  {
    this.salt = ((ASN1OctetString)paramASN1Sequence.getObjectAt(0));
    this.iterations = ((ASN1Integer)paramASN1Sequence.getObjectAt(1));
  }
  
  public PBEParameter(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte.length == 8)
    {
      this.salt = new DEROctetString(paramArrayOfByte);
      this.iterations = new ASN1Integer(paramInt);
      return;
    }
    throw new IllegalArgumentException("salt length must be 8");
  }
  
  public static PBEParameter getInstance(Object paramObject)
  {
    if ((paramObject instanceof PBEParameter)) {
      return (PBEParameter)paramObject;
    }
    if (paramObject != null) {
      return new PBEParameter(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public BigInteger getIterationCount()
  {
    return this.iterations.getValue();
  }
  
  public byte[] getSalt()
  {
    return this.salt.getOctets();
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.salt);
    localASN1EncodableVector.add(this.iterations);
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\pkcs\PBEParameter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */