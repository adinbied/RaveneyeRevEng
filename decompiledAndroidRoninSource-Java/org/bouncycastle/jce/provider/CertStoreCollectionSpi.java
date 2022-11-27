package org.bouncycastle.jce.provider;

import java.security.InvalidAlgorithmParameterException;
import java.security.cert.CRL;
import java.security.cert.CRLSelector;
import java.security.cert.CertSelector;
import java.security.cert.CertStoreException;
import java.security.cert.CertStoreParameters;
import java.security.cert.CertStoreSpi;
import java.security.cert.Certificate;
import java.security.cert.CollectionCertStoreParameters;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class CertStoreCollectionSpi
  extends CertStoreSpi
{
  private CollectionCertStoreParameters params;
  
  public CertStoreCollectionSpi(CertStoreParameters paramCertStoreParameters)
    throws InvalidAlgorithmParameterException
  {
    super(paramCertStoreParameters);
    if ((paramCertStoreParameters instanceof CollectionCertStoreParameters))
    {
      this.params = ((CollectionCertStoreParameters)paramCertStoreParameters);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("org.bouncycastle.jce.provider.CertStoreCollectionSpi: parameter must be a CollectionCertStoreParameters object\n");
    localStringBuilder.append(paramCertStoreParameters.toString());
    throw new InvalidAlgorithmParameterException(localStringBuilder.toString());
  }
  
  public Collection engineGetCRLs(CRLSelector paramCRLSelector)
    throws CertStoreException
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.params.getCollection().iterator();
    if (paramCRLSelector == null) {
      while (localIterator.hasNext())
      {
        paramCRLSelector = localIterator.next();
        if ((paramCRLSelector instanceof CRL)) {
          localArrayList.add(paramCRLSelector);
        }
      }
    }
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (((localObject instanceof CRL)) && (paramCRLSelector.match((CRL)localObject))) {
        localArrayList.add(localObject);
      }
    }
    return localArrayList;
  }
  
  public Collection engineGetCertificates(CertSelector paramCertSelector)
    throws CertStoreException
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.params.getCollection().iterator();
    if (paramCertSelector == null) {
      while (localIterator.hasNext())
      {
        paramCertSelector = localIterator.next();
        if ((paramCertSelector instanceof Certificate)) {
          localArrayList.add(paramCertSelector);
        }
      }
    }
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (((localObject instanceof Certificate)) && (paramCertSelector.match((Certificate)localObject))) {
        localArrayList.add(localObject);
      }
    }
    return localArrayList;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jce\provider\CertStoreCollectionSpi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */