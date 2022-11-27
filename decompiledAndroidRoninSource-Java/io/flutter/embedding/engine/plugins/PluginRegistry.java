package io.flutter.embedding.engine.plugins;

import java.util.Set;

public abstract interface PluginRegistry
{
  public abstract void add(FlutterPlugin paramFlutterPlugin);
  
  public abstract void add(Set<FlutterPlugin> paramSet);
  
  public abstract FlutterPlugin get(Class<? extends FlutterPlugin> paramClass);
  
  public abstract boolean has(Class<? extends FlutterPlugin> paramClass);
  
  public abstract void remove(Class<? extends FlutterPlugin> paramClass);
  
  public abstract void remove(Set<Class<? extends FlutterPlugin>> paramSet);
  
  public abstract void removeAll();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\flutter\embedding\engine\plugins\PluginRegistry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */