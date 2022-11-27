package com.huawei.updatesdk.sdk.a.b;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public class c
  implements X509TrustManager
{
  protected List<X509TrustManager> a = new ArrayList();
  
  public c(Context paramContext)
    throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, IllegalArgumentException
  {
    TrustManager[] arrayOfTrustManager;
    Object localObject;
    if (paramContext != null)
    {
      arrayOfTrustManager = null;
      localObject = arrayOfTrustManager;
    }
    for (;;)
    {
      int i;
      try
      {
        TrustManagerFactory localTrustManagerFactory = TrustManagerFactory.getInstance("X509");
        localObject = arrayOfTrustManager;
        KeyStore localKeyStore = KeyStore.getInstance("bks");
        localObject = arrayOfTrustManager;
        paramContext = paramContext.getAssets().open("hmsrootcas.bks");
        localObject = paramContext;
        paramContext.reset();
        localObject = paramContext;
        localKeyStore.load(paramContext, "".toCharArray());
        localObject = paramContext;
        localTrustManagerFactory.init(localKeyStore);
        localObject = paramContext;
        arrayOfTrustManager = localTrustManagerFactory.getTrustManagers();
        i = 0;
        localObject = paramContext;
        if (i < arrayOfTrustManager.length)
        {
          localObject = paramContext;
          if (!(arrayOfTrustManager[i] instanceof X509TrustManager)) {
            break label238;
          }
          localObject = paramContext;
          this.a.add((X509TrustManager)arrayOfTrustManager[i]);
          break label238;
        }
        localObject = paramContext;
        boolean bool = this.a.isEmpty();
        if (bool) {}
      }
      finally
      {
        if (localObject == null) {}
      }
      try
      {
        paramContext.close();
        return;
      }
      catch (IOException paramContext)
      {
        continue;
      }
      Log.e("SecureX509TrustManager", "close bks exception");
      return;
      localObject = paramContext;
      throw new CertificateException("X509TrustManager is empty");
      try
      {
        ((InputStream)localObject).close();
      }
      catch (IOException localIOException)
      {
        for (;;) {}
      }
      Log.e("SecureX509TrustManager", "close bks exception");
      throw paramContext;
      throw new IllegalArgumentException("context is null");
      label238:
      i += 1;
    }
  }
  
  /* Error */
  public void checkClientTrusted(X509Certificate[] arg1, String arg2)
    throws CertificateException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void checkServerTrusted(X509Certificate[] arg1, String arg2)
    throws CertificateException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public X509Certificate[] getAcceptedIssuers()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawe\\updatesdk\sdk\a\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */