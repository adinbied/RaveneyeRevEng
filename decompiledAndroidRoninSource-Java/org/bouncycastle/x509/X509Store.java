package org.bouncycastle.x509;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.util.Collection;
import org.bouncycastle.util.Selector;
import org.bouncycastle.util.Store;

public class X509Store
  implements Store
{
  private Provider _provider;
  private X509StoreSpi _spi;
  
  private X509Store(Provider paramProvider, X509StoreSpi paramX509StoreSpi)
  {
    this._provider = paramProvider;
    this._spi = paramX509StoreSpi;
  }
  
  private static X509Store createStore(X509Util.Implementation paramImplementation, X509StoreParameters paramX509StoreParameters)
  {
    X509StoreSpi localX509StoreSpi = (X509StoreSpi)paramImplementation.getEngine();
    localX509StoreSpi.engineInit(paramX509StoreParameters);
    return new X509Store(paramImplementation.getProvider(), localX509StoreSpi);
  }
  
  public static X509Store getInstance(String paramString, X509StoreParameters paramX509StoreParameters)
    throws NoSuchStoreException
  {
    try
    {
      paramString = createStore(X509Util.getImplementation("X509Store", paramString), paramX509StoreParameters);
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      throw new NoSuchStoreException(paramString.getMessage());
    }
  }
  
  public static X509Store getInstance(String paramString1, X509StoreParameters paramX509StoreParameters, String paramString2)
    throws NoSuchStoreException, NoSuchProviderException
  {
    return getInstance(paramString1, paramX509StoreParameters, X509Util.getProvider(paramString2));
  }
  
  public static X509Store getInstance(String paramString, X509StoreParameters paramX509StoreParameters, Provider paramProvider)
    throws NoSuchStoreException
  {
    try
    {
      paramString = createStore(X509Util.getImplementation("X509Store", paramString, paramProvider), paramX509StoreParameters);
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      throw new NoSuchStoreException(paramString.getMessage());
    }
  }
  
  public Collection getMatches(Selector paramSelector)
  {
    return this._spi.engineGetMatches(paramSelector);
  }
  
  public Provider getProvider()
  {
    return this._provider;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\x509\X509Store.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */