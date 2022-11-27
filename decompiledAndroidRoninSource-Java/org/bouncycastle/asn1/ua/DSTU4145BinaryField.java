package org.bouncycastle.asn1.ua;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

public class DSTU4145BinaryField
  extends ASN1Object
{
  private int j;
  private int k;
  private int l;
  private int m;
  
  public DSTU4145BinaryField(int paramInt1, int paramInt2)
  {
    this(paramInt1, paramInt2, 0, 0);
  }
  
  public DSTU4145BinaryField(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.m = paramInt1;
    this.k = paramInt2;
    this.j = paramInt3;
    this.l = paramInt4;
  }
  
  private DSTU4145BinaryField(ASN1Sequence paramASN1Sequence)
  {
    this.m = ASN1Integer.getInstance(paramASN1Sequence.getObjectAt(0)).getPositiveValue().intValue();
    if ((paramASN1Sequence.getObjectAt(1) instanceof ASN1Integer))
    {
      this.k = ((ASN1Integer)paramASN1Sequence.getObjectAt(1)).getPositiveValue().intValue();
      return;
    }
    if ((paramASN1Sequence.getObjectAt(1) instanceof ASN1Sequence))
    {
      paramASN1Sequence = ASN1Sequence.getInstance(paramASN1Sequence.getObjectAt(1));
      this.k = ASN1Integer.getInstance(paramASN1Sequence.getObjectAt(0)).getPositiveValue().intValue();
      this.j = ASN1Integer.getInstance(paramASN1Sequence.getObjectAt(1)).getPositiveValue().intValue();
      this.l = ASN1Integer.getInstance(paramASN1Sequence.getObjectAt(2)).getPositiveValue().intValue();
      return;
    }
    throw new IllegalArgumentException("object parse error");
  }
  
  public static DSTU4145BinaryField getInstance(Object paramObject)
  {
    if ((paramObject instanceof DSTU4145BinaryField)) {
      return (DSTU4145BinaryField)paramObject;
    }
    if (paramObject != null) {
      return new DSTU4145BinaryField(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public int getK1()
  {
    return this.k;
  }
  
  public int getK2()
  {
    return this.j;
  }
  
  public int getK3()
  {
    return this.l;
  }
  
  public int getM()
  {
    return this.m;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector1 = new ASN1EncodableVector();
    localASN1EncodableVector1.add(new ASN1Integer(this.m));
    if (this.j == 0)
    {
      localASN1EncodableVector1.add(new ASN1Integer(this.k));
    }
    else
    {
      ASN1EncodableVector localASN1EncodableVector2 = new ASN1EncodableVector();
      localASN1EncodableVector2.add(new ASN1Integer(this.k));
      localASN1EncodableVector2.add(new ASN1Integer(this.j));
      localASN1EncodableVector2.add(new ASN1Integer(this.l));
      localASN1EncodableVector1.add(new DERSequence(localASN1EncodableVector2));
    }
    return new DERSequence(localASN1EncodableVector1);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn\\ua\DSTU4145BinaryField.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */