package io.flutter.embedding.android;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterShellArgs;
import io.flutter.embedding.engine.renderer.FlutterUiDisplayListener;
import io.flutter.plugin.platform.PlatformPlugin;

final class FlutterActivityAndFragmentDelegate
{
  private static final String TAG = "FlutterActivityAndFragmentDelegate";
  private FlutterEngine flutterEngine;
  private FlutterSplashView flutterSplashView;
  private final FlutterUiDisplayListener flutterUiDisplayListener = new FlutterUiDisplayListener()
  {
    /* Error */
    public void onFlutterUiDisplayed()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void onFlutterUiNoLongerDisplayed()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  };
  private FlutterView flutterView;
  private Host host;
  private boolean isFlutterEngineFromHost;
  private PlatformPlugin platformPlugin;
  
  FlutterActivityAndFragmentDelegate(Host paramHost)
  {
    this.host = paramHost;
  }
  
  /* Error */
  private void doInitialFlutterViewRun()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void ensureAlive()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  FlutterEngine getFlutterEngine()
  {
    return this.flutterEngine;
  }
  
  boolean isFlutterEngineFromHost()
  {
    return this.isFlutterEngineFromHost;
  }
  
  /* Error */
  void onActivityCreated(Bundle arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  void onActivityResult(int arg1, int arg2, android.content.Intent arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  /* Error */
  void onAttach(Context arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  void onBackPressed()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return null;
  }
  
  /* Error */
  void onDestroyView()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  void onDetach()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  void onLowMemory()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  void onNewIntent(android.content.Intent arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  void onPause()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  void onPostResume()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  void onRequestPermissionsResult(int arg1, String[] arg2, int[] arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  void onResume()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  void onSaveInstanceState(Bundle arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  void onStart()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  void onStop()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  void onTrimMemory(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
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
  
  /* Error */
  void release()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  void setupFlutterEngine()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static abstract interface Host
    extends SplashScreenProvider, FlutterEngineProvider, FlutterEngineConfigurator
  {
    public abstract void cleanUpFlutterEngine(FlutterEngine paramFlutterEngine);
    
    public abstract void configureFlutterEngine(FlutterEngine paramFlutterEngine);
    
    public abstract Activity getActivity();
    
    public abstract String getAppBundlePath();
    
    public abstract String getCachedEngineId();
    
    public abstract Context getContext();
    
    public abstract String getDartEntrypointFunctionName();
    
    public abstract FlutterShellArgs getFlutterShellArgs();
    
    public abstract String getInitialRoute();
    
    public abstract Lifecycle getLifecycle();
    
    public abstract RenderMode getRenderMode();
    
    public abstract TransparencyMode getTransparencyMode();
    
    public abstract void onFlutterSurfaceViewCreated(FlutterSurfaceView paramFlutterSurfaceView);
    
    public abstract void onFlutterTextureViewCreated(FlutterTextureView paramFlutterTextureView);
    
    public abstract void onFlutterUiDisplayed();
    
    public abstract void onFlutterUiNoLongerDisplayed();
    
    public abstract FlutterEngine provideFlutterEngine(Context paramContext);
    
    public abstract PlatformPlugin providePlatformPlugin(Activity paramActivity, FlutterEngine paramFlutterEngine);
    
    public abstract SplashScreen provideSplashScreen();
    
    public abstract boolean shouldAttachEngineToActivity();
    
    public abstract boolean shouldDestroyEngineWithHost();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\flutter\embedding\android\FlutterActivityAndFragmentDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */