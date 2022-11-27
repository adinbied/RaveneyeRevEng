package io.flutter.plugin.common;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class EventChannel
{
  private static final String TAG = "EventChannel#";
  private final MethodCodec codec;
  private final BinaryMessenger messenger;
  private final String name;
  
  public EventChannel(BinaryMessenger paramBinaryMessenger, String paramString)
  {
    this(paramBinaryMessenger, paramString, StandardMethodCodec.INSTANCE);
  }
  
  public EventChannel(BinaryMessenger paramBinaryMessenger, String paramString, MethodCodec paramMethodCodec)
  {
    this.messenger = paramBinaryMessenger;
    this.name = paramString;
    this.codec = paramMethodCodec;
  }
  
  /* Error */
  public void setStreamHandler(StreamHandler arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static abstract interface EventSink
  {
    public abstract void endOfStream();
    
    public abstract void error(String paramString1, String paramString2, Object paramObject);
    
    public abstract void success(Object paramObject);
  }
  
  private final class IncomingStreamRequestHandler
    implements BinaryMessenger.BinaryMessageHandler
  {
    private final AtomicReference<EventChannel.EventSink> activeSink = new AtomicReference(null);
    private final EventChannel.StreamHandler handler;
    
    IncomingStreamRequestHandler(EventChannel.StreamHandler paramStreamHandler)
    {
      this.handler = paramStreamHandler;
    }
    
    /* Error */
    private void onCancel(Object arg1, BinaryMessenger.BinaryReply arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    private void onListen(Object arg1, BinaryMessenger.BinaryReply arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    public void onMessage(java.nio.ByteBuffer arg1, BinaryMessenger.BinaryReply arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    private final class EventSinkImplementation
      implements EventChannel.EventSink
    {
      final AtomicBoolean hasEnded = new AtomicBoolean(false);
      
      private EventSinkImplementation() {}
      
      /* Error */
      public void endOfStream()
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: goto -2 -> 0
      }
      
      /* Error */
      public void error(String arg1, String arg2, Object arg3)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: goto -2 -> 0
      }
      
      /* Error */
      public void success(Object arg1)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: goto -2 -> 0
      }
    }
  }
  
  public static abstract interface StreamHandler
  {
    public abstract void onCancel(Object paramObject);
    
    public abstract void onListen(Object paramObject, EventChannel.EventSink paramEventSink);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\flutter\plugin\common\EventChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */