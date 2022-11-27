package org.bouncycastle.cert.cmp;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.cmp.RevDetails;
import org.bouncycastle.asn1.crmf.CertTemplate;
import org.bouncycastle.asn1.x500.X500Name;

public class RevocationDetails
{
  private RevDetails revDetails;
  
  public RevocationDetails(RevDetails paramRevDetails)
  {
    this.revDetails = paramRevDetails;
  }
  
  public X500Name getIssuer()
  {
    return this.revDetails.getCertDetails().getIssuer();
  }
  
  public BigInteger getSerialNumber()
  {
    return this.revDetails.getCertDetails().getSerialNumber().getValue();
  }
  
  public X500Name getSubject()
  {
    return this.revDetails.getCertDetails().getSubject();
  }
  
  public RevDetails toASN1Structure()
  {
    return this.revDetails;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cert\cmp\RevocationDetails.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */