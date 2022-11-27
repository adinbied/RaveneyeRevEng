package it.sauronsoftware.ftp4j;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.ArrayList;

public class FTPCommunicationChannel
{
  private String charsetName = null;
  private ArrayList communicationListeners = new ArrayList();
  private Socket connection = null;
  private NVTASCIIReader reader = null;
  private NVTASCIIWriter writer = null;
  
  public FTPCommunicationChannel(Socket paramSocket, String paramString)
    throws IOException
  {
    this.connection = paramSocket;
    this.charsetName = paramString;
    InputStream localInputStream = paramSocket.getInputStream();
    paramSocket = paramSocket.getOutputStream();
    this.reader = new NVTASCIIReader(localInputStream, paramString);
    this.writer = new NVTASCIIWriter(paramSocket, paramString);
  }
  
  private String read()
    throws IOException
  {
    return null;
  }
  
  public void addCommunicationListener(FTPCommunicationListener paramFTPCommunicationListener)
  {
    this.communicationListeners.add(paramFTPCommunicationListener);
  }
  
  /* Error */
  public void changeCharset(String arg1)
    throws IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void close()
  {
    try
    {
      this.connection.close();
      return;
    }
    catch (Exception localException) {}
  }
  
  public FTPCommunicationListener[] getCommunicationListeners()
  {
    return null;
  }
  
  public FTPReply readFTPReply()
    throws IOException, FTPIllegalReplyException
  {
    return null;
  }
  
  public void removeCommunicationListener(FTPCommunicationListener paramFTPCommunicationListener)
  {
    this.communicationListeners.remove(paramFTPCommunicationListener);
  }
  
  /* Error */
  public void sendFTPCommand(String arg1)
    throws IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void ssl(javax.net.ssl.SSLSocketFactory arg1)
    throws IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\it\sauronsoftware\ftp4j\FTPCommunicationChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */