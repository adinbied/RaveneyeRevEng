package dji.midware.media.opengl;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import dji.log.RoninLog;

public class GLContextMgr18plus
  extends GLContextMgrBase
{
  public static final String TAG = "GLContextMgr18";
  private EGLConfig[] configs;
  private EGLContext mEglContext = EGL14.EGL_NO_CONTEXT;
  private EGLDisplay mEglDisplay = EGL14.EGL_NO_DISPLAY;
  private EGLSurface mEglSurfaceDraw = EGL14.EGL_NO_SURFACE;
  private EGLSurface mEglSurfaceRead = EGL14.EGL_NO_SURFACE;
  
  public GLContextMgr18plus()
  {
    this.hasInit = true;
    initDisplay();
    initConfig();
    RoninLog.i("GLContextMgr18", "GLContextMgr18 init successful!", new Object[0]);
  }
  
  /* Error */
  public void attachToThread()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
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
  public void createContext()
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
    return "GLContextMgr18";
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
  public void setPresentationTime(long arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void swapBuffers()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\media\opengl\GLContextMgr18plus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */