package io.flutter.embedding.engine.dart;

import android.content.res.AssetManager;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.BinaryMessenger.BinaryMessageHandler;
import io.flutter.plugin.common.BinaryMessenger.BinaryReply;
import io.flutter.view.FlutterCallbackInformation;
import io.flutter.view.FlutterMain;
import java.nio.ByteBuffer;

public class DartExecutor
  implements BinaryMessenger
{
  private static final String TAG = "DartExecutor";
  private final AssetManager assetManager;
  private final BinaryMessenger binaryMessenger;
  private final DartMessenger dartMessenger;
  private final FlutterJNI flutterJNI;
  private boolean isApplicationRunning = false;
  private final BinaryMessenger.BinaryMessageHandler isolateChannelMessageHandler = new BinaryMessenger.BinaryMessageHandler()
  {
    /* Error */
    public void onMessage(ByteBuffer arg1, BinaryMessenger.BinaryReply arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  };
  private String isolateServiceId;
  private IsolateServiceIdListener isolateServiceIdListener;
  
  public DartExecutor(FlutterJNI paramFlutterJNI, AssetManager paramAssetManager)
  {
    this.flutterJNI = paramFlutterJNI;
    this.assetManager = paramAssetManager;
    paramFlutterJNI = new DartMessenger(paramFlutterJNI);
    this.dartMessenger = paramFlutterJNI;
    paramFlutterJNI.setMessageHandler("flutter/isolate", this.isolateChannelMessageHandler);
    this.binaryMessenger = new DefaultBinaryMessenger(this.dartMessenger, null);
  }
  
  /* Error */
  public void executeDartCallback(DartCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void executeDartEntrypoint(DartEntrypoint arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public BinaryMessenger getBinaryMessenger()
  {
    return this.binaryMessenger;
  }
  
  public String getIsolateServiceId()
  {
    return this.isolateServiceId;
  }
  
  public int getPendingChannelResponseCount()
  {
    return this.dartMessenger.getPendingChannelResponseCount();
  }
  
  public boolean isExecutingDart()
  {
    return this.isApplicationRunning;
  }
  
  /* Error */
  public void onAttachedToJNI()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onDetachedFromJNI()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  @Deprecated
  public void send(String paramString, ByteBuffer paramByteBuffer)
  {
    this.binaryMessenger.send(paramString, paramByteBuffer);
  }
  
  @Deprecated
  public void send(String paramString, ByteBuffer paramByteBuffer, BinaryMessenger.BinaryReply paramBinaryReply)
  {
    this.binaryMessenger.send(paramString, paramByteBuffer, paramBinaryReply);
  }
  
  /* Error */
  public void setIsolateServiceIdListener(IsolateServiceIdListener arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  @Deprecated
  public void setMessageHandler(String paramString, BinaryMessenger.BinaryMessageHandler paramBinaryMessageHandler)
  {
    this.binaryMessenger.setMessageHandler(paramString, paramBinaryMessageHandler);
  }
  
  public static class DartCallback
  {
    public final AssetManager androidAssetManager;
    public final FlutterCallbackInformation callbackHandle;
    public final String pathToBundle;
    
    public DartCallback(AssetManager paramAssetManager, String paramString, FlutterCallbackInformation paramFlutterCallbackInformation)
    {
      this.androidAssetManager = paramAssetManager;
      this.pathToBundle = paramString;
      this.callbackHandle = paramFlutterCallbackInformation;
    }
    
    public String toString()
    {
      return null;
    }
  }
  
  public static class DartEntrypoint
  {
    public final String dartEntrypointFunctionName;
    public final String pathToBundle;
    
    public DartEntrypoint(String paramString1, String paramString2)
    {
      this.pathToBundle = paramString1;
      this.dartEntrypointFunctionName = paramString2;
    }
    
    public static DartEntrypoint createDefault()
    {
      return new DartEntrypoint(FlutterMain.findAppBundlePath(), "main");
    }
    
    public boolean equals(Object paramObject)
    {
      return false;
    }
    
    public int hashCode()
    {
      return 0;
    }
    
    public String toString()
    {
      return null;
    }
  }
  
  private static class DefaultBinaryMessenger
    implements BinaryMessenger
  {
    private final DartMessenger messenger;
    
    private DefaultBinaryMessenger(DartMessenger paramDartMessenger)
    {
      this.messenger = paramDartMessenger;
    }
    
    public void send(String paramString, ByteBuffer paramByteBuffer)
    {
      this.messenger.send(paramString, paramByteBuffer, null);
    }
    
    public void send(String paramString, ByteBuffer paramByteBuffer, BinaryMessenger.BinaryReply paramBinaryReply)
    {
      this.messenger.send(paramString, paramByteBuffer, paramBinaryReply);
    }
    
    public void setMessageHandler(String paramString, BinaryMessenger.BinaryMessageHandler paramBinaryMessageHandler)
    {
      this.messenger.setMessageHandler(paramString, paramBinaryMessageHandler);
    }
  }
  
  static abstract interface IsolateServiceIdListener
  {
    public abstract void onIsolateServiceIdAvailable(String paramString);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\flutter\embedding\engine\dart\DartExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */