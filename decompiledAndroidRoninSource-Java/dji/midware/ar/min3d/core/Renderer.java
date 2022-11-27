package dji.midware.ar.min3d.core;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.GLSurfaceView.Renderer;
import dji.midware.ar.min3d.Shared;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import javax.microedition.khronos.opengles.GL10;

public class Renderer
  implements GLSurfaceView.Renderer
{
  public static final int FRAMERATE_SAMPLEINTERVAL_MS = 1000;
  public static final int NUM_GLLIGHTS = 8;
  private ActivityManager _activityManager;
  private float _fps = 0.0F;
  private long _frameCount = 0L;
  private GL10 _gl;
  private boolean _logFps = false;
  private ActivityManager.MemoryInfo _memoryInfo;
  private Scene _scene;
  private boolean _scratchB;
  private FloatBuffer _scratchFloatBuffer;
  private IntBuffer _scratchIntBuffer;
  private float _surfaceAspectRatio;
  private TextureManager _textureManager;
  private long _timeLastSample;
  
  public Renderer(Scene paramScene)
  {
    this._scene = paramScene;
    this._scratchIntBuffer = IntBuffer.allocate(4);
    this._scratchFloatBuffer = FloatBuffer.allocate(4);
    paramScene = new TextureManager();
    this._textureManager = paramScene;
    Shared.textureManager(paramScene);
    this._activityManager = ((ActivityManager)Shared.context().getSystemService("activity"));
    this._memoryInfo = new ActivityManager.MemoryInfo();
  }
  
  /* Error */
  private void doFps()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void drawObject_textures(Object3d arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void reset()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private void setGl(GL10 paramGL10)
  {
    this._gl = paramGL10;
  }
  
  public long availMem()
  {
    return 211240209L;
  }
  
  /* Error */
  void deleteTexture(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void drawObject(Object3d arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void drawScene()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void drawSetup()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void drawSetupLights()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public float fps()
  {
    return this._fps;
  }
  
  public float getSurfaceAspectRatio()
  {
    return this._surfaceAspectRatio;
  }
  
  public GL10 gl()
  {
    return this._gl;
  }
  
  /* Error */
  public void logFps(boolean arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    this._scene.update();
    drawSetup();
    drawScene();
    if (this._logFps) {
      doFps();
    }
  }
  
  /* Error */
  public void onSurfaceChanged(GL10 arg1, int arg2, int arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onSurfaceCreated(GL10 arg1, javax.microedition.khronos.egl.EGLConfig arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void updateViewFrustrum()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  int uploadTextureAndReturnId(Bitmap paramBitmap, boolean paramBoolean)
  {
    return 0;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\midware\ar\min3d\core\Renderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */