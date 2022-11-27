package org.bouncycastle.asn1.esf;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

public class CommitmentTypeQualifier
  extends ASN1Object
{
  private ASN1ObjectIdentifier commitmentTypeIdentifier;
  private ASN1Encodable qualifier;
  
  public CommitmentTypeQualifier(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
  {
    this(paramASN1ObjectIdentifier, null);
  }
  
  public CommitmentTypeQualifier(ASN1ObjectIdentifier paramASN1ObjectIdentifier, ASN1Encodable paramASN1Encodable)
  {
    this.commitmentTypeIdentifier = paramASN1ObjectIdentifier;
    this.qualifier = paramASN1Encodable;
  }
  
  private CommitmentTypeQualifier(ASN1Sequence paramASN1Sequence)
  {
    this.commitmentTypeIdentifier = ((ASN1ObjectIdentifier)paramASN1Sequence.getObjectAt(0));
    if (paramASN1Sequence.size() > 1) {
      this.qualifier = paramASN1Sequence.getObjectAt(1);
    }
  }
  
  public static CommitmentTypeQualifier getInstance(Object paramObject)
  {
    if ((paramObject instanceof CommitmentTypeQualifier)) {
      return (CommitmentTypeQualifier)paramObject;
    }
    if (paramObject != null) {
      return new CommitmentTypeQualifier(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public ASN1ObjectIdentifier getCommitmentTypeIdentifier()
  {
    return this.commitmentTypeIdentifier;
  }
  
  public ASN1Encodable getQualifier()
  {
    return this.qualifier;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.commitmentTypeIdentifier);
    ASN1Encodable localASN1Encodable = this.qualifier;
    if (localASN1Encodable != null) {
      localASN1EncodableVector.add(localASN1Encodable);
    }
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\esf\CommitmentTypeQualifier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */