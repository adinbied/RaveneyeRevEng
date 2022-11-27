package org.bouncycastle.asn1.cmp;

import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;

public class POPODecKeyChallContent
  extends ASN1Object
{
  private ASN1Sequence content;
  
  private POPODecKeyChallContent(ASN1Sequence paramASN1Sequence)
  {
    this.content = paramASN1Sequence;
  }
  
  public static POPODecKeyChallContent getInstance(Object paramObject)
  {
    if ((paramObject instanceof POPODecKeyChallContent)) {
      return (POPODecKeyChallContent)paramObject;
    }
    if (paramObject != null) {
      return new POPODecKeyChallContent(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    return this.content;
  }
  
  public Challenge[] toChallengeArray()
  {
    int j = this.content.size();
    Challenge[] arrayOfChallenge = new Challenge[j];
    int i = 0;
    while (i != j)
    {
      arrayOfChallenge[i] = Challenge.getInstance(this.content.getObjectAt(i));
      i += 1;
    }
    return arrayOfChallenge;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cmp\POPODecKeyChallContent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */