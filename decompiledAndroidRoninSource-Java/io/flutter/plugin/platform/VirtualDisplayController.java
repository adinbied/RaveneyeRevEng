package io.flutter.plugin.platform;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.SurfaceTexture;
import android.hardware.display.DisplayManager;
import android.hardware.display.VirtualDisplay;
import android.util.DisplayMetrics;
import android.view.Surface;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnDrawListener;
import io.flutter.view.TextureRegistry.SurfaceTextureEntry;

class VirtualDisplayController
{
  private final AccessibilityEventsDelegate accessibilityEventsDelegate;
  private final Context context;
  private final int densityDpi;
  private final View.OnFocusChangeListener focusChangeListener;
  private SingleViewPresentation presentation;
  private Surface surface;
  private final TextureRegistry.SurfaceTextureEntry textureEntry;
  private VirtualDisplay virtualDisplay;
  
  private VirtualDisplayController(Context paramContext, AccessibilityEventsDelegate paramAccessibilityEventsDelegate, VirtualDisplay paramVirtualDisplay, PlatformViewFactory paramPlatformViewFactory, Surface paramSurface, TextureRegistry.SurfaceTextureEntry paramSurfaceTextureEntry, View.OnFocusChangeListener paramOnFocusChangeListener, int paramInt, Object paramObject)
  {
    this.context = paramContext;
    this.accessibilityEventsDelegate = paramAccessibilityEventsDelegate;
    this.textureEntry = paramSurfaceTextureEntry;
    this.focusChangeListener = paramOnFocusChangeListener;
    this.surface = paramSurface;
    this.virtualDisplay = paramVirtualDisplay;
    this.densityDpi = paramContext.getResources().getDisplayMetrics().densityDpi;
    paramContext = new SingleViewPresentation(paramContext, this.virtualDisplay.getDisplay(), paramPlatformViewFactory, paramAccessibilityEventsDelegate, paramInt, paramObject, paramOnFocusChangeListener);
    this.presentation = paramContext;
    paramContext.show();
  }
  
  public static VirtualDisplayController create(Context paramContext, AccessibilityEventsDelegate paramAccessibilityEventsDelegate, PlatformViewFactory paramPlatformViewFactory, TextureRegistry.SurfaceTextureEntry paramSurfaceTextureEntry, int paramInt1, int paramInt2, int paramInt3, Object paramObject, View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    paramSurfaceTextureEntry.surfaceTexture().setDefaultBufferSize(paramInt1, paramInt2);
    Surface localSurface = new Surface(paramSurfaceTextureEntry.surfaceTexture());
    VirtualDisplay localVirtualDisplay = ((DisplayManager)paramContext.getSystemService("display")).createVirtualDisplay("flutter-vd", paramInt1, paramInt2, paramContext.getResources().getDisplayMetrics().densityDpi, localSurface, 0);
    if (localVirtualDisplay == null) {
      return null;
    }
    return new VirtualDisplayController(paramContext, paramAccessibilityEventsDelegate, localVirtualDisplay, paramPlatformViewFactory, localSurface, paramSurfaceTextureEntry, paramOnFocusChangeListener, paramInt3, paramObject);
  }
  
  /* Error */
  public void dispose()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public View getView()
  {
    return null;
  }
  
  /* Error */
  void onFlutterViewAttached(View arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  void onFlutterViewDetached()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  void onInputConnectionLocked()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  void onInputConnectionUnlocked()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void resize(int arg1, int arg2, Runnable arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  static class OneTimeOnDrawListener
    implements ViewTreeObserver.OnDrawListener
  {
    Runnable mOnDrawRunnable;
    final View mView;
    
    OneTimeOnDrawListener(View paramView, Runnable paramRunnable)
    {
      this.mView = paramView;
      this.mOnDrawRunnable = paramRunnable;
    }
    
    static void schedule(View paramView, Runnable paramRunnable)
    {
      paramRunnable = new OneTimeOnDrawListener(paramView, paramRunnable);
      paramView.getViewTreeObserver().addOnDrawListener(paramRunnable);
    }
    
    /* Error */
    public void onDraw()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\flutter\plugin\platform\VirtualDisplayController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */