package io.flutter.embedding.engine;

import android.app.Activity;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.content.Context;
import android.content.Intent;
import androidx.lifecycle.Lifecycle;
import io.flutter.embedding.engine.loader.FlutterLoader;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.FlutterPlugin.FlutterAssets;
import io.flutter.embedding.engine.plugins.FlutterPlugin.FlutterPluginBinding;
import io.flutter.embedding.engine.plugins.PluginRegistry;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityControlSurface;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding.OnSaveInstanceStateListener;
import io.flutter.embedding.engine.plugins.broadcastreceiver.BroadcastReceiverAware;
import io.flutter.embedding.engine.plugins.broadcastreceiver.BroadcastReceiverControlSurface;
import io.flutter.embedding.engine.plugins.broadcastreceiver.BroadcastReceiverPluginBinding;
import io.flutter.embedding.engine.plugins.contentprovider.ContentProviderAware;
import io.flutter.embedding.engine.plugins.contentprovider.ContentProviderControlSurface;
import io.flutter.embedding.engine.plugins.contentprovider.ContentProviderPluginBinding;
import io.flutter.embedding.engine.plugins.lifecycle.HiddenLifecycleReference;
import io.flutter.embedding.engine.plugins.service.ServiceAware;
import io.flutter.embedding.engine.plugins.service.ServiceAware.OnModeChangeListener;
import io.flutter.embedding.engine.plugins.service.ServiceControlSurface;
import io.flutter.embedding.engine.plugins.service.ServicePluginBinding;
import io.flutter.plugin.common.PluginRegistry.ActivityResultListener;
import io.flutter.plugin.common.PluginRegistry.NewIntentListener;
import io.flutter.plugin.common.PluginRegistry.RequestPermissionsResultListener;
import io.flutter.plugin.common.PluginRegistry.UserLeaveHintListener;
import io.flutter.plugin.platform.PlatformViewsController;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class FlutterEnginePluginRegistry
  implements PluginRegistry, ActivityControlSurface, ServiceControlSurface, BroadcastReceiverControlSurface, ContentProviderControlSurface
{
  private static final String TAG = "FlutterEnginePluginRegistry";
  private Activity activity;
  private final Map<Class<? extends FlutterPlugin>, ActivityAware> activityAwarePlugins = new HashMap();
  private FlutterEngineActivityPluginBinding activityPluginBinding;
  private BroadcastReceiver broadcastReceiver;
  private final Map<Class<? extends FlutterPlugin>, BroadcastReceiverAware> broadcastReceiverAwarePlugins = new HashMap();
  private FlutterEngineBroadcastReceiverPluginBinding broadcastReceiverPluginBinding;
  private ContentProvider contentProvider;
  private final Map<Class<? extends FlutterPlugin>, ContentProviderAware> contentProviderAwarePlugins = new HashMap();
  private FlutterEngineContentProviderPluginBinding contentProviderPluginBinding;
  private final FlutterEngine flutterEngine;
  private boolean isWaitingForActivityReattachment = false;
  private final FlutterPlugin.FlutterPluginBinding pluginBinding;
  private final Map<Class<? extends FlutterPlugin>, FlutterPlugin> plugins = new HashMap();
  private Service service;
  private final Map<Class<? extends FlutterPlugin>, ServiceAware> serviceAwarePlugins = new HashMap();
  private FlutterEngineServicePluginBinding servicePluginBinding;
  
  FlutterEnginePluginRegistry(Context paramContext, FlutterEngine paramFlutterEngine, FlutterLoader paramFlutterLoader)
  {
    this.flutterEngine = paramFlutterEngine;
    this.pluginBinding = new FlutterPlugin.FlutterPluginBinding(paramContext, paramFlutterEngine, paramFlutterEngine.getDartExecutor(), paramFlutterEngine.getRenderer(), paramFlutterEngine.getPlatformViewsController().getRegistry(), new DefaultFlutterAssets(paramFlutterLoader, null));
  }
  
  /* Error */
  private void detachFromAndroidComponent()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private boolean isAttachedToActivity()
  {
    return this.activity != null;
  }
  
  private boolean isAttachedToBroadcastReceiver()
  {
    return this.broadcastReceiver != null;
  }
  
  private boolean isAttachedToContentProvider()
  {
    return this.contentProvider != null;
  }
  
  private boolean isAttachedToService()
  {
    return this.service != null;
  }
  
  /* Error */
  public void add(FlutterPlugin arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void add(Set<FlutterPlugin> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void attachToActivity(Activity arg1, Lifecycle arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void attachToBroadcastReceiver(BroadcastReceiver arg1, Lifecycle arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void attachToContentProvider(ContentProvider arg1, Lifecycle arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void attachToService(Service arg1, Lifecycle arg2, boolean arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void destroy()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void detachFromActivity()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void detachFromActivityForConfigChanges()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void detachFromBroadcastReceiver()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void detachFromContentProvider()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void detachFromService()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public FlutterPlugin get(Class<? extends FlutterPlugin> paramClass)
  {
    return null;
  }
  
  public boolean has(Class<? extends FlutterPlugin> paramClass)
  {
    return this.plugins.containsKey(paramClass);
  }
  
  public boolean onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    return false;
  }
  
  /* Error */
  public void onMoveToBackground()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onMoveToForeground()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onNewIntent(Intent arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    return false;
  }
  
  /* Error */
  public void onRestoreInstanceState(android.os.Bundle arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onSaveInstanceState(android.os.Bundle arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onUserLeaveHint()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void remove(Class<? extends FlutterPlugin> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void remove(Set<Class<? extends FlutterPlugin>> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void removeAll()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private static class DefaultFlutterAssets
    implements FlutterPlugin.FlutterAssets
  {
    final FlutterLoader flutterLoader;
    
    private DefaultFlutterAssets(FlutterLoader paramFlutterLoader)
    {
      this.flutterLoader = paramFlutterLoader;
    }
    
    public String getAssetFilePathByName(String paramString)
    {
      return this.flutterLoader.getLookupKeyForAsset(paramString);
    }
    
    public String getAssetFilePathByName(String paramString1, String paramString2)
    {
      return this.flutterLoader.getLookupKeyForAsset(paramString1, paramString2);
    }
    
    public String getAssetFilePathBySubpath(String paramString)
    {
      return this.flutterLoader.getLookupKeyForAsset(paramString);
    }
    
    public String getAssetFilePathBySubpath(String paramString1, String paramString2)
    {
      return this.flutterLoader.getLookupKeyForAsset(paramString1, paramString2);
    }
  }
  
  private static class FlutterEngineActivityPluginBinding
    implements ActivityPluginBinding
  {
    private final Activity activity;
    private final HiddenLifecycleReference hiddenLifecycleReference;
    private final Set<PluginRegistry.ActivityResultListener> onActivityResultListeners = new HashSet();
    private final Set<PluginRegistry.NewIntentListener> onNewIntentListeners = new HashSet();
    private final Set<PluginRegistry.RequestPermissionsResultListener> onRequestPermissionsResultListeners = new HashSet();
    private final Set<ActivityPluginBinding.OnSaveInstanceStateListener> onSaveInstanceStateListeners = new HashSet();
    private final Set<PluginRegistry.UserLeaveHintListener> onUserLeaveHintListeners = new HashSet();
    
    public FlutterEngineActivityPluginBinding(Activity paramActivity, Lifecycle paramLifecycle)
    {
      this.activity = paramActivity;
      this.hiddenLifecycleReference = new HiddenLifecycleReference(paramLifecycle);
    }
    
    public void addActivityResultListener(PluginRegistry.ActivityResultListener paramActivityResultListener)
    {
      this.onActivityResultListeners.add(paramActivityResultListener);
    }
    
    public void addOnNewIntentListener(PluginRegistry.NewIntentListener paramNewIntentListener)
    {
      this.onNewIntentListeners.add(paramNewIntentListener);
    }
    
    public void addOnSaveStateListener(ActivityPluginBinding.OnSaveInstanceStateListener paramOnSaveInstanceStateListener)
    {
      this.onSaveInstanceStateListeners.add(paramOnSaveInstanceStateListener);
    }
    
    public void addOnUserLeaveHintListener(PluginRegistry.UserLeaveHintListener paramUserLeaveHintListener)
    {
      this.onUserLeaveHintListeners.add(paramUserLeaveHintListener);
    }
    
    public void addRequestPermissionsResultListener(PluginRegistry.RequestPermissionsResultListener paramRequestPermissionsResultListener)
    {
      this.onRequestPermissionsResultListeners.add(paramRequestPermissionsResultListener);
    }
    
    public Activity getActivity()
    {
      return this.activity;
    }
    
    public Object getLifecycle()
    {
      return this.hiddenLifecycleReference;
    }
    
    boolean onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
    {
      return false;
    }
    
    /* Error */
    void onNewIntent(Intent arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    boolean onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
    {
      return false;
    }
    
    /* Error */
    void onRestoreInstanceState(android.os.Bundle arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void onSaveInstanceState(android.os.Bundle arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void onUserLeaveHint()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void removeActivityResultListener(PluginRegistry.ActivityResultListener paramActivityResultListener)
    {
      this.onActivityResultListeners.remove(paramActivityResultListener);
    }
    
    public void removeOnNewIntentListener(PluginRegistry.NewIntentListener paramNewIntentListener)
    {
      this.onNewIntentListeners.remove(paramNewIntentListener);
    }
    
    public void removeOnSaveStateListener(ActivityPluginBinding.OnSaveInstanceStateListener paramOnSaveInstanceStateListener)
    {
      this.onSaveInstanceStateListeners.remove(paramOnSaveInstanceStateListener);
    }
    
    public void removeOnUserLeaveHintListener(PluginRegistry.UserLeaveHintListener paramUserLeaveHintListener)
    {
      this.onUserLeaveHintListeners.remove(paramUserLeaveHintListener);
    }
    
    public void removeRequestPermissionsResultListener(PluginRegistry.RequestPermissionsResultListener paramRequestPermissionsResultListener)
    {
      this.onRequestPermissionsResultListeners.remove(paramRequestPermissionsResultListener);
    }
  }
  
  private static class FlutterEngineBroadcastReceiverPluginBinding
    implements BroadcastReceiverPluginBinding
  {
    private final BroadcastReceiver broadcastReceiver;
    
    FlutterEngineBroadcastReceiverPluginBinding(BroadcastReceiver paramBroadcastReceiver)
    {
      this.broadcastReceiver = paramBroadcastReceiver;
    }
    
    public BroadcastReceiver getBroadcastReceiver()
    {
      return this.broadcastReceiver;
    }
  }
  
  private static class FlutterEngineContentProviderPluginBinding
    implements ContentProviderPluginBinding
  {
    private final ContentProvider contentProvider;
    
    FlutterEngineContentProviderPluginBinding(ContentProvider paramContentProvider)
    {
      this.contentProvider = paramContentProvider;
    }
    
    public ContentProvider getContentProvider()
    {
      return this.contentProvider;
    }
  }
  
  private static class FlutterEngineServicePluginBinding
    implements ServicePluginBinding
  {
    private final HiddenLifecycleReference hiddenLifecycleReference;
    private final Set<ServiceAware.OnModeChangeListener> onModeChangeListeners = new HashSet();
    private final Service service;
    
    FlutterEngineServicePluginBinding(Service paramService, Lifecycle paramLifecycle)
    {
      this.service = paramService;
      if (paramLifecycle != null) {
        paramService = new HiddenLifecycleReference(paramLifecycle);
      } else {
        paramService = null;
      }
      this.hiddenLifecycleReference = paramService;
    }
    
    public void addOnModeChangeListener(ServiceAware.OnModeChangeListener paramOnModeChangeListener)
    {
      this.onModeChangeListeners.add(paramOnModeChangeListener);
    }
    
    public Object getLifecycle()
    {
      return this.hiddenLifecycleReference;
    }
    
    public Service getService()
    {
      return this.service;
    }
    
    /* Error */
    void onMoveToBackground()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void onMoveToForeground()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void removeOnModeChangeListener(ServiceAware.OnModeChangeListener paramOnModeChangeListener)
    {
      this.onModeChangeListeners.remove(paramOnModeChangeListener);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\flutter\embedding\engine\FlutterEnginePluginRegistry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */