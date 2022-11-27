package dji.midware.wsbridge;

import android.text.TextUtils;
import dji.log.RoninLog;
import dji.midware.MidWare;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.ScheduledExecutorService;

public class BridgeWSConnectionManager
{
  private static final String DEFAULT_IP = "10.128.129.92";
  private static final String HOST_PREFIX = "ws://";
  private static final String HOST_SUFFIX = ":9007";
  private static final int TRANSFER_SIZE_WITHOUT_VIDEO = 5;
  private static final int TRANSFER_SIZE_WITH_VIDEO = 2048;
  private ByteArrayOutputStream buffer;
  private StringBuilder ipAddress;
  private boolean isReconnecting;
  private OutputStream outStream;
  ScheduledExecutorService reconnectExecutor;
  private DJIWebSocketClient socketClient;
  
  private BridgeWSConnectionManager()
  {
    try
    {
      this.isReconnecting = false;
      Object localObject = new StringBuilder();
      this.ipAddress = ((StringBuilder)localObject);
      ((StringBuilder)localObject).append("ws://");
      if (TextUtils.isEmpty(""))
      {
        if (TextUtils.isEmpty(MidWare.bridgeIP)) {
          this.ipAddress.append("10.128.129.92");
        } else {
          this.ipAddress.append(MidWare.bridgeIP);
        }
      }
      else {
        this.ipAddress.append("");
      }
      this.ipAddress.append(":9007");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ipAddress ");
      ((StringBuilder)localObject).append(this.ipAddress.toString());
      RoninLog.d("WSOCKET", ((StringBuilder)localObject).toString(), new Object[0]);
      localObject = new DJIWebSocketClient(new URI(this.ipAddress.toString()));
      this.socketClient = ((DJIWebSocketClient)localObject);
      ((DJIWebSocketClient)localObject).connect();
      this.buffer = new ByteArrayOutputStream();
      this.outStream = new OutputStream()
      {
        /* Error */
        public void write(int arg1)
          throws IOException
        {
          // Byte code:
          //   0: return
          //   1: astore_2
          //   2: goto -2 -> 0
        }
        
        public void write(byte[] paramAnonymousArrayOfByte)
          throws IOException
        {
          BridgeWSConnectionManager.this.writeAfterFilter(paramAnonymousArrayOfByte, 0, paramAnonymousArrayOfByte.length);
        }
        
        /* Error */
        public void write(byte[] arg1, int arg2, int arg3)
          throws IOException
        {
          // Byte code:
          //   0: return
          //   1: astore_1
          //   2: goto -2 -> 0
        }
      };
      return;
    }
    catch (URISyntaxException localURISyntaxException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onError ");
      localStringBuilder.append(localURISyntaxException);
      RoninLog.d("WSOCKET", localStringBuilder.toString(), new Object[0]);
    }
  }
  
  public static BridgeWSConnectionManager getInstance()
  {
    return LazyHolder.INSTANCE;
  }
  
  private boolean send(byte[] paramArrayOfByte, int paramInt)
  {
    return false;
  }
  
  /* Error */
  private void sendIfReady()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void writeAfterFilter(byte[] arg1, int arg2, int arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public InputStream getInputStream()
  {
    return this.socketClient.getInputStream();
  }
  
  public OutputStream getOutputStream()
  {
    return this.outStream;
  }
  
  /* Error */
  void reconnect()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  private static class LazyHolder
  {
    private static final BridgeWSConnectionManager INSTANCE = new BridgeWSConnectionManager(null);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\wsbridge\BridgeWSConnectionManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */