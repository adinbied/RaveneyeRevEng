package it.sauronsoftware.ftp4j.connectors;

import it.sauronsoftware.ftp4j.FTPConnector;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class SOCKS5Connector
  extends FTPConnector
{
  private String socks5host;
  private String socks5pass;
  private int socks5port;
  private String socks5user;
  
  public SOCKS5Connector(String paramString, int paramInt)
  {
    this(paramString, paramInt, null, null);
  }
  
  public SOCKS5Connector(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    this.socks5host = paramString1;
    this.socks5port = paramInt;
    this.socks5user = paramString2;
    this.socks5pass = paramString3;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\it\sauronsoftware\ftp4j\connectors\SOCKS5Connector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */