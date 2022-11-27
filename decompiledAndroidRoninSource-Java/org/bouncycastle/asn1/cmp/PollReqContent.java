package org.bouncycastle.asn1.cmp;

import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

public class PollReqContent
  extends ASN1Object
{
  private ASN1Sequence content;
  
  public PollReqContent(ASN1Integer paramASN1Integer)
  {
    this(new DERSequence(new DERSequence(paramASN1Integer)));
  }
  
  private PollReqContent(ASN1Sequence paramASN1Sequence)
  {
    this.content = paramASN1Sequence;
  }
  
  public static PollReqContent getInstance(Object paramObject)
  {
    if ((paramObject instanceof PollReqContent)) {
      return (PollReqContent)paramObject;
    }
    if (paramObject != null) {
      return new PollReqContent(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  private static ASN1Integer[] sequenceToASN1IntegerArray(ASN1Sequence paramASN1Sequence)
  {
    int j = paramASN1Sequence.size();
    ASN1Integer[] arrayOfASN1Integer = new ASN1Integer[j];
    int i = 0;
    while (i != j)
    {
      arrayOfASN1Integer[i] = ASN1Integer.getInstance(paramASN1Sequence.getObjectAt(i));
      i += 1;
    }
    return arrayOfASN1Integer;
  }
  
  public ASN1Integer[][] getCertReqIds()
  {
    int j = this.content.size();
    ASN1Integer[][] arrayOfASN1Integer = new ASN1Integer[j][];
    int i = 0;
    while (i != j)
    {
      arrayOfASN1Integer[i] = sequenceToASN1IntegerArray((ASN1Sequence)this.content.getObjectAt(i));
      i += 1;
    }
    return arrayOfASN1Integer;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    return this.content;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cmp\PollReqContent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */