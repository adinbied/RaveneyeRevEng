package io.flutter.plugin.platform;

import android.app.Presentation;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

class SingleViewPresentation
  extends Presentation
{
  private final AccessibilityEventsDelegate accessibilityEventsDelegate;
  private FrameLayout container;
  private Object createParams;
  private final View.OnFocusChangeListener focusChangeListener;
  private AccessibilityDelegatingFrameLayout rootView;
  private boolean startFocused = false;
  private PresentationState state;
  private final PlatformViewFactory viewFactory;
  private int viewId;
  
  public SingleViewPresentation(Context paramContext, Display paramDisplay, AccessibilityEventsDelegate paramAccessibilityEventsDelegate, PresentationState paramPresentationState, View.OnFocusChangeListener paramOnFocusChangeListener, boolean paramBoolean)
  {
    super(new ImmContext(paramContext), paramDisplay);
    this.accessibilityEventsDelegate = paramAccessibilityEventsDelegate;
    this.viewFactory = null;
    this.state = paramPresentationState;
    this.focusChangeListener = paramOnFocusChangeListener;
    getWindow().setFlags(8, 8);
    this.startFocused = paramBoolean;
  }
  
  public SingleViewPresentation(Context paramContext, Display paramDisplay, PlatformViewFactory paramPlatformViewFactory, AccessibilityEventsDelegate paramAccessibilityEventsDelegate, int paramInt, Object paramObject, View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    super(new ImmContext(paramContext), paramDisplay);
    this.viewFactory = paramPlatformViewFactory;
    this.accessibilityEventsDelegate = paramAccessibilityEventsDelegate;
    this.viewId = paramInt;
    this.createParams = paramObject;
    this.focusChangeListener = paramOnFocusChangeListener;
    this.state = new PresentationState();
    getWindow().setFlags(8, 8);
    if (Build.VERSION.SDK_INT >= 19) {
      getWindow().setType(2030);
    }
  }
  
  public PresentationState detachState()
  {
    return null;
  }
  
  public PlatformView getView()
  {
    return null;
  }
  
  /* Error */
  protected void onCreate(android.os.Bundle arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private static class AccessibilityDelegatingFrameLayout
    extends FrameLayout
  {
    private final AccessibilityEventsDelegate accessibilityEventsDelegate;
    private final View embeddedView;
    
    public AccessibilityDelegatingFrameLayout(Context paramContext, AccessibilityEventsDelegate paramAccessibilityEventsDelegate, View paramView)
    {
      super();
      this.accessibilityEventsDelegate = paramAccessibilityEventsDelegate;
      this.embeddedView = paramView;
    }
    
    public boolean requestSendAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      return false;
    }
  }
  
  static class FakeWindowViewGroup
    extends ViewGroup
  {
    private final Rect childRect = new Rect();
    private final Rect viewBounds = new Rect();
    
    public FakeWindowViewGroup(Context paramContext)
    {
      super();
    }
    
    private static int atMost(int paramInt)
    {
      return View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt), Integer.MIN_VALUE);
    }
    
    /* Error */
    protected void onLayout(boolean arg1, int arg2, int arg3, int arg4, int arg5)
    {
      // Byte code:
      //   0: return
      //   1: astore 6
      //   3: goto -3 -> 0
    }
    
    /* Error */
    protected void onMeasure(int arg1, int arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_3
      //   2: goto -2 -> 0
    }
  }
  
  private static class ImmContext
    extends ContextWrapper
  {
    private final InputMethodManager inputMethodManager;
    
    ImmContext(Context paramContext)
    {
      this(paramContext, null);
    }
    
    private ImmContext(Context paramContext, InputMethodManager paramInputMethodManager)
    {
      super();
      if (paramInputMethodManager == null) {
        paramInputMethodManager = (InputMethodManager)paramContext.getSystemService("input_method");
      }
      this.inputMethodManager = paramInputMethodManager;
    }
    
    public Context createDisplayContext(Display paramDisplay)
    {
      return null;
    }
    
    public Object getSystemService(String paramString)
    {
      return null;
    }
  }
  
  private static class PresentationContext
    extends ContextWrapper
  {
    private WindowManager windowManager;
    private final SingleViewPresentation.WindowManagerHandler windowManagerHandler;
    
    PresentationContext(Context paramContext, SingleViewPresentation.WindowManagerHandler paramWindowManagerHandler)
    {
      super();
      this.windowManagerHandler = paramWindowManagerHandler;
    }
    
    private WindowManager getWindowManager()
    {
      return null;
    }
    
    public Object getSystemService(String paramString)
    {
      return null;
    }
  }
  
  static class PresentationState
  {
    private SingleViewPresentation.FakeWindowViewGroup fakeWindowViewGroup;
    private PlatformView platformView;
    private SingleViewPresentation.WindowManagerHandler windowManagerHandler;
  }
  
  static class WindowManagerHandler
    implements InvocationHandler
  {
    private static final String TAG = "PlatformViewsController";
    private final WindowManager delegate;
    SingleViewPresentation.FakeWindowViewGroup fakeWindowRootView;
    
    WindowManagerHandler(WindowManager paramWindowManager, SingleViewPresentation.FakeWindowViewGroup paramFakeWindowViewGroup)
    {
      this.delegate = paramWindowManager;
      this.fakeWindowRootView = paramFakeWindowViewGroup;
    }
    
    /* Error */
    private void addView(Object[] arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    private void removeView(Object[] arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    private void removeViewImmediate(Object[] arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    private void updateViewLayout(Object[] arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public WindowManager getWindowManager()
    {
      return null;
    }
    
    public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
      throws Throwable
    {
      return null;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\flutter\plugin\platform\SingleViewPresentation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */