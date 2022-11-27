package com.idlefish.flutterboost.containers;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import com.idlefish.flutterboost.XFlutterView;
import com.idlefish.flutterboost.XPlatformPlugin;
import com.idlefish.flutterboost.interfaces.IFlutterViewContainer;
import com.idlefish.flutterboost.interfaces.IOperateSyncer;
import io.flutter.embedding.android.FlutterEngineConfigurator;
import io.flutter.embedding.android.FlutterEngineProvider;
import io.flutter.embedding.android.FlutterView.RenderMode;
import io.flutter.embedding.android.FlutterView.TransparencyMode;
import io.flutter.embedding.android.SplashScreen;
import io.flutter.embedding.android.SplashScreenProvider;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterShellArgs;
import java.util.Map;

public class FlutterActivityAndFragmentDelegate
  implements IFlutterViewContainer
{
  private static int ACTIVITY_CONTROL_SURFACE_ATTACH_TO_ACTVITY_HASH_CODE = 0;
  private static final String TAG = "FlutterActivityAndFragmentDelegate";
  private FlutterEngine flutterEngine;
  private FlutterSplashView flutterSplashView;
  private XFlutterView flutterView;
  private Host host;
  private boolean isFlutterEngineFromHost;
  protected IOperateSyncer mSyncer;
  private XPlatformPlugin platformPlugin;
  
  public FlutterActivityAndFragmentDelegate(Host paramHost)
  {
    this.host = paramHost;
  }
  
  /* Error */
  private void ensureAlive()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void setupFlutterEngine()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void finishContainer(Map<String, Object> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public FlutterSplashView getBoostFlutterView()
  {
    return this.flutterSplashView;
  }
  
  public String getContainerUrl()
  {
    return this.host.getContainerUrl();
  }
  
  public Map<String, Object> getContainerUrlParams()
  {
    return this.host.getContainerUrlParams();
  }
  
  public Activity getContextActivity()
  {
    return this.host.getActivity();
  }
  
  public FlutterEngine getFlutterEngine()
  {
    return this.flutterEngine;
  }
  
  public XFlutterView getFlutterView()
  {
    return this.flutterView;
  }
  
  /* Error */
  public void onActivityResult(int arg1, int arg2, android.content.Intent arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onAttach(Context arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onBackPressed()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void onContainerHidden() {}
  
  public void onContainerShown() {}
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return null;
  }
  
  /* Error */
  public void onDestroyView()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onDetach()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onLowMemory()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onNewIntent(android.content.Intent arg1)
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
  public void onResume()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onStart()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onStop()
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
  
  /* Error */
  public void onUserLeaveHint()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void release()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setBoostResult(Activity arg1, java.util.HashMap arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static abstract interface Host
    extends SplashScreenProvider, FlutterEngineProvider, FlutterEngineConfigurator
  {
    public abstract void configureFlutterEngine(FlutterEngine paramFlutterEngine);
    
    public abstract Activity getActivity();
    
    public abstract String getContainerUrl();
    
    public abstract Map<String, Object> getContainerUrlParams();
    
    public abstract Context getContext();
    
    public abstract FlutterShellArgs getFlutterShellArgs();
    
    public abstract Lifecycle getLifecycle();
    
    public abstract FlutterView.RenderMode getRenderMode();
    
    public abstract FlutterView.TransparencyMode getTransparencyMode();
    
    public abstract FlutterEngine provideFlutterEngine(Context paramContext);
    
    public abstract XPlatformPlugin providePlatformPlugin(FlutterEngine paramFlutterEngine);
    
    public abstract SplashScreen provideSplashScreen();
    
    public abstract boolean shouldAttachEngineToActivity();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\idlefish\flutterboost\containers\FlutterActivityAndFragmentDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */