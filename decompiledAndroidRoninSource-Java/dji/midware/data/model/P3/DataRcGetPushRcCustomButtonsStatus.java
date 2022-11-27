package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataRcGetPushRcCustomButtonsStatus
  extends DataBase
{
  private static DataRcGetPushRcCustomButtonsStatus instance;
  
  public static DataRcGetPushRcCustomButtonsStatus getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataRcGetPushRcCustomButtonsStatus();
      }
      DataRcGetPushRcCustomButtonsStatus localDataRcGetPushRcCustomButtonsStatus = instance;
      return localDataRcGetPushRcCustomButtonsStatus;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public int gets()
  {
    return 0;
  }
  
  public boolean isC1Pressed()
  {
    return false;
  }
  
  public boolean isC2Pressed()
  {
    return false;
  }
  
  public boolean isDown()
  {
    return false;
  }
  
  public boolean isLeft()
  {
    return false;
  }
  
  public boolean isPressed()
  {
    return false;
  }
  
  public boolean isRight()
  {
    return false;
  }
  
  public boolean isUp()
  {
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataRcGetPushRcCustomButtonsStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */