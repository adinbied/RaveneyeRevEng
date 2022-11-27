package okhttp3;

import java.io.IOException;
import kotlin.Metadata;
import okio.Timeout;

@Metadata(bv={1, 0, 3}, d1={"\0004\n\002\030\002\n\002\020\032\n\000\n\002\020\002\n\002\b\003\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\013\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\bf\030\0002\0020\001:\001\021J\b\020\002\032\0020\003H&J\b\020\004\032\0020\000H&J\020\020\005\032\0020\0032\006\020\006\032\0020\007H&J\b\020\b\032\0020\tH&J\b\020\n\032\0020\013H&J\b\020\f\032\0020\013H&J\b\020\r\032\0020\016H&J\b\020\017\032\0020\020H&¨\006\022"}, d2={"Lokhttp3/Call;", "", "cancel", "", "clone", "enqueue", "responseCallback", "Lokhttp3/Callback;", "execute", "Lokhttp3/Response;", "isCanceled", "", "isExecuted", "request", "Lokhttp3/Request;", "timeout", "Lokio/Timeout;", "Factory", "okhttp"}, k=1, mv={1, 1, 16})
public abstract interface Call
  extends Cloneable
{
  public abstract void cancel();
  
  public abstract Call clone();
  
  public abstract void enqueue(Callback paramCallback);
  
  public abstract Response execute()
    throws IOException;
  
  public abstract boolean isCanceled();
  
  public abstract boolean isExecuted();
  
  public abstract Request request();
  
  public abstract Timeout timeout();
  
  @Metadata(bv={1, 0, 3}, d1={"\000\026\n\002\030\002\n\002\020\000\n\000\n\002\030\002\n\000\n\002\030\002\n\000\bf\030\0002\0020\001J\020\020\002\032\0020\0032\006\020\004\032\0020\005H&¨\006\006"}, d2={"Lokhttp3/Call$Factory;", "", "newCall", "Lokhttp3/Call;", "request", "Lokhttp3/Request;", "okhttp"}, k=1, mv={1, 1, 16})
  public static abstract interface Factory
  {
    public abstract Call newCall(Request paramRequest);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okhttp3\Call.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */