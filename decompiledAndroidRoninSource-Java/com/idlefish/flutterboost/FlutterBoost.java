package com.idlefish.flutterboost;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import com.idlefish.flutterboost.interfaces.IContainerManager;
import com.idlefish.flutterboost.interfaces.IFlutterViewContainer;
import com.idlefish.flutterboost.interfaces.INativeRouter;
import io.flutter.embedding.android.FlutterView.RenderMode;
import io.flutter.embedding.engine.FlutterEngine;

public class FlutterBoost
{
  private static boolean sInit;
  static FlutterBoost sInstance;
  private long FlutterPostFrameCallTime = 0L;
  private Application.ActivityLifecycleCallbacks mActivityLifecycleCallbacks;
  private Activity mCurrentActiveActivity;
  private FlutterEngine mEngine;
  private boolean mEnterActivityCreate = false;
  private FlutterViewContainerManager mManager;
  private Platform mPlatform;
  
  private FlutterEngine createEngine()
  {
    return null;
  }
  
  public static FlutterBoost instance()
  {
    if (sInstance == null) {
      sInstance = new FlutterBoost();
    }
    return sInstance;
  }
  
  /* Error */
  private void registerPlugins(FlutterEngine arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void boostDestroy()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public FlutterBoostPlugin channel()
  {
    return FlutterBoostPlugin.singleton();
  }
  
  public IContainerManager containerManager()
  {
    return sInstance.mManager;
  }
  
  public Activity currentActivity()
  {
    return sInstance.mCurrentActiveActivity;
  }
  
  /* Error */
  public void doInitialFlutter()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public FlutterEngine engineProvider()
  {
    return this.mEngine;
  }
  
  public IFlutterViewContainer findContainerById(String paramString)
  {
    return this.mManager.findContainerById(paramString);
  }
  
  public long getFlutterPostFrameCallTime()
  {
    return this.FlutterPostFrameCallTime;
  }
  
  /* Error */
  public void init(Platform arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public Platform platform()
  {
    return sInstance.mPlatform;
  }
  
  public void setFlutterPostFrameCallTime(long paramLong)
  {
    this.FlutterPostFrameCallTime = paramLong;
  }
  
  public static abstract interface BoostLifecycleListener
  {
    public abstract void beforeCreateEngine();
    
    public abstract void onEngineCreated();
    
    public abstract void onEngineDestroy();
    
    public abstract void onPluginsRegistered();
  }
  
  public static class ConfigBuilder
  {
    public static int ANY_ACTIVITY_CREATED = 1;
    public static int APP_EXit = 0;
    public static int All_FLUTTER_ACTIVITY_DESTROY = 1;
    public static final String DEFAULT_DART_ENTRYPOINT = "main";
    public static final String DEFAULT_INITIAL_ROUTE = "/";
    public static int FLUTTER_ACTIVITY_CREATED = 2;
    public static int IMMEDIATELY;
    private String dartEntrypoint = "main";
    private String initialRoute = "/";
    private boolean isDebug = false;
    private FlutterBoost.BoostLifecycleListener lifecycleListener;
    private Application mApp;
    private FlutterView.RenderMode renderMode = FlutterView.RenderMode.texture;
    private INativeRouter router = null;
    private int whenEngineDestory = APP_EXit;
    private int whenEngineStart = ANY_ACTIVITY_CREATED;
    
    public ConfigBuilder(Application paramApplication, INativeRouter paramINativeRouter)
    {
      this.router = paramINativeRouter;
      this.mApp = paramApplication;
    }
    
    public Platform build()
    {
      return null;
    }
    
    public ConfigBuilder dartEntrypoint(String paramString)
    {
      this.dartEntrypoint = paramString;
      return this;
    }
    
    public ConfigBuilder initialRoute(String paramString)
    {
      this.initialRoute = paramString;
      return this;
    }
    
    public ConfigBuilder isDebug(boolean paramBoolean)
    {
      this.isDebug = paramBoolean;
      return this;
    }
    
    public ConfigBuilder lifecycleListener(FlutterBoost.BoostLifecycleListener paramBoostLifecycleListener)
    {
      this.lifecycleListener = paramBoostLifecycleListener;
      return this;
    }
    
    public ConfigBuilder renderMode(FlutterView.RenderMode paramRenderMode)
    {
      this.renderMode = paramRenderMode;
      return this;
    }
    
    public ConfigBuilder whenEngineStart(int paramInt)
    {
      this.whenEngineStart = paramInt;
      return this;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\idlefish\flutterboost\FlutterBoost.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */