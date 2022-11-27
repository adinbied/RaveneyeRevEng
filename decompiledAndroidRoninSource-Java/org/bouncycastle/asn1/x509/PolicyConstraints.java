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

public class PolicyConstraints
  extends ASN1Object
{
  private BigInteger inhibitPolicyMapping;
  private BigInteger requireExplicitPolicyMapping;
  
  public PolicyConstraints(BigInteger paramBigInteger1, BigInteger paramBigInteger2)
  {
    this.requireExplicitPolicyMapping = paramBigInteger1;
    this.inhibitPolicyMapping = paramBigInteger2;
  }
  
  private PolicyConstraints(ASN1Sequence paramASN1Sequence)
  {
    int i = 0;
    while (i != paramASN1Sequence.size())
    {
      ASN1TaggedObject localASN1TaggedObject = ASN1TaggedObject.getInstance(paramASN1Sequence.getObjectAt(i));
      if (localASN1TaggedObject.getTagNo() == 0)
      {
        this.requireExplicitPolicyMapping = ASN1Integer.getInstance(localASN1TaggedObject, false).getValue();
      }
      else
      {
        if (localASN1TaggedObject.getTagNo() != 1) {
          break label72;
        }
        this.inhibitPolicyMapping = ASN1Integer.getInstance(localASN1TaggedObject, false).getValue();
      }
      i += 1;
      continue;
      label72:
      throw new IllegalArgumentException("Unknown tag encountered.");
    }
  }
  
  public static PolicyConstraints fromExtensions(Extensions paramExtensions)
  {
    return getInstance(paramExtensions.getExtensionParsedValue(Extension.policyConstraints));
  }
  
  public static PolicyConstraints getInstance(Object paramObject)
  {
    if ((paramObject instanceof PolicyConstraints)) {
      return (PolicyConstraints)paramObject;
    }
    if (paramObject != null) {
      return new PolicyConstraints(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public BigInteger getInhibitPolicyMapping()
  {
    return this.inhibitPolicyMapping;
  }
  
  public BigInteger getRequireExplicitPolicyMapping()
  {
    return this.requireExplicitPolicyMapping;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    BigInteger localBigInteger = this.requireExplicitPolicyMapping;
    if (localBigInteger != null) {
      localASN1EncodableVector.add(new DERTaggedObject(false, 0, new ASN1Integer(localBigInteger)));
    }
    localBigInteger = this.inhibitPolicyMapping;
    if (localBigInteger != null) {
      localASN1EncodableVector.add(new DERTaggedObject(false, 1, new ASN1Integer(localBigInteger)));
    }
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\asn1\x509\PolicyConstraints.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */