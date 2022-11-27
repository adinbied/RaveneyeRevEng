package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataRcGetPushParams
  extends DataBase
{
  public static final int MAX_CHANNEL = 1684;
  public static final int MIDDLE_VALUE = 1024;
  public static final int MIN_CHANNEL = 364;
  private static DataRcGetPushParams instance;
  
  public DataRcGetPushParams() {}
  
  public DataRcGetPushParams(boolean paramBoolean)
  {
    super(paramBoolean);
  }
  
  public static DataRcGetPushParams getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataRcGetPushParams();
      }
      DataRcGetPushParams localDataRcGetPushParams = instance;
      return localDataRcGetPushParams;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public int getAileron()
  {
    return 0;
  }
  
  public int getBandWidth()
  {
    return 0;
  }
  
  public int getCustom1()
  {
    return 0;
  }
  
  public int getCustom2()
  {
    return 0;
  }
  
  public int getElevator()
  {
    return 0;
  }
  
  public boolean getFootStool()
  {
    return false;
  }
  
  public int getGyroValue()
  {
    return 0;
  }
  
  public int getMode()
  {
    return 0;
  }
  
  public boolean getPlayBackStatus()
  {
    return false;
  }
  
  public int getPlayback()
  {
    return 0;
  }
  
  public boolean getRecordStatus()
  {
    return false;
  }
  
  public byte[] getResource()
  {
    return this._recData;
  }
  
  public int getRudder()
  {
    return 0;
  }
  
  public boolean getShutterStatus()
  {
    return false;
  }
  
  public int getThrottle()
  {
    return 0;
  }
  
  public int getWheelClickStatus()
  {
    return 0;
  }
  
  public int getWheelOffset()
  {
    return 0;
  }
  
  public boolean isGettedGimbalControl()
  {
    return false;
  }
  
  public boolean isGoHomeButtonPressed()
  {
    return false;
  }
  
  public boolean isWheelBtnDown()
  {
    return false;
  }
  
  public boolean isWheelChanged()
  {
    return false;
  }
  
  public boolean isWheelPositive()
  {
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataRcGetPushParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */