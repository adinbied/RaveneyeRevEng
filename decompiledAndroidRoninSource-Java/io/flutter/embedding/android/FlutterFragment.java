package io.flutter.embedding.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterShellArgs;
import io.flutter.plugin.platform.PlatformPlugin;
import java.lang.annotation.Annotation;

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
  private static final String TAG = "FlutterFragment";
  FlutterActivityAndFragmentDelegate delegate;
  
  public FlutterFragment()
  {
    setArguments(new Bundle());
  }
  
  public static FlutterFragment createDefault()
  {
    return new NewEngineFragmentBuilder().build();
  }
  
  public static CachedEngineFragmentBuilder withCachedEngine(String paramString)
  {
    return new CachedEngineFragmentBuilder(paramString, null);
  }
  
  public static NewEngineFragmentBuilder withNewEngine()
  {
    return new NewEngineFragmentBuilder();
  }
  
  /* Error */
  public void cleanUpFlutterEngine(FlutterEngine arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void configureFlutterEngine(FlutterEngine arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public String getAppBundlePath()
  {
    return null;
  }
  
  public String getCachedEngineId()
  {
    return null;
  }
  
  public String getDartEntrypointFunctionName()
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
  
  public String getInitialRoute()
  {
    return null;
  }
  
  public RenderMode getRenderMode()
  {
    return null;
  }
  
  public TransparencyMode getTransparencyMode()
  {
    return null;
  }
  
  /* Error */
  public void onActivityCreated(Bundle arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
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
  
  /* Error */
  public void onFlutterUiNoLongerDisplayed()
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
  public void onSaveInstanceState(Bundle arg1)
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
    return false;
  }
  
  public boolean shouldDestroyEngineWithHost()
  {
    return false;
  }
  
  static @interface ActivityCallThrough {}
  
  public static class CachedEngineFragmentBuilder
  {
    private boolean destroyEngineWithFragment = false;
    private final String engineId;
    private final Class<? extends FlutterFragment> fragmentClass;
    private RenderMode renderMode = RenderMode.surface;
    private boolean shouldAttachEngineToActivity = true;
    private TransparencyMode transparencyMode = TransparencyMode.transparent;
    
    protected CachedEngineFragmentBuilder(Class<? extends FlutterFragment> paramClass, String paramString)
    {
      this.fragmentClass = paramClass;
      this.engineId = paramString;
    }
    
    private CachedEngineFragmentBuilder(String paramString)
    {
      this(FlutterFragment.class, paramString);
    }
    
    public <T extends FlutterFragment> T build()
    {
      return null;
    }
    
    protected Bundle createArgs()
    {
      return null;
    }
    
    public CachedEngineFragmentBuilder destroyEngineWithFragment(boolean paramBoolean)
    {
      this.destroyEngineWithFragment = paramBoolean;
      return this;
    }
    
    public CachedEngineFragmentBuilder renderMode(RenderMode paramRenderMode)
    {
      this.renderMode = paramRenderMode;
      return this;
    }
    
    public CachedEngineFragmentBuilder shouldAttachEngineToActivity(boolean paramBoolean)
    {
      this.shouldAttachEngineToActivity = paramBoolean;
      return this;
    }
    
    public CachedEngineFragmentBuilder transparencyMode(TransparencyMode paramTransparencyMode)
    {
      this.transparencyMode = paramTransparencyMode;
      return this;
    }
  }
  
  public static class NewEngineFragmentBuilder
  {
    private String appBundlePath = null;
    private String dartEntrypoint = "main";
    private final Class<? extends FlutterFragment> fragmentClass;
    private String initialRoute = "/";
    private RenderMode renderMode = RenderMode.surface;
    private FlutterShellArgs shellArgs = null;
    private boolean shouldAttachEngineToActivity = true;
    private TransparencyMode transparencyMode = TransparencyMode.transparent;
    
    public NewEngineFragmentBuilder()
    {
      this.fragmentClass = FlutterFragment.class;
    }
    
    public NewEngineFragmentBuilder(Class<? extends FlutterFragment> paramClass)
    {
      this.fragmentClass = paramClass;
    }
    
    public NewEngineFragmentBuilder appBundlePath(String paramString)
    {
      this.appBundlePath = paramString;
      return this;
    }
    
    public <T extends FlutterFragment> T build()
    {
      return null;
    }
    
    protected Bundle createArgs()
    {
      return null;
    }
    
    public NewEngineFragmentBuilder dartEntrypoint(String paramString)
    {
      this.dartEntrypoint = paramString;
      return this;
    }
    
    public NewEngineFragmentBuilder flutterShellArgs(FlutterShellArgs paramFlutterShellArgs)
    {
      this.shellArgs = paramFlutterShellArgs;
      return this;
    }
    
    public NewEngineFragmentBuilder initialRoute(String paramString)
    {
      this.initialRoute = paramString;
      return this;
    }
    
    public NewEngineFragmentBuilder renderMode(RenderMode paramRenderMode)
    {
      this.renderMode = paramRenderMode;
      return this;
    }
    
    public NewEngineFragmentBuilder shouldAttachEngineToActivity(boolean paramBoolean)
    {
      this.shouldAttachEngineToActivity = paramBoolean;
      return this;
    }
    
    public NewEngineFragmentBuilder transparencyMode(TransparencyMode paramTransparencyMode)
    {
      this.transparencyMode = paramTransparencyMode;
      return this;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\flutter\embedding\android\FlutterFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */