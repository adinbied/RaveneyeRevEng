package org.bouncycastle.asn1.x509;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Boolean;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;

public class BasicConstraints
  extends ASN1Object
{
  ASN1Boolean cA = ASN1Boolean.getInstance(false);
  ASN1Integer pathLenConstraint = null;
  
  public BasicConstraints(int paramInt)
  {
    this.cA = ASN1Boolean.getInstance(true);
    this.pathLenConstraint = new ASN1Integer(paramInt);
  }
  
  private BasicConstraints(ASN1Sequence paramASN1Sequence)
  {
    if (paramASN1Sequence.size() == 0)
    {
      this.cA = null;
      this.pathLenConstraint = null;
      return;
    }
    if ((paramASN1Sequence.getObjectAt(0) instanceof ASN1Boolean))
    {
      this.cA = ASN1Boolean.getInstance(paramASN1Sequence.getObjectAt(0));
    }
    else
    {
      this.cA = null;
      this.pathLenConstraint = ASN1Integer.getInstance(paramASN1Sequence.getObjectAt(0));
    }
    if (paramASN1Sequence.size() > 1)
    {
      if (this.cA != null)
      {
        this.pathLenConstraint = ASN1Integer.getInstance(paramASN1Sequence.getObjectAt(1));
        return;
      }
      throw new IllegalArgumentException("wrong sequence in constructor");
    }
  }
  
  public BasicConstraints(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.cA = ASN1Boolean.getInstance(true);
    } else {
      this.cA = null;
    }
    this.pathLenConstraint = null;
  }
  
  public static BasicConstraints fromExtensions(Extensions paramExtensions)
  {
    return getInstance(paramExtensions.getExtensionParsedValue(Extension.basicConstraints));
  }
  
  public static BasicConstraints getInstance(Object paramObject)
  {
    if ((paramObject instanceof BasicConstraints)) {
      return (BasicConstraints)paramObject;
    }
    if ((paramObject instanceof X509Extension)) {
      return getInstance(X509Extension.convertValueToObject((X509Extension)paramObject));
    }
    if (paramObject != null) {
      return new BasicConstraints(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public static BasicConstraints getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    return getInstance(ASN1Sequence.getInstance(paramASN1TaggedObject, paramBoolean));
  }
  
  public BigInteger getPathLenConstraint()
  {
    ASN1Integer localASN1Integer = this.pathLenConstraint;
    if (localASN1Integer != null) {
      return localASN1Integer.getValue();
    }
    return null;
  }
  
  public boolean isCA()
  {
    ASN1Boolean localASN1Boolean = this.cA;
    return (localASN1Boolean != null) && (localASN1Boolean.isTrue());
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    Object localObject = this.cA;
    if (localObject != null) {
      localASN1EncodableVector.add((ASN1Encodable)localObject);
    }
    localObject = this.pathLenConstraint;
    if (localObject != null) {
      localASN1EncodableVector.add((ASN1Encodable)localObject);
    }
    return new DERSequence(localASN1EncodableVector);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder;
    if (this.pathLenConstraint == null)
    {
      if (this.cA == null) {
        return "BasicConstraints: isCa(false)";
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("BasicConstraints: isCa(");
      localStringBuilder.append(isCA());
      localStringBuilder.append(")");
    }
    for (;;)
    {
      return localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("BasicConstraints: isCa(");
      localStringBuilder.append(isCA());
      localStringBuilder.append("), pathLenConstraint = ");
      localStringBuilder.append(this.pathLenConstraint.getValue());
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\asn1\x509\BasicConstraints.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */