package org.bouncycastle.asn1.cmp;

import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;

public class CertConfirmContent
  extends ASN1Object
{
  private ASN1Sequence content;
  
  private CertConfirmContent(ASN1Sequence paramASN1Sequence)
  {
    this.content = paramASN1Sequence;
  }
  
  public static CertConfirmContent getInstance(Object paramObject)
  {
    if ((paramObject instanceof CertConfirmContent)) {
      return (CertConfirmContent)paramObject;
    }
    if (paramObject != null) {
      return new CertConfirmContent(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    return this.content;
  }
  
  public CertStatus[] toCertStatusArray()
  {
    int j = this.content.size();
    CertStatus[] arrayOfCertStatus = new CertStatus[j];
    int i = 0;
    while (i != j)
    {
      arrayOfCertStatus[i] = CertStatus.getInstance(this.content.getObjectAt(i));
      i += 1;
    }
    return arrayOfCertStatus;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cmp\CertConfirmContent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */