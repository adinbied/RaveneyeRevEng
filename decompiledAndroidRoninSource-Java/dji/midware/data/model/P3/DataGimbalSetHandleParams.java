package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataGimbalSetHandleParams
  extends DataBase
  implements DJIDataSyncListener
{
  int mCellphoneSensorDisable = 255;
  int mJoystickDualChannelEnable = 255;
  int mPanDirection = 255;
  int mPitchFree = 255;
  int mProfile = 255;
  int mRotationFocusEnable = 255;
  int mTiltDirection = 255;
  int mZoom2Speed = 255;
  
  /* Error */
  private void reset()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void doPack()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public DataGimbalSetHandleParams setCellphoneSensorDisable(int paramInt)
  {
    this.mCellphoneSensorDisable = paramInt;
    return this;
  }
  
  public DataGimbalSetHandleParams setDualChannelEnable(int paramInt)
  {
    this.mJoystickDualChannelEnable = paramInt;
    return this;
  }
  
  public DataGimbalSetHandleParams setPanDirection(int paramInt)
  {
    this.mPanDirection = paramInt;
    return this;
  }
  
  public DataGimbalSetHandleParams setPitchFree(int paramInt)
  {
    this.mPitchFree = paramInt;
    return this;
  }
  
  public DataGimbalSetHandleParams setProfile(int paramInt)
  {
    this.mProfile = paramInt;
    return this;
  }
  
  public DataGimbalSetHandleParams setRotationFocusEnable(int paramInt)
  {
    this.mRotationFocusEnable = paramInt;
    return this;
  }
  
  public DataGimbalSetHandleParams setTiltDirection(int paramInt)
  {
    this.mTiltDirection = paramInt;
    return this;
  }
  
  public DataGimbalSetHandleParams setZoom2Speed(int paramInt)
  {
    this.mZoom2Speed = paramInt;
    return this;
  }
  
  /* Error */
  public void start(dji.midware.interfaces.DJIDataCallBack arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataGimbalSetHandleParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */