package dji.midware.ar;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.os.Handler;
import dji.midware.ar.min3d.Shared;
import dji.midware.ar.min3d.core.Renderer;
import dji.midware.ar.min3d.core.Scene;
import dji.midware.ar.min3d.interfaces.ISceneController;

public abstract class Min3dView
  extends GLSurfaceView
  implements ISceneController
{
  protected Handler _initSceneHander;
  final Runnable _initSceneRunnable = new Runnable()
  {
    public void run()
    {
      Min3dView.this.onInitScene();
    }
  };
  private boolean _renderContinuously;
  protected Handler _updateSceneHander;
  final Runnable _updateSceneRunnable = new Runnable()
  {
    public void run()
    {
      Min3dView.this.onUpdateScene();
    }
  };
  private Renderer mRender;
  public Scene scene;
  
  public Min3dView(Context paramContext)
  {
    super(paramContext);
  }
  
  public Handler getInitSceneHandler()
  {
    return this._initSceneHander;
  }
  
  public Runnable getInitSceneRunnable()
  {
    return this._initSceneRunnable;
  }
  
  public Renderer getRenderer()
  {
    return this.mRender;
  }
  
  public Handler getUpdateSceneHandler()
  {
    return this._updateSceneHander;
  }
  
  public Runnable getUpdateSceneRunnable()
  {
    return this._updateSceneRunnable;
  }
  
  /* Error */
  protected void glSurfaceViewConfig()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void init()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public abstract void initScene();
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
  }
  
  public void onInitScene() {}
  
  public void onUpdateScene() {}
  
  public void unInit()
  {
    Shared.renderer(null);
  }
  
  public abstract void updateScene();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\midware\ar\Min3dView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */