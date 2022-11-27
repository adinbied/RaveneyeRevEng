package okhttp3.internal.connection;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\000\036\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\007\n\002\020\002\n\002\b\002\030\0002\0060\001j\002`\002B\017\b\000\022\006\020\003\032\0020\004¢\006\002\020\005J\016\020\013\032\0020\f2\006\020\r\032\0020\004R\021\020\003\032\0020\004¢\006\b\n\000\032\004\b\006\020\007R\036\020\t\032\0020\0042\006\020\b\032\0020\004@BX\016¢\006\b\n\000\032\004\b\n\020\007¨\006\016"}, d2={"Lokhttp3/internal/connection/RouteException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "firstConnectException", "Ljava/io/IOException;", "(Ljava/io/IOException;)V", "getFirstConnectException", "()Ljava/io/IOException;", "<set-?>", "lastConnectException", "getLastConnectException", "addConnectException", "", "e", "okhttp"}, k=1, mv={1, 1, 16})
public final class RouteException
  extends RuntimeException
{
  private final IOException firstConnectException;
  private IOException lastConnectException;
  
  public RouteException(IOException paramIOException)
  {
    super((Throwable)paramIOException);
    this.firstConnectException = paramIOException;
    this.lastConnectException = paramIOException;
  }
  
  public final void addConnectException(IOException paramIOException)
  {
    Intrinsics.checkParameterIsNotNull(paramIOException, "e");
    this.firstConnectException.addSuppressed((Throwable)paramIOException);
    this.lastConnectException = paramIOException;
  }
  
  public final IOException getFirstConnectException()
  {
    return this.firstConnectException;
  }
  
  public final IOException getLastConnectException()
  {
    return this.lastConnectException;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okhttp3\internal\connection\RouteException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */