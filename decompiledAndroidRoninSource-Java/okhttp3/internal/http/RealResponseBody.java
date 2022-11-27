package okhttp3.internal.http;

import kotlin.Metadata;
import okhttp3.MediaType;
import okhttp3.MediaType.Companion;
import okhttp3.ResponseBody;
import okio.BufferedSource;

@Metadata(bv={1, 0, 3}, d1={"\000$\n\002\030\002\n\002\030\002\n\000\n\002\020\016\n\000\n\002\020\t\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\000\030\0002\0020\001B\037\022\b\020\002\032\004\030\0010\003\022\006\020\004\032\0020\005\022\006\020\006\032\0020\007¢\006\002\020\bJ\b\020\004\032\0020\005H\026J\n\020\t\032\004\030\0010\nH\026J\b\020\006\032\0020\007H\026R\016\020\004\032\0020\005X\004¢\006\002\n\000R\020\020\002\032\004\030\0010\003X\004¢\006\002\n\000R\016\020\006\032\0020\007X\004¢\006\002\n\000¨\006\013"}, d2={"Lokhttp3/internal/http/RealResponseBody;", "Lokhttp3/ResponseBody;", "contentTypeString", "", "contentLength", "", "source", "Lokio/BufferedSource;", "(Ljava/lang/String;JLokio/BufferedSource;)V", "contentType", "Lokhttp3/MediaType;", "okhttp"}, k=1, mv={1, 1, 16})
public final class RealResponseBody
  extends ResponseBody
{
  private final long contentLength;
  private final String contentTypeString;
  private final BufferedSource source;
  
  public RealResponseBody(String paramString, long paramLong, BufferedSource paramBufferedSource)
  {
    this.contentTypeString = paramString;
    this.contentLength = paramLong;
    this.source = paramBufferedSource;
  }
  
  public long contentLength()
  {
    return this.contentLength;
  }
  
  public MediaType contentType()
  {
    String str = this.contentTypeString;
    if (str != null) {
      return MediaType.Companion.parse(str);
    }
    return null;
  }
  
  public BufferedSource source()
  {
    return this.source;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okhttp3\internal\http\RealResponseBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */