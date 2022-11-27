package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataFlycPushForbidDataInfos
  extends DataBase
{
  private static DataFlycPushForbidDataInfos instance;
  
  private DataFlycPushForbidDataInfos()
  {
    this.isNeedPushLosed = true;
    this.delayPushLoseTime = 10000;
  }
  
  private String addZero(int paramInt)
  {
    return null;
  }
  
  public static DataFlycPushForbidDataInfos getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataFlycPushForbidDataInfos();
      }
      DataFlycPushForbidDataInfos localDataFlycPushForbidDataInfos = instance;
      return localDataFlycPushForbidDataInfos;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public int getTimeStamp()
  {
    return 0;
  }
  
  public String getVersion()
  {
    return null;
  }
  
  protected boolean isChanged(byte[] paramArrayOfByte)
  {
    return true;
  }
  
  public boolean isSupportDynamicUpdate()
  {
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataFlycPushForbidDataInfos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */