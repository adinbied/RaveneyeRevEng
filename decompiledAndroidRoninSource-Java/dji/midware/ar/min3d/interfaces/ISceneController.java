package dji.midware.ar.min3d.interfaces;

import android.os.Handler;

public abstract interface ISceneController
{
  public abstract Handler getInitSceneHandler();
  
  public abstract Runnable getInitSceneRunnable();
  
  public abstract Handler getUpdateSceneHandler();
  
  public abstract Runnable getUpdateSceneRunnable();
  
  public abstract void initScene();
  
  public abstract void updateScene();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\midware\ar\min3d\interfaces\ISceneController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */