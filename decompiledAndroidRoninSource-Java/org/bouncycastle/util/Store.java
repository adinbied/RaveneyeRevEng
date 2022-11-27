package org.bouncycastle.util;

import java.util.Collection;

public abstract interface Store<T>
{
  public abstract Collection<T> getMatches(Selector<T> paramSelector)
    throws StoreException;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastl\\util\Store.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */