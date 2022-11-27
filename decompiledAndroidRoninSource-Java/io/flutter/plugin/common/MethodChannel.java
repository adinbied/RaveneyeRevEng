package io.flutter.plugin.common;

public final class MethodChannel
{
  private static final String TAG = "MethodChannel#";
  private final MethodCodec codec;
  private final BinaryMessenger messenger;
  private final String name;
  
  public MethodChannel(BinaryMessenger paramBinaryMessenger, String paramString)
  {
    this(paramBinaryMessenger, paramString, StandardMethodCodec.INSTANCE);
  }
  
  public MethodChannel(BinaryMessenger paramBinaryMessenger, String paramString, MethodCodec paramMethodCodec)
  {
    this.messenger = paramBinaryMessenger;
    this.name = paramString;
    this.codec = paramMethodCodec;
  }
  
  public void invokeMethod(String paramString, Object paramObject)
  {
    invokeMethod(paramString, paramObject, null);
  }
  
  /* Error */
  public void invokeMethod(String arg1, Object arg2, Result arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void resizeChannelBuffer(int paramInt)
  {
    BasicMessageChannel.resizeChannelBuffer(this.messenger, this.name, paramInt);
  }
  
  /* Error */
  public void setMethodCallHandler(MethodCallHandler arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private final class IncomingMethodCallHandler
    implements BinaryMessenger.BinaryMessageHandler
  {
    private final MethodChannel.MethodCallHandler handler;
    
    IncomingMethodCallHandler(MethodChannel.MethodCallHandler paramMethodCallHandler)
    {
      this.handler = paramMethodCallHandler;
    }
    
    /* Error */
    public void onMessage(java.nio.ByteBuffer arg1, BinaryMessenger.BinaryReply arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
  }
  
  private final class IncomingResultHandler
    implements BinaryMessenger.BinaryReply
  {
    private final MethodChannel.Result callback;
    
    IncomingResultHandler(MethodChannel.Result paramResult)
    {
      this.callback = paramResult;
    }
    
    /* Error */
    public void reply(java.nio.ByteBuffer arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
  }
  
  public static abstract interface MethodCallHandler
  {
    public abstract void onMethodCall(MethodCall paramMethodCall, MethodChannel.Result paramResult);
  }
  
  public static abstract interface Result
  {
    public abstract void error(String paramString1, String paramString2, Object paramObject);
    
    public abstract void notImplemented();
    
    public abstract void success(Object paramObject);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\flutter\plugin\common\MethodChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */