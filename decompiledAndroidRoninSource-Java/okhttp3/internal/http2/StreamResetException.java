package okhttp3.internal.http2;

import java.io.IOException;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={"\000\022\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004R\020\020\002\032\0020\0038\006X\004¢\006\002\n\000¨\006\005"}, d2={"Lokhttp3/internal/http2/StreamResetException;", "Ljava/io/IOException;", "errorCode", "Lokhttp3/internal/http2/ErrorCode;", "(Lokhttp3/internal/http2/ErrorCode;)V", "okhttp"}, k=1, mv={1, 1, 16})
public final class StreamResetException
  extends IOException
{
  public final ErrorCode errorCode;
  
  public StreamResetException(ErrorCode paramErrorCode)
  {
    super(localStringBuilder.toString());
    this.errorCode = paramErrorCode;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okhttp3\internal\http2\StreamResetException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */