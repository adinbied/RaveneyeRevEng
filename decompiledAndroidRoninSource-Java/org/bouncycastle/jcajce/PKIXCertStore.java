package org.bouncycastle.jcajce;

import java.security.cert.Certificate;
import java.util.Collection;
import org.bouncycastle.util.Selector;
import org.bouncycastle.util.Store;
import org.bouncycastle.util.StoreException;

public abstract interface PKIXCertStore<T extends Certificate>
  extends Store<T>
{
  public abstract Collection<T> getMatches(Selector<T> paramSelector)
    throws StoreException;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\PKIXCertStore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */