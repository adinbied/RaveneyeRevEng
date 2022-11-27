package dji.midware.wsbridge;

import dji.log.RoninLog;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.concurrent.LinkedBlockingDeque;
import org.java_websocket.client.WebSocketClient;

public class DJIWebSocketClient
  extends WebSocketClient
{
  private InputStream inStream = new InputStream()
  {
    public int read()
      throws IOException
    {
      return 0;
    }
    
    public int read(byte[] paramAnonymousArrayOfByte)
      throws IOException
    {
      return 0;
    }
    
    public int read(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt1, int paramAnonymousInt2)
      throws IOException
    {
      return 0;
    }
  };
  private ByteBuffer mLast;
  private LinkedBlockingDeque<ByteBuffer> mQueue = new LinkedBlockingDeque();
  
  public DJIWebSocketClient(URI paramURI)
  {
    super(paramURI);
    RoninLog.d("WSOCKET", "Starting...", new Object[0]);
  }
  
  private ByteBuffer read()
  {
    return null;
  }
  
  public InputStream getInputStream()
  {
    return this.inStream;
  }
  
  public void onClose(int paramInt, String paramString, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onClose ");
    localStringBuilder.append(paramString);
    RoninLog.d("WSOCKET", localStringBuilder.toString(), new Object[0]);
    BridgeWSConnectionManager.getInstance().reconnect();
  }
  
  /* Error */
  public void onError(Exception arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void onMessage(String paramString) {}
  
  public void onMessage(ByteBuffer paramByteBuffer)
  {
    LinkedBlockingDeque localLinkedBlockingDeque = this.mQueue;
    if (localLinkedBlockingDeque != null) {
      localLinkedBlockingDeque.add(paramByteBuffer);
    }
  }
  
  /* Error */
  public void onOpen(org.java_websocket.handshake.ServerHandshake arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\wsbridge\DJIWebSocketClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */