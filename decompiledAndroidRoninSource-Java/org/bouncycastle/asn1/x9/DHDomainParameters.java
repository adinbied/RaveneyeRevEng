package org.bouncycastle.asn1.x9;

import java.math.BigInteger;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;

public class DHDomainParameters
  extends ASN1Object
{
  private ASN1Integer g;
  private ASN1Integer j;
  private ASN1Integer p;
  private ASN1Integer q;
  private DHValidationParms validationParms;
  
  public DHDomainParameters(BigInteger paramBigInteger1, BigInteger paramBigInteger2, BigInteger paramBigInteger3, BigInteger paramBigInteger4, DHValidationParms paramDHValidationParms)
  {
    if (paramBigInteger1 != null)
    {
      if (paramBigInteger2 != null)
      {
        if (paramBigInteger3 != null)
        {
          this.p = new ASN1Integer(paramBigInteger1);
          this.g = new ASN1Integer(paramBigInteger2);
          this.q = new ASN1Integer(paramBigInteger3);
          this.j = new ASN1Integer(paramBigInteger4);
          this.validationParms = paramDHValidationParms;
          return;
        }
        throw new IllegalArgumentException("'q' cannot be null");
      }
      throw new IllegalArgumentException("'g' cannot be null");
    }
    throw new IllegalArgumentException("'p' cannot be null");
  }
  
  public DHDomainParameters(ASN1Integer paramASN1Integer1, ASN1Integer paramASN1Integer2, ASN1Integer paramASN1Integer3, ASN1Integer paramASN1Integer4, DHValidationParms paramDHValidationParms)
  {
    if (paramASN1Integer1 != null)
    {
      if (paramASN1Integer2 != null)
      {
        if (paramASN1Integer3 != null)
        {
          this.p = paramASN1Integer1;
          this.g = paramASN1Integer2;
          this.q = paramASN1Integer3;
          this.j = paramASN1Integer4;
          this.validationParms = paramDHValidationParms;
          return;
        }
        throw new IllegalArgumentException("'q' cannot be null");
      }
      throw new IllegalArgumentException("'g' cannot be null");
    }
    throw new IllegalArgumentException("'p' cannot be null");
  }
  
  private DHDomainParameters(ASN1Sequence paramASN1Sequence)
  {
    if ((paramASN1Sequence.size() >= 3) && (paramASN1Sequence.size() <= 5))
    {
      Enumeration localEnumeration = paramASN1Sequence.getObjects();
      this.p = ASN1Integer.getInstance(localEnumeration.nextElement());
      this.g = ASN1Integer.getInstance(localEnumeration.nextElement());
      this.q = ASN1Integer.getInstance(localEnumeration.nextElement());
      localObject = getNext(localEnumeration);
      paramASN1Sequence = (ASN1Sequence)localObject;
      if (localObject != null)
      {
        paramASN1Sequence = (ASN1Sequence)localObject;
        if ((localObject instanceof ASN1Integer))
        {
          this.j = ASN1Integer.getInstance(localObject);
          paramASN1Sequence = getNext(localEnumeration);
        }
      }
      if (paramASN1Sequence != null) {
        this.validationParms = DHValidationParms.getInstance(paramASN1Sequence.toASN1Primitive());
      }
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Bad sequence size: ");
    ((StringBuilder)localObject).append(paramASN1Sequence.size());
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public static DHDomainParameters getInstance(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof DHDomainParameters)))
    {
      if ((paramObject instanceof ASN1Sequence)) {
        return new DHDomainParameters((ASN1Sequence)paramObject);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Invalid DHDomainParameters: ");
      localStringBuilder.append(paramObject.getClass().getName());
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return (DHDomainParameters)paramObject;
  }
  
  public static DHDomainParameters getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    return getInstance(ASN1Sequence.getInstance(paramASN1TaggedObject, paramBoolean));
  }
  
  private static ASN1Encodable getNext(Enumeration paramEnumeration)
  {
    if (paramEnumeration.hasMoreElements()) {
      return (ASN1Encodable)paramEnumeration.nextElement();
    }
    return null;
  }
  
  public ASN1Integer getG()
  {
    return this.g;
  }
  
  public ASN1Integer getJ()
  {
    return this.j;
  }
  
  public ASN1Integer getP()
  {
    return this.p;
  }
  
  public ASN1Integer getQ()
  {
    return this.q;
  }
  
  public DHValidationParms getValidationParms()
  {
    return this.validationParms;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.p);
    localASN1EncodableVector.add(this.g);
    localASN1EncodableVector.add(this.q);
    Object localObject = this.j;
    if (localObject != null) {
      localASN1EncodableVector.add((ASN1Encodable)localObject);
    }
    localObject = this.validationParms;
    if (localObject != null) {
      localASN1EncodableVector.add((ASN1Encodable)localObject);
    }
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\asn1\x9\DHDomainParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */