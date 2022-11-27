package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataGimbalAbsAngleControl
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataGimbalAbsAngleControl instance;
  private boolean PitchInvalid;
  private boolean RollInvalid;
  private boolean YawInvalid;
  private boolean controlMode;
  private int overtime = 10;
  private short pitchAngle;
  private short rollAngle;
  private short yawAngle;
  
  public static DataGimbalAbsAngleControl getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataGimbalAbsAngleControl();
      }
      DataGimbalAbsAngleControl localDataGimbalAbsAngleControl = instance;
      return localDataGimbalAbsAngleControl;
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
  
  public DataGimbalAbsAngleControl setControlMode(boolean paramBoolean)
  {
    this.controlMode = paramBoolean;
    return this;
  }
  
  public DataGimbalAbsAngleControl setOvertime(int paramInt)
  {
    this.overtime = paramInt;
    return this;
  }
  
  public DataGimbalAbsAngleControl setPitch(short paramShort)
  {
    this.pitchAngle = paramShort;
    return this;
  }
  
  public DataGimbalAbsAngleControl setPitchInvalid(boolean paramBoolean)
  {
    this.PitchInvalid = paramBoolean;
    return this;
  }
  
  public DataGimbalAbsAngleControl setRoll(short paramShort)
  {
    this.rollAngle = paramShort;
    return this;
  }
  
  public DataGimbalAbsAngleControl setRollInvalid(boolean paramBoolean)
  {
    this.RollInvalid = paramBoolean;
    return this;
  }
  
  public DataGimbalAbsAngleControl setYaw(short paramShort)
  {
    this.yawAngle = paramShort;
    return this;
  }
  
  public DataGimbalAbsAngleControl setYawInvalid(boolean paramBoolean)
  {
    this.YawInvalid = paramBoolean;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataGimbalAbsAngleControl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */