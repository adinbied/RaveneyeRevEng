package dji.midware.data.model.P3;

import dji.midware.data.model.base.DJICameraDataBase;
import dji.midware.data.model.hg702.CameraType;
import dji.midware.data.model.hg702.CaptureStatus;
import dji.midware.data.model.hg702.EVMode;
import dji.midware.data.model.hg702.LineType;

public class DataThirdPartyCameraParamPush
  extends DJICameraDataBase
{
  private static final int GIMBAL_SENDER_ID = 0;
  private static final int MONITOR_SENDER_ID = 6;
  private static final String TAG = "CameraParamPush";
  private int mAperture;
  private CameraType mCameraType = CameraType.OTHER;
  private CaptureStatus mCaptureStatus;
  private int mEv;
  private EVMode mEvMode;
  private int mFocusRank;
  private boolean mGimbalPushValid;
  private int mISO;
  private LineType mLineType;
  private boolean mMonitorPushValid;
  private int mShutter;
  private int mZoomRank;
  
  public DataThirdPartyCameraParamPush()
  {
    this.isNeedPushLosed = true;
    setPushLose(0);
    setPushLose(6);
  }
  
  public static DataThirdPartyCameraParamPush getInstance()
  {
    return SingletonHolder.mInstance;
  }
  
  protected void doPack() {}
  
  public int getAperture()
  {
    return this.mAperture;
  }
  
  public CameraType getCameraType()
  {
    return this.mCameraType;
  }
  
  public CaptureStatus getCaptureStatus()
  {
    return this.mCaptureStatus;
  }
  
  public int getEv()
  {
    return this.mEv;
  }
  
  public EVMode getEvMode()
  {
    return this.mEvMode;
  }
  
  public int getFocusRank()
  {
    return this.mFocusRank;
  }
  
  public int getISO()
  {
    return this.mISO;
  }
  
  public LineType getLineType()
  {
    return this.mLineType;
  }
  
  public int getSenderType()
  {
    return 0;
  }
  
  public int getShutter()
  {
    return this.mShutter;
  }
  
  public int getZoomRank()
  {
    return this.mZoomRank;
  }
  
  protected boolean isChanged(byte[] paramArrayOfByte)
  {
    return true;
  }
  
  public boolean isGimbalPushValid()
  {
    return this.mGimbalPushValid;
  }
  
  public boolean isMonitorPushValid()
  {
    return this.mMonitorPushValid;
  }
  
  /* Error */
  protected void setPushRecData(byte[] arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private static final class SingletonHolder
  {
    private static final DataThirdPartyCameraParamPush mInstance = new DataThirdPartyCameraParamPush();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataThirdPartyCameraParamPush.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */