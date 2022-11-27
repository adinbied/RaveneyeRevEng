package dji.thirdparty.okhttp3.internal;

import dji.thirdparty.okhttp3.Address;
import dji.thirdparty.okhttp3.Call;
import dji.thirdparty.okhttp3.Callback;
import dji.thirdparty.okhttp3.ConnectionPool;
import dji.thirdparty.okhttp3.ConnectionSpec;
import dji.thirdparty.okhttp3.Headers.Builder;
import dji.thirdparty.okhttp3.HttpUrl;
import dji.thirdparty.okhttp3.OkHttpClient;
import dji.thirdparty.okhttp3.OkHttpClient.Builder;
import dji.thirdparty.okhttp3.internal.http.StreamAllocation;
import dji.thirdparty.okhttp3.internal.io.RealConnection;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocket;

public abstract class Internal
{
  public static Internal instance;
  public static final Logger logger = Logger.getLogger(OkHttpClient.class.getName());
  
  public static void initializeInstanceForTests()
  {
    new OkHttpClient();
  }
  
  public abstract void addLenient(Headers.Builder paramBuilder, String paramString);
  
  public abstract void addLenient(Headers.Builder paramBuilder, String paramString1, String paramString2);
  
  public abstract void apply(ConnectionSpec paramConnectionSpec, SSLSocket paramSSLSocket, boolean paramBoolean);
  
  public abstract StreamAllocation callEngineGetStreamAllocation(Call paramCall);
  
  public abstract void callEnqueue(Call paramCall, Callback paramCallback, boolean paramBoolean);
  
  public abstract boolean connectionBecameIdle(ConnectionPool paramConnectionPool, RealConnection paramRealConnection);
  
  public abstract RealConnection get(ConnectionPool paramConnectionPool, Address paramAddress, StreamAllocation paramStreamAllocation);
  
  public abstract HttpUrl getHttpUrlChecked(String paramString)
    throws MalformedURLException, UnknownHostException;
  
  public abstract InternalCache internalCache(OkHttpClient paramOkHttpClient);
  
  public abstract void put(ConnectionPool paramConnectionPool, RealConnection paramRealConnection);
  
  public abstract RouteDatabase routeDatabase(ConnectionPool paramConnectionPool);
  
  public abstract void setCache(OkHttpClient.Builder paramBuilder, InternalCache paramInternalCache);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\okhttp3\internal\Internal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */