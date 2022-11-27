package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataFlycGetPushBoardRecv
  extends DataBase
{
  private static DataFlycGetPushBoardRecv instance;
  
  public static DataFlycGetPushBoardRecv getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataFlycGetPushBoardRecv();
      }
      DataFlycGetPushBoardRecv localDataFlycGetPushBoardRecv = instance;
      return localDataFlycGetPushBoardRecv;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public byte[] getRecvData()
  {
    return this._recData;
  }
  
  protected boolean isChanged(byte[] paramArrayOfByte)
  {
    return true;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataFlycGetPushBoardRecv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */