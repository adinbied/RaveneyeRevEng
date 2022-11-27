package org.bouncycastle.cert.cmp;

import org.bouncycastle.asn1.cmp.CertConfirmContent;
import org.bouncycastle.asn1.cmp.CertStatus;
import org.bouncycastle.operator.DefaultDigestAlgorithmIdentifierFinder;
import org.bouncycastle.operator.DigestAlgorithmIdentifierFinder;

public class CertificateConfirmationContent
{
  private CertConfirmContent content;
  private DigestAlgorithmIdentifierFinder digestAlgFinder;
  
  public CertificateConfirmationContent(CertConfirmContent paramCertConfirmContent)
  {
    this(paramCertConfirmContent, new DefaultDigestAlgorithmIdentifierFinder());
  }
  
  public CertificateConfirmationContent(CertConfirmContent paramCertConfirmContent, DigestAlgorithmIdentifierFinder paramDigestAlgorithmIdentifierFinder)
  {
    this.digestAlgFinder = paramDigestAlgorithmIdentifierFinder;
    this.content = paramCertConfirmContent;
  }
  
  public CertificateStatus[] getStatusMessages()
  {
    CertStatus[] arrayOfCertStatus = this.content.toCertStatusArray();
    int j = arrayOfCertStatus.length;
    CertificateStatus[] arrayOfCertificateStatus = new CertificateStatus[j];
    int i = 0;
    while (i != j)
    {
      arrayOfCertificateStatus[i] = new CertificateStatus(this.digestAlgFinder, arrayOfCertStatus[i]);
      i += 1;
    }
    return arrayOfCertificateStatus;
  }
  
  public CertConfirmContent toASN1Structure()
  {
    return this.content;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cert\cmp\CertificateConfirmationContent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */