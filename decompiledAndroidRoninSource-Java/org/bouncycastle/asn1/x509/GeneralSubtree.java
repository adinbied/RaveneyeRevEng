package org.bouncycastle.asn1.x509;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;

public class GeneralSubtree
  extends ASN1Object
{
  private static final BigInteger ZERO = BigInteger.valueOf(0L);
  private GeneralName base;
  private ASN1Integer maximum;
  private ASN1Integer minimum;
  
  private GeneralSubtree(ASN1Sequence paramASN1Sequence)
  {
    this.base = GeneralName.getInstance(paramASN1Sequence.getObjectAt(0));
    int i = paramASN1Sequence.size();
    if (i != 1)
    {
      if (i != 2)
      {
        if (i == 3)
        {
          localObject = ASN1TaggedObject.getInstance(paramASN1Sequence.getObjectAt(1));
          if (((ASN1TaggedObject)localObject).getTagNo() == 0)
          {
            this.minimum = ASN1Integer.getInstance((ASN1TaggedObject)localObject, false);
            paramASN1Sequence = ASN1TaggedObject.getInstance(paramASN1Sequence.getObjectAt(2));
            if (paramASN1Sequence.getTagNo() != 1)
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("Bad tag number for 'maximum': ");
              ((StringBuilder)localObject).append(paramASN1Sequence.getTagNo());
              throw new IllegalArgumentException(((StringBuilder)localObject).toString());
            }
          }
          else
          {
            paramASN1Sequence = new StringBuilder();
            paramASN1Sequence.append("Bad tag number for 'minimum': ");
            paramASN1Sequence.append(((ASN1TaggedObject)localObject).getTagNo());
            throw new IllegalArgumentException(paramASN1Sequence.toString());
          }
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Bad sequence size: ");
          ((StringBuilder)localObject).append(paramASN1Sequence.size());
          throw new IllegalArgumentException(((StringBuilder)localObject).toString());
        }
      }
      else
      {
        paramASN1Sequence = ASN1TaggedObject.getInstance(paramASN1Sequence.getObjectAt(1));
        i = paramASN1Sequence.getTagNo();
        if (i == 0) {
          break label258;
        }
        if (i != 1) {
          break label222;
        }
      }
      this.maximum = ASN1Integer.getInstance(paramASN1Sequence, false);
      return;
      label222:
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Bad tag number: ");
      ((StringBuilder)localObject).append(paramASN1Sequence.getTagNo());
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
      label258:
      this.minimum = ASN1Integer.getInstance(paramASN1Sequence, false);
    }
  }
  
  public GeneralSubtree(GeneralName paramGeneralName)
  {
    this(paramGeneralName, null, null);
  }
  
  public GeneralSubtree(GeneralName paramGeneralName, BigInteger paramBigInteger1, BigInteger paramBigInteger2)
  {
    this.base = paramGeneralName;
    if (paramBigInteger2 != null) {
      this.maximum = new ASN1Integer(paramBigInteger2);
    }
    if (paramBigInteger1 == null) {
      paramGeneralName = null;
    } else {
      paramGeneralName = new ASN1Integer(paramBigInteger1);
    }
    this.minimum = paramGeneralName;
  }
  
  public static GeneralSubtree getInstance(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    if ((paramObject instanceof GeneralSubtree)) {
      return (GeneralSubtree)paramObject;
    }
    return new GeneralSubtree(ASN1Sequence.getInstance(paramObject));
  }
  
  public static GeneralSubtree getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    return new GeneralSubtree(ASN1Sequence.getInstance(paramASN1TaggedObject, paramBoolean));
  }
  
  public GeneralName getBase()
  {
    return this.base;
  }
  
  public BigInteger getMaximum()
  {
    ASN1Integer localASN1Integer = this.maximum;
    if (localASN1Integer == null) {
      return null;
    }
    return localASN1Integer.getValue();
  }
  
  public BigInteger getMinimum()
  {
    ASN1Integer localASN1Integer = this.minimum;
    if (localASN1Integer == null) {
      return ZERO;
    }
    return localASN1Integer.getValue();
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.base);
    ASN1Integer localASN1Integer = this.minimum;
    if ((localASN1Integer != null) && (!localASN1Integer.getValue().equals(ZERO))) {
      localASN1EncodableVector.add(new DERTaggedObject(false, 0, this.minimum));
    }
    localASN1Integer = this.maximum;
    if (localASN1Integer != null) {
      localASN1EncodableVector.add(new DERTaggedObject(false, 1, localASN1Integer));
    }
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\asn1\x509\GeneralSubtree.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */