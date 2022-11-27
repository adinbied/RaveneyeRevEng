package io.flutter.embedding.android;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.FrameLayout;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.renderer.FlutterRenderer.ViewportMetrics;
import io.flutter.embedding.engine.renderer.FlutterUiDisplayListener;
import io.flutter.embedding.engine.renderer.RenderSurface;
import io.flutter.plugin.editing.TextInputPlugin;
import io.flutter.view.AccessibilityBridge;
import io.flutter.view.AccessibilityBridge.OnAccessibilityChangeListener;
import java.util.HashSet;
import java.util.Set;

public class FlutterView
  extends FrameLayout
{
  private static final String TAG = "FlutterView";
  private AccessibilityBridge accessibilityBridge;
  private AndroidKeyProcessor androidKeyProcessor;
  private AndroidTouchProcessor androidTouchProcessor;
  private FlutterEngine flutterEngine;
  private final Set<FlutterEngineAttachmentListener> flutterEngineAttachmentListeners = new HashSet();
  private FlutterSurfaceView flutterSurfaceView;
  private FlutterTextureView flutterTextureView;
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
  private final Set<FlutterUiDisplayListener> flutterUiDisplayListeners = new HashSet();
  private boolean isFlutterUiDisplayed;
  private final AccessibilityBridge.OnAccessibilityChangeListener onAccessibilityChangeListener = new AccessibilityBridge.OnAccessibilityChangeListener()
  {
    public void onAccessibilityChanged(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
    {
      FlutterView.this.resetWillNotDraw(paramAnonymousBoolean1, paramAnonymousBoolean2);
    }
  };
  private RenderSurface renderSurface;
  private TextInputPlugin textInputPlugin;
  private final FlutterRenderer.ViewportMetrics viewportMetrics = new FlutterRenderer.ViewportMetrics();
  
  public FlutterView(Context paramContext)
  {
    this(paramContext, null, new FlutterSurfaceView(paramContext));
  }
  
  public FlutterView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, new FlutterSurfaceView(paramContext));
  }
  
  private FlutterView(Context paramContext, AttributeSet paramAttributeSet, FlutterSurfaceView paramFlutterSurfaceView)
  {
    super(paramContext, paramAttributeSet);
    this.flutterSurfaceView = paramFlutterSurfaceView;
    this.renderSurface = paramFlutterSurfaceView;
    init();
  }
  
  private FlutterView(Context paramContext, AttributeSet paramAttributeSet, FlutterTextureView paramFlutterTextureView)
  {
    super(paramContext, paramAttributeSet);
    this.flutterTextureView = paramFlutterTextureView;
    this.renderSurface = this.flutterSurfaceView;
    init();
  }
  
  public FlutterView(Context paramContext, FlutterSurfaceView paramFlutterSurfaceView)
  {
    this(paramContext, null, paramFlutterSurfaceView);
  }
  
  public FlutterView(Context paramContext, FlutterTextureView paramFlutterTextureView)
  {
    this(paramContext, null, paramFlutterTextureView);
  }
  
  @Deprecated
  public FlutterView(Context paramContext, RenderMode paramRenderMode)
  {
    super(paramContext, null);
    if (paramRenderMode == RenderMode.surface)
    {
      paramContext = new FlutterSurfaceView(paramContext);
      this.flutterSurfaceView = paramContext;
      this.renderSurface = paramContext;
    }
    else
    {
      paramContext = new FlutterTextureView(paramContext);
      this.flutterTextureView = paramContext;
      this.renderSurface = paramContext;
    }
    init();
  }
  
  @Deprecated
  public FlutterView(Context paramContext, RenderMode paramRenderMode, TransparencyMode paramTransparencyMode)
  {
    super(paramContext, null);
    if (paramRenderMode == RenderMode.surface)
    {
      boolean bool;
      if (paramTransparencyMode == TransparencyMode.transparent) {
        bool = true;
      } else {
        bool = false;
      }
      paramContext = new FlutterSurfaceView(paramContext, bool);
      this.flutterSurfaceView = paramContext;
      this.renderSurface = paramContext;
    }
    else
    {
      paramContext = new FlutterTextureView(paramContext);
      this.flutterTextureView = paramContext;
      this.renderSurface = paramContext;
    }
    init();
  }
  
  @Deprecated
  public FlutterView(Context paramContext, TransparencyMode paramTransparencyMode)
  {
    this(paramContext, null, new FlutterSurfaceView(paramContext, bool));
  }
  
  /* Error */
  private void init()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
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
  private void sendLocalesToFlutter(android.content.res.Configuration arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void sendViewportMetricsToFlutter()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void addFlutterEngineAttachmentListener(FlutterEngineAttachmentListener paramFlutterEngineAttachmentListener)
  {
    this.flutterEngineAttachmentListeners.add(paramFlutterEngineAttachmentListener);
  }
  
  public void addOnFirstFrameRenderedListener(FlutterUiDisplayListener paramFlutterUiDisplayListener)
  {
    this.flutterUiDisplayListeners.add(paramFlutterUiDisplayListener);
  }
  
  /* Error */
  public void attachToFlutterEngine(FlutterEngine arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean checkInputConnectionProxy(View paramView)
  {
    return false;
  }
  
  /* Error */
  public void detachFromFlutterEngine()
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
  
  public FlutterEngine getAttachedFlutterEngine()
  {
    return this.flutterEngine;
  }
  
  public boolean hasRenderedFirstFrame()
  {
    return this.isFlutterUiDisplayed;
  }
  
  public boolean isAttachedToFlutterEngine()
  {
    return false;
  }
  
  public final WindowInsets onApplyWindowInsets(WindowInsets paramWindowInsets)
  {
    return null;
  }
  
  /* Error */
  protected void onConfigurationChanged(android.content.res.Configuration arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    return null;
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
  
  /* Error */
  protected void onSizeChanged(int arg1, int arg2, int arg3, int arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore 5
    //   3: goto -3 -> 0
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void removeFlutterEngineAttachmentListener(FlutterEngineAttachmentListener paramFlutterEngineAttachmentListener)
  {
    this.flutterEngineAttachmentListeners.remove(paramFlutterEngineAttachmentListener);
  }
  
  public void removeOnFirstFrameRenderedListener(FlutterUiDisplayListener paramFlutterUiDisplayListener)
  {
    this.flutterUiDisplayListeners.remove(paramFlutterUiDisplayListener);
  }
  
  /* Error */
  void sendUserSettingsToFlutter()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static abstract interface FlutterEngineAttachmentListener
  {
    public abstract void onFlutterEngineAttachedToFlutterView(FlutterEngine paramFlutterEngine);
    
    public abstract void onFlutterEngineDetachedFromFlutterView();
  }
  
  @Deprecated
  public static enum RenderMode
  {
    static
    {
      RenderMode localRenderMode = new RenderMode("texture", 1);
      texture = localRenderMode;
      $VALUES = new RenderMode[] { surface, localRenderMode };
    }
    
    private RenderMode() {}
  }
  
  @Deprecated
  public static enum TransparencyMode
  {
    static
    {
      TransparencyMode localTransparencyMode = new TransparencyMode("transparent", 1);
      transparent = localTransparencyMode;
      $VALUES = new TransparencyMode[] { opaque, localTransparencyMode };
    }
    
    private TransparencyMode() {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\flutter\embedding\android\FlutterView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */