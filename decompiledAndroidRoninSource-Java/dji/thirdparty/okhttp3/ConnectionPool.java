package dji.thirdparty.okhttp3;

import dji.thirdparty.okhttp3.internal.RouteDatabase;
import dji.thirdparty.okhttp3.internal.Util;
import dji.thirdparty.okhttp3.internal.http.StreamAllocation;
import dji.thirdparty.okhttp3.internal.io.RealConnection;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class ConnectionPool
{
  private static final Executor executor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkHttp ConnectionPool", true));
  private final Runnable cleanupRunnable = new Runnable()
  {
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
  };
  boolean cleanupRunning;
  private final Deque<RealConnection> connections = new ArrayDeque();
  private final long keepAliveDurationNs;
  private final int maxIdleConnections;
  final RouteDatabase routeDatabase = new RouteDatabase();
  
  public ConnectionPool()
  {
    this(5, 5L, TimeUnit.MINUTES);
  }
  
  public ConnectionPool(int paramInt, long paramLong, TimeUnit paramTimeUnit)
  {
    this.maxIdleConnections = paramInt;
    this.keepAliveDurationNs = paramTimeUnit.toNanos(paramLong);
    if (paramLong > 0L) {
      return;
    }
    paramTimeUnit = new StringBuilder();
    paramTimeUnit.append("keepAliveDuration <= 0: ");
    paramTimeUnit.append(paramLong);
    throw new IllegalArgumentException(paramTimeUnit.toString());
  }
  
  private int pruneAndGetAllocationCount(RealConnection paramRealConnection, long paramLong)
  {
    return 0;
  }
  
  long cleanup(long paramLong)
  {
    return 277743701L;
  }
  
  boolean connectionBecameIdle(RealConnection paramRealConnection)
  {
    return false;
  }
  
  public int connectionCount()
  {
    return 0;
  }
  
  /* Error */
  public void evictAll()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  RealConnection get(Address paramAddress, StreamAllocation paramStreamAllocation)
  {
    return null;
  }
  
  public int idleConnectionCount()
  {
    return 0;
  }
  
  /* Error */
  void put(RealConnection arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\okhttp3\ConnectionPool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */