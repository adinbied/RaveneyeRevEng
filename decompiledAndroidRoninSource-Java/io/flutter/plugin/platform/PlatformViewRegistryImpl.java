package io.flutter.plugin.platform;

import java.util.HashMap;
import java.util.Map;

class PlatformViewRegistryImpl
  implements PlatformViewRegistry
{
  private final Map<String, PlatformViewFactory> viewFactories = new HashMap();
  
  PlatformViewFactory getFactory(String paramString)
  {
    return null;
  }
  
  public boolean registerViewFactory(String paramString, PlatformViewFactory paramPlatformViewFactory)
  {
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\flutter\plugin\platform\PlatformViewRegistryImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */