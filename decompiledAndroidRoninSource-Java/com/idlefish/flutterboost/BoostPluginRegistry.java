package com.idlefish.flutterboost;

import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.FlutterPlugin.FlutterPluginBinding;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.PluginRegistry.Registrar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BoostPluginRegistry
  implements io.flutter.plugin.common.PluginRegistry
{
  private static final String TAG = "ShimPluginRegistry";
  private final FlutterEngine flutterEngine;
  private final Map<String, Object> pluginMap = new HashMap();
  private final BoostRegistrarAggregate shimRegistrarAggregate;
  
  public BoostPluginRegistry(FlutterEngine paramFlutterEngine)
  {
    this.flutterEngine = paramFlutterEngine;
    this.shimRegistrarAggregate = new BoostRegistrarAggregate(null);
    this.flutterEngine.getPlugins().add(this.shimRegistrarAggregate);
  }
  
  public BoostRegistrarAggregate getRegistrarAggregate()
  {
    return this.shimRegistrarAggregate;
  }
  
  public boolean hasPlugin(String paramString)
  {
    return this.pluginMap.containsKey(paramString);
  }
  
  public PluginRegistry.Registrar registrarFor(String paramString)
  {
    return null;
  }
  
  public Object valuePublishedByPlugin(String paramString)
  {
    return this.pluginMap.get(paramString);
  }
  
  public static class BoostRegistrarAggregate
    implements FlutterPlugin, ActivityAware
  {
    private ActivityPluginBinding activityPluginBinding;
    private FlutterPlugin.FlutterPluginBinding flutterPluginBinding;
    private final Set<BoostRegistrar> shimRegistrars = new HashSet();
    
    /* Error */
    public void addPlugin(BoostRegistrar arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public ActivityPluginBinding getActivityPluginBinding()
    {
      return this.activityPluginBinding;
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
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\idlefish\flutterboost\BoostPluginRegistry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */