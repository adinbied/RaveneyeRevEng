package org.bouncycastle.jce.provider;

import java.util.Collection;
import org.bouncycastle.util.CollectionStore;
import org.bouncycastle.util.Selector;
import org.bouncycastle.x509.X509CollectionStoreParameters;
import org.bouncycastle.x509.X509StoreParameters;
import org.bouncycastle.x509.X509StoreSpi;

public class X509StoreCertPairCollection
  extends X509StoreSpi
{
  private CollectionStore _store;
  
  public Collection engineGetMatches(Selector paramSelector)
  {
    return this._store.getMatches(paramSelector);
  }
  
  public void engineInit(X509StoreParameters paramX509StoreParameters)
  {
    if ((paramX509StoreParameters instanceof X509CollectionStoreParameters))
    {
      this._store = new CollectionStore(((X509CollectionStoreParameters)paramX509StoreParameters).getCollection());
      return;
    }
    paramX509StoreParameters = new StringBuilder();
    paramX509StoreParameters.append("Initialization parameters must be an instance of ");
    paramX509StoreParameters.append(X509CollectionStoreParameters.class.getName());
    paramX509StoreParameters.append(".");
    throw new IllegalArgumentException(paramX509StoreParameters.toString());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jce\provider\X509StoreCertPairCollection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */