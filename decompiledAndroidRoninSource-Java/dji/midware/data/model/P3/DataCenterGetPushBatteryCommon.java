package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataCenterGetPushBatteryCommon
  extends DataBase
{
  private static final int FLAG_DAY = 31;
  private static final int FLAG_MONTH = 480;
  private static final int FLAG_YEAR = 65024;
  private static final String TAG = "CenterGetPushBattery";
  private static DataCenterGetPushBatteryCommon instance;
  private final int[] mPartVoltages = new int[6];
  private final int[] mProductDate = { 2013, 1, 1 };
  
  public DataCenterGetPushBatteryCommon() {}
  
  public DataCenterGetPushBatteryCommon(boolean paramBoolean)
  {
    super(paramBoolean);
  }
  
  public static DataCenterGetPushBatteryCommon getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataCenterGetPushBatteryCommon();
      }
      DataCenterGetPushBatteryCommon localDataCenterGetPushBatteryCommon = instance;
      return localDataCenterGetPushBatteryCommon;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public boolean getChargingStatus()
  {
    return false;
  }
  
  public ConnStatus getConnStatus()
  {
    return null;
  }
  
  public int getCurrent()
  {
    return 0;
  }
  
  public int getCurrentCapacity()
  {
    return 0;
  }
  
  public int getCurrentPV()
  {
    return 0;
  }
  
  public int getErrorType()
  {
    return 0;
  }
  
  public int getFullCapacity()
  {
    return 0;
  }
  
  public int getLife()
  {
    return 0;
  }
  
  public int getLoopNum()
  {
    return 0;
  }
  
  public int[] getPartVoltages()
  {
    return null;
  }
  
  public int[] getProductDate()
  {
    return null;
  }
  
  public int getRelativeCapacity()
  {
    return 0;
  }
  
  public int getSerialNo()
  {
    return 0;
  }
  
  public int getTemperature()
  {
    return 0;
  }
  
  public boolean isBatteryOnCharge()
  {
    return false;
  }
  
  public boolean isNeedStudy()
  {
    return false;
  }
  
  public int lastStudyCycle()
  {
    return 0;
  }
  
  public int totalStudyCycle()
  {
    return 0;
  }
  
  public static enum ConnStatus
  {
    private int mData = 0;
    
    static
    {
      INVALID = new ConnStatus("INVALID", 1, 1);
      EXCEPTION = new ConnStatus("EXCEPTION", 2, 2);
      ConnStatus localConnStatus = new ConnStatus("OTHER", 3, 100);
      OTHER = localConnStatus;
      $VALUES = new ConnStatus[] { NORMAL, INVALID, EXCEPTION, localConnStatus };
    }
    
    private ConnStatus(int paramInt)
    {
      this.mData = paramInt;
    }
    
    private boolean belongsTo(int paramInt)
    {
      return this.mData == paramInt;
    }
    
    public static ConnStatus ofData(int paramInt)
    {
      ConnStatus[] arrayOfConnStatus = values();
      int j = arrayOfConnStatus.length;
      int i = 0;
      while (i < j)
      {
        ConnStatus localConnStatus = arrayOfConnStatus[i];
        if (localConnStatus.belongsTo(paramInt)) {
          return localConnStatus;
        }
        i += 1;
      }
      return OTHER;
    }
    
    public int value()
    {
      return this.mData;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCenterGetPushBatteryCommon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */