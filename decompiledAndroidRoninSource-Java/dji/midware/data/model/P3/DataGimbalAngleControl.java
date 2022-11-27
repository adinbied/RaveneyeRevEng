package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataGimbalAngleControl
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataGimbalAngleControl instance;
  private boolean absolute;
  private short allowDeviation = 300;
  private boolean mIsPitchCtrlIsValid = true;
  private boolean mIsRollCtrlIsValid = true;
  private boolean mIsYawCtrlIsValid = true;
  private int overtime;
  private boolean permission;
  private short pitchAngle;
  private boolean reference;
  private short rollAngle;
  private short yawAngle;
  
  public static DataGimbalAngleControl getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataGimbalAngleControl();
      }
      DataGimbalAngleControl localDataGimbalAngleControl = instance;
      return localDataGimbalAngleControl;
    }
    finally {}
  }
  
  /* Error */
  protected void doPack()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public DataGimbalAngleControl setAbsolute(boolean paramBoolean)
  {
    this.absolute = paramBoolean;
    return this;
  }
  
  public DataGimbalAngleControl setOvertime(int paramInt)
  {
    this.overtime = paramInt;
    return this;
  }
  
  public DataGimbalAngleControl setPermission(boolean paramBoolean)
  {
    this.permission = paramBoolean;
    return this;
  }
  
  public DataGimbalAngleControl setPitch(short paramShort)
  {
    this.pitchAngle = paramShort;
    return this;
  }
  
  public DataGimbalAngleControl setPitchCtrlIsValid(boolean paramBoolean)
  {
    this.mIsPitchCtrlIsValid = paramBoolean;
    return this;
  }
  
  public DataGimbalAngleControl setReference(boolean paramBoolean)
  {
    this.reference = paramBoolean;
    return this;
  }
  
  public DataGimbalAngleControl setRoll(short paramShort)
  {
    this.rollAngle = paramShort;
    return this;
  }
  
  public DataGimbalAngleControl setRollCtrlIsValid(boolean paramBoolean)
  {
    this.mIsRollCtrlIsValid = paramBoolean;
    return this;
  }
  
  public DataGimbalAngleControl setYaw(short paramShort)
  {
    this.yawAngle = paramShort;
    return this;
  }
  
  public DataGimbalAngleControl setYawCtrlIsValid(boolean paramBoolean)
  {
    this.mIsYawCtrlIsValid = paramBoolean;
    return this;
  }
  
  /* Error */
  public void start()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataGimbalAngleControl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */