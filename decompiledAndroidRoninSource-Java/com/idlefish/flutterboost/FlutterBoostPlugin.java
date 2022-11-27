package com.idlefish.flutterboost;

import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class FlutterBoostPlugin
{
  private static final Set<ActionAfterRegistered> sActions = new HashSet();
  private static FlutterBoostPlugin sInstance;
  private final Map<String, Set<EventListener>> mEventListeners = new HashMap();
  private final Set<MethodChannel.MethodCallHandler> mMethodCallHandlers = new HashSet();
  private final MethodChannel mMethodChannel;
  
  private FlutterBoostPlugin(PluginRegistry.Registrar paramRegistrar)
  {
    paramRegistrar = new MethodChannel(paramRegistrar.messenger(), "flutter_boost");
    this.mMethodChannel = paramRegistrar;
    paramRegistrar.setMethodCallHandler(new MethodChannel.MethodCallHandler()
    {
      /* Error */
      public void onMethodCall(io.flutter.plugin.common.MethodCall arg1, MethodChannel.Result arg2)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: return
      }
    });
    addMethodCallHandler(new BoostMethodHandler());
  }
  
  public static void addActionAfterRegistered(ActionAfterRegistered paramActionAfterRegistered)
  {
    if (paramActionAfterRegistered == null) {
      return;
    }
    FlutterBoostPlugin localFlutterBoostPlugin = sInstance;
    if (localFlutterBoostPlugin == null)
    {
      sActions.add(paramActionAfterRegistered);
      return;
    }
    paramActionAfterRegistered.onChannelRegistered(localFlutterBoostPlugin);
  }
  
  public static void registerWith(PluginRegistry.Registrar paramRegistrar)
  {
    sInstance = new FlutterBoostPlugin(paramRegistrar);
    paramRegistrar = sActions.iterator();
    while (paramRegistrar.hasNext()) {
      ((ActionAfterRegistered)paramRegistrar.next()).onChannelRegistered(sInstance);
    }
    sActions.clear();
  }
  
  public static FlutterBoostPlugin singleton()
  {
    FlutterBoostPlugin localFlutterBoostPlugin = sInstance;
    if (localFlutterBoostPlugin != null) {
      return localFlutterBoostPlugin;
    }
    throw new RuntimeException("FlutterBoostPlugin not register yet");
  }
  
  /* Error */
  public void addEventListener(String arg1, EventListener arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void addMethodCallHandler(MethodChannel.MethodCallHandler arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void invokeMethod(String arg1, java.io.Serializable arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void invokeMethod(String arg1, java.io.Serializable arg2, MethodChannel.Result arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void invokeMethodUnsafe(String arg1, java.io.Serializable arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void removeEventListener(EventListener arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void removeMethodCallHandler(MethodChannel.MethodCallHandler arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void sendEvent(String arg1, Map arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static abstract interface ActionAfterRegistered
  {
    public abstract void onChannelRegistered(FlutterBoostPlugin paramFlutterBoostPlugin);
  }
  
  class BoostMethodHandler
    implements MethodChannel.MethodCallHandler
  {
    BoostMethodHandler() {}
    
    /* Error */
    public void onMethodCall(io.flutter.plugin.common.MethodCall arg1, MethodChannel.Result arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
  }
  
  public static abstract interface EventListener
  {
    public abstract void onEvent(String paramString, Map paramMap);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\idlefish\flutterboost\FlutterBoostPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */