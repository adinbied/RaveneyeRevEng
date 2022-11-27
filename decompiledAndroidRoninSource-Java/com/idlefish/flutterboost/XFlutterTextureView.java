package com.idlefish.flutterboost;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import io.flutter.Log;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.embedding.engine.renderer.RenderSurface;

public class XFlutterTextureView
  extends TextureView
  implements RenderSurface
{
  private static final String TAG = "FlutterTextureView";
  private FlutterRenderer flutterRenderer;
  private boolean isAttachedToFlutterRenderer = false;
  private boolean isSurfaceAvailableForRendering = false;
  private Surface renderSurface;
  private final TextureView.SurfaceTextureListener surfaceTextureListener = new TextureView.SurfaceTextureListener()
  {
    public void onSurfaceTextureAvailable(SurfaceTexture paramAnonymousSurfaceTexture, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      Log.v("FlutterTextureView", "SurfaceTextureListener.onSurfaceTextureAvailable()");
      XFlutterTextureView.access$002(XFlutterTextureView.this, true);
      if (XFlutterTextureView.this.isAttachedToFlutterRenderer) {
        XFlutterTextureView.this.connectSurfaceToRenderer();
      }
    }
    
    public boolean onSurfaceTextureDestroyed(SurfaceTexture paramAnonymousSurfaceTexture)
    {
      return false;
    }
    
    /* Error */
    public void onSurfaceTextureSizeChanged(SurfaceTexture arg1, int arg2, int arg3)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void onSurfaceTextureUpdated(SurfaceTexture paramAnonymousSurfaceTexture) {}
  };
  
  public XFlutterTextureView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public XFlutterTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
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
  
  private void init()
  {
    setSurfaceTextureListener(this.surfaceTextureListener);
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\idlefish\flutterboost\XFlutterTextureView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */