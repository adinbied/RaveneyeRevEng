package dji.midware.ar;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup.LayoutParams;
import dji.log.RoninLog;
import dji.midware.ar.min3d.core.Object3d;
import dji.midware.ar.min3d.core.Object3dContainer;
import dji.midware.ar.min3d.vos.Color4;
import dji.midware.ar.min3d.vos.Number3d;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import javax.microedition.khronos.opengles.GL10;

public class ArTapGroundDisplayView
  extends Min3dView
{
  private static final boolean DEBUG = true;
  private static final int GRID_ALPHA_MAX = 127;
  private static final float GRID_HEIGHT_ADJUST_PARAM = 10.0F;
  private static final String TAG = "ArTapGroundDisplayView";
  private static final String TARGET_TAG_CANNOT_PASS = "tap_ground_target_cannot_pass";
  private static final String TARGET_TAG_CAN_PASS = "tap_ground_target_can_pass";
  private static final float TARGET_TAG_ROTATION_MAX = 20.0F;
  private float fovy = 60.6F;
  private GL10 gl;
  private Object3dContainer grid;
  private Handler mainHandler = new Handler(Looper.getMainLooper());
  private float[] modelMatrix = new float[16];
  private MoveCameraTask moveCameraTask = new MoveCameraTask(null);
  private float[] projMatrix = new float[16];
  private TargetTag targetTag;
  private Number3d targetTagPos;
  private float[] targetTagScreenPos;
  private float testVerFov = 60.0F;
  private int updateCount = 0;
  private UpdateTargetTagTask updateTargetTagTask = new UpdateTargetTagTask(null);
  private BlockingQueue<Runnable> updateTaskQueue = new LinkedBlockingQueue();
  private int[] viewMatrix = new int[16];
  
  public ArTapGroundDisplayView(Context paramContext, float paramFloat)
  {
    super(paramContext);
    this.fovy = paramFloat;
  }
  
  /* Error */
  private void addTextures()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private Object3d getBall(float paramFloat, Color4 paramColor4)
  {
    return null;
  }
  
  private Object3d getCanPassTargetTag(float paramFloat)
  {
    return getRectWithTexture("tap_ground_target_can_pass", paramFloat, paramFloat);
  }
  
  private Object3d getCannotPassTargetTag(float paramFloat)
  {
    return getRectWithTexture("tap_ground_target_cannot_pass", paramFloat, paramFloat);
  }
  
  private Object3dContainer getGrid(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, float paramFloat3)
  {
    return null;
  }
  
  private Object3d getHorLines(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, int paramInt1, int paramInt2)
  {
    return null;
  }
  
  private Object3d getRectWithTexture(String paramString, float paramFloat1, float paramFloat2)
  {
    return null;
  }
  
  private Object3d getVerLines(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, int paramInt1, int paramInt2)
  {
    return null;
  }
  
  /* Error */
  private void gridMove(float arg1, float arg2, float arg3, float arg4, float arg5)
  {
    // Byte code:
    //   0: return
    //   1: astore 6
    //   3: goto -3 -> 0
  }
  
  /* Error */
  private void invokeSurfaceChange()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private void logd(String paramString1, String paramString2)
  {
    RoninLog.d(paramString1, paramString2, new Object[0]);
  }
  
  /* Error */
  private void moveCamera5(float arg1, float arg2, float arg3, float arg4, float arg5, float arg6)
  {
    // Byte code:
    //   0: return
    //   1: astore 7
    //   3: goto -3 -> 0
  }
  
  /* Error */
  private void postRunnableToGlThread(Runnable arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void updateTargetTagRotation()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void updateTargetTagYaw()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public float calcFrontGroundScreenCoorY(double paramDouble)
  {
    return 0.0F;
  }
  
  public float[] getTargetTagScreenCoor()
  {
    return null;
  }
  
  public ArTapGroundDisplayView.TargetTag.TargetTagState getTargetTagState()
  {
    return null;
  }
  
  /* Error */
  public void initScene()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean isCameraInitialized()
  {
    return false;
  }
  
  /* Error */
  public void moveCamera(float arg1, float arg2, float arg3, float arg4, float arg5, float arg6)
  {
    // Byte code:
    //   0: return
    //   1: astore 7
    //   3: goto -3 -> 0
  }
  
  /* Error */
  protected void onAttachedToWindow()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setGridVisible(boolean arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  public void setTargetTagState(ArTapGroundDisplayView.TargetTag.TargetTagState paramTargetTagState)
  {
    TargetTag localTargetTag = this.targetTag;
    if (localTargetTag != null) {
      localTargetTag.setTargetTagState(paramTargetTagState);
    }
  }
  
  /* Error */
  public void setTargetTagVisible(boolean arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void updateScene()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void updateTargetPosTag(float arg1, float arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void updateTargetPosTag(float arg1, float arg2, float arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore 4
    //   3: goto -3 -> 0
  }
  
  /* Error */
  public void updateVerticalFov(float arg1, boolean arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  private class MoveCameraTask
    implements Runnable
  {
    public float camPitch;
    public float camRoll;
    public float camYaw;
    public float posEarth;
    public float posEast;
    public float posNorth;
    
    private MoveCameraTask() {}
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void setAll(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
    {
      this.posNorth = paramFloat1;
      this.posEast = paramFloat2;
      this.posEarth = paramFloat3;
      this.camPitch = paramFloat4;
      this.camRoll = paramFloat5;
      this.camYaw = paramFloat6;
    }
  }
  
  public static class TargetTag
    extends Object3dContainer
  {
    private Object3d canPassTag;
    private Object3d cannotPassTag;
    private TargetTagState targetTagState;
    
    public TargetTag(Object3d paramObject3d1, Object3d paramObject3d2)
    {
      this.canPassTag = paramObject3d1;
      this.cannotPassTag = paramObject3d2;
      addChild(paramObject3d1);
      addChild(paramObject3d2);
      setTargetTagState(TargetTagState.Canpass);
    }
    
    public Number3d getTagRotation()
    {
      return this.canPassTag.rotation();
    }
    
    public TargetTagState getTargetTagState()
    {
      return this.targetTagState;
    }
    
    /* Error */
    public void setTagRotation(float arg1, float arg2, float arg3)
    {
      // Byte code:
      //   0: return
      //   1: astore 4
      //   3: goto -3 -> 0
    }
    
    /* Error */
    public void setTargetTagState(TargetTagState arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public static enum TargetTagState
    {
      static
      {
        CannotPass = new TargetTagState("CannotPass", 1);
        LeftYaw = new TargetTagState("LeftYaw", 2);
        RightYaw = new TargetTagState("RightYaw", 3);
        TargetTagState localTargetTagState = new TargetTagState("Unknown", 4);
        Unknown = localTargetTagState;
        $VALUES = new TargetTagState[] { Canpass, CannotPass, LeftYaw, RightYaw, localTargetTagState };
      }
      
      private TargetTagState() {}
    }
  }
  
  private class UpdateTargetTagTask
    implements Runnable
  {
    float touchEventX;
    float touchEventY;
    
    private UpdateTargetTagTask() {}
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\midware\ar\ArTapGroundDisplayView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */