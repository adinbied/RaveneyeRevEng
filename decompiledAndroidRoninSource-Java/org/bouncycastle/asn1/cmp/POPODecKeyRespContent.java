package org.bouncycastle.asn1.cmp;

import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;

public class POPODecKeyRespContent
  extends ASN1Object
{
  private ASN1Sequence content;
  
  private POPODecKeyRespContent(ASN1Sequence paramASN1Sequence)
  {
    this.content = paramASN1Sequence;
  }
  
  public static POPODecKeyRespContent getInstance(Object paramObject)
  {
    if ((paramObject instanceof POPODecKeyRespContent)) {
      return (POPODecKeyRespContent)paramObject;
    }
    if (paramObject != null) {
      return new POPODecKeyRespContent(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public ASN1Integer[] toASN1IntegerArray()
  {
    int j = this.content.size();
    ASN1Integer[] arrayOfASN1Integer = new ASN1Integer[j];
    int i = 0;
    while (i != j)
    {
      arrayOfASN1Integer[i] = ASN1Integer.getInstance(this.content.getObjectAt(i));
      i += 1;
    }
    return arrayOfASN1Integer;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    return this.content;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cmp\POPODecKeyRespContent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */