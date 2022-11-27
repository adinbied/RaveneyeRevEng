package io.flutter.embedding.engine.systemchannels;

import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.JSONMethodCodec;
import io.flutter.plugin.common.MethodChannel;

public class LocalizationChannel
{
  private static final String TAG = "LocalizationChannel";
  public final MethodChannel channel;
  
  public LocalizationChannel(DartExecutor paramDartExecutor)
  {
    this.channel = new MethodChannel(paramDartExecutor, "flutter/localization", JSONMethodCodec.INSTANCE);
  }
  
  /* Error */
  public void sendLocales(java.util.List<java.util.Locale> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\flutter\embedding\engine\systemchannels\LocalizationChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */