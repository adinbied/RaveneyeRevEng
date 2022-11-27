package com.idlefish.flutterboost.containers;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.idlefish.flutterboost.FlutterBoost;
import com.idlefish.flutterboost.XFlutterView;
import com.idlefish.flutterboost.XPlatformPlugin;
import io.flutter.embedding.android.FlutterView.RenderMode;
import io.flutter.embedding.android.FlutterView.TransparencyMode;
import io.flutter.embedding.android.SplashScreen;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterShellArgs;
import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;

public class FlutterFragment
  extends Fragment
  implements FlutterActivityAndFragmentDelegate.Host
{
  protected static final String ARG_APP_BUNDLE_PATH = "app_bundle_path";
  protected static final String ARG_CACHED_ENGINE_ID = "cached_engine_id";
  protected static final String ARG_DART_ENTRYPOINT = "dart_entrypoint";
  protected static final String ARG_DESTROY_ENGINE_WITH_FRAGMENT = "destroy_engine_with_fragment";
  protected static final String ARG_FLUTTERVIEW_RENDER_MODE = "flutterview_render_mode";
  protected static final String ARG_FLUTTERVIEW_TRANSPARENCY_MODE = "flutterview_transparency_mode";
  protected static final String ARG_FLUTTER_INITIALIZATION_ARGS = "initialization_args";
  protected static final String ARG_INITIAL_ROUTE = "initial_route";
  protected static final String ARG_SHOULD_ATTACH_ENGINE_TO_ACTIVITY = "should_attach_engine_to_activity";
  protected static final String EXTRA_PARAMS = "params";
  protected static final String EXTRA_URL = "url";
  private static final String TAG = "NewFlutterFragment";
  private FlutterActivityAndFragmentDelegate delegate;
  
  public FlutterFragment()
  {
    setArguments(new Bundle());
  }
  
  public static FlutterFragment createDefault()
  {
    return new NewEngineFragmentBuilder().build();
  }
  
  private Context getContextCompat()
  {
    return null;
  }
  
  public static NewEngineFragmentBuilder withNewEngine()
  {
    return new NewEngineFragmentBuilder();
  }
  
  public void cleanUpFlutterEngine(FlutterEngine paramFlutterEngine) {}
  
  /* Error */
  public void configureFlutterEngine(FlutterEngine arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public String getContainerUrl()
  {
    return null;
  }
  
  public Map<String, Object> getContainerUrlParams()
  {
    return null;
  }
  
  public FlutterEngine getFlutterEngine()
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
  
  public FlutterView.RenderMode getRenderMode()
  {
    return null;
  }
  
  public FlutterView.TransparencyMode getTransparencyMode()
  {
    return null;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.delegate.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  /* Error */
  public void onAttach(Context arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void onBackPressed()
  {
    this.delegate.onBackPressed();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return this.delegate.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
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
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    if (paramBoolean)
    {
      this.delegate.onPause();
      return;
    }
    this.delegate.onResume();
  }
  
  /* Error */
  public void onLowMemory()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    this.delegate.onNewIntent(paramIntent);
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
    this.delegate.onPostResume();
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.delegate.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
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
  
  public void onTrimMemory(int paramInt)
  {
    this.delegate.onTrimMemory(paramInt);
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
  
  static @interface ActivityCallThrough {}
  
  public static class NewEngineFragmentBuilder
  {
    private final Class<? extends FlutterFragment> fragmentClass;
    private Map params = new HashMap();
    private FlutterView.RenderMode renderMode = FlutterView.RenderMode.surface;
    private FlutterShellArgs shellArgs = null;
    private boolean shouldAttachEngineToActivity = true;
    private FlutterView.TransparencyMode transparencyMode = FlutterView.TransparencyMode.transparent;
    private String url = "";
    
    public NewEngineFragmentBuilder()
    {
      this.fragmentClass = FlutterFragment.class;
    }
    
    public NewEngineFragmentBuilder(Class<? extends FlutterFragment> paramClass)
    {
      this.fragmentClass = paramClass;
    }
    
    public <T extends FlutterFragment> T build()
    {
      return null;
    }
    
    protected Bundle createArgs()
    {
      return null;
    }
    
    public NewEngineFragmentBuilder flutterShellArgs(FlutterShellArgs paramFlutterShellArgs)
    {
      this.shellArgs = paramFlutterShellArgs;
      return this;
    }
    
    public NewEngineFragmentBuilder params(Map paramMap)
    {
      this.params = paramMap;
      return this;
    }
    
    public NewEngineFragmentBuilder renderMode(FlutterView.RenderMode paramRenderMode)
    {
      this.renderMode = paramRenderMode;
      return this;
    }
    
    public NewEngineFragmentBuilder transparencyMode(FlutterView.TransparencyMode paramTransparencyMode)
    {
      this.transparencyMode = paramTransparencyMode;
      return this;
    }
    
    public NewEngineFragmentBuilder url(String paramString)
    {
      this.url = paramString;
      return this;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\idlefish\flutterboost\containers\FlutterFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */