package it.sauronsoftware.ftp4j.connectors;

import it.sauronsoftware.ftp4j.FTPConnector;
import java.io.IOException;
import java.net.Socket;

public class DirectConnector
  extends FTPConnector
{
  public Socket connectForCommunicationChannel(String paramString, int paramInt)
    throws IOException
  {
    return tcpConnectForCommunicationChannel(paramString, paramInt);
  }
  
  public Socket connectForDataTransferChannel(String paramString, int paramInt)
    throws IOException
  {
    return tcpConnectForDataTransferChannel(paramString, paramInt);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\it\sauronsoftware\ftp4j\connectors\DirectConnector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */