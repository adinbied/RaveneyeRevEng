package it.sauronsoftware.ftp4j;

import java.io.IOException;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.StringTokenizer;

class FTPDataTransferServer
  implements FTPDataTransferConnectionProvider, Runnable
{
  private IOException exception;
  private ServerSocket serverSocket = null;
  private Socket socket;
  private Thread thread;
  
  public FTPDataTransferServer()
    throws FTPDataTransferException
  {
    Object localObject1 = System.getProperty("ftp4j.activeDataTransfer.portRange");
    int i3 = 0;
    Object localObject3;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject3 = new StringTokenizer((String)localObject1, "-");
      if (((StringTokenizer)localObject3).countTokens() == 2)
      {
        localObject2 = ((StringTokenizer)localObject3).nextToken();
        localObject3 = ((StringTokenizer)localObject3).nextToken();
      }
    }
    try
    {
      j = Integer.parseInt((String)localObject2);
    }
    catch (NumberFormatException localNumberFormatException1)
    {
      int j;
      for (;;) {}
    }
    j = 0;
    try
    {
      i = Integer.parseInt((String)localObject3);
    }
    catch (NumberFormatException localNumberFormatException2)
    {
      int i;
      int n;
      int k;
      int i1;
      int m;
      int i2;
      for (;;) {}
    }
    i = 0;
    if ((j > 0) && (i > 0) && (i >= j))
    {
      n = 1;
      k = 1;
    }
    else
    {
      i = 0;
      j = 0;
      n = 0;
      k = 0;
    }
    i1 = i;
    m = j;
    i2 = k;
    if (n == 0)
    {
      localObject2 = System.err;
      localObject3 = new StringBuffer();
      ((StringBuffer)localObject3).append("WARNING: invalid value \"");
      ((StringBuffer)localObject3).append((String)localObject1);
      ((StringBuffer)localObject3).append("\" for the ");
      ((StringBuffer)localObject3).append("ftp4j.activeDataTransfer.portRange");
      ((StringBuffer)localObject3).append(" system property. The value should ");
      ((StringBuffer)localObject3).append("be in the start-stop form, with ");
      ((StringBuffer)localObject3).append("start > 0, stop > 0 and start <= stop.");
      ((PrintStream)localObject2).println(((StringBuffer)localObject3).toString());
      i1 = i;
      m = j;
      i2 = k;
      break label227;
      i1 = 0;
      m = 0;
      i2 = 0;
    }
    label227:
    if (i2 != 0)
    {
      localObject2 = new ArrayList();
      for (;;)
      {
        i = i3;
        if (m > i1) {
          break;
        }
        ((ArrayList)localObject2).add(new Integer(m));
        m += 1;
      }
      while (i == 0)
      {
        j = ((ArrayList)localObject2).size();
        if (j <= 0) {
          break;
        }
        j = ((Integer)((ArrayList)localObject2).remove((int)Math.floor(Math.random() * j))).intValue();
        try
        {
          localObject3 = new ServerSocket();
          this.serverSocket = ((ServerSocket)localObject3);
          ((ServerSocket)localObject3).setReceiveBufferSize(524288);
          this.serverSocket.bind(new InetSocketAddress(j));
          i = 1;
        }
        catch (IOException localIOException2)
        {
          for (;;) {}
        }
      }
      if (i != 0) {
        break label438;
      }
      localObject2 = new StringBuffer();
      ((StringBuffer)localObject2).append("Cannot open the ServerSocket. No available port found in range ");
      ((StringBuffer)localObject2).append((String)localObject1);
      throw new FTPDataTransferException(((StringBuffer)localObject2).toString());
    }
    try
    {
      localObject1 = new ServerSocket();
      this.serverSocket = ((ServerSocket)localObject1);
      ((ServerSocket)localObject1).setReceiveBufferSize(524288);
      this.serverSocket.bind(new InetSocketAddress(0));
      label438:
      localObject1 = new Thread(this);
      this.thread = ((Thread)localObject1);
      ((Thread)localObject1).start();
      return;
    }
    catch (IOException localIOException1)
    {
      throw new FTPDataTransferException("Cannot open the ServerSocket", localIOException1);
    }
  }
  
  public void dispose()
  {
    ServerSocket localServerSocket = this.serverSocket;
    if (localServerSocket != null) {}
    try
    {
      localServerSocket.close();
      return;
    }
    catch (IOException localIOException) {}
  }
  
  public int getPort()
  {
    return this.serverSocket.getLocalPort();
  }
  
  public Socket openDataTransferConnection()
    throws FTPDataTransferException
  {
    return null;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\it\sauronsoftware\ftp4j\FTPDataTransferServer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */