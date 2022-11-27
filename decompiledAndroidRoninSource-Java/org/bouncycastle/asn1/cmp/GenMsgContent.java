package org.bouncycastle.asn1.cmp;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

public class GenMsgContent
  extends ASN1Object
{
  private ASN1Sequence content;
  
  private GenMsgContent(ASN1Sequence paramASN1Sequence)
  {
    this.content = paramASN1Sequence;
  }
  
  public GenMsgContent(InfoTypeAndValue paramInfoTypeAndValue)
  {
    this.content = new DERSequence(paramInfoTypeAndValue);
  }
  
  public GenMsgContent(InfoTypeAndValue[] paramArrayOfInfoTypeAndValue)
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    int i = 0;
    while (i < paramArrayOfInfoTypeAndValue.length)
    {
      localASN1EncodableVector.add(paramArrayOfInfoTypeAndValue[i]);
      i += 1;
    }
    this.content = new DERSequence(localASN1EncodableVector);
  }
  
  public static GenMsgContent getInstance(Object paramObject)
  {
    if ((paramObject instanceof GenMsgContent)) {
      return (GenMsgContent)paramObject;
    }
    if (paramObject != null) {
      return new GenMsgContent(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    return this.content;
  }
  
  public InfoTypeAndValue[] toInfoTypeAndValueArray()
  {
    int j = this.content.size();
    InfoTypeAndValue[] arrayOfInfoTypeAndValue = new InfoTypeAndValue[j];
    int i = 0;
    while (i != j)
    {
      arrayOfInfoTypeAndValue[i] = InfoTypeAndValue.getInstance(this.content.getObjectAt(i));
      i += 1;
    }
    return arrayOfInfoTypeAndValue;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cmp\GenMsgContent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */