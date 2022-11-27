package org.bouncycastle.asn1.cmp;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

public class PollRepContent
  extends ASN1Object
{
  private ASN1Integer[] certReqId;
  private ASN1Integer[] checkAfter;
  private PKIFreeText[] reason;
  
  public PollRepContent(ASN1Integer paramASN1Integer1, ASN1Integer paramASN1Integer2)
  {
    this(paramASN1Integer1, paramASN1Integer2, null);
  }
  
  public PollRepContent(ASN1Integer paramASN1Integer1, ASN1Integer paramASN1Integer2, PKIFreeText paramPKIFreeText)
  {
    ASN1Integer[] arrayOfASN1Integer1 = new ASN1Integer[1];
    this.certReqId = arrayOfASN1Integer1;
    ASN1Integer[] arrayOfASN1Integer2 = new ASN1Integer[1];
    this.checkAfter = arrayOfASN1Integer2;
    PKIFreeText[] arrayOfPKIFreeText = new PKIFreeText[1];
    this.reason = arrayOfPKIFreeText;
    arrayOfASN1Integer1[0] = paramASN1Integer1;
    arrayOfASN1Integer2[0] = paramASN1Integer2;
    arrayOfPKIFreeText[0] = paramPKIFreeText;
  }
  
  private PollRepContent(ASN1Sequence paramASN1Sequence)
  {
    this.certReqId = new ASN1Integer[paramASN1Sequence.size()];
    this.checkAfter = new ASN1Integer[paramASN1Sequence.size()];
    this.reason = new PKIFreeText[paramASN1Sequence.size()];
    int i = 0;
    while (i != paramASN1Sequence.size())
    {
      ASN1Sequence localASN1Sequence = ASN1Sequence.getInstance(paramASN1Sequence.getObjectAt(i));
      this.certReqId[i] = ASN1Integer.getInstance(localASN1Sequence.getObjectAt(0));
      this.checkAfter[i] = ASN1Integer.getInstance(localASN1Sequence.getObjectAt(1));
      if (localASN1Sequence.size() > 2) {
        this.reason[i] = PKIFreeText.getInstance(localASN1Sequence.getObjectAt(2));
      }
      i += 1;
    }
  }
  
  public static PollRepContent getInstance(Object paramObject)
  {
    if ((paramObject instanceof PollRepContent)) {
      return (PollRepContent)paramObject;
    }
    if (paramObject != null) {
      return new PollRepContent(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public ASN1Integer getCertReqId(int paramInt)
  {
    return this.certReqId[paramInt];
  }
  
  public ASN1Integer getCheckAfter(int paramInt)
  {
    return this.checkAfter[paramInt];
  }
  
  public PKIFreeText getReason(int paramInt)
  {
    return this.reason[paramInt];
  }
  
  public int size()
  {
    return this.certReqId.length;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector1 = new ASN1EncodableVector();
    int i = 0;
    while (i != this.certReqId.length)
    {
      ASN1EncodableVector localASN1EncodableVector2 = new ASN1EncodableVector();
      localASN1EncodableVector2.add(this.certReqId[i]);
      localASN1EncodableVector2.add(this.checkAfter[i]);
      PKIFreeText[] arrayOfPKIFreeText = this.reason;
      if (arrayOfPKIFreeText[i] != null) {
        localASN1EncodableVector2.add(arrayOfPKIFreeText[i]);
      }
      localASN1EncodableVector1.add(new DERSequence(localASN1EncodableVector2));
      i += 1;
    }
    return new DERSequence(localASN1EncodableVector1);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cmp\PollRepContent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */