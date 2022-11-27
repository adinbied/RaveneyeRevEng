package it.sauronsoftware.ftp4j;

import it.sauronsoftware.ftp4j.connectors.DirectConnector;
import it.sauronsoftware.ftp4j.extrecognizers.DefaultTextualExtensionRecognizer;
import it.sauronsoftware.ftp4j.listparsers.DOSListParser;
import it.sauronsoftware.ftp4j.listparsers.EPLFListParser;
import it.sauronsoftware.ftp4j.listparsers.MLSDListParser;
import it.sauronsoftware.ftp4j.listparsers.NetWareListParser;
import it.sauronsoftware.ftp4j.listparsers.UnixListParser;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Pattern;
import javax.net.ssl.SSLSocketFactory;

public class FTPClient
{
  private static final DateFormat MDTM_DATE_FORMAT = new SimpleDateFormat("yyyyMMddHHmmss");
  public static final int MLSD_ALWAYS = 1;
  public static final int MLSD_IF_SUPPORTED = 0;
  public static final int MLSD_NEVER = 2;
  private static final Pattern PASV_PATTERN = Pattern.compile("\\d{1,3},\\d{1,3},\\d{1,3},\\d{1,3},\\d{1,3},\\d{1,3}");
  private static final Pattern PWD_PATTERN = Pattern.compile("\"/.*\"");
  public static final int SECURITY_FTP = 0;
  public static final int SECURITY_FTPES = 2;
  public static final int SECURITY_FTPS = 1;
  private static final int SEND_AND_RECEIVE_BUFFER_SIZE = 65536;
  public static final int TYPE_AUTO = 0;
  public static final int TYPE_BINARY = 2;
  public static final int TYPE_TEXTUAL = 1;
  private Object abortLock = new Object();
  private boolean aborted = false;
  private boolean authenticated = false;
  private long autoNoopTimeout = 0L;
  private AutoNoopTimer autoNoopTimer;
  private String charset = null;
  private FTPCommunicationChannel communication = null;
  private ArrayList communicationListeners = new ArrayList();
  private boolean compressionEnabled = false;
  private boolean connected = false;
  private FTPConnector connector = new DirectConnector();
  private boolean consumeAborCommandReply = false;
  private boolean dataChannelEncrypted = false;
  private InputStream dataTransferInputStream = null;
  private OutputStream dataTransferOutputStream = null;
  private String host = null;
  private ArrayList listParsers = new ArrayList();
  private Object lock = new Object();
  private int mlsdPolicy = 0;
  private boolean mlsdSupported = false;
  private boolean modezEnabled = false;
  private boolean modezSupported = false;
  private long nextAutoNoopTime;
  private boolean ongoingDataTransfer = false;
  private FTPListParser parser = null;
  private boolean passive = true;
  private String password;
  private int port = 0;
  private boolean restSupported = false;
  private int security = 0;
  private SSLSocketFactory sslSocketFactory = (SSLSocketFactory)SSLSocketFactory.getDefault();
  private FTPTextualExtensionRecognizer textualExtensionRecognizer = DefaultTextualExtensionRecognizer.getInstance();
  private int type = 0;
  private String username;
  private boolean utf8Supported = false;
  
  public FTPClient()
  {
    addListParser(new UnixListParser());
    addListParser(new DOSListParser());
    addListParser(new EPLFListParser());
    addListParser(new NetWareListParser());
    addListParser(new MLSDListParser());
  }
  
  private int detectType(String paramString)
    throws IOException, FTPIllegalReplyException, FTPException
  {
    return 0;
  }
  
  private FTPDataTransferConnectionProvider openActiveDataTransferChannel()
    throws IOException, FTPIllegalReplyException, FTPException, FTPDataTransferException
  {
    return null;
  }
  
  private FTPDataTransferConnectionProvider openDataTransferChannel()
    throws IOException, FTPIllegalReplyException, FTPException, FTPDataTransferException
  {
    return null;
  }
  
  private FTPDataTransferConnectionProvider openPassiveDataTransferChannel()
    throws IOException, FTPIllegalReplyException, FTPException, FTPDataTransferException
  {
    return null;
  }
  
  private int[] pickAutoDetectedLocalAddress()
    throws IOException
  {
    return null;
  }
  
  private String pickCharset()
  {
    return null;
  }
  
  private int[] pickForcedLocalAddress()
  {
    return null;
  }
  
  private int[] pickLocalAddress()
    throws IOException
  {
    return null;
  }
  
  /* Error */
  private void postLoginOperations()
    throws IllegalStateException, IOException, FTPIllegalReplyException, FTPException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  private Socket ssl(Socket paramSocket, String paramString, int paramInt)
    throws IOException
  {
    return this.sslSocketFactory.createSocket(paramSocket, paramString, paramInt, true);
  }
  
  /* Error */
  private void startAutoNoopTimer()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void stopAutoNoopTimer()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void touchAutoNoopTimer()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void abortCurrentConnectionAttempt()
  {
    this.connector.abortConnectForCommunicationChannel();
  }
  
  /* Error */
  public void abortCurrentDataTransfer(boolean arg1)
    throws IOException, FTPIllegalReplyException
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: return
  }
  
  /* Error */
  public void abruptlyCloseCommunication()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void addCommunicationListener(FTPCommunicationListener arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void addListParser(FTPListParser arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public void append(File paramFile)
    throws IllegalStateException, FileNotFoundException, IOException, FTPIllegalReplyException, FTPException, FTPDataTransferException, FTPAbortedException
  {
    append(paramFile, null);
  }
  
  /* Error */
  public void append(File arg1, FTPDataTransferListener arg2)
    throws IllegalStateException, FileNotFoundException, IOException, FTPIllegalReplyException, FTPException, FTPDataTransferException, FTPAbortedException
  {
    // Byte code:
    //   0: goto +15 -> 15
    //   3: goto +12 -> 15
    //   6: goto +9 -> 15
    //   9: goto +6 -> 15
    //   12: return
    //   13: astore_1
    //   14: return
    //   15: goto -3 -> 12
  }
  
  /* Error */
  public void append(String arg1, InputStream arg2, long arg3, FTPDataTransferListener arg5)
    throws IllegalStateException, IOException, FTPIllegalReplyException, FTPException, FTPDataTransferException, FTPAbortedException
  {
    // Byte code:
    //   0: goto +6 -> 6
    //   3: return
    //   4: astore_1
    //   5: return
    //   6: goto -3 -> 3
  }
  
  /* Error */
  public void changeAccount(String arg1)
    throws IllegalStateException, IOException, FTPIllegalReplyException, FTPException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void changeDirectory(String arg1)
    throws IllegalStateException, IOException, FTPIllegalReplyException, FTPException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void changeDirectoryUp()
    throws IllegalStateException, IOException, FTPIllegalReplyException, FTPException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public String[] connect(String paramString)
    throws IllegalStateException, IOException, FTPIllegalReplyException, FTPException
  {
    return null;
  }
  
  public String[] connect(String paramString, int paramInt)
    throws IllegalStateException, IOException, FTPIllegalReplyException, FTPException
  {
    return null;
  }
  
  /* Error */
  public void createDirectory(String arg1)
    throws IllegalStateException, IOException, FTPIllegalReplyException, FTPException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public String currentDirectory()
    throws IllegalStateException, IOException, FTPIllegalReplyException, FTPException
  {
    return null;
  }
  
  /* Error */
  public void deleteDirectory(String arg1)
    throws IllegalStateException, IOException, FTPIllegalReplyException, FTPException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void deleteFile(String arg1)
    throws IllegalStateException, IOException, FTPIllegalReplyException, FTPException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void disconnect(boolean arg1)
    throws IllegalStateException, IOException, FTPIllegalReplyException, FTPException
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: return
  }
  
  /* Error */
  public void download(String arg1, File arg2)
    throws IllegalStateException, FileNotFoundException, IOException, FTPIllegalReplyException, FTPException, FTPDataTransferException, FTPAbortedException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void download(String arg1, File arg2, long arg3)
    throws IllegalStateException, FileNotFoundException, IOException, FTPIllegalReplyException, FTPException, FTPDataTransferException, FTPAbortedException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void download(String arg1, File arg2, long arg3, FTPDataTransferListener arg5)
    throws IllegalStateException, FileNotFoundException, IOException, FTPIllegalReplyException, FTPException, FTPDataTransferException, FTPAbortedException
  {
    // Byte code:
    //   0: goto +15 -> 15
    //   3: goto +12 -> 15
    //   6: goto +9 -> 15
    //   9: goto +6 -> 15
    //   12: return
    //   13: astore_1
    //   14: return
    //   15: goto -3 -> 12
  }
  
  /* Error */
  public void download(String arg1, File arg2, FTPDataTransferListener arg3)
    throws IllegalStateException, FileNotFoundException, IOException, FTPIllegalReplyException, FTPException, FTPDataTransferException, FTPAbortedException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void download(String arg1, OutputStream arg2, long arg3, FTPDataTransferListener arg5)
    throws IllegalStateException, IOException, FTPIllegalReplyException, FTPException, FTPDataTransferException, FTPAbortedException
  {
    // Byte code:
    //   0: goto +9 -> 9
    //   3: goto +9 -> 12
    //   6: return
    //   7: astore_1
    //   8: return
    //   9: goto -6 -> 3
    //   12: goto -6 -> 6
  }
  
  public long fileSize(String paramString)
    throws IllegalStateException, IOException, FTPIllegalReplyException, FTPException
  {
    for (;;)
    {
      return 277792621L;
    }
  }
  
  public long getAutoNoopTimeout()
  {
    return 277792657L;
  }
  
  public String getCharset()
  {
    return null;
  }
  
  public FTPCommunicationListener[] getCommunicationListeners()
  {
    return null;
  }
  
  public FTPConnector getConnector()
  {
    return null;
  }
  
  public String getHost()
  {
    return null;
  }
  
  public FTPListParser[] getListParsers()
  {
    return null;
  }
  
  public int getMLSDPolicy()
  {
    return 0;
  }
  
  public String getPassword()
  {
    return null;
  }
  
  public int getPort()
  {
    return 0;
  }
  
  public SSLSocketFactory getSSLSocketFactory()
  {
    return null;
  }
  
  public int getSecurity()
  {
    return this.security;
  }
  
  public FTPTextualExtensionRecognizer getTextualExtensionRecognizer()
  {
    return null;
  }
  
  public int getType()
  {
    return 0;
  }
  
  public String getUsername()
  {
    return null;
  }
  
  public String[] help()
    throws IllegalStateException, IOException, FTPIllegalReplyException, FTPException
  {
    return null;
  }
  
  public boolean isAuthenticated()
  {
    return false;
  }
  
  public boolean isCompressionEnabled()
  {
    return this.compressionEnabled;
  }
  
  public boolean isCompressionSupported()
  {
    return this.modezSupported;
  }
  
  public boolean isConnected()
  {
    return false;
  }
  
  public boolean isPassive()
  {
    return false;
  }
  
  public boolean isResumeSupported()
  {
    return false;
  }
  
  public FTPFile[] list()
    throws IllegalStateException, IOException, FTPIllegalReplyException, FTPException, FTPDataTransferException, FTPAbortedException, FTPListParseException
  {
    return list(null);
  }
  
  public FTPFile[] list(String paramString)
    throws IllegalStateException, IOException, FTPIllegalReplyException, FTPException, FTPDataTransferException, FTPAbortedException, FTPListParseException
  {
    for (;;)
    {
      return null;
    }
  }
  
  public String[] listNames()
    throws IllegalStateException, IOException, FTPIllegalReplyException, FTPException, FTPDataTransferException, FTPAbortedException, FTPListParseException
  {
    for (;;)
    {
      return null;
    }
  }
  
  public void login(String paramString1, String paramString2)
    throws IllegalStateException, IOException, FTPIllegalReplyException, FTPException
  {
    login(paramString1, paramString2, null);
  }
  
  /* Error */
  public void login(String arg1, String arg2, String arg3)
    throws IllegalStateException, IOException, FTPIllegalReplyException, FTPException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void logout()
    throws IllegalStateException, IOException, FTPIllegalReplyException, FTPException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public Date modifiedDate(String paramString)
    throws IllegalStateException, IOException, FTPIllegalReplyException, FTPException
  {
    for (;;)
    {
      return null;
    }
  }
  
  /* Error */
  public void noop()
    throws IllegalStateException, IOException, FTPIllegalReplyException, FTPException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void removeCommunicationListener(FTPCommunicationListener arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void removeListParser(FTPListParser arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void rename(String arg1, String arg2)
    throws IllegalStateException, IOException, FTPIllegalReplyException, FTPException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public FTPReply sendCustomCommand(String paramString)
    throws IllegalStateException, IOException, FTPIllegalReplyException
  {
    return null;
  }
  
  public FTPReply sendSiteCommand(String paramString)
    throws IllegalStateException, IOException, FTPIllegalReplyException
  {
    return null;
  }
  
  public String[] serverStatus()
    throws IllegalStateException, IOException, FTPIllegalReplyException, FTPException
  {
    return null;
  }
  
  /* Error */
  public void setAutoNoopTimeout(long arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: return
  }
  
  /* Error */
  public void setCharset(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public void setCompressionEnabled(boolean paramBoolean)
  {
    this.compressionEnabled = paramBoolean;
  }
  
  /* Error */
  public void setConnector(FTPConnector arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void setMLSDPolicy(int arg1)
    throws java.lang.IllegalArgumentException
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: return
  }
  
  /* Error */
  public void setPassive(boolean arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: return
  }
  
  /* Error */
  public void setSSLSocketFactory(SSLSocketFactory arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void setSecurity(int arg1)
    throws IllegalStateException, java.lang.IllegalArgumentException
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: return
  }
  
  /* Error */
  public void setTextualExtensionRecognizer(FTPTextualExtensionRecognizer arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void setType(int arg1)
    throws java.lang.IllegalArgumentException
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: return
  }
  
  public String toString()
  {
    return null;
  }
  
  public void upload(File paramFile)
    throws IllegalStateException, FileNotFoundException, IOException, FTPIllegalReplyException, FTPException, FTPDataTransferException, FTPAbortedException
  {
    upload(paramFile, 0L, null);
  }
  
  public void upload(File paramFile, long paramLong)
    throws IllegalStateException, FileNotFoundException, IOException, FTPIllegalReplyException, FTPException, FTPDataTransferException, FTPAbortedException
  {
    upload(paramFile, paramLong, null);
  }
  
  /* Error */
  public void upload(File arg1, long arg2, FTPDataTransferListener arg4)
    throws IllegalStateException, FileNotFoundException, IOException, FTPIllegalReplyException, FTPException, FTPDataTransferException, FTPAbortedException
  {
    // Byte code:
    //   0: goto +15 -> 15
    //   3: goto +12 -> 15
    //   6: goto +9 -> 15
    //   9: goto +6 -> 15
    //   12: return
    //   13: astore_1
    //   14: return
    //   15: goto -3 -> 12
  }
  
  public void upload(File paramFile, FTPDataTransferListener paramFTPDataTransferListener)
    throws IllegalStateException, FileNotFoundException, IOException, FTPIllegalReplyException, FTPException, FTPDataTransferException, FTPAbortedException
  {
    upload(paramFile, 0L, paramFTPDataTransferListener);
  }
  
  /* Error */
  public void upload(String arg1, InputStream arg2, long arg3, long arg5, FTPDataTransferListener arg7)
    throws IllegalStateException, IOException, FTPIllegalReplyException, FTPException, FTPDataTransferException, FTPAbortedException
  {
    // Byte code:
    //   0: goto +9 -> 9
    //   3: goto +9 -> 12
    //   6: return
    //   7: astore_1
    //   8: return
    //   9: goto -6 -> 3
    //   12: goto -6 -> 6
  }
  
  private class AutoNoopTimer
    extends Thread
  {
    private AutoNoopTimer() {}
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\it\sauronsoftware\ftp4j\FTPClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */