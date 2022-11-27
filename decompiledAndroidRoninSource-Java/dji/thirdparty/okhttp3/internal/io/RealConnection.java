package dji.thirdparty.okhttp3.internal.io;

import dji.thirdparty.okhttp3.Connection;
import dji.thirdparty.okhttp3.Handshake;
import dji.thirdparty.okhttp3.Protocol;
import dji.thirdparty.okhttp3.Request;
import dji.thirdparty.okhttp3.Route;
import dji.thirdparty.okhttp3.internal.Util;
import dji.thirdparty.okhttp3.internal.framed.ErrorCode;
import dji.thirdparty.okhttp3.internal.framed.FramedConnection;
import dji.thirdparty.okhttp3.internal.framed.FramedConnection.Listener;
import dji.thirdparty.okhttp3.internal.framed.FramedStream;
import dji.thirdparty.okhttp3.internal.http.StreamAllocation;
import dji.thirdparty.okio.BufferedSink;
import dji.thirdparty.okio.BufferedSource;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public final class RealConnection
  extends FramedConnection.Listener
  implements Connection
{
  public int allocationLimit;
  public final List<Reference<StreamAllocation>> allocations = new ArrayList();
  public volatile FramedConnection framedConnection;
  private Handshake handshake;
  public long idleAtNanos = Long.MAX_VALUE;
  public boolean noNewStreams;
  private Protocol protocol;
  private Socket rawSocket;
  private final Route route;
  public BufferedSink sink;
  public Socket socket;
  public BufferedSource source;
  public int successCount;
  
  public RealConnection(Route paramRoute)
  {
    this.route = paramRoute;
  }
  
  /* Error */
  private void connectSocket(int arg1, int arg2, int arg3, dji.thirdparty.okhttp3.internal.ConnectionSpecSelector arg4)
    throws IOException
  {
    // Byte code:
    //   0: return
    //   1: astore 4
    //   3: return
  }
  
  /* Error */
  private void connectTls(int arg1, int arg2, dji.thirdparty.okhttp3.internal.ConnectionSpecSelector arg3)
    throws IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: return
  }
  
  /* Error */
  private void createTunnel(int arg1, int arg2)
    throws IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  private Request createTunnelRequest()
    throws IOException
  {
    return null;
  }
  
  public void cancel()
  {
    Util.closeQuietly(this.rawSocket);
  }
  
  /* Error */
  public void connect(int arg1, int arg2, int arg3, List<dji.thirdparty.okhttp3.ConnectionSpec> arg4, boolean arg5)
    throws dji.thirdparty.okhttp3.internal.http.RouteException
  {
    // Byte code:
    //   0: return
    //   1: astore 4
    //   3: return
  }
  
  public Handshake handshake()
  {
    return this.handshake;
  }
  
  boolean isConnected()
  {
    return this.protocol != null;
  }
  
  public boolean isHealthy(boolean paramBoolean)
  {
    return false;
  }
  
  public boolean isMultiplexed()
  {
    return this.framedConnection != null;
  }
  
  public void onSettings(FramedConnection paramFramedConnection)
  {
    this.allocationLimit = paramFramedConnection.maxConcurrentStreams();
  }
  
  public void onStream(FramedStream paramFramedStream)
    throws IOException
  {
    paramFramedStream.close(ErrorCode.REFUSED_STREAM);
  }
  
  public Protocol protocol()
  {
    return null;
  }
  
  public Route route()
  {
    return this.route;
  }
  
  public Socket socket()
  {
    return this.socket;
  }
  
  public String toString()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\okhttp3\internal\io\RealConnection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */