package it.sauronsoftware.ftp4j.connectors;

import it.sauronsoftware.ftp4j.FTPConnector;
import java.io.IOException;
import java.net.Socket;

public class FTPProxyConnector
  extends FTPConnector
{
  public static int STYLE_OPEN_COMMAND = 1;
  public static int STYLE_SITE_COMMAND;
  private String proxyHost;
  private String proxyPass;
  private int proxyPort;
  private String proxyUser;
  public int style = STYLE_SITE_COMMAND;
  
  public FTPProxyConnector(String paramString, int paramInt)
  {
    this(paramString, paramInt, "anonymous", "ftp4j");
  }
  
  public FTPProxyConnector(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    super(true);
    this.proxyHost = paramString1;
    this.proxyPort = paramInt;
    this.proxyUser = paramString2;
    this.proxyPass = paramString3;
  }
  
  public Socket connectForCommunicationChannel(String paramString, int paramInt)
    throws IOException
  {
    return null;
  }
  
  public Socket connectForDataTransferChannel(String paramString, int paramInt)
    throws IOException
  {
    return tcpConnectForDataTransferChannel(paramString, paramInt);
  }
  
  /* Error */
  public void setStyle(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\it\sauronsoftware\ftp4j\connectors\FTPProxyConnector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */