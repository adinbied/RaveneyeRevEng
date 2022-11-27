package org.bouncycastle.est.jcajce;

import java.net.Socket;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import javax.net.ssl.KeyManager;
import javax.net.ssl.X509TrustManager;
import org.bouncycastle.est.ESTClientProvider;
import org.bouncycastle.est.ESTService;
import org.bouncycastle.est.ESTServiceBuilder;

public class JsseESTServiceBuilder
  extends ESTServiceBuilder
{
  protected Long absoluteLimit;
  protected ChannelBindingProvider bindingProvider;
  protected boolean filterCipherSuites = true;
  protected JsseHostnameAuthorizer hostNameAuthorizer = new JsseDefaultHostnameAuthorizer(null);
  protected SSLSocketFactoryCreator socketFactoryCreator;
  protected SSLSocketFactoryCreatorBuilder sslSocketFactoryCreatorBuilder;
  protected Set<String> supportedSuites = new HashSet();
  protected int timeoutMillis = 0;
  
  public JsseESTServiceBuilder(String paramString)
  {
    super(paramString);
    this.sslSocketFactoryCreatorBuilder = new SSLSocketFactoryCreatorBuilder(JcaJceUtils.getTrustAllTrustManager());
  }
  
  public JsseESTServiceBuilder(String paramString, X509TrustManager paramX509TrustManager)
  {
    super(paramString);
    this.sslSocketFactoryCreatorBuilder = new SSLSocketFactoryCreatorBuilder(paramX509TrustManager);
  }
  
  public JsseESTServiceBuilder(String paramString, SSLSocketFactoryCreator paramSSLSocketFactoryCreator)
  {
    super(paramString);
    if (paramSSLSocketFactoryCreator != null)
    {
      this.socketFactoryCreator = paramSSLSocketFactoryCreator;
      return;
    }
    throw new NullPointerException("No socket factory creator.");
  }
  
  public JsseESTServiceBuilder(String paramString, X509TrustManager[] paramArrayOfX509TrustManager)
  {
    super(paramString);
    this.sslSocketFactoryCreatorBuilder = new SSLSocketFactoryCreatorBuilder(paramArrayOfX509TrustManager);
  }
  
  public JsseESTServiceBuilder addCipherSuites(String paramString)
  {
    this.supportedSuites.add(paramString);
    return this;
  }
  
  public JsseESTServiceBuilder addCipherSuites(String[] paramArrayOfString)
  {
    this.supportedSuites.addAll(Arrays.asList(paramArrayOfString));
    return this;
  }
  
  public ESTService build()
  {
    if (this.bindingProvider == null) {
      this.bindingProvider = new ChannelBindingProvider()
      {
        public boolean canAccessChannelBinding(Socket paramAnonymousSocket)
        {
          return false;
        }
        
        public byte[] getChannelBinding(Socket paramAnonymousSocket, String paramAnonymousString)
        {
          return null;
        }
      };
    }
    if (this.socketFactoryCreator == null) {
      this.socketFactoryCreator = this.sslSocketFactoryCreatorBuilder.build();
    }
    if (this.clientProvider == null) {
      this.clientProvider = new DefaultESTHttpClientProvider(this.hostNameAuthorizer, this.socketFactoryCreator, this.timeoutMillis, this.bindingProvider, this.supportedSuites, this.absoluteLimit, this.filterCipherSuites);
    }
    return super.build();
  }
  
  public JsseESTServiceBuilder withChannelBindingProvider(ChannelBindingProvider paramChannelBindingProvider)
  {
    this.bindingProvider = paramChannelBindingProvider;
    return this;
  }
  
  public JsseESTServiceBuilder withClientProvider(ESTClientProvider paramESTClientProvider)
  {
    this.clientProvider = paramESTClientProvider;
    return this;
  }
  
  public JsseESTServiceBuilder withFilterCipherSuites(boolean paramBoolean)
  {
    this.filterCipherSuites = paramBoolean;
    return this;
  }
  
  public JsseESTServiceBuilder withHostNameAuthorizer(JsseHostnameAuthorizer paramJsseHostnameAuthorizer)
  {
    this.hostNameAuthorizer = paramJsseHostnameAuthorizer;
    return this;
  }
  
  public JsseESTServiceBuilder withKeyManager(KeyManager paramKeyManager)
  {
    if (this.socketFactoryCreator == null)
    {
      this.sslSocketFactoryCreatorBuilder.withKeyManager(paramKeyManager);
      return this;
    }
    throw new IllegalStateException("Socket Factory Creator was defined in the constructor.");
  }
  
  public JsseESTServiceBuilder withKeyManagers(KeyManager[] paramArrayOfKeyManager)
  {
    if (this.socketFactoryCreator == null)
    {
      this.sslSocketFactoryCreatorBuilder.withKeyManagers(paramArrayOfKeyManager);
      return this;
    }
    throw new IllegalStateException("Socket Factory Creator was defined in the constructor.");
  }
  
  public JsseESTServiceBuilder withProvider(String paramString)
    throws NoSuchProviderException
  {
    if (this.socketFactoryCreator == null)
    {
      this.sslSocketFactoryCreatorBuilder.withProvider(paramString);
      return this;
    }
    throw new IllegalStateException("Socket Factory Creator was defined in the constructor.");
  }
  
  public JsseESTServiceBuilder withProvider(Provider paramProvider)
  {
    if (this.socketFactoryCreator == null)
    {
      this.sslSocketFactoryCreatorBuilder.withProvider(paramProvider);
      return this;
    }
    throw new IllegalStateException("Socket Factory Creator was defined in the constructor.");
  }
  
  public JsseESTServiceBuilder withReadLimit(long paramLong)
  {
    this.absoluteLimit = Long.valueOf(paramLong);
    return this;
  }
  
  public JsseESTServiceBuilder withSecureRandom(SecureRandom paramSecureRandom)
  {
    if (this.socketFactoryCreator == null)
    {
      this.sslSocketFactoryCreatorBuilder.withSecureRandom(paramSecureRandom);
      return this;
    }
    throw new IllegalStateException("Socket Factory Creator was defined in the constructor.");
  }
  
  public JsseESTServiceBuilder withTLSVersion(String paramString)
  {
    if (this.socketFactoryCreator == null)
    {
      this.sslSocketFactoryCreatorBuilder.withTLSVersion(paramString);
      return this;
    }
    throw new IllegalStateException("Socket Factory Creator was defined in the constructor.");
  }
  
  public JsseESTServiceBuilder withTimeout(int paramInt)
  {
    this.timeoutMillis = paramInt;
    return this;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\est\jcajce\JsseESTServiceBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */