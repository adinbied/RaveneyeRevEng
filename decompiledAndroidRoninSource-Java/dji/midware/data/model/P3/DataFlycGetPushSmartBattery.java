package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataFlycGetPushSmartBattery
  extends DataBase
{
  public static final int MaskBatteryCellError = 64;
  public static final int MaskBatteryCommunicateError = 128;
  public static final int MaskBatteryDangerous = 8192;
  public static final int MaskBatteryDangerousWarning = 16384;
  public static final int MaskBatteryFakeSingleBattery = 65536;
  public static final int MaskBatteryFirstChargeNotFull = 2048;
  public static final int MaskBatteryLimitOutputMax = 4096;
  public static final int MaskBatteryNotReady = 1024;
  public static final int MaskBatterySingleBattery = 32768;
  public static final int MaskBatteryTempVoltageLow = 512;
  public static final int MaskMainVoltageLowGoHOme = 16;
  public static final int MaskMainVoltageLowLand = 32;
  public static final int MaskSmartBatteryReqGoHome = 4;
  public static final int MaskSmartBatteryReqLand = 8;
  public static final int MaskUserBatteryReqGoHome = 1;
  public static final int MaskUserBatteryReqLand = 2;
  public static final int MaskVoltageLowNeedLand = 256;
  private static DataFlycGetPushSmartBattery instance;
  
  public DataFlycGetPushSmartBattery() {}
  
  public DataFlycGetPushSmartBattery(boolean paramBoolean)
  {
    super(paramBoolean);
  }
  
  public static DataFlycGetPushSmartBattery getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataFlycGetPushSmartBattery();
      }
      DataFlycGetPushSmartBattery localDataFlycGetPushSmartBattery = instance;
      return localDataFlycGetPushSmartBattery;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public int getBattery()
  {
    return 0;
  }
  
  public int getBatteryPercent()
  {
    return 0;
  }
  
  public int getGoHomeBattery()
  {
    return 0;
  }
  
  public int getGoHomeCountDown()
  {
    return 0;
  }
  
  public SmartGoHomeStatus getGoHomeStatus()
  {
    return null;
  }
  
  public int getGoHomeTime()
  {
    return 0;
  }
  
  public boolean getIsFakeSingleBatteryMode()
  {
    return false;
  }
  
  public boolean getIsSingleBatteryMode()
  {
    return false;
  }
  
  public int getLandBattery()
  {
    return 0;
  }
  
  public int getLandTime()
  {
    return 0;
  }
  
  public int getLowWarning()
  {
    return 0;
  }
  
  public boolean getLowWarningGoHome()
  {
    return false;
  }
  
  public float getSafeFlyRadius()
  {
    return 0.0F;
  }
  
  public int getSeriousLowWarning()
  {
    return 0;
  }
  
  public boolean getSeriousLowWarningLanding()
  {
    return false;
  }
  
  public int getStatus()
  {
    return 0;
  }
  
  public int getUsefulTime()
  {
    return 0;
  }
  
  public int getVoltage()
  {
    return 0;
  }
  
  public int getVoltagePercent()
  {
    return 0;
  }
  
  public float getVolumeComsume()
  {
    return 0.0F;
  }
  
  public static enum SmartGoHomeStatus
  {
    private byte _value = 0;
    
    static
    {
      GOHOME = new SmartGoHomeStatus("GOHOME", 1, (byte)1);
      SmartGoHomeStatus localSmartGoHomeStatus = new SmartGoHomeStatus("GOHOME_ALREADY", 2, (byte)2);
      GOHOME_ALREADY = localSmartGoHomeStatus;
      $VALUES = new SmartGoHomeStatus[] { NON_GOHOME, GOHOME, localSmartGoHomeStatus };
    }
    
    private SmartGoHomeStatus(byte paramByte)
    {
      this._value = paramByte;
    }
    
    public static SmartGoHomeStatus find(byte paramByte)
    {
      SmartGoHomeStatus[] arrayOfSmartGoHomeStatus = values();
      int j = arrayOfSmartGoHomeStatus.length;
      int i = 0;
      while (i < j)
      {
        SmartGoHomeStatus localSmartGoHomeStatus = arrayOfSmartGoHomeStatus[i];
        if (localSmartGoHomeStatus._equals(paramByte)) {
          return localSmartGoHomeStatus;
        }
        i += 1;
      }
      return NON_GOHOME;
    }
    
    public boolean _equals(byte paramByte)
    {
      return this._value == paramByte;
    }
    
    public final byte value()
    {
      return this._value;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataFlycGetPushSmartBattery.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */