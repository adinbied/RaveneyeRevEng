package io.flutter.embedding.engine.plugins;

import android.content.Context;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.platform.PlatformViewRegistry;
import io.flutter.view.TextureRegistry;

public abstract interface FlutterPlugin
{
  public abstract void onAttachedToEngine(FlutterPluginBinding paramFlutterPluginBinding);
  
  public abstract void onDetachedFromEngine(FlutterPluginBinding paramFlutterPluginBinding);
  
  public static abstract interface FlutterAssets
  {
    public abstract String getAssetFilePathByName(String paramString);
    
    public abstract String getAssetFilePathByName(String paramString1, String paramString2);
    
    public abstract String getAssetFilePathBySubpath(String paramString);
    
    public abstract String getAssetFilePathBySubpath(String paramString1, String paramString2);
  }
  
  public static class FlutterPluginBinding
  {
    private final Context applicationContext;
    private final BinaryMessenger binaryMessenger;
    private final FlutterPlugin.FlutterAssets flutterAssets;
    private final FlutterEngine flutterEngine;
    private final PlatformViewRegistry platformViewRegistry;
    private final TextureRegistry textureRegistry;
    
    public FlutterPluginBinding(Context paramContext, FlutterEngine paramFlutterEngine, BinaryMessenger paramBinaryMessenger, TextureRegistry paramTextureRegistry, PlatformViewRegistry paramPlatformViewRegistry, FlutterPlugin.FlutterAssets paramFlutterAssets)
    {
      this.applicationContext = paramContext;
      this.flutterEngine = paramFlutterEngine;
      this.binaryMessenger = paramBinaryMessenger;
      this.textureRegistry = paramTextureRegistry;
      this.platformViewRegistry = paramPlatformViewRegistry;
      this.flutterAssets = paramFlutterAssets;
    }
    
    public Context getApplicationContext()
    {
      return this.applicationContext;
    }
    
    public BinaryMessenger getBinaryMessenger()
    {
      return this.binaryMessenger;
    }
    
    public FlutterPlugin.FlutterAssets getFlutterAssets()
    {
      return this.flutterAssets;
    }
    
    @Deprecated
    public FlutterEngine getFlutterEngine()
    {
      return this.flutterEngine;
    }
    
    public PlatformViewRegistry getPlatformViewRegistry()
    {
      return this.platformViewRegistry;
    }
    
    public TextureRegistry getTextureRegistry()
    {
      return this.textureRegistry;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\flutter\embedding\engine\plugins\FlutterPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */