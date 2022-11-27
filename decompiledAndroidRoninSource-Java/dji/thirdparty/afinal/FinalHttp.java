package dji.thirdparty.afinal;

import android.os.Build;
import android.os.Build.VERSION;
import dji.thirdparty.afinal.http.AjaxCallBack;
import dji.thirdparty.afinal.http.AjaxParams;
import dji.thirdparty.afinal.http.HttpHandler;
import dji.thirdparty.afinal.http.RetryHandler;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.URI;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.HttpVersion;
import org.apache.http.ProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.HttpEntityWrapper;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.DefaultRedirectHandler;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.SyncBasicHttpContext;

@Deprecated
public class FinalHttp
{
  private static final int DEFAULT_SOCKET_BUFFER_SIZE = 8192;
  private static final String ENCODING_GZIP = "gzip";
  private static final String HEADER_ACCEPT_ENCODING = "Accept-Encoding";
  private static final String TAG = FinalHttp.class.getSimpleName();
  private static final Executor executor;
  private static int httpThreadCount;
  private static int maxConnections = 10;
  private static int maxRetries;
  private static final ThreadFactory sThreadFactory;
  private static int socketConnectTimeout;
  private static int socketSoTimeout = 30000;
  private static int socketTimeout;
  private String charset = "utf-8";
  private final Map<String, String> clientHeaderMap;
  private final DefaultHttpClient httpClient;
  private final HttpContext httpContext;
  
  static
  {
    socketConnectTimeout = 4000;
    socketTimeout = 2000;
    maxRetries = 3;
    httpThreadCount = 6;
    ThreadFactory local1 = new ThreadFactory()
    {
      private final AtomicInteger mCount = new AtomicInteger(1);
      
      public Thread newThread(Runnable paramAnonymousRunnable)
      {
        return null;
      }
    };
    sThreadFactory = local1;
    executor = Executors.newFixedThreadPool(httpThreadCount, local1);
  }
  
  @Deprecated
  public FinalHttp()
  {
    Object localObject1 = new BasicHttpParams();
    ((BasicHttpParams)localObject1).setParameter("http.protocol.allow-circular-redirects", Boolean.valueOf(true));
    ConnManagerParams.setTimeout((HttpParams)localObject1, socketTimeout);
    ConnManagerParams.setMaxConnectionsPerRoute((HttpParams)localObject1, new ConnPerRouteBean(maxConnections));
    ConnManagerParams.setMaxTotalConnections((HttpParams)localObject1, 10);
    HttpConnectionParams.setSoTimeout((HttpParams)localObject1, socketSoTimeout);
    HttpConnectionParams.setConnectionTimeout((HttpParams)localObject1, socketConnectTimeout);
    HttpConnectionParams.setTcpNoDelay((HttpParams)localObject1, true);
    HttpConnectionParams.setSocketBufferSize((HttpParams)localObject1, 8192);
    HttpProtocolParams.setVersion((HttpParams)localObject1, HttpVersion.HTTP_1_1);
    Object localObject2 = new SchemeRegistry();
    ((SchemeRegistry)localObject2).register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
    ((SchemeRegistry)localObject2).register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
    localObject2 = new ThreadSafeClientConnManager((HttpParams)localObject1, (SchemeRegistry)localObject2);
    this.httpContext = new SyncBasicHttpContext(new BasicHttpContext());
    localObject1 = new DefaultHttpClient((ClientConnectionManager)localObject2, (HttpParams)localObject1);
    this.httpClient = ((DefaultHttpClient)localObject1);
    ((DefaultHttpClient)localObject1).addRequestInterceptor(new HttpRequestInterceptor()
    {
      /* Error */
      public void process(org.apache.http.HttpRequest arg1, HttpContext arg2)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: goto -2 -> 0
      }
    });
    this.httpClient.addResponseInterceptor(new HttpResponseInterceptor()
    {
      /* Error */
      public void process(HttpResponse arg1, HttpContext arg2)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: goto -2 -> 0
      }
    });
    this.httpClient.setRedirectHandler(new SpaceRedirectHandler(null));
    this.httpClient.setHttpRequestRetryHandler(new RetryHandler(maxRetries));
    this.clientHeaderMap = new HashMap();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("DJI/Android/");
    ((StringBuilder)localObject1).append(Build.PRODUCT);
    ((StringBuilder)localObject1).append("/");
    ((StringBuilder)localObject1).append(Build.MODEL);
    ((StringBuilder)localObject1).append("/");
    ((StringBuilder)localObject1).append(Build.BRAND);
    ((StringBuilder)localObject1).append("/");
    ((StringBuilder)localObject1).append(Build.VERSION.SDK_INT);
    ((StringBuilder)localObject1).append("/");
    configUserAgent(((StringBuilder)localObject1).toString());
  }
  
  private HttpEntityEnclosingRequestBase addEntityToRequestBase(HttpEntityEnclosingRequestBase paramHttpEntityEnclosingRequestBase, HttpEntity paramHttpEntity)
  {
    if (paramHttpEntity != null) {
      paramHttpEntityEnclosingRequestBase.setEntity(paramHttpEntity);
    }
    return paramHttpEntityEnclosingRequestBase;
  }
  
  /* Error */
  private void configUserAgent(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static String getUrlWithQueryString(String paramString, AjaxParams paramAjaxParams)
  {
    Object localObject = paramString;
    if (paramAjaxParams != null)
    {
      paramAjaxParams = paramAjaxParams.getParamString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("?");
      ((StringBuilder)localObject).append(paramAjaxParams);
      localObject = ((StringBuilder)localObject).toString();
    }
    return (String)localObject;
  }
  
  private HttpEntity paramsToEntity(AjaxParams paramAjaxParams)
  {
    if (paramAjaxParams != null) {
      return paramAjaxParams.getEntity();
    }
    return null;
  }
  
  public void addHeader(String paramString1, String paramString2)
  {
    this.clientHeaderMap.put(paramString1, paramString2);
  }
  
  /* Error */
  public void configCharset(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void configCookieStore(CookieStore paramCookieStore)
  {
    this.httpContext.setAttribute("http.cookie-store", paramCookieStore);
  }
  
  /* Error */
  public void configRequestExecutionRetryCount(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void configSSLSocketFactory(SSLSocketFactory arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void configTimeout(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void delete(String arg1, AjaxCallBack<? extends Object> arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void delete(String arg1, AjaxParams arg2, AjaxCallBack<? extends Object> arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void delete(String arg1, Header[] arg2, AjaxCallBack<? extends Object> arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public Object deleteSync(String paramString)
  {
    return deleteSync(paramString, null);
  }
  
  public Object deleteSync(String paramString, Header[] paramArrayOfHeader)
  {
    return null;
  }
  
  public HttpHandler<File> download(String paramString1, AjaxParams paramAjaxParams, String paramString2, AjaxCallBack<File> paramAjaxCallBack)
  {
    return null;
  }
  
  public HttpHandler<File> download(String paramString1, AjaxParams paramAjaxParams, String paramString2, boolean paramBoolean1, boolean paramBoolean2, AjaxCallBack<File> paramAjaxCallBack)
  {
    return null;
  }
  
  public HttpHandler<File> download(String paramString1, String paramString2, AjaxCallBack<File> paramAjaxCallBack)
  {
    return null;
  }
  
  public HttpHandler<File> download(String paramString1, String paramString2, boolean paramBoolean, AjaxCallBack<File> paramAjaxCallBack)
  {
    return null;
  }
  
  public HttpHandler<File> downloadCheck(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, AjaxCallBack<File> paramAjaxCallBack)
  {
    return null;
  }
  
  public void get(String paramString, AjaxCallBack<? extends Object> paramAjaxCallBack)
  {
    get(paramString, null, paramAjaxCallBack);
  }
  
  /* Error */
  public void get(String arg1, AjaxParams arg2, AjaxCallBack<? extends Object> arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void get(String arg1, Header[] arg2, AjaxParams arg3, AjaxCallBack<? extends Object> arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public HttpClient getHttpClient()
  {
    return this.httpClient;
  }
  
  public HttpContext getHttpContext()
  {
    return this.httpContext;
  }
  
  public Object getSync(String paramString)
  {
    return getSync(paramString, null);
  }
  
  public Object getSync(String paramString, AjaxParams paramAjaxParams)
  {
    return null;
  }
  
  public Object getSync(String paramString, Header[] paramArrayOfHeader, AjaxParams paramAjaxParams)
  {
    return null;
  }
  
  public void post(String paramString, AjaxCallBack<? extends Object> paramAjaxCallBack)
  {
    post(paramString, null, paramAjaxCallBack);
  }
  
  /* Error */
  public void post(String arg1, AjaxParams arg2, AjaxCallBack<? extends Object> arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void post(String arg1, HttpEntity arg2, String arg3, AjaxCallBack<? extends Object> arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public <T> void post(String arg1, Header[] arg2, AjaxParams arg3, String arg4, AjaxCallBack<T> arg5)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void post(String arg1, Header[] arg2, HttpEntity arg3, String arg4, AjaxCallBack<? extends Object> arg5)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public HttpHandler<File> postDownload(String paramString1, String paramString2, HttpEntity paramHttpEntity, String paramString3, boolean paramBoolean, AjaxCallBack<File> paramAjaxCallBack)
  {
    return null;
  }
  
  public HttpHandler<File> postDownload(String paramString1, String paramString2, HttpEntity paramHttpEntity, String paramString3, boolean paramBoolean1, boolean paramBoolean2, AjaxCallBack<File> paramAjaxCallBack)
  {
    return null;
  }
  
  public Object postSync(String paramString)
  {
    return postSync(paramString, null);
  }
  
  public Object postSync(String paramString, AjaxParams paramAjaxParams)
  {
    return null;
  }
  
  public Object postSync(String paramString1, HttpEntity paramHttpEntity, String paramString2)
  {
    return null;
  }
  
  public Object postSync(String paramString1, Header[] paramArrayOfHeader, AjaxParams paramAjaxParams, String paramString2)
  {
    return null;
  }
  
  public Object postSync(String paramString1, Header[] paramArrayOfHeader, HttpEntity paramHttpEntity, String paramString2)
  {
    return null;
  }
  
  public void put(String paramString, AjaxCallBack<? extends Object> paramAjaxCallBack)
  {
    put(paramString, null, paramAjaxCallBack);
  }
  
  /* Error */
  public void put(String arg1, AjaxParams arg2, AjaxCallBack<? extends Object> arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void put(String arg1, HttpEntity arg2, String arg3, AjaxCallBack<? extends Object> arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void put(String arg1, Header[] arg2, HttpEntity arg3, String arg4, AjaxCallBack<? extends Object> arg5)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public Object putSync(String paramString)
  {
    return putSync(paramString, null);
  }
  
  public Object putSync(String paramString, AjaxParams paramAjaxParams)
  {
    return null;
  }
  
  public Object putSync(String paramString1, HttpEntity paramHttpEntity, String paramString2)
  {
    return putSync(paramString1, null, paramHttpEntity, paramString2);
  }
  
  public Object putSync(String paramString1, Header[] paramArrayOfHeader, HttpEntity paramHttpEntity, String paramString2)
  {
    return null;
  }
  
  /* Error */
  protected <T> void sendRequest(DefaultHttpClient arg1, HttpContext arg2, HttpUriRequest arg3, String arg4, AjaxCallBack<T> arg5)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected Object sendSyncRequest(DefaultHttpClient paramDefaultHttpClient, HttpContext paramHttpContext, HttpUriRequest paramHttpUriRequest, String paramString)
  {
    return null;
  }
  
  private static final class EasyX509TrustManager
    implements X509TrustManager
  {
    private X509TrustManager defaultTM = null;
    
    public EasyX509TrustManager(KeyStore paramKeyStore)
      throws NoSuchAlgorithmException, KeyStoreException
    {
      TrustManagerFactory localTrustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
      localTrustManagerFactory.init(paramKeyStore);
      paramKeyStore = localTrustManagerFactory.getTrustManagers();
      if ((paramKeyStore != null) && (paramKeyStore.length > 0))
      {
        this.defaultTM = findTrustManager(paramKeyStore);
        return;
      }
      throw new NoSuchAlgorithmException("no trust manager found");
    }
    
    private X509TrustManager findTrustManager(TrustManager[] paramArrayOfTrustManager)
    {
      return null;
    }
    
    private boolean searchRootCert(X509Certificate paramX509Certificate)
    {
      return false;
    }
    
    public void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
      throws CertificateException
    {
      X509TrustManager localX509TrustManager = this.defaultTM;
      if (localX509TrustManager != null) {
        localX509TrustManager.checkClientTrusted(paramArrayOfX509Certificate, paramString);
      }
    }
    
    /* Error */
    public void checkServerTrusted(X509Certificate[] arg1, String arg2)
      throws CertificateException
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    public X509Certificate[] getAcceptedIssuers()
    {
      return null;
    }
  }
  
  private static class InflatingEntity
    extends HttpEntityWrapper
  {
    public InflatingEntity(HttpEntity paramHttpEntity)
    {
      super();
    }
    
    public InputStream getContent()
      throws IOException
    {
      return null;
    }
    
    public long getContentLength()
    {
      return -1L;
    }
  }
  
  private static final class MySSLSocketFactory
    extends SSLSocketFactory
  {
    private SSLContext mSslContext;
    
    public MySSLSocketFactory(KeyStore paramKeyStore)
      throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException
    {
      super();
      SSLContext localSSLContext = SSLContext.getInstance("TLS");
      this.mSslContext = localSSLContext;
      paramKeyStore = new FinalHttp.EasyX509TrustManager(paramKeyStore);
      SecureRandom localSecureRandom = new SecureRandom();
      localSSLContext.init(null, new TrustManager[] { paramKeyStore }, localSecureRandom);
    }
    
    public Socket createSocket()
      throws IOException
    {
      return null;
    }
    
    public Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean)
      throws IOException, UnknownHostException
    {
      return null;
    }
  }
  
  private static final class SpaceRedirectHandler
    extends DefaultRedirectHandler
  {
    private URI sanitizeUrl(String paramString)
      throws ProtocolException
    {
      return null;
    }
    
    public URI getLocationURI(HttpResponse paramHttpResponse, HttpContext paramHttpContext)
      throws ProtocolException
    {
      return sanitizeUrl(paramHttpResponse.getFirstHeader("location").getValue());
    }
    
    public boolean isRedirectRequested(HttpResponse paramHttpResponse, HttpContext paramHttpContext)
    {
      return super.isRedirectRequested(paramHttpResponse, paramHttpContext);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\afinal\FinalHttp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */