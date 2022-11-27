package io.flutter.embedding.android;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import io.flutter.Log;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.embedding.engine.renderer.FlutterUiDisplayListener;
import io.flutter.embedding.engine.renderer.RenderSurface;

public class FlutterSurfaceView
  extends SurfaceView
  implements RenderSurface
{
  private static final String TAG = "FlutterSurfaceView";
  private FlutterRenderer flutterRenderer;
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
    
    public void onFlutterUiNoLongerDisplayed() {}
  };
  private boolean isAttachedToFlutterRenderer = false;
  private boolean isSurfaceAvailableForRendering = false;
  private final boolean renderTransparently;
  private final SurfaceHolder.Callback surfaceCallback = new SurfaceHolder.Callback()
  {
    public void surfaceChanged(SurfaceHolder paramAnonymousSurfaceHolder, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
    {
      Log.v("FlutterSurfaceView", "SurfaceHolder.Callback.surfaceChanged()");
      if (FlutterSurfaceView.this.isAttachedToFlutterRenderer) {
        FlutterSurfaceView.this.changeSurfaceSize(paramAnonymousInt2, paramAnonymousInt3);
      }
    }
    
    /* Error */
    public void surfaceCreated(SurfaceHolder arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void surfaceDestroyed(SurfaceHolder arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  };
  
  public FlutterSurfaceView(Context paramContext)
  {
    this(paramContext, null, false);
  }
  
  public FlutterSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, false);
  }
  
  private FlutterSurfaceView(Context paramContext, AttributeSet paramAttributeSet, boolean paramBoolean)
  {
    super(paramContext, paramAttributeSet);
    this.renderTransparently = paramBoolean;
    init();
  }
  
  public FlutterSurfaceView(Context paramContext, boolean paramBoolean)
  {
    this(paramContext, null, paramBoolean);
  }
  
  /* Error */
  private void changeSurfaceSize(int arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void connectSurfaceToRenderer()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void disconnectSurfaceFromRenderer()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
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
  public void attachToRenderer(FlutterRenderer arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void detachFromRenderer()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public FlutterRenderer getAttachedRenderer()
  {
    return this.flutterRenderer;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\flutter\embedding\android\FlutterSurfaceView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */