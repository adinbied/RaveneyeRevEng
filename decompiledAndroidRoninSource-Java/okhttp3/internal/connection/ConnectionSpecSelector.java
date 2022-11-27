package okhttp3.internal.connection;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ConnectionSpec;

@Metadata(bv={1, 0, 3}, d1={"\0006\n\002\030\002\n\002\020\000\n\000\n\002\020 \n\002\030\002\n\002\b\002\n\002\020\013\n\002\b\002\n\002\020\b\n\002\b\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\b\000\030\0002\0020\001B\023\022\f\020\002\032\b\022\004\022\0020\0040\003¢\006\002\020\005J\016\020\013\032\0020\0042\006\020\f\032\0020\rJ\016\020\016\032\0020\0072\006\020\017\032\0020\020J\020\020\b\032\0020\0072\006\020\021\032\0020\rH\002R\024\020\002\032\b\022\004\022\0020\0040\003X\004¢\006\002\n\000R\016\020\006\032\0020\007X\016¢\006\002\n\000R\016\020\b\032\0020\007X\016¢\006\002\n\000R\016\020\t\032\0020\nX\016¢\006\002\n\000¨\006\022"}, d2={"Lokhttp3/internal/connection/ConnectionSpecSelector;", "", "connectionSpecs", "", "Lokhttp3/ConnectionSpec;", "(Ljava/util/List;)V", "isFallback", "", "isFallbackPossible", "nextModeIndex", "", "configureSecureSocket", "sslSocket", "Ljavax/net/ssl/SSLSocket;", "connectionFailed", "e", "Ljava/io/IOException;", "socket", "okhttp"}, k=1, mv={1, 1, 16})
public final class ConnectionSpecSelector
{
  private final List<ConnectionSpec> connectionSpecs;
  private boolean isFallback;
  private boolean isFallbackPossible;
  private int nextModeIndex;
  
  public ConnectionSpecSelector(List<ConnectionSpec> paramList)
  {
    this.connectionSpecs = paramList;
  }
  
  private final boolean isFallbackPossible(SSLSocket paramSSLSocket)
  {
    int i = this.nextModeIndex;
    int j = this.connectionSpecs.size();
    while (i < j)
    {
      if (((ConnectionSpec)this.connectionSpecs.get(i)).isCompatible(paramSSLSocket)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public final ConnectionSpec configureSecureSocket(SSLSocket paramSSLSocket)
    throws IOException
  {
    Intrinsics.checkParameterIsNotNull(paramSSLSocket, "sslSocket");
    ConnectionSpec localConnectionSpec = (ConnectionSpec)null;
    int i = this.nextModeIndex;
    int j = this.connectionSpecs.size();
    Object localObject;
    for (;;)
    {
      localObject = localConnectionSpec;
      if (i >= j) {
        break;
      }
      localObject = (ConnectionSpec)this.connectionSpecs.get(i);
      if (((ConnectionSpec)localObject).isCompatible(paramSSLSocket))
      {
        this.nextModeIndex = (i + 1);
        break;
      }
      i += 1;
    }
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Unable to find acceptable protocols. isFallback=");
      ((StringBuilder)localObject).append(this.isFallback);
      ((StringBuilder)localObject).append(',');
      ((StringBuilder)localObject).append(" modes=");
      ((StringBuilder)localObject).append(this.connectionSpecs);
      ((StringBuilder)localObject).append(',');
      ((StringBuilder)localObject).append(" supported protocols=");
      paramSSLSocket = paramSSLSocket.getEnabledProtocols();
      if (paramSSLSocket == null) {
        Intrinsics.throwNpe();
      }
      paramSSLSocket = Arrays.toString(paramSSLSocket);
      Intrinsics.checkExpressionValueIsNotNull(paramSSLSocket, "java.util.Arrays.toString(this)");
      ((StringBuilder)localObject).append(paramSSLSocket);
      throw ((Throwable)new UnknownServiceException(((StringBuilder)localObject).toString()));
    }
    this.isFallbackPossible = isFallbackPossible(paramSSLSocket);
    ((ConnectionSpec)localObject).apply$okhttp(paramSSLSocket, this.isFallback);
    return (ConnectionSpec)localObject;
  }
  
  public final boolean connectionFailed(IOException paramIOException)
  {
    Intrinsics.checkParameterIsNotNull(paramIOException, "e");
    this.isFallback = true;
    if (!this.isFallbackPossible) {}
    while (((paramIOException instanceof ProtocolException)) || ((paramIOException instanceof InterruptedIOException)) || (((paramIOException instanceof SSLHandshakeException)) && ((paramIOException.getCause() instanceof CertificateException))) || ((paramIOException instanceof SSLPeerUnverifiedException)) || (!(paramIOException instanceof SSLException))) {
      return false;
    }
    return true;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okhttp3\internal\connection\ConnectionSpecSelector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */