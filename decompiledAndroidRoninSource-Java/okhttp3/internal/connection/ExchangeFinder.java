package okhttp3.internal.connection;

import java.io.IOException;
import java.net.Socket;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.ObjectRef;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.EventListener;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.StreamResetException;

@Metadata(bv={1, 0, 3}, d1={"\000l\n\002\030\002\n\002\020\000\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\004\n\002\030\002\n\000\n\002\020\b\n\000\n\002\030\002\n\002\b\003\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\006\n\002\020\013\n\002\b\005\n\002\020\002\n\000\n\002\030\002\n\000\030\0002\0020\001B%\022\006\020\002\032\0020\003\022\006\020\004\032\0020\005\022\006\020\006\032\0020\007\022\006\020\b\032\0020\t¢\006\002\020\nJ\b\020\r\032\004\030\0010\016J\026\020\031\032\0020\0322\006\020\033\032\0020\0342\006\020\035\032\0020\036J0\020\037\032\0020\0162\006\020 \032\0020\0202\006\020!\032\0020\0202\006\020\"\032\0020\0202\006\020#\032\0020\0202\006\020$\032\0020%H\002J8\020&\032\0020\0162\006\020 \032\0020\0202\006\020!\032\0020\0202\006\020\"\032\0020\0202\006\020#\032\0020\0202\006\020$\032\0020%2\006\020'\032\0020%H\002J\006\020(\032\0020%J\b\020)\032\0020%H\002J\016\020*\032\0020+2\006\020,\032\0020-R\024\020\004\032\0020\005X\004¢\006\b\n\000\032\004\b\013\020\fR\016\020\006\032\0020\007X\004¢\006\002\n\000R\020\020\r\032\004\030\0010\016X\016¢\006\002\n\000R\016\020\002\032\0020\003X\004¢\006\002\n\000R\016\020\017\032\0020\020X\016¢\006\002\n\000R\016\020\b\032\0020\tX\004¢\006\002\n\000R\020\020\021\032\004\030\0010\022X\016¢\006\002\n\000R\016\020\023\032\0020\020X\016¢\006\002\n\000R\016\020\024\032\0020\020X\016¢\006\002\n\000R\020\020\025\032\004\030\0010\026X\016¢\006\002\n\000R\020\020\027\032\004\030\0010\030X\016¢\006\002\n\000¨\006."}, d2={"Lokhttp3/internal/connection/ExchangeFinder;", "", "connectionPool", "Lokhttp3/internal/connection/RealConnectionPool;", "address", "Lokhttp3/Address;", "call", "Lokhttp3/internal/connection/RealCall;", "eventListener", "Lokhttp3/EventListener;", "(Lokhttp3/internal/connection/RealConnectionPool;Lokhttp3/Address;Lokhttp3/internal/connection/RealCall;Lokhttp3/EventListener;)V", "getAddress$okhttp", "()Lokhttp3/Address;", "connectingConnection", "Lokhttp3/internal/connection/RealConnection;", "connectionShutdownCount", "", "nextRouteToTry", "Lokhttp3/Route;", "otherFailureCount", "refusedStreamCount", "routeSelection", "Lokhttp3/internal/connection/RouteSelector$Selection;", "routeSelector", "Lokhttp3/internal/connection/RouteSelector;", "find", "Lokhttp3/internal/http/ExchangeCodec;", "client", "Lokhttp3/OkHttpClient;", "chain", "Lokhttp3/internal/http/RealInterceptorChain;", "findConnection", "connectTimeout", "readTimeout", "writeTimeout", "pingIntervalMillis", "connectionRetryEnabled", "", "findHealthyConnection", "doExtensiveHealthChecks", "retryAfterFailure", "retryCurrentRoute", "trackFailure", "", "e", "Ljava/io/IOException;", "okhttp"}, k=1, mv={1, 1, 16})
public final class ExchangeFinder
{
  private final Address address;
  private final RealCall call;
  private RealConnection connectingConnection;
  private final RealConnectionPool connectionPool;
  private int connectionShutdownCount;
  private final EventListener eventListener;
  private Route nextRouteToTry;
  private int otherFailureCount;
  private int refusedStreamCount;
  private RouteSelector.Selection routeSelection;
  private RouteSelector routeSelector;
  
  public ExchangeFinder(RealConnectionPool paramRealConnectionPool, Address paramAddress, RealCall paramRealCall, EventListener paramEventListener)
  {
    this.connectionPool = paramRealConnectionPool;
    this.address = paramAddress;
    this.call = paramRealCall;
    this.eventListener = paramEventListener;
  }
  
  private final RealConnection findConnection(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
    throws IOException
  {
    Object localObject5 = (RealConnection)null;
    Object localObject6 = (Route)null;
    ??? = new Ref.ObjectRef();
    for (;;)
    {
      synchronized (this.connectionPool)
      {
        if (!this.call.isCanceled())
        {
          ((Ref.ObjectRef)???).element = this.call.getConnection();
          if (this.call.getConnection() != null)
          {
            Object localObject1 = this.call.getConnection();
            if (localObject1 == null) {
              Intrinsics.throwNpe();
            }
            if (!((RealConnection)localObject1).getNoNewExchanges())
            {
              localObject1 = this.call.getConnection();
              if (localObject1 == null) {
                Intrinsics.throwNpe();
              }
              if (((RealConnection)localObject1).supportsUrl(this.address.url())) {}
            }
            else
            {
              localObject7 = this.call.releaseConnectionNoEvents$okhttp();
              if (this.call.getConnection() != null)
              {
                localObject5 = this.call.getConnection();
                ((Ref.ObjectRef)???).element = ((RealConnection)null);
              }
              localObject1 = localObject6;
              if (localObject5 != null) {
                break label1050;
              }
              this.refusedStreamCount = 0;
              this.connectionShutdownCount = 0;
              this.otherFailureCount = 0;
              if (this.connectionPool.callAcquirePooledConnection(this.address, this.call, null, false))
              {
                localObject5 = this.call.getConnection();
                i = 1;
                localObject1 = localObject6;
              }
              else
              {
                localObject1 = localObject6;
                if (this.nextRouteToTry == null) {
                  break label1050;
                }
                localObject1 = this.nextRouteToTry;
                this.nextRouteToTry = ((Route)null);
                break label1050;
              }
              localObject6 = Unit.INSTANCE;
              if (localObject7 != null) {
                Util.closeQuietly((Socket)localObject7);
              }
              if ((RealConnection)((Ref.ObjectRef)???).element != null)
              {
                localObject6 = this.eventListener;
                localObject7 = (Call)this.call;
                ??? = (RealConnection)((Ref.ObjectRef)???).element;
                if (??? == null) {
                  Intrinsics.throwNpe();
                }
                ((EventListener)localObject6).connectionReleased((Call)localObject7, (Connection)???);
              }
              if (i != 0)
              {
                localObject6 = this.eventListener;
                localObject7 = (Call)this.call;
                if (localObject5 == null) {
                  Intrinsics.throwNpe();
                }
                ((EventListener)localObject6).connectionAcquired((Call)localObject7, (Connection)localObject5);
              }
              if (localObject5 != null)
              {
                if (localObject5 == null) {
                  Intrinsics.throwNpe();
                }
                return (RealConnection)localObject5;
              }
              if (localObject1 == null)
              {
                localObject6 = this.routeSelection;
                if (localObject6 != null)
                {
                  if (localObject6 == null) {
                    Intrinsics.throwNpe();
                  }
                  if (((RouteSelector.Selection)localObject6).hasNext()) {}
                }
                else
                {
                  localObject7 = this.routeSelector;
                  localObject6 = localObject7;
                  if (localObject7 == null)
                  {
                    localObject6 = new RouteSelector(this.address, this.call.getClient().getRouteDatabase(), (Call)this.call, this.eventListener);
                    this.routeSelector = ((RouteSelector)localObject6);
                  }
                  this.routeSelection = ((RouteSelector)localObject6).next();
                  j = 1;
                  continue;
                }
              }
              int j = 0;
              localObject7 = (List)null;
              synchronized (this.connectionPool)
              {
                if (!this.call.isCanceled())
                {
                  localObject6 = localObject5;
                  int k = i;
                  if (j != 0)
                  {
                    localObject6 = this.routeSelection;
                    if (localObject6 == null) {
                      Intrinsics.throwNpe();
                    }
                    ??? = ((RouteSelector.Selection)localObject6).getRoutes();
                    localObject6 = localObject5;
                    localObject7 = ???;
                    k = i;
                    if (this.connectionPool.callAcquirePooledConnection(this.address, this.call, (List)???, false))
                    {
                      localObject6 = this.call.getConnection();
                      k = 1;
                      localObject7 = ???;
                    }
                  }
                  localObject5 = localObject6;
                  localObject6 = localObject1;
                  if (k == 0)
                  {
                    localObject5 = localObject1;
                    if (localObject1 == null)
                    {
                      localObject1 = this.routeSelection;
                      if (localObject1 == null) {
                        Intrinsics.throwNpe();
                      }
                      localObject5 = ((RouteSelector.Selection)localObject1).next();
                    }
                    localObject1 = this.connectionPool;
                    if (localObject5 == null) {
                      Intrinsics.throwNpe();
                    }
                    localObject1 = new RealConnection((RealConnectionPool)localObject1, (Route)localObject5);
                    this.connectingConnection = ((RealConnection)localObject1);
                    localObject6 = localObject5;
                    localObject5 = localObject1;
                  }
                  localObject1 = Unit.INSTANCE;
                  if (k != 0)
                  {
                    localObject1 = this.eventListener;
                    localObject6 = (Call)this.call;
                    if (localObject5 == null) {
                      Intrinsics.throwNpe();
                    }
                    ((EventListener)localObject1).connectionAcquired((Call)localObject6, (Connection)localObject5);
                    if (localObject5 == null) {
                      Intrinsics.throwNpe();
                    }
                    return (RealConnection)localObject5;
                  }
                  if (localObject5 == null) {
                    Intrinsics.throwNpe();
                  }
                  ((RealConnection)localObject5).connect(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean, (Call)this.call, this.eventListener);
                  localObject1 = this.call.getClient().getRouteDatabase();
                  if (localObject5 == null) {
                    Intrinsics.throwNpe();
                  }
                  ((RouteDatabase)localObject1).connected(((RealConnection)localObject5).route());
                  localObject1 = (Socket)null;
                  synchronized (this.connectionPool)
                  {
                    this.connectingConnection = ((RealConnection)null);
                    if (this.connectionPool.callAcquirePooledConnection(this.address, this.call, (List)localObject7, true))
                    {
                      if (localObject5 == null) {
                        Intrinsics.throwNpe();
                      }
                      ((RealConnection)localObject5).setNoNewExchanges(true);
                      if (localObject5 == null) {
                        Intrinsics.throwNpe();
                      }
                      localObject1 = ((RealConnection)localObject5).socket();
                      localObject5 = this.call.getConnection();
                      this.nextRouteToTry = ((Route)localObject6);
                    }
                    else
                    {
                      localObject6 = this.connectionPool;
                      if (localObject5 == null) {
                        Intrinsics.throwNpe();
                      }
                      ((RealConnectionPool)localObject6).put((RealConnection)localObject5);
                      localObject6 = this.call;
                      if (localObject5 == null) {
                        Intrinsics.throwNpe();
                      }
                      ((RealCall)localObject6).acquireConnectionNoEvents((RealConnection)localObject5);
                    }
                    localObject6 = Unit.INSTANCE;
                    if (localObject1 != null) {
                      Util.closeQuietly((Socket)localObject1);
                    }
                    localObject1 = this.eventListener;
                    localObject6 = (Call)this.call;
                    if (localObject5 == null) {
                      Intrinsics.throwNpe();
                    }
                    ((EventListener)localObject1).connectionAcquired((Call)localObject6, (Connection)localObject5);
                    if (localObject5 == null) {
                      Intrinsics.throwNpe();
                    }
                    return (RealConnection)localObject5;
                  }
                }
                throw ((Throwable)new IOException("Canceled"));
              }
            }
          }
        }
        else
        {
          throw ((Throwable)new IOException("Canceled"));
        }
      }
      Object localObject7 = null;
      continue;
      label1050:
      int i = 0;
    }
  }
  
  private final RealConnection findHealthyConnection(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2)
    throws IOException
  {
    RealConnection localRealConnection;
    for (;;)
    {
      localRealConnection = findConnection(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean1);
      if (localRealConnection.isHealthy(paramBoolean2)) {
        break;
      }
      localRealConnection.noNewExchanges();
    }
    return localRealConnection;
  }
  
  private final boolean retryCurrentRoute()
  {
    int i = this.refusedStreamCount;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (i <= 1)
    {
      bool1 = bool2;
      if (this.connectionShutdownCount <= 1)
      {
        if (this.otherFailureCount > 0) {
          return false;
        }
        RealConnection localRealConnection = this.call.getConnection();
        bool1 = bool2;
        if (localRealConnection != null)
        {
          bool1 = bool2;
          if (localRealConnection.getRouteFailureCount$okhttp() == 0)
          {
            bool1 = bool2;
            if (Util.canReuseConnectionFor(localRealConnection.route().address().url(), this.address.url())) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public final RealConnection connectingConnection()
  {
    RealConnectionPool localRealConnectionPool = this.connectionPool;
    if ((Util.assertionsEnabled) && (!Thread.holdsLock(localRealConnectionPool)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Thread ");
      Thread localThread = Thread.currentThread();
      Intrinsics.checkExpressionValueIsNotNull(localThread, "Thread.currentThread()");
      localStringBuilder.append(localThread.getName());
      localStringBuilder.append(" MUST hold lock on ");
      localStringBuilder.append(localRealConnectionPool);
      throw ((Throwable)new AssertionError(localStringBuilder.toString()));
    }
    return this.connectingConnection;
  }
  
  public final ExchangeCodec find(OkHttpClient paramOkHttpClient, RealInterceptorChain paramRealInterceptorChain)
  {
    Intrinsics.checkParameterIsNotNull(paramOkHttpClient, "client");
    Intrinsics.checkParameterIsNotNull(paramRealInterceptorChain, "chain");
    try
    {
      paramOkHttpClient = findHealthyConnection(paramRealInterceptorChain.getConnectTimeoutMillis$okhttp(), paramRealInterceptorChain.getReadTimeoutMillis$okhttp(), paramRealInterceptorChain.getWriteTimeoutMillis$okhttp(), paramOkHttpClient.pingIntervalMillis(), paramOkHttpClient.retryOnConnectionFailure(), Intrinsics.areEqual(paramRealInterceptorChain.getRequest$okhttp().method(), "GET") ^ true).newCodec$okhttp(paramOkHttpClient, paramRealInterceptorChain);
      return paramOkHttpClient;
    }
    catch (IOException paramOkHttpClient)
    {
      trackFailure(paramOkHttpClient);
      throw ((Throwable)new RouteException(paramOkHttpClient));
    }
    catch (RouteException paramOkHttpClient)
    {
      trackFailure(paramOkHttpClient.getLastConnectException());
      throw ((Throwable)paramOkHttpClient);
    }
  }
  
  public final Address getAddress$okhttp()
  {
    return this.address;
  }
  
  public final boolean retryAfterFailure()
  {
    synchronized (this.connectionPool)
    {
      if ((this.refusedStreamCount == 0) && (this.connectionShutdownCount == 0))
      {
        int i = this.otherFailureCount;
        if (i == 0) {
          return false;
        }
      }
      Object localObject1 = this.nextRouteToTry;
      if (localObject1 != null) {
        return true;
      }
      if (retryCurrentRoute())
      {
        localObject1 = this.call.getConnection();
        if (localObject1 == null) {
          Intrinsics.throwNpe();
        }
        this.nextRouteToTry = ((RealConnection)localObject1).route();
        return true;
      }
      localObject1 = this.routeSelection;
      boolean bool;
      if (localObject1 != null)
      {
        bool = ((RouteSelector.Selection)localObject1).hasNext();
        if (bool == true) {
          return true;
        }
      }
      localObject1 = this.routeSelector;
      if (localObject1 != null)
      {
        bool = ((RouteSelector)localObject1).hasNext();
        return bool;
      }
      return true;
    }
  }
  
  public final void trackFailure(IOException paramIOException)
  {
    Intrinsics.checkParameterIsNotNull(paramIOException, "e");
    ??? = this.connectionPool;
    if ((Util.assertionsEnabled) && (Thread.holdsLock(???)))
    {
      paramIOException = new StringBuilder();
      paramIOException.append("Thread ");
      Thread localThread = Thread.currentThread();
      Intrinsics.checkExpressionValueIsNotNull(localThread, "Thread.currentThread()");
      paramIOException.append(localThread.getName());
      paramIOException.append(" MUST NOT hold lock on ");
      paramIOException.append(???);
      throw ((Throwable)new AssertionError(paramIOException.toString()));
    }
    synchronized (this.connectionPool)
    {
      this.nextRouteToTry = ((Route)null);
      if (((paramIOException instanceof StreamResetException)) && (((StreamResetException)paramIOException).errorCode == ErrorCode.REFUSED_STREAM)) {
        this.refusedStreamCount += 1;
      } else if ((paramIOException instanceof ConnectionShutdownException)) {
        this.connectionShutdownCount += 1;
      } else {
        this.otherFailureCount += 1;
      }
      return;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okhttp3\internal\connection\ExchangeFinder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */