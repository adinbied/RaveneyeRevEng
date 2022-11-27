package org.bouncycastle.asn1.cmp;

import org.bouncycastle.asn1.ASN1Null;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DERNull;

public class PKIConfirmContent
  extends ASN1Object
{
  private ASN1Null val;
  
  public PKIConfirmContent()
  {
    this.val = DERNull.INSTANCE;
  }
  
  private PKIConfirmContent(ASN1Null paramASN1Null)
  {
    this.val = paramASN1Null;
  }
  
  public static PKIConfirmContent getInstance(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof PKIConfirmContent)))
    {
      if ((paramObject instanceof ASN1Null)) {
        return new PKIConfirmContent((ASN1Null)paramObject);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Invalid object: ");
      localStringBuilder.append(paramObject.getClass().getName());
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return (PKIConfirmContent)paramObject;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    return this.val;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cmp\PKIConfirmContent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */