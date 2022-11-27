package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataSimulatorSimulateFlightCommend
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataSimulatorSimulateFlightCommend instance;
  private double altitude;
  private int byte1st = 128;
  private int byte2nd = 64;
  private int byte3rd = 32;
  private int byte4th = 16;
  private int byte5th = 8;
  private int byte6th = 4;
  private int byte7th = 2;
  private int byte8th = 1;
  private int gpsCount;
  private int hz;
  private double latitude;
  private double longitude;
  private int remoteControl;
  private int simulatorSwitch;
  private int status1;
  private int status2;
  private int status3;
  private int status4;
  
  private double Degree(double paramDouble)
  {
    return 4.9735319E-315D;
  }
  
  private double Radian(double paramDouble)
  {
    return 4.973531903E-315D;
  }
  
  public static DataSimulatorSimulateFlightCommend getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataSimulatorSimulateFlightCommend();
      }
      DataSimulatorSimulateFlightCommend localDataSimulatorSimulateFlightCommend = instance;
      return localDataSimulatorSimulateFlightCommend;
    }
    finally {}
  }
  
  public DataSimulatorSimulateFlightCommend closeSimulator()
  {
    this.simulatorSwitch = 2;
    return this;
  }
  
  /* Error */
  protected void doPack()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public int getResult()
  {
    return 0;
  }
  
  public DataSimulatorSimulateFlightCommend openSimulator()
  {
    this.simulatorSwitch = 0;
    return this;
  }
  
  public DataSimulatorSimulateFlightCommend setAccelerateX(boolean paramBoolean)
  {
    return null;
  }
  
  public DataSimulatorSimulateFlightCommend setAccelerateY(boolean paramBoolean)
  {
    return null;
  }
  
  public DataSimulatorSimulateFlightCommend setAccelerateZ(boolean paramBoolean)
  {
    return null;
  }
  
  public DataSimulatorSimulateFlightCommend setAltitude(double paramDouble)
  {
    this.altitude = (paramDouble * 1.0D);
    return this;
  }
  
  public DataSimulatorSimulateFlightCommend setBatterySim(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.remoteControl |= 0x4;
      return this;
    }
    this.remoteControl |= 0x0;
    return this;
  }
  
  public DataSimulatorSimulateFlightCommend setGearState(boolean paramBoolean)
  {
    return null;
  }
  
  public DataSimulatorSimulateFlightCommend setGpsCount(int paramInt)
  {
    this.gpsCount = paramInt;
    return this;
  }
  
  public DataSimulatorSimulateFlightCommend setGyroX(boolean paramBoolean)
  {
    return null;
  }
  
  public DataSimulatorSimulateFlightCommend setGyroY(boolean paramBoolean)
  {
    return null;
  }
  
  public DataSimulatorSimulateFlightCommend setGyroZ(boolean paramBoolean)
  {
    return null;
  }
  
  public DataSimulatorSimulateFlightCommend setHz(int paramInt)
  {
    this.hz = paramInt;
    return this;
  }
  
  public DataSimulatorSimulateFlightCommend setLEDColor(boolean paramBoolean)
  {
    return null;
  }
  
  public DataSimulatorSimulateFlightCommend setLatitude(double paramDouble)
  {
    this.latitude = Radian(paramDouble);
    return this;
  }
  
  public DataSimulatorSimulateFlightCommend setLatitude(boolean paramBoolean)
  {
    return null;
  }
  
  public DataSimulatorSimulateFlightCommend setLongitude(double paramDouble)
  {
    this.longitude = Radian(paramDouble);
    return this;
  }
  
  public DataSimulatorSimulateFlightCommend setLongitude(boolean paramBoolean)
  {
    return null;
  }
  
  public DataSimulatorSimulateFlightCommend setPitch(boolean paramBoolean)
  {
    return null;
  }
  
  public DataSimulatorSimulateFlightCommend setPositionX(boolean paramBoolean)
  {
    return null;
  }
  
  public DataSimulatorSimulateFlightCommend setPositionY(boolean paramBoolean)
  {
    return null;
  }
  
  public DataSimulatorSimulateFlightCommend setPositionZ(boolean paramBoolean)
  {
    return null;
  }
  
  public DataSimulatorSimulateFlightCommend setQuaternion(boolean paramBoolean)
  {
    return null;
  }
  
  public DataSimulatorSimulateFlightCommend setRoll(boolean paramBoolean)
  {
    return null;
  }
  
  public DataSimulatorSimulateFlightCommend setRpm1(boolean paramBoolean)
  {
    return null;
  }
  
  public DataSimulatorSimulateFlightCommend setRpm2(boolean paramBoolean)
  {
    return null;
  }
  
  public DataSimulatorSimulateFlightCommend setRpm3(boolean paramBoolean)
  {
    return null;
  }
  
  public DataSimulatorSimulateFlightCommend setRpm4(boolean paramBoolean)
  {
    return null;
  }
  
  public DataSimulatorSimulateFlightCommend setRpm5(boolean paramBoolean)
  {
    return null;
  }
  
  public DataSimulatorSimulateFlightCommend setRpm6(boolean paramBoolean)
  {
    return null;
  }
  
  public DataSimulatorSimulateFlightCommend setRpm7(boolean paramBoolean)
  {
    return null;
  }
  
  public DataSimulatorSimulateFlightCommend setRpm8(boolean paramBoolean)
  {
    return null;
  }
  
  public DataSimulatorSimulateFlightCommend setSimulateTime(boolean paramBoolean)
  {
    return null;
  }
  
  public DataSimulatorSimulateFlightCommend setUseRC(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.remoteControl |= 0x1;
      return this;
    }
    this.remoteControl |= 0x0;
    return this;
  }
  
  public DataSimulatorSimulateFlightCommend setUseThird(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.remoteControl |= 0x2;
      return this;
    }
    this.remoteControl |= 0x0;
    return this;
  }
  
  public DataSimulatorSimulateFlightCommend setVelocityX(boolean paramBoolean)
  {
    return null;
  }
  
  public DataSimulatorSimulateFlightCommend setVelocityY(boolean paramBoolean)
  {
    return null;
  }
  
  public DataSimulatorSimulateFlightCommend setVelocityZ(boolean paramBoolean)
  {
    return null;
  }
  
  public DataSimulatorSimulateFlightCommend setYaw(boolean paramBoolean)
  {
    return null;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataSimulatorSimulateFlightCommend.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */