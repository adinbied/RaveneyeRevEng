package io.flutter.embedding.engine;

import android.content.Context;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.loader.FlutterLoader;
import io.flutter.embedding.engine.plugins.PluginRegistry;
import io.flutter.embedding.engine.plugins.activity.ActivityControlSurface;
import io.flutter.embedding.engine.plugins.broadcastreceiver.BroadcastReceiverControlSurface;
import io.flutter.embedding.engine.plugins.contentprovider.ContentProviderControlSurface;
import io.flutter.embedding.engine.plugins.service.ServiceControlSurface;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.embedding.engine.systemchannels.AccessibilityChannel;
import io.flutter.embedding.engine.systemchannels.KeyEventChannel;
import io.flutter.embedding.engine.systemchannels.LifecycleChannel;
import io.flutter.embedding.engine.systemchannels.LocalizationChannel;
import io.flutter.embedding.engine.systemchannels.NavigationChannel;
import io.flutter.embedding.engine.systemchannels.PlatformChannel;
import io.flutter.embedding.engine.systemchannels.SettingsChannel;
import io.flutter.embedding.engine.systemchannels.SystemChannel;
import io.flutter.embedding.engine.systemchannels.TextInputChannel;
import io.flutter.plugin.platform.PlatformViewsController;
import java.util.HashSet;
import java.util.Set;

public class FlutterEngine
{
  private static final String TAG = "FlutterEngine";
  private final AccessibilityChannel accessibilityChannel;
  private final DartExecutor dartExecutor;
  private final EngineLifecycleListener engineLifecycleListener = new EngineLifecycleListener()
  {
    /* Error */
    public void onPreEngineRestart()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  };
  private final Set<EngineLifecycleListener> engineLifecycleListeners = new HashSet();
  private final FlutterJNI flutterJNI;
  private final KeyEventChannel keyEventChannel;
  private final LifecycleChannel lifecycleChannel;
  private final LocalizationChannel localizationChannel;
  private final NavigationChannel navigationChannel;
  private final PlatformChannel platformChannel;
  private final PlatformViewsController platformViewsController;
  private final FlutterEnginePluginRegistry pluginRegistry;
  private final FlutterRenderer renderer;
  private final SettingsChannel settingsChannel;
  private final SystemChannel systemChannel;
  private final TextInputChannel textInputChannel;
  
  public FlutterEngine(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FlutterEngine(Context paramContext, FlutterLoader paramFlutterLoader, FlutterJNI paramFlutterJNI)
  {
    this(paramContext, paramFlutterLoader, paramFlutterJNI, null, true);
  }
  
  public FlutterEngine(Context paramContext, FlutterLoader paramFlutterLoader, FlutterJNI paramFlutterJNI, PlatformViewsController paramPlatformViewsController, String[] paramArrayOfString, boolean paramBoolean)
  {
    this.flutterJNI = paramFlutterJNI;
    paramFlutterLoader.startInitialization(paramContext.getApplicationContext());
    paramFlutterLoader.ensureInitializationComplete(paramContext, paramArrayOfString);
    paramFlutterJNI.addEngineLifecycleListener(this.engineLifecycleListener);
    attachToJni();
    paramArrayOfString = new DartExecutor(paramFlutterJNI, paramContext.getAssets());
    this.dartExecutor = paramArrayOfString;
    paramArrayOfString.onAttachedToJNI();
    this.renderer = new FlutterRenderer(paramFlutterJNI);
    this.accessibilityChannel = new AccessibilityChannel(this.dartExecutor, paramFlutterJNI);
    this.keyEventChannel = new KeyEventChannel(this.dartExecutor);
    this.lifecycleChannel = new LifecycleChannel(this.dartExecutor);
    this.localizationChannel = new LocalizationChannel(this.dartExecutor);
    this.navigationChannel = new NavigationChannel(this.dartExecutor);
    this.platformChannel = new PlatformChannel(this.dartExecutor);
    this.settingsChannel = new SettingsChannel(this.dartExecutor);
    this.systemChannel = new SystemChannel(this.dartExecutor);
    this.textInputChannel = new TextInputChannel(this.dartExecutor);
    this.platformViewsController = paramPlatformViewsController;
    this.pluginRegistry = new FlutterEnginePluginRegistry(paramContext.getApplicationContext(), this, paramFlutterLoader);
    if (paramBoolean) {
      registerPlugins();
    }
  }
  
  public FlutterEngine(Context paramContext, FlutterLoader paramFlutterLoader, FlutterJNI paramFlutterJNI, String[] paramArrayOfString, boolean paramBoolean)
  {
    this(paramContext, paramFlutterLoader, paramFlutterJNI, new PlatformViewsController(), paramArrayOfString, paramBoolean);
  }
  
  public FlutterEngine(Context paramContext, String[] paramArrayOfString)
  {
    this(paramContext, FlutterLoader.getInstance(), new FlutterJNI(), paramArrayOfString, true);
  }
  
  public FlutterEngine(Context paramContext, String[] paramArrayOfString, boolean paramBoolean)
  {
    this(paramContext, FlutterLoader.getInstance(), new FlutterJNI(), paramArrayOfString, paramBoolean);
  }
  
  /* Error */
  private void attachToJni()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private boolean isAttachedToJni()
  {
    return this.flutterJNI.isAttached();
  }
  
  /* Error */
  private void registerPlugins()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public void addEngineLifecycleListener(EngineLifecycleListener paramEngineLifecycleListener)
  {
    this.engineLifecycleListeners.add(paramEngineLifecycleListener);
  }
  
  /* Error */
  public void destroy()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public AccessibilityChannel getAccessibilityChannel()
  {
    return this.accessibilityChannel;
  }
  
  public ActivityControlSurface getActivityControlSurface()
  {
    return this.pluginRegistry;
  }
  
  public BroadcastReceiverControlSurface getBroadcastReceiverControlSurface()
  {
    return this.pluginRegistry;
  }
  
  public ContentProviderControlSurface getContentProviderControlSurface()
  {
    return this.pluginRegistry;
  }
  
  public DartExecutor getDartExecutor()
  {
    return this.dartExecutor;
  }
  
  public KeyEventChannel getKeyEventChannel()
  {
    return this.keyEventChannel;
  }
  
  public LifecycleChannel getLifecycleChannel()
  {
    return this.lifecycleChannel;
  }
  
  public LocalizationChannel getLocalizationChannel()
  {
    return this.localizationChannel;
  }
  
  public NavigationChannel getNavigationChannel()
  {
    return this.navigationChannel;
  }
  
  public PlatformChannel getPlatformChannel()
  {
    return this.platformChannel;
  }
  
  public PlatformViewsController getPlatformViewsController()
  {
    return this.platformViewsController;
  }
  
  public PluginRegistry getPlugins()
  {
    return this.pluginRegistry;
  }
  
  public FlutterRenderer getRenderer()
  {
    return this.renderer;
  }
  
  public ServiceControlSurface getServiceControlSurface()
  {
    return this.pluginRegistry;
  }
  
  public SettingsChannel getSettingsChannel()
  {
    return this.settingsChannel;
  }
  
  public SystemChannel getSystemChannel()
  {
    return this.systemChannel;
  }
  
  public TextInputChannel getTextInputChannel()
  {
    return this.textInputChannel;
  }
  
  public void removeEngineLifecycleListener(EngineLifecycleListener paramEngineLifecycleListener)
  {
    this.engineLifecycleListeners.remove(paramEngineLifecycleListener);
  }
  
  public static abstract interface EngineLifecycleListener
  {
    public abstract void onPreEngineRestart();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\flutter\embedding\engine\FlutterEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */