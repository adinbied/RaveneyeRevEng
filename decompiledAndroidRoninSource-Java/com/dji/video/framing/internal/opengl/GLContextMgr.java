package com.dji.video.framing.internal.opengl;

import dji.log.DJILog;
import java.util.Hashtable;
import java.util.Set;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

public class GLContextMgr
  extends GLContextMgrBase
{
  private static final int EGL_RECORDABLE_ANDROID = 12610;
  public static final String TAG = "GLContextMgr";
  private EGLConfig[] configs;
  private Hashtable<String, ExtraSurfaceInfo> extraSurfaceInfoMap = new Hashtable();
  private Hashtable<String, Long> lastExtraDrawTimeMap = new Hashtable();
  private EGL10 mEgl = (EGL10)EGLContext.getEGL();
  private EGLContext mEglContext = EGL10.EGL_NO_CONTEXT;
  private EGLDisplay mEglDisplay = EGL10.EGL_NO_DISPLAY;
  private EGLSurface mEglSurfaceDraw = EGL10.EGL_NO_SURFACE;
  private EGLSurface mEglSurfaceRead = EGL10.EGL_NO_SURFACE;
  
  public GLContextMgr()
  {
    this.hasInit = true;
    initDisplay();
    initConfig();
    DJILog.i("GLContextMgr", "OpenGL init Surface/pBuffer/Context successful!", new Object[0]);
  }
  
  private EGLConfig getConfig(boolean paramBoolean1, boolean paramBoolean2)
  {
    return null;
  }
  
  /* Error */
  public void attachSecondaryToThread(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void attachToThread()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean bindExtraSurface(String paramString, Object paramObject, int paramInt1, int paramInt2, int paramInt3)
  {
    return false;
  }
  
  /* Error */
  public void bindSurface(Object arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void checkGlError(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void createContext()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void createContext(EGLContext arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void destroyAll()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public void destroyExtraSurfaces(String paramString)
  {
    destroyExtraSurfaces(paramString, true);
  }
  
  /* Error */
  public void destroyExtraSurfaces(String arg1, boolean arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void destroySurfaces()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void detachFromThread()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean existContext()
  {
    return false;
  }
  
  public EGLContext getEglContext()
  {
    return this.mEglContext;
  }
  
  public ExtraSurfaceInfo getExtraSurfaceInfo(String paramString)
  {
    return null;
  }
  
  public Set<String> getExtraSurfaceKeys()
  {
    return this.extraSurfaceInfoMap.keySet();
  }
  
  public long getLastExtraDrawTime(String paramString)
  {
    return 211247660L;
  }
  
  public int getSecSurfaceNum()
  {
    return this.extraSurfaceInfoMap.size();
  }
  
  public int getSurfaceHeight()
  {
    return 0;
  }
  
  public int getSurfaceWidth()
  {
    return 0;
  }
  
  public String getTAG()
  {
    return "GLContextMgr";
  }
  
  public boolean hasBindSecSurface(String paramString)
  {
    return false;
  }
  
  /* Error */
  protected void initConfig()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void initDisplay()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void loadFromThread()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void resetSurface()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void setPresentationTime(long paramLong) {}
  
  /* Error */
  public void swapBuffers()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void swapExtraBuffers(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static class ExtraSurfaceInfo
  {
    public int drawInterval = 1;
    public int height;
    public EGLSurface surfaceDraw = EGL10.EGL_NO_SURFACE;
    public EGLSurface surfaceRead = EGL10.EGL_NO_SURFACE;
    public int width;
    
    public ExtraSurfaceInfo(EGLSurface paramEGLSurface1, EGLSurface paramEGLSurface2, int paramInt1, int paramInt2, int paramInt3)
    {
      this.surfaceRead = paramEGLSurface1;
      this.surfaceDraw = paramEGLSurface2;
      this.width = paramInt1;
      this.height = paramInt2;
      this.drawInterval = paramInt3;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\dji\video\framing\internal\opengl\GLContextMgr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */