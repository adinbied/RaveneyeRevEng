package org.bouncycastle.x509;

import java.util.Collection;
import org.bouncycastle.util.Selector;

public abstract class X509StoreSpi
{
  public abstract Collection engineGetMatches(Selector paramSelector);
  
  public abstract void engineInit(X509StoreParameters paramX509StoreParameters);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\x509\X509StoreSpi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */