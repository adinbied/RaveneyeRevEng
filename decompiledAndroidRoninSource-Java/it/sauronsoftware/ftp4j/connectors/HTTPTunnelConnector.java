package it.sauronsoftware.ftp4j.connectors;

import it.sauronsoftware.ftp4j.FTPConnector;
import java.io.IOException;
import java.net.Socket;

public class HTTPTunnelConnector
  extends FTPConnector
{
  private String proxyHost;
  private String proxyPass;
  private int proxyPort;
  private String proxyUser;
  
  public HTTPTunnelConnector(String paramString, int paramInt)
  {
    this(paramString, paramInt, null, null);
  }
  
  public HTTPTunnelConnector(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    this.proxyHost = paramString1;
    this.proxyPort = paramInt;
    this.proxyUser = paramString2;
    this.proxyPass = paramString3;
  }
  
  private Socket httpConnect(String paramString, int paramInt, boolean paramBoolean)
    throws IOException
  {
    return null;
  }
  
  public Socket connectForCommunicationChannel(String paramString, int paramInt)
    throws IOException
  {
    return httpConnect(paramString, paramInt, false);
  }
  
  public Socket connectForDataTransferChannel(String paramString, int paramInt)
    throws IOException
  {
    return httpConnect(paramString, paramInt, true);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\it\sauronsoftware\ftp4j\connectors\HTTPTunnelConnector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */