package org.bouncycastle.jce.provider;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.bouncycastle.jce.X509LDAPCertStoreParameters;
import org.bouncycastle.util.Selector;
import org.bouncycastle.util.StoreException;
import org.bouncycastle.x509.X509CertPairStoreSelector;
import org.bouncycastle.x509.X509CertStoreSelector;
import org.bouncycastle.x509.X509CertificatePair;
import org.bouncycastle.x509.X509StoreParameters;
import org.bouncycastle.x509.X509StoreSpi;
import org.bouncycastle.x509.util.LDAPStoreHelper;

public class X509StoreLDAPCerts
  extends X509StoreSpi
{
  private LDAPStoreHelper helper;
  
  private Collection getCertificatesFromCrossCertificatePairs(X509CertStoreSelector paramX509CertStoreSelector)
    throws StoreException
  {
    HashSet localHashSet = new HashSet();
    Object localObject1 = new X509CertPairStoreSelector();
    ((X509CertPairStoreSelector)localObject1).setForwardSelector(paramX509CertStoreSelector);
    ((X509CertPairStoreSelector)localObject1).setReverseSelector(new X509CertStoreSelector());
    Object localObject2 = new HashSet(this.helper.getCrossCertificatePairs((X509CertPairStoreSelector)localObject1));
    paramX509CertStoreSelector = new HashSet();
    localObject1 = new HashSet();
    localObject2 = ((Set)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      X509CertificatePair localX509CertificatePair = (X509CertificatePair)((Iterator)localObject2).next();
      if (localX509CertificatePair.getForward() != null) {
        paramX509CertStoreSelector.add(localX509CertificatePair.getForward());
      }
      if (localX509CertificatePair.getReverse() != null) {
        ((Set)localObject1).add(localX509CertificatePair.getReverse());
      }
    }
    localHashSet.addAll(paramX509CertStoreSelector);
    localHashSet.addAll((Collection)localObject1);
    return localHashSet;
  }
  
  public Collection engineGetMatches(Selector paramSelector)
    throws StoreException
  {
    if (!(paramSelector instanceof X509CertStoreSelector)) {
      return Collections.EMPTY_SET;
    }
    paramSelector = (X509CertStoreSelector)paramSelector;
    HashSet localHashSet = new HashSet();
    if (paramSelector.getBasicConstraints() > 0) {}
    for (;;)
    {
      localHashSet.addAll(this.helper.getCACertificates(paramSelector));
      for (paramSelector = getCertificatesFromCrossCertificatePairs(paramSelector);; paramSelector = this.helper.getUserCertificates(paramSelector))
      {
        localHashSet.addAll(paramSelector);
        return localHashSet;
        if (paramSelector.getBasicConstraints() != -2) {
          break;
        }
      }
      localHashSet.addAll(this.helper.getUserCertificates(paramSelector));
    }
  }
  
  public void engineInit(X509StoreParameters paramX509StoreParameters)
  {
    if ((paramX509StoreParameters instanceof X509LDAPCertStoreParameters))
    {
      this.helper = new LDAPStoreHelper((X509LDAPCertStoreParameters)paramX509StoreParameters);
      return;
    }
    paramX509StoreParameters = new StringBuilder();
    paramX509StoreParameters.append("Initialization parameters must be an instance of ");
    paramX509StoreParameters.append(X509LDAPCertStoreParameters.class.getName());
    paramX509StoreParameters.append(".");
    throw new IllegalArgumentException(paramX509StoreParameters.toString());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jce\provider\X509StoreLDAPCerts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */