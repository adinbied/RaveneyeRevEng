package io.flutter.embedding.engine.systemchannels;

import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.FlutterJNI.AccessibilityDelegate;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BasicMessageChannel.MessageHandler;
import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.view.AccessibilityBridge.Action;

public class AccessibilityChannel
{
  private static final String TAG = "AccessibilityChannel";
  public final BasicMessageChannel<Object> channel;
  public final FlutterJNI flutterJNI;
  private AccessibilityMessageHandler handler;
  private final BasicMessageChannel.MessageHandler<Object> parsingMessageHandler = new BasicMessageChannel.MessageHandler()
  {
    /* Error */
    public void onMessage(Object arg1, io.flutter.plugin.common.BasicMessageChannel.Reply<Object> arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  };
  
  public AccessibilityChannel(DartExecutor paramDartExecutor, FlutterJNI paramFlutterJNI)
  {
    paramDartExecutor = new BasicMessageChannel(paramDartExecutor, "flutter/accessibility", StandardMessageCodec.INSTANCE);
    this.channel = paramDartExecutor;
    paramDartExecutor.setMessageHandler(this.parsingMessageHandler);
    this.flutterJNI = paramFlutterJNI;
  }
  
  public void dispatchSemanticsAction(int paramInt, AccessibilityBridge.Action paramAction)
  {
    this.flutterJNI.dispatchSemanticsAction(paramInt, paramAction);
  }
  
  public void dispatchSemanticsAction(int paramInt, AccessibilityBridge.Action paramAction, Object paramObject)
  {
    this.flutterJNI.dispatchSemanticsAction(paramInt, paramAction, paramObject);
  }
  
  public void onAndroidAccessibilityDisabled()
  {
    this.flutterJNI.setSemanticsEnabled(false);
  }
  
  public void onAndroidAccessibilityEnabled()
  {
    this.flutterJNI.setSemanticsEnabled(true);
  }
  
  public void setAccessibilityFeatures(int paramInt)
  {
    this.flutterJNI.setAccessibilityFeatures(paramInt);
  }
  
  public void setAccessibilityMessageHandler(AccessibilityMessageHandler paramAccessibilityMessageHandler)
  {
    this.handler = paramAccessibilityMessageHandler;
    this.flutterJNI.setAccessibilityDelegate(paramAccessibilityMessageHandler);
  }
  
  public static abstract interface AccessibilityMessageHandler
    extends FlutterJNI.AccessibilityDelegate
  {
    public abstract void announce(String paramString);
    
    public abstract void onLongPress(int paramInt);
    
    public abstract void onTap(int paramInt);
    
    public abstract void onTooltip(String paramString);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\flutter\embedding\engine\systemchannels\AccessibilityChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */