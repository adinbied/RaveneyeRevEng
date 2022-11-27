package org.bouncycastle.cert.dane;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.bouncycastle.operator.DigestCalculator;

public class DANECertificateFetcher
{
  private final DANEEntryFetcherFactory fetcherFactory;
  private final DANEEntrySelectorFactory selectorFactory;
  
  public DANECertificateFetcher(DANEEntryFetcherFactory paramDANEEntryFetcherFactory, DigestCalculator paramDigestCalculator)
  {
    this.fetcherFactory = paramDANEEntryFetcherFactory;
    this.selectorFactory = new DANEEntrySelectorFactory(paramDigestCalculator);
  }
  
  public List fetch(String paramString)
    throws DANEException
  {
    paramString = this.selectorFactory.createSelector(paramString);
    Object localObject = this.fetcherFactory.build(paramString.getDomainName()).getEntries();
    ArrayList localArrayList = new ArrayList(((List)localObject).size());
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      DANEEntry localDANEEntry = (DANEEntry)((Iterator)localObject).next();
      if (paramString.match(localDANEEntry)) {
        localArrayList.add(localDANEEntry.getCertificate());
      }
    }
    return Collections.unmodifiableList(localArrayList);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cert\dane\DANECertificateFetcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */