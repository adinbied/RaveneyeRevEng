package dji.midware.ar;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import dji.logic.vision.DJITrajectoryHelper.TrajectoryInfo;
import dji.midware.ar.min3d.core.Object3d;
import dji.midware.ar.min3d.core.Object3dContainer;
import dji.midware.ar.min3d.objectPrimitives.Box;
import dji.midware.ar.min3d.vos.Color4;
import dji.midware.ar.min3d.vos.Number3d;
import dji.midware.data.model.P3.DataEyeGetPushTrajectory.PolynomialTrajectory;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.microedition.khronos.opengles.GL10;

public class ArDrawFlyController
  extends ArControllerBase
{
  private static final String ARROW_TEX_ID = "arrow";
  private static final String ROUTE_PASS_TEX_ID = "route_pass_texture";
  private static final String ROUTE_TEX_ID = "route_texture";
  private static final float SCREEN_STRIP_WIDTH_SCALE = 0.096F;
  private static final String START_POINT_TEX_ID = "startpoint";
  private static final String TAG = "ArDrawFlyController";
  private static final String TERMINAL_TEX_ID = "terminal";
  private static final String UAV_POS_ARROW_TEX = "uav_pos_arrow_texture";
  private static final String UAV_POS_BG_TEX = "uav_pos_background_texture";
  private static ArDrawFlyController instance;
  private List<ArPointInfo> arPointInfos;
  Box box;
  private GL10 gl;
  private Object3d greenStrip;
  private Object3d greyStrip;
  private Object3dContainer grid;
  private int lastCurveIndex = -1;
  private long lastGetTrajectoryTime;
  private boolean lastHasStrip;
  private float lastRearDepth;
  private float lastRearX;
  private float lastRearY;
  private float lastSkyLineHorPos;
  private float lastStep = -1.0F;
  private ArDrawFlyControllerListener listener;
  private Handler mainHandler = new Handler(Looper.getMainLooper());
  private boolean needLogCamState;
  private AtomicBoolean needMoveUavTag = new AtomicBoolean(false);
  private AtomicBoolean needUpdateCam = new AtomicBoolean(false);
  private AtomicBoolean needUpdateStrip = new AtomicBoolean(false);
  private float newCamPitch;
  private float newCamPosX;
  private float newCamPosY;
  private float newCamPosZ;
  private float newCamRoll;
  private float newCamYaw;
  private int newCurveIndex;
  private float newStep;
  private float newUavPosX;
  private float newUavPosY;
  private float newUavRotZ;
  int screeny = 0;
  private Object3dContainer strip;
  private float stripWidth = 0.6F;
  private List<DataEyeGetPushTrajectory.PolynomialTrajectory> trajectoryList;
  private Object3d uavPosTag;
  private List<Number3d> vertices;
  
  /* Error */
  private void addBox()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void addMarkBall()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private void addTestObject() {}
  
  /* Error */
  private void addTextures()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private int calcArPointIndexByCurveIndexAndStep(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return 0;
  }
  
  private ArPointInfo[] calcArrowPoint(ArPointInfo paramArPointInfo, float paramFloat)
  {
    return null;
  }
  
  public static float calcDistanceSquare(Number3d paramNumber3d1, Number3d paramNumber3d2)
  {
    if ((paramNumber3d1 != null) && (paramNumber3d2 != null)) {
      return (float)(Math.pow(paramNumber3d1.x - paramNumber3d2.x, 2.0D) + Math.pow(paramNumber3d1.y - paramNumber3d2.y, 2.0D) + Math.pow(paramNumber3d1.z - paramNumber3d2.z, 2.0D));
    }
    return -1.0F;
  }
  
  private float calcStripWidth()
  {
    return 0.0F;
  }
  
  private List<Number3d> calcVertices(List<ArPointInfo> paramList, float paramFloat)
  {
    return null;
  }
  
  /* Error */
  private void changeStripSegAlpha(Object3d arg1, int arg2, int arg3, int arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void checkAndInvokeSkyLineListener()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void checkAndInvokeStripRearListener()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private boolean checkPolynomialTrajectory(DataEyeGetPushTrajectory.PolynomialTrajectory paramPolynomialTrajectory)
  {
    return false;
  }
  
  private boolean checkValApproximability(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return Math.abs(paramFloat1 - paramFloat2) <= paramFloat3;
  }
  
  private static float determinant(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return paramFloat1 * paramFloat3 - paramFloat2 * paramFloat4;
  }
  
  private List<Object3d> getArrows(int paramInt1, float paramFloat1, float paramFloat2, int paramInt2, float paramFloat3)
  {
    return null;
  }
  
  private Object3d getBallByArPointInfo(float paramFloat, Color4 paramColor4)
  {
    return null;
  }
  
  private Object3d getBallByArPointInfo(ArPointInfo paramArPointInfo, float paramFloat, Color4 paramColor4)
  {
    return null;
  }
  
  private Object3dContainer getGrid(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, float paramFloat3)
  {
    return null;
  }
  
  private Object3d getHorLines(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    return null;
  }
  
  public static ArDrawFlyController getInstance()
  {
    if (instance == null) {
      instance = new ArDrawFlyController();
    }
    return instance;
  }
  
  private Object3d getRectWithTexture(String paramString, float paramFloat1, float paramFloat2)
  {
    return null;
  }
  
  private List<Object3d> getStartAndTerminalPointTags(List<ArPointInfo> paramList, int paramInt1, int paramInt2)
  {
    return null;
  }
  
  private Object3d getStrip(List<Number3d> paramList)
  {
    return null;
  }
  
  private Object3d getStrip(List<Number3d> paramList, String paramString, int paramInt)
  {
    return null;
  }
  
  public static boolean getStripEdgePointBaseOnY(ArPointInfo paramArPointInfo, float paramFloat, Number3d paramNumber3d1, Number3d paramNumber3d2)
  {
    if ((paramArPointInfo != null) && (paramNumber3d1 != null))
    {
      if (paramNumber3d2 == null) {
        return false;
      }
      if (paramArPointInfo.normalX * paramArPointInfo.normalX + paramArPointInfo.normalZ * paramArPointInfo.normalZ == 0.0F) {
        return false;
      }
      paramNumber3d1.y = paramArPointInfo.posY;
      paramNumber3d2.y = paramArPointInfo.posY;
      float f = (float)Math.abs(paramArPointInfo.normalX * paramFloat / (Math.sqrt(paramArPointInfo.normalX * paramArPointInfo.normalX + paramArPointInfo.normalZ * paramArPointInfo.normalZ) * 2.0D));
      paramFloat = (float)Math.abs(paramFloat * paramArPointInfo.normalZ / (Math.sqrt(paramArPointInfo.normalX * paramArPointInfo.normalX + paramArPointInfo.normalZ * paramArPointInfo.normalZ) * 2.0D));
      if ((paramArPointInfo.normalX >= 0.0F) && (paramArPointInfo.normalZ >= 0.0F))
      {
        paramNumber3d1.x = (paramArPointInfo.posX - paramFloat);
        paramNumber3d1.z = (paramArPointInfo.posZ + f);
        paramNumber3d2.x = (paramArPointInfo.posX + paramFloat);
        paramNumber3d2.z = (paramArPointInfo.posZ - f);
      }
      if ((paramArPointInfo.normalX < 0.0F) && (paramArPointInfo.normalZ >= 0.0F))
      {
        paramNumber3d1.x = (paramArPointInfo.posX - paramFloat);
        paramNumber3d1.z = (paramArPointInfo.posZ - f);
        paramNumber3d2.x = (paramArPointInfo.posX + paramFloat);
        paramNumber3d2.z = (paramArPointInfo.posZ + f);
      }
      if ((paramArPointInfo.normalX < 0.0F) && (paramArPointInfo.normalZ < 0.0F))
      {
        paramNumber3d1.x = (paramArPointInfo.posX + paramFloat);
        paramNumber3d1.z = (paramArPointInfo.posZ - f);
        paramNumber3d2.x = (paramArPointInfo.posX - paramFloat);
        paramNumber3d2.z = (paramArPointInfo.posZ + f);
      }
      if ((paramArPointInfo.normalX >= 0.0F) && (paramArPointInfo.normalZ < 0.0F))
      {
        paramNumber3d1.x = (paramArPointInfo.posX + paramFloat);
        paramNumber3d1.z = (paramArPointInfo.posZ + f);
        paramNumber3d2.x = (paramArPointInfo.posX - paramFloat);
        paramNumber3d2.z = (paramArPointInfo.posZ - f);
      }
      return true;
    }
    return false;
  }
  
  public static boolean getStripEdgePointBaseOnZ(ArPointInfo paramArPointInfo, float paramFloat, Number3d paramNumber3d1, Number3d paramNumber3d2)
  {
    if ((paramArPointInfo != null) && (paramNumber3d1 != null))
    {
      if (paramNumber3d2 == null) {
        return false;
      }
      paramNumber3d1.z = 0.0F;
      paramNumber3d2.z = 0.0F;
      if (paramArPointInfo.normalX * paramArPointInfo.normalX + paramArPointInfo.normalY * paramArPointInfo.normalY == 0.0F) {
        return false;
      }
      float f = (float)Math.abs(paramArPointInfo.normalX * paramFloat / (Math.sqrt(paramArPointInfo.normalX * paramArPointInfo.normalX + paramArPointInfo.normalY * paramArPointInfo.normalY) * 2.0D));
      paramFloat = (float)Math.abs(paramFloat * paramArPointInfo.normalY / (Math.sqrt(paramArPointInfo.normalX * paramArPointInfo.normalX + paramArPointInfo.normalY * paramArPointInfo.normalY) * 2.0D));
      if ((paramArPointInfo.normalX >= 0.0F) && (paramArPointInfo.normalY >= 0.0F))
      {
        paramNumber3d1.x = (paramArPointInfo.posX - paramFloat);
        paramNumber3d1.y = (paramArPointInfo.posY + f);
        paramNumber3d2.x = (paramArPointInfo.posX + paramFloat);
        paramNumber3d2.y = (paramArPointInfo.posY - f);
      }
      if ((paramArPointInfo.normalX < 0.0F) && (paramArPointInfo.normalY >= 0.0F))
      {
        paramNumber3d1.x = (paramArPointInfo.posX - paramFloat);
        paramNumber3d1.y = (paramArPointInfo.posY - f);
        paramNumber3d2.x = (paramArPointInfo.posX + paramFloat);
        paramNumber3d2.y = (paramArPointInfo.posY + f);
      }
      if ((paramArPointInfo.normalX < 0.0F) && (paramArPointInfo.normalY < 0.0F))
      {
        paramNumber3d1.x = (paramArPointInfo.posX + paramFloat);
        paramNumber3d1.y = (paramArPointInfo.posY - f);
        paramNumber3d2.x = (paramArPointInfo.posX - paramFloat);
        paramNumber3d2.y = (paramArPointInfo.posY + f);
      }
      if ((paramArPointInfo.normalX >= 0.0F) && (paramArPointInfo.normalY < 0.0F))
      {
        paramNumber3d1.x = (paramArPointInfo.posX + paramFloat);
        paramNumber3d1.y = (paramArPointInfo.posY + f);
        paramNumber3d2.x = (paramArPointInfo.posX - paramFloat);
        paramNumber3d2.y = (paramArPointInfo.posY - f);
      }
      return true;
    }
    return false;
  }
  
  private Object3dContainer getTestingBalls(List<ArPointInfo> paramList, int paramInt, float paramFloat, Color4 paramColor4)
  {
    return null;
  }
  
  private Object3d getUavPosTag(float paramFloat)
  {
    return null;
  }
  
  private Object3d getVerLines(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    return null;
  }
  
  private float[] gox(float[] paramArrayOfFloat)
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
  
  private static boolean isVerticeIntersectional(Number3d paramNumber3d1, Number3d paramNumber3d2, Number3d paramNumber3d3, Number3d paramNumber3d4)
  {
    float f1 = determinant(paramNumber3d2.x - paramNumber3d1.x, paramNumber3d3.x - paramNumber3d4.x, paramNumber3d2.y - paramNumber3d1.y, paramNumber3d3.y - paramNumber3d4.y);
    double d = f1;
    if ((d <= 1.0E-6D) && (d >= -1.0E-6D)) {
      return false;
    }
    float f2 = determinant(paramNumber3d3.x - paramNumber3d1.x, paramNumber3d3.x - paramNumber3d4.x, paramNumber3d3.y - paramNumber3d1.y, paramNumber3d3.y - paramNumber3d4.y) / f1;
    if (f2 <= 1.0F)
    {
      if (f2 < 0.0F) {
        return false;
      }
      f1 = determinant(paramNumber3d2.x - paramNumber3d1.x, paramNumber3d3.x - paramNumber3d1.x, paramNumber3d2.y - paramNumber3d1.y, paramNumber3d3.y - paramNumber3d1.y) / f1;
      if (f1 <= 1.0F) {
        return f1 >= 0.0F;
      }
    }
    return false;
  }
  
  /* Error */
  private void logCameraState(File arg1)
    throws IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void logToFile(File arg1, String arg2)
    throws IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void logTrajectoriesToFile(File arg1, Collection<DJITrajectoryHelper.TrajectoryInfo> arg2)
    throws IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void logTrajectoryToFile(File arg1, Collection<DJITrajectoryHelper.TrajectoryInfo> arg2)
    throws IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void onUavPosOnTrajectoryUpdate(int arg1, float arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  public static List<DataEyeGetPushTrajectory.PolynomialTrajectory> parseTrackDataFromFile(File paramFile)
    throws IOException
  {
    if ((paramFile != null) && (paramFile.exists()) && (paramFile.isFile()))
    {
      LinkedList localLinkedList1 = new LinkedList();
      LinkedList localLinkedList2 = new LinkedList();
      paramFile = new BufferedReader(new FileReader(paramFile));
      Object localObject;
      int i;
      for (;;)
      {
        localObject = paramFile.readLine();
        i = 0;
        if (localObject == null) {
          break;
        }
        localObject = ((String)localObject).replace("\n", "").replace("\r", "").split(" ");
        if (localObject != null)
        {
          int j = localObject.length;
          while (i < j)
          {
            localLinkedList2.add(Float.valueOf(Float.parseFloat(localObject[i])));
            i += 1;
          }
        }
      }
      paramFile.close();
      while (localLinkedList2.size() >= 18)
      {
        paramFile = new float[6];
        localObject = new float[6];
        float[] arrayOfFloat = new float[6];
        i = 0;
        while (i < 6)
        {
          paramFile[i] = ((Float)localLinkedList2.poll()).floatValue();
          i += 1;
        }
        i = 0;
        while (i < 6)
        {
          localObject[i] = ((Float)localLinkedList2.poll()).floatValue();
          i += 1;
        }
        i = 0;
        while (i < 6)
        {
          arrayOfFloat[i] = ((Float)localLinkedList2.poll()).floatValue();
          i += 1;
        }
        localLinkedList1.add(new DataEyeGetPushTrajectory.PolynomialTrajectory(paramFile, (float[])localObject, arrayOfFloat));
      }
      return localLinkedList1;
    }
    return null;
  }
  
  /* Error */
  private void regulateVertices(List<Number3d> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private ArPointInfo samplingFromCurve(DataEyeGetPushTrajectory.PolynomialTrajectory paramPolynomialTrajectory, float paramFloat)
  {
    return null;
  }
  
  private void updatePos() {}
  
  public float curveSampling(float[] paramArrayOfFloat1, int paramInt1, float[] paramArrayOfFloat2, int paramInt2, int paramInt3)
  {
    return 0.0F;
  }
  
  /* Error */
  public void destroy()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public float[] findDerivative(float[] paramArrayOfFloat)
  {
    return null;
  }
  
  public List<ArPointInfo> getArPointInfosFromCurve(DataEyeGetPushTrajectory.PolynomialTrajectory paramPolynomialTrajectory, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return null;
  }
  
  public List<ArPointInfo> getArPointInfosFromCurve(Collection<DJITrajectoryHelper.TrajectoryInfo> paramCollection, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return null;
  }
  
  public List<ArPointInfo> getArPointInfosFromCurve(List<DataEyeGetPushTrajectory.PolynomialTrajectory> paramList, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return null;
  }
  
  public boolean getGridVisibility()
  {
    return this.grid.isVisible();
  }
  
  public Object3d getSingleArrow(String paramString, Number3d paramNumber3d1, Number3d paramNumber3d2, Number3d paramNumber3d3, Number3d paramNumber3d4)
  {
    return null;
  }
  
  public float getSkyLinePosOnScreen()
  {
    return 0.0F;
  }
  
  /* Error */
  public void init(Context arg1, float arg2, float arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
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
  public void moveCamera2(float arg1, float arg2, float arg3, float arg4, float arg5, float arg6)
  {
    // Byte code:
    //   0: return
    //   1: astore 7
    //   3: goto -3 -> 0
  }
  
  /* Error */
  public void moveCamera3(float arg1, float arg2, float arg3, float arg4, float arg5, float arg6)
  {
    // Byte code:
    //   0: return
    //   1: astore 7
    //   3: goto -3 -> 0
  }
  
  /* Error */
  public void moveCamera4(float arg1, float arg2, float arg3, float arg4, float arg5, float arg6)
  {
    // Byte code:
    //   0: return
    //   1: astore 7
    //   3: goto -3 -> 0
  }
  
  /* Error */
  public void moveCamera5(float arg1, float arg2, float arg3, float arg4, float arg5, float arg6)
  {
    // Byte code:
    //   0: return
    //   1: astore 7
    //   3: goto -3 -> 0
  }
  
  /* Error */
  @org.greenrobot.eventbus.Subscribe(threadMode=org.greenrobot.eventbus.ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(dji.logic.vision.DJITrajectoryHelper.TrajectoryEvent arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @org.greenrobot.eventbus.Subscribe(threadMode=org.greenrobot.eventbus.ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(dji.midware.data.model.P3.DataEyeGetPushUAVState arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setGridVisibility(boolean arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  public void setListener(ArDrawFlyControllerListener paramArDrawFlyControllerListener)
  {
    this.listener = paramArDrawFlyControllerListener;
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
  
  public static abstract interface ArDrawFlyControllerListener
  {
    public abstract void onSkyLineChange(float paramFloat);
    
    public abstract void onStripRearScreenCoorChange(boolean paramBoolean, float paramFloat1, float paramFloat2, float paramFloat3);
  }
  
  static class ArPointInfo
  {
    public float normalX;
    public float normalY;
    public float normalZ;
    public float posX;
    public float posY;
    public float posZ;
    
    public ArPointInfo() {}
    
    public ArPointInfo(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
    {
      this.posX = paramFloat2;
      this.posY = paramFloat1;
      this.posZ = (-paramFloat3);
      this.posZ = 0.0F;
      this.normalX = paramFloat5;
      this.normalY = paramFloat4;
      this.normalZ = (-paramFloat6);
      this.normalZ = 0.0F;
    }
    
    public Number3d getPos()
    {
      return null;
    }
    
    public String toString()
    {
      return null;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\midware\ar\ArDrawFlyController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */