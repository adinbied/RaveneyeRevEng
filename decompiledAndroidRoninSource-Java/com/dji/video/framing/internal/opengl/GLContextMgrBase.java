package com.dji.video.framing.internal.opengl;

public abstract class GLContextMgrBase
{
  public final boolean DEBUG = false;
  protected final int EGL_CONTEXT_CLIENT_VERSION = 12440;
  protected final int EGL_OPENGL_ES2_BIT = 4;
  protected boolean hasInit = false;
  
  public static GLContextMgrBase createGLContextMgrInstance()
  {
    return new GLContextMgr18plus();
  }
  
  public abstract void attachToThread();
  
  public abstract void bindSurface(Object paramObject);
  
  /* Error */
  protected void checkGlError(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public abstract void createContext();
  
  public abstract void destroyAll();
  
  public abstract void destroySurfaces();
  
  public abstract void detachFromThread();
  
  public abstract boolean existContext();
  
  public abstract int getSurfaceHeight();
  
  public abstract int getSurfaceWidth();
  
  public abstract String getTAG();
  
  public abstract void loadFromThread();
  
  public abstract void setPresentationTime(long paramLong);
  
  public abstract void swapBuffers();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\dji\video\framing\internal\opengl\GLContextMgrBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */