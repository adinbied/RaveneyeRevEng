package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataGimbalGetPushAbnormalStatus
  extends DataBase
{
  private static DataGimbalGetPushAbnormalStatus instance;
  
  public static DataGimbalGetPushAbnormalStatus getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataGimbalGetPushAbnormalStatus();
      }
      DataGimbalGetPushAbnormalStatus localDataGimbalGetPushAbnormalStatus = instance;
      return localDataGimbalGetPushAbnormalStatus;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public int getFanDirection()
  {
    return 0;
  }
  
  public int getGimbalDirectionWhenVertical()
  {
    return 0;
  }
  
  public int getGimbalGravity()
  {
    return 0;
  }
  
  public int getSleepMode()
  {
    return 0;
  }
  
  public int getVerticalDirection()
  {
    return 0;
  }
  
  public boolean isErrorRecentOrSelfie()
  {
    return false;
  }
  
  public boolean isErrorRecentWhenStartUp()
  {
    return false;
  }
  
  public boolean isGimbalLocked()
  {
    return false;
  }
  
  public boolean isInFlashlight()
  {
    return false;
  }
  
  public boolean isJointLockAfterStartup()
  {
    return false;
  }
  
  public boolean isJointLockWhenStartup()
  {
    return false;
  }
  
  public boolean isMotorProtected()
  {
    return false;
  }
  
  public boolean isPanoReady()
  {
    return false;
  }
  
  public boolean isPhoneOutGimbal()
  {
    return false;
  }
  
  public boolean isPitchLimitedInTracking()
  {
    return false;
  }
  
  public boolean isPitchLocked()
  {
    return false;
  }
  
  public boolean isPortrait()
  {
    return false;
  }
  
  public boolean isRollLocked()
  {
    return false;
  }
  
  public boolean isUpgrading()
  {
    return false;
  }
  
  public boolean isYawLimit()
  {
    return false;
  }
  
  public boolean isYawLimitedInTracking()
  {
    return false;
  }
  
  public boolean isYawLocked()
  {
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataGimbalGetPushAbnormalStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */