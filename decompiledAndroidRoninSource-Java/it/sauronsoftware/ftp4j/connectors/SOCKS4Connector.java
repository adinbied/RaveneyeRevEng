package it.sauronsoftware.ftp4j.connectors;

import it.sauronsoftware.ftp4j.FTPConnector;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class SOCKS4Connector
  extends FTPConnector
{
  private String socks4host;
  private int socks4port;
  private String socks4user;
  
  public SOCKS4Connector(String paramString, int paramInt)
  {
    this(paramString, paramInt, null);
  }
  
  public SOCKS4Connector(String paramString1, int paramInt, String paramString2)
  {
    this.socks4host = paramString1;
    this.socks4port = paramInt;
    this.socks4user = paramString2;
  }
  
  private int read(InputStream paramInputStream)
    throws IOException
  {
    return 0;
  }
  
  private Socket socksConnect(String paramString, int paramInt, boolean paramBoolean)
    throws IOException
  {
    return null;
  }
  
  public Socket connectForCommunicationChannel(String paramString, int paramInt)
    throws IOException
  {
    return socksConnect(paramString, paramInt, false);
  }
  
  public Socket connectForDataTransferChannel(String paramString, int paramInt)
    throws IOException
  {
    return socksConnect(paramString, paramInt, true);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\it\sauronsoftware\ftp4j\connectors\SOCKS4Connector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */