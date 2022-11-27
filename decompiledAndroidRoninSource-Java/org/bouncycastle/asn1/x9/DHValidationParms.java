package org.bouncycastle.asn1.x9;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERSequence;

public class DHValidationParms
  extends ASN1Object
{
  private ASN1Integer pgenCounter;
  private DERBitString seed;
  
  private DHValidationParms(ASN1Sequence paramASN1Sequence)
  {
    if (paramASN1Sequence.size() == 2)
    {
      this.seed = DERBitString.getInstance(paramASN1Sequence.getObjectAt(0));
      this.pgenCounter = ASN1Integer.getInstance(paramASN1Sequence.getObjectAt(1));
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Bad sequence size: ");
    localStringBuilder.append(paramASN1Sequence.size());
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public DHValidationParms(DERBitString paramDERBitString, ASN1Integer paramASN1Integer)
  {
    if (paramDERBitString != null)
    {
      if (paramASN1Integer != null)
      {
        this.seed = paramDERBitString;
        this.pgenCounter = paramASN1Integer;
        return;
      }
      throw new IllegalArgumentException("'pgenCounter' cannot be null");
    }
    throw new IllegalArgumentException("'seed' cannot be null");
  }
  
  public static DHValidationParms getInstance(Object paramObject)
  {
    if ((paramObject instanceof DHValidationParms)) {
      return (DHValidationParms)paramObject;
    }
    if (paramObject != null) {
      return new DHValidationParms(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public static DHValidationParms getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    return getInstance(ASN1Sequence.getInstance(paramASN1TaggedObject, paramBoolean));
  }
  
  public ASN1Integer getPgenCounter()
  {
    return this.pgenCounter;
  }
  
  public DERBitString getSeed()
  {
    return this.seed;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.seed);
    localASN1EncodableVector.add(this.pgenCounter);
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\asn1\x9\DHValidationParms.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */