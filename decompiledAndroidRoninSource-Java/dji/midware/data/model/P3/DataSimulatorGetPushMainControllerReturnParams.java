package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataSimulatorGetPushMainControllerReturnParams
  extends DataBase
{
  private static DataSimulatorGetPushMainControllerReturnParams instance;
  
  public static DataSimulatorGetPushMainControllerReturnParams getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataSimulatorGetPushMainControllerReturnParams();
      }
      DataSimulatorGetPushMainControllerReturnParams localDataSimulatorGetPushMainControllerReturnParams = instance;
      return localDataSimulatorGetPushMainControllerReturnParams;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public int getDroneType()
  {
    return 0;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataSimulatorGetPushMainControllerReturnParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */