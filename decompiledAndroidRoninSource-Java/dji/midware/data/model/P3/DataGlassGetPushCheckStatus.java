package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataGlassGetPushCheckStatus
  extends DataBase
{
  private static DataGlassGetPushCheckStatus instance;
  
  private DataGlassGetPushCheckStatus()
  {
    this.isNeedPushLosed = true;
    this.isRemoteModel = true;
  }
  
  public static DataGlassGetPushCheckStatus getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataGlassGetPushCheckStatus();
      }
      DataGlassGetPushCheckStatus localDataGlassGetPushCheckStatus = instance;
      return localDataGlassGetPushCheckStatus;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  protected void setPushLose()
  {
    this.isPushLosed = true;
    post();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataGlassGetPushCheckStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */