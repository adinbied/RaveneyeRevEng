package dji.thirdparty.okhttp3.internal.http;

import dji.thirdparty.okhttp3.Address;
import dji.thirdparty.okhttp3.ConnectionPool;
import dji.thirdparty.okhttp3.Route;
import dji.thirdparty.okhttp3.internal.RouteDatabase;
import dji.thirdparty.okhttp3.internal.io.RealConnection;
import dji.thirdparty.okio.Sink;
import java.io.IOException;

public final class StreamAllocation
{
  public final Address address;
  private boolean canceled;
  private RealConnection connection;
  private final ConnectionPool connectionPool;
  private boolean released;
  private Route route;
  private RouteSelector routeSelector;
  private HttpStream stream;
  
  public StreamAllocation(ConnectionPool paramConnectionPool, Address paramAddress)
  {
    this.connectionPool = paramConnectionPool;
    this.address = paramAddress;
    this.routeSelector = new RouteSelector(paramAddress, routeDatabase());
  }
  
  /* Error */
  private void deallocate(boolean arg1, boolean arg2, boolean arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore 4
    //   3: return
  }
  
  private RealConnection findConnection(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
    throws IOException, RouteException
  {
    return null;
  }
  
  private RealConnection findHealthyConnection(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2)
    throws IOException, RouteException
  {
    return null;
  }
  
  private boolean isRecoverable(IOException paramIOException)
  {
    return false;
  }
  
  /* Error */
  private void release(RealConnection arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private RouteDatabase routeDatabase()
  {
    return null;
  }
  
  /* Error */
  public void acquire(RealConnection arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void cancel()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public RealConnection connection()
  {
    try
    {
      RealConnection localRealConnection = this.connection;
      return localRealConnection;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public void connectionFailed(IOException arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public HttpStream newStream(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2)
    throws RouteException, IOException
  {
    return null;
  }
  
  public void noNewStreams()
  {
    deallocate(true, false, false);
  }
  
  public boolean recover(IOException paramIOException, Sink paramSink)
  {
    return false;
  }
  
  public void release()
  {
    deallocate(false, true, false);
  }
  
  public HttpStream stream()
  {
    return null;
  }
  
  /* Error */
  public void streamFinished(boolean arg1, HttpStream arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: return
  }
  
  public String toString()
  {
    return this.address.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\okhttp3\internal\http\StreamAllocation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */