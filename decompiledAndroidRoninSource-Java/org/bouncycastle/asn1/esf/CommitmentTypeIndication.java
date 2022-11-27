package org.bouncycastle.asn1.esf;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

public class CommitmentTypeIndication
  extends ASN1Object
{
  private ASN1ObjectIdentifier commitmentTypeId;
  private ASN1Sequence commitmentTypeQualifier;
  
  public CommitmentTypeIndication(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
  {
    this.commitmentTypeId = paramASN1ObjectIdentifier;
  }
  
  public CommitmentTypeIndication(ASN1ObjectIdentifier paramASN1ObjectIdentifier, ASN1Sequence paramASN1Sequence)
  {
    this.commitmentTypeId = paramASN1ObjectIdentifier;
    this.commitmentTypeQualifier = paramASN1Sequence;
  }
  
  private CommitmentTypeIndication(ASN1Sequence paramASN1Sequence)
  {
    this.commitmentTypeId = ((ASN1ObjectIdentifier)paramASN1Sequence.getObjectAt(0));
    if (paramASN1Sequence.size() > 1) {
      this.commitmentTypeQualifier = ((ASN1Sequence)paramASN1Sequence.getObjectAt(1));
    }
  }
  
  public static CommitmentTypeIndication getInstance(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof CommitmentTypeIndication))) {
      return new CommitmentTypeIndication(ASN1Sequence.getInstance(paramObject));
    }
    return (CommitmentTypeIndication)paramObject;
  }
  
  public ASN1ObjectIdentifier getCommitmentTypeId()
  {
    return this.commitmentTypeId;
  }
  
  public ASN1Sequence getCommitmentTypeQualifier()
  {
    return this.commitmentTypeQualifier;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.commitmentTypeId);
    ASN1Sequence localASN1Sequence = this.commitmentTypeQualifier;
    if (localASN1Sequence != null) {
      localASN1EncodableVector.add(localASN1Sequence);
    }
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\esf\CommitmentTypeIndication.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */