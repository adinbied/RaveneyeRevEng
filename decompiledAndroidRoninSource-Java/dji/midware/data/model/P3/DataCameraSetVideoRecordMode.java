package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataCallBack;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataCameraSetVideoRecordMode
  extends DataBase
  implements DJIDataSyncListener
{
  private int mDuration = 0;
  private int mGimbalIndex = 0;
  private int mInterval = 0;
  private int mMode = 0;
  int mPitchAngle = 0;
  int mRollAngle = 0;
  private int mTimelapseControlMode = 0;
  private int mTimelapseSaveType = 0;
  int mYawAngle = 0;
  
  /* Error */
  protected void doPack()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public DataCameraSetVideoRecordMode setDuration(int paramInt)
  {
    this.mDuration = paramInt;
    return this;
  }
  
  public DataCameraSetVideoRecordMode setGimbalIndex(int paramInt)
  {
    this.mGimbalIndex = paramInt;
    return this;
  }
  
  public DataCameraSetVideoRecordMode setInterval(int paramInt)
  {
    this.mInterval = paramInt;
    return this;
  }
  
  public DataCameraSetVideoRecordMode setPitchAngle(int paramInt)
  {
    this.mPitchAngle = paramInt;
    return this;
  }
  
  public DataCameraSetVideoRecordMode setRollAngle(int paramInt)
  {
    this.mRollAngle = paramInt;
    return this;
  }
  
  public DataCameraSetVideoRecordMode setTimelapseControlMode(int paramInt)
  {
    this.mTimelapseControlMode = paramInt;
    return this;
  }
  
  public DataCameraSetVideoRecordMode setTimelapseSaveType(int paramInt)
  {
    this.mTimelapseSaveType = paramInt;
    return this;
  }
  
  public DataCameraSetVideoRecordMode setVideoRecordMode(int paramInt1, int paramInt2, int paramInt3)
  {
    this.mMode = paramInt1;
    this.mInterval = paramInt2;
    this.mDuration = paramInt3;
    return this;
  }
  
  public DataCameraSetVideoRecordMode setYawAngle(int paramInt)
  {
    this.mYawAngle = paramInt;
    return this;
  }
  
  public void start(DJIDataCallBack paramDJIDataCallBack)
  {
    start(paramDJIDataCallBack, 200, 3);
  }
  
  /* Error */
  public void start(DJIDataCallBack arg1, int arg2, int arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCameraSetVideoRecordMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */