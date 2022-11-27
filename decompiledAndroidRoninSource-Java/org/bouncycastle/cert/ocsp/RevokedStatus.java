package org.bouncycastle.cert.ocsp;

import java.math.BigInteger;
import java.util.Date;
import org.bouncycastle.asn1.ASN1GeneralizedTime;
import org.bouncycastle.asn1.ocsp.RevokedInfo;
import org.bouncycastle.asn1.x509.CRLReason;

public class RevokedStatus
  implements CertificateStatus
{
  RevokedInfo info;
  
  public RevokedStatus(Date paramDate, int paramInt)
  {
    this.info = new RevokedInfo(new ASN1GeneralizedTime(paramDate), CRLReason.lookup(paramInt));
  }
  
  public RevokedStatus(RevokedInfo paramRevokedInfo)
  {
    this.info = paramRevokedInfo;
  }
  
  public int getRevocationReason()
  {
    if (this.info.getRevocationReason() != null) {
      return this.info.getRevocationReason().getValue().intValue();
    }
    throw new IllegalStateException("attempt to get a reason where none is available");
  }
  
  public Date getRevocationTime()
  {
    return OCSPUtils.extractDate(this.info.getRevocationTime());
  }
  
  public boolean hasRevocationReason()
  {
    return this.info.getRevocationReason() != null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cert\ocsp\RevokedStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */