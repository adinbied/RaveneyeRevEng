package org.bouncycastle.jce.provider;

import java.security.cert.CertStore;
import java.security.cert.CertStoreException;
import java.security.cert.X509CRL;
import java.security.cert.X509Certificate;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.bouncycastle.jcajce.PKIXCRLStoreSelector;
import org.bouncycastle.util.Store;
import org.bouncycastle.util.StoreException;

class PKIXCRLUtil
{
  private final Collection findCRLs(PKIXCRLStoreSelector paramPKIXCRLStoreSelector, List paramList)
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
        break label130;
      }
      localObject = localIterator.next();
      if ((localObject instanceof Store))
      {
        localObject = (Store)localObject;
        try
        {
          localHashSet.addAll(((Store)localObject).getMatches(paramPKIXCRLStoreSelector));
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
        localHashSet.addAll(PKIXCRLStoreSelector.getCRLs(paramPKIXCRLStoreSelector, (CertStore)localObject));
      }
      catch (CertStoreException paramList)
      {
        paramList = new AnnotatedException("Exception searching in X.509 CRL store.", paramList);
      }
    }
    label130:
    if (i == 0)
    {
      if (paramList == null) {
        return localHashSet;
      }
      throw paramList;
    }
    return localHashSet;
  }
  
  public Set findCRLs(PKIXCRLStoreSelector paramPKIXCRLStoreSelector, Date paramDate, List paramList1, List paramList2)
    throws AnnotatedException
  {
    Object localObject = new HashSet();
    try
    {
      ((Set)localObject).addAll(findCRLs(paramPKIXCRLStoreSelector, paramList2));
      ((Set)localObject).addAll(findCRLs(paramPKIXCRLStoreSelector, paramList1));
      paramList1 = new HashSet();
      paramList2 = ((Set)localObject).iterator();
      while (paramList2.hasNext())
      {
        localObject = (X509CRL)paramList2.next();
        if (((X509CRL)localObject).getNextUpdate().after(paramDate))
        {
          X509Certificate localX509Certificate = paramPKIXCRLStoreSelector.getCertificateChecking();
          if ((localX509Certificate == null) || (((X509CRL)localObject).getThisUpdate().before(localX509Certificate.getNotAfter()))) {
            paramList1.add(localObject);
          }
        }
      }
      return paramList1;
    }
    catch (AnnotatedException paramPKIXCRLStoreSelector)
    {
      throw new AnnotatedException("Exception obtaining complete CRLs.", paramPKIXCRLStoreSelector);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jce\provider\PKIXCRLUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */