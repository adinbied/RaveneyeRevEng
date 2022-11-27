package com.idlefish.flutterboost;

import android.app.Activity;
import android.content.Context;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.FlutterPlugin.FlutterPluginBinding;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.PluginRegistry.ActivityResultListener;
import io.flutter.plugin.common.PluginRegistry.NewIntentListener;
import io.flutter.plugin.common.PluginRegistry.Registrar;
import io.flutter.plugin.common.PluginRegistry.RequestPermissionsResultListener;
import io.flutter.plugin.common.PluginRegistry.UserLeaveHintListener;
import io.flutter.plugin.common.PluginRegistry.ViewDestroyListener;
import io.flutter.plugin.platform.PlatformViewRegistry;
import io.flutter.view.FlutterMain;
import io.flutter.view.FlutterView;
import io.flutter.view.TextureRegistry;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class BoostRegistrar
  implements PluginRegistry.Registrar, FlutterPlugin, ActivityAware
{
  private static final String TAG = "ShimRegistrar";
  private ActivityPluginBinding activityPluginBinding;
  private final Set<PluginRegistry.ActivityResultListener> activityResultListeners = new HashSet();
  private final Map<String, Object> globalRegistrarMap;
  private final Set<PluginRegistry.NewIntentListener> newIntentListeners = new HashSet();
  private FlutterPlugin.FlutterPluginBinding pluginBinding;
  private final String pluginId;
  private final Set<PluginRegistry.RequestPermissionsResultListener> requestPermissionsResultListeners = new HashSet();
  private final Set<PluginRegistry.UserLeaveHintListener> userLeaveHintListeners = new HashSet();
  private final Set<PluginRegistry.ViewDestroyListener> viewDestroyListeners = new HashSet();
  
  public BoostRegistrar(String paramString, Map<String, Object> paramMap)
  {
    this.pluginId = paramString;
    this.globalRegistrarMap = paramMap;
  }
  
  /* Error */
  private void addExistingListenersToActivityPluginBinding()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public Context activeContext()
  {
    return null;
  }
  
  public Activity activity()
  {
    return null;
  }
  
  public PluginRegistry.Registrar addActivityResultListener(PluginRegistry.ActivityResultListener paramActivityResultListener)
  {
    return null;
  }
  
  public PluginRegistry.Registrar addNewIntentListener(PluginRegistry.NewIntentListener paramNewIntentListener)
  {
    return null;
  }
  
  public PluginRegistry.Registrar addRequestPermissionsResultListener(PluginRegistry.RequestPermissionsResultListener paramRequestPermissionsResultListener)
  {
    return null;
  }
  
  public PluginRegistry.Registrar addUserLeaveHintListener(PluginRegistry.UserLeaveHintListener paramUserLeaveHintListener)
  {
    return null;
  }
  
  public PluginRegistry.Registrar addViewDestroyListener(PluginRegistry.ViewDestroyListener paramViewDestroyListener)
  {
    this.viewDestroyListeners.add(paramViewDestroyListener);
    return this;
  }
  
  public Context context()
  {
    return null;
  }
  
  public String lookupKeyForAsset(String paramString)
  {
    return FlutterMain.getLookupKeyForAsset(paramString);
  }
  
  public String lookupKeyForAsset(String paramString1, String paramString2)
  {
    return FlutterMain.getLookupKeyForAsset(paramString1, paramString2);
  }
  
  public BinaryMessenger messenger()
  {
    return null;
  }
  
  /* Error */
  public void onAttachedToActivity(ActivityPluginBinding arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onDetachedFromActivity()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onDetachedFromActivityForConfigChanges()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onReattachedToActivityForConfigChanges(ActivityPluginBinding arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public PlatformViewRegistry platformViewRegistry()
  {
    return null;
  }
  
  public PluginRegistry.Registrar publish(Object paramObject)
  {
    this.globalRegistrarMap.put(this.pluginId, paramObject);
    return this;
  }
  
  public TextureRegistry textures()
  {
    return null;
  }
  
  public FlutterView view()
  {
    throw new UnsupportedOperationException("The new embedding does not support the old FlutterView.");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\idlefish\flutterboost\BoostRegistrar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */