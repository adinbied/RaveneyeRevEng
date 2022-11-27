package dji.thirdparty.okhttp3;

import dji.thirdparty.okhttp3.internal.Internal;
import dji.thirdparty.okhttp3.internal.InternalCache;
import dji.thirdparty.okhttp3.internal.Platform;
import dji.thirdparty.okhttp3.internal.RouteDatabase;
import dji.thirdparty.okhttp3.internal.Util;
import dji.thirdparty.okhttp3.internal.http.HttpEngine;
import dji.thirdparty.okhttp3.internal.http.StreamAllocation;
import dji.thirdparty.okhttp3.internal.io.RealConnection;
import dji.thirdparty.okhttp3.internal.tls.OkHostnameVerifier;
import dji.thirdparty.okhttp3.internal.tls.TrustRootIndex;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.UnknownHostException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

public class OkHttpClient
  implements Cloneable, Call.Factory
{
  private static final List<ConnectionSpec> DEFAULT_CONNECTION_SPECS;
  private static final List<Protocol> DEFAULT_PROTOCOLS = Util.immutableList(new Protocol[] { Protocol.HTTP_2, Protocol.SPDY_3, Protocol.HTTP_1_1 });
  final Authenticator authenticator;
  final Cache cache;
  final CertificatePinner certificatePinner;
  final int connectTimeout;
  final ConnectionPool connectionPool;
  final List<ConnectionSpec> connectionSpecs;
  final CookieJar cookieJar;
  final Dispatcher dispatcher;
  final Dns dns;
  final boolean followRedirects;
  final boolean followSslRedirects;
  final HostnameVerifier hostnameVerifier;
  final List<Interceptor> interceptors;
  final InternalCache internalCache;
  final List<Interceptor> networkInterceptors;
  final List<Protocol> protocols;
  final Proxy proxy;
  final Authenticator proxyAuthenticator;
  final ProxySelector proxySelector;
  final int readTimeout;
  final boolean retryOnConnectionFailure;
  final SocketFactory socketFactory;
  final SSLSocketFactory sslSocketFactory;
  final TrustRootIndex trustRootIndex;
  final int writeTimeout;
  
  static
  {
    DEFAULT_CONNECTION_SPECS = Util.immutableList(new ConnectionSpec[] { ConnectionSpec.MODERN_TLS, ConnectionSpec.COMPATIBLE_TLS, ConnectionSpec.CLEARTEXT });
    Internal.instance = new Internal()
    {
      public void addLenient(Headers.Builder paramAnonymousBuilder, String paramAnonymousString)
      {
        paramAnonymousBuilder.addLenient(paramAnonymousString);
      }
      
      public void addLenient(Headers.Builder paramAnonymousBuilder, String paramAnonymousString1, String paramAnonymousString2)
      {
        paramAnonymousBuilder.addLenient(paramAnonymousString1, paramAnonymousString2);
      }
      
      public void apply(ConnectionSpec paramAnonymousConnectionSpec, SSLSocket paramAnonymousSSLSocket, boolean paramAnonymousBoolean)
      {
        paramAnonymousConnectionSpec.apply(paramAnonymousSSLSocket, paramAnonymousBoolean);
      }
      
      public StreamAllocation callEngineGetStreamAllocation(Call paramAnonymousCall)
      {
        return ((RealCall)paramAnonymousCall).engine.streamAllocation;
      }
      
      public void callEnqueue(Call paramAnonymousCall, Callback paramAnonymousCallback, boolean paramAnonymousBoolean)
      {
        ((RealCall)paramAnonymousCall).enqueue(paramAnonymousCallback, paramAnonymousBoolean);
      }
      
      public boolean connectionBecameIdle(ConnectionPool paramAnonymousConnectionPool, RealConnection paramAnonymousRealConnection)
      {
        return paramAnonymousConnectionPool.connectionBecameIdle(paramAnonymousRealConnection);
      }
      
      public RealConnection get(ConnectionPool paramAnonymousConnectionPool, Address paramAnonymousAddress, StreamAllocation paramAnonymousStreamAllocation)
      {
        return paramAnonymousConnectionPool.get(paramAnonymousAddress, paramAnonymousStreamAllocation);
      }
      
      public HttpUrl getHttpUrlChecked(String paramAnonymousString)
        throws MalformedURLException, UnknownHostException
      {
        return HttpUrl.getChecked(paramAnonymousString);
      }
      
      public InternalCache internalCache(OkHttpClient paramAnonymousOkHttpClient)
      {
        return paramAnonymousOkHttpClient.internalCache();
      }
      
      public void put(ConnectionPool paramAnonymousConnectionPool, RealConnection paramAnonymousRealConnection)
      {
        paramAnonymousConnectionPool.put(paramAnonymousRealConnection);
      }
      
      public RouteDatabase routeDatabase(ConnectionPool paramAnonymousConnectionPool)
      {
        return paramAnonymousConnectionPool.routeDatabase;
      }
      
      public void setCache(OkHttpClient.Builder paramAnonymousBuilder, InternalCache paramAnonymousInternalCache)
      {
        paramAnonymousBuilder.setInternalCache(paramAnonymousInternalCache);
      }
    };
  }
  
  public OkHttpClient()
  {
    this(new Builder());
  }
  
  private OkHttpClient(Builder paramBuilder)
  {
    this.dispatcher = paramBuilder.dispatcher;
    this.proxy = paramBuilder.proxy;
    this.protocols = paramBuilder.protocols;
    this.connectionSpecs = paramBuilder.connectionSpecs;
    this.interceptors = Util.immutableList(paramBuilder.interceptors);
    this.networkInterceptors = Util.immutableList(paramBuilder.networkInterceptors);
    this.proxySelector = paramBuilder.proxySelector;
    this.cookieJar = paramBuilder.cookieJar;
    this.cache = paramBuilder.cache;
    this.internalCache = paramBuilder.internalCache;
    this.socketFactory = paramBuilder.socketFactory;
    Object localObject = this.connectionSpecs.iterator();
    for (int i = 0;; i = 1)
    {
      if (!((Iterator)localObject).hasNext()) {
        break label147;
      }
      ConnectionSpec localConnectionSpec = (ConnectionSpec)((Iterator)localObject).next();
      if ((i == 0) && (!localConnectionSpec.isTls())) {
        break;
      }
    }
    label147:
    if ((paramBuilder.sslSocketFactory == null) && (i != 0)) {}
    try
    {
      localObject = SSLContext.getInstance("TLS");
      ((SSLContext)localObject).init(null, null, null);
      this.sslSocketFactory = ((SSLContext)localObject).getSocketFactory();
    }
    catch (GeneralSecurityException paramBuilder)
    {
      for (;;) {}
    }
    throw new AssertionError();
    this.sslSocketFactory = paramBuilder.sslSocketFactory;
    if ((this.sslSocketFactory != null) && (paramBuilder.trustRootIndex == null))
    {
      localObject = Platform.get().trustManager(this.sslSocketFactory);
      if (localObject != null)
      {
        this.trustRootIndex = Platform.get().trustRootIndex((X509TrustManager)localObject);
        this.certificatePinner = paramBuilder.certificatePinner.newBuilder().trustRootIndex(this.trustRootIndex).build();
      }
      else
      {
        paramBuilder = new StringBuilder();
        paramBuilder.append("Unable to extract the trust manager on ");
        paramBuilder.append(Platform.get());
        paramBuilder.append(", sslSocketFactory is ");
        paramBuilder.append(this.sslSocketFactory.getClass());
        throw new IllegalStateException(paramBuilder.toString());
      }
    }
    else
    {
      this.trustRootIndex = paramBuilder.trustRootIndex;
      this.certificatePinner = paramBuilder.certificatePinner;
    }
    this.hostnameVerifier = paramBuilder.hostnameVerifier;
    this.proxyAuthenticator = paramBuilder.proxyAuthenticator;
    this.authenticator = paramBuilder.authenticator;
    this.connectionPool = paramBuilder.connectionPool;
    this.dns = paramBuilder.dns;
    this.followSslRedirects = paramBuilder.followSslRedirects;
    this.followRedirects = paramBuilder.followRedirects;
    this.retryOnConnectionFailure = paramBuilder.retryOnConnectionFailure;
    this.connectTimeout = paramBuilder.connectTimeout;
    this.readTimeout = paramBuilder.readTimeout;
    this.writeTimeout = paramBuilder.writeTimeout;
  }
  
  public Authenticator authenticator()
  {
    return this.authenticator;
  }
  
  public Cache cache()
  {
    return this.cache;
  }
  
  public CertificatePinner certificatePinner()
  {
    return this.certificatePinner;
  }
  
  public int connectTimeoutMillis()
  {
    return this.connectTimeout;
  }
  
  public ConnectionPool connectionPool()
  {
    return this.connectionPool;
  }
  
  public List<ConnectionSpec> connectionSpecs()
  {
    return this.connectionSpecs;
  }
  
  public CookieJar cookieJar()
  {
    return this.cookieJar;
  }
  
  public Dispatcher dispatcher()
  {
    return this.dispatcher;
  }
  
  public Dns dns()
  {
    return this.dns;
  }
  
  public boolean followRedirects()
  {
    return this.followRedirects;
  }
  
  public boolean followSslRedirects()
  {
    return this.followSslRedirects;
  }
  
  public HostnameVerifier hostnameVerifier()
  {
    return this.hostnameVerifier;
  }
  
  public List<Interceptor> interceptors()
  {
    return this.interceptors;
  }
  
  InternalCache internalCache()
  {
    return null;
  }
  
  public List<Interceptor> networkInterceptors()
  {
    return this.networkInterceptors;
  }
  
  public Builder newBuilder()
  {
    return new Builder(this);
  }
  
  public Call newCall(Request paramRequest)
  {
    return new RealCall(this, paramRequest);
  }
  
  public List<Protocol> protocols()
  {
    return this.protocols;
  }
  
  public Proxy proxy()
  {
    return this.proxy;
  }
  
  public Authenticator proxyAuthenticator()
  {
    return this.proxyAuthenticator;
  }
  
  public ProxySelector proxySelector()
  {
    return this.proxySelector;
  }
  
  public int readTimeoutMillis()
  {
    return this.readTimeout;
  }
  
  public boolean retryOnConnectionFailure()
  {
    return this.retryOnConnectionFailure;
  }
  
  public SocketFactory socketFactory()
  {
    return this.socketFactory;
  }
  
  public SSLSocketFactory sslSocketFactory()
  {
    return this.sslSocketFactory;
  }
  
  public int writeTimeoutMillis()
  {
    return this.writeTimeout;
  }
  
  public static final class Builder
  {
    Authenticator authenticator;
    Cache cache;
    CertificatePinner certificatePinner;
    int connectTimeout;
    ConnectionPool connectionPool;
    List<ConnectionSpec> connectionSpecs;
    CookieJar cookieJar;
    Dispatcher dispatcher;
    Dns dns;
    boolean followRedirects;
    boolean followSslRedirects;
    HostnameVerifier hostnameVerifier;
    final List<Interceptor> interceptors = new ArrayList();
    InternalCache internalCache;
    final List<Interceptor> networkInterceptors = new ArrayList();
    List<Protocol> protocols;
    Proxy proxy;
    Authenticator proxyAuthenticator;
    ProxySelector proxySelector;
    int readTimeout;
    boolean retryOnConnectionFailure;
    SocketFactory socketFactory;
    SSLSocketFactory sslSocketFactory;
    TrustRootIndex trustRootIndex;
    int writeTimeout;
    
    public Builder()
    {
      this.dispatcher = new Dispatcher();
      this.protocols = OkHttpClient.DEFAULT_PROTOCOLS;
      this.connectionSpecs = OkHttpClient.DEFAULT_CONNECTION_SPECS;
      this.proxySelector = ProxySelector.getDefault();
      this.cookieJar = CookieJar.NO_COOKIES;
      this.socketFactory = SocketFactory.getDefault();
      this.hostnameVerifier = OkHostnameVerifier.INSTANCE;
      this.certificatePinner = CertificatePinner.DEFAULT;
      this.proxyAuthenticator = Authenticator.NONE;
      this.authenticator = Authenticator.NONE;
      this.connectionPool = new ConnectionPool();
      this.dns = Dns.SYSTEM;
      this.followSslRedirects = true;
      this.followRedirects = true;
      this.retryOnConnectionFailure = true;
      this.connectTimeout = 10000;
      this.readTimeout = 10000;
      this.writeTimeout = 10000;
    }
    
    Builder(OkHttpClient paramOkHttpClient)
    {
      this.dispatcher = paramOkHttpClient.dispatcher;
      this.proxy = paramOkHttpClient.proxy;
      this.protocols = paramOkHttpClient.protocols;
      this.connectionSpecs = paramOkHttpClient.connectionSpecs;
      this.interceptors.addAll(paramOkHttpClient.interceptors);
      this.networkInterceptors.addAll(paramOkHttpClient.networkInterceptors);
      this.proxySelector = paramOkHttpClient.proxySelector;
      this.cookieJar = paramOkHttpClient.cookieJar;
      this.internalCache = paramOkHttpClient.internalCache;
      this.cache = paramOkHttpClient.cache;
      this.socketFactory = paramOkHttpClient.socketFactory;
      this.sslSocketFactory = paramOkHttpClient.sslSocketFactory;
      this.trustRootIndex = paramOkHttpClient.trustRootIndex;
      this.hostnameVerifier = paramOkHttpClient.hostnameVerifier;
      this.certificatePinner = paramOkHttpClient.certificatePinner;
      this.proxyAuthenticator = paramOkHttpClient.proxyAuthenticator;
      this.authenticator = paramOkHttpClient.authenticator;
      this.connectionPool = paramOkHttpClient.connectionPool;
      this.dns = paramOkHttpClient.dns;
      this.followSslRedirects = paramOkHttpClient.followSslRedirects;
      this.followRedirects = paramOkHttpClient.followRedirects;
      this.retryOnConnectionFailure = paramOkHttpClient.retryOnConnectionFailure;
      this.connectTimeout = paramOkHttpClient.connectTimeout;
      this.readTimeout = paramOkHttpClient.readTimeout;
      this.writeTimeout = paramOkHttpClient.writeTimeout;
    }
    
    public Builder addInterceptor(Interceptor paramInterceptor)
    {
      this.interceptors.add(paramInterceptor);
      return this;
    }
    
    public Builder addNetworkInterceptor(Interceptor paramInterceptor)
    {
      this.networkInterceptors.add(paramInterceptor);
      return this;
    }
    
    public Builder authenticator(Authenticator paramAuthenticator)
    {
      return null;
    }
    
    public OkHttpClient build()
    {
      return new OkHttpClient(this, null);
    }
    
    public Builder cache(Cache paramCache)
    {
      this.cache = paramCache;
      this.internalCache = null;
      return this;
    }
    
    public Builder certificatePinner(CertificatePinner paramCertificatePinner)
    {
      return null;
    }
    
    public Builder connectTimeout(long paramLong, TimeUnit paramTimeUnit)
    {
      return null;
    }
    
    public Builder connectionPool(ConnectionPool paramConnectionPool)
    {
      return null;
    }
    
    public Builder connectionSpecs(List<ConnectionSpec> paramList)
    {
      this.connectionSpecs = Util.immutableList(paramList);
      return this;
    }
    
    public Builder cookieJar(CookieJar paramCookieJar)
    {
      return null;
    }
    
    public Builder dispatcher(Dispatcher paramDispatcher)
    {
      return null;
    }
    
    public Builder dns(Dns paramDns)
    {
      return null;
    }
    
    public Builder followRedirects(boolean paramBoolean)
    {
      this.followRedirects = paramBoolean;
      return this;
    }
    
    public Builder followSslRedirects(boolean paramBoolean)
    {
      this.followSslRedirects = paramBoolean;
      return this;
    }
    
    public Builder hostnameVerifier(HostnameVerifier paramHostnameVerifier)
    {
      return null;
    }
    
    public List<Interceptor> interceptors()
    {
      return this.interceptors;
    }
    
    public List<Interceptor> networkInterceptors()
    {
      return this.networkInterceptors;
    }
    
    public Builder protocols(List<Protocol> paramList)
    {
      return null;
    }
    
    public Builder proxy(Proxy paramProxy)
    {
      this.proxy = paramProxy;
      return this;
    }
    
    public Builder proxyAuthenticator(Authenticator paramAuthenticator)
    {
      return null;
    }
    
    public Builder proxySelector(ProxySelector paramProxySelector)
    {
      this.proxySelector = paramProxySelector;
      return this;
    }
    
    public Builder readTimeout(long paramLong, TimeUnit paramTimeUnit)
    {
      return null;
    }
    
    public Builder retryOnConnectionFailure(boolean paramBoolean)
    {
      this.retryOnConnectionFailure = paramBoolean;
      return this;
    }
    
    void setInternalCache(InternalCache paramInternalCache)
    {
      this.internalCache = paramInternalCache;
      this.cache = null;
    }
    
    public Builder socketFactory(SocketFactory paramSocketFactory)
    {
      return null;
    }
    
    public Builder sslSocketFactory(SSLSocketFactory paramSSLSocketFactory)
    {
      return null;
    }
    
    public Builder writeTimeout(long paramLong, TimeUnit paramTimeUnit)
    {
      return null;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\okhttp3\OkHttpClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */