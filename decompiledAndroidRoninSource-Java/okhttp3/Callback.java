package okhttp3;

import java.io.IOException;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={"\000$\n\002\030\002\n\002\020\000\n\000\n\002\020\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\000\bf\030\0002\0020\001J\030\020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\007H&J\030\020\b\032\0020\0032\006\020\004\032\0020\0052\006\020\t\032\0020\nH&¨\006\013"}, d2={"Lokhttp3/Callback;", "", "onFailure", "", "call", "Lokhttp3/Call;", "e", "Ljava/io/IOException;", "onResponse", "response", "Lokhttp3/Response;", "okhttp"}, k=1, mv={1, 1, 16})
public abstract interface Callback
{
  public abstract void onFailure(Call paramCall, IOException paramIOException);
  
  public abstract void onResponse(Call paramCall, Response paramResponse)
    throws IOException;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okhttp3\Callback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */