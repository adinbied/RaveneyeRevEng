package io.flutter.view;

import android.graphics.SurfaceTexture;

public abstract interface TextureRegistry
{
  public abstract SurfaceTextureEntry createSurfaceTexture();
  
  public static abstract interface SurfaceTextureEntry
  {
    public abstract long id();
    
    public abstract void release();
    
    public abstract SurfaceTexture surfaceTexture();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\flutter\view\TextureRegistry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */