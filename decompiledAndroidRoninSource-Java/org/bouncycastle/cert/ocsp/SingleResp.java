package org.bouncycastle.cert.ocsp;

import java.util.Date;
import java.util.List;
import java.util.Set;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ocsp.CertStatus;
import org.bouncycastle.asn1.ocsp.RevokedInfo;
import org.bouncycastle.asn1.ocsp.SingleResponse;
import org.bouncycastle.asn1.x509.Extension;
import org.bouncycastle.asn1.x509.Extensions;

public class SingleResp
{
  private Extensions extensions;
  private SingleResponse resp;
  
  public SingleResp(SingleResponse paramSingleResponse)
  {
    this.resp = paramSingleResponse;
    this.extensions = paramSingleResponse.getSingleExtensions();
  }
  
  public CertificateID getCertID()
  {
    return new CertificateID(this.resp.getCertID());
  }
  
  public CertificateStatus getCertStatus()
  {
    CertStatus localCertStatus = this.resp.getCertStatus();
    if (localCertStatus.getTagNo() == 0) {
      return null;
    }
    if (localCertStatus.getTagNo() == 1) {
      return new RevokedStatus(RevokedInfo.getInstance(localCertStatus.getStatus()));
    }
    return new UnknownStatus();
  }
  
  public Set getCriticalExtensionOIDs()
  {
    return OCSPUtils.getCriticalExtensionOIDs(this.extensions);
  }
  
  public Extension getExtension(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
  {
    Extensions localExtensions = this.extensions;
    if (localExtensions != null) {
      return localExtensions.getExtension(paramASN1ObjectIdentifier);
    }
    return null;
  }
  
  public List getExtensionOIDs()
  {
    return OCSPUtils.getExtensionOIDs(this.extensions);
  }
  
  public Date getNextUpdate()
  {
    if (this.resp.getNextUpdate() == null) {
      return null;
    }
    return OCSPUtils.extractDate(this.resp.getNextUpdate());
  }
  
  public Set getNonCriticalExtensionOIDs()
  {
    return OCSPUtils.getNonCriticalExtensionOIDs(this.extensions);
  }
  
  public Date getThisUpdate()
  {
    return OCSPUtils.extractDate(this.resp.getThisUpdate());
  }
  
  public boolean hasExtensions()
  {
    return this.extensions != null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cert\ocsp\SingleResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */