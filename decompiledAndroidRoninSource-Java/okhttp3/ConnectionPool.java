package okhttp3;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.RealConnectionPool;

@Metadata(bv={1, 0, 3}, d1={"\000.\n\002\030\002\n\002\020\000\n\000\n\002\020\b\n\000\n\002\020\t\n\000\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\005\n\002\020\002\n\002\b\002\030\0002\0020\001B\037\b\026\022\006\020\002\032\0020\003\022\006\020\004\032\0020\005\022\006\020\006\032\0020\007¢\006\002\020\bB\007\b\026¢\006\002\020\tB\017\b\000\022\006\020\n\032\0020\013¢\006\002\020\fJ\006\020\017\032\0020\003J\006\020\020\032\0020\021J\006\020\022\032\0020\003R\024\020\n\032\0020\013X\004¢\006\b\n\000\032\004\b\r\020\016¨\006\023"}, d2={"Lokhttp3/ConnectionPool;", "", "maxIdleConnections", "", "keepAliveDuration", "", "timeUnit", "Ljava/util/concurrent/TimeUnit;", "(IJLjava/util/concurrent/TimeUnit;)V", "()V", "delegate", "Lokhttp3/internal/connection/RealConnectionPool;", "(Lokhttp3/internal/connection/RealConnectionPool;)V", "getDelegate$okhttp", "()Lokhttp3/internal/connection/RealConnectionPool;", "connectionCount", "evictAll", "", "idleConnectionCount", "okhttp"}, k=1, mv={1, 1, 16})
public final class ConnectionPool
{
  private final RealConnectionPool delegate;
  
  public ConnectionPool()
  {
    this(5, 5L, TimeUnit.MINUTES);
  }
  
  public ConnectionPool(int paramInt, long paramLong, TimeUnit paramTimeUnit)
  {
    this(new RealConnectionPool(TaskRunner.INSTANCE, paramInt, paramLong, paramTimeUnit));
  }
  
  public ConnectionPool(RealConnectionPool paramRealConnectionPool)
  {
    this.delegate = paramRealConnectionPool;
  }
  
  public final int connectionCount()
  {
    return this.delegate.connectionCount();
  }
  
  public final void evictAll()
  {
    this.delegate.evictAll();
  }
  
  public final RealConnectionPool getDelegate$okhttp()
  {
    return this.delegate;
  }
  
  public final int idleConnectionCount()
  {
    return this.delegate.idleConnectionCount();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okhttp3\ConnectionPool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */