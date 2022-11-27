package dji.thirdparty.okhttp3.internal;

import dji.thirdparty.okhttp3.ConnectionSpec;
import java.io.IOException;
import java.util.List;
import javax.net.ssl.SSLSocket;

public final class ConnectionSpecSelector
{
  private final List<ConnectionSpec> connectionSpecs;
  private boolean isFallback;
  private boolean isFallbackPossible;
  private int nextModeIndex = 0;
  
  public ConnectionSpecSelector(List<ConnectionSpec> paramList)
  {
    this.connectionSpecs = paramList;
  }
  
  private boolean isFallbackPossible(SSLSocket paramSSLSocket)
  {
    return false;
  }
  
  public ConnectionSpec configureSecureSocket(SSLSocket paramSSLSocket)
    throws IOException
  {
    return null;
  }
  
  public boolean connectionFailed(IOException paramIOException)
  {
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\okhttp3\internal\ConnectionSpecSelector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */