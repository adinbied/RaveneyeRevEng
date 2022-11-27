package io.flutter.embedding.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterShellArgs;
import io.flutter.plugin.platform.PlatformPlugin;
import java.lang.reflect.Method;

public class FlutterActivity
  extends Activity
  implements FlutterActivityAndFragmentDelegate.Host, LifecycleOwner
{
  private static final String TAG = "FlutterActivity";
  protected FlutterActivityAndFragmentDelegate delegate;
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
  
  private View createFlutterView()
  {
    return this.delegate.onCreateView(null, null, null);
  }
  
  private Drawable getSplashScreenFromManifest()
  {
    return null;
  }
  
  private boolean isDebuggable()
  {
    return false;
  }
  
  private static void registerPlugins(FlutterEngine paramFlutterEngine)
  {
    try
    {
      Class.forName("io.flutter.plugins.GeneratedPluginRegistrant").getDeclaredMethod("registerWith", new Class[] { FlutterEngine.class }).invoke(null, new Object[] { paramFlutterEngine });
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder;
      for (;;) {}
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("Tried to automatically register plugins with FlutterEngine (");
    localStringBuilder.append(paramFlutterEngine);
    localStringBuilder.append(") but could not find and invoke the GeneratedPluginRegistrant.");
    Log.w("FlutterActivity", localStringBuilder.toString());
  }
  
  /* Error */
  private void switchLaunchThemeForNormalTheme()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public static CachedEngineIntentBuilder withCachedEngine(String paramString)
  {
    return new CachedEngineIntentBuilder(FlutterActivity.class, paramString);
  }
  
  public static NewEngineIntentBuilder withNewEngine()
  {
    return new NewEngineIntentBuilder(FlutterActivity.class);
  }
  
  public void cleanUpFlutterEngine(FlutterEngine paramFlutterEngine) {}
  
  public void configureFlutterEngine(FlutterEngine paramFlutterEngine)
  {
    registerPlugins(paramFlutterEngine);
  }
  
  public Activity getActivity()
  {
    return this;
  }
  
  public String getAppBundlePath()
  {
    return null;
  }
  
  protected FlutterActivityLaunchConfigs.BackgroundMode getBackgroundMode()
  {
    return null;
  }
  
  public String getCachedEngineId()
  {
    return null;
  }
  
  public Context getContext()
  {
    return this;
  }
  
  public String getDartEntrypointFunctionName()
  {
    return null;
  }
  
  protected FlutterEngine getFlutterEngine()
  {
    return this.delegate.getFlutterEngine();
  }
  
  public FlutterShellArgs getFlutterShellArgs()
  {
    return null;
  }
  
  public String getInitialRoute()
  {
    return null;
  }
  
  public Lifecycle getLifecycle()
  {
    return this.lifecycle;
  }
  
  public RenderMode getRenderMode()
  {
    return null;
  }
  
  public TransparencyMode getTransparencyMode()
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
  
  public void onFlutterSurfaceViewCreated(FlutterSurfaceView paramFlutterSurfaceView) {}
  
  public void onFlutterTextureViewCreated(FlutterTextureView paramFlutterTextureView) {}
  
  /* Error */
  public void onFlutterUiDisplayed()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void onFlutterUiNoLongerDisplayed() {}
  
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
  protected void onSaveInstanceState(android.os.Bundle arg1)
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
    return null;
  }
  
  public PlatformPlugin providePlatformPlugin(Activity paramActivity, FlutterEngine paramFlutterEngine)
  {
    return null;
  }
  
  public SplashScreen provideSplashScreen()
  {
    return null;
  }
  
  void setDelegate(FlutterActivityAndFragmentDelegate paramFlutterActivityAndFragmentDelegate)
  {
    this.delegate = paramFlutterActivityAndFragmentDelegate;
  }
  
  public boolean shouldAttachEngineToActivity()
  {
    return true;
  }
  
  public boolean shouldDestroyEngineWithHost()
  {
    return false;
  }
  
  public static class CachedEngineIntentBuilder
  {
    private final Class<? extends FlutterActivity> activityClass;
    private String backgroundMode = FlutterActivityLaunchConfigs.DEFAULT_BACKGROUND_MODE;
    private final String cachedEngineId;
    private boolean destroyEngineWithActivity = false;
    
    protected CachedEngineIntentBuilder(Class<? extends FlutterActivity> paramClass, String paramString)
    {
      this.activityClass = paramClass;
      this.cachedEngineId = paramString;
    }
    
    public CachedEngineIntentBuilder backgroundMode(FlutterActivityLaunchConfigs.BackgroundMode paramBackgroundMode)
    {
      this.backgroundMode = paramBackgroundMode.name();
      return this;
    }
    
    public Intent build(Context paramContext)
    {
      return null;
    }
    
    public CachedEngineIntentBuilder destroyEngineWithActivity(boolean paramBoolean)
    {
      this.destroyEngineWithActivity = paramBoolean;
      return this;
    }
  }
  
  public static class NewEngineIntentBuilder
  {
    private final Class<? extends FlutterActivity> activityClass;
    private String backgroundMode = FlutterActivityLaunchConfigs.DEFAULT_BACKGROUND_MODE;
    private String initialRoute = "/";
    
    protected NewEngineIntentBuilder(Class<? extends FlutterActivity> paramClass)
    {
      this.activityClass = paramClass;
    }
    
    public NewEngineIntentBuilder backgroundMode(FlutterActivityLaunchConfigs.BackgroundMode paramBackgroundMode)
    {
      this.backgroundMode = paramBackgroundMode.name();
      return this;
    }
    
    public Intent build(Context paramContext)
    {
      return null;
    }
    
    public NewEngineIntentBuilder initialRoute(String paramString)
    {
      this.initialRoute = paramString;
      return this;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\flutter\embedding\android\FlutterActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */