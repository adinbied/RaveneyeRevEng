package org.bouncycastle.x509;

import org.bouncycastle.util.Selector;

public class X509CertPairStoreSelector
  implements Selector
{
  private X509CertificatePair certPair;
  private X509CertStoreSelector forwardSelector;
  private X509CertStoreSelector reverseSelector;
  
  public Object clone()
  {
    X509CertPairStoreSelector localX509CertPairStoreSelector = new X509CertPairStoreSelector();
    localX509CertPairStoreSelector.certPair = this.certPair;
    X509CertStoreSelector localX509CertStoreSelector = this.forwardSelector;
    if (localX509CertStoreSelector != null) {
      localX509CertPairStoreSelector.setForwardSelector((X509CertStoreSelector)localX509CertStoreSelector.clone());
    }
    localX509CertStoreSelector = this.reverseSelector;
    if (localX509CertStoreSelector != null) {
      localX509CertPairStoreSelector.setReverseSelector((X509CertStoreSelector)localX509CertStoreSelector.clone());
    }
    return localX509CertPairStoreSelector;
  }
  
  public X509CertificatePair getCertPair()
  {
    return this.certPair;
  }
  
  public X509CertStoreSelector getForwardSelector()
  {
    return this.forwardSelector;
  }
  
  public X509CertStoreSelector getReverseSelector()
  {
    return this.reverseSelector;
  }
  
  public boolean match(Object paramObject)
  {
    try
    {
      if (!(paramObject instanceof X509CertificatePair)) {
        return false;
      }
      X509CertificatePair localX509CertificatePair = (X509CertificatePair)paramObject;
      if ((this.forwardSelector != null) && (!this.forwardSelector.match(localX509CertificatePair.getForward()))) {
        return false;
      }
      if ((this.reverseSelector != null) && (!this.reverseSelector.match(localX509CertificatePair.getReverse()))) {
        return false;
      }
      if (this.certPair != null)
      {
        boolean bool = this.certPair.equals(paramObject);
        return bool;
      }
      return true;
    }
    catch (Exception paramObject) {}
    return false;
  }
  
  public void setCertPair(X509CertificatePair paramX509CertificatePair)
  {
    this.certPair = paramX509CertificatePair;
  }
  
  public void setForwardSelector(X509CertStoreSelector paramX509CertStoreSelector)
  {
    this.forwardSelector = paramX509CertStoreSelector;
  }
  
  public void setReverseSelector(X509CertStoreSelector paramX509CertStoreSelector)
  {
    this.reverseSelector = paramX509CertStoreSelector;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\x509\X509CertPairStoreSelector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */