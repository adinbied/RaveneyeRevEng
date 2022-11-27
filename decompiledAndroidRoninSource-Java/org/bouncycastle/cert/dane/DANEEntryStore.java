package org.bouncycastle.cert.dane;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.bouncycastle.util.CollectionStore;
import org.bouncycastle.util.Selector;
import org.bouncycastle.util.Store;
import org.bouncycastle.util.StoreException;

public class DANEEntryStore
  implements Store
{
  private final Map entries;
  
  DANEEntryStore(List paramList)
  {
    HashMap localHashMap = new HashMap();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      DANEEntry localDANEEntry = (DANEEntry)paramList.next();
      localHashMap.put(localDANEEntry.getDomainName(), localDANEEntry);
    }
    this.entries = Collections.unmodifiableMap(localHashMap);
  }
  
  public Collection getMatches(Selector paramSelector)
    throws StoreException
  {
    if (paramSelector == null) {
      return this.entries.values();
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.entries.values().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (paramSelector.match(localObject)) {
        localArrayList.add(localObject);
      }
    }
    return Collections.unmodifiableList(localArrayList);
  }
  
  public Store toCertificateStore()
  {
    Object localObject = getMatches(null);
    ArrayList localArrayList = new ArrayList(((Collection)localObject).size());
    localObject = ((Collection)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(((DANEEntry)((Iterator)localObject).next()).getCertificate());
    }
    return new CollectionStore(localArrayList);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cert\dane\DANEEntryStore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */