package com.dji.video.framing.internal.opengl.extra;

import com.dji.video.framing.internal.opengl.GLContextMgr;
import com.dji.video.framing.internal.opengl.renderer.GLRenderBase;
import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.microedition.khronos.egl.EGLContext;

public class ExtraRenderThread
  implements Runnable
{
  private static final String TAG = "ExtraRenderThread";
  private GLContextMgr glContextMgr;
  private GLContextMgr glContextMgrPre;
  private AtomicBoolean isRunning = new AtomicBoolean(false);
  private final Object lock = new Object();
  private GLRenderBase renderer;
  private long secondaryDrawCount = 0L;
  private EGLContext sharedContext;
  private float[] stMatrix;
  private ArrayDeque<Integer> texIdQueue = new ArrayDeque(5);
  private int textureID = -1;
  private Thread thread;
  private int viewRotateDegree;
  private int viewX;
  private int viewportHeight;
  private int viewportWidth;
  
  public ExtraRenderThread(EGLContext paramEGLContext, GLRenderBase paramGLRenderBase, int paramInt1, float[] paramArrayOfFloat, int paramInt2, int paramInt3)
  {
    this.sharedContext = paramEGLContext;
    this.renderer = paramGLRenderBase;
    this.textureID = paramInt1;
    this.stMatrix = paramArrayOfFloat;
    this.viewRotateDegree = paramInt3;
    this.viewX = paramInt2;
    init();
  }
  
  /* Error */
  public void drawNotify(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: return
  }
  
  public int getAsyncRenderInterval(String paramString)
  {
    return 0;
  }
  
  /* Error */
  public void init()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void setAsyncRenderInterval(String arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean setAsyncRenderSurface(String paramString, Object paramObject, int paramInt1, int paramInt2, int paramInt3)
  {
    return false;
  }
  
  /* Error */
  public void startRunning()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void stopRunning()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\dji\video\framing\internal\opengl\extra\ExtraRenderThread.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */