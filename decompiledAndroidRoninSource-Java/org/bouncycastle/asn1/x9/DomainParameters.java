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

public class DomainParameters
  extends ASN1Object
{
  private final ASN1Integer g;
  private final ASN1Integer j;
  private final ASN1Integer p;
  private final ASN1Integer q;
  private final ValidationParams validationParams;
  
  public DomainParameters(BigInteger paramBigInteger1, BigInteger paramBigInteger2, BigInteger paramBigInteger3, BigInteger paramBigInteger4, ValidationParams paramValidationParams)
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
          if (paramBigInteger4 != null) {
            paramBigInteger1 = new ASN1Integer(paramBigInteger4);
          } else {
            paramBigInteger1 = null;
          }
          this.j = paramBigInteger1;
          this.validationParams = paramValidationParams;
          return;
        }
        throw new IllegalArgumentException("'q' cannot be null");
      }
      throw new IllegalArgumentException("'g' cannot be null");
    }
    throw new IllegalArgumentException("'p' cannot be null");
  }
  
  private DomainParameters(ASN1Sequence paramASN1Sequence)
  {
    if ((paramASN1Sequence.size() >= 3) && (paramASN1Sequence.size() <= 5))
    {
      localObject = paramASN1Sequence.getObjects();
      this.p = ASN1Integer.getInstance(((Enumeration)localObject).nextElement());
      this.g = ASN1Integer.getInstance(((Enumeration)localObject).nextElement());
      this.q = ASN1Integer.getInstance(((Enumeration)localObject).nextElement());
      paramASN1Sequence = getNext((Enumeration)localObject);
      if ((paramASN1Sequence != null) && ((paramASN1Sequence instanceof ASN1Integer)))
      {
        this.j = ASN1Integer.getInstance(paramASN1Sequence);
        paramASN1Sequence = getNext((Enumeration)localObject);
      }
      else
      {
        this.j = null;
      }
      if (paramASN1Sequence != null)
      {
        this.validationParams = ValidationParams.getInstance(paramASN1Sequence.toASN1Primitive());
        return;
      }
      this.validationParams = null;
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Bad sequence size: ");
    ((StringBuilder)localObject).append(paramASN1Sequence.size());
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public static DomainParameters getInstance(Object paramObject)
  {
    if ((paramObject instanceof DomainParameters)) {
      return (DomainParameters)paramObject;
    }
    if (paramObject != null) {
      return new DomainParameters(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public static DomainParameters getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
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
  
  public BigInteger getG()
  {
    return this.g.getPositiveValue();
  }
  
  public BigInteger getJ()
  {
    ASN1Integer localASN1Integer = this.j;
    if (localASN1Integer == null) {
      return null;
    }
    return localASN1Integer.getPositiveValue();
  }
  
  public BigInteger getP()
  {
    return this.p.getPositiveValue();
  }
  
  public BigInteger getQ()
  {
    return this.q.getPositiveValue();
  }
  
  public ValidationParams getValidationParams()
  {
    return this.validationParams;
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
    localObject = this.validationParams;
    if (localObject != null) {
      localASN1EncodableVector.add((ASN1Encodable)localObject);
    }
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\asn1\x9\DomainParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */