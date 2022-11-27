package io.flutter.app;

import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import io.flutter.plugin.common.PluginRegistry;
import io.flutter.plugin.common.PluginRegistry.Registrar;
import io.flutter.util.Preconditions;
import io.flutter.view.FlutterNativeView;
import io.flutter.view.FlutterView;
import io.flutter.view.FlutterView.FirstFrameListener;
import io.flutter.view.FlutterView.Provider;
import java.util.ArrayList;

public final class FlutterActivityDelegate
  implements FlutterActivityEvents, FlutterView.Provider, PluginRegistry
{
  private static final String SPLASH_SCREEN_META_DATA_KEY = "io.flutter.app.android.SplashScreenUntilFirstFrame";
  private static final String TAG = "FlutterActivityDelegate";
  private static final WindowManager.LayoutParams matchParent = new WindowManager.LayoutParams(-1, -1);
  private final Activity activity;
  private FlutterView flutterView;
  private View launchView;
  private final ViewFactory viewFactory;
  
  public FlutterActivityDelegate(Activity paramActivity, ViewFactory paramViewFactory)
  {
    this.activity = ((Activity)Preconditions.checkNotNull(paramActivity));
    this.viewFactory = ((ViewFactory)Preconditions.checkNotNull(paramViewFactory));
  }
  
  /* Error */
  private void addLaunchView()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private View createLaunchView()
  {
    return null;
  }
  
  private static String[] getArgsFromIntent(Intent paramIntent)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramIntent.getBooleanExtra("trace-startup", false)) {
      localArrayList.add("--trace-startup");
    }
    if (paramIntent.getBooleanExtra("start-paused", false)) {
      localArrayList.add("--start-paused");
    }
    if (paramIntent.getBooleanExtra("disable-service-auth-codes", false)) {
      localArrayList.add("--disable-service-auth-codes");
    }
    if (paramIntent.getBooleanExtra("use-test-fonts", false)) {
      localArrayList.add("--use-test-fonts");
    }
    if (paramIntent.getBooleanExtra("enable-dart-profiling", false)) {
      localArrayList.add("--enable-dart-profiling");
    }
    if (paramIntent.getBooleanExtra("enable-software-rendering", false)) {
      localArrayList.add("--enable-software-rendering");
    }
    if (paramIntent.getBooleanExtra("skia-deterministic-rendering", false)) {
      localArrayList.add("--skia-deterministic-rendering");
    }
    if (paramIntent.getBooleanExtra("trace-skia", false)) {
      localArrayList.add("--trace-skia");
    }
    if (paramIntent.getBooleanExtra("trace-systrace", false)) {
      localArrayList.add("--trace-systrace");
    }
    if (paramIntent.getBooleanExtra("dump-skp-on-shader-compilation", false)) {
      localArrayList.add("--dump-skp-on-shader-compilation");
    }
    if (paramIntent.getBooleanExtra("cache-sksl", false)) {
      localArrayList.add("--cache-sksl");
    }
    if (paramIntent.getBooleanExtra("verbose-logging", false)) {
      localArrayList.add("--verbose-logging");
    }
    int i = paramIntent.getIntExtra("observatory-port", 0);
    StringBuilder localStringBuilder;
    if (i > 0)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("--observatory-port=");
      localStringBuilder.append(Integer.toString(i));
      localArrayList.add(localStringBuilder.toString());
    }
    if (paramIntent.getBooleanExtra("disable-service-auth-codes", false)) {
      localArrayList.add("--disable-service-auth-codes");
    }
    if (paramIntent.getBooleanExtra("endless-trace-buffer", false)) {
      localArrayList.add("--endless-trace-buffer");
    }
    if (paramIntent.hasExtra("dart-flags"))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("--dart-flags=");
      localStringBuilder.append(paramIntent.getStringExtra("dart-flags"));
      localArrayList.add(localStringBuilder.toString());
    }
    if (!localArrayList.isEmpty()) {
      return (String[])localArrayList.toArray(new String[localArrayList.size()]);
    }
    return null;
  }
  
  private Drawable getLaunchScreenDrawableFromActivityTheme()
  {
    return null;
  }
  
  private boolean isDebuggable()
  {
    return false;
  }
  
  private boolean loadIntent(Intent paramIntent)
  {
    return false;
  }
  
  /* Error */
  private void runBundle(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private Boolean showSplashScreenUntilFirstFrame()
  {
    return null;
  }
  
  public FlutterView getFlutterView()
  {
    return this.flutterView;
  }
  
  public boolean hasPlugin(String paramString)
  {
    return false;
  }
  
  public boolean onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    return false;
  }
  
  public boolean onBackPressed()
  {
    return false;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration) {}
  
  /* Error */
  public void onCreate(android.os.Bundle arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onDestroy()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void onLowMemory()
  {
    this.flutterView.onMemoryPressure();
  }
  
  /* Error */
  public void onNewIntent(Intent arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onPause()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void onPostResume()
  {
    FlutterView localFlutterView = this.flutterView;
    if (localFlutterView != null) {
      localFlutterView.onPostResume();
    }
  }
  
  public boolean onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    return false;
  }
  
  /* Error */
  public void onResume()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void onStart()
  {
    FlutterView localFlutterView = this.flutterView;
    if (localFlutterView != null) {
      localFlutterView.onStart();
    }
  }
  
  public void onStop()
  {
    this.flutterView.onStop();
  }
  
  /* Error */
  public void onTrimMemory(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
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
  
  public PluginRegistry.Registrar registrarFor(String paramString)
  {
    return null;
  }
  
  public <T> T valuePublishedByPlugin(String paramString)
  {
    return null;
  }
  
  public static abstract interface ViewFactory
  {
    public abstract FlutterNativeView createFlutterNativeView();
    
    public abstract FlutterView createFlutterView(Context paramContext);
    
    public abstract boolean retainFlutterNativeView();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\flutter\app\FlutterActivityDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */