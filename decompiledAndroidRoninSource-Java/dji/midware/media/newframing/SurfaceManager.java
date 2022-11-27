package dji.midware.media.newframing;

import com.dji.video.framing.internal.opengl.surface.SurfaceInterface;

public class SurfaceManager
{
  public static SurfaceInterface createInstance()
  {
    return new GLYUVSurface();
  }
  
  @Deprecated
  public static SurfaceInterface createInstance(Class<?> paramClass)
  {
    return new GLYUVSurface();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\media\newframing\SurfaceManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */