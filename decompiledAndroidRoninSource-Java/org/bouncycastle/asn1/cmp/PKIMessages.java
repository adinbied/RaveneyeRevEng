package org.bouncycastle.asn1.cmp;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

public class PKIMessages
  extends ASN1Object
{
  private ASN1Sequence content;
  
  private PKIMessages(ASN1Sequence paramASN1Sequence)
  {
    this.content = paramASN1Sequence;
  }
  
  public PKIMessages(PKIMessage paramPKIMessage)
  {
    this.content = new DERSequence(paramPKIMessage);
  }
  
  public PKIMessages(PKIMessage[] paramArrayOfPKIMessage)
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    int i = 0;
    while (i < paramArrayOfPKIMessage.length)
    {
      localASN1EncodableVector.add(paramArrayOfPKIMessage[i]);
      i += 1;
    }
    this.content = new DERSequence(localASN1EncodableVector);
  }
  
  public static PKIMessages getInstance(Object paramObject)
  {
    if ((paramObject instanceof PKIMessages)) {
      return (PKIMessages)paramObject;
    }
    if (paramObject != null) {
      return new PKIMessages(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    return this.content;
  }
  
  public PKIMessage[] toPKIMessageArray()
  {
    int j = this.content.size();
    PKIMessage[] arrayOfPKIMessage = new PKIMessage[j];
    int i = 0;
    while (i != j)
    {
      arrayOfPKIMessage[i] = PKIMessage.getInstance(this.content.getObjectAt(i));
      i += 1;
    }
    return arrayOfPKIMessage;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cmp\PKIMessages.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */