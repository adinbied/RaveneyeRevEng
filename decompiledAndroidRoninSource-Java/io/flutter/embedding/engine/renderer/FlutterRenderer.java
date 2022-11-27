package io.flutter.embedding.engine.renderer;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.Surface;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.view.TextureRegistry;
import io.flutter.view.TextureRegistry.SurfaceTextureEntry;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicLong;

public class FlutterRenderer
  implements TextureRegistry
{
  private static final String TAG = "FlutterRenderer";
  private final FlutterJNI flutterJNI;
  private final FlutterUiDisplayListener flutterUiDisplayListener;
  private boolean isDisplayingFlutterUi = false;
  private final AtomicLong nextTextureId = new AtomicLong(0L);
  private Surface surface;
  
  public FlutterRenderer(FlutterJNI paramFlutterJNI)
  {
    FlutterUiDisplayListener local1 = new FlutterUiDisplayListener()
    {
      public void onFlutterUiDisplayed()
      {
        FlutterRenderer.access$002(FlutterRenderer.this, true);
      }
      
      public void onFlutterUiNoLongerDisplayed()
      {
        FlutterRenderer.access$002(FlutterRenderer.this, false);
      }
    };
    this.flutterUiDisplayListener = local1;
    this.flutterJNI = paramFlutterJNI;
    paramFlutterJNI.addIsDisplayingFlutterUiListener(local1);
  }
  
  private void markTextureFrameAvailable(long paramLong)
  {
    this.flutterJNI.markTextureFrameAvailable(paramLong);
  }
  
  private void registerTexture(long paramLong, SurfaceTexture paramSurfaceTexture)
  {
    this.flutterJNI.registerTexture(paramLong, paramSurfaceTexture);
  }
  
  private void unregisterTexture(long paramLong)
  {
    this.flutterJNI.unregisterTexture(paramLong);
  }
  
  /* Error */
  public void addIsDisplayingFlutterUiListener(FlutterUiDisplayListener arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public TextureRegistry.SurfaceTextureEntry createSurfaceTexture()
  {
    return null;
  }
  
  public void dispatchPointerDataPacket(ByteBuffer paramByteBuffer, int paramInt)
  {
    this.flutterJNI.dispatchPointerDataPacket(paramByteBuffer, paramInt);
  }
  
  public void dispatchSemanticsAction(int paramInt1, int paramInt2, ByteBuffer paramByteBuffer, int paramInt3)
  {
    this.flutterJNI.dispatchSemanticsAction(paramInt1, paramInt2, paramByteBuffer, paramInt3);
  }
  
  public Bitmap getBitmap()
  {
    return this.flutterJNI.getBitmap();
  }
  
  public boolean isDisplayingFlutterUi()
  {
    return this.isDisplayingFlutterUi;
  }
  
  public boolean isSoftwareRenderingEnabled()
  {
    return this.flutterJNI.nativeGetIsSoftwareRenderingEnabled();
  }
  
  public void removeIsDisplayingFlutterUiListener(FlutterUiDisplayListener paramFlutterUiDisplayListener)
  {
    this.flutterJNI.removeIsDisplayingFlutterUiListener(paramFlutterUiDisplayListener);
  }
  
  public void setAccessibilityFeatures(int paramInt)
  {
    this.flutterJNI.setAccessibilityFeatures(paramInt);
  }
  
  public void setSemanticsEnabled(boolean paramBoolean)
  {
    this.flutterJNI.setSemanticsEnabled(paramBoolean);
  }
  
  /* Error */
  public void setViewportMetrics(ViewportMetrics arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void startRenderingToSurface(Surface arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void stopRenderingToSurface()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void surfaceChanged(int paramInt1, int paramInt2)
  {
    this.flutterJNI.onSurfaceChanged(paramInt1, paramInt2);
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
  
  public static final class ViewportMetrics
  {
    public float devicePixelRatio = 1.0F;
    public int height = 0;
    public int paddingBottom = 0;
    public int paddingLeft = 0;
    public int paddingRight = 0;
    public int paddingTop = 0;
    public int systemGestureInsetBottom = 0;
    public int systemGestureInsetLeft = 0;
    public int systemGestureInsetRight = 0;
    public int systemGestureInsetTop = 0;
    public int viewInsetBottom = 0;
    public int viewInsetLeft = 0;
    public int viewInsetRight = 0;
    public int viewInsetTop = 0;
    public int width = 0;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\flutter\embedding\engine\renderer\FlutterRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */