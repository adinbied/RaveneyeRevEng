package io.flutter.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.PluginRegistry;
import io.flutter.plugin.common.PluginRegistry.ActivityResultListener;
import io.flutter.plugin.common.PluginRegistry.NewIntentListener;
import io.flutter.plugin.common.PluginRegistry.Registrar;
import io.flutter.plugin.common.PluginRegistry.RequestPermissionsResultListener;
import io.flutter.plugin.common.PluginRegistry.UserLeaveHintListener;
import io.flutter.plugin.common.PluginRegistry.ViewDestroyListener;
import io.flutter.plugin.platform.PlatformViewRegistry;
import io.flutter.plugin.platform.PlatformViewsController;
import io.flutter.view.FlutterMain;
import io.flutter.view.FlutterNativeView;
import io.flutter.view.FlutterView;
import io.flutter.view.TextureRegistry;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FlutterPluginRegistry
  implements PluginRegistry, PluginRegistry.RequestPermissionsResultListener, PluginRegistry.ActivityResultListener, PluginRegistry.NewIntentListener, PluginRegistry.UserLeaveHintListener, PluginRegistry.ViewDestroyListener
{
  private static final String TAG = "FlutterPluginRegistry";
  private Activity mActivity;
  private final List<PluginRegistry.ActivityResultListener> mActivityResultListeners = new ArrayList(0);
  private Context mAppContext;
  private FlutterView mFlutterView;
  private FlutterNativeView mNativeView;
  private final List<PluginRegistry.NewIntentListener> mNewIntentListeners = new ArrayList(0);
  private final PlatformViewsController mPlatformViewsController;
  private final Map<String, Object> mPluginMap = new LinkedHashMap(0);
  private final List<PluginRegistry.RequestPermissionsResultListener> mRequestPermissionsResultListeners = new ArrayList(0);
  private final List<PluginRegistry.UserLeaveHintListener> mUserLeaveHintListeners = new ArrayList(0);
  private final List<PluginRegistry.ViewDestroyListener> mViewDestroyListeners = new ArrayList(0);
  
  public FlutterPluginRegistry(FlutterEngine paramFlutterEngine, Context paramContext)
  {
    this.mAppContext = paramContext;
    this.mPlatformViewsController = new PlatformViewsController();
  }
  
  public FlutterPluginRegistry(FlutterNativeView paramFlutterNativeView, Context paramContext)
  {
    this.mNativeView = paramFlutterNativeView;
    this.mAppContext = paramContext;
    this.mPlatformViewsController = new PlatformViewsController();
  }
  
  /* Error */
  public void attach(FlutterView arg1, Activity arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void destroy()
  {
    this.mPlatformViewsController.onFlutterViewDestroyed();
  }
  
  /* Error */
  public void detach()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public PlatformViewsController getPlatformViewsController()
  {
    return this.mPlatformViewsController;
  }
  
  public boolean hasPlugin(String paramString)
  {
    return this.mPluginMap.containsKey(paramString);
  }
  
  public boolean onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    return false;
  }
  
  public boolean onNewIntent(Intent paramIntent)
  {
    return false;
  }
  
  public void onPreEngineRestart()
  {
    this.mPlatformViewsController.onPreEngineRestart();
  }
  
  public boolean onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    return false;
  }
  
  /* Error */
  public void onUserLeaveHint()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean onViewDestroy(FlutterNativeView paramFlutterNativeView)
  {
    return false;
  }
  
  public PluginRegistry.Registrar registrarFor(String paramString)
  {
    return null;
  }
  
  public <T> T valuePublishedByPlugin(String paramString)
  {
    return (T)this.mPluginMap.get(paramString);
  }
  
  private class FlutterRegistrar
    implements PluginRegistry.Registrar
  {
    private final String pluginKey;
    
    FlutterRegistrar(String paramString)
    {
      this.pluginKey = paramString;
    }
    
    public Context activeContext()
    {
      return null;
    }
    
    public Activity activity()
    {
      return FlutterPluginRegistry.this.mActivity;
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
      return null;
    }
    
    public Context context()
    {
      return FlutterPluginRegistry.this.mAppContext;
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
      return FlutterPluginRegistry.this.mNativeView;
    }
    
    public PlatformViewRegistry platformViewRegistry()
    {
      return null;
    }
    
    public PluginRegistry.Registrar publish(Object paramObject)
    {
      return null;
    }
    
    public TextureRegistry textures()
    {
      return FlutterPluginRegistry.this.mFlutterView;
    }
    
    public FlutterView view()
    {
      return FlutterPluginRegistry.this.mFlutterView;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\flutter\app\FlutterPluginRegistry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */