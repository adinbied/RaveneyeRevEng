package okhttp3;

import java.net.Socket;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={"\000\"\n\002\030\002\n\002\020\000\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\bf\030\0002\0020\001J\n\020\002\032\004\030\0010\003H&J\b\020\004\032\0020\005H&J\b\020\006\032\0020\007H&J\b\020\b\032\0020\tH&¨\006\n"}, d2={"Lokhttp3/Connection;", "", "handshake", "Lokhttp3/Handshake;", "protocol", "Lokhttp3/Protocol;", "route", "Lokhttp3/Route;", "socket", "Ljava/net/Socket;", "okhttp"}, k=1, mv={1, 1, 16})
public abstract interface Connection
{
  public abstract Handshake handshake();
  
  public abstract Protocol protocol();
  
  public abstract Route route();
  
  public abstract Socket socket();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okhttp3\Connection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */