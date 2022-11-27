package dji.midware.media.newframing;

import androidx.core.util.Pools.SynchronizedPool;
import com.dji.dynamic_assets.DynamicAssetsHelper;
import com.dji.video.framing.internal.decoder.common.FrameFovType;
import com.dji.video.framing.internal.opengl.renderer.GLIdentityRender;
import dji.log.DJILog;
import dji.midware.data.model.P3.DataCameraGetPushStateInfo.CameraType;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.CountDownLatch;

public class DistortionCorrectionRender
  extends GLIdentityRender
{
  private static final int BLOCK_HEIGHT = 8;
  private static final int BLOCK_WIDTH = 8;
  private static final boolean DEBUG = false;
  private static final int LUT_ASYNC_PARSE_WAIT_NUM = 2;
  private static final String LUT_DIR_NAME = "distrotion_correction";
  private static final int LUT_SYNC_PARSE_MAX_NUM = 1;
  private static final int MAX_LUT_NUM = 64;
  private static final int[] RENDER_ORDER = { 0, 1, 2, 2, 1, 3 };
  private DataCameraGetPushStateInfo.CameraType cameraType = DataCameraGetPushStateInfo.CameraType.OTHER;
  private boolean enableAntiDistortion = true;
  private FrameFovType fovType = FrameFovType.NoGdc;
  private int height = 0;
  private String lutRootDirPath;
  private int[] originVerticeIndicesData = this.mTriangleIndicesData;
  private float[] originVerticePosData = this.mTriangleVerticesPosData;
  private float[] originVerticeUvData = this.mTriangleVerticesUvData;
  private CountDownLatch parseLutCdl;
  private final Pools.SynchronizedPool<ParseLutTask> parseLutTaskPool = new Pools.SynchronizedPool(64);
  private Object updateFrameInfoLock = new Object();
  private ArrayList<float[]> uvDataList = new ArrayList(64);
  private int width = 0;
  private int zoomIndex = -1;
  
  public DistortionCorrectionRender(boolean paramBoolean)
  {
    super(paramBoolean);
    int i = 0;
    while (i < 64)
    {
      this.uvDataList.add(null);
      i += 1;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(DynamicAssetsHelper.getInternalPath());
    localStringBuilder.append("/");
    localStringBuilder.append("distrotion_correction");
    this.lutRootDirPath = localStringBuilder.toString();
    DJILog.d(TAG, "create DistortionCorrectionRender", new Object[0]);
  }
  
  private boolean checkUvDataList()
  {
    return false;
  }
  
  private boolean checkVerticePosAndUv(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, int[] paramArrayOfInt)
  {
    return (paramArrayOfFloat1 != null) && (paramArrayOfFloat2 != null) && (paramArrayOfInt != null) && (paramArrayOfFloat1.length / 3 == paramArrayOfFloat2.length / 2);
  }
  
  private void clearUvDataList()
  {
    Collections.fill(this.uvDataList, null);
  }
  
  private int[] genVerticesIndices(int paramInt1, int paramInt2)
  {
    return null;
  }
  
  private float[] genVerticesPos(int paramInt1, int paramInt2)
  {
    return null;
  }
  
  private String getHexString(byte paramByte)
  {
    return Integer.toHexString(paramByte & 0xFF);
  }
  
  private String getHexString(int paramInt)
  {
    return Integer.toHexString(paramInt & 0xFFFFFFFF);
  }
  
  private String getHexString(short paramShort)
  {
    return null;
  }
  
  private float[] getLut(File paramFile, int paramInt1, int paramInt2)
    throws IOException
  {
    return null;
  }
  
  private String getLutDir(String paramString, int paramInt1, int paramInt2, FrameFovType paramFrameFovType)
  {
    return null;
  }
  
  private String getLutFileName(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    return null;
  }
  
  private int getLutNum(DataCameraGetPushStateInfo.CameraType paramCameraType)
  {
    return 0;
  }
  
  private String getSensorName(DataCameraGetPushStateInfo.CameraType paramCameraType)
  {
    return null;
  }
  
  /* Error */
  private void logd(String arg1, String arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private boolean needCheckFrameFov(int paramInt1, int paramInt2)
  {
    return false;
  }
  
  private ParseLutTask obtainParseLutTask(File paramFile, int paramInt1, int paramInt2)
  {
    return null;
  }
  
  private boolean resetVertice()
  {
    return false;
  }
  
  /* Error */
  private void updateUvDataList(String arg1, int arg2, int arg3, String arg4, int arg5, int arg6)
    throws IOException, java.lang.RuntimeException, java.lang.InterruptedException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void init()
  {
    super.init();
  }
  
  public void setEnableAntiDistortion(boolean paramBoolean)
  {
    this.enableAntiDistortion = paramBoolean;
  }
  
  /* Error */
  public void updateFrameInfo(DataCameraGetPushStateInfo.CameraType arg1, int arg2, int arg3, int arg4, FrameFovType arg5)
  {
    // Byte code:
    //   0: goto +6 -> 6
    //   3: return
    //   4: astore_1
    //   5: return
    //   6: goto -3 -> 3
  }
  
  private class ParseLutTask
    implements Runnable
  {
    private int height;
    private File lutFile;
    private int width;
    
    private ParseLutTask(File paramFile, int paramInt1, int paramInt2)
    {
      update(paramFile, paramInt1, paramInt2);
    }
    
    /* Error */
    private void recycle()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    private void update(File paramFile, int paramInt1, int paramInt2)
    {
      this.lutFile = paramFile;
      this.width = paramInt1;
      this.height = paramInt2;
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\media\newframing\DistortionCorrectionRender.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */