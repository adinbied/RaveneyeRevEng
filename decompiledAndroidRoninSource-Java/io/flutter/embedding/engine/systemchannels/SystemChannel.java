package io.flutter.embedding.engine.systemchannels;

import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.JSONMessageCodec;

public class SystemChannel
{
  private static final String TAG = "SystemChannel";
  public final BasicMessageChannel<Object> channel;
  
  public SystemChannel(DartExecutor paramDartExecutor)
  {
    this.channel = new BasicMessageChannel(paramDartExecutor, "flutter/system", JSONMessageCodec.INSTANCE);
  }
  
  /* Error */
  public void sendMemoryPressureWarning()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\flutter\embedding\engine\systemchannels\SystemChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */