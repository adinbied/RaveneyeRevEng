package org.bouncycastle.asn1.x9;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.math.ec.ECAlgorithms;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECCurve.F2m;
import org.bouncycastle.math.ec.ECCurve.Fp;
import org.bouncycastle.math.ec.ECFieldElement;

public class X9Curve
  extends ASN1Object
  implements X9ObjectIdentifiers
{
  private ECCurve curve;
  private ASN1ObjectIdentifier fieldIdentifier = null;
  private byte[] seed;
  
  public X9Curve(X9FieldID paramX9FieldID, ASN1Sequence paramASN1Sequence)
  {
    Object localObject = paramX9FieldID.getIdentifier();
    this.fieldIdentifier = ((ASN1ObjectIdentifier)localObject);
    X9FieldElement localX9FieldElement;
    if (((ASN1ObjectIdentifier)localObject).equals(prime_field))
    {
      paramX9FieldID = ((ASN1Integer)paramX9FieldID.getParameters()).getValue();
      localObject = new X9FieldElement(paramX9FieldID, (ASN1OctetString)paramASN1Sequence.getObjectAt(0));
      localX9FieldElement = new X9FieldElement(paramX9FieldID, (ASN1OctetString)paramASN1Sequence.getObjectAt(1));
    }
    int m;
    int k;
    int i;
    int j;
    for (paramX9FieldID = new ECCurve.Fp(paramX9FieldID, ((X9FieldElement)localObject).getValue().toBigInteger(), localX9FieldElement.getValue().toBigInteger());; paramX9FieldID = new ECCurve.F2m(m, k, i, j, paramX9FieldID.getValue().toBigInteger(), ((X9FieldElement)localObject).getValue().toBigInteger()))
    {
      this.curve = paramX9FieldID;
      break;
      if (!this.fieldIdentifier.equals(characteristic_two_field)) {
        break label375;
      }
      paramX9FieldID = ASN1Sequence.getInstance(paramX9FieldID.getParameters());
      m = ((ASN1Integer)paramX9FieldID.getObjectAt(0)).getValue().intValue();
      localObject = (ASN1ObjectIdentifier)paramX9FieldID.getObjectAt(1);
      if (((ASN1ObjectIdentifier)localObject).equals(tpBasis))
      {
        k = ASN1Integer.getInstance(paramX9FieldID.getObjectAt(2)).getValue().intValue();
        i = 0;
        j = 0;
      }
      else
      {
        if (!((ASN1ObjectIdentifier)localObject).equals(ppBasis)) {
          break label365;
        }
        paramX9FieldID = ASN1Sequence.getInstance(paramX9FieldID.getObjectAt(2));
        k = ASN1Integer.getInstance(paramX9FieldID.getObjectAt(0)).getValue().intValue();
        i = ASN1Integer.getInstance(paramX9FieldID.getObjectAt(1)).getValue().intValue();
        j = ASN1Integer.getInstance(paramX9FieldID.getObjectAt(2)).getValue().intValue();
      }
      paramX9FieldID = new X9FieldElement(m, k, i, j, (ASN1OctetString)paramASN1Sequence.getObjectAt(0));
      localObject = new X9FieldElement(m, k, i, j, (ASN1OctetString)paramASN1Sequence.getObjectAt(1));
    }
    if (paramASN1Sequence.size() == 3) {
      this.seed = ((DERBitString)paramASN1Sequence.getObjectAt(2)).getBytes();
    }
    return;
    label365:
    throw new IllegalArgumentException("This type of EC basis is not implemented");
    label375:
    throw new IllegalArgumentException("This type of ECCurve is not implemented");
  }
  
  public X9Curve(ECCurve paramECCurve)
  {
    this.curve = paramECCurve;
    this.seed = null;
    setFieldIdentifier();
  }
  
  public X9Curve(ECCurve paramECCurve, byte[] paramArrayOfByte)
  {
    this.curve = paramECCurve;
    this.seed = paramArrayOfByte;
    setFieldIdentifier();
  }
  
  private void setFieldIdentifier()
  {
    if (ECAlgorithms.isFpCurve(this.curve)) {}
    for (ASN1ObjectIdentifier localASN1ObjectIdentifier = prime_field;; localASN1ObjectIdentifier = characteristic_two_field)
    {
      this.fieldIdentifier = localASN1ObjectIdentifier;
      return;
      if (!ECAlgorithms.isF2mCurve(this.curve)) {
        break;
      }
    }
    throw new IllegalArgumentException("This type of ECCurve is not implemented");
  }
  
  public ECCurve getCurve()
  {
    return this.curve;
  }
  
  public byte[] getSeed()
  {
    return this.seed;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    if (this.fieldIdentifier.equals(prime_field)) {
      localASN1EncodableVector.add(new X9FieldElement(this.curve.getA()).toASN1Primitive());
    }
    for (Object localObject = new X9FieldElement(this.curve.getB());; localObject = new X9FieldElement(this.curve.getB()))
    {
      localASN1EncodableVector.add(((X9FieldElement)localObject).toASN1Primitive());
      break;
      if (!this.fieldIdentifier.equals(characteristic_two_field)) {
        break;
      }
      localASN1EncodableVector.add(new X9FieldElement(this.curve.getA()).toASN1Primitive());
    }
    localObject = this.seed;
    if (localObject != null) {
      localASN1EncodableVector.add(new DERBitString((byte[])localObject));
    }
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\asn1\x9\X9Curve.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */