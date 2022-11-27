package io.flutter.embedding.engine.systemchannels;

import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.JSONMethodCodec;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;

public class NavigationChannel
{
  private static final String TAG = "NavigationChannel";
  public final MethodChannel channel;
  
  public NavigationChannel(DartExecutor paramDartExecutor)
  {
    this.channel = new MethodChannel(paramDartExecutor, "flutter/navigation", JSONMethodCodec.INSTANCE);
  }
  
  /* Error */
  public void popRoute()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void pushRoute(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setInitialRoute(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void setMethodCallHandler(MethodChannel.MethodCallHandler paramMethodCallHandler)
  {
    this.channel.setMethodCallHandler(paramMethodCallHandler);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\flutter\embedding\engine\systemchannels\NavigationChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */