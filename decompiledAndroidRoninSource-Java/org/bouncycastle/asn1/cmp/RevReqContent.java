package org.bouncycastle.asn1.cmp;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

public class RevReqContent
  extends ASN1Object
{
  private ASN1Sequence content;
  
  private RevReqContent(ASN1Sequence paramASN1Sequence)
  {
    this.content = paramASN1Sequence;
  }
  
  public RevReqContent(RevDetails paramRevDetails)
  {
    this.content = new DERSequence(paramRevDetails);
  }
  
  public RevReqContent(RevDetails[] paramArrayOfRevDetails)
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    int i = 0;
    while (i != paramArrayOfRevDetails.length)
    {
      localASN1EncodableVector.add(paramArrayOfRevDetails[i]);
      i += 1;
    }
    this.content = new DERSequence(localASN1EncodableVector);
  }
  
  public static RevReqContent getInstance(Object paramObject)
  {
    if ((paramObject instanceof RevReqContent)) {
      return (RevReqContent)paramObject;
    }
    if (paramObject != null) {
      return new RevReqContent(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    return this.content;
  }
  
  public RevDetails[] toRevDetailsArray()
  {
    int j = this.content.size();
    RevDetails[] arrayOfRevDetails = new RevDetails[j];
    int i = 0;
    while (i != j)
    {
      arrayOfRevDetails[i] = RevDetails.getInstance(this.content.getObjectAt(i));
      i += 1;
    }
    return arrayOfRevDetails;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cmp\RevReqContent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */