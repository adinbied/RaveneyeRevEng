package com.idlefish.flutterboost.containers;

import com.idlefish.flutterboost.XPlatformPlugin;
import io.flutter.embedding.engine.systemchannels.PlatformChannel;

class BoostViewUtils
{
  private static volatile XPlatformPlugin mInstance;
  
  public static XPlatformPlugin getPlatformPlugin(PlatformChannel paramPlatformChannel)
  {
    if (mInstance == null) {
      try
      {
        if (mInstance == null) {
          mInstance = new XPlatformPlugin(paramPlatformChannel);
        }
      }
      finally {}
    }
    return mInstance;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\idlefish\flutterboost\containers\BoostViewUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */