package it.sauronsoftware.ftp4j;

import java.io.IOException;
import java.net.Socket;

public abstract class FTPConnector
{
  protected int closeTimeout = 10;
  private Socket connectingCommunicationChannelSocket;
  protected int connectionTimeout = 10;
  protected int readTimeout = 10;
  private boolean useSuggestedAddressForDataConnections;
  
  protected FTPConnector()
  {
    this(false);
  }
  
  protected FTPConnector(boolean paramBoolean)
  {
    String str = System.getProperty("ftp4j.passiveDataTransfer.useSuggestedAddress");
    if ((!"true".equalsIgnoreCase(str)) && (!"yes".equalsIgnoreCase(str)) && (!"1".equals(str)))
    {
      if ((!"false".equalsIgnoreCase(str)) && (!"no".equalsIgnoreCase(str)) && (!"0".equals(str)))
      {
        this.useSuggestedAddressForDataConnections = paramBoolean;
        return;
      }
      this.useSuggestedAddressForDataConnections = false;
      return;
    }
    this.useSuggestedAddressForDataConnections = true;
  }
  
  public void abortConnectForCommunicationChannel()
  {
    Socket localSocket = this.connectingCommunicationChannelSocket;
    if (localSocket != null) {}
    try
    {
      localSocket.close();
      return;
    }
    finally {}
  }
  
  public abstract Socket connectForCommunicationChannel(String paramString, int paramInt)
    throws IOException;
  
  public abstract Socket connectForDataTransferChannel(String paramString, int paramInt)
    throws IOException;
  
  boolean getUseSuggestedAddressForDataConnections()
  {
    return this.useSuggestedAddressForDataConnections;
  }
  
  public void setCloseTimeout(int paramInt)
  {
    this.closeTimeout = paramInt;
  }
  
  public void setConnectionTimeout(int paramInt)
  {
    this.connectionTimeout = paramInt;
  }
  
  public void setReadTimeout(int paramInt)
  {
    this.readTimeout = paramInt;
  }
  
  public void setUseSuggestedAddressForDataConnections(boolean paramBoolean)
  {
    this.useSuggestedAddressForDataConnections = paramBoolean;
  }
  
  protected Socket tcpConnectForCommunicationChannel(String paramString, int paramInt)
    throws IOException
  {
    return null;
  }
  
  protected Socket tcpConnectForDataTransferChannel(String paramString, int paramInt)
    throws IOException
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\it\sauronsoftware\ftp4j\FTPConnector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */