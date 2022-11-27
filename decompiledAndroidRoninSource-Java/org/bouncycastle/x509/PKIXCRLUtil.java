package org.bouncycastle.x509;

import java.security.cert.CertStore;
import java.security.cert.CertStoreException;
import java.security.cert.PKIXParameters;
import java.security.cert.X509CRL;
import java.security.cert.X509Certificate;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.bouncycastle.jce.provider.AnnotatedException;
import org.bouncycastle.util.StoreException;

class PKIXCRLUtil
{
  private final Collection findCRLs(X509CRLStoreSelector paramX509CRLStoreSelector, List paramList)
    throws AnnotatedException
  {
    HashSet localHashSet = new HashSet();
    Iterator localIterator = paramList.iterator();
    paramList = null;
    int i = 0;
    Object localObject;
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label128;
      }
      localObject = localIterator.next();
      if ((localObject instanceof X509Store))
      {
        localObject = (X509Store)localObject;
        try
        {
          localHashSet.addAll(((X509Store)localObject).getMatches(paramX509CRLStoreSelector));
          i = 1;
        }
        catch (StoreException paramList)
        {
          paramList = new AnnotatedException("Exception searching in X.509 CRL store.", paramList);
        }
      }
    }
    for (;;)
    {
      break;
      localObject = (CertStore)localObject;
      try
      {
        localHashSet.addAll(((CertStore)localObject).getCRLs(paramX509CRLStoreSelector));
      }
      catch (CertStoreException paramList)
      {
        paramList = new AnnotatedException("Exception searching in X.509 CRL store.", paramList);
      }
    }
    label128:
    if (i == 0)
    {
      if (paramList == null) {
        return localHashSet;
      }
      throw paramList;
    }
    return localHashSet;
  }
  
  public Set findCRLs(X509CRLStoreSelector paramX509CRLStoreSelector, PKIXParameters paramPKIXParameters)
    throws AnnotatedException
  {
    HashSet localHashSet = new HashSet();
    try
    {
      localHashSet.addAll(findCRLs(paramX509CRLStoreSelector, paramPKIXParameters.getCertStores()));
      return localHashSet;
    }
    catch (AnnotatedException paramX509CRLStoreSelector)
    {
      throw new AnnotatedException("Exception obtaining complete CRLs.", paramX509CRLStoreSelector);
    }
  }
  
  public Set findCRLs(X509CRLStoreSelector paramX509CRLStoreSelector, ExtendedPKIXParameters paramExtendedPKIXParameters, Date paramDate)
    throws AnnotatedException
  {
    Object localObject = new HashSet();
    try
    {
      ((Set)localObject).addAll(findCRLs(paramX509CRLStoreSelector, paramExtendedPKIXParameters.getAdditionalStores()));
      ((Set)localObject).addAll(findCRLs(paramX509CRLStoreSelector, paramExtendedPKIXParameters.getStores()));
      ((Set)localObject).addAll(findCRLs(paramX509CRLStoreSelector, paramExtendedPKIXParameters.getCertStores()));
      HashSet localHashSet = new HashSet();
      if (paramExtendedPKIXParameters.getDate() != null) {
        paramDate = paramExtendedPKIXParameters.getDate();
      }
      paramExtendedPKIXParameters = ((Set)localObject).iterator();
      while (paramExtendedPKIXParameters.hasNext())
      {
        localObject = (X509CRL)paramExtendedPKIXParameters.next();
        if (((X509CRL)localObject).getNextUpdate().after(paramDate))
        {
          X509Certificate localX509Certificate = paramX509CRLStoreSelector.getCertificateChecking();
          if ((localX509Certificate == null) || (((X509CRL)localObject).getThisUpdate().before(localX509Certificate.getNotAfter()))) {
            localHashSet.add(localObject);
          }
        }
      }
      return localHashSet;
    }
    catch (AnnotatedException paramX509CRLStoreSelector)
    {
      throw new AnnotatedException("Exception obtaining complete CRLs.", paramX509CRLStoreSelector);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\x509\PKIXCRLUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */