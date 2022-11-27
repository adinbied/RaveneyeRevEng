package okhttp3;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

@Metadata(bv={1, 0, 3}, d1={"\000<\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\002\n\000\n\002\030\002\n\000\n\002\020\b\n\000\n\002\020\016\n\002\b\003\n\002\020\003\n\000\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\002\b&\030\0002\0020\001B\005¢\006\002\020\002J \020\003\032\0020\0042\006\020\005\032\0020\0062\006\020\007\032\0020\b2\006\020\t\032\0020\nH\026J \020\013\032\0020\0042\006\020\005\032\0020\0062\006\020\007\032\0020\b2\006\020\t\032\0020\nH\026J\"\020\f\032\0020\0042\006\020\005\032\0020\0062\006\020\r\032\0020\0162\b\020\017\032\004\030\0010\020H\026J\030\020\021\032\0020\0042\006\020\005\032\0020\0062\006\020\022\032\0020\nH\026J\030\020\021\032\0020\0042\006\020\005\032\0020\0062\006\020\023\032\0020\024H\026J\030\020\025\032\0020\0042\006\020\005\032\0020\0062\006\020\017\032\0020\020H\026¨\006\026"}, d2={"Lokhttp3/WebSocketListener;", "", "()V", "onClosed", "", "webSocket", "Lokhttp3/WebSocket;", "code", "", "reason", "", "onClosing", "onFailure", "t", "", "response", "Lokhttp3/Response;", "onMessage", "text", "bytes", "Lokio/ByteString;", "onOpen", "okhttp"}, k=1, mv={1, 1, 16})
public abstract class WebSocketListener
{
  public void onClosed(WebSocket paramWebSocket, int paramInt, String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramWebSocket, "webSocket");
    Intrinsics.checkParameterIsNotNull(paramString, "reason");
  }
  
  public void onClosing(WebSocket paramWebSocket, int paramInt, String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramWebSocket, "webSocket");
    Intrinsics.checkParameterIsNotNull(paramString, "reason");
  }
  
  public void onFailure(WebSocket paramWebSocket, Throwable paramThrowable, Response paramResponse)
  {
    Intrinsics.checkParameterIsNotNull(paramWebSocket, "webSocket");
    Intrinsics.checkParameterIsNotNull(paramThrowable, "t");
  }
  
  public void onMessage(WebSocket paramWebSocket, String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramWebSocket, "webSocket");
    Intrinsics.checkParameterIsNotNull(paramString, "text");
  }
  
  public void onMessage(WebSocket paramWebSocket, ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramWebSocket, "webSocket");
    Intrinsics.checkParameterIsNotNull(paramByteString, "bytes");
  }
  
  public void onOpen(WebSocket paramWebSocket, Response paramResponse)
  {
    Intrinsics.checkParameterIsNotNull(paramWebSocket, "webSocket");
    Intrinsics.checkParameterIsNotNull(paramResponse, "response");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okhttp3\WebSocketListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */