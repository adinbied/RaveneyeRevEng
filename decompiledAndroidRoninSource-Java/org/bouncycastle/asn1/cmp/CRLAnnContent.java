package org.bouncycastle.asn1.cmp;

import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.CertificateList;

public class CRLAnnContent
  extends ASN1Object
{
  private ASN1Sequence content;
  
  private CRLAnnContent(ASN1Sequence paramASN1Sequence)
  {
    this.content = paramASN1Sequence;
  }
  
  public CRLAnnContent(CertificateList paramCertificateList)
  {
    this.content = new DERSequence(paramCertificateList);
  }
  
  public static CRLAnnContent getInstance(Object paramObject)
  {
    if ((paramObject instanceof CRLAnnContent)) {
      return (CRLAnnContent)paramObject;
    }
    if (paramObject != null) {
      return new CRLAnnContent(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public CertificateList[] getCertificateLists()
  {
    int j = this.content.size();
    CertificateList[] arrayOfCertificateList = new CertificateList[j];
    int i = 0;
    while (i != j)
    {
      arrayOfCertificateList[i] = CertificateList.getInstance(this.content.getObjectAt(i));
      i += 1;
    }
    return arrayOfCertificateList;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    return this.content;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cmp\CRLAnnContent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */