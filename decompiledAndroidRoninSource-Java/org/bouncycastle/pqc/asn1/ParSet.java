package org.bouncycastle.pqc.asn1;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.util.Arrays;

public class ParSet
  extends ASN1Object
{
  private static final BigInteger ZERO = BigInteger.valueOf(0L);
  private int[] h;
  private int[] k;
  private int t;
  private int[] w;
  
  public ParSet(int paramInt, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    this.t = paramInt;
    this.h = paramArrayOfInt1;
    this.w = paramArrayOfInt2;
    this.k = paramArrayOfInt3;
  }
  
  private ParSet(ASN1Sequence paramASN1Sequence)
  {
    if (paramASN1Sequence.size() == 4)
    {
      int i = 0;
      this.t = checkBigIntegerInIntRangeAndPositive(((ASN1Integer)paramASN1Sequence.getObjectAt(0)).getValue());
      localObject = (ASN1Sequence)paramASN1Sequence.getObjectAt(1);
      ASN1Sequence localASN1Sequence = (ASN1Sequence)paramASN1Sequence.getObjectAt(2);
      paramASN1Sequence = (ASN1Sequence)paramASN1Sequence.getObjectAt(3);
      if ((((ASN1Sequence)localObject).size() == this.t) && (localASN1Sequence.size() == this.t) && (paramASN1Sequence.size() == this.t))
      {
        this.h = new int[((ASN1Sequence)localObject).size()];
        this.w = new int[localASN1Sequence.size()];
        this.k = new int[paramASN1Sequence.size()];
        while (i < this.t)
        {
          this.h[i] = checkBigIntegerInIntRangeAndPositive(((ASN1Integer)((ASN1Sequence)localObject).getObjectAt(i)).getValue());
          this.w[i] = checkBigIntegerInIntRangeAndPositive(((ASN1Integer)localASN1Sequence.getObjectAt(i)).getValue());
          this.k[i] = checkBigIntegerInIntRangeAndPositive(((ASN1Integer)paramASN1Sequence.getObjectAt(i)).getValue());
          i += 1;
        }
        return;
      }
      throw new IllegalArgumentException("invalid size of sequences");
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("sie of seqOfParams = ");
    ((StringBuilder)localObject).append(paramASN1Sequence.size());
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  private static int checkBigIntegerInIntRangeAndPositive(BigInteger paramBigInteger)
  {
    if ((paramBigInteger.compareTo(BigInteger.valueOf(2147483647L)) <= 0) && (paramBigInteger.compareTo(ZERO) > 0)) {
      return paramBigInteger.intValue();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("BigInteger not in Range: ");
    localStringBuilder.append(paramBigInteger.toString());
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public static ParSet getInstance(Object paramObject)
  {
    if ((paramObject instanceof ParSet)) {
      return (ParSet)paramObject;
    }
    if (paramObject != null) {
      return new ParSet(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public int[] getH()
  {
    return Arrays.clone(this.h);
  }
  
  public int[] getK()
  {
    return Arrays.clone(this.k);
  }
  
  public int getT()
  {
    return this.t;
  }
  
  public int[] getW()
  {
    return Arrays.clone(this.w);
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector1 = new ASN1EncodableVector();
    ASN1EncodableVector localASN1EncodableVector2 = new ASN1EncodableVector();
    ASN1EncodableVector localASN1EncodableVector3 = new ASN1EncodableVector();
    int i = 0;
    for (;;)
    {
      localObject = this.h;
      if (i >= localObject.length) {
        break;
      }
      localASN1EncodableVector1.add(new ASN1Integer(localObject[i]));
      localASN1EncodableVector2.add(new ASN1Integer(this.w[i]));
      localASN1EncodableVector3.add(new ASN1Integer(this.k[i]));
      i += 1;
    }
    Object localObject = new ASN1EncodableVector();
    ((ASN1EncodableVector)localObject).add(new ASN1Integer(this.t));
    ((ASN1EncodableVector)localObject).add(new DERSequence(localASN1EncodableVector1));
    ((ASN1EncodableVector)localObject).add(new DERSequence(localASN1EncodableVector2));
    ((ASN1EncodableVector)localObject).add(new DERSequence(localASN1EncodableVector3));
    return new DERSequence((ASN1EncodableVector)localObject);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\asn1\ParSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */