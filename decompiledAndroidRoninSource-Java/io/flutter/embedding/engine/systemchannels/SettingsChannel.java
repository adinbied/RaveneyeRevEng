package io.flutter.embedding.engine.systemchannels;

import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.JSONMessageCodec;
import java.util.HashMap;
import java.util.Map;

public class SettingsChannel
{
  private static final String ALWAYS_USE_24_HOUR_FORMAT = "alwaysUse24HourFormat";
  public static final String CHANNEL_NAME = "flutter/settings";
  private static final String PLATFORM_BRIGHTNESS = "platformBrightness";
  private static final String TAG = "SettingsChannel";
  private static final String TEXT_SCALE_FACTOR = "textScaleFactor";
  public final BasicMessageChannel<Object> channel;
  
  public SettingsChannel(DartExecutor paramDartExecutor)
  {
    this.channel = new BasicMessageChannel(paramDartExecutor, "flutter/settings", JSONMessageCodec.INSTANCE);
  }
  
  public MessageBuilder startMessage()
  {
    return new MessageBuilder(this.channel);
  }
  
  public static class MessageBuilder
  {
    private final BasicMessageChannel<Object> channel;
    private Map<String, Object> message = new HashMap();
    
    MessageBuilder(BasicMessageChannel<Object> paramBasicMessageChannel)
    {
      this.channel = paramBasicMessageChannel;
    }
    
    /* Error */
    public void send()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public MessageBuilder setPlatformBrightness(SettingsChannel.PlatformBrightness paramPlatformBrightness)
    {
      return null;
    }
    
    public MessageBuilder setTextScaleFactor(float paramFloat)
    {
      return null;
    }
    
    public MessageBuilder setUse24HourFormat(boolean paramBoolean)
    {
      return null;
    }
  }
  
  public static enum PlatformBrightness
  {
    public String name;
    
    static
    {
      PlatformBrightness localPlatformBrightness = new PlatformBrightness("dark", 1, "dark");
      dark = localPlatformBrightness;
      $VALUES = new PlatformBrightness[] { light, localPlatformBrightness };
    }
    
    private PlatformBrightness(String paramString)
    {
      this.name = paramString;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\flutter\embedding\engine\systemchannels\SettingsChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */