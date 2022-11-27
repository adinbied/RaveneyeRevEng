package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataEyeDrawOperation
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataEyeDrawOperation instance;
  private OperateCmd mCmd = OperateCmd.START;
  private int mRepeatTime = 3;
  
  public static DataEyeDrawOperation getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataEyeDrawOperation();
      }
      DataEyeDrawOperation localDataEyeDrawOperation = instance;
      return localDataEyeDrawOperation;
    }
    finally {}
  }
  
  /* Error */
  protected void doPack()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public DataEyeDrawOperation setOperateCmd(OperateCmd paramOperateCmd)
  {
    this.mCmd = paramOperateCmd;
    return this;
  }
  
  public DataEyeDrawOperation setRepeatTime(int paramInt)
  {
    this.mRepeatTime = paramInt;
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
  
  public static enum OperateCmd
  {
    private final int data;
    
    static
    {
      PAUSE = new OperateCmd("PAUSE", 2, 2);
      RESUME = new OperateCmd("RESUME", 3, 3);
      PREPARE = new OperateCmd("PREPARE", 4, 4);
      UNPREPARE = new OperateCmd("UNPREPARE", 5, 5);
      OperateCmd localOperateCmd = new OperateCmd("OTHER", 6, 100);
      OTHER = localOperateCmd;
      $VALUES = new OperateCmd[] { START, STOP, PAUSE, RESUME, PREPARE, UNPREPARE, localOperateCmd };
    }
    
    private OperateCmd(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static OperateCmd find(int paramInt)
    {
      OperateCmd localOperateCmd1 = START;
      OperateCmd[] arrayOfOperateCmd = values();
      int j = arrayOfOperateCmd.length;
      int i = 0;
      while (i < j)
      {
        OperateCmd localOperateCmd2 = arrayOfOperateCmd[i];
        if (localOperateCmd2._equals(paramInt)) {
          return localOperateCmd2;
        }
        i += 1;
      }
      return localOperateCmd1;
    }
    
    public boolean _equals(int paramInt)
    {
      return this.data == paramInt;
    }
    
    public int value()
    {
      return this.data;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataEyeDrawOperation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */