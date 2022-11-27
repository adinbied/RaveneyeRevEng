package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataSimulatorGetPushFlightStatusParams
  extends DataBase
{
  private static DataSimulatorGetPushFlightStatusParams instance;
  
  public static DataSimulatorGetPushFlightStatusParams getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataSimulatorGetPushFlightStatusParams();
      }
      DataSimulatorGetPushFlightStatusParams localDataSimulatorGetPushFlightStatusParams = instance;
      return localDataSimulatorGetPushFlightStatusParams;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public int getLength()
  {
    return 0;
  }
  
  public byte[] getResult()
  {
    return this._recData;
  }
  
  public boolean hasMotorTurnedOn()
  {
    return false;
  }
  
  protected boolean isChanged(byte[] paramArrayOfByte)
  {
    return true;
  }
  
  public boolean isInTheAir()
  {
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataSimulatorGetPushFlightStatusParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */