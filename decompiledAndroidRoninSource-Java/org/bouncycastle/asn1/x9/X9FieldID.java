package org.bouncycastle.asn1.x9;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

public class X9FieldID
  extends ASN1Object
  implements X9ObjectIdentifiers
{
  private ASN1ObjectIdentifier id;
  private ASN1Primitive parameters;
  
  public X9FieldID(int paramInt1, int paramInt2)
  {
    this(paramInt1, paramInt2, 0, 0);
  }
  
  public X9FieldID(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.id = characteristic_two_field;
    ASN1EncodableVector localASN1EncodableVector1 = new ASN1EncodableVector();
    localASN1EncodableVector1.add(new ASN1Integer(paramInt1));
    if (paramInt3 == 0)
    {
      if (paramInt4 == 0)
      {
        localASN1EncodableVector1.add(tpBasis);
        localASN1EncodableVector1.add(new ASN1Integer(paramInt2));
      }
      else
      {
        throw new IllegalArgumentException("inconsistent k values");
      }
    }
    else
    {
      if ((paramInt3 <= paramInt2) || (paramInt4 <= paramInt3)) {
        break label177;
      }
      localASN1EncodableVector1.add(ppBasis);
      ASN1EncodableVector localASN1EncodableVector2 = new ASN1EncodableVector();
      localASN1EncodableVector2.add(new ASN1Integer(paramInt2));
      localASN1EncodableVector2.add(new ASN1Integer(paramInt3));
      localASN1EncodableVector2.add(new ASN1Integer(paramInt4));
      localASN1EncodableVector1.add(new DERSequence(localASN1EncodableVector2));
    }
    this.parameters = new DERSequence(localASN1EncodableVector1);
    return;
    label177:
    throw new IllegalArgumentException("inconsistent k values");
  }
  
  public X9FieldID(BigInteger paramBigInteger)
  {
    this.id = prime_field;
    this.parameters = new ASN1Integer(paramBigInteger);
  }
  
  private X9FieldID(ASN1Sequence paramASN1Sequence)
  {
    this.id = ASN1ObjectIdentifier.getInstance(paramASN1Sequence.getObjectAt(0));
    this.parameters = paramASN1Sequence.getObjectAt(1).toASN1Primitive();
  }
  
  public static X9FieldID getInstance(Object paramObject)
  {
    if ((paramObject instanceof X9FieldID)) {
      return (X9FieldID)paramObject;
    }
    if (paramObject != null) {
      return new X9FieldID(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public ASN1ObjectIdentifier getIdentifier()
  {
    return this.id;
  }
  
  public ASN1Primitive getParameters()
  {
    return this.parameters;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.id);
    localASN1EncodableVector.add(this.parameters);
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\asn1\x9\X9FieldID.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */