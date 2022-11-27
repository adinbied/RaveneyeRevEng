package io.flutter.plugin.common;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Locale;

public final class BasicMessageChannel<T>
{
  public static final String CHANNEL_BUFFERS_CHANNEL = "dev.flutter/channel-buffers";
  private static final String TAG = "BasicMessageChannel#";
  private final MessageCodec<T> codec;
  private final BinaryMessenger messenger;
  private final String name;
  
  public BasicMessageChannel(BinaryMessenger paramBinaryMessenger, String paramString, MessageCodec<T> paramMessageCodec)
  {
    this.messenger = paramBinaryMessenger;
    this.name = paramString;
    this.codec = paramMessageCodec;
  }
  
  static void resizeChannelBuffer(BinaryMessenger paramBinaryMessenger, String paramString, int paramInt)
  {
    Charset localCharset = Charset.forName("UTF-8");
    paramBinaryMessenger.send("dev.flutter/channel-buffers", ByteBuffer.wrap(String.format(Locale.US, "resize\r%s\r%d", new Object[] { paramString, Integer.valueOf(paramInt) }).getBytes(localCharset)));
  }
  
  public void resizeChannelBuffer(int paramInt)
  {
    resizeChannelBuffer(this.messenger, this.name, paramInt);
  }
  
  public void send(T paramT)
  {
    send(paramT, null);
  }
  
  /* Error */
  public void send(T arg1, Reply<T> arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setMessageHandler(MessageHandler<T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private final class IncomingMessageHandler
    implements BinaryMessenger.BinaryMessageHandler
  {
    private final BasicMessageChannel.MessageHandler<T> handler;
    
    private IncomingMessageHandler()
    {
      BasicMessageChannel.MessageHandler localMessageHandler;
      this.handler = localMessageHandler;
    }
    
    /* Error */
    public void onMessage(ByteBuffer arg1, BinaryMessenger.BinaryReply arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
  }
  
  private final class IncomingReplyHandler
    implements BinaryMessenger.BinaryReply
  {
    private final BasicMessageChannel.Reply<T> callback;
    
    private IncomingReplyHandler()
    {
      BasicMessageChannel.Reply localReply;
      this.callback = localReply;
    }
    
    /* Error */
    public void reply(ByteBuffer arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
  }
  
  public static abstract interface MessageHandler<T>
  {
    public abstract void onMessage(T paramT, BasicMessageChannel.Reply<T> paramReply);
  }
  
  public static abstract interface Reply<T>
  {
    public abstract void reply(T paramT);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\flutter\plugin\common\BasicMessageChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */