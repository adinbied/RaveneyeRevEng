package dji.midware.ar;

import android.content.Context;
import dji.midware.ar.min3d.core.Scene;

public abstract class ArControllerBase
{
  protected Context context;
  protected Min3dView displayView;
  protected Scene mScene;
  
  public Min3dView getDisplayView()
  {
    return this.displayView;
  }
  
  public Scene getScene()
  {
    return this.mScene;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\midware\ar\ArControllerBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */