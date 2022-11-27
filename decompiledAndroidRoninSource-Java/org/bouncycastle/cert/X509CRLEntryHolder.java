package org.bouncycastle.cert;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.x509.Extension;
import org.bouncycastle.asn1.x509.Extensions;
import org.bouncycastle.asn1.x509.GeneralNames;
import org.bouncycastle.asn1.x509.TBSCertList.CRLEntry;
import org.bouncycastle.asn1.x509.Time;

public class X509CRLEntryHolder
{
  private GeneralNames ca;
  private TBSCertList.CRLEntry entry;
  
  X509CRLEntryHolder(TBSCertList.CRLEntry paramCRLEntry, boolean paramBoolean, GeneralNames paramGeneralNames)
  {
    this.entry = paramCRLEntry;
    this.ca = paramGeneralNames;
    if ((paramBoolean) && (paramCRLEntry.hasExtensions()))
    {
      paramCRLEntry = paramCRLEntry.getExtensions().getExtension(Extension.certificateIssuer);
      if (paramCRLEntry != null) {
        this.ca = GeneralNames.getInstance(paramCRLEntry.getParsedValue());
      }
    }
  }
  
  public GeneralNames getCertificateIssuer()
  {
    return this.ca;
  }
  
  public Set getCriticalExtensionOIDs()
  {
    return CertUtils.getCriticalExtensionOIDs(this.entry.getExtensions());
  }
  
  public Extension getExtension(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
  {
    Extensions localExtensions = this.entry.getExtensions();
    if (localExtensions != null) {
      return localExtensions.getExtension(paramASN1ObjectIdentifier);
    }
    return null;
  }
  
  public List getExtensionOIDs()
  {
    return CertUtils.getExtensionOIDs(this.entry.getExtensions());
  }
  
  public Extensions getExtensions()
  {
    return this.entry.getExtensions();
  }
  
  public Set getNonCriticalExtensionOIDs()
  {
    return CertUtils.getNonCriticalExtensionOIDs(this.entry.getExtensions());
  }
  
  public Date getRevocationDate()
  {
    return this.entry.getRevocationDate().getDate();
  }
  
  public BigInteger getSerialNumber()
  {
    return this.entry.getUserCertificate().getValue();
  }
  
  public boolean hasExtensions()
  {
    return this.entry.hasExtensions();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cert\X509CRLEntryHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */