package io.flutter.embedding.android;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import io.flutter.embedding.engine.FlutterEngine;

public class FlutterFragmentActivity
  extends FragmentActivity
  implements SplashScreenProvider, FlutterEngineProvider, FlutterEngineConfigurator
{
  private static final int FRAGMENT_CONTAINER_ID = 609893468;
  private static final String TAG = "FlutterFragmentActivity";
  private static final String TAG_FLUTTER_FRAGMENT = "flutter_fragment";
  private FlutterFragment flutterFragment;
  
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
  
  private View createFragmentContainer()
  {
    return null;
  }
  
  /* Error */
  private void ensureFlutterFragmentCreated()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
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
  
  public static CachedEngineIntentBuilder withCachedEngine(String paramString)
  {
    return new CachedEngineIntentBuilder(FlutterFragmentActivity.class, paramString);
  }
  
  public static NewEngineIntentBuilder withNewEngine()
  {
    return new NewEngineIntentBuilder(FlutterFragmentActivity.class);
  }
  
  public void cleanUpFlutterEngine(FlutterEngine paramFlutterEngine) {}
  
  public void configureFlutterEngine(FlutterEngine paramFlutterEngine) {}
  
  protected FlutterFragment createFlutterFragment()
  {
    return null;
  }
  
  protected String getAppBundlePath()
  {
    return null;
  }
  
  protected FlutterActivityLaunchConfigs.BackgroundMode getBackgroundMode()
  {
    return null;
  }
  
  protected String getCachedEngineId()
  {
    return null;
  }
  
  public String getDartEntrypointFunctionName()
  {
    return null;
  }
  
  protected FlutterEngine getFlutterEngine()
  {
    return this.flutterFragment.getFlutterEngine();
  }
  
  protected String getInitialRoute()
  {
    return null;
  }
  
  /* Error */
  protected void onActivityResult(int arg1, int arg2, Intent arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  public void onBackPressed()
  {
    this.flutterFragment.onBackPressed();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    switchLaunchThemeForNormalTheme();
    super.onCreate(paramBundle);
    configureWindowForTransparency();
    setContentView(createFragmentContainer());
    configureStatusBarForFullscreenFlutterExperience();
    ensureFlutterFragmentCreated();
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
  public void onPostResume()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onRequestPermissionsResult(int arg1, String[] arg2, int[] arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
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
    this.flutterFragment.onUserLeaveHint();
  }
  
  public FlutterEngine provideFlutterEngine(Context paramContext)
  {
    return null;
  }
  
  public SplashScreen provideSplashScreen()
  {
    return null;
  }
  
  protected boolean shouldAttachEngineToActivity()
  {
    return true;
  }
  
  public boolean shouldDestroyEngineWithHost()
  {
    return false;
  }
  
  public static class CachedEngineIntentBuilder
  {
    private final Class<? extends FlutterFragmentActivity> activityClass;
    private String backgroundMode = FlutterActivityLaunchConfigs.DEFAULT_BACKGROUND_MODE;
    private final String cachedEngineId;
    private boolean destroyEngineWithActivity = false;
    
    protected CachedEngineIntentBuilder(Class<? extends FlutterFragmentActivity> paramClass, String paramString)
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
    private final Class<? extends FlutterFragmentActivity> activityClass;
    private String backgroundMode = FlutterActivityLaunchConfigs.DEFAULT_BACKGROUND_MODE;
    private String initialRoute = "/";
    
    protected NewEngineIntentBuilder(Class<? extends FlutterFragmentActivity> paramClass)
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\flutter\embedding\android\FlutterFragmentActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */