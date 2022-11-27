package org.bouncycastle.est.jcajce;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.Security;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

class SSLSocketFactoryCreatorBuilder
{
  protected KeyManager[] keyManagers;
  protected SecureRandom secureRandom = new SecureRandom();
  protected Provider tlsProvider;
  protected String tlsVersion = "TLS";
  protected X509TrustManager[] trustManagers;
  
  public SSLSocketFactoryCreatorBuilder(X509TrustManager paramX509TrustManager)
  {
    if (paramX509TrustManager != null)
    {
      this.trustManagers = new X509TrustManager[] { paramX509TrustManager };
      return;
    }
    throw new NullPointerException("Trust managers can not be null");
  }
  
  public SSLSocketFactoryCreatorBuilder(X509TrustManager[] paramArrayOfX509TrustManager)
  {
    if (paramArrayOfX509TrustManager != null)
    {
      this.trustManagers = paramArrayOfX509TrustManager;
      return;
    }
    throw new NullPointerException("Trust managers can not be null");
  }
  
  public SSLSocketFactoryCreator build()
  {
    new SSLSocketFactoryCreator()
    {
      public SSLSocketFactory createFactory()
        throws NoSuchAlgorithmException, NoSuchProviderException, KeyManagementException
      {
        SSLContext localSSLContext;
        if (SSLSocketFactoryCreatorBuilder.this.tlsProvider != null) {
          localSSLContext = SSLContext.getInstance(SSLSocketFactoryCreatorBuilder.this.tlsVersion, SSLSocketFactoryCreatorBuilder.this.tlsProvider);
        } else {
          localSSLContext = SSLContext.getInstance(SSLSocketFactoryCreatorBuilder.this.tlsVersion);
        }
        localSSLContext.init(SSLSocketFactoryCreatorBuilder.this.keyManagers, SSLSocketFactoryCreatorBuilder.this.trustManagers, SSLSocketFactoryCreatorBuilder.this.secureRandom);
        return localSSLContext.getSocketFactory();
      }
      
      public boolean isTrusted()
      {
        int i = 0;
        while (i != SSLSocketFactoryCreatorBuilder.this.trustManagers.length)
        {
          if (SSLSocketFactoryCreatorBuilder.this.trustManagers[i].getAcceptedIssuers().length > 0) {
            return true;
          }
          i += 1;
        }
        return false;
      }
    };
  }
  
  public SSLSocketFactoryCreatorBuilder withKeyManager(KeyManager paramKeyManager)
  {
    if (paramKeyManager == null)
    {
      this.keyManagers = null;
      return this;
    }
    this.keyManagers = new KeyManager[] { paramKeyManager };
    return this;
  }
  
  public SSLSocketFactoryCreatorBuilder withKeyManagers(KeyManager[] paramArrayOfKeyManager)
  {
    this.keyManagers = paramArrayOfKeyManager;
    return this;
  }
  
  public SSLSocketFactoryCreatorBuilder withProvider(String paramString)
    throws NoSuchProviderException
  {
    Object localObject = Security.getProvider(paramString);
    this.tlsProvider = ((Provider)localObject);
    if (localObject != null) {
      return this;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("JSSE provider not found: ");
    ((StringBuilder)localObject).append(paramString);
    throw new NoSuchProviderException(((StringBuilder)localObject).toString());
  }
  
  public SSLSocketFactoryCreatorBuilder withProvider(Provider paramProvider)
  {
    this.tlsProvider = paramProvider;
    return this;
  }
  
  public SSLSocketFactoryCreatorBuilder withSecureRandom(SecureRandom paramSecureRandom)
  {
    this.secureRandom = paramSecureRandom;
    return this;
  }
  
  public SSLSocketFactoryCreatorBuilder withTLSVersion(String paramString)
  {
    this.tlsVersion = paramString;
    return this;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\est\jcajce\SSLSocketFactoryCreatorBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */