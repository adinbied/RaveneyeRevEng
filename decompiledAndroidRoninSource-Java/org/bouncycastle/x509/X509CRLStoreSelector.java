package org.bouncycastle.x509;

import java.io.IOException;
import java.math.BigInteger;
import java.security.cert.CRL;
import java.security.cert.X509CRL;
import java.security.cert.X509CRLSelector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.x509.X509Extensions;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Selector;
import org.bouncycastle.x509.extension.X509ExtensionUtil;

public class X509CRLStoreSelector
  extends X509CRLSelector
  implements Selector
{
  private X509AttributeCertificate attrCertChecking;
  private boolean completeCRLEnabled = false;
  private boolean deltaCRLIndicator = false;
  private byte[] issuingDistributionPoint = null;
  private boolean issuingDistributionPointEnabled = false;
  private BigInteger maxBaseCRLNumber = null;
  
  public static X509CRLStoreSelector getInstance(X509CRLSelector paramX509CRLSelector)
  {
    if (paramX509CRLSelector != null)
    {
      X509CRLStoreSelector localX509CRLStoreSelector = new X509CRLStoreSelector();
      localX509CRLStoreSelector.setCertificateChecking(paramX509CRLSelector.getCertificateChecking());
      localX509CRLStoreSelector.setDateAndTime(paramX509CRLSelector.getDateAndTime());
      try
      {
        localX509CRLStoreSelector.setIssuerNames(paramX509CRLSelector.getIssuerNames());
        localX509CRLStoreSelector.setIssuers(paramX509CRLSelector.getIssuers());
        localX509CRLStoreSelector.setMaxCRLNumber(paramX509CRLSelector.getMaxCRL());
        localX509CRLStoreSelector.setMinCRLNumber(paramX509CRLSelector.getMinCRL());
        return localX509CRLStoreSelector;
      }
      catch (IOException paramX509CRLSelector)
      {
        throw new IllegalArgumentException(paramX509CRLSelector.getMessage());
      }
    }
    throw new IllegalArgumentException("cannot create from null selector");
  }
  
  public Object clone()
  {
    X509CRLStoreSelector localX509CRLStoreSelector = getInstance(this);
    localX509CRLStoreSelector.deltaCRLIndicator = this.deltaCRLIndicator;
    localX509CRLStoreSelector.completeCRLEnabled = this.completeCRLEnabled;
    localX509CRLStoreSelector.maxBaseCRLNumber = this.maxBaseCRLNumber;
    localX509CRLStoreSelector.attrCertChecking = this.attrCertChecking;
    localX509CRLStoreSelector.issuingDistributionPointEnabled = this.issuingDistributionPointEnabled;
    localX509CRLStoreSelector.issuingDistributionPoint = Arrays.clone(this.issuingDistributionPoint);
    return localX509CRLStoreSelector;
  }
  
  public X509AttributeCertificate getAttrCertificateChecking()
  {
    return this.attrCertChecking;
  }
  
  public byte[] getIssuingDistributionPoint()
  {
    return Arrays.clone(this.issuingDistributionPoint);
  }
  
  public BigInteger getMaxBaseCRLNumber()
  {
    return this.maxBaseCRLNumber;
  }
  
  public boolean isCompleteCRLEnabled()
  {
    return this.completeCRLEnabled;
  }
  
  public boolean isDeltaCRLIndicatorEnabled()
  {
    return this.deltaCRLIndicator;
  }
  
  public boolean isIssuingDistributionPointEnabled()
  {
    return this.issuingDistributionPointEnabled;
  }
  
  public boolean match(Object paramObject)
  {
    if (!(paramObject instanceof X509CRL)) {
      return false;
    }
    X509CRL localX509CRL = (X509CRL)paramObject;
    paramObject = null;
    try
    {
      byte[] arrayOfByte = localX509CRL.getExtensionValue(X509Extensions.DeltaCRLIndicator.getId());
      if (arrayOfByte != null) {
        paramObject = ASN1Integer.getInstance(X509ExtensionUtil.fromExtensionValue(arrayOfByte));
      }
      if ((isDeltaCRLIndicatorEnabled()) && (paramObject == null)) {
        return false;
      }
      if ((isCompleteCRLEnabled()) && (paramObject != null)) {
        return false;
      }
      if ((paramObject != null) && (this.maxBaseCRLNumber != null) && (((ASN1Integer)paramObject).getPositiveValue().compareTo(this.maxBaseCRLNumber) == 1)) {
        return false;
      }
      if (this.issuingDistributionPointEnabled)
      {
        paramObject = localX509CRL.getExtensionValue(X509Extensions.IssuingDistributionPoint.getId());
        arrayOfByte = this.issuingDistributionPoint;
        if (arrayOfByte == null)
        {
          if (paramObject != null) {
            return false;
          }
        }
        else if (!Arrays.areEqual((byte[])paramObject, arrayOfByte)) {
          return false;
        }
      }
      return super.match(localX509CRL);
    }
    catch (Exception paramObject) {}
    return false;
  }
  
  public boolean match(CRL paramCRL)
  {
    return match(paramCRL);
  }
  
  public void setAttrCertificateChecking(X509AttributeCertificate paramX509AttributeCertificate)
  {
    this.attrCertChecking = paramX509AttributeCertificate;
  }
  
  public void setCompleteCRLEnabled(boolean paramBoolean)
  {
    this.completeCRLEnabled = paramBoolean;
  }
  
  public void setDeltaCRLIndicatorEnabled(boolean paramBoolean)
  {
    this.deltaCRLIndicator = paramBoolean;
  }
  
  public void setIssuingDistributionPoint(byte[] paramArrayOfByte)
  {
    this.issuingDistributionPoint = Arrays.clone(paramArrayOfByte);
  }
  
  public void setIssuingDistributionPointEnabled(boolean paramBoolean)
  {
    this.issuingDistributionPointEnabled = paramBoolean;
  }
  
  public void setMaxBaseCRLNumber(BigInteger paramBigInteger)
  {
    this.maxBaseCRLNumber = paramBigInteger;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\x509\X509CRLStoreSelector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */