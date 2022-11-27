package com.idlefish.flutterboost.containers;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import com.idlefish.flutterboost.FlutterBoost;
import com.idlefish.flutterboost.XFlutterView;
import com.idlefish.flutterboost.XPlatformPlugin;
import io.flutter.embedding.android.FlutterView.RenderMode;
import io.flutter.embedding.android.FlutterView.TransparencyMode;
import io.flutter.embedding.android.SplashScreen;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterShellArgs;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class BoostFlutterActivity
  extends Activity
  implements FlutterActivityAndFragmentDelegate.Host, LifecycleOwner
{
  protected static final String DEFAULT_BACKGROUND_MODE = BackgroundMode.opaque.name();
  protected static final String EXTRA_BACKGROUND_MODE = "background_mode";
  protected static final String EXTRA_DART_ENTRYPOINT = "dart_entrypoint";
  protected static final String EXTRA_DESTROY_ENGINE_WITH_ACTIVITY = "destroy_engine_with_activity";
  protected static final String EXTRA_PARAMS = "params";
  protected static final String EXTRA_URL = "url";
  protected static final String NORMAL_THEME_META_DATA_KEY = "io.flutter.embedding.android.NormalTheme";
  protected static final String SPLASH_SCREEN_META_DATA_KEY = "io.flutter.embedding.android.SplashScreenDrawable";
  private static final String TAG = "NewBoostFlutterActivity";
  private static XPlatformPlugin sXPlatformPlugin;
  private FlutterActivityAndFragmentDelegate delegate;
  private LifecycleRegistry lifecycle = new LifecycleRegistry(this);
  
  /* Error */
  private void configureStatusBarForFullscreenFlutterExperience()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void configureWindowForTransparency()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static Intent createDefaultIntent(Context paramContext)
  {
    return withNewEngine().build(paramContext);
  }
  
  private Drawable getSplashScreenFromManifest()
  {
    return null;
  }
  
  private boolean isDebuggable()
  {
    return false;
  }
  
  /* Error */
  private void switchLaunchThemeForNormalTheme()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public static NewEngineIntentBuilder withNewEngine()
  {
    return new NewEngineIntentBuilder(BoostFlutterActivity.class);
  }
  
  public void cleanUpFlutterEngine(FlutterEngine paramFlutterEngine) {}
  
  public void configureFlutterEngine(FlutterEngine paramFlutterEngine) {}
  
  protected View createFlutterView()
  {
    return this.delegate.onCreateView(null, null, null);
  }
  
  public Activity getActivity()
  {
    return this;
  }
  
  protected BackgroundMode getBackgroundMode()
  {
    return null;
  }
  
  public String getContainerUrl()
  {
    return null;
  }
  
  public Map<String, Object> getContainerUrlParams()
  {
    return null;
  }
  
  public Context getContext()
  {
    return this;
  }
  
  protected FlutterEngine getFlutterEngine()
  {
    return this.delegate.getFlutterEngine();
  }
  
  public FlutterShellArgs getFlutterShellArgs()
  {
    return null;
  }
  
  protected XFlutterView getFlutterView()
  {
    return this.delegate.getFlutterView();
  }
  
  public Lifecycle getLifecycle()
  {
    return this.lifecycle;
  }
  
  public FlutterView.RenderMode getRenderMode()
  {
    return null;
  }
  
  public FlutterView.TransparencyMode getTransparencyMode()
  {
    return null;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.delegate.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onBackPressed()
  {
    this.delegate.onBackPressed();
  }
  
  /* Error */
  protected void onCreate(android.os.Bundle arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void onDestroy()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void onNewIntent(Intent arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void onPause()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onPostResume()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.delegate.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
  }
  
  /* Error */
  protected void onResume()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void onStart()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void onStop()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onTrimMemory(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  public void onUserLeaveHint()
  {
    this.delegate.onUserLeaveHint();
  }
  
  public FlutterEngine provideFlutterEngine(Context paramContext)
  {
    return FlutterBoost.instance().engineProvider();
  }
  
  public XPlatformPlugin providePlatformPlugin(FlutterEngine paramFlutterEngine)
  {
    return BoostViewUtils.getPlatformPlugin(paramFlutterEngine.getPlatformChannel());
  }
  
  public SplashScreen provideSplashScreen()
  {
    return null;
  }
  
  public boolean shouldAttachEngineToActivity()
  {
    return true;
  }
  
  public static enum BackgroundMode
  {
    static
    {
      BackgroundMode localBackgroundMode = new BackgroundMode("transparent", 1);
      transparent = localBackgroundMode;
      $VALUES = new BackgroundMode[] { opaque, localBackgroundMode };
    }
    
    private BackgroundMode() {}
  }
  
  public static class NewEngineIntentBuilder
  {
    private final Class<? extends BoostFlutterActivity> activityClass;
    private String backgroundMode = BoostFlutterActivity.DEFAULT_BACKGROUND_MODE;
    private Map<String, Object> params = new HashMap();
    private String url = "";
    
    public NewEngineIntentBuilder(Class<? extends BoostFlutterActivity> paramClass)
    {
      this.activityClass = paramClass;
    }
    
    public NewEngineIntentBuilder backgroundMode(BoostFlutterActivity.BackgroundMode paramBackgroundMode)
    {
      this.backgroundMode = paramBackgroundMode.name();
      return this;
    }
    
    public Intent build(Context paramContext)
    {
      return null;
    }
    
    public NewEngineIntentBuilder params(Map<String, Object> paramMap)
    {
      this.params = paramMap;
      return this;
    }
    
    public NewEngineIntentBuilder url(String paramString)
    {
      this.url = paramString;
      return this;
    }
  }
  
  public static class SerializableMap
    implements Serializable
  {
    private Map<String, Object> map;
    
    public Map<String, Object> getMap()
    {
      return this.map;
    }
    
    public void setMap(Map<String, Object> paramMap)
    {
      this.map = paramMap;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\idlefish\flutterboost\containers\BoostFlutterActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */