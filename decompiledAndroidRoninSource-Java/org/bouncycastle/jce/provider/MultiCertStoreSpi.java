package org.bouncycastle.jce.provider;

import java.security.InvalidAlgorithmParameterException;
import java.security.cert.CRLSelector;
import java.security.cert.CertSelector;
import java.security.cert.CertStore;
import java.security.cert.CertStoreException;
import java.security.cert.CertStoreParameters;
import java.security.cert.CertStoreSpi;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.bouncycastle.jce.MultiCertStoreParameters;

public class MultiCertStoreSpi
  extends CertStoreSpi
{
  private MultiCertStoreParameters params;
  
  public MultiCertStoreSpi(CertStoreParameters paramCertStoreParameters)
    throws InvalidAlgorithmParameterException
  {
    super(paramCertStoreParameters);
    if ((paramCertStoreParameters instanceof MultiCertStoreParameters))
    {
      this.params = ((MultiCertStoreParameters)paramCertStoreParameters);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("org.bouncycastle.jce.provider.MultiCertStoreSpi: parameter must be a MultiCertStoreParameters object\n");
    localStringBuilder.append(paramCertStoreParameters.toString());
    throw new InvalidAlgorithmParameterException(localStringBuilder.toString());
  }
  
  public Collection engineGetCRLs(CRLSelector paramCRLSelector)
    throws CertStoreException
  {
    boolean bool = this.params.getSearchAllStores();
    Iterator localIterator = this.params.getCertStores().iterator();
    Object localObject;
    if (bool) {
      localObject = new ArrayList();
    } else {
      localObject = Collections.EMPTY_LIST;
    }
    while (localIterator.hasNext())
    {
      Collection localCollection = ((CertStore)localIterator.next()).getCRLs(paramCRLSelector);
      if (bool) {
        ((List)localObject).addAll(localCollection);
      } else if (!localCollection.isEmpty()) {
        return localCollection;
      }
    }
    return (Collection)localObject;
  }
  
  public Collection engineGetCertificates(CertSelector paramCertSelector)
    throws CertStoreException
  {
    boolean bool = this.params.getSearchAllStores();
    Iterator localIterator = this.params.getCertStores().iterator();
    Object localObject;
    if (bool) {
      localObject = new ArrayList();
    } else {
      localObject = Collections.EMPTY_LIST;
    }
    while (localIterator.hasNext())
    {
      Collection localCollection = ((CertStore)localIterator.next()).getCertificates(paramCertSelector);
      if (bool) {
        ((List)localObject).addAll(localCollection);
      } else if (!localCollection.isEmpty()) {
        return localCollection;
      }
    }
    return (Collection)localObject;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jce\provider\MultiCertStoreSpi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */