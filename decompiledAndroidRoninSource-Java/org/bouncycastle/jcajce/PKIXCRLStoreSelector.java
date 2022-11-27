package org.bouncycastle.jcajce;

import java.math.BigInteger;
import java.security.cert.CRL;
import java.security.cert.CRLSelector;
import java.security.cert.CertStore;
import java.security.cert.CertStoreException;
import java.security.cert.X509CRL;
import java.security.cert.X509CRLSelector;
import java.security.cert.X509Certificate;
import java.util.Collection;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.x509.Extension;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Selector;

public class PKIXCRLStoreSelector<T extends CRL>
  implements Selector<T>
{
  private final CRLSelector baseSelector;
  private final boolean completeCRLEnabled;
  private final boolean deltaCRLIndicator;
  private final byte[] issuingDistributionPoint;
  private final boolean issuingDistributionPointEnabled;
  private final BigInteger maxBaseCRLNumber;
  
  private PKIXCRLStoreSelector(Builder paramBuilder)
  {
    this.baseSelector = paramBuilder.baseSelector;
    this.deltaCRLIndicator = paramBuilder.deltaCRLIndicator;
    this.completeCRLEnabled = paramBuilder.completeCRLEnabled;
    this.maxBaseCRLNumber = paramBuilder.maxBaseCRLNumber;
    this.issuingDistributionPoint = paramBuilder.issuingDistributionPoint;
    this.issuingDistributionPointEnabled = paramBuilder.issuingDistributionPointEnabled;
  }
  
  public static Collection<? extends CRL> getCRLs(PKIXCRLStoreSelector paramPKIXCRLStoreSelector, CertStore paramCertStore)
    throws CertStoreException
  {
    return paramCertStore.getCRLs(new SelectorClone(paramPKIXCRLStoreSelector));
  }
  
  public Object clone()
  {
    return this;
  }
  
  public X509Certificate getCertificateChecking()
  {
    CRLSelector localCRLSelector = this.baseSelector;
    if ((localCRLSelector instanceof X509CRLSelector)) {
      return ((X509CRLSelector)localCRLSelector).getCertificateChecking();
    }
    return null;
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
  
  public boolean match(CRL paramCRL)
  {
    if (!(paramCRL instanceof X509CRL)) {}
    for (;;)
    {
      return this.baseSelector.match(paramCRL);
      Object localObject2 = (X509CRL)paramCRL;
      Object localObject1 = null;
      try
      {
        byte[] arrayOfByte = ((X509CRL)localObject2).getExtensionValue(Extension.deltaCRLIndicator.getId());
        if (arrayOfByte != null) {
          localObject1 = ASN1Integer.getInstance(ASN1OctetString.getInstance(arrayOfByte).getOctets());
        }
        if ((isDeltaCRLIndicatorEnabled()) && (localObject1 == null)) {
          return false;
        }
        if ((isCompleteCRLEnabled()) && (localObject1 != null)) {
          return false;
        }
        if ((localObject1 != null) && (this.maxBaseCRLNumber != null) && (((ASN1Integer)localObject1).getPositiveValue().compareTo(this.maxBaseCRLNumber) == 1)) {
          return false;
        }
        if (this.issuingDistributionPointEnabled)
        {
          localObject1 = ((X509CRL)localObject2).getExtensionValue(Extension.issuingDistributionPoint.getId());
          localObject2 = this.issuingDistributionPoint;
          if (localObject2 == null)
          {
            if (localObject1 != null) {
              return false;
            }
          }
          else if (!Arrays.areEqual((byte[])localObject1, (byte[])localObject2)) {
            return false;
          }
        }
      }
      catch (Exception paramCRL) {}
    }
    return false;
  }
  
  public static class Builder
  {
    private final CRLSelector baseSelector;
    private boolean completeCRLEnabled = false;
    private boolean deltaCRLIndicator = false;
    private byte[] issuingDistributionPoint = null;
    private boolean issuingDistributionPointEnabled = false;
    private BigInteger maxBaseCRLNumber = null;
    
    public Builder(CRLSelector paramCRLSelector)
    {
      this.baseSelector = ((CRLSelector)paramCRLSelector.clone());
    }
    
    public PKIXCRLStoreSelector<? extends CRL> build()
    {
      return new PKIXCRLStoreSelector(this, null);
    }
    
    public Builder setCompleteCRLEnabled(boolean paramBoolean)
    {
      this.completeCRLEnabled = paramBoolean;
      return this;
    }
    
    public Builder setDeltaCRLIndicatorEnabled(boolean paramBoolean)
    {
      this.deltaCRLIndicator = paramBoolean;
      return this;
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
  
  private static class SelectorClone
    extends X509CRLSelector
  {
    private final PKIXCRLStoreSelector selector;
    
    SelectorClone(PKIXCRLStoreSelector paramPKIXCRLStoreSelector)
    {
      this.selector = paramPKIXCRLStoreSelector;
      if ((paramPKIXCRLStoreSelector.baseSelector instanceof X509CRLSelector))
      {
        paramPKIXCRLStoreSelector = (X509CRLSelector)paramPKIXCRLStoreSelector.baseSelector;
        setCertificateChecking(paramPKIXCRLStoreSelector.getCertificateChecking());
        setDateAndTime(paramPKIXCRLStoreSelector.getDateAndTime());
        setIssuers(paramPKIXCRLStoreSelector.getIssuers());
        setMinCRLNumber(paramPKIXCRLStoreSelector.getMinCRL());
        setMaxCRLNumber(paramPKIXCRLStoreSelector.getMaxCRL());
      }
    }
    
    public boolean match(CRL paramCRL)
    {
      PKIXCRLStoreSelector localPKIXCRLStoreSelector = this.selector;
      if (localPKIXCRLStoreSelector == null) {
        return paramCRL != null;
      }
      return localPKIXCRLStoreSelector.match(paramCRL);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\PKIXCRLStoreSelector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */