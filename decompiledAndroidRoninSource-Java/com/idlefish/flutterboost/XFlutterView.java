package com.idlefish.flutterboost;

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
import io.flutter.embedding.android.AndroidTouchProcessor;
import io.flutter.embedding.android.FlutterView.FlutterEngineAttachmentListener;
import io.flutter.embedding.android.FlutterView.RenderMode;
import io.flutter.embedding.android.FlutterView.TransparencyMode;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.renderer.FlutterRenderer.ViewportMetrics;
import io.flutter.embedding.engine.renderer.FlutterUiDisplayListener;
import io.flutter.embedding.engine.renderer.RenderSurface;
import io.flutter.view.AccessibilityBridge;
import io.flutter.view.AccessibilityBridge.OnAccessibilityChangeListener;
import java.util.HashSet;
import java.util.Set;

public class XFlutterView
  extends FrameLayout
{
  private static final String TAG = "FlutterView";
  private AccessibilityBridge accessibilityBridge;
  private XAndroidKeyProcessor androidKeyProcessor;
  private AndroidTouchProcessor androidTouchProcessor;
  private boolean didRenderFirstFrame;
  private FlutterEngine flutterEngine;
  private final Set<FlutterView.FlutterEngineAttachmentListener> flutterEngineAttachmentListeners = new HashSet();
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
  private boolean hasAddFirstFrameRenderedListener = false;
  private boolean isFlutterUiDisplayed;
  private final AccessibilityBridge.OnAccessibilityChangeListener onAccessibilityChangeListener = new AccessibilityBridge.OnAccessibilityChangeListener()
  {
    public void onAccessibilityChanged(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
    {
      XFlutterView.this.resetWillNotDraw(paramAnonymousBoolean1, paramAnonymousBoolean2);
    }
  };
  private FlutterView.RenderMode renderMode;
  private RenderSurface renderSurface;
  private XTextInputPlugin textInputPlugin;
  private FlutterView.TransparencyMode transparencyMode;
  private final FlutterRenderer.ViewportMetrics viewportMetrics = new FlutterRenderer.ViewportMetrics();
  
  public XFlutterView(Context paramContext)
  {
    this(paramContext, null, null, null);
  }
  
  public XFlutterView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, null, null);
  }
  
  private XFlutterView(Context paramContext, AttributeSet paramAttributeSet, FlutterView.RenderMode paramRenderMode, FlutterView.TransparencyMode paramTransparencyMode)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramRenderMode;
    if (paramRenderMode == null) {
      paramContext = FlutterView.RenderMode.surface;
    }
    this.renderMode = paramContext;
    if (paramTransparencyMode == null) {
      paramTransparencyMode = FlutterView.TransparencyMode.opaque;
    }
    this.transparencyMode = paramTransparencyMode;
    init();
  }
  
  public XFlutterView(Context paramContext, FlutterView.RenderMode paramRenderMode)
  {
    this(paramContext, null, paramRenderMode, null);
  }
  
  public XFlutterView(Context paramContext, FlutterView.RenderMode paramRenderMode, FlutterView.TransparencyMode paramTransparencyMode)
  {
    this(paramContext, null, paramRenderMode, paramTransparencyMode);
  }
  
  public XFlutterView(Context paramContext, FlutterView.TransparencyMode paramTransparencyMode)
  {
    this(paramContext, null, FlutterView.RenderMode.surface, paramTransparencyMode);
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
  private void sendUserSettingsToFlutter()
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
  
  public void addFlutterEngineAttachmentListener(FlutterView.FlutterEngineAttachmentListener paramFlutterEngineAttachmentListener)
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
    return this.didRenderFirstFrame;
  }
  
  public boolean isAttachedToFlutterEngine()
  {
    return this.flutterEngine != null;
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
    //   2: return
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
  
  public void release()
  {
    XTextInputPlugin localXTextInputPlugin = this.textInputPlugin;
    if (localXTextInputPlugin != null) {
      localXTextInputPlugin.release(this);
    }
  }
  
  public void removeFlutterEngineAttachmentListener(FlutterView.FlutterEngineAttachmentListener paramFlutterEngineAttachmentListener)
  {
    this.flutterEngineAttachmentListeners.remove(paramFlutterEngineAttachmentListener);
  }
  
  public void removeOnFirstFrameRenderedListener(FlutterUiDisplayListener paramFlutterUiDisplayListener)
  {
    this.flutterUiDisplayListeners.remove(paramFlutterUiDisplayListener);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\idlefish\flutterboost\XFlutterView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */