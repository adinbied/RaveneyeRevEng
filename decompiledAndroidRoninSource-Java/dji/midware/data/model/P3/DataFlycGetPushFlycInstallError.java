package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataFlycGetPushFlycInstallError
  extends DataBase
{
  private static DataFlycGetPushFlycInstallError ourInstance = new DataFlycGetPushFlycInstallError();
  
  public static DataFlycGetPushFlycInstallError getInstance()
  {
    return ourInstance;
  }
  
  protected void doPack() {}
  
  public int getAccXInstallErrorLevel()
  {
    return 0;
  }
  
  public int getAccYInstallErrorLevel()
  {
    return 0;
  }
  
  public int getAccZInstallErrorLevel()
  {
    return 0;
  }
  
  public int getGyroXInstallErrorLevel()
  {
    return 0;
  }
  
  public int getGyroYInstallErrorLevel()
  {
    return 0;
  }
  
  public int getGyroZInstallErrorLevel()
  {
    return 0;
  }
  
  public int getPitchInstallErrorLevel()
  {
    return 0;
  }
  
  public int getRollInstallErrorLevel()
  {
    return 0;
  }
  
  public int getThrustInstallErrorLevel()
  {
    return 0;
  }
  
  public int getYawInstallErrorLevel()
  {
    return 0;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataFlycGetPushFlycInstallError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */