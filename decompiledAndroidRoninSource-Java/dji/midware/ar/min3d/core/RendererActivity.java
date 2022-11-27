package dji.midware.ar.min3d.core;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Handler;
import dji.midware.ar.min3d.interfaces.ISceneController;

public class RendererActivity
  extends Activity
  implements ISceneController
{
  protected GLSurfaceView _glSurfaceView;
  protected Handler _initSceneHander;
  final Runnable _initSceneRunnable = new Runnable()
  {
    public void run()
    {
      RendererActivity.this.onInitScene();
    }
  };
  private boolean _renderContinuously;
  protected Handler _updateSceneHander;
  final Runnable _updateSceneRunnable = new Runnable()
  {
    public void run()
    {
      RendererActivity.this.onUpdateScene();
    }
  };
  public Scene scene;
  
  public Handler getInitSceneHandler()
  {
    return this._initSceneHander;
  }
  
  public Runnable getInitSceneRunnable()
  {
    return this._initSceneRunnable;
  }
  
  public Handler getUpdateSceneHandler()
  {
    return this._updateSceneHander;
  }
  
  public Runnable getUpdateSceneRunnable()
  {
    return this._updateSceneRunnable;
  }
  
  protected GLSurfaceView glSurfaceView()
  {
    return this._glSurfaceView;
  }
  
  protected void glSurfaceViewConfig() {}
  
  public void initScene() {}
  
  /* Error */
  protected void onCreate(android.os.Bundle arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected void onCreateSetContentView()
  {
    setContentView(this._glSurfaceView);
  }
  
  public void onInitScene() {}
  
  /* Error */
  protected void onPause()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void onResume()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void onUpdateScene() {}
  
  /* Error */
  public void renderContinuously(boolean arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  public void updateScene() {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\midware\ar\min3d\core\RendererActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */