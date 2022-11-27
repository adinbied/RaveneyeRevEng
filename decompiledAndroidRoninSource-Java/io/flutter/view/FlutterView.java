package io.flutter.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.os.Build.VERSION;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import io.flutter.app.FlutterPluginRegistry;
import io.flutter.embedding.android.AndroidKeyProcessor;
import io.flutter.embedding.android.AndroidTouchProcessor;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.embedding.engine.systemchannels.KeyEventChannel;
import io.flutter.embedding.engine.systemchannels.LifecycleChannel;
import io.flutter.embedding.engine.systemchannels.LocalizationChannel;
import io.flutter.embedding.engine.systemchannels.NavigationChannel;
import io.flutter.embedding.engine.systemchannels.PlatformChannel;
import io.flutter.embedding.engine.systemchannels.SettingsChannel;
import io.flutter.embedding.engine.systemchannels.SystemChannel;
import io.flutter.plugin.common.ActivityLifecycleListener;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.BinaryMessenger.BinaryMessageHandler;
import io.flutter.plugin.editing.TextInputPlugin;
import io.flutter.plugin.platform.PlatformPlugin;
import io.flutter.plugin.platform.PlatformViewsController;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class FlutterView
  extends SurfaceView
  implements BinaryMessenger, TextureRegistry
{
  private static final String TAG = "FlutterView";
  private final AndroidKeyProcessor androidKeyProcessor;
  private final AndroidTouchProcessor androidTouchProcessor;
  private final DartExecutor dartExecutor;
  private boolean didRenderFirstFrame = false;
  private final FlutterRenderer flutterRenderer;
  private final KeyEventChannel keyEventChannel;
  private final LifecycleChannel lifecycleChannel;
  private final LocalizationChannel localizationChannel;
  private AccessibilityBridge mAccessibilityNodeProvider;
  private final List<ActivityLifecycleListener> mActivityLifecycleListeners;
  private final List<FirstFrameListener> mFirstFrameListeners;
  private final InputMethodManager mImm;
  private boolean mIsSoftwareRenderingEnabled = false;
  private final ViewportMetrics mMetrics;
  private FlutterNativeView mNativeView;
  private final SurfaceHolder.Callback mSurfaceCallback;
  private final TextInputPlugin mTextInputPlugin;
  private final NavigationChannel navigationChannel;
  private final AtomicLong nextTextureId = new AtomicLong(0L);
  private final AccessibilityBridge.OnAccessibilityChangeListener onAccessibilityChangeListener = new AccessibilityBridge.OnAccessibilityChangeListener()
  {
    public void onAccessibilityChanged(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
    {
      FlutterView.this.resetWillNotDraw(paramAnonymousBoolean1, paramAnonymousBoolean2);
    }
  };
  private final PlatformChannel platformChannel;
  private final SettingsChannel settingsChannel;
  private final SystemChannel systemChannel;
  
  public FlutterView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FlutterView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, null);
  }
  
  public FlutterView(Context paramContext, AttributeSet paramAttributeSet, FlutterNativeView paramFlutterNativeView)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = getActivity(getContext());
    if (paramAttributeSet != null)
    {
      if (paramFlutterNativeView == null) {
        this.mNativeView = new FlutterNativeView(paramAttributeSet.getApplicationContext());
      } else {
        this.mNativeView = paramFlutterNativeView;
      }
      this.dartExecutor = this.mNativeView.getDartExecutor();
      this.flutterRenderer = new FlutterRenderer(this.mNativeView.getFlutterJNI());
      this.mIsSoftwareRenderingEnabled = this.mNativeView.getFlutterJNI().nativeGetIsSoftwareRenderingEnabled();
      paramFlutterNativeView = new ViewportMetrics();
      this.mMetrics = paramFlutterNativeView;
      paramFlutterNativeView.devicePixelRatio = paramContext.getResources().getDisplayMetrics().density;
      setFocusable(true);
      setFocusableInTouchMode(true);
      this.mNativeView.attachViewAndActivity(this, paramAttributeSet);
      this.mSurfaceCallback = new SurfaceHolder.Callback()
      {
        public void surfaceChanged(SurfaceHolder paramAnonymousSurfaceHolder, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          FlutterView.this.assertAttached();
          FlutterView.this.mNativeView.getFlutterJNI().onSurfaceChanged(paramAnonymousInt2, paramAnonymousInt3);
        }
        
        /* Error */
        public void surfaceCreated(SurfaceHolder arg1)
        {
          // Byte code:
          //   0: return
          //   1: astore_1
          //   2: goto -2 -> 0
        }
        
        public void surfaceDestroyed(SurfaceHolder paramAnonymousSurfaceHolder)
        {
          FlutterView.this.assertAttached();
          FlutterView.this.mNativeView.getFlutterJNI().onSurfaceDestroyed();
        }
      };
      getHolder().addCallback(this.mSurfaceCallback);
      this.mActivityLifecycleListeners = new ArrayList();
      this.mFirstFrameListeners = new ArrayList();
      this.navigationChannel = new NavigationChannel(this.dartExecutor);
      this.keyEventChannel = new KeyEventChannel(this.dartExecutor);
      this.lifecycleChannel = new LifecycleChannel(this.dartExecutor);
      this.localizationChannel = new LocalizationChannel(this.dartExecutor);
      this.platformChannel = new PlatformChannel(this.dartExecutor);
      this.systemChannel = new SystemChannel(this.dartExecutor);
      this.settingsChannel = new SettingsChannel(this.dartExecutor);
      addActivityLifecycleListener(new ActivityLifecycleListener()
      {
        public void onPostResume()
        {
          this.val$platformPlugin.updateSystemUiOverlays();
        }
      });
      this.mImm = ((InputMethodManager)getContext().getSystemService("input_method"));
      paramContext = this.mNativeView.getPluginRegistry().getPlatformViewsController();
      paramContext = new TextInputPlugin(this, this.dartExecutor, paramContext);
      this.mTextInputPlugin = paramContext;
      this.androidKeyProcessor = new AndroidKeyProcessor(this.keyEventChannel, paramContext);
      this.androidTouchProcessor = new AndroidTouchProcessor(this.flutterRenderer);
      this.mNativeView.getPluginRegistry().getPlatformViewsController().attachTextInputPlugin(this.mTextInputPlugin);
      sendLocalesToDart(getResources().getConfiguration());
      sendUserPlatformSettingsToDart();
      return;
    }
    throw new IllegalArgumentException("Bad context");
  }
  
  private static Activity getActivity(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    if ((paramContext instanceof Activity)) {
      return (Activity)paramContext;
    }
    if ((paramContext instanceof ContextWrapper)) {
      return getActivity(((ContextWrapper)paramContext).getBaseContext());
    }
    return null;
  }
  
  private boolean isAttached()
  {
    return false;
  }
  
  private void postRun() {}
  
  private void preRun()
  {
    resetAccessibilityTree();
  }
  
  /* Error */
  private void resetWillNotDraw(boolean arg1, boolean arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void sendLocalesToDart(Configuration arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void sendUserPlatformSettingsToDart()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void updateViewportMetrics()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void addActivityLifecycleListener(ActivityLifecycleListener paramActivityLifecycleListener)
  {
    this.mActivityLifecycleListeners.add(paramActivityLifecycleListener);
  }
  
  public void addFirstFrameListener(FirstFrameListener paramFirstFrameListener)
  {
    this.mFirstFrameListeners.add(paramFirstFrameListener);
  }
  
  /* Error */
  void assertAttached()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  int calculateBottomKeyboardInset(WindowInsets paramWindowInsets)
  {
    return 0;
  }
  
  ZeroSides calculateShouldZeroSides()
  {
    return null;
  }
  
  public boolean checkInputConnectionProxy(View paramView)
  {
    return false;
  }
  
  public TextureRegistry.SurfaceTextureEntry createSurfaceTexture()
  {
    return null;
  }
  
  /* Error */
  public void destroy()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public FlutterNativeView detach()
  {
    return null;
  }
  
  /* Error */
  public void disableTransparentBackground()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Deprecated
  public void enableTransparentBackground()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected boolean fitSystemWindows(Rect paramRect)
  {
    return false;
  }
  
  public AccessibilityNodeProvider getAccessibilityNodeProvider()
  {
    return null;
  }
  
  public Bitmap getBitmap()
  {
    return null;
  }
  
  public DartExecutor getDartExecutor()
  {
    return this.dartExecutor;
  }
  
  float getDevicePixelRatio()
  {
    return this.mMetrics.devicePixelRatio;
  }
  
  public FlutterNativeView getFlutterNativeView()
  {
    return this.mNativeView;
  }
  
  public String getLookupKeyForAsset(String paramString)
  {
    return FlutterMain.getLookupKeyForAsset(paramString);
  }
  
  public String getLookupKeyForAsset(String paramString1, String paramString2)
  {
    return FlutterMain.getLookupKeyForAsset(paramString1, paramString2);
  }
  
  public FlutterPluginRegistry getPluginRegistry()
  {
    return this.mNativeView.getPluginRegistry();
  }
  
  public boolean hasRenderedFirstFrame()
  {
    return this.didRenderFirstFrame;
  }
  
  public final WindowInsets onApplyWindowInsets(WindowInsets paramWindowInsets)
  {
    return null;
  }
  
  /* Error */
  protected void onAttachedToWindow()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    sendLocalesToDart(paramConfiguration);
    sendUserPlatformSettingsToDart();
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    return this.mTextInputPlugin.createInputConnection(this, paramEditorInfo);
  }
  
  /* Error */
  protected void onDetachedFromWindow()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onFirstFrame()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean onGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onHoverEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  public void onMemoryPressure()
  {
    this.systemChannel.sendMemoryPressureWarning();
  }
  
  public void onPause()
  {
    this.lifecycleChannel.appIsInactive();
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
  protected void onSizeChanged(int arg1, int arg2, int arg3, int arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore 5
    //   3: goto -3 -> 0
  }
  
  public void onStart()
  {
    this.lifecycleChannel.appIsInactive();
  }
  
  public void onStop()
  {
    this.lifecycleChannel.appIsPaused();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void popRoute()
  {
    this.navigationChannel.popRoute();
  }
  
  public void pushRoute(String paramString)
  {
    this.navigationChannel.pushRoute(paramString);
  }
  
  public void removeFirstFrameListener(FirstFrameListener paramFirstFrameListener)
  {
    this.mFirstFrameListeners.remove(paramFirstFrameListener);
  }
  
  void resetAccessibilityTree()
  {
    AccessibilityBridge localAccessibilityBridge = this.mAccessibilityNodeProvider;
    if (localAccessibilityBridge != null) {
      localAccessibilityBridge.reset();
    }
  }
  
  /* Error */
  public void runFromBundle(FlutterRunArguments arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void send(String paramString, ByteBuffer paramByteBuffer)
  {
    send(paramString, paramByteBuffer, null);
  }
  
  /* Error */
  public void send(String arg1, ByteBuffer arg2, io.flutter.plugin.common.BinaryMessenger.BinaryReply arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void setInitialRoute(String paramString)
  {
    this.navigationChannel.setInitialRoute(paramString);
  }
  
  public void setMessageHandler(String paramString, BinaryMessenger.BinaryMessageHandler paramBinaryMessageHandler)
  {
    this.mNativeView.setMessageHandler(paramString, paramBinaryMessageHandler);
  }
  
  public static abstract interface FirstFrameListener
  {
    public abstract void onFirstFrame();
  }
  
  public static abstract interface Provider
  {
    public abstract FlutterView getFlutterView();
  }
  
  final class SurfaceTextureRegistryEntry
    implements TextureRegistry.SurfaceTextureEntry
  {
    private final long id;
    private SurfaceTexture.OnFrameAvailableListener onFrameListener = new SurfaceTexture.OnFrameAvailableListener()
    {
      /* Error */
      public void onFrameAvailable(SurfaceTexture arg1)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: goto -2 -> 0
      }
    };
    private boolean released;
    private final SurfaceTexture surfaceTexture;
    
    SurfaceTextureRegistryEntry(long paramLong, SurfaceTexture paramSurfaceTexture)
    {
      this.id = paramLong;
      this.surfaceTexture = paramSurfaceTexture;
      if (Build.VERSION.SDK_INT >= 21)
      {
        this.surfaceTexture.setOnFrameAvailableListener(this.onFrameListener, new Handler());
        return;
      }
      this.surfaceTexture.setOnFrameAvailableListener(this.onFrameListener);
    }
    
    public long id()
    {
      return this.id;
    }
    
    /* Error */
    public void release()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public SurfaceTexture surfaceTexture()
    {
      return this.surfaceTexture;
    }
  }
  
  static final class ViewportMetrics
  {
    float devicePixelRatio = 1.0F;
    int physicalHeight = 0;
    int physicalPaddingBottom = 0;
    int physicalPaddingLeft = 0;
    int physicalPaddingRight = 0;
    int physicalPaddingTop = 0;
    int physicalViewInsetBottom = 0;
    int physicalViewInsetLeft = 0;
    int physicalViewInsetRight = 0;
    int physicalViewInsetTop = 0;
    int physicalWidth = 0;
    int systemGestureInsetBottom = 0;
    int systemGestureInsetLeft = 0;
    int systemGestureInsetRight = 0;
    int systemGestureInsetTop = 0;
  }
  
  static enum ZeroSides
  {
    static
    {
      LEFT = new ZeroSides("LEFT", 1);
      RIGHT = new ZeroSides("RIGHT", 2);
      ZeroSides localZeroSides = new ZeroSides("BOTH", 3);
      BOTH = localZeroSides;
      $VALUES = new ZeroSides[] { NONE, LEFT, RIGHT, localZeroSides };
    }
    
    private ZeroSides() {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\flutter\view\FlutterView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */