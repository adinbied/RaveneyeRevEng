package org.bouncycastle.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class CollectionStore<T>
  implements Store<T>, Iterable<T>
{
  private Collection<T> _local;
  
  public CollectionStore(Collection<T> paramCollection)
  {
    this._local = new ArrayList(paramCollection);
  }
  
  public Collection<T> getMatches(Selector<T> paramSelector)
  {
    if (paramSelector == null) {
      return new ArrayList(this._local);
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this._local.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (paramSelector.match(localObject)) {
        localArrayList.add(localObject);
      }
    }
    return localArrayList;
  }
  
  public Iterator<T> iterator()
  {
    return getMatches(null).iterator();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastl\\util\CollectionStore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */