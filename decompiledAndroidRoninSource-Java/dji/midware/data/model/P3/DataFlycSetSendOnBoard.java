package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataFlycSetSendOnBoard
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataFlycSetSendOnBoard instance;
  private byte[] data;
  
  public static DataFlycSetSendOnBoard getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataFlycSetSendOnBoard();
      }
      DataFlycSetSendOnBoard localDataFlycSetSendOnBoard = instance;
      return localDataFlycSetSendOnBoard;
    }
    finally {}
  }
  
  protected void doPack()
  {
    this._sendData = this.data;
  }
  
  protected boolean isChanged(byte[] paramArrayOfByte)
  {
    return true;
  }
  
  public DataFlycSetSendOnBoard setSendData(byte[] paramArrayOfByte)
  {
    this.data = paramArrayOfByte;
    return this;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataFlycSetSendOnBoard.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */