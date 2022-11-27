package dji.midware.ar;

import android.content.Context;
import dji.midware.ar.min3d.core.Object3dContainer;
import dji.midware.ar.min3d.core.Scene;
import dji.midware.ar.min3d.vos.Color4;
import java.util.LinkedList;
import java.util.List;
import javax.microedition.khronos.opengles.GL10;

public class ArPathController
{
  private static final float ARROW_SCALE_X = 0.11363637F;
  private static final float ARROW_SCALE_Y = 0.19999999F;
  private static final float ARROW_SCALE_Z = 0.18181819F;
  private static final String TAG = "ArPathController";
  private static ArPathController instance;
  private static float[] rotateQuat;
  private List<Object3dContainer> arrowNodes = new LinkedList();
  private Min3dView displayView;
  private int extraNodeNum = 0;
  private GL10 gl;
  private boolean isPaused;
  private boolean isResume;
  private Context mContext;
  private Scene mScene;
  private Color4[] newColors;
  private float[] posX;
  private float[] posY;
  private float[] posZ;
  private Object3dContainer prototype;
  private float[] rotationX;
  private float[] rotationY;
  private float[] rotationZ;
  
  static
  {
    float f = (float)(Math.sqrt(2.0D) / 2.0D);
    rotateQuat = new float[] { f, f, 0.0F, 0.0F };
  }
  
  public static ArPathController getInstance()
  {
    if (instance == null) {
      instance = new ArPathController();
    }
    return instance;
  }
  
  /* Error */
  private void updateNodesColor()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void updateNodesNum()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void updateNodesPos()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void updateNodesRotation()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void destroy()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public Min3dView getDisplayView()
  {
    return this.displayView;
  }
  
  /* Error */
  public void init(Context arg1, java.io.InputStream arg2, float arg3, float arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @org.greenrobot.eventbus.Subscribe(threadMode=org.greenrobot.eventbus.ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(dji.midware.data.model.P3.DataEyeObjectDetectionPushInfo arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void onResume()
  {
    this.isResume = true;
  }
  
  /* Error */
  public void updateNodesColor(Color4[] arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void updateNodesNum(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void updateNodesPosition(float[] arg1, float[] arg2, float[] arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void updateNodesRotation(float[] arg1, float[] arg2, float[] arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void updateVerticalFov(float arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void updateVerticalFov(float arg1, float arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void updateViewport(int arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\midware\ar\ArPathController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */