package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataEyeGetPushFunctionList
  extends DataBase
{
  private static DataEyeGetPushFunctionList instance;
  
  public static DataEyeGetPushFunctionList getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataEyeGetPushFunctionList();
      }
      DataEyeGetPushFunctionList localDataEyeGetPushFunctionList = instance;
      return localDataEyeGetPushFunctionList;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public int getTinkCount()
  {
    return 0;
  }
  
  public boolean isBackAttiTooLarge()
  {
    return false;
  }
  
  public boolean isBackDisable()
  {
    return false;
  }
  
  public boolean isBackDisableBySwitchSensor()
  {
    return false;
  }
  
  public boolean isBackDisableByTripod()
  {
    return false;
  }
  
  public boolean isBackDisableWhenAutoLanding()
  {
    return false;
  }
  
  public boolean isFrontAttiTooLarge()
  {
    return false;
  }
  
  public boolean isFrontDisable()
  {
    return false;
  }
  
  public boolean isFrontDisableBySwitchSensor()
  {
    return false;
  }
  
  public boolean isFrontDisableByTripod()
  {
    return false;
  }
  
  public boolean isFrontDisableWhenAutoLanding()
  {
    return false;
  }
  
  public boolean isLeftAttiTooLarge()
  {
    return false;
  }
  
  public boolean isLeftDisable()
  {
    return false;
  }
  
  public boolean isLeftDisableByTripod()
  {
    return false;
  }
  
  public boolean isLeftDisableWhenAutoLanding()
  {
    return false;
  }
  
  public boolean isRightAttiTooLarge()
  {
    return false;
  }
  
  public boolean isRightDisable()
  {
    return false;
  }
  
  public boolean isRightDisableByTripod()
  {
    return false;
  }
  
  public boolean isRightDisableWhenAutoLanding()
  {
    return false;
  }
  
  public boolean sensorStatusSource()
  {
    return false;
  }
  
  public boolean supportSelfCal()
  {
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataEyeGetPushFunctionList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */